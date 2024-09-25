package Armamento;

// Classe que representa uma arma
public class Arma {
    // Nome da arma
    private String nome;
    
    // Dano que a arma causa
    private int dano;
    
    // Categoria da arma (leve, pesada, média, etc.)
    private String categoria;

    // Construtor da classe Arma, inicializa os atributos nome, dano e categoria
    public Arma(String nome, int dano, String categoria) {
        this.nome = nome;
        this.dano = dano;
        this.categoria = categoria;
    }

    // Retorna o dano da arma
    public int getDano() {
        return dano;
    }

    // Retorna o nome da arma
    public String getNome() {
        return nome;
    }

    // Retorna a categoria da arma
    public String getCategoria() {
        return categoria;
    }
}
