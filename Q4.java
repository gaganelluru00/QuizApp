package com.example.gagan.quizapp;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Q4 extends AppCompatActivity {
    TextView t1;
    Button b1;
    RadioButton r1,r2,r3,r4;
    RadioGroup rg1;
   int q1;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q4);
        final Bundle a1=getIntent().getExtras();



        t1=(TextView)findViewById(R.id.t2);
        b1=(Button)findViewById(R.id.b1);
        rg1=(RadioGroup)findViewById(R.id.rg1);
        r1=(RadioButton)findViewById(R.id.r1);
        r2=(RadioButton)findViewById(R.id.r2);
        r3=(RadioButton)findViewById(R.id.r3);
        r4=(RadioButton)findViewById(R.id.r4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int y=rg1.getCheckedRadioButtonId();
                r1=(RadioButton)findViewById(y);
                q1=a1.getInt("SCORE1");



                if(y==-1){
                    Toast.makeText(Q4.this,"Please Select",Toast.LENGTH_LONG).show();
                }
                else {
                    if(r1.getText().toString().equals("8")){
                      q1=q1+2;
                        Intent x=new Intent(Q4.this,Quiz.class);
                            Toast.makeText(Q4.this,"Score is "+q1,Toast.LENGTH_LONG).show();

                        startActivity(x);
                    }
                    else{
                        q1=a1.getInt("SCORE1");
                        showAlertDialog();
                    }
                }
            }
        });
    }
    public void showAlertDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Alert");
        builder.setMessage("Do you want to continue?");
        builder.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Intent x=new Intent(Q4.this,Q4.class);

               Toast.makeText(Q4.this,"Score is "+q1,Toast.LENGTH_LONG).show();
                startActivity(x);
            }
        });
        builder.setNegativeButton("Quit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Intent x=new Intent(Q4.this,Quiz.class);
                Toast.makeText(Q4.this,"Score is "+q1,Toast.LENGTH_LONG).show();

                startActivity(x);
            }
        });
        builder.setNeutralButton("Skip", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Intent x=new Intent(Q4.this,Quiz.class);
                final Bundle a1=getIntent().getExtras();
                q1=a1.getInt("SCORE1");
                Toast.makeText(Q4.this,"Score is "+q1,Toast.LENGTH_LONG).show();
                startActivity(x);
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();


    }
}

