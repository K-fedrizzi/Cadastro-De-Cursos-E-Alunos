package com.example.cadastrarcursosealunos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AlterarDadosAluno extends AppCompatActivity {
    private EditText edtAlterCPFAluno,edtAlterNomeAluno,edtAlterEmailAluno, edtAlterTelefoneAluno;
    private Button btnAlterAlterarDadosAluno, btnAlterExcluirDadosAluno,btnAlterVoltarAluno;

    private TableCursoAlunoHelper alterDateAluno =new TableCursoAlunoHelper(this);

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

    }

    public void alterarDados(View view) {

        // capturando os atributos de cada componente
        String nome  = edtAlterNomeAluno.getText()+"";
        String cpf   = edtAlterCPFAluno.getText()+"";
        String email = edtAlterEmailAluno.getText()+"";
        String telefone = edtAlterTelefoneAluno.getText()+"";

        if(alterDateAluno.buscarCPFaluno(cpf) == true){
            alterDateAluno.alterarDadosAluno(nome,cpf,email,telefone);
            edtAlterNomeAluno.setText("");
            edtAlterCPFAluno.setText("");
            edtAlterEmailAluno.setText("");
            edtAlterTelefoneAluno.setText("");
            Toast toast=Toast.makeText(AlterarDadosAluno.this,"Alteracao feita com sucesso!", Toast.LENGTH_LONG);
        }else{
            Toast toast=Toast.makeText(AlterarDadosAluno.this,"Aluno não encontrado!", Toast.LENGTH_LONG);
        }

    }

    public void excluirDados(View view) {
        String cpf   = edtAlterCPFAluno.getText()+"";
        alterDateAluno.excluirAluno(cpf);
        edtAlterCPFAluno.setText("");
        Toast toast=Toast.makeText(AlterarDadosAluno.this,"Dados Excluídos com Sucesso!", Toast.LENGTH_LONG);
    }

    public void voltar(View view) {
        Intent it=new Intent(this,MenuActivity.class);
        startActivity(it);
    }
}