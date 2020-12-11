package com.src.appnivelestres20.contacto;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.src.appnivelestres20.R;

import java.util.ArrayList;


public class TecnicasFragment extends AppCompatActivity {
    private ListView ListViewTecnicas;
    private Adaptador adaptador;
    private ArrayList<Entidad> arrayentidad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tecnicas);

        ListViewTecnicas = (ListView) findViewById(R.id.ListViewTecnicas);
        arrayentidad = GetArrayItems();
        adaptador = new Adaptador(this,arrayentidad);
        ListViewTecnicas.setAdapter(adaptador);

        ListViewTecnicas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TecnicasFragment.this, DetalleItem.class);
                intent.putExtra("objetoData", arrayentidad.get(position));
                startActivity(intent);
            }
        });
    }
    private ArrayList<Entidad> GetArrayItems() {
        ArrayList<Entidad> listItems=new ArrayList<>();
        listItems.add(new Entidad(R.drawable.dbs_1,"Cuídate alimentándote bien","Cuando están deprimidas, a algunas personas no les apetece nada comer, pero hay otras pueden comer demasiado. Si la depresión ha afectado a tus hábitos alimentarios, tendrás que tener muy presente la necesidad de alimentarte bien. La nutrición puede influir en el estado de ánimo y el nivel de energía de una persona."));
        listItems.add(new Entidad(R.drawable.dbs_2,"Analiza tus pensamientos\n","Muy especialmente analiza tus pensamientos negativos, pues es una manera efectiva de mejorar los sesgos cognitivos, algo fundamental para superar la depresión. Para ello escribe a mano esos pensamientos que te asedian con frecuencia  y hazte las siguientes preguntas:\n" +
                "\n" +
                "¿Estoy seguro de esto? ¿Tengo pruebas?\n" +
                "¿Hay otra posible explicación?\n" +
                "Si fuera cierto ¿Sería tan grave?\n" +
                "¿Qué consecuencias tendrá?\n" +
                "¿Lo han superado otras personas?\n" +
                "¿Darle vueltas lo soluciona?\n" +
                "¿Qué opciones tengo para solventarlo?"));
        listItems.add(new Entidad(R.drawable.dbs_3,"Escribe un diario","Dedica al menos 5 minutos al día a pensar y escribir con detalle sobre 3 hechos, o más, que puedas agradecer. No tienen que ser grandes acontecimientos, incluso lo más simple nos puede ayudar, veamos varios ejemplos:\n" +
                "\n" +
                "“Qué agradable es la tendera que me dijo….”; “Qué rico me supo el plátano, estaba tan dulce y suave”; “Qué bien que hoy cuando llamé a mamá pudimos hablar un buen rato”, etc.\n" +
                "\n" +
                "Se ha constado que escribir un diario de gratitud mejora significativamente nuestra atención hacia los acontecimientos positivos, lo que resulta muy útil en depresión."));
        listItems.add(new Entidad(R.drawable.dbs_4,"Lado positivo","La depresión repercute sobre los pensamientos de las personas, haciendo que todo parezca negro, desastroso, triste y negativo. Si la depresión te está haciendo fijarte solo en lo negativo, haz un esfuerzo para fijarte en las cosas buenas de la vida. Primero intenta identificar una cosa positiva, luego intenta buscar otra más. Considera tus puntos fuertes, tus dones y lo afortunado que eres. Y, sobre todo, no te olvides de tener paciencia contigo mismo. La depresión requiere tiempo para curarse."));
        return listItems;
    }
}