package com.src.pruebanavegaciones;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador_Tecnicas extends BaseAdapter {
    private Context context;
    private ArrayList<Entidad_Tecnicas> listItems;

    public Adaptador_Tecnicas(Context context, ArrayList<Entidad_Tecnicas> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public int getCount() {return listItems.size(); }

    @Override
    public Object getItem(int position) {return listItems.get(position);}

    @Override
    public long getItemId(int position) {return 0;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Entidad_Tecnicas Item = (Entidad_Tecnicas) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.item_tecnicas, null);
        ImageView imgFoto = (ImageView) convertView.findViewById(R.id.imgFoto);
        TextView tvTitulo = (TextView) convertView.findViewById(R.id.tvTitulo);
        TextView tvContent = (TextView) convertView.findViewById(R.id.tvContent);

        imgFoto.setImageResource(Item.getImgFoto());
        tvTitulo.setText(Item.getTitulo());
        tvContent.setText(Item.getContenido());

      /*  convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetalleItem.class);
                intent.putExtra("objetoData", Item);
                context.startActivity(intent);
            }
        });*/

        return convertView;
    }
}