package Juego;
//
//public class Pokedex {
//    private Pokemon[] pokemonDisponibles;
//
//    public Pokedex(Pokemon[] pokemonDisponibles) {
//        this.pokemonDisponibles = pokemonDisponibles;
//    }
//
//    public Pokemon obtenerPokemonAleatorio() {
//        if (pokemonDisponibles.length > 0) {
//            int indiceAleatorio = (int) (Math.random() * pokemonDisponibles.length);
//            return pokemonDisponibles[indiceAleatorio];
//        } else {
//            return null;
//        }
//    }
//
//    public void mostrarInformacion() {
//        System.out.println("Pokémon disponibles en el Pokedex:");
//        for (Pokemon pokemon : pokemonDisponibles) {
//            System.out.println(pokemon);
//        }
//    }
//
//    public int getCantidadPokemonRestantes() {
//        return pokemonDisponibles.length;
//    }
//
//    public boolean quedanPokemon() {
//        return pokemonDisponibles.length > 0;
//    }
//    public boolean todosPokemonMuertos() {
//        for (Pokemon pokemon : pokemonDisponibles) {
//            if (pokemon.getVida() > 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//}
//
