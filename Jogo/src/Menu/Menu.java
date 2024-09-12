package Menu;

import java.util.Scanner;
import java.util.List;
import Personagens.*;
import Combate.*;

public class Menu {
    private Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        while (true) {
            System.out.println("Bem-vindo ao RPG de Combate!");
            System.out.println("1 - Iniciar Jogo");
            System.out.println("2 - Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    exibirHistoria();
                    break;
                case 2:
                    System.out.println("Saindo do jogo...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    private void exibirHistoria() {
        System.out.println("Você é um guerreiro solitário em um mundo sombrio e caótico...");
        System.out.println("Monstros tomaram conta das terras e você é o único capaz de restaurar a paz.");
        System.out.println("Você deve escolher um caminho para iniciar sua jornada.");

        System.out.println("\nEscolha seu caminho:");
        System.out.println("1 - Floresta Sombria");
        System.out.println("2 - Montanhas Geladas");
        System.out.println("3 - Deserto Ardente");

        int caminhoEscolhido = scanner.nextInt();
        scanner.nextLine(); 
        iniciarJogo(caminhoEscolhido);
    }

    private void iniciarJogo(int caminhoEscolhido) {
        GerenciadorPersonagem gerenciadorPersonagem = new GerenciadorPersonagem();
        GerenciadorInimigos gerenciadorInimigos = new GerenciadorInimigos();
        GerenciadorCombate gerenciadorCombate = new GerenciadorCombate();

        Jogador jogador = gerenciadorPersonagem.criarJogador();

        List<Adversario> inimigos = gerenciadorInimigos.criarInimigosPorCaminho(caminhoEscolhido);

        gerenciadorCombate.iniciarCombate(jogador, inimigos);

        Adversario inimigoFinal = gerenciadorInimigos.criarInimigoFinal();
        System.out.println("Você chegou ao final da sua jornada. O inimigo final o aguarda.");
        gerenciadorCombate.iniciarCombate(jogador, List.of(inimigoFinal));
    }
}
