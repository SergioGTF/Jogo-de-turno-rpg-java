package Magia;

import Personagens.*;

public class Magia {
    private String nome;
    private int dano;
    private String rank;
    private int custoMana;

    public Magia(String nome, int dano, String rank, int custoMana) {
        this.nome = nome;
        this.dano = dano;
        this.rank = rank;
        this.custoMana = custoMana;
    }

    public String getNome() {
        return nome;
    }

    public int getDano() {
        return dano;
    }

    public String getRank() {
        return rank;
    }

    public int getCusto() {
        return custoMana;
    }

    public void usarMagia(Personagem alvo) {
        System.out.println("\nUsando magia: " + nome + " causando " + dano + " de dano!");
        alvo.receberDano(dano);
    }
}
