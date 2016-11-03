package juego;
/**
 * Juego Cuatro en L��nea
 * 
 * Reglas:
 * 
 * 		...asd
 *
 */
public class CuatroEnLinea {

	/**
	 * pre : 'filas' y 'columnas' son mayores o iguales a 4.
	 * post: empieza el juego entre el jugador que tiene fichas rojas, identificado como 
	 * 		 'jugadorRojo' y el jugador que tiene fichas amarillas, identificado como
	 * 		 'jugadorAmarillo'. 
	 * 		 Todo el tablero est� vac�o.
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
	
	private Casillero tablero [][];
	
	
	
	public CuatroEnLinea(int filas, int columnas, String jugadorRojo, String jugadorAmarillo) {
		
		if(filas<=1 || columnas<=1){
			Error error = new Error ("La cantidad de filas y columnas deben ser mayores a 1.");
			throw error;
		}
		this.filas = filas;
		this.columnas = columnas;
		this.jugadorAmarillo = jugadorAmarillo;
		this.jugadorRojo = jugadorRojo;
		this.tablero = new Casillero[this.contarFilas()][this.contarColumnas()];
	}

	/**
	 * post: devuelve la cantidad m�xima de fichas que se pueden apilar en el tablero.
	 */
	public int contarFilas() {
		
		return this.filas;
	}

	/**
	 * post: devuelve la cantidad m�xima de fichas que se pueden alinear en el tablero.
	 */
	public int contarColumnas() {
		
		return this.columnas;
	}

	/**
	 * pre : fila est� en el intervalo [1, contarFilas()],
	 * 		 columnas est� en el intervalo [1, contarColumnas()].
	 * post: indica qu� ocupa el casillero en la posici�n dada por fila y columna.
	 * 
	 * @param fila
	 * @param columna
	 */
	public Casillero obtenerCasillero(int fila, int columna) {
		if( !(fila>0 && fila<this.contarFilas()) || !(columna>0 && columna<this.contarColumnas())){
		
			Error error = new Error ("La cantidad de filas y columnas debe estar entre las elegidas para jugar.");
			throw error;
		}
		
		return this.tablero[fila][columna];
	}
	
	/**
	 * pre : el juego no termin�, columna est� en el intervalo [1, contarColumnas()]
	 * 		 y a�n queda un Casillero.VACIO en la columna indicada. 
	 * post: deja caer una ficha en la columna indicada.
	 * 
	 * @param columna
	 */
	public void soltarFicha(int columna) {
		
		if(this.termino()  || !this.verificadorEspacioLibreColumna(columna) || !(columna >=1 && columna <=this.contarColumnas())  ){
			Error error = new Error("Eljuego no debe haber terminado y se debe dar un valor valido");
			throw error;
		}
		for (int i = 1; i < tablero.length && tablero[i][columna] !=Casillero.VACIO; i++){
			//Hay que hacer que caiga laficha del jugador en el ulltimo casillero vacio que encuentre
		}
		
	}
	
	
	
	private boolean verificadorEspacioLibreColumna(int columna){
		for (int i = 1; i < tablero.length && tablero[i][columna] !=Casillero.VACIO; i++){
			
					
					
			
		}
		return false;
	}
	
	/**
	 * post: indica si el juego termin� porque uno de los jugadores
	 * 		 gan� o no existen casilleros vac�os.
	 */
	public boolean termino() {
		
		
		return false;
	}

	/**
	 * post: indica si el juego termin� y tiene un ganador.
	 */
	public boolean hayGanador() {
		
		return false;
	}

	/**
	 * pre : el juego termin�.
	 * post: devuelve el nombre del jugador que gan� el juego.
	 */
	public String obtenerGanador() {
		
		return null;
	}
}