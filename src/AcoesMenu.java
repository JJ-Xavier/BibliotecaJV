import java.util.Scanner;

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

public class AcoesMenu {
    public AcoesMenu() {
    }
    public void MenuPrincipal(){
        System.out.println("\n1 - Cadastrar Livro");
        System.out.println("2 - Cadastrar cliente");
        System.out.println("3 - Alugar Livro");
        System.out.println("4 - Devolver Livro");
        System.out.println("5 - Listar todos os Livros");
        System.out.println("6 - Listar Emprestimos dos Livros");
        System.out.println("0 - Sair");
    }

    public void cadastrarLivro(Scanner sc, Biblioteca biblioteca){
        System.out.print("ID: ");
        int idV = sc.nextInt();
        sc.nextLine();

        System.out.print("Categoria: ");
        String categoria = sc.nextLine();

        System.out.print("Título: ");
        String titulo = sc.nextLine();

        biblioteca.adicionarLivro(new Livro(idV, categoria, titulo));
    }

    public void cadastrarCliente(Scanner sc, Biblioteca biblioteca){
        System.out.print("ID: ");
        int idC = sc.nextInt();

        sc.nextLine();

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        biblioteca.adicionarCliente(new Cliente(idC, nome));
    }

    public void emprestarLivro(Scanner sc, Biblioteca biblioteca){
        System.out.print("ID: ");
        int vId = sc.nextInt();

        System.out.print("ID cliente: ");
        int cId = sc.nextInt();

        biblioteca.emprestarLivro(vId, cId);
    }

    public void devolverLivro(Scanner sc, Biblioteca biblioteca){
        System.out.print("ID do livro: ");
        int devId = sc.nextInt();

        biblioteca.devolverLivro(devId);
    }
}
