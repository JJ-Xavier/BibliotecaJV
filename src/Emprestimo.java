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

public class Emprestimo {
        private Livro livro;
        private Cliente cliente;

        public Emprestimo(Livro livro, Cliente cliente) {
            this.livro = livro;
            this.cliente = cliente;
        }

    public Livro getLivro() {
        return livro;
    }

    public Cliente getCliente() {
            return cliente;
        }

        public String toString() {
            return "Livro: " + livro.getTitulo() + " | Cliente: " + cliente.getNome();
        }
}
