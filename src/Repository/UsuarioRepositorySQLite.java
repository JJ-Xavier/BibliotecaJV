package Repository;

import DataBase.DataBaseConnection;
import Factory.UsuarioFactory;
import Model.Aluno;
import Model.Professor;
import Model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorySQLite implements UsuarioRepository {

    private Connection connection;

    public UsuarioRepositorySQLite() {
        connection = DataBaseConnection
                .getInstance()
                .getConnection();
    }

    @Override
    public void salvar(Usuario usuario) {

        String sql =
                "INSERT INTO usuario(id,nome,tipo) VALUES(?,?,?)";

        try (PreparedStatement stmt =
                     connection.prepareStatement(sql)) {

            stmt.setInt(1, usuario.getId());
            stmt.setString(2, usuario.getNome());

            if (usuario instanceof Aluno) {
                stmt.setString(3, "ALUNO");
            } else if (usuario instanceof Professor) {
                stmt.setString(3, "PROFESSOR");
            }

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario buscarPorId(int id) {

        String sql =
                "SELECT * FROM usuario WHERE id=?";

        try (PreparedStatement stmt =
                     connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return UsuarioFactory.criarUsuario(
                        rs.getString("tipo"),
                        rs.getInt("id"),
                        rs.getString("nome")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Usuario> listarTodos() {

        List<Usuario> usuarios = new ArrayList<>();

        String sql = "SELECT * FROM usuario";

        try (Statement stmt =
                     connection.createStatement()) {

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                usuarios.add(
                        UsuarioFactory.criarUsuario(
                                rs.getString("tipo"),
                                rs.getInt("id"),
                                rs.getString("nome")
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    @Override
    public void atualizar(Usuario usuario) {
    }

    @Override
    public void remover(int id) {

        String sql =
                "DELETE FROM usuario WHERE id=?";

        try (PreparedStatement stmt =
                     connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}