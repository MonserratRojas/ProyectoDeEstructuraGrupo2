package Juego;

public class Batalla {
    private Jugador jugador1;
    private Jugador jugador2;
    private int turno;

    public Batalla(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.turno = 1;
    }

    public void iniciarBatalla() {
        ReproductorSonido.reproducirSonidoWAV("D:\\mkel5\\Documents\\NetBeansProjects\\Pokemon2\\y2mate.bz-pokeball-opening-sound-FX.wav");
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("¡Comienza la batalla!");

        while (todosPokemonMuertos()) {
            System.out.println("\nTurno " + turno + ":");
            ejecutarTurno();
            cambiarTurno();
        }

        determinarGanador();
    }

    private void ejecutarTurno() {
        if (turno == 1) {
            turnoJugador(jugador1, jugador2);
        } else {
            turnoJugador(jugador2, jugador1);
        }
    }

    private void turnoJugador(Jugador atacante, Jugador defensor) {
        System.out.println(atacante.getNombre() + ", es tu turno.");

        Pokemon pokemonAtacante = atacante.seleccionarPokemon();
        Pokemon pokemonDefensor = defensor.seleccionarPokemon();

        if (pokemonAtacante != null && pokemonDefensor != null) {
            System.out.println("¡" + atacante.getNombre() + " ha seleccionado a " + pokemonAtacante.getNombre() + "!");
            System.out.println(defensor.getNombre() + " tiene a " + pokemonDefensor.getNombre() + ".");

            double multiplicadorAtaque = obtenerMultiplicadorTipo(pokemonAtacante.getTipo(), pokemonDefensor.getTipo());

            int daño = (int) (pokemonAtacante.getAtaque() * multiplicadorAtaque);
            pokemonDefensor.recibirDaño(daño);

            System.out.println(pokemonAtacante.getNombre() + " ha atacado a " + pokemonDefensor.getNombre() +
                    " y le ha causado " + daño + " de daño.");

            System.out.println("Vida restante de " + pokemonDefensor.getNombre() + ": " + pokemonDefensor.getVida());

            if (pokemonDefensor.getVida() <= 0) {
                System.out.println(pokemonDefensor.getNombre() + " ha sido derrotado!");
                defensor.getPokedex().elimina(pokemonDefensor.getNombre());
            }
        }
    }
    private double obtenerMultiplicadorTipo(String tipoAtacante, String tipoDefensor) {
        double[][] multiplicadores = {
                //   Normal   Fuego   Agua
        /* Normal */ {1.0,     0.5,    1.5},
        /* Fuego  */ {1.5,     1.0,    0.5},
        /* Agua   */ {0.5,     1.5,    1.0}
        };

        int indiceAtacante = obtenerIndiceTipo(tipoAtacante);
        int indiceDefensor = obtenerIndiceTipo(tipoDefensor);

        return multiplicadores[indiceAtacante][indiceDefensor];
    }

    private int obtenerIndiceTipo(String tipo) {
        switch (tipo) {
            case "Normal":
                return 0;
            case "Fuego":
                return 1;
            case "Agua":
                return 2;
            default:
                return -1;
        }
    }


    private void cambiarTurno() {
        if (jugador1.getPokedex().areAlivePokemon() && jugador2.getPokedex().areAlivePokemon()) {
            if (turno == 1) {
                turno = 2;
            } else {
                turno = 1;
            }
            imprimirCambioDeTurno();
        } else {
            determinarGanador();
        }
    }

    private void imprimirCambioDeTurno() {
        System.out.println("Es el turno del Jugador " + turno + "!");
    }


    private void determinarGanador() {
        boolean todosPokemonJugador1Muertos = jugador1.getPokedex().areAlivePokemon();
        boolean todosPokemonJugador2Muertos = jugador2.getPokedex().areAlivePokemon();

        if (todosPokemonJugador1Muertos == true) {
            System.out.println("El Jugador 1 se ha quedado sin Pokemon! ¡El Jugador 2 es el ganador");

        } else if (todosPokemonJugador2Muertos == true) {
            System.out.println("El Jugador 2 se ha quedado sin Pokemon! ¡El Jugador 1 es el ganador");

        }
        System.out.println("Fin de la batalla!");
    }


    private boolean todosPokemonMuertos() {
        return jugador1.getPokedex().areAlivePokemon() && jugador2.getPokedex().areAlivePokemon();
    }


}

