package Combate;

import Personagens.Jogador;
import Armamento.*;
import Personagens.GerenciadorPersonagem;

public class Recompensas {
    private GerenciarArmamento gerenciarArmamento = new GerenciarArmamento();
    private GerenciadorPersonagem gerenciadorPersonagem = new GerenciadorPersonagem();

    public void darPremioPrimeiroCombate(Jogador jogador) {
        jogador.setNivel(jogador.getNivel() + 2);
        System.out.println("\nParabéns! Você subiu para o nível " + jogador.getNivel() + "!");

        gerenciadorPersonagem.distribuirPontosExtras(jogador, 5);
        jogador.setVida(jogador.getVida() + 15);
        jogador.recuperarMana(15);

        System.out.println("\nSua vida foi aumentada em 15 pontos. Sua mana foi recuperada em 15 pontos.");
        System.out.println("\nEscolha uma nova arma:");
        Arma novaArma = gerenciarArmamento.escolherArma(jogador);
        jogador.equiparArma(novaArma);
    }

    public void darPremioSegundoCombate(Jogador jogador) {
        jogador.setNivel(jogador.getNivel() + 2);
        System.out.println("\nVocê subiu para o nível " + jogador.getNivel() + "!");

        gerenciadorPersonagem.distribuirPontosExtras(jogador, 10);
        jogador.setVida(jogador.getVida() + 25);
        jogador.recuperarMana(30);

        System.out.println("\nSua vida foi aumentada em 25 pontos. Sua mana foi recuperada em 30 pontos.");
        System.out.println("\nEscolha uma nova armadura:");
        Armadura novaArmadura = gerenciarArmamento.escolherArmadura(jogador);
        jogador.equiparArmadura(novaArmadura);
    }

    public void darPremioFinal(Jogador jogador) {
        jogador.setNivel(jogador.getNivel() + 3);
        System.out.println("\nParabéns! Você subiu para o nível " + jogador.getNivel() + " e venceu o jogo!");
        jogador.recuperarMana(50);
    }
}
