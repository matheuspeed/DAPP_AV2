package com.example.av2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Cadastro extends AppCompatActivity {

    private Button botao_cadastrar;
    private EditText nome;
    private EditText ano;
    private EditText ra;
    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstances){
        DatabaseReference filmes = reference.child("filmes");
        super.onCreate(savedInstances);
        setContentView(R.layout.cadastro);
        nome = findViewById(R.id.edit_nome);
        ano = findViewById(R.id.edit_ano);
        ra = findViewById(R.id.edit_ra);
        botao_cadastrar = findViewById(R.id.button_cadastrar);
        botao_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nome.getText().toString().isEmpty() || ano.getText().toString().isEmpty() || ra.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Preencha todos os campos",Toast.LENGTH_SHORT).show();
                }else{
                    Filme filme = new Filme();
                    filme.setNome(nome.getText().toString());
                    filme.setAno(Integer.parseInt(ano.getText().toString()));
                    filme.setRa(ra.getText().toString());
                    filmes.push().setValue(filme);
                    Toast.makeText(getApplicationContext(),"Filme cadastrado",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
