package Personagens;

import java.util.Scanner;

import Armamento.Arma;
import Armamento.Armadura;
import Armamento.GerenciarArmamento;

public class GerenciadorPersonagem {
    private Scanner scanner = new Scanner(System.in);

    public Jogador criarJogador() {
        System.out.println("Bem-vindo ao Jogo! Digite o nome do seu personagem:");
        String nomeJogador = scanner.nextLine();

        int pontosRestantes = 15;
        int forca = 0, constituicao = 0, agilidade = 0, destreza = 0;

        while (true) {
            System.out.println("Você tem " + pontosRestantes
                    + " pontos para distribuir entre Força, Constituição, Agilidade e Destreza.");

            System.out.print("Força: ");
            forca = scanner.nextInt();

            System.out.print("Constituição: ");
            constituicao = scanner.nextInt();

            System.out.print("Agilidade: ");
            agilidade = scanner.nextInt();

            System.out.print("Destreza: ");
            destreza = scanner.nextInt();

            int totalDistribuido = forca + constituicao + agilidade + destreza;

            if (totalDistribuido == 15) {
                break;
            } else if (totalDistribuido > 15) {
                System.out.println("Você distribuiu mais do que 15 pontos. Por favor, tente novamente.");
            } else {
                System.out.println("Você distribuiu menos do que 15 pontos. Por favor, distribua todos os pontos.");
            }
        }

        Jogador jogador = new Jogador(nomeJogador, 100, forca, constituicao, agilidade, destreza);

        // Escolha de arma
        GerenciarArmamento gerenciadorEquipamento = new GerenciarArmamento();
        Arma armaEscolhida = gerenciadorEquipamento.escolherArma();
        jogador.equiparArma(armaEscolhida);

        // Escolha de armadura
        Armadura armaduraEscolhida = gerenciadorEquipamento.escolherArmadura();
        jogador.equiparArmadura(armaduraEscolhida);

        return jogador;
    }
}
