package Magia;

import Personagens.*;

public class Magia {
    private String nome; // Nome da magia
    private int dano; // Dano que a magia causa
    private String rank; // Rank da magia (ex: D, C, B, A, S, SS)
    private int custoMana; // Custo de mana para usar a magia

    // Construtor da classe Magia
    public Magia(String nome, int dano, String rank, int custoMana) {
        this.nome = nome; // Define o nome da magia
        this.dano = dano; // Define o dano da magia
        this.rank = rank; // Define o rank da magia
        this.custoMana = custoMana; // Define o custo de mana da magia
    }

    // Retorna o nome da magia
    public String getNome() {
        return nome;
    }

    // Retorna o dano causado pela magia
    public int getDano() {
        return dano;
    }

    // Retorna o rank da magia
    public String getRank() {
        return rank;
    }

    // Retorna o custo de mana da magia
    public int getCusto() {
        return custoMana;
    }

    // Método para usar a magia em um alvo (causa dano ao alvo)
    public void usarMagia(Personagem alvo) {
        System.out.println("\nUsando magia: " + nome + " causando " + dano + " de dano!");
        alvo.receberDano(dano); // O alvo da magia recebe o dano correspondente
    }
}
