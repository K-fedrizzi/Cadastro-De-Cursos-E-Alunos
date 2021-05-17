package com.example.cadastrarcursosealunos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AlterarDadosCurso extends AppCompatActivity {
    private EditText edtAlterCodCurso, edtAlterNomeCurso, edtAlterQuatidadeHorasCurso;
    private Button btnAlterAlterarDadosCurso,btnAlterExcluirDadosCurso,btnAlterVoltarCurso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_dados_curso);

        // Fazendo a ligação dos componentes da activity
        edtAlterCodCurso = findViewById(R.id.edtAlterCodCurso);
        edtAlterNomeCurso = findViewById(R.id.edtAlterNomeCurso);
        edtAlterQuatidadeHorasCurso = findViewById(R.id.edtAlterQuatidadeHorasCurso);

        btnAlterAlterarDadosCurso = findViewById(R.id.btnAlterAlterarDadosCurso);
        btnAlterExcluirDadosCurso = findViewById(R.id.btnAlterExcluirDadosCurso);
        btnAlterVoltarCurso = findViewById(R.id.btnAlterVoltarCurso);

        // capturando os atributos de cada componente
        int codCurso = Integer.parseInt(edtAlterCodCurso.getText()+"");
        String nomeCurso = edtAlterNomeCurso.getText()+"";
        String horas = edtAlterQuatidadeHorasCurso.getText()+"";
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