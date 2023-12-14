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
        realizarRondas(getRaiz());
    }

    private void realizarRondas(NodoB nodo) {
        if (nodo == null) {
            return;
        }

        NodoB ganadorRonda1 = realizarRonda(nodo);
        NodoB ganadorRonda2 = realizarRonda(ganadorRonda1);
        NodoB ganadorRonda3 = realizarRonda(ganadorRonda2);

        System.out.println("\nRonda 1:");
        System.out.println("Ganador: " + ganadorRonda1.getNombre());

        System.out.println("\nRonda 2:");
        System.out.println("Ganador: " + ganadorRonda2.getNombre());

        System.out.println("\nRonda 3:");
        System.out.println("Ganador: " + ganadorRonda3.getNombre());

        System.out.println("\nRonda 4:");
        System.out.println("¡El ganador del torneo es " + nodo.getNombre() + "!");
    }

    private NodoB realizarRonda(NodoB nodo) {
        if (nodo == null) {
            return null;
        }

        while (nodo.getHijoIzq() != null && nodo.getHijoDer() != null) {
            System.out.println("Jugador " + nodo.getHijoIzq().getNombre() + " vs Jugador " + nodo.getHijoDer().getNombre());
            if (Math.random() < 0.5) {
                nodo = nodo.getHijoIzq();
            } else {
                nodo = nodo.getHijoDer();
            }
        }
        return nodo;
    }
}