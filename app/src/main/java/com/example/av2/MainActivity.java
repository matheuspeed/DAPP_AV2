package com.example.av2;

import com.example.av2.Filme;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listFilmes;
    private Button btCadastro;
    private ArrayList<Filme> listaFilmes;
    private Context mContext;
    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mContext = this;
        DatabaseReference filmes = reference.child("filmes");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listFilmes =  findViewById(R.id.listFilmes);
        btCadastro = findViewById(R.id.btCadastrar);
        btCadastro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), Cadastro.class);
                startActivity(intent);
            }
        });
        ArrayList<Filme> listaFilmes = new ArrayList<>();
        filmes.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listaFilmes.clear();
                for(DataSnapshot child : snapshot.getChildren()){
                    Filme filme = child.getValue(Filme.class);
                    listaFilmes.add(filme);
                    FilmesListAdapter adapter = new FilmesListAdapter(mContext, R.layout.adapterfilmes, listaFilmes);
                    listFilmes.setAdapter(adapter);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        FilmesListAdapter adapter = new FilmesListAdapter(this, R.layout.adapterfilmes, listaFilmes);
        listFilmes.setAdapter(adapter);


    }





}