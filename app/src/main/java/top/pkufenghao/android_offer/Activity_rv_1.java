package top.pkufenghao.android_offer;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Activity_rv_1 extends Activity implements View.OnClickListener{
    public TextView title;

    public TextView content;
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_layout_1);
        //禁止横屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        new ReadHttpGet().execute("http://139.199.127.163/news/5");


        initViews();
    }


    private void initViews(){
        title=(TextView)findViewById(R.id.activity_fx_title);
        content=(TextView)findViewById(R.id.activity_fx_content);
        back=(ImageView)findViewById(R.id.activity_fx_back);
        back.setOnClickListener(this);
    }

    class ReadHttpGet extends AsyncTask<Object, Object, Object>

    {



        @Override

        protected Object doInBackground(Object... params) {

            // TODO Auto-generated method stub



            HttpGet httpRequest = new HttpGet(params[0].toString());

            try

            {

                HttpClient httpClient = new DefaultHttpClient();

                HttpResponse httpResponse = httpClient.execute(httpRequest);



                if(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK)

                {

                    String strResult = EntityUtils.toString(httpResponse.getEntity());

                    return strResult;

                }

                else

                {

                    return "请求出错";

                }

            }

            catch(ClientProtocolException e)

            {



            }

            catch (IOException e) {

                // TODO Auto-generated catch block

                e.printStackTrace();

            }



            return null;

        }



        @Override

        protected void onCancelled(Object result) {

            // TODO Auto-generated method stub

            super.onCancelled(result);

        }



        @Override

        protected void onPostExecute(Object result) {

            // TODO Auto-generated method stub

            super.onPostExecute(result);



            try

            {

                //创建一个JSON对象

                JSONObject jsonObject = new JSONObject(result.toString());

                //获取某个对象的JSON数组

                JSONArray jsonArray = jsonObject.getJSONArray("data");
                JSONObject inf_Array = jsonArray.getJSONObject(0);
                StringBuilder builder = new StringBuilder();
                builder.append(inf_Array.getString("id")); //获取数据


                builder.append(inf_Array.getString("title"));
                title.setText(inf_Array.getString("title"));
                builder.append(inf_Array.getString("content"));

                content.setText(inf_Array.getString("content"));

                // StringBuilder builder = new StringBuilder();


                Log.d("news",builder.toString());

               // content.setText(inf_Array.getString("id"));

            }

            catch (JSONException e) {

                // TODO Auto-generated catch block

                e.printStackTrace();

            }



        }



        @Override

        protected void onPreExecute() {

            // TODO Auto-generated method stub

            //super.onPreExecute();

            Toast.makeText(getApplicationContext(), "开始HTTP GET请求", Toast.LENGTH_LONG).show();

        }



        @Override

        protected void onProgressUpdate(Object... values) {

            // TODO Auto-generated method stub

            super.onProgressUpdate(values);

        }



    }

    @Override
    public void onClick(View view) {//按钮监听事件

        switch (view.getId()) {
            case R.id.activity_fx_back:
                Intent i = new Intent(this, Activity_rv.class);
                startActivityForResult(i, 1);
                break;

            default:
                break;
        }
    }
}
