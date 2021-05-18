package com.example.cadastrarcursosealunos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

public class AlterarDadosCurso extends AppCompatActivity {
    private EditText edtAlterNomeCurso, edtAlterQuatidadeHorasCurso;
    private Spinner spinnCursos;
    private Button btnAlterAlterarDadosCurso,btnAlterExcluirDadosCurso,btnAlterVoltarCurso;

    private TableCursoAlunoHelper alterDateCurso =new TableCursoAlunoHelper(this);
    private List<String> cursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_dados_curso);

        // Fazendo a ligação dos componentes da activity
        edtAlterNomeCurso = findViewById(R.id.edtAlterNomeCurso);
        edtAlterQuatidadeHorasCurso = findViewById(R.id.edtAlterQuatidadeHorasCurso);

        btnAlterAlterarDadosCurso = findViewById(R.id.btnAlterAlterarDadosCurso);
        btnAlterExcluirDadosCurso = findViewById(R.id.btnAlterExcluirDadosCurso);
        btnAlterVoltarCurso = findViewById(R.id.btnAlterVoltarCurso);

        spinnCursos = findViewById(R.id.spinnCursos);

        cursos = alterDateCurso.buscarCursos();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,cursos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnCursos.setAdapter(adapter);

    }

    public void alterarDados(View view) {

        /*capturando os atributos de cada componente*/
        String nomeCurso = edtAlterNomeCurso.getText()+"";
        String horas = edtAlterQuatidadeHorasCurso.getText()+"";

        /*Recebe o indice do curso selecionado*/
        int indice = spinnCursos.getSelectedItemPosition();

        /*Busca o id do curso selecionado*/
        int id = alterDateCurso.buscarIdCurso(cursos.get(indice));

        /*Altera os dados do curso*/
        alterDateCurso.alterarDadosCurso(id+"",nomeCurso,horas);

        /*Limpa os campos*/
        edtAlterNomeCurso.setText("");
        edtAlterQuatidadeHorasCurso.setText("");

        /*Atualiza os dados do spinner */
        cursos = alterDateCurso.buscarCursos();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,cursos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnCursos.setAdapter(adapter);
    }

    public void excluirDados(View view) {
        String nomeCurso = edtAlterNomeCurso.getText()+"";
        alterDateCurso.excluirCurso(nomeCurso);

        /*Atualiza os dados do spinner */
        cursos = alterDateCurso.buscarCursos();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,cursos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnCursos.setAdapter(adapter);
    }

    public void voltar(View view) {
        Intent it=new Intent(this,MenuActivity.class);
        startActivity(it);
    }
}