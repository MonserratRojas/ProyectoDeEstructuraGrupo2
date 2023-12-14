package Juego;

import Juego.Jugador;
import Juego.ReproductorSonido;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Batalla {
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugador3;
    private Jugador jugador4;
    private int turno;
    private JFrame frame;
    private JTextArea textArea;

    public Batalla(Jugador jugador1, Jugador jugador2, Jugador jugador3, Jugador jugador4) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.jugador3 = jugador3;
        this.jugador4 = jugador4;
        this.turno = 1;

        this.frame = new JFrame("Batalla Pokémon");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(400, 300);
        this.frame.setLayout(null);

        this.textArea = new JTextArea();
        this.textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(this.textArea);
        scrollPane.setBounds(10, 10, 380, 240);
        this.frame.add(scrollPane);
    }

    public void iniciarBatalla() {
        ReproductorSonido.reproducirSonidoWAV("D:\\mkel5\\Documents\\NetBeansProjects\\Pokemon2\\y2mate.bz-pokeball-opening-sound-FX.wav");
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        batallar(jugador1, jugador2);
        batallar(jugador1, jugador3);
        batallar(jugador1, jugador4);
        determinarGanadorFinal();
        this.frame.setVisible(true);
        textArea.append("¡Comienza la batalla!\n");

        while (todosPokemonMuertos()) {
            textArea.append("\nTurno " + turno + ":\n");
            ejecutarTurno();
            cambiarTurno();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }    
    }
    
    private void batallar(Jugador atacante, Jugador defensor) {
        textArea.append("¡Comienza la batalla entre " + atacante.getNombre() + " y " + defensor.getNombre() + "!");

        while (atacante.getPokedex().areAlivePokemon() && defensor.getPokedex().areAlivePokemon()) {
            turnoJugador(atacante, defensor);
            if (defensor.getPokedex().areAlivePokemon()) {
                cambiarTurno();
            }
        }
    }

    private void ejecutarTurno() {
        if (turno == 1) {
            turnoJugador(jugador1, jugador2);
            turnoJugador(jugador1, jugador3);
            turnoJugador(jugador1, jugador4);
        } else {
            turnoJugador(jugador2, jugador1);
            turnoJugador(jugador3, jugador1);
            turnoJugador(jugador4, jugador1);
        }
    }

    private void turnoJugador(Jugador atacante, Jugador defensor) {
        StringBuilder turnoActual = new StringBuilder();

        turnoActual.append("\n¡Comienza la batalla entre " + atacante.getNombre() + " y " + defensor.getNombre() + "!\n");
        turnoActual.append(atacante.getNombre() + ", es tu turno.\n");

        Pokemon pokemonAtacante = atacante.seleccionarPokemon();
        Pokemon pokemonDefensor = defensor.seleccionarPokemon();

        if (pokemonAtacante != null && pokemonDefensor != null) {
            turnoActual.append("¡" + atacante.getNombre() + " ha seleccionado a " + pokemonAtacante.getNombre() + "!\n");
            turnoActual.append(defensor.getNombre() + " tiene a " + pokemonDefensor.getNombre() + ".\n");

            double multiplicadorAtaque = obtenerMultiplicadorTipo(pokemonAtacante.getTipo(), pokemonDefensor.getTipo());

            int daño = (int) (pokemonAtacante.getAtaque() * multiplicadorAtaque);
            pokemonDefensor.recibirDaño(daño);

            turnoActual.append(pokemonAtacante.getNombre() + " ha atacado a " + pokemonDefensor.getNombre() +
                    " y le ha causado " + daño + " de daño.\n");

            turnoActual.append("Vida restante de " + pokemonDefensor.getNombre() + ": " + pokemonDefensor.getVida() + "\n");

            if (pokemonDefensor.getVida() <= 0) {
                turnoActual.append(pokemonDefensor.getNombre() + " ha sido derrotado!\n");
                defensor.getPokedex().elimina(pokemonDefensor.getNombre());
            }
        }
        textArea.append(turnoActual.toString() + "\n");
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
            determinarGanadorFinal();
        }
    }

    private void imprimirCambioDeTurno() {
        String mensaje = "Es el turno del Jugador " + turno + "!";
        textArea.append(mensaje + "\n");
    }

    private void determinarGanadorFinal() {
        boolean todosPokemonJugador1Muertos = !jugador1.getPokedex().areAlivePokemon();
        boolean todosPokemonJugador234Muertos = !jugador2.getPokedex().areAlivePokemon()
                && !jugador3.getPokedex().areAlivePokemon()
                && !jugador4.getPokedex().areAlivePokemon();

        if (todosPokemonJugador1Muertos) {
            textArea.append("El Jugador 1 se ha quedado sin Pokémon. ¡Los jugadores 2, 3 y 4 son los ganadores!\n");
        } else if (todosPokemonJugador234Muertos) {
           textArea.append("Los jugadores 2, 3 y 4 se han quedado sin Pokémon. ¡El Jugador 1 es el ganador!\n");
        } else {
            textArea.append("La batalla ha terminado sin un ganador claro.\n");
        }
        frame.setVisible(true); 
    }

    private boolean todosPokemonMuertos() {
        return jugador1.getPokedex().areAlivePokemon() && jugador2.getPokedex().areAlivePokemon();
    }
}



}

