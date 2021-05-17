package com.example.cadastrarcursosealunos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AlterarDadosAluno extends AppCompatActivity {
    private EditText edtAlterCPFAluno,edtAlterNomeAluno,edtAlterEmailAluno, edtAlterTelefoneAluno;
    private Button btnAlterAlterarDadosAluno, btnAlterExcluirDadosAluno,btnAlterVoltarAluno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_dados_aluno);

        // Fazendo a ligação dos componentes da activity
        edtAlterCPFAluno = findViewById(R.id.edtAlterCPFAluno);
        edtAlterNomeAluno = findViewById(R.id.edtAlterNomeAluno);
        edtAlterEmailAluno = findViewById(R.id.edtAlterEmailAluno);
        edtAlterTelefoneAluno =findViewById(R.id.edtAlterTelefoneAluno);

        btnAlterAlterarDadosAluno = findViewById(R.id.btnAlterAlterarDadosAluno);
        btnAlterExcluirDadosAluno = findViewById(R.id.btnAlterExcluirDadosAluno);
        btnAlterVoltarAluno = findViewById(R.id.btnAlterVoltarAluno);

        // capturando os atributos de cada componente
        String nome  = edtAlterNomeAluno.getText()+"";
        String cpf   = edtAlterCPFAluno.getText()+"";
        String email = edtAlterEmailAluno.getText()+"";
        String tetefone = edtAlterTelefoneAluno.getText()+"";
    }

    public void alterarDados(View view) {
    }

    public void excluirDados(View view) {
    }

    public void voltar(View view) {
        Intent it=new Intent(this,MenuActivity.class);
        startActivity(it);
    }
}