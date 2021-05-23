package com.example.a180706037eventhander;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button red,green,blue;

    private TextView testText;

    private Button italic;
    private boolean isItalic = false,isBold =false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//设置界面布局文件
        testText = (TextView) findViewById(R.id.testText);//根据id找到控件
        red =(Button) findViewById(R.id.red);
        green =(Button) findViewById(R.id.green);
        blue =(Button) findViewById(R.id.blue);
        ColorListener myColorListener = new ColorListener();
        //注册监听器
        red.setOnClickListener(myColorListener);
        blue.setOnClickListener(myColorListener);
        green.setOnClickListener(myColorListener);

        //创建监听器对象
        SizeListener mysizeListener = new SizeListener(testText);
        //注册监听器
        red.setOnClickListener(mysizeListener);
        blue.setOnClickListener(mysizeListener);
        green.setOnClickListener(mysizeListener);
        //Activity类实现
        testText.setTypeface(Typeface.DEFAULT);  //设置字体样式
        italic = (Button) findViewById(R.id.italic); //获取控件

        italic.setOnClickListener(this);//注册监听器

        //匿名内部类
        testText.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("请输入新的内容呀");
                builder.setIcon(R.mipmap.ic_launcher);
                final EditText contenText = new EditText(MainActivity.this);
                builder.setView(contenText);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       testText.setText(contenText.getText().toString());
                    }
                });
                builder.setNegativeButton("取消",null);
                builder.create().show();
                return false;
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.italic:
                isItalic = !isItalic;
                break;

            case R.id.red:
                isItalic = !isItalic;
                break;
            default:break;
        }
        if(isItalic) {
            if(isBold){
            }else {
                testText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC);
                testText.setTypeface(Typeface.MONOSPACE,Typeface.ITALIC);
            }
        }else {
            if(isBold){
                testText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD);
            }else {
                testText.setTypeface(Typeface.MONOSPACE,Typeface.NORMAL);
            }
        }


    }

    //定义内部类实现单击
    private class  ColorListener implements View.OnClickListener {
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.red:
                    testText.setTextColor(Color.RED);
                    break;
                case R.id.blue:
                    testText.setTextColor(Color.BLUE);
                    break;
                case R.id.green:
                    testText.setTextColor(Color.GREEN);
                    break;
                default:break;  //默认什么都不做

            }
        }//内部类结束

    }//外部类结束


    //外部类
    public class SizeListener implements View.OnClickListener {
        private TextView tv;
        public SizeListener(TextView tv) {
            this.tv = tv;
        }
        public void onClick(View v) {
            float f =tv.getTextSize();  //获取当前字体的大小
            switch(v.getId()) {
                case R.id.blue:
                    f=f+2;
                    break;

                case R.id.green:
                    f=f-2;
                    break;
                default:break;
            }
            if(f<=8) {
                f = 8;
            }
            tv.setTextSize(TypedValue.COMPLEX_UNIT_PX,f); //设置字体大小
        }
    }


    //绑定到标签
    public void clickEventHandler(View view) {
        Toast.makeText(this,"绑定到标签的事件处理执行了！",Toast.LENGTH_SHORT).show();
    }
}