package Personagens;

import java.util.Scanner;

public class Jogador extends Personagem {
    private int poçõesRestantes = 3;

    public Jogador(String nome, int vida, int forca, int constituicao, int agilidade, int destreza) {
        super(nome, vida, forca, constituicao, agilidade, destreza);
    }

    @Override
    public void realizarAcao(Personagem adversario) {
        Scanner entrada = new Scanner(System.in);
        System.out.println();
        System.out.println("\nEscolha sua ação: ");
        System.out.println(("\n1 - Atacar | 2 - Defender | 3 - Usar poção"));

        int escolha = entrada.nextInt();

        switch (escolha) {
            case 1:
                int dano = calcularDano();
                adversario.receberDano(dano);
                break;

            case 2:
                System.out.println(getNome() + "\n defendeu, defesa aumentada por um turno.");
                break;

            case 3:
                if (poçõesRestantes > 0) {
                    int cura = rolarD6() + rolarD6() + rolarD6();
                    setVida(getVida() + cura);
                    poçõesRestantes--;
                    System.out.println(getNome() + "\n usou uma poção e recuperou " + cura + " pontos de vida.");
                    System.out.println("\nPoções restantes: " + poçõesRestantes);
                } else {
                    System.out.println("\nVocê não tem mais poções disponíveis.");
                }
                break;
            default:
                break;
        }
    }

    public void resetarPocoes() {
        poçõesRestantes = 3;
    }
}
