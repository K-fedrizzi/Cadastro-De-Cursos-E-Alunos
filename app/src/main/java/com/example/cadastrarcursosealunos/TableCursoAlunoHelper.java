package com.example.cadastrarcursosealunos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class TableCursoAlunoHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 4;
    private static  final String DATABASE_NAME = "Cursos_Alunos.db";

    // Atributos do curso
    private static final String TABLE_CURSO = "aluno";
    private static final String cursoID="cursoID";
    private static final String nomeCurso="nomeCurso";
    private static final String qtdeHoras="qtdeHoras";

    // Atributos do Aluno
    private static final String TABLE_ALUNO = "aluno";
    private static final String alunoID="alunoID";
    private static final String CursoAlunoID ="cursoID"; // primary key
    private static final String nomeAluno = "nomeAluno";
    private static final String cpf ="cpf";
    private static final String email ="email";
    private static final String telefone = "telefone";


    // Objeto para acessar o banco de dados
    SQLiteDatabase db;

    // Query para criar a tabela curso
    private static  String CURSO_QUERY = "CREATE TABLE curso("                            +
                                                    "cursoID INT AUTO INCREMENT  PRIMARY KEY," +
                                                    "nomeCurso text NOT NULL,"                 +
                                                    "qutdeHoras text NOT NULL"               +
                                              ");";

    // Query para criar a tabela Aluno
    private static  String ALUNO_QUERY = "CREATE TABLE aluno("                           +
                                                    "alunoID INT AUTO INCREMENT PRIMARY KEY," +
                                                    "cursoID INT NOT NULL, "                  +
                                                    "nomeAluno TEXT NOT NULL, "               +
                                                    "cpf TEXT NOT NULL, "                     +
                                                    "temail TEXT NOT NULL, "                  +
                                                    "telefone TEXT NOT NULL,"                 +
                                                    "    FOREIGN KEY (cursoID) "              +
                                                    "       REFERENCES curso(cursoID)\n"      +
                                              ");";


    public TableCursoAlunoHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Execução do SQL para criação das tabelas
        db.execSQL(CURSO_QUERY);
        db.execSQL(ALUNO_QUERY);
        this.db=db;
    }

    @Override
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
        if(!db.isReadOnly()){
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query1 =(String)"DROP TABLE IF EXISTS " + CURSO_QUERY;
        db.execSQL(query1);

        String query2 =(String)"DROP TABLE IF EXISTS " + ALUNO_QUERY;
        db.execSQL(query2);

        this.onCreate(db);
    }

    // Inserindo de curso na tabela curso.db
    public void inserirCurso(Curso c){
        db=this.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put(nomeCurso,c.getNomeCurso());
        values.put(qtdeHoras,c.getQuantHoras());

        db.insert(TABLE_CURSO,null,values);
        db.close();
    }

    // Inserindo aluno na tabela aluno.db
    public void inserirAluno(Aluno a){
        db=this.getWritableDatabase();
        ContentValues values=new ContentValues();


        values.put(cursoID,a.getCurso().getIdCurso());
        values.put(nomeAluno,a.getNomeAluno());
        values.put(cpf,a.getCpf());
        values.put(email,a.getEmail());
        values.put(telefone,a.getTelefone());

        db.insert(TABLE_ALUNO,null,values);
        db.close();
    }

    public String buscarId(String nomeCurso){
        return "";
    }

}
