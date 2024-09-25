package Personagens;

import java.util.ArrayList; // Importa a classe ArrayList para gerenciar listas dinâmicas
import java.util.List; // Importa a interface List para usar listas
import java.util.Scanner; // Importa a classe Scanner para entrada de dados

import Armamento.Arma; // Importa a classe Arma do pacote Armamento
import Armamento.Armadura; // Importa a classe Armadura do pacote Armamento
import Magia.*; // Importa todas as classes do pacote Magia

public class Jogador extends Personagem { // Classe Jogador que estende a classe Personagem
    private int nivel; // Nível do jogador
    private int poçõesRestantes = 3; // Quantidade de poções disponíveis
    private int mana = 100; // Mana atual do jogador
    private int manaMaxima; // Mana máxima que o jogador pode ter
    private int vidaMaxima; // Vida máxima do jogador
    private List<Magia> magias = new ArrayList<>(); // Lista de magias que o jogador possui
    private List<Arma> armasUsadas = new ArrayList<>(); // Lista de armas que o jogador já usou
    private List<Armadura> armadurasUsadas = new ArrayList<>(); // Lista de armaduras que o jogador já usou
    private Scanner entrada = new Scanner(System.in); // Scanner para entrada de dados do jogador

    public Jogador(String nome, int vida, int forca, int constituicao, int agilidade, int destreza) {
        super(nome, vida, forca, constituicao, agilidade, destreza); // Chama o construtor da classe pai
        this.manaMaxima = 200; // Define mana máxima
        this.vidaMaxima = vida; // Define vida máxima com o valor passado
        this.nivel = 1; // Inicializa o nível do jogador como 1
        inicializarMagias(); // Inicializa as magias disponíveis para o jogador
    }

    // Métodos getters para acessar atributos privados
    public int getMana() {
        return mana; // Retorna a mana atual
    }

    public int getVidaMaxima() {
        return vidaMaxima; // Retorna a vida máxima
    }

    public Arma getArma() {
        return super.getArma(); // Retorna a arma equipada do personagem pai
    }

    public Armadura getArmadura() {
        return super.getArmadura(); // Retorna a armadura equipada do personagem pai
    }

    public void setMana(int mana) {
        this.mana = Math.min(mana, manaMaxima); // Define a mana, garantindo que não ultrapasse o máximo
    }

    public int getNivel() {
        return nivel; // Retorna o nível do jogador
    }

    public void setNivel(int nivel) {
        this.nivel = nivel; // Define o nível do jogador
    }

    public List<Arma> getArmasUsadas() {
        return armasUsadas; // Retorna a lista de armas usadas
    }

    public List<Armadura> getArmadurasUsadas() {
        return armadurasUsadas; // Retorna a lista de armaduras usadas
    }

    public void recuperarMana(int quantidade) {
        this.mana = Math.min(this.mana + quantidade, manaMaxima); // Recupera mana, sem ultrapassar o máximo
        exibirMensagemRecuperacaoMana(quantidade); // Exibe mensagem de recuperação
    }

    private void exibirMensagemRecuperacaoMana(int quantidade) {
        System.out.printf("\nVocê recuperou %d de mana. Mana atual: %d%n", quantidade, this.mana); // Mensagem de mana
                                                                                                   // recuperada
    }

    public void regenerarManaPassivamente() {
        int regeneracao = 5; // Valor de regeneração de mana
        this.mana = Math.min(this.mana + regeneracao, manaMaxima); // Regenera mana, sem ultrapassar o máximo
        System.out.printf("\nVocê regenerou %d pontos de mana. Mana atual: %d%n", regeneracao, this.mana); // Mensagem
                                                                                                           // de
                                                                                                           // regeneração
    }

    public void adicionarArmaUsada(Arma arma) {
        armasUsadas.add(arma); // Adiciona a arma usada à lista
    }

    public void adicionarArmaduraUsada(Armadura armadura) {
        armadurasUsadas.add(armadura); // Adiciona a armadura usada à lista
    }

    private void inicializarMagias() {
        // Adiciona magias à lista de magias do jogador
        magias.add(new Magia("Bola de Fogo", 20, "D", 10));
        magias.add(new Magia("Raio", 25, "C", 15));
        magias.add(new Magia("Tornado", 30, "B", 20));
        magias.add(new Magia("Terremoto", 35, "A", 25));
        magias.add(new Magia("Explosão Estelar", 45, "S", 30));
        magias.add(new Magia("Supernova", 60, "SS", 40));
        magias.add(new Magia("Cadeirada do Datena", 60, "S", 50));
    }

