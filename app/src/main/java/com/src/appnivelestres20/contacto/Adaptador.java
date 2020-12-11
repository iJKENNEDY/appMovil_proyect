package com.src.appnivelestres20.contacto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.src.appnivelestres20.R;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    private Context context;
    private ArrayList<Entidad> listItems;

    public Adaptador(Context context, ArrayList<Entidad> listItems) {
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
        final Entidad Item = (Entidad) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.tecnica_item, null);
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
