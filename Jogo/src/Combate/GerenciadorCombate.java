package Combate;

import java.util.List;

import Personagens.*;

public class GerenciadorCombate {
    public void iniciarCombate(Jogador jogador, List<Adversario> adversarios) {
        for (Adversario adversario : adversarios) {
            System.out.println("Combate entre " + jogador.getNome() + " e " + adversario.getNome() + " começou!");

            while (jogador.estaVivo() && adversario.estaVivo()) {
                realizarTurno(jogador, adversario);
                if (!adversario.estaVivo()) {
                    System.out.println(jogador.getNome() + " venceu o combate contra " + adversario.getNome() + "!");
                    break;
                }

                realizarTurno(adversario, jogador);
                if (!jogador.estaVivo()) {
                    System.out.println(adversario.getNome() + " venceu!");
                    break;
                }
            }

            if (!jogador.estaVivo()) {
                System.out.println("Fim de jogo. Você foi derrotado.");
                break;
            }
        }

        if (jogador.estaVivo()) {
            System.out.println(jogador.getNome() + " sobreviveu a todos os combates!");
        }
    }

    private void realizarTurno(Personagem atacante, Personagem defensor) {
        atacante.realizarAcao(defensor);
    }
}
