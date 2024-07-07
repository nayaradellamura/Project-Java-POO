/*
Nome/RA:  Matheus Opuscolo 🤓 RA: 114449 
Nome/RA:  Sophya Damiazo 🌸 RA: 115352 :)
Nome/RA:  Julya de Lima Tochio❤️ RA: 115406 <3
Nome/RA:  Nayara Dellamura 🦥 RA: 115374
Nome/RA:  Juan Andrés Alvarez Salazar 🐴 RA: 116133
Nome/RA:  Vinicius Portes de Almeida 🎸 RA: 114722
*/




package ma2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Filme> titulos = new ArrayList<>();
    static ArrayList<Serie> titulos1 = new ArrayList<>();

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Sistema sistema = new Sistema();
        while (true) {
            System.out.println("Bem-vindo ao catálogo!");
            System.out.println("1. Registrar");
            System.out.println("2. Login");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int choice = ler.nextInt();
            ler.nextLine();
            if (choice == 1) {
                System.out.print("Digite um novo nome de usuário: ");
                String novoNomeUsuario = ler.nextLine();
                System.out.print("Digite uma nova senha: ");
                String novaSenha = ler.nextLine();

                if (sistema.registrarUsuario(novoNomeUsuario, novaSenha)) {
                    System.out.println("Registro de " + novoNomeUsuario + " foi bem-sucedido!");
                } else {
                    System.out.println("Nome de usuário já existe. Tente outro.");
                }
            } else if (choice == 2) {
                while (true) {
                    System.out.print("Digite seu nome de usuário: ");
                    String nomeUsuario = ler.nextLine();
                    System.out.print("Digite sua senha: ");
                    String senha = ler.nextLine();

                    Usuario usuario = sistema.loginUsuario(nomeUsuario, senha);
                    if (usuario != null) {
                        if (usuario.getTipoUsuario() == Usuario.TIPO_ADMIN) {
                            System.out.println("Login bem-sucedido! Bem-vindo, ADMIN " + nomeUsuario + "!");
                            adminMenu(ler, sistema, nomeUsuario);
                        } else {
                            System.out.println("Login bem-sucedido! Bem-vindo, " + nomeUsuario + "!");
                            userMenu(ler);
                        }
                        break;
                    } else {
                        System.out.println("Nome de usuário ou senha incorretos. Por favor, tente novamente.");
                    }
                }
            } else if (choice == 3) {
                System.out.println("Saindo do sistema. Até logo!");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
        ler.close();
    }

    private static void userMenu(Scanner ler) {
        while (true) {
        	System.out.println("Menu:");
            System.out.println("1. Exibir filmes registrados");
            System.out.println("2. Exibir séries registradas");
            System.out.println("3. Avaliar um título");
            System.out.println("4. Tempo de maratona de um título");
            System.out.println("5. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            int choice = ler.nextInt();
            ler.nextLine();

            if (choice == 1) {
            	int i = 0;
                     System.out.println("Escolha um filme caso você queria mais informações ou digite sair para voltar.");
                     for (i = 0; i < titulos.size(); i++) {
                         System.out.println((i + 1) + ". " + titulos.get(i).getTitulo());
                     } //Exibe o número dos filmes cadastrados 
                     int filmeEscolhido = ler.nextInt();
                     ler.nextLine();
                     if (filmeEscolhido > 0 && filmeEscolhido <= titulos.size()) {
                    	 System.out.println(titulos.get(filmeEscolhido - 1).toString());
                     } else {//Realiza a escolha do filme
                         System.out.println("Voltando ao menu");
                     }
            } else if (choice == 2) {
            	int i = 0;
                System.out.println("Escolha uma série caso você queria mais informações ou digite sair para voltar.");
                for (i = 0; i < titulos1.size(); i++) {
                    System.out.println((i + 1) + ". " + titulos1.get(i).getTitulo());
                } //Exibe o número dos filmes cadastrados 
                int serieEscolhida = ler.nextInt();
                ler.nextLine();
                if (serieEscolhida > 0 && serieEscolhida <= titulos1.size()) {
               	 System.out.println(titulos1.get(serieEscolhida - 1).toString());
                } else {//Realiza a escolha do filme
                    System.out.println("Voltando ao menu");
                }
            } else if (choice == 3) {
            	System.out.println("Que tipo de título você quer avaliar?");
                System.out.println("1. Filme");
                System.out.println("2. Série");
                System.out.print("Escolha uma opção: ");
                int tipo = ler.nextInt();
                ler.nextLine();

                if (tipo == 1) {
                	int i = 0;
                    System.out.println("Escolha um filme:");
                    for (i = 0; i < titulos.size(); i++) {
                        System.out.println((i + 1) + ". " + titulos.get(i).getTitulo());
                    } //Exibe o número dos filmes cadastrados 
                    int filmeEscolhido = ler.nextInt();
                    ler.nextLine();
                    if (filmeEscolhido > 0 && filmeEscolhido <= titulos.size()) {
                    	while(true) {
                    		System.out.println("Digite a nota de 1 a 5 para o filme " + titulos.get(filmeEscolhido - 1).getTitulo());
                            if(titulos.get(filmeEscolhido - 1).avaliar(ler.nextInt())){
                         	   System.out.println("Filme avaliado com sucesso.");
                         	   ler.nextLine();
                         	   break;
                            }
                            else {
                         	   System.out.println("Nota inválida.");
                            }
                    	}
                    	
                    } else {//Realiza a escolha do filme
                        System.out.println("Opção inválida, voltando ao menu.");
                    }
                } else if (tipo == 2) {
                	int i = 0;
                    System.out.println("Escolha uma série:");
                    for (i = 0; i < titulos1.size(); i++) {
                        System.out.println((i + 1) + ". " + titulos1.get(i).getTitulo());
                    }
                    int serieEscolhida = ler.nextInt();
                    ler.nextLine();
                    if (serieEscolhida > 0 && serieEscolhida <= titulos1.size()) {
                    	while(true) {
                    		System.out.println("Digite a nota de 1 a 5 para a série " + titulos1.get(serieEscolhida - 1).getTitulo());
                            if(titulos.get(serieEscolhida - 1).avaliar(ler.nextInt())){
                         	   System.out.println("série avaliada com sucesso.");
                         	   ler.nextLine();
                         	   break;
                            }
                            else {
                         	   System.out.println("Nota inválida.");
                            }
                    	}
                    	
                    } else {
                        System.out.println("Opção inválida.");
                    }
                } else {
                    System.out.println("Opção inválida.");
                }
            } else if (choice == 4) {
            	 System.out.println("Calcular tempo de maratona de:");
                 System.out.println("1. Filme");
                 System.out.println("2. Série");
                 System.out.print("Escolha uma opção: ");
                 int tipo = ler.nextInt();
                 ler.nextLine();

                 if (tipo == 1) {
                     System.out.println("Escolha um filme:");
                     for (int i = 0; i < titulos.size(); i++) {
                         System.out.println((i + 1) + ". " + titulos.get(i).getTitulo());
                     }
                     int filmeEscolhido = ler.nextInt();
                     ler.nextLine();
                     if (filmeEscolhido > 0 && filmeEscolhido <= titulos.size()) {
                         Filme filme = titulos.get(filmeEscolhido - 1);
                         filme.tempoMaratona();
                     } else {
                         System.out.println("Opção inválida.");
                     }
                 } else if (tipo == 2) {
                     System.out.println("Escolha uma série:");
                     for (int i = 0; i < titulos1.size(); i++) {
                         System.out.println((i + 1) + ". " + titulos1.get(i).getTitulo());
                     }
                     int serieEscolhida = ler.nextInt();
                     ler.nextLine();
                     if (serieEscolhida > 0 && serieEscolhida <= titulos1.size()) {
                         Serie serie = titulos1.get(serieEscolhida - 1);
                         serie.tempoMaratona();
                     } else {
                         System.out.println("Opção inválida.");
                     }
                 }
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void adminMenu(Scanner ler, Sistema sistema, String adminAtual) {
        while (true) {
            System.out.println("Menu de administrador:");
            System.out.println("1. Adicionar novo administrador");
            System.out.println("2. Remover administrador");
            System.out.println("3. Adicionar Filme");
            System.out.println("4. Adicionar Série");
            System.out.println("5. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            int choice = ler.nextInt();
            ler.nextLine();
            if (choice == 1) {
                System.out.print("Digite um novo nome de usuário para o administrador: ");
                String novoAdminNomeUsuario = ler.nextLine();
                System.out.print("Digite uma nova senha para o administrador: ");
                String novaAdminSenha = ler.nextLine();

                if (sistema.adicionarAdmin(novoAdminNomeUsuario, novaAdminSenha)) {
                    System.out.println("Novo administrador registrado com sucesso!");
                } else {
                    System.out.println("Nome de usuário já existe ou inválido. Tente outro.");
                }
            } else if (choice == 2) {
                sistema.listarAdmins();
                System.out.print("Digite o nome de usuário do administrador a ser removido: ");
                String adminParaRemover = ler.nextLine();

                if (sistema.removerAdmin(adminParaRemover, adminAtual)) {
                    System.out.println("Administrador removido com sucesso.");
                } else {
                    System.out.println("Nome de usuário inválido ou você não pode remover a si mesmo.");
                }
            } else if (choice == 3) {
                System.out.println("Adicionar título ao catálogo: ");
                cadastrarFilme(ler);
            } else if (choice == 4) {
                System.out.println("Adicionar título ao catálogo: ");
                cadastrarSerie(ler);
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void cadastrarFilme(Scanner ler) {
        System.out.print("Digite o título do filme: ");
        String titulo = ler.nextLine();
        System.out.print("Digite o ano de lançamento: ");
        int ano = ler.nextInt();
        ler.nextLine();
        System.out.print("Digite o nome do diretor: ");
        String diretor = ler.nextLine();
        System.out.print("Digite o nome da produtora: ");
        String produtora = ler.nextLine();
        System.out.print("Digite o gênero: ");
        String genero = ler.nextLine();
        System.out.print("Qual duração do filme em minutos? ");
        float duracao = ler.nextFloat();
        ler.nextLine();
        System.out.print("Digite o nome do ator que interpreta o protagonista do filme: ");
        String nome = ler.nextLine();
        System.out.print("Digite a idade do ator que interpreta o protagonista do filme: ");
        int idade = ler.nextInt();
        ler.nextLine();
        Protagonista nomeAtor = new Protagonista(nome, idade);
        titulos.add(new Filme(titulo, ano, diretor, produtora, genero, nomeAtor, duracao));
    }

    public static void cadastrarSerie(Scanner ler) {
        System.out.print("Digite o título da série: ");
        String titulo = ler.nextLine();
        System.out.print("Digite o ano de lançamento: ");
        int ano = ler.nextInt();
        ler.nextLine();
        System.out.print("Digite o nome do diretor: ");
        String diretor = ler.nextLine();
        System.out.print("Digite o nome da produtora: ");
        String produtora = ler.nextLine();
        System.out.print("Digite o gênero: ");
        String genero = ler.nextLine();
        System.out.print("Digite o número de temporadas: ");
        int temporadas = ler.nextInt();
        ler.nextLine();
        System.out.print("Digite o número de episódios: ");
        int episodios = ler.nextInt();
        ler.nextLine();
        System.out.print("Qual a duração de cada episódio em minutos? ");
        float duracao = ler.nextFloat();
        ler.nextLine();
        System.out.print("Digite o nome do ator que interpreta o protagonista da série: ");
        String nome = ler.nextLine();
        System.out.print("Digite a idade do ator que interpreta o protagonista da série: ");
        int idade = ler.nextInt();
        ler.nextLine();
        Protagonista nomeAtor = new Protagonista(nome, idade);
        titulos1.add(new Serie(titulo, ano, diretor, produtora, genero, nomeAtor, temporadas, episodios, duracao));

    }
    
    public static void cadastrarFilme(Scanner ler, String titulo, int anoLanc, String diretor, String produtora, String genero, Protagonista ator, float duracao2) {
        titulos.add(new Filme(titulo, anoLanc, diretor, produtora, genero, ator, duracao2));
    }
    
    public static void cadastrarSerie(Scanner ler, String titulo, int anoLanc, String diretor, String produtora, String genero, Protagonista ator, int episodios, int temporadas, float duracao) {
        titulos1.add(new Serie(titulo, anoLanc, diretor, produtora, genero, ator, temporadas, episodios, duracao));

    }
}