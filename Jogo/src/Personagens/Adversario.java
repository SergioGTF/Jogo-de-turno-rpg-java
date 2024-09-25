package Personagens;

import java.util.Random;

public class Adversario extends Personagem {
    private Random random = new Random(); // Gerador de números aleatórios para determinar as ações do adversário

    // Construtor da classe Adversario
    public Adversario(String nome, int vida, int forca, int constituicao, int agilidade, int destreza) {
        super(nome, vida, forca, constituicao, agilidade, destreza); // Inicializa os atributos herdados de Personagem
    }

    // Método que define as ações que o adversário pode realizar durante o combate
    @Override
    public void realizarAcao(Personagem jogador) {
        int escolha = random.nextInt(4); // Escolhe aleatoriamente uma das quatro ações possíveis
        switch (escolha) {
            case 0:
                int dano = calcularDano(); // Calcula o dano do ataque
                jogador.receberDano(dano); // O jogador recebe o dano causado
                System.out.println();
                System.out.println(getNome() + "\n atacou " + jogador.getNome());
                break;
            case 1:
                System.out.println();
                System.out.println(getNome() + "\n defendeu."); // O adversário escolhe defender
                break;
            case 2:
                if (getVida() < (getConstituicao() * 5)) { // Se a vida do adversário estiver baixa
                    int cura = rolarD6() + rolarD6() + rolarD6(); // Cura o adversário rolando 3 dados de 6 lados
                    setVida(getVida() + cura); // Adiciona a cura à vida do adversário
                    System.out.println();
                    System.out.println(getNome() + "\n usou uma poção e recuperou " + cura + " pontos de vida.");
                } else {
                    realizarAcao(jogador); // Se a vida não estiver baixa, realiza outra ação
                }
                break;
            case 3:
                int ataquePoderoso = calcularDano() + rolarD6(); // Calcula um ataque especial (dano + dado extra)
                jogador.receberDano(ataquePoderoso); // O jogador recebe o dano do ataque especial
                System.out.println();
                System.out.println(getNome() + "\n usou um ataque especial e causou " + ataquePoderoso + " de dano!");
                break;
        }
    }
}
