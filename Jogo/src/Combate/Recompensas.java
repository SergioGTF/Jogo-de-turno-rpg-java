package Combate;

import Personagens.Jogador;
import Armamento.*;

public class Recompensas {
    private GerenciarArmamento gerenciarArmamento = new GerenciarArmamento();

    public void darPremioPrimeiroCombate(Jogador jogador) {
        System.out.println("\nParabéns! Você subiu de nível!");
        jogador.setVida(jogador.getVida() + 20);
        jogador.recuperarMana(20);
        System.out.println("\nSua vida foi aumentada em 20 pontos. Sua mana foi recuperada em 20 pontos.");
        System.out.println("\nEscolha uma nova arma:");
        Arma novaArma = gerenciarArmamento.escolherArma();
        jogador.equiparArma(novaArma);
    }

    public void darPremioSegundoCombate(Jogador jogador) {
        System.out.println("Você subiu dois níveis!");
        jogador.setVida(jogador.getVida() + 40);
        jogador.recuperarMana(30);
        System.out.println("Sua vida foi aumentada em 40 pontos. Sua mana foi recuperada em 30 pontos.");
        System.out.println("Escolha uma nova armadura:");
        Armadura novaArmadura = gerenciarArmamento.escolherArmadura();
        jogador.equiparArmadura(novaArmadura);
    }

    public void darPremioFinal(Jogador jogador) {
        System.out.println("\nParabéns! Você derrotou todos os inimigos e venceu o jogo!");
        jogador.recuperarMana(50);
    }
}
