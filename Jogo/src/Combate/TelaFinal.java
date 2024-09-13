package Combate;

import Personagens.Jogador;

public class TelaFinal {
    public void exibirVitoria(Jogador jogador) {
        System.out.println("\n Parabéns! Você venceu o jogo!");
        System.out.println("\n Status final do jogador:");
        System.out.println("\n Nome: " + jogador.getNome());
        System.out.println("\n Vida: " + jogador.getVida());
        System.out.println("\n Força: " + jogador.getForca());
        System.out.println();
        System.out.println("\n Feito por: Sergio Gabriel e Pedro Monteiro");
    }

    public void exibirDerrota(Jogador jogador) {
        System.out.println("\n Você foi derrotado...");
        System.out.println("\n Tente novamente!");
    }
}
