package Model;

import Service.Biblioteca;

import java.util.Scanner;

/***********************************************************************************
 * Universidade Católica de Brasília - UCB
 * Disciplina: Programação Orientada a Objetos
 *
 * Descrição:
 * Classe de ações do menu principal.
 ***********************************************************************************/
public class AcoesMenu {

    public void MenuPrincipal() {
        System.out.println("\n1 - Cadastrar Livro");
        System.out.println("2 - Cadastrar Usuário");
        System.out.println("3 - Emprestar Livro");
        System.out.println("4 - Devolver Livro");
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

        Livro livro = new Livro(
                id,
                categoria,
                titulo
        );

        biblioteca.cadastrarLivro(livro);
    }

    public void cadastrarUsuario(
            Scanner sc,
            Biblioteca biblioteca) {

        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print(
                "Tipo (1 para Aluno / 2 para Professor): "
        );

        int tipo = sc.nextInt();

        if (tipo == 1) {

            biblioteca.cadastrarUsuario(
                    new Aluno(id, nome)
            );

        } else {

            biblioteca.cadastrarUsuario(
                    new Professor(id, nome)
            );
        }
    }

    public void emprestarLivro(
            Scanner sc,
            Biblioteca biblioteca) {

        System.out.print("ID do Livro: ");
        int idLivro = sc.nextInt();

        System.out.print("ID do Usuário: ");
        int idUsuario = sc.nextInt();

        biblioteca.emprestarLivro(
                idLivro,
                idUsuario
        );
    }

    public void devolverLivro(
            Scanner sc,
            Biblioteca biblioteca) {

        System.out.print("ID do Livro: ");
        int idLivro = sc.nextInt();

        biblioteca.devolverLivro(idLivro);
    }
}