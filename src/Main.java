import Model.AcoesMenu;
import Repository.EmprestimoRepository;
import Repository.EmprestimoRepositorySQLite;
import Repository.LivroRepository;
import Repository.LivroRepositorySQLite;
import Repository.UsuarioRepository;
import Repository.UsuarioRepositorySQLite;
import Service.Biblioteca;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LivroRepository livroRepository =
                new LivroRepositorySQLite();

        UsuarioRepository usuarioRepository =
                new UsuarioRepositorySQLite();

        EmprestimoRepository emprestimoRepository =
                new EmprestimoRepositorySQLite();

        Biblioteca biblioteca =
                new Biblioteca(
                        livroRepository,
                        usuarioRepository,
                        emprestimoRepository
                );

        AcoesMenu acoesMenu = new AcoesMenu();

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

                    biblioteca
                            .listarLivros()
                            .forEach(System.out::println);

                    break;

                case 6:

                    biblioteca.listarEmprestimos();

                    break;

                case 0:

                    System.out.println("Saindo...");

                    break;

                default:

                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}