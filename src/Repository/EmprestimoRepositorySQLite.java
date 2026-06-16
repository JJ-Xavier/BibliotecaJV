package Repository;

import DataBase.DataBaseConnection;
import Model.Emprestimo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoRepositorySQLite
        implements EmprestimoRepository {

    private Connection connection;

    public EmprestimoRepositorySQLite() {

        connection = DataBaseConnection
                .getInstance()
                .getConnection();
    }

    @Override
    public void salvar(Emprestimo emprestimo) {

        String sql =
                "INSERT INTO emprestimo(livro_id,usuario_id) VALUES(?,?)";

        try (PreparedStatement stmt =
                     connection.prepareStatement(sql)) {

            stmt.setInt(
                    1,
                    emprestimo.getLivro().getId()
            );

            stmt.setInt(
                    2,
                    emprestimo.getUsuario().getId()
            );

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Emprestimo> listarTodos() {

        List<Emprestimo> emprestimos =
                new ArrayList<>();

        String sql =
                "SELECT * FROM emprestimo";

        try (Statement stmt =
                     connection.createStatement()) {

            ResultSet rs =
                    stmt.executeQuery(sql);

            LivroRepository livroRepository =
                    new LivroRepositorySQLite();

            UsuarioRepository usuarioRepository =
                    new UsuarioRepositorySQLite();

            while (rs.next()) {

                int livroId =
                        rs.getInt("livro_id");

                int usuarioId =
                        rs.getInt("usuario_id");

                Emprestimo emprestimo =
                        new Emprestimo(
                                livroRepository.buscarPorId(livroId),
                                usuarioRepository.buscarPorId(usuarioId)
                        );

                emprestimos.add(emprestimo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emprestimos;
    }

    @Override
    public void remover(int idLivro) {

        String sql =
                "DELETE FROM emprestimo WHERE livro_id=?";

        try (PreparedStatement stmt =
                     connection.prepareStatement(sql)) {

            stmt.setInt(1, idLivro);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}