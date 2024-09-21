package Personagens;

import java.util.Scanner;
import Armamento.Arma;
import Armamento.Armadura;
import Armamento.GerenciarArmamento;

public class GerenciadorPersonagem {
    private Scanner scanner = new Scanner(System.in);

    public Jogador criarJogador() {
        System.out.println("\nBem-vindo ao Jogo! Digite o nome do seu personagem:");
        String nomeJogador = scanner.nextLine();

        int pontosRestantes = 15;
        int forca = 0, constituicao = 0, agilidade = 0, destreza = 0;

        while (true) {
            System.out.println("\nVocê tem " + pontosRestantes
                    + " pontos para distribuir entre Força, Constituição, Agilidade e Destreza.");

            System.out.print("\nForça: ");
            forca = scanner.nextInt();

            System.out.print("\nConstituição: ");
            constituicao = scanner.nextInt();

            System.out.print("\nAgilidade: ");
            agilidade = scanner.nextInt();

            System.out.print("\nDestreza: ");
            destreza = scanner.nextInt();

            int totalDistribuido = forca + constituicao + agilidade + destreza;

            if (totalDistribuido == 15) {
                break;
            } else if (totalDistribuido > 15) {
                System.out.println("\nVocê distribuiu mais do que 15 pontos. Por favor, tente novamente.");
            } else {
                System.out.println("\nVocê distribuiu menos do que 15 pontos. Por favor, distribua todos os pontos.");
            }
        }

        Jogador jogador = new Jogador(nomeJogador, 100, forca, constituicao, agilidade, destreza);

        GerenciarArmamento gerenciadorEquipamento = new GerenciarArmamento();
        Arma armaEscolhida = gerenciadorEquipamento.escolherArma();
        jogador.equiparArma(armaEscolhida);

        Armadura armaduraEscolhida = gerenciadorEquipamento.escolherArmadura(jogador); 
        jogador.equiparArmadura(armaduraEscolhida);

        exibirAtributos(jogador);

        return jogador;
    }

    public void distribuirPontosExtras(Jogador jogador, int pontosExtras) {
        System.out.println("\nVocê ganhou " + pontosExtras + " pontos de atributos!");
        while (pontosExtras > 0) {
            System.out.println("\nVocê tem " + pontosExtras + " pontos restantes para distribuir.");
            System.out.println("1 - Aumentar Força");
            System.out.println("2 - Aumentar Constituição");
            System.out.println("3 - Aumentar Agilidade");
            System.out.println("4 - Aumentar Destreza");
            System.out.print("\nEscolha o atributo a aumentar: ");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    jogador.setForca(jogador.getForca() + 1);
                    System.out.println("Força aumentada!");
                    break;
                case 2:
                    jogador.setConstituicao(jogador.getConstituicao() + 1);
                    System.out.println("Constituição aumentada!");
                    break;
                case 3:
                    jogador.setAgilidade(jogador.getAgilidade() + 1);
                    System.out.println("Agilidade aumentada!");
                    break;
                case 4:
                    jogador.setDestreza(jogador.getDestreza() + 1);
                    System.out.println("Destreza aumentada!");
                    break;
                default:
                    System.out.println("Escolha inválida, tente novamente.");
                    continue;
            }
            pontosExtras--;
        }
        exibirAtributos(jogador);
    }

    private void exibirAtributos(Jogador jogador) {
        System.out.println("\nAtributos do jogador:");
        System.out.println("\nNome: " + jogador.getNome());
        System.out.println("\nVida: " + jogador.getVida() + "/" + jogador.getVidaMaxima());
        System.out.println("\nForça: " + jogador.getForca());
        System.out.println("\nConstituição: " + jogador.getConstituicao());
        System.out.println("\nAgilidade: " + jogador.getAgilidade());
        System.out.println("\nDestreza: " + jogador.getDestreza());
        System.out.println("\nMana: " + jogador.getMana());
    }
}
