package com.drizzle.learnapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.drizzle.learnapplication.bean.MyJavabean;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private static final String URL = "https://api.androidhive.info/volley/person_object.json";
    @BindView(R.id.set_btn)
    Button setBtn;
    @BindView(R.id.get_bean)
    Button getBean;
    @BindView(R.id.to_frameLayout)
    Button toFrameLayout;
    @BindView(R.id.to_test_driver)
    Button toTestDriver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.set_btn, R.id.get_bean, R.id.to_frameLayout,R.id.to_test_driver})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.set_btn:
                Log.d("MainActivity", "registrationID=" + JPushInterface.getRegistrationID(getApplicationContext()));
                if (JPushInterface.getRegistrationID(getApplicationContext()) != null) {
                    JPushInterface.setAlias(getApplicationContext(), 2, "我是别名哦");
                }
                break;
            case R.id.get_bean:
                jsonGet();
                //这里用来测试 api调用
                break;
            case R.id.to_frameLayout:
                //这里用来练习，framelayout
                break;
            case R.id.to_test_driver:
                //驾照考试界面
                Intent intent=new Intent(this,SecondActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void jsonGet() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d("MainActivity", "error=" + e.toString());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String responseData = response.body().string();
                Gson gson = new Gson();
                MyJavabean myJavabean = gson.fromJson(responseData, MyJavabean.class);
                MyJavabean.Phone phone = myJavabean.getPhone();
                Log.d("MainActivity", "name=" + myJavabean.getName());
                Log.d("MainActivity", "email=" + myJavabean.getEmail());
                Log.d("MainActivity", "home=" + phone.getHome());
                Log.d("MainActivity", "mobile=" + phone.getMobile());
            }
        });
        //使用lambda表达式 替换 new Runnable()
//        new Thread(() -> {
//            OkHttpClient client=new OkHttpClient();
//            Request request =new Request.Builder()
//                    .url(URL)
//                    .build();
//            try {
//                Response response= client.newCall(request).execute();
//                String responseData =response.body().string();
//                Gson gson=new Gson();
//                MyJavabean myJavabean=gson.fromJson(responseData,MyJavabean.class);
//                MyJavabean.Phone phone=myJavabean.getPhone();
//                Log.d("MainActivity","name="+myJavabean.getName());
//                Log.d("MainActivity","email="+myJavabean.getEmail());
//                Log.d("MainActivity","home="+phone.getHome());
//                Log.d("MainActivity","mobile="+phone.getMobile());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }).start();
    }
}
