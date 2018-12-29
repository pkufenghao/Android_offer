package top.pkufenghao.android_offer;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_rv extends Activity implements View.OnClickListener{

    private ImageView back;

    private TextView activity_news1,activity_news2,activity_news3,activity_news4,activity_news5,activity_news6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_layout);
        //禁止横屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        initViews();
    }

    private void initViews(){
        back=(ImageView)findViewById(R.id.activity_back);
        back.setOnClickListener(this);

        activity_news1=(TextView)findViewById(R.id.activity_news1);
        activity_news1.setOnClickListener(this);

        activity_news2=(TextView)findViewById(R.id.activity_news2);
        activity_news2.setOnClickListener(this);

        activity_news3=(TextView)findViewById(R.id.activity_news3);
        activity_news3.setOnClickListener(this);

        activity_news4=(TextView)findViewById(R.id.activity_news4);
        activity_news4.setOnClickListener(this);


        activity_news6=(TextView)findViewById(R.id.activity_news6);
        activity_news6.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {//按钮监听事件

        switch (view.getId()) {
            case R.id.activity_back:
                Intent i = new Intent(this, MainActivity.class);
                startActivityForResult(i, 1);
                break;
            case R.id.activity_news1:
                Intent i1 = new Intent(this, Activity_rv_1.class);
                startActivityForResult(i1, 1);
                break;
            case R.id.activity_news2:
                Uri uri2 = Uri.parse("https://blog.csdn.net/Liu_yunzhao/article/details/78255461");
                Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                startActivity(intent2);
                break;
            case R.id.activity_news3:
                Uri uri3 = Uri.parse("https://blog.csdn.net/Liu_yunzhao/article/details/78255461");
                Intent intent3 = new Intent(Intent.ACTION_VIEW, uri3);
                startActivity(intent3);
                break;
            case R.id.activity_news4:
                Uri uri4 = Uri.parse("https://blog.csdn.net/Liu_yunzhao/article/details/78255461");
                Intent intent4 = new Intent(Intent.ACTION_VIEW, uri4);
                startActivity(intent4);
                break;

            case R.id.activity_news6:
                Uri uri6 = Uri.parse("https://blog.csdn.net/Liu_yunzhao/article/details/78255461");
                Intent intent6 = new Intent(Intent.ACTION_VIEW, uri6);
                startActivity(intent6);
                break;
            default:
                break;
        }
    }
}
