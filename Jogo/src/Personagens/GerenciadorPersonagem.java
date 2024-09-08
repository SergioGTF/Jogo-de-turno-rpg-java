package Personagens;

import java.util.Scanner;

import Armamento.Arma;
import Armamento.Armadura;

public  class GerenciadorPersonagem {
    private Scanner scanner = new Scanner(System.in);

    public Jogador criarJogador() {
        System.out.println("Bem-vindo ao Jogo! Digite o nome do seu personagem:");
        String nomeJogador = scanner.nextLine();

        System.out.println("Distribua 15 pontos entre Força, Constituição, Agilidade e Destreza.");
        System.out.print("Força: ");
        int forca = scanner.nextInt();
        System.out.print("Constituição: ");
        int constituicao = scanner.nextInt();
        System.out.print("Agilidade: ");
        int agilidade = scanner.nextInt();
        System.out.print("Destreza: ");
        int destreza = scanner.nextInt();

        Jogador jogador = new Jogador(nomeJogador, 100, forca, constituicao, agilidade, destreza);
        Arma espada = new Arma("Espada Longa", 15, "pesada");
        Armadura armadura = new Armadura("Armadura de Couro", 5);
        jogador.equiparArma(espada);
        jogador.equiparArmadura(armadura);

        return jogador;
    }
}

