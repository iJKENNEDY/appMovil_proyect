package com.src.appnivelestres20.ayuda;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.src.appnivelestres20.R;

import java.util.ArrayList;
import java.util.List;


public class Ayuda_Fragment extends AppCompatActivity {


    ListView ListViewContacto;
    List<Contacto> lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_ayuda_);
        ListViewContacto=findViewById(R.id.ListViewContacto);
        CustomAdapter adapter=new CustomAdapter(this, GetData());
        ListViewContacto.setAdapter(adapter);
        ListViewContacto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Contacto c=lst.get(i);
                Toast.makeText(getBaseContext(),c.nombre,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<Contacto> GetData() {
        lst=new ArrayList<>();
        lst.add(new Contacto(1,R.drawable.user_h,"Jhersson","992944987"));
        lst.add(new Contacto(2,R.drawable.user_m,"Sol","925587412"));
        lst.add(new Contacto(3,R.drawable.user_h,"Gustavo","920882938"));
        lst.add(new Contacto(5,R.drawable.user_m,"Lizbeth","921203244"));
        lst.add(new Contacto(7,R.drawable.user_h,"Angelo","992482729"));

        return lst;
    }
}