package com.example.datasave1;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private EditText readText,writeText;
    private String fileName="content.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //根据id找到控件
        readText=(EditText) findViewById(R.id.readText);
        writeText=(EditText)findViewById(R.id.writeText);

    }
    public void write(View view) {
        try {
            FileOutputStream fos = openFileOutput(fileName, Context.MODE_APPEND);
            fos.write(writeText.getText().toString().getBytes());//写入内容
            writeText.setText("");
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void read(View view) {
        try {
            FileInputStream fis = openFileInput(fileName);
            StringBuffer sBuffer =new StringBuffer("");
            byte[] buffer = new byte[256];//定义缓存数组
            int hasRead = 0;
            while((hasRead = fis.read(buffer)) != -1){
                sBuffer.append(new String(buffer,0,hasRead));

            }
            readText.setText(sBuffer.toString());
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}