package com.example.gagan.quizapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2 extends AppCompatActivity {
    Button b1,b2;
    TextView t1;
    EditText e1,e2,e3,e4;
    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dataBaseHelper=new DataBaseHelper(this);
        t1=(TextView)findViewById(R.id.t2);
        b1=(Button)findViewById(R.id.b1);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        e4=(EditText)findViewById(R.id.e4);
        b2=(Button)findViewById(R.id.b2);
        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x=new Intent(Main2.this,MainActivity.class);
                startActivity(x);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result=dataBaseHelper.insertData(e1.getText().toString(),e2.getText().toString(),e3.getText().toString(),e4.getText().toString());
                if(result){
                    Toast.makeText(Main2.this,"Data is inserted",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(Main2.this,"Data is not inserted",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
