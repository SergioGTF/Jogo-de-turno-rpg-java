package Combate;

import Personagens.Jogador;

public class TelaFinal {
    public void exibirVitoria(Jogador jogador) {
        System.out.println("\nParabéns! Você venceu o jogo!");
        System.out.println("\nStatus final do jogador:");
        System.out.println("\nNome: " + jogador.getNome());
        System.out.println("\nVida: " + jogador.getVida());
        System.out.println("\nForça: " + jogador.getForca());
        System.out.println();
        System.out.println("\nFeito por: Sergio Gabriel e Pedro Monteiro");
    }

    public void exibirDerrota(Jogador jogador) {
        System.out.println("\nVocê foi derrotado...");
        System.out.println("\nTente novamente!");
    }
}
