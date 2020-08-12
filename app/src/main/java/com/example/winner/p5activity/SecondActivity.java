package com.example.winner.p5activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        //拿到intent对象
        Intent intent = getIntent();
        //获取到密码和账号
        String account = intent.getStringExtra("account");
        String password = intent.getStringExtra("password");

        TextView info = this.findViewById(R.id.info);
        info.setText("账号是: " + account + "密码是:" + password);
    }
}
