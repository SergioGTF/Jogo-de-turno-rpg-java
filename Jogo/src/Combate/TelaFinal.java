package Combate;

import Personagens.Jogador;

public class TelaFinal {
    public void exibirVitoria(Jogador jogador) {
        System.out.println("Parabéns! Você venceu o jogo!");
        System.out.println("Status final do jogador:");
        System.out.println("Nome: " + jogador.getNome());
        System.out.println("Vida: " + jogador.getVida());
        System.out.println("Força: " + jogador.getForca());
        // Mostrar outros atributos
    }

    public void exibirDerrota(Jogador jogador) {
        System.out.println("Você foi derrotado...");
        System.out.println("Tente novamente!");
    }
}
