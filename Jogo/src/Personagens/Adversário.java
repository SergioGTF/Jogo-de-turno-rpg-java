package Personagens;

import java.util.Random;

public class Adversário extends Personagem {
    private Random random = new Random();

    public Adversário(String nome, int vida, int forca, int constituicao, int agilidade, int destreza) {
        super(nome, vida, forca, constituicao, agilidade, destreza);
    }

    @Override
    public void realizarAcao(Personagem jogador){
        int escolha = random.nextInt(4);

        switch (escolha) {
            case 0:
                
                break;
        
            default:
                break;
        }
    }
}
