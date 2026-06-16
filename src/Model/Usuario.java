package Model;

import java.util.ArrayList;

/***********************************************************************************
 * Universidade Católica de Brasília - UCB                                         *
 * Disciplina: Programação Orientada a Objetos                                     *
 * Model.Aluno: Jackson Junio Xavier Franco                                              *
 * Data: 13/04/2026                                                                *
 *                                                                                 *
 * Descrição:                                                                      *
 * Classe que representa um Model.Usuario da Service.Biblioteca.                                 *
 * Armazena informações básicas como identificação e nome.                         *
 ***********************************************************************************/

public abstract class Usuario {
    private int id;
    private String nome;
    protected int limiteLivros;
    private ArrayList<Livro> livrosPossuidos = new ArrayList<>();

    public Usuario(int id, String nome, int limiteLivros) {
        this.id = id;
        this.nome = nome;
        this.limiteLivros = limiteLivros;
    }

    public boolean podePegarMaisLivro() {
        return livrosPossuidos.size() < limiteLivros;
    }

    public void adicionarLivroLista(Livro l) { livrosPossuidos.add(l); }
    public void removerLivroLista(Livro l) { livrosPossuidos.remove(l); }

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public int getLimiteLivros() {
        return limiteLivros;
    }

    public String toString() {
        return "ID: " + id + " | Nome: " + nome + " | Livros atuais: " + livrosPossuidos.size() + "/" + limiteLivros;
    }
}