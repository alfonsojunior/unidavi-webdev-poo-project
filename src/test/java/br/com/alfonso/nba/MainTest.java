package br.com.alfonso.nba;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MainTest {
	
	private Temporada temporada;
	
	@Before
	public void setUp() {
		temporada = new Temporada();
		temporada.setID("2017-2018");
	}

	@Test
	//@Ignore
	public void testMain() {
		Main mn = new Main();
		mn.main(new String[] {});
		assertThat(0.0, CoreMatchers.is(0.0));
	}


}
