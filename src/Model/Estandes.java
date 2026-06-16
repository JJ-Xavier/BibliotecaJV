package Model;

/***********************************************************************************
 * Universidade Católica de Brasília - UCB                                         *
 * Disciplina: Programação Orientada a Objetos                                     *
 * Model.Aluno: Jackson Junio Xavier Franco                                              *
 * Data: 13/04/2026                                                                *
 *                                                                                 *
 * Descrição:                                                                      *
 * Classe base que serve como mãe para as demais classes                           *
 * Contém atributos e métodos comuns a todos                                       *
 ***********************************************************************************/

public class Estandes {
    private int id;
    private String categoria;
    private boolean disponivel;

    public Estandes(int id, String categoria) {
        this.id = id;
        this.categoria = categoria;
        this.disponivel = true;
    }

    public int getId() {
        return id;
    }
    public String getCategoria() {
        return categoria;
    }
    public boolean isDisponivel() {
        return disponivel;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String toString() {
        return "ID: " + id + " | Categoria: " + categoria + " | Disponível: " + disponivel;
    }
}