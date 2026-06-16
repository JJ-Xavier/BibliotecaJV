package Model;

/***********************************************************************************
 * Universidade Católica de Brasília - UCB                                         *
 * Disciplina: Programação Orientada a Objetos                                     *
 * Model.Aluno: Jackson Junio Xavier Franco                                              *
 * Data: 13/04/2026                                                                *
 *                                                                                 *
 * Descrição:                                                                      *
 * Classe responsável por representar o relacionamento entre Model.Usuario e livro       *
 * Adiciona relacionamento                                                         *
 ***********************************************************************************/

public class Emprestimo {
    private Livro livro;
    private Usuario usuario;

    public Emprestimo(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public String toString() {
        return "Model.Livro: " + livro.getTitulo() + " | Usuário: " + usuario.getNome();
    }
}