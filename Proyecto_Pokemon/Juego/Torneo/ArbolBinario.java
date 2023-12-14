package Juego.Torneo;


public class ArbolBinario {
    private NodoB raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public NodoB getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoB raiz) {
        this.raiz = raiz;
    }

    public void inserta(String nombreJugador) {
        raiz = insertarRecursivo(raiz, nombreJugador);
    }

    private NodoB insertarRecursivo(NodoB nodo, String nombreJugador) {
        if (nodo == null) {
            return new NodoB(nombreJugador, null, null);
        }

        if (Math.random() < 0.5) {
            nodo.setHijoIzq(insertarRecursivo(nodo.getHijoIzq(), nombreJugador));
        } else {
            nodo.setHijoDer(insertarRecursivo(nodo.getHijoDer(), nombreJugador));
        }

        return nodo;
    }

    public void realizarTorneo() {
        System.out.println("\nComienza el torneo:");
        realizarRondas(getRaiz(), 16);
    }

    private void realizarRondas(NodoB nodo, int numJugadores) {
        if (nodo == null || numJugadores < 1) {
            return;
        }

        int batallas = numJugadores / 2;
        int numRonda = 1;

        while (batallas >= 1) {
            System.out.println("\nRonda " + numRonda + ":");
            for (int i = 0; i < batallas; i++) {
                NodoB jugador1 = determinarGanador(nodo);
                NodoB jugador2 = determinarGanador(nodo);
                System.out.println("Jugador " + jugador1.getNombre() + " vs Jugador " + jugador2.getNombre());
            }
            numRonda++;
            batallas /= 2;
        }

        NodoB ganador = determinarGanador(nodo);
        System.out.println("\nRonda " + numRonda + ":");
        System.out.println("¡El ganador del torneo es " + ganador.getNombre() + "!");
    }

    private NodoB determinarGanador(NodoB nodo) {
        if (nodo == null) {
            return null;
        }

        while (nodo.getHijoIzq() != null && nodo.getHijoDer() != null) {
            if (Math.random() < 0.5) {
                nodo = nodo.getHijoIzq();
            } else {
                nodo = nodo.getHijoDer();
            }
        }
        return nodo;
    }
}
