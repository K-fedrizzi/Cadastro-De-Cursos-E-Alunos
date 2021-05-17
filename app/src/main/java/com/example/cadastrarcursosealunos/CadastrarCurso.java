package com.example.cadastrarcursosealunos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CadastrarCurso extends AppCompatActivity {

    private EditText edtCadNomeCurso, edtCadHoras;
    private Button btnCadCadastrarCurso,btnCadVoltar;

    private TableCursoAlunoHelper cadCursoBD =new TableCursoAlunoHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_curso);

        // Fazendo a ligação dos componentes da activity
        edtCadNomeCurso = findViewById(R.id.edtCadNomeCurso);
        edtCadHoras = findViewById(R.id.edtCadHoras);
        btnCadCadastrarCurso = findViewById(R.id.btnCadCadastrarCurso);
        btnCadVoltar = findViewById(R.id.btnCadVoltar);
    }

    public void cadastrarCurso(View view) {
        // capturando os atributos de cada componente
        String nomeCurso = edtCadNomeCurso.getText()+"";
        String horas = edtCadHoras.getText()+"";

        //instanciando os dados no objeto Curso
        Curso curso = new Curso();
        curso.setNomeCurso(nomeCurso);
        curso.setQuantHoras(horas);

        // Cadastrando o curso no BD
        cadCursoBD.inserirCurso(curso);
        Log.d("myTag", "Curso Cadastrado!");

    }

    public void voltar(View view) {
        Intent it=new Intent(this,MenuActivity.class);
        startActivity(it);
    }
}