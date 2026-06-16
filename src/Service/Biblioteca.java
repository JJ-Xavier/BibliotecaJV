package Service;

import Model.Emprestimo;
import Model.Livro;
import Model.Usuario;
import Repository.EmprestimoRepository;
import Repository.LivroRepository;
import Repository.UsuarioRepository;

import java.util.List;

public class Biblioteca {

    private final LivroRepository livroRepository;
    private final UsuarioRepository usuarioRepository;
    private final EmprestimoRepository emprestimoRepository;

    public Biblioteca(
            LivroRepository livroRepository,
            UsuarioRepository usuarioRepository,
            EmprestimoRepository emprestimoRepository) {

        this.livroRepository = livroRepository;
        this.usuarioRepository = usuarioRepository;
        this.emprestimoRepository = emprestimoRepository;
    }

    // =========================
    // LIVROS
    // =========================

    public void cadastrarLivro(Livro livro) {

        if (livroRepository.buscarPorId(livro.getId()) != null) {
            System.out.println("Já existe um livro com esse ID.");
            return;
        }

        livroRepository.salvar(livro);

        System.out.println("Livro cadastrado com sucesso.");
    }

    public List<Livro> listarLivros() {
        return livroRepository.listarTodos();
    }

    // =========================
    // USUÁRIOS
    // =========================

    public void cadastrarUsuario(Usuario usuario) {

        if (usuarioRepository.buscarPorId(usuario.getId()) != null) {
            System.out.println("Já existe um usuário com esse ID.");
            return;
        }

        usuarioRepository.salvar(usuario);

        System.out.println("Usuário cadastrado com sucesso.");
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.listarTodos();
    }

    // =========================
    // EMPRÉSTIMOS
    // =========================

    public void emprestarLivro(int idLivro, int idUsuario) {

        Livro livro = livroRepository.buscarPorId(idLivro);

        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        Usuario usuario = usuarioRepository.buscarPorId(idUsuario);

        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        if (!livro.isDisponivel()) {
            System.out.println("Livro indisponível para empréstimo.");
            return;
        }

        if (!usuario.podePegarMaisLivro()) {
            System.out.println("Limite de empréstimos atingido.");
            return;
        }

        livro.setDisponivel(false);

        livroRepository.atualizar(livro);

        usuario.adicionarLivroLista(livro);

        Emprestimo emprestimo =
                new Emprestimo(livro, usuario);

        emprestimoRepository.salvar(emprestimo);

        System.out.println("Empréstimo realizado com sucesso.");
    }

    public void devolverLivro(int idLivro) {

        Livro livro = livroRepository.buscarPorId(idLivro);

        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        if (livro.isDisponivel()) {
            System.out.println("Este livro já está disponível.");
            return;
        }

        livro.setDisponivel(true);

        livroRepository.atualizar(livro);

        emprestimoRepository.remover(idLivro);

        System.out.println("Livro devolvido com sucesso.");
    }

    public void listarEmprestimos() {

        List<Emprestimo> emprestimos =
                emprestimoRepository.listarTodos();

        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo registrado.");
            return;
        }

        for (Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo);
        }
    }
}