package com.example.cadastrarcursosealunos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class CadastrarAluno extends AppCompatActivity {
    private EditText edtCadNomeAluno, edtCadCPFAluno,
            edtCadEmailAluno, edtCadTelefoneAluno;
    private Spinner spinnCadCursoAluno;
    private Button btnCadCadastrarAluno;
    private Button btnCadVoltarAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_aluno);

        // Fazendo a ligação dos componentes da activity
        edtCadNomeAluno = findViewById(R.id.edtCadNomeAluno);
        edtCadCPFAluno = findViewById(R.id.edtCadCPFAluno);
        edtCadEmailAluno = findViewById(R.id.edtCadEmailAluno);
        edtCadTelefoneAluno = findViewById(R.id.edtCadTelefoneAluno);

        spinnCadCursoAluno = findViewById(R.id.spinnCadCursoAluno);

        btnCadCadastrarAluno = findViewById(R.id.btnCadCadastrarAluno);
        btnCadVoltarAluno = findViewById(R.id.btnCadVoltarAluno);

        // Testando o Spinner
        final List<String> cursos = new ArrayList<String>();
        cursos.add("Curso 1");
        cursos.add("Curso 2");
        cursos.add("Curso 3");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,cursos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnCadCursoAluno.setAdapter(adapter);
    }

    public void cadastrarAluno(View view) {
        // capturando os atributos de cada componente
        String nome  = edtCadNomeAluno.getText()+"";
        String cpf   = edtCadCPFAluno.getText()+"";
        String email = edtCadEmailAluno.getText()+"";
        String tetefone = edtCadTelefoneAluno.getText()+"";


        //int curso = spinnCadCursoAluno.getSelectedItemPosition();

    }

    public void voltar(View view) {
        Intent it=new Intent(this,MenuActivity.class);
        startActivity(it);
    }
}