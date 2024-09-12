package Combate;

import Personagens.*;

public class GerenciadorCombate {
    private Recompensas recompensas = new Recompensas(); 

    public void iniciarCombate(Jogador jogador, int caminhoEscolhido) {
        GerenciadorInimigos gerenciadorInimigos = new GerenciadorInimigos();
        
        Adversario adversario1 = gerenciadorInimigos.selecionarAdversarioPrimeiroCombate(caminhoEscolhido);
        realizarCombate(jogador, adversario1);
        if (jogador.estaVivo()) {
            recompensas.darPremioPrimeiroCombate(jogador);
        } else {
            exibirDerrota(jogador);
            return;
        }

        Adversario adversario2 = gerenciadorInimigos.selecionarAdversarioSegundoCombate(caminhoEscolhido);
        realizarCombate(jogador, adversario2);
        if (jogador.estaVivo()) {
            recompensas.darPremioSegundoCombate(jogador);
        } else {
            exibirDerrota(jogador);
            return;
        }

        Adversario inimigoFinal = gerenciadorInimigos.criarInimigoFinal(caminhoEscolhido);
        realizarCombate(jogador, inimigoFinal);
        if (jogador.estaVivo()) {
            recompensas.darPremioFinal(jogador);
            exibirVitoria(jogador);
        } else {
            exibirDerrota(jogador);
        }
    }

    private void realizarCombate(Jogador jogador, Adversario adversario) {
        System.out.println("O combate começou entre " + jogador.getNome() + " e " + adversario.getNome());
        while (jogador.estaVivo() && adversario.estaVivo()) {
            jogador.realizarAcao(adversario);
            if (adversario.estaVivo()) {
                adversario.realizarAcao(jogador);
            }
        }
    }

    private void exibirVitoria(Jogador jogador) {
        new TelaFinal().exibirVitoria(jogador);
    }

    private void exibirDerrota(Jogador jogador) {
        new TelaFinal().exibirDerrota(jogador);
    }
}
