package br.com.alfonso.nba;


import org.junit.Assert;
import org.junit.Test;

import br.com.alfonso.nba.Time;

public class TimeTest {

	@Test
	public void testTime() {
		Time time = new Time();
		Assert.assertEquals(" - ", time.toString());
	}

	@Test
	public void testGetSigla() {
		Time time = new Time();
		time.setSigla("TST");
		Assert.assertEquals("TST", time.getSigla());
		Assert.assertEquals("TST - ", time.toString());
	}

	@Test
	public void testSetSigla() {
		Time time = new Time();
		time.setSigla("TST");
		Assert.assertEquals("TST", time.getSigla());
		time.setSigla("TESTE");
		Assert.assertEquals("TES", time.getSigla());
	}

	@Test
	public void testGetNome() {
		Time time = new Time();
		time.setNome("Teste");
		Assert.assertEquals("Teste", time.getNome());
		Assert.assertEquals(" - Teste", time.toString());
	}

	@Test
	public void testSetNome() {
		Time time = new Time();
		time.setNome("Teste");
		Assert.assertEquals("Teste", time.getNome());
	}

	@Test
	public void testToString() {
		Time time = new Time();
		time.setSigla("TST");
		time.setNome("Teste");
		Assert.assertEquals("TST - Teste", time.toString());
		time.setSigla("TESTE");
		Assert.assertEquals("TES - Teste", time.toString());
	}

}
