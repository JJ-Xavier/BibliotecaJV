package Repository;

import Model.Livro;
import java.util.List;

public interface LivroRepository {

    void salvar(Livro livro);

    Livro buscarPorId(int id);

    List<Livro> listarTodos();

    void atualizar(Livro livro);

    void remover(int id);
}