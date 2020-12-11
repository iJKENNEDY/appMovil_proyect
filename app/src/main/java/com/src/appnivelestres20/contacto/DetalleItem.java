package com.src.appnivelestres20.contacto;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.src.appnivelestres20.R;

public class DetalleItem extends AppCompatActivity {
    private Entidad Item;
    private TextView tvTitulo, descripcion;
    private ImageView imgFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tecnica_detalle_item);

        Item = (Entidad) getIntent().getSerializableExtra("objetoData");

        tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        descripcion = (TextView) findViewById(R.id.descripcion);
        imgFoto = (ImageView) findViewById(R.id.imgFoto);

        tvTitulo.setText(Item.getTitulo());
        imgFoto.setImageResource(Item.getImgFoto());
        descripcion.setText(Item.getContenido());

    }
}
