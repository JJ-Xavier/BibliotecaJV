/***********************************************************************************
 * Universidade Católica de Brasília - UCB                                         *
 * Disciplina: Programação Orientada a Objetos                                     *
 * Aluno: Jackson Junio Xavier Franco                                              *
 * Data: 13/04/2026                                                                *
 *                                                                                 *
 * Descrição:                                                                      *
 * Classe filha dos Usuarios                                                       *
 * Serve para limitar o limite de livros dos Professores                           *
 ***********************************************************************************/

public class Professor extends Usuario {
    public Professor(int id, String nome) {
        super(id, nome, 5); // limiteLivros: 5
    }
}