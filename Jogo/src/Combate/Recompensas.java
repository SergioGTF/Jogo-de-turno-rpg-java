package Combate;

import Personagens.Jogador;
import Armamento.*;
import Personagens.GerenciadorPersonagem;

// Classe responsável por gerenciar as recompensas que o jogador recebe após os combates.
public class Recompensas {
    // Instâncias de GerenciarArmamento e GerenciadorPersonagem para realizar a gestão do armamento e dos atributos do jogador.
    private GerenciarArmamento gerenciarArmamento = new GerenciarArmamento();
    private GerenciadorPersonagem gerenciadorPersonagem = new GerenciadorPersonagem();

    // Método responsável por fornecer a premiação após o primeiro combate.
    public void darPremioPrimeiroCombate(Jogador jogador) {
        // Aumenta o nível do jogador em 2.
        jogador.setNivel(jogador.getNivel() + 2);
        System.out.println("\nParabéns! Você subiu para o nível " + jogador.getNivel() + "!");

        // Distribui 5 pontos extras para o jogador.
        gerenciadorPersonagem.distribuirPontosExtras(jogador, 5);

        // Aumenta a vida do jogador em 15 pontos e recupera 15 pontos de mana.
        jogador.setVida(jogador.getVida() + 15);
        jogador.recuperarMana(15);

        System.out.println("\nSua vida foi aumentada em 15 pontos. Sua mana foi recuperada em 15 pontos.");
        
        // O jogador escolhe uma nova arma após a batalha.
        System.out.println("\nEscolha uma nova arma:");
        Arma novaArma = gerenciarArmamento.escolherArma(jogador);
        jogador.equiparArma(novaArma);
    }

    // Método responsável por fornecer a premiação após o segundo combate.
    public void darPremioSegundoCombate(Jogador jogador) {
        // Aumenta o nível do jogador em 2.
        jogador.setNivel(jogador.getNivel() + 2);
        System.out.println("\nVocê subiu para o nível " + jogador.getNivel() + "!");

        // Distribui 10 pontos extras para o jogador.
        gerenciadorPersonagem.distribuirPontosExtras(jogador, 10);

        // Aumenta a vida do jogador em 25 pontos e recupera 30 pontos de mana.
        jogador.setVida(jogador.getVida() + 25);
        jogador.recuperarMana(30);

        System.out.println("\nSua vida foi aumentada em 25 pontos. Sua mana foi recuperada em 30 pontos.");
        
        // O jogador escolhe uma nova armadura após a batalha.
        System.out.println("\nEscolha uma nova armadura:");
        Armadura novaArmadura = gerenciarArmamento.escolherArmadura(jogador);
        jogador.equiparArmadura(novaArmadura);
    }

    // Método responsável por fornecer a premiação após o combate final.
    public void darPremioFinal(Jogador jogador) {
        // Aumenta o nível do jogador em 3 e exibe a mensagem de vitória.
        jogador.setNivel(jogador.getNivel() + 3);
        System.out.println("\nParabéns! Você subiu para o nível " + jogador.getNivel() + " e venceu o jogo!");

        // Recupera 50 pontos de mana do jogador como prêmio final.
        jogador.recuperarMana(50);
    }
}
