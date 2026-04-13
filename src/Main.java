import java.util.Scanner;

/***********************************************************************************
 * Universidade Catolica de Brasília - UCB                                         *
 * Disciplina: Programação Orientada a Objetos                                     *
 * Aluno: Jackson Junio Xavier Franco                                              *
 * Data: 13/04/2026                                                                *
 *                                                                                 *
 * Descrição:                                                                      *
 * Classe principal do sistema de locação de livros                                *
 * Responsável pela execução do programa e interação com o usuário via terminal.   *
 ***********************************************************************************/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AcoesMenu acoesMenu = new AcoesMenu();
        Biblioteca biblioteca = new Biblioteca();
        int opcao;

        do {
            acoesMenu.MenuPrincipal();
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    acoesMenu.cadastrarLivro(sc, biblioteca);
                    break;
                case 2:
                    acoesMenu.cadastrarUsuario(sc, biblioteca);
                    break;
                case 3:
                    acoesMenu.emprestarLivro(sc, biblioteca);
                    break;
                case 4:
                    acoesMenu.devolverLivro(sc, biblioteca);
                    break;
                case 5:
                    biblioteca.listarLivros();
                    break;
                case 6:
                    biblioteca.listarEmprestimos();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
            }
        } while (opcao != 0);

        sc.close();
    }
}