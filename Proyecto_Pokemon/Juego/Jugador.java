package Juego;

public class Jugador {
    private String nombre;
    private Pokedex2 pokedex;

    public Jugador(String nombre, Pokedex2 pokedex) {
        this.nombre = nombre;
        this.pokedex = pokedex;
    }

    public String getNombre() {
        return nombre;
    }

    public Pokedex2 getPokedex() {
        return pokedex;
    }
    public Pokemon seleccionarPokemon() {
        Pokemon selectedPokemon = pokedex.getRandomPokemon();
        return selectedPokemon;
    }

}
