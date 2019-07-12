package com.example.gagan.quizapp;




import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    Button b1,b2;
    DataBaseHelper dataBaseHelper;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataBaseHelper = new DataBaseHelper(this);

        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = dataBaseHelper.getData(e1.getText().toString(), e2.getText().toString());
                while (cursor.moveToNext()) {
                    if (e1.getText().toString().equals(cursor.getString(1)) && e2.getText().toString().equals(cursor.getString(2))) {
                        flag = 1;
                    }
                }

                if (flag==0)
                {
                    Toast.makeText(MainActivity.this, "Incorrect Details", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent y = new Intent(MainActivity.this, Main3.class);
                    startActivity(y);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent z=new Intent(MainActivity.this,Main2.class);
                startActivity(z);
            }
        });

    }
}
