package com.example.cadastrarcursosealunos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TableCursoAlunoHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 4;
    private static  final String DATABASE_NAME = "emerson05";

    /*variável que armazena o nome da Tabela dos cursos*/
    private static final String TABLE_CURSO = "curso";

    /*variáveis referente as colunas da Tabela dos cursos*/
    private static final String nomeCurso="nomeCurso";
    private static final String qtdeHoras="qtdeHoras";

    /*variável que armazena o nome da Tabela dos alunos*/
    private static final String TABLE_ALUNO = "aluno";

    /*variáveis referente as colunas da tabela aluno*/
    private static final String cursoID ="cursoID"; // foreign key
    private static final String nomeAluno = "nomeAluno";
    private static final String cpf ="cpf";
    private static final String email ="email";
    private static final String telefone = "telefone";


    /*Query para criar a tabela curso*/
    private static String CURSO_QUERY = "CREATE TABLE curso(" +
                                                            "cursoID INTEGER PRIMARY KEY NOT NULL," +
                                                            "nomeCurso TEXT NOT NULL," +
                                                            "qtdeHoras TEXT NOT NULL);";

    /*Query para criar a tabela Aluno*/
    private static String ALUNO_QUERY = "CREATE TABLE aluno(" +
                                                            "alunoID INTEGER PRIMARY KEY NOT NULL," +
                                                    "        cursoID INT NOT NULL," +
                                                    "        nomeAluno TEXT NOT NULL," +
                                                            "cpf TEXT NOT NULL," +
                                                            "email TEXT NOT NULL," +
                                                            "telefone TEXT NOT NULL," +
                                                    "        FOREIGN KEY (cursoID)" +
                                                "            REFERENCES curso(cursoID)" +
                                            ");";

    public TableCursoAlunoHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*Execução do SQL para criação das duas tabelas*/
        db.execSQL(CURSO_QUERY);
        db.execSQL(ALUNO_QUERY);
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
        /*String query1 = "DROP TABLE IF EXISTS " + CURSO_QUERY;
        db.execSQL(query1);

        String query2 = "DROP TABLE IF EXISTS " + ALUNO_QUERY;
        db.execSQL(query2);

        this.onCreate(db);*/
    }

    /*Método paa inserir um curso*/
    public void inserirCurso(Curso c){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put(nomeCurso,c.getNomeCurso());
        values.put(qtdeHoras,c.getQuantHoras());

        db.insert("curso",null,values);
        db.close();
    }

    /*Método para inserir um aluno*/
    public void inserirAluno(Aluno a, String nomeCurso){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        /*Busca o id do curso pelo nome do curso*/
        values.put(cursoID,buscarIdCurso(nomeCurso));
        values.put(nomeAluno,a.getNomeAluno());
        values.put(cpf,a.getCpf());
        values.put(email,a.getEmail());
        values.put(telefone,a.getTelefone());


        db.insert(TABLE_ALUNO,null,values);
        db.close();
    }

    public List<String> buscarCursos(){

        SQLiteDatabase db=this.getReadableDatabase();
        String query = "SELECT nomeCurso FROM curso";
        Cursor cursor=db.rawQuery(query,null);

        List<String> cursos = new ArrayList<String>();

        if(cursor.moveToFirst()){
            do{
                String dado = cursor.getString(0)+"";
                cursos.add(dado);
            }while (cursor.moveToNext());
        }
        return cursos;
    }

    public List<String> buscarAlunos(){ ////////

        SQLiteDatabase db=this.getReadableDatabase();
        String query = "SELECT nomeAluno, cpf, email, telefone, cursoID  FROM aluno";

        Cursor cursor=db.rawQuery(query,null);

        List<String> alunos = new ArrayList<String>();

        if(cursor.moveToFirst()){
            do{
                String dado = "Nome: "+cursor.getString(0)+"\n";
                dado += "CPF: "+cursor.getString(1)+"\n";
                dado += "EMAIL: "+cursor.getString(2)+"\n";
                dado += "TELEFONE: "+cursor.getString(3)+"\n";
                dado += "ID CURSO: "+cursor.getString(3)+"\n";
                alunos.add(dado);
                dado="";
            }while (cursor.moveToNext());
        }
        return alunos;
    }


    public int buscarIdCurso(String nomeCurso){

        SQLiteDatabase db=this.getReadableDatabase();
        String query = "SELECT cursoID, nomeCurso FROM curso";
        Cursor cursor=db.rawQuery(query,null);


        if(cursor.moveToFirst()){
            do{
               String nomeCursoTabela=cursor.getString(1);
               if(nomeCursoTabela.equals(nomeCurso)){
                   return cursor.getInt(0);
               }
            }while (cursor.moveToNext());
        }
        return -1;
    }

}
