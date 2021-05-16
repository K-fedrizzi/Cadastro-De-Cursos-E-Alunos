package com.example.cadastrarcursosealunos;

public class Curso {

   private int idCurso;
   private String nomeCurso;
   private String quantHoras;

    // Construtor
    public Curso() {
        /* buscar o ultimo id da tabela curso e incrementar o id */
    }

    // Encapsulamento
    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getQuantHoras() {
        return quantHoras;
    }

    public void setQuantHoras(String quantHoras) {
        this.quantHoras = quantHoras;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }
}
