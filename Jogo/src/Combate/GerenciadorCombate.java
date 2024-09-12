package Combate;

import java.util.List;

import Personagens.*;

public class GerenciadorCombate {
    public void iniciarCombate(Jogador jogador, List<Adversario> adversarios) {
        for (Adversario adversario : adversarios) {
            System.out.println("Combate entre " + jogador.getNome() + " e " + adversario.getNome() + " começou!");
            System.out.println();

            while (jogador.estaVivo() && adversario.estaVivo()) {
                realizarTurno(jogador, adversario);
                if (!adversario.estaVivo()) {
                    System.out.println();
                    System.out.println(jogador.getNome() + " venceu o combate contra " + adversario.getNome() + "!");
                    System.out.println();
                    break;
                }

                realizarTurno(adversario, jogador);
                if (!jogador.estaVivo()) {
                    System.out.println();
                    System.out.println(adversario.getNome() + " venceu!");
                    System.out.println();
                    break;
                }
            }

            if (!jogador.estaVivo()) {
                System.out.println();
                System.out.println("Fim de jogo. Você foi derrotado.");
                System.out.println();
                break;
            }
        }

        if (jogador.estaVivo()) {
            System.out.println();
            System.out.println(jogador.getNome() + " sobreviveu a todos os combates!");
            System.out.println();
        }
    }

    private void realizarTurno(Personagem atacante, Personagem defensor) {
        atacante.realizarAcao(defensor);
    }
}
