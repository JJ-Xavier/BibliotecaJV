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
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    public void adicionarLivro(Livro l) {
        livros.add(l);
    }

    public void adicionarCliente(Cliente c) {
        clientes.add(c);
    }

    public Livro buscarLivro(int id) {
        for (Livro l : livros) {
            if (l.getId() == id) {
                return l;
            }
        }
        return null;
    }

    public Cliente buscarCliente(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public void emprestarLivro(int idLivro, int idCliente) {
        Livro l = buscarLivro(idLivro);
        Cliente c = buscarCliente(idCliente);

        if (l != null && c != null) {
            if (l.isDisponivel()) {
                l.setDisponivel(false);
                emprestimos.add(new Emprestimo(l, c));
                System.out.println("Emprestimo realizado com sucesso!");
            } else {
                System.out.println("Emprestimo indisponível.");
            }
        } else {
            System.out.println("Cliente ou Livro não encontrado.");
        }
    }

    public void devolverLivro(int idLivro) {
        for (Emprestimo e : emprestimos) {
            if (e.getLivro().getId() == idLivro) {
                e.getLivro().setDisponivel(true);
                emprestimos.remove(e);
                System.out.println("Livro devolvido!");
                return;
            }
        }
        System.out.println("Emprestimo não encontrado.");
    }

    public void listarLivros() {
        for (Livro l : livros) {
            System.out.println(l);
        }
    }

    public void listarEmprestimos() {
        for (Emprestimo e : emprestimos) {
            System.out.println(e);
        }
    }
}