    public void usarMagia(Personagem adversario) {
        mostrarManaAtual(); // Mostra a mana atual do jogador
        int escolha = escolherMagia(); // Permite ao jogador escolher uma magia

        if (escolha >= 0) {
            Magia magiaEscolhida = magias.get(escolha); // Obtém a magia escolhida
            if (this.mana >= magiaEscolhida.getCusto()) { // Verifica se há mana suficiente
                magiaEscolhida.usarMagia(adversario); // Usa a magia no adversário
                this.mana -= magiaEscolhida.getCusto(); // Deduz o custo da magia da mana
                System.out.printf("\nMana restante: %d%n", this.mana); // Mostra mana restante
            } else {
                System.out.println("\nMana insuficiente para lançar esta magia!"); // Mensagem de erro
            }
        }
    }

    private void mostrarManaAtual() {
        System.out.printf("\nMana atual: %d%n", this.mana); // Exibe a mana atual do jogador
    }

    private int escolherMagia() {
        // Permite ao jogador escolher uma magia a ser usada
        System.out.println("\nEscolha uma magia para usar:");
        for (int i = 0; i < magias.size(); i++) { // Exibe as magias disponíveis
            Magia magia = magias.get(i);
            System.out.printf("%d - %s (Rank: %s, Custo: %d mana)%n", (i + 1), magia.getNome(), magia.getRank(),
                    magia.getCusto());
        }
        int escolha;
        do {
            escolha = entrada.nextInt() - 1; // Lê a escolha do jogador
            if (escolha < 0 || escolha >= magias.size()) { // Verifica se a escolha é válida
                System.out.println("\nEscolha inválida. Tente novamente.");
            }
        } while (escolha < 0 || escolha >= magias.size()); // Repete até uma escolha válida
        return escolha; // Retorna a escolha válida
    }

    @Override
    public void realizarAcao(Personagem adversario) {
        // Permite ao jogador realizar uma ação no combate
        System.out.println("\nEscolha sua ação: ");
        System.out.println("1 - Atacar | 2 - Defender | 3 - Usar poção | 4 - Usar magia");
        int escolha = entrada.nextInt(); // Lê a escolha do jogador
        switch (escolha) {
            case 1:
                int dano = calcularDano(); // Calcula o dano do ataque
                adversario.receberDano(dano); // Aplica dano ao adversário
                break;
            case 2:
                System.out.println(getNome() + " defendeu, defesa aumentada por um turno."); // Mensagem de defesa
                break;
            case 3:
                usarPocao(); // Usa uma poção
                break;
            case 4:
                usarMagia(adversario); // Usa uma magia no adversário
                break;
            default:
                System.out.println("\nEscolha inválida."); // Mensagem de erro
                break;
        }
    }

    private void usarPocao() {
        // Lógica para usar uma poção
        if (poçõesRestantes > 0) { // Verifica se há poções disponíveis
            int cura = rolarD6() + rolarD6() + rolarD6(); // Rola 3 dados de 6 lados para cura
            int novaVida = Math.min(getVida() + cura, vidaMaxima); // Calcula nova vida
            int vidaCurada = novaVida - getVida(); // Calcula vida curada
            setVida(novaVida); // Atualiza a vida do jogador
            poçõesRestantes--; // Diminui o número de poções restantes
            System.out.printf("%s usou uma poção e recuperou %d pontos de vida.%n", getNome(), vidaCurada); // Mensagem
                                                                                                            // de cura
            System.out.println("Poções restantes: " + poçõesRestantes); // Exibe poções restantes
        } else {
            System.out.println("\nVocê não tem mais poções disponíveis."); // Mensagem de erro
        }
    }

    public void resetarPocoes() {
        poçõesRestantes = 3; // Restaura o número de poções para 3
    }

    @Override
    public void equiparArma(Arma arma) {
        super.equiparArma(arma); // Equipar arma na classe pai
        adicionarArmaUsada(arma); // Adiciona a arma à lista de armas usadas
    }

    @Override
    public void equiparArmadura(Armadura armadura) {
        super.equiparArmadura(armadura); // Equipar armadura na classe pai
        adicionarArmaduraUsada(armadura); // Adiciona a armadura à lista de armaduras usadas
    }
}
