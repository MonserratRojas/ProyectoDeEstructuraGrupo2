package Juego.Torneo;


public class Torneo {
    public static void main(String[] args) {
        String[] nombresJugadores = { "Jugador1", "Jugador2", "Jugador3", "Jugador4", "Jugador5", "Jugador6", "Jugador7", "Jugador8", "Jugador9"
                , "Jugador10", "Jugador11", "Jugador12", "Jugador13", "Jugador14", "Jugador15", "Jugador16", };

        ArbolBinario arbol = new ArbolBinario();
        for (String nombre : nombresJugadores) {
            arbol.inserta(nombre);
        }

        arbol.realizarTorneo();
    }
    public static void realizarTorneo() {
        String[] nombresJugadores = { "Jugador1", "Jugador2", "Jugador3", "Jugador4", "Jugador5", "Jugador6", "Jugador7", "Jugador8", "Jugador9"
                , "Jugador10", "Jugador11", "Jugador12", "Jugador13", "Jugador14", "Jugador15", "Jugador16", };

        ArbolBinario arbol = new ArbolBinario();
        for (String nombre : nombresJugadores) {
            arbol.inserta(nombre);
        }

        arbol.realizarTorneo();
    }
}
