package com.src.appnivelestres20.examenTest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.src.appnivelestres20.MainActivity;
import com.src.appnivelestres20.R;

public class Result extends AppCompatActivity {

    TextView tv, tv2, tv3, tv4;
    Button btnRestart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

       // tv = (TextView)findViewById(R.id.tvres);
        //tv2 = (TextView)findViewById(R.id.tvres2);
        //tv3 = (TextView)findViewById(R.id.tvres3);

        tv4 = (TextView)findViewById(R.id.tvres4);
        btnRestart = (Button) findViewById(R.id.btnRestart);

        StringBuffer sb = new StringBuffer();
        sb.append("N: " + Question.contNunca + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("CN: " + Question.contCasiNunca + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("SC: " + Question.contcasiSiempre + "\n");
        StringBuffer sb4 = new StringBuffer();
        sb4.append("S: " + Question.contSiempre + "\n");
/*
        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);
        //tv4.setText(sb4);
     */
        int promedio = 0;
        int n1 = Question.contCasiNunca;
        int n2 = Question.contcasiSiempre;
        int n3 = Question.contSiempre;
        int n4 = Question.contNunca;

        int total = n2+n1+n3+n4/2;
        String ttstring = String.valueOf(total);
        //tv4.setText(ttstring);

        int resultado[] = {n1,n2,n3,n4};
        int maximResult = resultado[0];

        for (int i=0; i<resultado.length; i++){
            maximResult = Math.max(maximResult, resultado[i]);

        }
        String comvResult = String.valueOf(maximResult);
        tv4.setText(comvResult);


        Question.correct=0;
        Question.wrong=0;

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in);
            }
        });
    }
}