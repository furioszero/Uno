/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unogame;

/**
 *
 * @author Mauricio-PC
 */
public class Turno {
    
	
	public static final int Turno_Derecha = 1;
	public static final int Turno_Izquierda = -1;
        private int jugadorConTurno;
	private int numJugador;
	private int direccion;
	
	public Turno(int jugadorInicial, int numJugador, int direccion) {
		
		if (jugadorInicial >= numJugador)
			throw new IllegalArgumentException("Jugador Inicial Esta Fuera del Rango de los Jugadores");
		
		if (direccion != Turno_Derecha && direccion != Turno_Izquierda) 
			throw new IllegalArgumentException("Direccion no es correcta.");
			
		jugadorConTurno   = jugadorInicial;
		this.numJugador = numJugador;
		this.direccion  = direccion;
	}
	
	public int mostraTurnoActual() {
		return jugadorConTurno;
	}
	
	public int mostrarTurnoAnterior() {
		return revisarLimites(jugadorConTurno - direccion);
	}
	
	public int mostrarSiguienteTurno() {
		return revisarLimites(jugadorConTurno + direccion);
	}
	
	public void siguienteTurno() {
		jugadorConTurno += direccion;
		jugadorConTurno = revisarLimites(jugadorConTurno);
	}
	
	public void cambiarDireccion() {
		direccion *= -1;
	}
	
	public int getDireccion() {
		return direccion;
	}
	
	public void retirarseJugador() {
		if (numJugador == 1) 
                    return;
		numJugador--;
		revisarLimites(jugadorConTurno);
	}
	
	public void adicionarNuevoJugador() {
		numJugador++;
	}
	
	private int revisarLimites(int position) {
		if (position >= numJugador)
                    return 0;
		else if (position < 0) 
                    return numJugador - 1;
		else 
                    return position;
	}
	
	
}
    

