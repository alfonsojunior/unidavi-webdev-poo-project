# Projeto Final - unidavi-webdev-poo-project

O projeto foi criado para fazer o controle de uma temporada da NBA. Para isso, foram criadas as seguintes classes:
* Temporada
* Time
* Partida
* Horario
* Agenda


## Definição das Classes

### Temporada

A classe Temporada engloba os recursos necessários para controlar uma temporada da NBA.</br>
Nessa classes definimos os times participantes e as agendas.

	Temporada temporada = new Temporada();
	temporada.setID("2017-2018");

### Time

Na classe Time temos uma identificação dos times participantes da temporada da NBA.</br>
Nessa classe informamos o nome do time e sua sigla.
Para fazer a manuntenção de um time, utilizamos a sigla do mesmo.

	Time time = new Time();
	time.setNome("Time 1");
	time.setSigla("TM1");
	
	temporada.adicionarTimes(time);
	temporada.adicionarTimes("TM2", "Time 2");

### Partida

A classe Partida reune 2 times (casa e visitante), inicializa a partida, adiciona pontos para os times e finaliza a partida. Ao finalizar a partida, a classe identifica qual é o time vencedor.</br>
Para adicionar um time (casa ou visitante), o time deve estar registrado na temporada primeiro.

	Partida partida = new Partida(temporada);
	partida.setCasa("TM1");
	
	Time time = new Time();
	time.setNome("Time 2");
	time.setSigla("TM2");
	partida.setVisitante(time);

### Horario

A classe Horario é utilizada adicionar várias partidas em um determinado horário para poder incluir em uma agenda.

	Horario horario = new Horario();
	horario.setHora(21, 00);
	horario.adicionarPartida(partida);

### Agenda

A classe Agenda utilizamos para reunir horários de partidas do mesmo dia. Para isso, precisamos informar a data da agenda e adicionar os horários com suas partidas.

	Agenda agenda = new Agenda();
	agenda.setData(2017, 12, 10);
	agenda.adicionarHorario(horario);
	
	temporada.adicionarAgenda(agenda);
	
	Partida part = temporada.buscaPartida(2017, 12, 10, 21, 00, "TM1", "TM2");
	if (part != null) {
		part.iniciarPartida();
		part.adicionarPontosCasa(2);
		part.adicionarPontosVisitante(3);
		part.adicionarPontosCasa(1);
		part.adicionarPontosCasa(1);
		part.adicionarPontosVisitante(2);
		part.adicionarPontosCasa(3);
		
		part.finalizarPartida();
	}
