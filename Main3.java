package com.example.gagan.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3 extends AppCompatActivity {
 Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           Intent x=new Intent(Main3.this,Quiz.class);
           startActivity(x);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent x=new Intent(Intent.ACTION_VIEW);
                x.setData(Uri.parse("https://www.facebook.com/gagan.elluru"));
                startActivity(x);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mob="+917550167802";
                Intent x=new Intent(Intent.ACTION_DIAL,Uri.fromParts("tel",mob,null));
                startActivity(x);

            }
        });
    }
}
