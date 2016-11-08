package tests;

import juego.Casillero;
import juego.CuatroEnLinea;

import org.junit.Test;
import org.junit.Assert;

public class PruebasCuatroEnLinea {

	@Test(expected = Error.class)
	public void siSeCreaUnJuegoConUnaFilaYUnaColumnaDaError() {
		
		new CuatroEnLinea(1, 1, "Carlitox", "Alejo");
	}
	
	@Test(expected = Error.class)
	public void siSeCreaUnJuegoConCeroFilasYUnaColumnaDaError() {
		
		new CuatroEnLinea(0, 1, "Carlitox", "Alejo");
	}
	
	@Test(expected = Error.class)
	public void siSeCreaUnJuegoConUnaFilaYCeroColumnasDaError() {
		
		new CuatroEnLinea(1, 0, "Carlitox", "Alejo");
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
	public void alComenzarElJuegoNoHayGanadorYGanadorEsNull() {
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "Carlitox", "Alejo");
		
		Assert.assertFalse(juego.hayGanador());
		Assert.assertNull(juego.obtenerGanador());
	}
	
	@Test
	public void siSeCreaUnJuegoConCuatroFilasYCuatroColumnasSeCreaTableroDeCuatroPorCuatro() {
		
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "Carlitox", "Alejo");
		
