package Repository;

import Model.Emprestimo;
import java.util.List;

public interface EmprestimoRepository {

    void salvar(Emprestimo emprestimo);

    List<Emprestimo> listarTodos();

    void remover(int idLivro);
}