package Model;

/***********************************************************************************
 * Universidade Católica de Brasília - UCB                                         *
 * Disciplina: Programação Orientada a Objetos                                     *
 * Model.Aluno: Jackson Junio Xavier Franco                                              *
 * Data: 13/04/2026                                                                *
 *                                                                                 *
 * Descrição:                                                                      *
 * Classe que representa um livro, herdando da classe estandes                     *
 * Adiciona características específicas como os titulos dos livros.                *
 ***********************************************************************************/

public class Livro extends Estandes {
    private String titulo;

    public Livro(int id, String categoria, String titulo) {
        super(id, categoria);
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String toString() {
        return super.toString() + " | Título: " + titulo;
    }
}