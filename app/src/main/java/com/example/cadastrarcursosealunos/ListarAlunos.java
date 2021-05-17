package com.example.cadastrarcursosealunos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ListarAlunos extends AppCompatActivity {
    private ListView lstAlunos;

    private TableCursoAlunoHelper listaAlunosBD =new TableCursoAlunoHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_alunos);
        lstAlunos = findViewById(R.id.lstAlunos);

        List<String> alunos;
        alunos = listaAlunosBD.buscarAlunos();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,alunos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        lstAlunos.setAdapter(adapter);

    }

    public void voltar(View view) {
        Intent it=new Intent(this,MenuActivity.class);
        startActivity(it);
    }
}