		Assert.assertEquals(4, juego.contarFilas());
		Assert.assertEquals(4, juego.contarColumnas());
	}
	
	@Test
	public void siSeCreaUnJuegoConVeinteFilasYCincuentaColumnasSeCreaTableroDeVeintePorCincuenta() {
		
		CuatroEnLinea juego = new CuatroEnLinea(20, 50, "Carlitox", "Alejo");
		
		Assert.assertEquals(20, juego.contarFilas());
		Assert.assertEquals(50, juego.contarColumnas());
	}
	
	@Test
	public void siElJuegoHaSidoCreadoNoHaTerminadoAun() {
		
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "Carlitox", "Alejo");
		
		Assert.assertFalse(juego.termino());
	}
	
	@Test
	public void siElJuegoHaSidoCreadoNoHayGanadorAun() {
		
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "Carlitox", "Alejo");
		
		Assert.assertFalse(juego.hayGanador());
		Assert.assertNull(juego.obtenerGanador());
	}
	
	@Test
	public void alCrearUnJuegoTodosSusCasillerosEstanVacios() {
		
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "Carlitox", "Alejo");
		
		for (int i = 1; i <= juego.contarFilas(); i++) {
			for (int j = 1; j <= juego.contarColumnas(); j++) {
				Assert.assertEquals(Casillero.VACIO, juego.obtenerCasillero(i, j));
			}
		}
	}
	
	@Test
	public void siSeSueltaUnaFichaEnColumnaDosYEstaVaciaCaeEnColumnaDosEnLaUltimaFila() {
		
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "Carlitox", "Alejo");
		juego.soltarFicha(2);
		
		Assert.assertEquals(Casillero.ROJO, juego.obtenerCasillero(4, 2));
		Assert.assertEquals(Casillero.VACIO, juego.obtenerCasillero(3, 2));
		Assert.assertEquals(Casillero.VACIO, juego.obtenerCasillero(2, 2));
		Assert.assertEquals(Casillero.VACIO, juego.obtenerCasillero(1, 2));
	}
	
	@Test
	public void siSeSueltanDosFichasEnColumnaDosYEstabaVaciaCaenEnLasDosUltimasFilas() {
		
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "Carlitox", "Alejo");
		juego.soltarFicha(2);		
		juego.soltarFicha(2);
		
		Assert.assertEquals(Casillero.ROJO, juego.obtenerCasillero(4, 2));
		Assert.assertEquals(Casillero.AMARILLO, juego.obtenerCasillero(3, 2));
		Assert.assertEquals(Casillero.VACIO, juego.obtenerCasillero(2, 2));
		Assert.assertEquals(Casillero.VACIO, juego.obtenerCasillero(1, 2));
	}
	
	@Test
	public void siSeSueltanTresFichasEnColumnaDosYEstabaVaciaCaenEnLasTresUltimasFilas() {
		
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "Carlitox", "Alejo");
		juego.soltarFicha(2);		
		juego.soltarFicha(2);
		juego.soltarFicha(2);
		
		Assert.assertEquals(Casillero.ROJO, juego.obtenerCasillero(4, 2));
		Assert.assertEquals(Casillero.AMARILLO, juego.obtenerCasillero(3, 2));
		Assert.assertEquals(Casillero.ROJO, juego.obtenerCasillero(2, 2));
		Assert.assertEquals(Casillero.VACIO, juego.obtenerCasillero(1, 2));
	}
	
	@Test
	public void siSeSueltanCuatroFichasEnColumnaDosSeLlenaLaColumna() {
		
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "Carlitox", "Alejo");
		juego.soltarFicha(2);		
		juego.soltarFicha(2);
		juego.soltarFicha(2);
		juego.soltarFicha(2);
		
		Assert.assertEquals(Casillero.ROJO, juego.obtenerCasillero(4, 2));
		Assert.assertEquals(Casillero.AMARILLO, juego.obtenerCasillero(3, 2));
		Assert.assertEquals(Casillero.ROJO, juego.obtenerCasillero(2, 2));
		Assert.assertEquals(Casillero.AMARILLO, juego.obtenerCasillero(1, 2));
	}
	
	@Test
	public void siSeCompletaUnaColumnaDeCuatroCasillerosYComenzoElRojoElProximoTurnoEsDelRojo() {
		
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "Carlitox", "Alejo");
		juego.soltarFicha(2);		
		juego.soltarFicha(2);
		juego.soltarFicha(2);
		juego.soltarFicha(2);
		juego.soltarFicha(4);
		
		Assert.assertEquals(Casillero.ROJO, juego.obtenerCasillero(4, 2));
		Assert.assertEquals(Casillero.AMARILLO, juego.obtenerCasillero(3, 2));
		Assert.assertEquals(Casillero.ROJO, juego.obtenerCasillero(2, 2));
		Assert.assertEquals(Casillero.AMARILLO, juego.obtenerCasillero(1, 2));
		Assert.assertEquals(Casillero.ROJO, juego.obtenerCasillero(4, 4));
	}
	
	@Test
	public void siSeCompletaUnaColumnaDeCincoCasillerosYComenzoElRojoElProximoTurnoEsDelAmarillo() {
		
		CuatroEnLinea juego = new CuatroEnLinea(5, 4, "Carlitox", "Alejo");
		juego.soltarFicha(2);		
		juego.soltarFicha(2);
		juego.soltarFicha(2);
		juego.soltarFicha(2);
		juego.soltarFicha(2);
		juego.soltarFicha(4);
		
		Assert.assertEquals(Casillero.ROJO, juego.obtenerCasillero(5, 2));
		Assert.assertEquals(Casillero.AMARILLO, juego.obtenerCasillero(4, 2));
		Assert.assertEquals(Casillero.ROJO, juego.obtenerCasillero(3, 2));
		Assert.assertEquals(Casillero.AMARILLO, juego.obtenerCasillero(2, 2));
		Assert.assertEquals(Casillero.ROJO, juego.obtenerCasillero(1, 2));
		Assert.assertEquals(Casillero.AMARILLO, juego.obtenerCasillero(5, 4));
	}
	
	@Test
	public void siSeLlenaElTableroSinHacerCuatroEnLineaElJuegoTermino() {
		
		// La cantidad de columnas debe ser impar para no hacer cuatro en linea
		CuatroEnLinea juego = new CuatroEnLinea(4, 5, "Carlitox", "Alejo");
		
		Assert.assertFalse(juego.termino());
		
		for (int i = 1; i < 5; i++) {
			juego.soltarFicha(1);		
			juego.soltarFicha(2);		
			juego.soltarFicha(3);		
			juego.soltarFicha(4);
			juego.soltarFicha(5);
		}
		
		Assert.assertTrue(juego.termino());
	}
	
	@Test
	public void siElJugadorRojoHaceCuatroEnLineaHorizontalEnLaUltimaFilaHayGanadorYGanaElRojo() {
		
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "Carlitox", "Alejo");
		juego.soltarFicha(1);		
		juego.soltarFicha(1);
		juego.soltarFicha(2);
		juego.soltarFicha(1);
		juego.soltarFicha(3);
		juego.soltarFicha(1);
		juego.soltarFicha(4);
		
		Assert.assertTrue(juego.hayGanador());
		Assert.assertEquals("Carlitox", juego.obtenerGanador());
		Assert.assertTrue(juego.termino());
	}
	
	@Test
	public void siElJugadorRojoHaceCuatroEnLineaHorizontalEnLaUltimaFilaDeUnTableroDeSietePorSieteHayGanadorYGanaElRojo() {
		
		CuatroEnLinea juego = new CuatroEnLinea(7, 7, "Carlitox", "Alejo");
		juego.soltarFicha(1);		
		juego.soltarFicha(1);
		juego.soltarFicha(2);
		juego.soltarFicha(1);
		juego.soltarFicha(3);
		juego.soltarFicha(1);
		juego.soltarFicha(4);
		
		Assert.assertTrue(juego.hayGanador());
		Assert.assertEquals("Carlitox", juego.obtenerGanador());
		Assert.assertTrue(juego.termino());
	}
	
	@Test
	public void siElJugadorRojoNoHaceCuatroEnLineaHorizontalEnLaUltimaFilaNoHayGanadorYGanadorEsNull() {
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "Carlitox", "Alejo");
		juego.soltarFicha(1);		
		juego.soltarFicha(1);
		juego.soltarFicha(2);
		juego.soltarFicha(1);
		juego.soltarFicha(3);
		juego.soltarFicha(1);
		
		Assert.assertFalse(juego.hayGanador());
		Assert.assertNull(juego.obtenerGanador());
		Assert.assertFalse(juego.termino());
	}
	
	@Test
	public void siElJugadorRojoNoHaceCuatroEnLineaHorizontalEnLaUltimaFilaDeUnTableroDeSietePorSieteNoHayGanadorYGanadorEsNull() {
		CuatroEnLinea juego = new CuatroEnLinea(7, 7, "Carlitox", "Alejo");
		juego.soltarFicha(1);		
		juego.soltarFicha(1);
		juego.soltarFicha(2);
		juego.soltarFicha(1);
		juego.soltarFicha(3);
		juego.soltarFicha(1);
		
		Assert.assertFalse(juego.hayGanador());
		Assert.assertNull(juego.obtenerGanador());
		Assert.assertFalse(juego.termino());
	}
	
	@Test
	public void siElJugadorRojoHaceCuatroEnLineaVerticalEnLaPrimeraColumnaHayGanadorYGanaElRojo() {
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "Carlitox", "Alejo");
		juego.soltarFicha(1);		
		juego.soltarFicha(2);
		juego.soltarFicha(1);
		juego.soltarFicha(3);
		juego.soltarFicha(1);
		juego.soltarFicha(4);
		juego.soltarFicha(1);
		
		Assert.assertTrue(juego.hayGanador());
		Assert.assertEquals("Carlitox", juego.obtenerGanador());
		Assert.assertTrue(juego.termino());
	}
	
	@Test
	public void siElJugadorRojoHaceCuatroEnLineaVerticalEnLaPrimeraColumnaDeUnTableroDeSietePorSieteHayGanadorYGanaElRojo() {
		CuatroEnLinea juego = new CuatroEnLinea(7, 7, "Carlitox", "Alejo");
		juego.soltarFicha(1);		
		juego.soltarFicha(2);
		juego.soltarFicha(1);
		juego.soltarFicha(3);
		juego.soltarFicha(1);
		juego.soltarFicha(4);
		juego.soltarFicha(1);
		
		Assert.assertTrue(juego.hayGanador());
		Assert.assertEquals("Carlitox", juego.obtenerGanador());
		Assert.assertTrue(juego.termino());
	}
	
	@Test
	public void siElJugadorRojoNoHaceCuatroEnLineaVerticalEnLaPrimeraFilaNoHayGanador() {
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "Carlitox", "Alejo");
		juego.soltarFicha(1);		
		juego.soltarFicha(2);
		juego.soltarFicha(1);
		juego.soltarFicha(3);
		juego.soltarFicha(1);
		juego.soltarFicha(1);
		
		Assert.assertFalse(juego.hayGanador());
		Assert.assertNull(juego.obtenerGanador());
		Assert.assertFalse(juego.termino());
	}
	
	@Test
	public void siELJugadorAmarilloNoHaceCuatroEnLineaHorizontalPorDosPartesNoHayGanador() {
		CuatroEnLinea juego = new CuatroEnLinea(7, 7, "Carlitox", "Alejo");
		
		juego.soltarFicha(1);		
		juego.soltarFicha(2);
		juego.soltarFicha(3);
		juego.soltarFicha(4);
		juego.soltarFicha(5);
		juego.soltarFicha(6);
		juego.soltarFicha(7);		
		juego.soltarFicha(1);
		juego.soltarFicha(1);
		juego.soltarFicha(2);
		juego.soltarFicha(2);
		juego.soltarFicha(3);
		juego.soltarFicha(3);
		juego.soltarFicha(3);		
		juego.soltarFicha(4);	
		juego.soltarFicha(5);
		juego.soltarFicha(5);		
		juego.soltarFicha(6);
			
		
		/*
		 * [[ V, V, V, V, V, V, V ],
		 *  [ V, V, V, V, V, V, V ],
		 *  [ V, V, V, V, V, V, V ],
		 *  [ V, V, A, V, V, V, V ],
		 *  [ R, R, R, V, R, V, V ],
		 *  [ A, A, A, R, A, A, V ],
		 *  [ R, A, R, A, R, A, R ]]
		 */
		
		
		Assert.assertFalse(juego.hayGanador());
		Assert.assertNull(juego.obtenerGanador());
		Assert.assertFalse(juego.termino());
	}
	
	@Test
	public void siELJugadorAmarilloHaceCuatroEnLineaHorizontalPorDosPartesHayGanadorYEsElAmarillo() {
		CuatroEnLinea juego = new CuatroEnLinea(7, 7, "Carlitox", "Alejo");
		juego.soltarFicha(1);		
		juego.soltarFicha(2);
		juego.soltarFicha(3);
		juego.soltarFicha(4);
		juego.soltarFicha(5);
		juego.soltarFicha(6);
		juego.soltarFicha(7);	
		juego.soltarFicha(1);
		juego.soltarFicha(1);
		juego.soltarFicha(2);
		juego.soltarFicha(2);
		juego.soltarFicha(3);
		juego.soltarFicha(3);
		juego.soltarFicha(3);	
		juego.soltarFicha(5);
		juego.soltarFicha(5);	
		juego.soltarFicha(6);
		juego.soltarFicha(4);
				
		
		/*
		 * [[ V, V, V, V, V, V, V ],
		 *  [ V, V, V, V, V, V, V ],
		 *  [ V, V, V, V, V, V, V ],
		 *  [ V, V, A, V, V, V, V ],
		 *  [ R, R, R, V, R, V, V ],
		 *  [ A, A, A, R, A, A, V ],
		 *  [ R, A, R, A, R, A, R ]]
		 */
		
		
		Assert.assertTrue(juego.hayGanador());
		Assert.assertEquals("Alejo", juego.obtenerGanador());
		Assert.assertTrue(juego.termino());
	}
	
}
