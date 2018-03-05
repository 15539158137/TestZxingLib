package com.dxxx.testzxinglib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.android.CaptureActivityHandler;
import com.google.zxing.client.android.ViewfinderView;
import com.google.zxing.client.android.camera.CameraManager;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
boolean hasSurface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this,CaptureActivity.class),1);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       if(requestCode==1&&resultCode==100){
           if(data==null){
               Log.e("data是个空","==");
           }
           String data1=data.getStringExtra("num");
           if(data1.equals("")||data1==null){
               Toast.makeText(MainActivity.this,"扫描异常，请重试",Toast.LENGTH_SHORT).show();
           }else {

               Toast.makeText(MainActivity.this,data1,Toast.LENGTH_SHORT).show();
           }

       }

    }
}
