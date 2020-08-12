package com.example.winner.p5activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mLogin;
    private EditText mPassword;
    private EditText mAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();

        initListener();

    }

    private void initListener() {
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击登录按钮  跳转到新的界面 显示账号和密码
                handlerLogin();
            }
        });
    }

    private void handlerLogin() {
        String accountText = mAccount.getText().toString().trim();
        if (accountText.isEmpty()) {
            Toast.makeText(this,"输入的账号为空",Toast.LENGTH_SHORT).show();
            return;
        }
        String passwordText = mPassword.getText().toString().trim();
        if (passwordText.isEmpty()) {
            Toast.makeText(this,"输入的密码为空",Toast.LENGTH_SHORT).show();
            return;
        }
        //有密码和账号 点击登录之后跳转到第二个界面并把数据带过去
        //先创建一个Intent对象，然后通过startActivity进行跳转
        //通过字节码文件进行跳转
        //显式意图跳转
        /*Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("account",accountText);
        intent.putExtra("password",passwordText);
        startActivity(intent);*/
        //隐式意图
        /**
         * 步骤  创建Intent对象
         *       在Manifest中 配置意图过滤器
         */
        Intent intent = new Intent();
        intent.setAction("android.intent.action.LOGININFO");
//        intent.addCategory("android.intent.category.DEFAULT");
        //CATEGORY_DEFAULT  为常量 推荐第二种
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.putExtra("account",accountText);
        intent.putExtra("password",passwordText);
        startActivity(intent);
    }

    private void initView() {
        mAccount = this.findViewById(R.id.account);
        mPassword = this.findViewById(R.id.password);
        mLogin = this.findViewById(R.id.login);
    }
}
