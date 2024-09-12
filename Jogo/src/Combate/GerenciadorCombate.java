package Combate;

import Personagens.*;
import java.util.List;

public class GerenciadorCombate {
    private Recompensas recompensas = new Recompensas(); 

    public void iniciarCombate(Jogador jogador, List<Adversario> adversarios) {
        for (int i = 0; i < adversarios.size(); i++) {
            Adversario adversario = adversarios.get(i);
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
                    exibirDerrota(jogador);
                    return;
                }
            }

            if (!jogador.estaVivo()) {
                System.out.println("Fim de jogo. Você foi derrotado.");
                exibirDerrota(jogador);
                return;
            }

            if (i == 0) {  
                recompensas.darPremioPrimeiroCombate(jogador);
            } else if (i == 1) {  
                recompensas.darPremioSegundoCombate(jogador);
            }
        }

        if (jogador.estaVivo()) {
            Adversario inimigoFinal = new GerenciadorInimigos().criarInimigoFinal();
            System.out.println("Você chegou ao final da sua jornada. O inimigo final, " + inimigoFinal.getNome() + ", o aguarda.");

            while (jogador.estaVivo() && inimigoFinal.estaVivo()) {
                realizarTurno(jogador, inimigoFinal);
                if (!inimigoFinal.estaVivo()) {
                    System.out.println(jogador.getNome() + " derrotou o inimigo final, " + inimigoFinal.getNome() + "!");
                    break;
                }

                realizarTurno(inimigoFinal, jogador);
                if (!jogador.estaVivo()) {
                    System.out.println(inimigoFinal.getNome() + " venceu!");
                    exibirDerrota(jogador);
                    return;
                }
            }

            if (jogador.estaVivo()) {
                recompensas.darPremioFinal(jogador);
                exibirVitoria(jogador);
            }
        }
    }

    private void realizarTurno(Personagem atacante, Personagem defensor) {
        atacante.realizarAcao(defensor);
    }

    private void exibirVitoria(Jogador jogador) {
        new TelaFinal().exibirVitoria(jogador);
    }

    private void exibirDerrota(Jogador jogador) {
        new TelaFinal().exibirDerrota(jogador);
    }
}
