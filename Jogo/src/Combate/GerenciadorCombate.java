package Combate;

import java.util.List;

import Personagens.Jogador;
import Personagens.Adversario;

public class GerenciadorCombate {
    public void iniciarCombate(Jogador jogador, List<Adversario> adversarios) {
        for (Adversario adversario : adversarios) {
            System.out.println("Combate entre " + jogador.getNome() + " e " + adversario.getNome() + " começou!");
            while (jogador.estaVivo() && adversario.estaVivo()) {
                if (jogador.getAgilidade() >= adversario.getAgilidade()) {
                    jogador.realizarAcao(adversario);
                    if (adversario.estaVivo()) {
                        adversario.realizarAcao(jogador);
                    }
                } else {
                    adversario.realizarAcao(jogador);
                    if (jogador.estaVivo()) {
                        jogador.realizarAcao(adversario);
                    }
                }
            }

            if (!jogador.estaVivo()) {
                System.out.println();
                System.out.println(adversario.getNome() + " venceu!");
                break;
            } else {
                System.out.println();
                System.out.println(jogador.getNome() + " venceu o combate contra " + adversario.getNome() + "!");
            }
        }
        if (jogador.estaVivo()) {
            System.out.println();
            System.out.println(jogador.getNome() + " sobreviveu a todos os combates!");
        }
    }
}
