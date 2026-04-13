import java.util.ArrayList;

/***********************************************************************************
 * Universidade Católica de Brasília - UCB                                         *
 * Disciplina: Programação Orientada a Objetos                                     *
 * Aluno: Jackson Junio Xavier Franco                                              *
 * Data: 13/04/2026                                                                *
 *                                                                                 *
 * Descrição:                                                                      *
 * Classe responsável pelo controle do sistema da locadora.                        *
 * Gerencia Livros, Usuarios e Emprestimos.                                        *
 ***********************************************************************************/

public class Biblioteca {
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    public void adicionarLivro(Livro l) { livros.add(l); }
    public void adicionarUsuario(Usuario u) { usuarios.add(u); }

    public Livro buscarLivro(int id) {
        for (Livro l : livros) { if (l.getId() == id) return l; }
        return null;
    }

    public Usuario buscarUsuario(int id) {
        for (Usuario u : usuarios) { if (u.getId() == id) return u; }
        return null;
    }

    public void emprestarLivro(int idLivro, int idUsuario) {
        Livro l = buscarLivro(idLivro);
        Usuario u = buscarUsuario(idUsuario);

        if (l != null && u != null) {
            if (l.isDisponivel()) {
                if (u.podePegarMaisLivro()) {
                    l.setDisponivel(false);
                    u.adicionarLivroLista(l);
                    emprestimos.add(new Emprestimo(l, u));
                    System.out.println("Empréstimo realizado com sucesso!");
                } else {
                    System.out.println("Limite atingido! Alunos max 3, Profs max 5.");
                }
            } else { System.out.println("Livro indisponível."); }
        } else { System.out.println("Usuário ou Livro não encontrado."); }
    }

    public void devolverLivro(int idLivro) {
        for (Emprestimo e : emprestimos) {
            if (e.getLivro().getId() == idLivro) {
                e.getLivro().setDisponivel(true);
                e.getUsuario().removerLivroLista(e.getLivro());
                emprestimos.remove(e);
                System.out.println("Livro devolvido!");
                return;
            }
        }
        System.out.println("Empréstimo não encontrado.");
    }

    public void listarLivros() {
        for (Livro l : livros) System.out.println(l);
    }
    public void listarEmprestimos() {
        for (Emprestimo e : emprestimos) System.out.println(e);
    }
}
