package Repository;

import DataBase.DataBaseConnection;
import Model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroRepositorySQLite
        implements LivroRepository {

    private Connection connection;

    public LivroRepositorySQLite() {

        connection = DataBaseConnection
                .getInstance()
                .getConnection();
    }

    @Override
    public void salvar(Livro livro) {

        String sql =
                "INSERT INTO livro(id,categoria,titulo,disponivel) VALUES(?,?,?,?)";

        try (PreparedStatement stmt =
                     connection.prepareStatement(sql)) {

            stmt.setInt(1, livro.getId());
            stmt.setString(2, livro.getCategoria());
            stmt.setString(3, livro.getTitulo());
            stmt.setBoolean(4, livro.isDisponivel());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Livro buscarPorId(int id) {

        String sql =
                "SELECT * FROM livro WHERE id=?";

        try (PreparedStatement stmt =
                     connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Livro livro = new Livro(
                        rs.getInt("id"),
                        rs.getString("categoria"),
                        rs.getString("titulo")
                );

                livro.setDisponivel(
                        rs.getBoolean("disponivel")
                );

                return livro;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Livro> listarTodos() {

        List<Livro> livros = new ArrayList<>();

        String sql = "SELECT * FROM livro";

        try (Statement stmt =
                     connection.createStatement()) {

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                Livro livro = new Livro(
                        rs.getInt("id"),
                        rs.getString("categoria"),
                        rs.getString("titulo")
                );

                livro.setDisponivel(
                        rs.getBoolean("disponivel")
                );

                livros.add(livro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return livros;
    }

    @Override
    public void atualizar(Livro livro) {

        String sql =
                "UPDATE livro SET disponivel=? WHERE id=?";

        try (PreparedStatement stmt =
                     connection.prepareStatement(sql)) {

            stmt.setBoolean(
                    1,
                    livro.isDisponivel()
            );

            stmt.setInt(
                    2,
                    livro.getId()
            );

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remover(int id) {

        String sql =
                "DELETE FROM livro WHERE id=?";

        try (PreparedStatement stmt =
                     connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}