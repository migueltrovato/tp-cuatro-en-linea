package tests;

import juego.CuatroEnLinea;

import org.junit.Test;
import org.junit.Assert;

public class PruebasCuatroEnLinea {

	@Test(expected = Error.class)
	public void siSeCreaUnJuegoConUnaFilaYUnaColumnaDaError() {
		new CuatroEnLinea(1, 1, "Carlitox", "Alejo");
	}
	
	@Test(expected = Error.class)
	public void siSeCreaUnJuegoConUnaFilaYCuatroColumnasDaError() {
		new CuatroEnLinea(1, 4, "Carlitox", "Alejo");
	}
	
	@Test(expected = Error.class)
	public void siSeCreaUnJuegoConCuatroFilasYUnaColumnaDaError() {
		new CuatroEnLinea(4, 1, "Carlitox", "Alejo");
	}
	
	@Test
	public void siSeCreaUnJuegoConCuatroFilasYCuatroColumnasSeCreaTableroDeCuatroPorCuatro() {
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "Carlitox", "Alejo");
		
		Assert.assertEquals(4, juego.contarFilas());
		Assert.assertEquals(4, juego.contarColumnas());
	}
	
}
