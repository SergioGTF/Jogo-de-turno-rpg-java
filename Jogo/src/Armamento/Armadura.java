package Armamento;

// Classe que representa uma armadura
public class Armadura {
    // Nome da armadura
    private String nome;
    
    // Quantidade de defesa que a armadura proporciona
    private int defesa;

    // Construtor da classe Armadura, inicializa os atributos nome e defesa
    public Armadura(String nome, int defesa) {
        this.nome = nome;
        this.defesa = defesa;
    }

    // Retorna a defesa da armadura
    public int getDefesa() {
        return defesa;
    }

    // Retorna o nome da armadura
    public String getNome() {
        return nome;
    }
}
