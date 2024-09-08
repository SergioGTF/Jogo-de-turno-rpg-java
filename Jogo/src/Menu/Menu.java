package Menu;

import java.util.Scanner;
import java.util.List;

import Personagens.*;
import Combate.*;

public class Menu {
    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Bem-vindo ao RPG de Combate!");
            System.out.println("1 - Iniciar Jogo");
            System.out.println("2 - História");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    GerenciadorPersonagem gerenciadorPersonagem = new GerenciadorPersonagem();
                    GerenciadorInimigos gerenciadorInimigos = new GerenciadorInimigos();
                    GerenciadorCombate gerenciadorCombate = new GerenciadorCombate();

                    // Criar jogador e escolher arma
                    Jogador jogador = gerenciadorPersonagem.criarJogador();

                    // Criar inimigos
                    List<Adversario> inimigos = gerenciadorInimigos.criarInimigos();

                    // Iniciar o combate
                    gerenciadorCombate.iniciarCombate(jogador, inimigos);
                    break;
                case 2:
                    exibirHistoria();
                    break;
                case 3:
                    System.out.println("Saindo do jogo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    private void exibirHistoria() {
        System.out.println(
                "História: Falta pensar em uma");
    }
}
