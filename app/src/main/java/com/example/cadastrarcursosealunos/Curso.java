package com.example.cadastrarcursosealunos;

public class Curso {
   private String nomeCurso;
   private String quantHoras;

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

}
