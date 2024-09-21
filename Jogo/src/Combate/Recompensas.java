package Combate;

import Personagens.Jogador;
import Armamento.*;
import Personagens.GerenciadorPersonagem;

public class Recompensas {
    private GerenciarArmamento gerenciarArmamento = new GerenciarArmamento();
    private GerenciadorPersonagem gerenciadorPersonagem = new GerenciadorPersonagem(); 

    public void darPremioPrimeiroCombate(Jogador jogador) {
        System.out.println("\nParabéns! Você subiu de nível!");
        gerenciadorPersonagem.distribuirPontosExtras(jogador, 5); 

        jogador.setVida(jogador.getVida() + 15);
        jogador.recuperarMana(15);
        System.out.println("\nSua vida foi aumentada em 15 pontos. Sua mana foi recuperada em 20 pontos.");
        System.out.println("\nEscolha uma nova arma:");
        Arma novaArma = gerenciarArmamento.escolherArma();
        jogador.equiparArma(novaArma);
    }

    public void darPremioSegundoCombate(Jogador jogador) {
        System.out.println("Você subiu dois níveis!");
        gerenciadorPersonagem.distribuirPontosExtras(jogador, 10); 
    
        jogador.setVida(jogador.getVida() + 25);
        jogador.recuperarMana(20);
        System.out.println("Sua vida foi aumentada em 25 pontos. Sua mana foi recuperada em 30 pontos.");
        System.out.println("Escolha uma nova armadura:");
    
        Armadura novaArmadura = gerenciarArmamento.escolherArmadura(jogador);  // Passar o jogador aqui
        jogador.equiparArmadura(novaArmadura);
    }    

    public void darPremioFinal(Jogador jogador) {
        System.out.println("\nParabéns! Você derrotou todos os inimigos e venceu o jogo!");
        jogador.recuperarMana(50);
    }
}
