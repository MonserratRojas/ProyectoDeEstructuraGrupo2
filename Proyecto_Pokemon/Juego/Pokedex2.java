package Juego;

import java.util.Random;

public class Pokedex2 {
    private Nodo cabeza;

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    public void inserta (Pokemon pokemon){
        if (cabeza== null){
            cabeza = new Nodo(pokemon);
        }
        else{
            Nodo aux = new Nodo(pokemon);
            aux.setNext(cabeza);
            cabeza = aux;
        }
    }

    public void elimina(String nombrePokemon) {
        Nodo anterior = null;
        Nodo actual = cabeza;
        while (actual != null && !actual.getPokemon().getNombre().equals(nombrePokemon)) {
            anterior = actual;
            actual = actual.getNext();
        }
        if (actual != null) {
            if (anterior != null) {
                anterior.setNext(actual.getNext());
            } else {
                cabeza = actual.getNext();
            }
        }
    }

    public void showTeam(){
        System.out.println("Los pokemon en tu equipo son: ");
        pokemonPrinter(cabeza);
    }

    public void pokemonPrinter(Nodo pokemon){
        if (pokemon == null) {
            return;
        }
        String nombrePokemon = pokemon.getPokemon().getNombre();
        System.out.println(nombrePokemon+"\n");
        pokemonPrinter(pokemon.getNext());
    }

    public int availablePokemon (Nodo nodo){
        if (nodo==null){
            return 0;
        }
        return 1+availablePokemon(nodo.getNext());
    }

    public Pokemon getRandomPokemon(){
        if (cabeza == null) {
            return null;
        }
        Random random = new Random();
        int indiceAleatorio = random.nextInt(availablePokemon(cabeza));
        Nodo nodoActual = cabeza;
        for (int i = 0; i < indiceAleatorio; i++) {
            nodoActual = nodoActual.getNext();
        }
        return nodoActual.getPokemon();
    }
    public boolean areAlivePokemon() {
        return availablePokemon(cabeza) > 0;
    }
}

