package com.example.cadastrarcursosealunos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    private Button btnMenuCadastrarCurso,btnMenuCadastrarAluno,
            btnMenuListarAlunos,btnMenuAlterarDadosCurso,btnMenuAlterarDadosAluno;

    TableCursoAlunoHelper bd = new TableCursoAlunoHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_main);

        // Fazendo a ligação dos componentes da activity
        btnMenuCadastrarCurso = findViewById(R.id.btnMenuCadastrarCurso);
        btnMenuCadastrarAluno = findViewById(R.id.btnMenuCadastrarAluno);
        btnMenuListarAlunos = findViewById(R.id.btnMenuListarAlunos);
        btnMenuAlterarDadosCurso = findViewById(R.id.btnMenuAlterarDadosCurso);
        btnMenuAlterarDadosAluno = findViewById(R.id.btnMenuAlterarDadosAluno);

        // Testando o CRUD
        Aluno a = new Aluno();

        a.setNomeAluno("Karina");
        a.setNomeCurso("Corte e Costura");
        a.setCpf("071056838");
        a.setEmail("curso@email.com");
        a.setTelefone("DDD111111");

        bd.inserirAluno(a,a.getNomeCurso());
        bd.close();


    }

    public void cadastrarCurso(View view) {
        Intent it=new Intent(this,CadastrarCurso.class);
        startActivity(it);
    }

    public void cadastrarAluno(View view) {
        Intent it=new Intent(this,CadastrarAluno.class);
        startActivity(it);
    }

    public void listarAlunos(View view) {
        Intent it=new Intent(this,ListarAlunos.class);
        startActivity(it);
    }

    public void alterarDadosCurso(View view) {
        Intent it=new Intent(this,AlterarDadosCurso.class);
        startActivity(it);
    }

    public void alterarDadosAluno(View view) {
        Intent it=new Intent(this,AlterarDadosAluno.class);
        startActivity(it);

    }
}