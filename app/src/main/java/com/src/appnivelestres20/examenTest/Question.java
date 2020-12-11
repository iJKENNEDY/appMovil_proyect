package com.src.appnivelestres20.examenTest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.src.appnivelestres20.R;

public class Question extends AppCompatActivity {

    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "¿Con qué frecuencia le estresa la sobrecarga de tareas y trabajos escolares que tiene que realizar todos los días? ",
            "¿Con qué frecuencia le estresa la personalidad y el carácter de los-as profesores/as que le imparten clases?",
            "¿Con qué frecuencia le estresa la forma de evaluación de sus profesores-as (a través de ensayos, trabajos de investigación, búsquedas en internet, etc.)",
            "¿Con qué frecuencia le estresa el nivel de exigencia de sus profesores?",
            "¿Con qué frecuencia le estresa el tipo de trabajo que le piden los profesores (consulta de temas, fichas de trabajo, ensayos, mapas conceptuales, etc.)",
            "¿Con qué frecuencia le estresa tener tiempo limitado para hacer el trabajo que le encargan los-as profesores-as?",
            "¿Con qué frecuencia le estresa la poca claridad que tiene sobre lo que quieren los-as profesores-as?",
            "¿Con qué frecuencia se presenta la fatiga crónica (cansancio permanente) cuando está estresado? ",
            "¿Con qué frecuencia se presentan los sentimientos de depresión y tristeza (decaído) cuando estás estresado?",
            "¿Con qué frecuencia se presenta la ansiedad, angustia o desesperación cuando estás estresado?",
            "¿Con qué frecuencia se presentan los problemas de concentración cuando estás estresado? ",
            "¿Con qué frecuencia se presentan los sentimiento de agresividad o aumento de irritabilidad cuando estás estresado?",
            "¿Con qué frecuencia se presentan los conflictos o tendencia a polemizar o discutir cuando estás estresado?",
            "¿Con qué frecuencia se presenta el desgano para realizar las labores escolares cuando estás estresado? ",
            "¿Con qué frecuencia utilizas la concentración para resolver alguna situación que te preocupa y así enfrentar tu estrés? ",
            "¿Con qué frecuencia analizas lo positivo y negativo para solucionar la situación que te preocupa?",
            "¿Con qué frecuencia mantienes el control sobre tus emociones para que no te afecte lo que te estresa?",
            "¿Con qué frecuencia recuerdas situaciones similares ocurridas anteriormente y piensas en cómo las solucionaste para enfrentar situaciones estresantes?",
            "¿Con qué frecuencia elaboras un plan para enfrentar lo que te estresa y ejecutar tus tareas?",
            "¿Con qué frecuencia te fijas o tratas de obtener lo positivo de la situación que te preocupa para enfrentar tu estrés?"
    };
    String answers[] = {"nunca","casi nunca","casi siempre","siempre"};
    String opt[] = {
            "nunca","casi nunca","casi siempre","siempre",
            "nunca","casi nunca","casi siempre","siempre",
            "nunca","casi nunca","casi siempre","siempre",
            "nunca","casi nunca","casi siempre","siempre",
            "nunca","casi nunca","casi siempre","siempre",
            "nunca","casi nunca","casi siempre","siempre",
            "nunca","casi nunca","casi siempre","siempre",
            "nunca","casi nunca","casi siempre","siempre",
            "nunca","casi nunca","casi siempre","siempre",
            "nunca","casi nunca","casi siempre","siempre",
            "nunca","casi nunca","casi siempre","siempre",
            "nunca","casi nunca","casi siempre","siempre",
            "nunca","casi nunca","casi siempre","siempre",
            "nunca","casi nunca","casi siempre","siempre",
            "nunca","casi nunca","casi siempre","siempre",
            "nunca","casi nunca","casi siempre","siempre",
            "nunca","casi nunca","casi siempre","siempre",
            "nunca","casi nunca","casi siempre","siempre",
            "nunca","casi nunca","casi siempre","siempre",
            "nunca","casi nunca","casi siempre","siempre"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    public static int contNunca=0,
            contCasiNunca=0,
            contcasiSiempre=0,
            contSiempre=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("");
        else
            textView.setText("Hola " + name);

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "seleccione una de las opciones", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[0])) {
                    contNunca++;
                    //correct++;
                   // Toast.makeText(getApplicationContext(), "contNunca", Toast.LENGTH_SHORT).show();
                }
                if (ansText.equals(answers[1])){
                     contCasiNunca++;
                }
                if (ansText.equals(answers[2])){
                    contcasiSiempre++;
                }
                if (ansText.equals(answers[3])){
                    contSiempre++;
                }

                flag++;

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),Result.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Result.class);
                startActivity(intent);
            }
        });
    }
}