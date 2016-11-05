package juego;
/**
 * Juego Cuatro en Lí­nea
 * 
 * Reglas:
 * 
 * 		...
 *
 */
public class CuatroEnLinea {

	/**
	 * pre : 'filas' y 'columnas' son mayores o iguales a 4.
	 * post: empieza el juego entre el jugador que tiene fichas rojas, identificado como 
	 * 		 'jugadorRojo' y el jugador que tiene fichas amarillas, identificado como
	 * 		 'jugadorAmarillo'. 
	 * 		 Todo el tablero está vací­o.
	 * 
	 * @param filas : cantidad de filas que tiene el tablero.
	 * @param columnas : cantidad de columnas que tiene el tablero.
	 * @param jugadorRojo : nombre del jugador con fichas rojas.
	 * @param jugadorAmarillo : nombre del jugador con fichas amarillas.
	 */
	
	private int filas;
	private int columnas;
	private String jugadorRojo;
	private String jugadorAmarillo;
	private String esTurnoDelJugador;
	
	private Casillero tablero[][];
	private int fichasTotalesUsadas;
	
	
	
	public CuatroEnLinea(int filas, int columnas, String jugadorRojo, String jugadorAmarillo) {
		
		if(filas < 4 || columnas < 4){
			Error error = new Error ("La cantidad de filas y de columnas deben ser al menos 4.");
			throw error;
		}
		
		this.filas = filas;
		this.columnas = columnas;
		this.jugadorAmarillo = jugadorAmarillo;
		this.jugadorRojo = jugadorRojo;
		this.tablero = new Casillero[this.contarFilas()][this.contarColumnas()];
		this.inicializarTableroVacio();
		/*
		 *  TODO: Consultar como manejar quien empieza primero
		 *  	  por ahora dejamos que el rojo comienze primero
		 */
		this.esTurnoDelJugador = jugadorRojo;
	}
	
	private void inicializarTableroVacio() {
		
		for (int i = 0; i < this.contarFilas(); i++) {
			for (int j = 0; j < this.contarColumnas(); j++) {
				this.tablero[i][j] = Casillero.VACIO;
			}
		}
	}
	
	/**
	 * post: devuelve la cantidad máxima de fichas que se pueden apilar en el tablero.
	 */
	public int contarFilas() {
		
		return this.filas;
	}

	/**
	 * post: devuelve la cantidad máxima de fichas que se pueden alinear en el tablero.
	 */
	public int contarColumnas() {
		
		return this.columnas;
	}

	/**
	 * pre : fila está en el intervalo [1, contarFilas()],
	 * 		 columnas está en el intervalo [1, contarColumnas()].
	 * post: indica qué ocupa el casillero en la posición dada por fila y columna.
	 * 
	 * @param fila
	 * @param columna
	 */
	public Casillero obtenerCasillero(int fila, int columna) {
		
		if( !(fila >= 1 && fila <= this.contarFilas()) 
				|| !(columna >= 1 && columna <= this.contarColumnas())){
		
			Error error = new Error ("La cantidad de filas y columnas debe estar entre las elegidas para jugar.");
			throw error;
		}
		
		return this.tablero[fila-1][columna-1];
	}
	
	/**
	 * pre : el juego no terminó, columna está en el intervalo [1, contarColumnas()]
	 * 		 y aún queda un Casillero.VACIO en la columna indicada. 
	 * post: deja caer una ficha en la columna indicada.
	 * 
	 * @param columna
	 */
	public void soltarFicha(int columna) {
		
		if(this.termino()
				|| !(columna >=1 && columna <= this.contarColumnas())  ){
			Error error = new Error("Eljuego no debe haber terminado y se debe dar un valor valido");
			throw error;
		}
		
		Integer casilleroLibre = verificadorCasilleroLibreColumna(columna);
		
		if (casilleroLibre != null) {
			if (esTurnoDelJugador == this.jugadorRojo) {
				this.tablero[casilleroLibre-1][columna-1] = Casillero.ROJO;
				this.esTurnoDelJugador = this.jugadorAmarillo;
			} else {
				this.tablero[casilleroLibre-1][columna-1] = Casillero.AMARILLO;
				this.esTurnoDelJugador = this.jugadorRojo;
			}
			fichasTotalesUsadas++;
		}
		
	}

	/**
	 * post: devuelve la posición del último casillero VACIO en una columna
	 * 		de lo contrario devuelve null
	 */
	private Integer verificadorCasilleroLibreColumna(int columna){
		
		boolean hayCasilleroVacio = false;
		Integer ultimaPosicionVacia = null;
		
		for (int i = this.contarFilas()-1; i >= 0 && !hayCasilleroVacio; i--) {
			if (this.tablero[i][columna-1] == Casillero.VACIO) {
				hayCasilleroVacio = true;
				ultimaPosicionVacia = i+1;
			}
		}
		
		return ultimaPosicionVacia;
	}
	
	/**
	 * post: indica si el juego terminó porque uno de los jugadores
	 * 		 ganó o no existen casilleros vacíos.
	 */
	public boolean termino() {
		
	    	boolean juegoTerminado = (this.fichasTotalesUsadas==(this.contarFilas()*this.contarColumnas()) || this.hayGanador());
	    		
	    	return juegoTerminado;
	}

	/**
	 * post: indica si el juego terminó y tiene un ganador.
	 */
	public boolean hayGanador() {
		
		/*
		 * TODO: hacer que se fije si hay cuatro en linea horizontal
		 * 		luego diagonal, luego vertical
		 */
		
		return false;
	}

	/**
	 * pre : el juego terminó.
	 * post: devuelve el nombre del jugador que ganó el juego.
	 */
	public String obtenerGanador() {
		
		return null;
	}
}
