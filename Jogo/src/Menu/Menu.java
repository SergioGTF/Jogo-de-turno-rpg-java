package Menu;

import java.util.InputMismatchException;
import java.util.Scanner;
import Personagens.*;
import Combate.*;

public class Menu {
    private Scanner scanner = new Scanner(System.in); // Scanner para capturar entradas do usuário

    // Exibe o menu principal do jogo
    public void exibirMenu() {
        while (true) { // Laço infinito para manter o menu ativo até o jogador decidir sair
            System.out.println("\n");
            // Imprime o título do jogo em estilo ASCII
            System.out.println("\n");
            System.out.println("        JJJJJJJJJJ      RRRRRRRRRRRRRRRR      PPPPPPPPPPPPPPPP      GGGGGGGGGGGGGGGGG");
            System.out.println("        J::::::::J      R::::::::::::::::R    P::::::::::::::::P   G::::::::::::::::G");
            System.out.println("        J::::::::J      R::::::RRRRRR:::::R   P::::::PPPPPP:::::P  G::::::::::::::::G");
            System.out.println("        J::::::::J      RR:::::R     R:::::R  PP:::::P     P:::::P G:::::GGGGGGGGGGGG");
            System.out
                    .println("         J:::::::J        R::::R     R:::::R    P::::P     P:::::P G:::::G            ");
            System.out
                    .println("         J:::::::J        R::::R     R:::::R    P::::P     P:::::P G:::::G            ");
            System.out
                    .println("         J:::::::J        R::::RRRRRR:::::R     P::::PPPPPP:::::P  G:::::G    GGGGGGG ");
            System.out
                    .println("         J:::::::J        R:::::::::::::RR      P:::::::::::::PP   G:::::G    G:::::G ");
            System.out
                    .println("JJJJJJJ  J:::::::J        R::::RRRRRR:::::R     P::::PPPPPPPPP     G:::::G    G:::::G ");
            System.out
                    .println("J:::::J  J:::::::J        R::::R     R:::::R    P::::P             G:::::G      G:::G ");
            System.out
                    .println("J:::::J  J:::::::J        R::::R     R:::::R    P::::P             G:::::G      G:::G ");
            System.out
                    .println("J::::::J J:::::::J        R::::R     R:::::R    P::::P              G:::::GGGGGG::::G ");
            System.out.println("J:::::::J:::::::J       RR:::::R     R:::::R  PP::::::PP             G:::::::::::::G ");
            System.out.println(" J:::::::::::::J        R::::::R     R:::::R  P::::::::P              GG:::::::::::G ");
            System.out.println("  JJ:::::::::JJ         R::::::R     R:::::R  P::::::::P                GGG::::GGGGG ");
            System.out.println("    JJJJJJJJJ           RRRRRRRR     RRRRRRR  PPPPPPPPPP                   GGGGGGG   ");

            // Menu de opções para o jogador
            System.out.println("\nBem-vindo ao JRPG de Combate!\n");
            System.out.println("1 - Iniciar Jogo");
            System.out.println("2 - Sair");
            System.out.print("\nEscolha uma opção: ");

            int escolha = -1;
            try {
                escolha = scanner.nextInt(); // Captura a escolha do jogador
                scanner.nextLine(); // Limpa o buffer do scanner
            } catch (InputMismatchException e) {
                System.out.println("\nErro: Entrada inválida. Por favor, insira um número.");
                scanner.nextLine(); // Limpa o buffer em caso de erro
                continue; // Retorna ao início do loop
            }

            // Executa a ação baseada na escolha do jogador
            switch (escolha) {
                case 1:
                    exibirHistoria(); // Exibe a história do jogo
                    break;
                case 2:
                    System.out.println("\nSaindo do jogo...");
                    System.exit(0); // Encerra o programa
                default:
                    System.out.println("\nOpção inválida, tente novamente."); // Trata entradas inválidas
            }
        }
    }

    // Exibe a introdução do jogo e solicita a escolha do caminho pelo jogador
    private void exibirHistoria() {
        System.out.println("\nVocê é um guerreiro solitário em um mundo sombrio e caótico...");
        System.out.println(
                "Após um portal se abrir acima da cidade, monstros tomaram conta das terras, e você é o único capaz de restaurar a paz.");
        System.out.println("Você deve escolher um caminho para iniciar sua jornada.");

        // Apresenta as opções de caminho para o jogador
        System.out.println("\nEscolha seu caminho:\n");
        System.out.println("1 - Floresta Sombria");
        System.out.println("2 - Montanhas Geladas");
        System.out.println("3 - Deserto Ardente\n");

        int caminhoEscolhido = -1;
        try {
            caminhoEscolhido = scanner.nextInt(); // Captura a escolha do caminho
            scanner.nextLine(); // Limpa o buffer do scanner
        } catch (InputMismatchException e) {
            System.out.println("\nErro: Entrada inválida. Por favor, insira um número.");
            scanner.nextLine();
            return; // Retorna ao menu principal em caso de erro
        }

        iniciarJogo(caminhoEscolhido); // Inicia o jogo com o caminho escolhido
    }

    // Inicia o jogo com base no caminho escolhido
    private void iniciarJogo(int caminhoEscolhido) {
        GerenciadorPersonagem gerenciadorPersonagem = new GerenciadorPersonagem(); // Gerenciador de personagens
        GerenciadorCombate gerenciadorCombate = new GerenciadorCombate(); // Gerenciador de combates

        Jogador jogador = gerenciadorPersonagem.criarJogador(); // Cria o jogador

        // Inicia o combate com base no caminho escolhido
        gerenciadorCombate.iniciarCombate(jogador, caminhoEscolhido);
    }
}
