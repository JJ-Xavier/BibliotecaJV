/***********************************************************************************
 * Universidade Católica de Brasília - UCB                                         *
 * Disciplina: Programação Orientada a Objetos                                     *
 * Aluno: Jackson Junio Xavier Franco                                              *
 * Data: 13/04/2026                                                                *
 *                                                                                 *
 * Descrição:                                                                      *
 * Classe filha dos Usuarios                                                       *
 * Serve para limitar o limite de livros dos alunos                                *
 ***********************************************************************************/

public class Aluno extends Usuario {
    public Aluno(int id, String nome) {
        super(id, nome, 3); // limiteLivros: 3
    }
}