package com.src.appnivelestres20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.src.appnivelestres20.ayuda.Ayuda_Fragment;
import com.src.appnivelestres20.contacto.TecnicasFragment;
import com.src.appnivelestres20.examenTest.ExamenEstress;
import com.src.appnivelestres20.examenTest.Result;
import com.src.appnivelestres20.login.Login;

public class MainActivity extends AppCompatActivity {

    private ImageView ivExamen,ivResultados, ivTecnicas, ivAyuda;

    private TextView textcsesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivAyuda = (ImageView)findViewById(R.id.ivAyuda);
        ivTecnicas =(ImageView)findViewById(R.id.idTecnicas);
        ivExamen =(ImageView)findViewById(R.id.ivResultados);
        ivResultados =(ImageView)findViewById(R.id.ivAyuda);
        textcsesion = (TextView)findViewById(R.id.tvcerrarsesion);

        textcsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                 */
                finishAffinity();

                //finish();
            }
        });

      //  Intent intentContacto = new Intent(this, TecnicasFragment.class);
        //startActivity(intentContacto);

    }

    public void ivAyudaMain(View v){
        Intent intentAyuda = new Intent(this, Ayuda_Fragment.class);
        startActivity(intentAyuda);

    }
    public void ivContacto(View v){
        Intent intentContacto = new Intent(this, TecnicasFragment.class);
        startActivity(intentContacto);
    }

    public void ivExamen(View v){
        Intent intentExamen = new Intent(this, ExamenEstress.class);
        startActivity(intentExamen);
    }

    public void ivResultados(View v){
        Intent intenResultado = new Intent(this, Result.class);
        startActivity(intenResultado);
    }


}