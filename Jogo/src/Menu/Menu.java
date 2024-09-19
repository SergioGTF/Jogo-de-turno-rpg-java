package Menu;

import java.util.Scanner;
import Personagens.*;
import Combate.*;

public class Menu {
    private Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        while (true) {
        System.out.println("\n");
        System.out.println("        JJJJJJJJJJ      RRRRRRRRRRRRRRRR      PPPPPPPPPPPPPPPP      GGGGGGGGGGGGGGGGG");
        System.out.println("        J::::::::J      R::::::::::::::::R    P::::::::::::::::P   G::::::::::::::::G");
        System.out.println("        J::::::::J      R::::::RRRRRR:::::R   P::::::PPPPPP:::::P  G::::::::::::::::G");
        System.out.println("        J::::::::J      RR:::::R     R:::::R  PP:::::P     P:::::P G:::::GGGGGGGGGGGG");
        System.out.println("         J:::::::J        R::::R     R:::::R    P::::P     P:::::P G:::::G            ");
        System.out.println("         J:::::::J        R::::R     R:::::R    P::::P     P:::::P G:::::G            ");
        System.out.println("         J:::::::J        R::::RRRRRR:::::R     P::::PPPPPP:::::P  G:::::G    GGGGGGG ");
        System.out.println("         J:::::::J        R:::::::::::::RR      P:::::::::::::PP   G:::::G    G:::::G ");
        System.out.println("JJJJJJJ  J:::::::J        R::::RRRRRR:::::R     P::::PPPPPPPPP     G:::::G    G:::::G ");
        System.out.println("J:::::J  J:::::::J        R::::R     R:::::R    P::::P             G:::::G      G:::G ");
        System.out.println("J:::::J  J:::::::J        R::::R     R:::::R    P::::P             G:::::G      G:::G ");
        System.out.println("J::::::J J:::::::J        R::::R     R:::::R    P::::P              G:::::GGGGGG::::G ");
        System.out.println("J:::::::J:::::::J       RR:::::R     R:::::R  PP::::::PP             G:::::::::::::G ");
        System.out.println(" J:::::::::::::J        R::::::R     R:::::R  P::::::::P              GG:::::::::::G ");
        System.out.println("  JJ:::::::::JJ         R::::::R     R:::::R  P::::::::P                GGG::::GGGGG ");
        System.out.println("    JJJJJJJJJ           RRRRRRRR     RRRRRRR  PPPPPPPPPP                   GGGGGGG   ");

            System.out.println("\nBem-vindo ao JRPG de Combate!\n");
            System.out.println("1 - Iniciar Jogo");
            System.out.println("2 - Sair");
            System.out.print("\nEscolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    exibirHistoria();
                    break;
                case 2:
                    System.out.println("\nSaindo do jogo...");
                    System.exit(0);
                default:
                    System.out.println("\nOpção inválida, tente novamente.");
            }
        }
    }

    private void exibirHistoria() {
        System.out.println("\nVocê é um guerreiro solitário em um mundo sombrio e caótico...");
        System.out.println("Monstros tomaram conta das terras e você é o único capaz de restaurar a paz.");
        System.out.println("Você deve escolher um caminho para iniciar sua jornada.");

        System.out.println("\nEscolha seu caminho:\n");
        System.out.println("1 - Floresta Sombria");
        System.out.println("2 - Montanhas Geladas");
        System.out.println("3 - Deserto Ardente\n");

        int caminhoEscolhido = scanner.nextInt();
        scanner.nextLine();
        iniciarJogo(caminhoEscolhido);
    }

    private void iniciarJogo(int caminhoEscolhido) {
        GerenciadorPersonagem gerenciadorPersonagem = new GerenciadorPersonagem();
        GerenciadorCombate gerenciadorCombate = new GerenciadorCombate();

        Jogador jogador = gerenciadorPersonagem.criarJogador();

        gerenciadorCombate.iniciarCombate(jogador, caminhoEscolhido);
    }
}
