package Personagens;

public class Arma {
    private String nome;
    private int dano;
    private String categoria; // pesada ou leve

    public Arma(String nome, int dano, String categoria) {
        this.nome = nome;
        this.dano = dano;
        this.categoria = categoria;
    }

    public int getDano() {
        return dano;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }
}


