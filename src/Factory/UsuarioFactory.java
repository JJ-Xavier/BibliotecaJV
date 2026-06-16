package Factory;

import Model.Aluno;
import Model.Professor;
import Model.Usuario;

public class UsuarioFactory {

    public static Usuario criarUsuario(
            String tipo,
            int id,
            String nome) {

        if (tipo.equalsIgnoreCase("ALUNO")) {
            return new Aluno(id, nome);
        }

        if (tipo.equalsIgnoreCase("PROFESSOR")) {
            return new Professor(id, nome);
        }

        throw new IllegalArgumentException(
                "Tipo de usuário inválido: " + tipo
        );
    }
}