package Personagens;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Magia.*;

public class Jogador extends Personagem {
    private int poçõesRestantes = 3;
    private int mana = 100;
    private int manaMaxima;
    private int vidaMaxima;
    private List<Magia> magias = new ArrayList<>();
    private Scanner entrada = new Scanner(System.in);

    public Jogador(String nome, int vida, int forca, int constituicao, int agilidade, int destreza) {
        super(nome, vida, forca, constituicao, agilidade, destreza);
        this.manaMaxima = 200;
        this.vidaMaxima = vida;
        inicializarMagias();
    }

    public int getMana() {
        return mana;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setMana(int mana) {
        this.mana = Math.min(mana, manaMaxima);
    }

    public void recuperarMana(int quantidade) {
        this.mana = Math.min(this.mana + quantidade, manaMaxima);
        exibirMensagemRecuperacaoMana(quantidade);
    }

    private void exibirMensagemRecuperacaoMana(int quantidade) {
        System.out.printf("\nVocê recuperou %d de mana. Mana atual: %d%n", quantidade, this.mana);
    }

    public void regenerarManaPassivamente() {
        int regeneracao = 5;
        this.mana = Math.min(this.mana + regeneracao, manaMaxima);
        System.out.printf("\nVocê regenerou %d pontos de mana. Mana atual: %d%n", regeneracao, this.mana);
    }

    private void inicializarMagias() {
        magias.add(new Magia("Bola de Fogo", 20, "D", 10));
        magias.add(new Magia("Raio", 25, "C", 15));
        magias.add(new Magia("Tornado", 30, "B", 20));
        magias.add(new Magia("Terremoto", 35, "A", 25));
        magias.add(new Magia("Explosão Estelar", 45, "S", 30));
        magias.add(new Magia("Supernova", 60, "SS", 40));
        magias.add(new Magia("Cadeirada do Datena", 60, "S", 50));
    }

    public void usarMagia(Personagem adversario) {
        mostrarManaAtual();
        int escolha = escolherMagia();

        if (escolha >= 0) {
            Magia magiaEscolhida = magias.get(escolha);
            if (this.mana >= magiaEscolhida.getCusto()) {
                magiaEscolhida.usarMagia(adversario);
                this.mana -= magiaEscolhida.getCusto();
                System.out.printf("\nMana restante: %d%n", this.mana);
            } else {
                System.out.println("\nMana insuficiente para lançar esta magia!");
            }
        }
    }

    private void mostrarManaAtual() {
        System.out.printf("\nMana atual: %d%n", this.mana);
    }

    private int escolherMagia() {
        System.out.println("\nEscolha uma magia para usar:");
        for (int i = 0; i < magias.size(); i++) {
            Magia magia = magias.get(i);
            System.out.printf("%d - %s (Rank: %s, Custo: %d mana)%n", (i + 1), magia.getNome(), magia.getRank(),
                    magia.getCusto());
        }
        int escolha;
        do {
            escolha = entrada.nextInt() - 1; // Ajusta para índice de 0
            if (escolha < 0 || escolha >= magias.size()) {
                System.out.println("\nEscolha inválida. Tente novamente.");
            }
        } while (escolha < 0 || escolha >= magias.size());
        return escolha;
    }

    @Override
    public void realizarAcao(Personagem adversario) {
        System.out.println("\nEscolha sua ação: ");
        System.out.println("1 - Atacar | 2 - Defender | 3 - Usar poção | 4 - Usar magia");
        int escolha = entrada.nextInt();
        switch (escolha) {
            case 1:
                int dano = calcularDano();
                adversario.receberDano(dano);
                break;
            case 2:
                System.out.println(getNome() + " defendeu, defesa aumentada por um turno.");
                break;
            case 3:
                usarPocao();
                break;
            case 4:
                usarMagia(adversario);
                break;
            default:
                System.out.println("\nEscolha inválida.");
                break;
        }
    }

    private void usarPocao() {
        if (poçõesRestantes > 0) {
            int cura = rolarD6() + rolarD6() + rolarD6();
            int novaVida = Math.min(getVida() + cura, vidaMaxima); 
            int vidaCurada = novaVida - getVida();
            setVida(novaVida);
            poçõesRestantes--;
            System.out.printf("%s usou uma poção e recuperou %d pontos de vida.%n", getNome(), vidaCurada);
            System.out.println("Poções restantes: " + poçõesRestantes);
        } else {
            System.out.println("\nVocê não tem mais poções disponíveis.");
        }
    }

    public void resetarPocoes() {
        poçõesRestantes = 3;
    }
}
