package com.src.pruebanavegaciones;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetalleItem_Tecnicas extends AppCompatActivity {
    private Entidad_Tecnicas Item;
    private TextView tvTitulo, descripcion;
    private ImageView imgFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_item);

        Item = (Entidad_Tecnicas) getIntent().getSerializableExtra("objetoData");

        tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        descripcion = (TextView) findViewById(R.id.descripcion);
        imgFoto = (ImageView) findViewById(R.id.imgFoto);

        tvTitulo.setText(Item.getTitulo());
        imgFoto.setImageResource(Item.getImgFoto());
        descripcion.setText(Item.getContenido());

    }
}