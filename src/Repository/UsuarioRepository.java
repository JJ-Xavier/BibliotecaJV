package Repository;

import Model.Usuario;
import java.util.List;

public interface UsuarioRepository {

    void salvar(Usuario usuario);

    Usuario buscarPorId(int id);

    List<Usuario> listarTodos();

    void atualizar(Usuario usuario);

    void remover(int id);
}