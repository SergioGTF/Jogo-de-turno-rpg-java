# Jogo-de-turno-rpg-java

## Sistema de Combate JRPG

Este projeto implementa um sistema de combate em turnos inspirado em **JRPGs** (Japanese Role-Playing Games), desenvolvido em **Java** como parte da disciplina de Programação 2.

## Funcionalidades

- **Menu Inicial**: Opções para iniciar o jogo, visualizar a história ou fechar o jogo.
- **Criação de Personagem**: O jogador pode nomear seu personagem, distribuir pontos em atributos (Força, Constituição, Agilidade e Destreza) e escolher uma arma e uma armadura iniciais.
- **Sistema de Combate**: O jogo possui um combate em turnos, onde o jogador e o adversário alternam ataques. O jogador pode atacar, defender ou usar poções para recuperar HP.
- **Recompensas por Vitória**: Ao vencer um combate, o jogador recebe melhorias como pontos de atributos extras, novas armas e armaduras.
- **Progressão**: O jogador enfrenta três adversários, com dificuldade crescente, até alcançar a vitória final.

## Fluxogramas


- **Fluxograma do Jogo**

```
Início 
  |
  v
Criar Personagem
  |
  v
1º Combate
  |
  v
1º Premiação
  |
  v
2º Combate
  |
  v
2º Premiação
  |
  v
3º Combate
  |
  v
3º Premiação
  |
  v
Vitória
```

- **Criação de personagem**

```
Criação de Personagem
  |
  v
Digitar Nome
  |
  v
Distribuir Pontos
  |
  v
Escolher Arma
  |
  v
Escolher Armadura
```

- **Fluxograma de combate**
```
Combate
  |
  v
Jogador é Mais Rápido?
   /  \
Sim  Não
 |     |
 v     v
Turno Jogador    Turno Adversário
 |                |
 v                v
Turno Adversário  Turno Jogador
  |
  v
Alguém Morreu?
   /  \
Sim   Não
 |     |
 v     v
Jogador Morto?  Repetir Combate
   /  \
Sim   Não
 |     |
 v     v
Fim de Jogo  Vitória
```

## Projeto

O objetivo do projeto é desenvolver um sistema de combate em turnos que será aplicado em um jogo de JRPG. Ao iniciar o aplicativo, o jogador se depara com um menu inicial contendo as opções de começar o jogo, visualizar a história ou fechar o jogo.

Ao escolher a opção **História**, será mostrado um texto contando uma breve história sobre o mundo de fantasia e o principal motivo do personagem querer enfrentar o desafio. A opção **Começar Jogo** inicializa o jogo, que segue o fluxograma da **Figura 1**.

O jogador criará seu personagem e enfrentará três combates, onde cada vitória proporcionará recompensas. O jogo vai se tornando mais difícil à medida que o jogador avança nas lutas. Se todas as três lutas forem vencidas, uma tela de vitória será exibida; em caso de derrota, o jogador verá uma tela de derrota e retornará ao menu inicial.

## Criação de Personagem

O personagem do jogo contém os seguintes atributos:

- **Status Básicos**:
  - Nome
  - P.V. (Ponto de Vida)
- **Atributos**:
  - Força
  - Constituição
  - Agilidade
  - Destreza
- **Equipamentos**:
  - Arma
  - Armadura

### Atributos e Influências

- **Força**: Influencia no dano da arma pesada.
- **Constituição**: Aumenta a quantidade de P.V. e a defesa.
- **Agilidade**: Define a ordem dos turnos durante o combate.
- **Destreza**: Influencia no dano da arma leve.

### Armas

As armas possuem os seguintes atributos:

- **Arma**:
  - Categoria
  - Constante dano

As armas podem ser classificadas em duas categorias: **pesada** e **leve**, que influenciam o valor do dano.

- **Arma Pesada**: Dano calculado pela soma de um dado de 12 lados (d12) mais 1,5 vezes o valor da força, acrescido de um valor constante.
- **Arma Leve**: Dano calculado pela soma de dois dados de 6 lados (d6), um dado de 4 lados (d4), mais o valor da destreza e um valor constante.

### Armaduras

As armaduras possuem os seguintes atributos:

- **Armadura**:
  - Defesa

A defesa da armadura é calculada com base em um valor constante mais 1,5 vezes o valor da constituição. O ponto de vida (P.V.) é calculado pela soma de três dados de 6 lados (d6) mais o valor da constituição.

### Resumo das Características

- **P.V.** = 3d6 + Constituição
- **Arma Pesada** = K + d12 + 1,5\*Força
- **Arma Leve** = K + 2d6 + d4 + Destreza
- **Armadura** = K + 1,5\*Constituição

O jogador começa criando o personagem, distribuindo 15 pontos de atributos e escolhendo uma das três armas e armaduras iniciais disponíveis.

## Combate

Durante o combate, o personagem enfrentará um adversário, que possui os seguintes atributos:

- **Adversário**:
  - Nome
  - P.V. (Ponto de Vida)
  - Dano
  - Defesa
  - Agilidade

O P.V., defesa e agilidade do adversário são valores fixos, definidos pelo programador. O dano do adversário pode ser um valor constante ou gerado aleatoriamente.

### Turno do Jogador

O jogador terá três ações disponíveis:

- **Atacar**: O dano é calculado subtraindo a defesa do adversário do dano da arma do jogador.
- **Defender**: Dobra o valor da defesa do personagem por um turno.
- **Usar Poção**: Recupera pontos de vida (P.V.), calculados pela soma de três dados de 6 lados (3d6). O jogador tem três poções por combate.

### Turno do Adversário

O adversário segue as mesmas ações do jogador, mas suas ações são escolhidas aleatoriamente:

- 0: Atacar
- 1: Defender
- 2: Usar Poção

## Premiações

Após cada vitória, o jogador recebe uma premiação:

- **Primeira Premiação**:
  - Subir de nível (ganhar 5 pontos de atributo)
  - Aumento de P.V.
  - Escolher uma nova arma mais forte que as iniciais.
  
- **Segunda Premiação**:
  - Subir dois níveis (ganhar 10 pontos de atributo)
  - Aumento de P.V.
  - Escolher uma nova armadura mais forte que as iniciais.
  
- **Terceira Premiação**:
  - Vitória final do jogo e conclusão da história.

## Requisitos

- Desenvolvido em **Java**.
- Utiliza classes para representar personagens, armas, armaduras, poções e adversários.
- Implementação de no mínimo seis adversários, distribuídos entre os três combates.

## Possíveis Expansões

- Aventura textual com interações pré-definidas.
- Sistema de magia para adicionar novas habilidades ao personagem.
