package com.example.cadastrarcursosealunos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CadastrarCurso extends AppCompatActivity {
    private EditText edtCadNomeCurso, edtCadHoras;
    private Button btnCadCadastrarCurso,btnCadVoltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_curso);
        edtCadNomeCurso = findViewById(R.id.edtCadNomeCurso);
        edtCadHoras = findViewById(R.id.edtCadHoras);
        btnCadCadastrarCurso = findViewById(R.id.btnCadCadastrarCurso);
        btnCadVoltar = findViewById(R.id.btnCadVoltar);
    }

    public void cadastrarCurso(View view) {
    }

    public void voltar(View view) {
        Intent it=new Intent(this,MenuActivity.class);
        startActivity(it);
    }
}