# Jogo-de-turno-rpg-java

## Sistema de Combate JRPG

Este projeto implementa um sistema de combate em turnos inspirado em JRPGs (Japanese Role-Playing Games), desenvolvido em **Java** como parte da disciplina de Programação 2.

## Funcionalidades

- **Menu Inicial**: Opções para iniciar o jogo, visualizar a história ou fechar o jogo.
- **Criação de Personagem**: O jogador pode nomear seu personagem, distribuir pontos em atributos (Força, Constituição, Agilidade e Destreza) e escolher uma arma
 e uma armadura iniciais.
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


## Requisitos

- Desenvolvido em **Java**.
- Utiliza classes para representar personagens, armas, armaduras, poções e adversários.
- Implementação de no mínimo seis adversários, distribuídos entre os três combates.

## Possíveis Expansões

- Aventura textual com interações pré-definidas.
- Sistema de magia para adicionar novas habilidades ao personagem.
