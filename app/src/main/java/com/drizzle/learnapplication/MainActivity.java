package com.drizzle.learnapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;

public class MainActivity extends AppCompatActivity{

    @BindView(R.id.set_btn)
    Button setBtn;
    @BindView(R.id.get_bean)
    Button getBean;
    @BindView(R.id.to_frameLayout)
    Button toFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.set_btn, R.id.get_bean, R.id.to_frameLayout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.set_btn:
                Log.d("MainActivity","hahahhahah");
                if (JPushInterface.getRegistrationID(getApplicationContext())!=null){
                    JPushInterface.setAlias(getApplicationContext(),2,"我是别名哦");
                }
                break;
            case R.id.get_bean:
                //这里用来测试 api调用
                break;
            case R.id.to_frameLayout:
                //这里用来练习，framelayout
                break;
        }
    }
}
