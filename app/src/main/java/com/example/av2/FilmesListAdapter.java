package com.example.av2;

import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class FilmesListAdapter extends ArrayAdapter<Filme> {
    private Context mcontext;
    private int mresource;
    private int lastPosition = -1;

    private static class ViewHolder {
        TextView nome;
        TextView ra;
        TextView ano;
    }

    public FilmesListAdapter(Context context, int resource, ArrayList<Filme> objects) {
        super(context, resource, objects);
        mcontext = context;
        mresource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String nome = getItem(position).getNome();
        String ra = getItem(position).getRa();
        int ano = getItem(position).getAno();

        Filme filme = new Filme(nome, ano, ra);

        final View result;
        ViewHolder holder;

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mcontext);
            convertView = inflater.inflate(mresource, parent, false);

            holder = new ViewHolder();
            holder.nome = convertView.findViewById(R.id.textView1);
            holder.ra = convertView.findViewById(R.id.textView2);
            holder.ano = convertView.findViewById(R.id.textView3);

            result = convertView;
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }




        Animation animation = AnimationUtils.loadAnimation(mcontext, (position > lastPosition)? R.anim.load_down_anim : R.anim.load_up_anim);
        result.startAnimation(animation);
        lastPosition = position;

        holder.nome.setText(nome);
        holder.ano.setText(String.valueOf(ano));
        holder.ra.setText(ra);



        return convertView;
    }
}
