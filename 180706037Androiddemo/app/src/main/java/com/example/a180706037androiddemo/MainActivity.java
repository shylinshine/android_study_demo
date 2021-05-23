package com.example.a180706037androiddemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void exit(View view) {
        AlertDialog.Builder exitBuilder = new AlertDialog.Builder(this); //创建Builde对象
        exitBuilder.setTitle("退出提示");
        exitBuilder.setMessage("你要退出当前页面吗");
        exitBuilder.setPositiveButton("确定",null);
        exitBuilder.setNegativeButton("取消",null);
        exitBuilder.create().show();
    }


    public void singleChoice(View view) {
        String[] items = new String[]{"在线","隐身","隐身","隐身"};
        AlertDialog.Builder singleBuilder = new AlertDialog.Builder(this);
        singleBuilder.setTitle("请选择你的状态");
        singleBuilder.setSingleChoiceItems(items,1,null);
        singleBuilder.setPositiveButton("确定",null);
        singleBuilder.setNegativeButton("取消",null);
        singleBuilder.create().show();
    }


}
