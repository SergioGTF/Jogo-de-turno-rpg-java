package Personagens;

import java.util.Random;

public class Adversario extends Personagem {
    private Random random = new Random();

    public Adversario(String nome, int vida, int forca, int constituicao, int agilidade, int destreza) {
        super(nome, vida, forca, constituicao, agilidade, destreza);
    }

    @Override
    public void realizarAcao(Personagem jogador) {
        int escolha = random.nextInt(4); // Agora há mais ações
        switch (escolha) {
            case 0:
                int dano = calcularDano();
                jogador.receberDano(dano);
                System.out.println(getNome() + " atacou " + jogador.getNome());
                break;
            case 1:
                System.out.println(getNome() + " defendeu.");
                break;
            case 2:
                if (getVida() < (getConstituicao() * 5)) { // Se vida abaixo de 50% usa poção
                    int cura = rolarD6() + rolarD6() + rolarD6();
                    setVida(getVida() + cura);
                    System.out.println(getNome() + " usou uma poção e recuperou " + cura + " pontos de vida.");
                } else {
                    realizarAcao(jogador); // Caso contrário, ataca de novo
                }
                break;
            case 3:
                int ataquePoderoso = calcularDano() + rolarD6(); // Ataque especial, com bônus
                jogador.receberDano(ataquePoderoso);
                System.out.println(getNome() + " usou um ataque especial e causou " + ataquePoderoso + " de dano!");
                break;
        }
    }
}

