package Combate;

import Personagens.Jogador;
import Armamento.*;

public class Recompensas {
    private GerenciarArmamento gerenciarArmamento = new GerenciarArmamento();

    public void darPremioPrimeiroCombate(Jogador jogador) {
        System.out.println("Parabéns! Você subiu de nível!");
        jogador.setVida(jogador.getVida() + 20);
        System.out.println("Sua vida foi aumentada em 20 pontos.");
        System.out.println("Escolha uma nova arma:");
        Arma novaArma = gerenciarArmamento.escolherArma();
        jogador.equiparArma(novaArma);
    }

    public void darPremioSegundoCombate(Jogador jogador) {
        System.out.println("Você subiu dois níveis!");
        jogador.setVida(jogador.getVida() + 40);
        System.out.println("Sua vida foi aumentada em 40 pontos.");
        System.out.println("Escolha uma nova armadura:");
        Armadura novaArmadura = gerenciarArmamento.escolherArmadura();
        jogador.equiparArmadura(novaArmadura);
    }

    public void darPremioFinal(Jogador jogador) {
        System.out.println("Parabéns! Você derrotou todos os inimigos e venceu o jogo!");
        // Adicionar um final especial ou reiniciar o jogo.
    }
}

