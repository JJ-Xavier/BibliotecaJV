package Model;

import java.util.Scanner;

/***********************************************************************************
 * Universidade Católica de Brasília - UCB                                         *
 * Disciplina: Programação Orientada a Objetos                                     *
 * Model.Aluno: Jackson Junio Xavier Franco                                              *
 * Data: 13/04/2026                                                                *
 *                                                                                 *
 * Descrição:                                                                      *
 * Classe de ações do menu principal.                                              *
 * Responsável pelas ações do menu e uso da classe controler locadora.             *
 ***********************************************************************************/

public class AcoesMenu {
    public void MenuPrincipal() {
        System.out.println("\n1 - Cadastrar Model.Livro");
        System.out.println("2 - Cadastrar Usuário");
        System.out.println("3 - Emprestar Model.Livro");
        System.out.println("4 - Devolver Model.Livro");
        System.out.println("5 - Listar todos os Livros");
        System.out.println("6 - Listar Empréstimos");
        System.out.println("0 - Sair");
    }

    public void cadastrarLivro(Scanner sc, Biblioteca biblioteca) {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Categoria: ");
        String categoria = sc.nextLine();
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        biblioteca.adicionarLivro(new Livro(id, categoria, titulo));
    }

    public void cadastrarUsuario(Scanner sc, Biblioteca biblioteca) {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Tipo (1 para Model.Aluno / 2 para Model.Professor): ");
        int tipo = sc.nextInt();

        if (tipo == 1) {
            biblioteca.adicionarUsuario(new Aluno(id, nome));
        } else {
            biblioteca.adicionarUsuario(new Professor(id, nome));
        }
        System.out.println("Usuário cadastrado com sucesso!");
    }

    public void emprestarLivro(Scanner sc, Biblioteca biblioteca) {
        System.out.print("ID do Model.Livro: ");
        int vId = sc.nextInt();
        System.out.print("ID do Usuário: ");
        int cId = sc.nextInt();
        biblioteca.emprestarLivro(vId, cId);
    }

    public void devolverLivro(Scanner sc, Biblioteca biblioteca) {
        System.out.print("ID do livro: ");
        int devId = sc.nextInt();
        biblioteca.devolverLivro(devId);
    }
}