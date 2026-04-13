/***********************************************************************************
 * Universidade Católica de Brasília - UCB                                         *
 * Disciplina: Programação Orientada a Objetos                                     *
 * Aluno: Jackson Junio Xavier Franco                                              *
 * Data: 13/04/2026                                                                *
 *                                                                                 *
 * Descrição:                                                                      *
 * Classe principal do sistema de locação de livros                                *
 * Responsável pela execução do programa e interação com o usuário via terminal.   *
 ***********************************************************************************/

public class Livro extends Estandes {
        private String titulo;

        public Livro(int id, String categoria, String titulo) {
            super(id, categoria);
            this.titulo = titulo;
        }

    public String getTitulo() {
        return titulo;
    }

    public String toString() {
            return super.toString() + " | Titulos: " + titulo;
        }
}
