# Encapsulamento / Polimorfismo / Heran�a

## Ferramenta

* Encapsulamento - deixar somente os m�todos importantes expostos
* Encapsulamento - atributos de instancia privados
* Encapsulamento - pode dizer o que o m�todo faz sem dizer como ele faz
* Encapsulamento - mudan�as devem ocorrer somente em um s� lugar
* Heran�a - Somente colocar na classe o que diz respeito a ela
* Heran�a - N�o possuir repeti��o de c�digo
* Heran�a- A classe filha deve usar todas as propriedades da classe pai
* Heran�a - Atributos protegidos para que a classe filha possa manipular atributos da classe pai.
* Polimorfismo - A classe de base possui o forma como o processo funciona
* Polimorfismo - A classe filha implementa as regras do funcionamento definido nos processos da classe base
* Polimorfismo - Os m�todos da classe pai devem ser constru�dos na classe filha
* Encapsulamento - cobertura de c�digo superior a 80%

## Inspe��o

##### Caso 1 - Encapsulamento - deixar somente os m�todos importantes expostos (1 - n�o usa, 2 - usa)
* Agenda: 2
* Horario: 2
* Partida: 2
* Temporada: 2
* Time: 2

##### Caso 2 - Encapsulamento - atributos de instancia privados (1 - n�o usa, 2 - usa)
* Agenda: 2
* Horario: 2
* Partida: 2
* Temporada: 2
* Time: 2

##### Caso 3 - Encapsulamento - pode dizer o que o m�todo faz sem dizer como ele faz  (1 - n�o se aplica, 2 - razoavelmente, 3 - completamente)
* Agenda: 3
* Horario: 3
* Partida: 3
* Temporada: 3
* Time: 3

##### Caso 4 - Encapsulamento - mudan�as devem ocorrer somente em um s� lugar. (1 - n�o ocorre, 2 - ocorre)
* Agenda: 2
* Horario: 2
* Partida: 2
* Temporada: 2
* Time: 2

##### Caso 5 - Heran�a - Somente colocar na classe o que diz respeito a ela (1 - n�o ocorre, 2 - ocorre)
* Agenda: 2
* Horario: 2
* Partida: 2
* Temporada: 2
* Time: 2

##### Caso 6 - Heran�a - N�o possuir repeti��o de c�digo (1 - possui repeti��o,  2 - possui pouca, 3 - n�o possui repeti��o)
* Agenda: 3
* Horario: 3
* Partida: 3
* Temporada: 2
* Time: 3

##### Caso 7 - Heran�a - A classe filha deve usar todas as propriedades da classe pai (1 - n�o usa, 2 - usa)
* Agenda: 2 (n�o extende classe ou implementa interface)
* Horario: 2 (n�o extende classe ou implementa interface)
* Partida: 2 (sobrescreve todos os m�todos)
* Temporada: 2 (n�o extende classe ou implementa interface)
* Time: 2 (n�o extende classe ou implementa interface)

##### Caso 8 - Heran�a - Atributos protegidos para que a classe filha possa manipular atributos da classe pai.
> Os atributos n�o foram definidos na classe pai, apenas m�todos.

##### Caso 9 - Polimorfismo - A classe de base possui a forma como o processo funciona. (1 - N�o, 2 - Sim)
* IPartida: 2

##### Caso 10 - Polimorfismo - A classe filha implementa as regras do funcionamento definido nos processos da classe base.  (1 - N�o, 2 - Sim)
* Partida: 2 

##### Caso 11 - Polimorfismo - Os m�todos da classe pai devem ser constru�dos na classe filha (1 - N�o, 2 - Sim)
* Partida: 2 

##### Caso 12 - Encapsulamento - cobertura de c�digo superior a 80% (1 - abaixo, 2 - 80%, 3 - 100%)
* AgendaTest: 3
* HorarioTest: 3
* PartidaTest: 3
* TemporadaTest: 3
* TimeTest: 3

## Regras do Jogo NBA

###### Agendar um jogo para um dia e hor�rio
* Criar uma Partida com o Tima da casa e o Time Visitante
* Criar um Horario com uma hora (LocalTime) e adiciona-se a partida a esse Horario
* Criar uma Agenda para uma data (LocalDate) e adiciona-se o Hor�rio a essa Agenda
* Se a Temporada n�o existir ainda, criar uma Temporada, depois, adicione a Agenda a Temporada

###### Jogos de uma data
* Na Temporada, utilize o m�todo listarPartidas passando como par�metro a data desejada no formato LocalDate

###### Reagendar um jogo
* Na Temporada, utilize o m�todo reagendarPartida passando a Partida, a nova data (LocalDate) e o novo hor�rio (LocalTime), que o m�todo encontrar� a partida e far� o reagendamento da Partida
* Ou utilize o m�todo reagendarPartida passando a data atual (LocalDate) da partida, a Partida, a nova data (LocalDate) e o novo hor�rio (LocalTime), para que o m�todo encontre mais r�pido a Partida

###### Adicionar pontos a uma equipe em um jogo em andamento
* Com a Partida em andamento, utilie os m�todos adicionarPontosCasa e adicionarPontosVisitante. Somente partidas em andamento aceitam adicionar pontos aos Times 

###### Definir resultado final de um jogo
* Utilizando o m�todo finalizarPartida, o jogo verificar� a pontua��o e definir� o vencedor. Como um jogo de basquete n�o tem empate, o jogo n�o � finalizado se a pontua��o do jogo estiver empatada
