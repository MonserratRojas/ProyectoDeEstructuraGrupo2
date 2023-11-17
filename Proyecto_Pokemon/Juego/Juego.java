package Juego;

public class Juego {
        public static void main(String[] args) {

        Pokedex2 j1Pkdx = new Pokedex2();
        j1Pkdx.inserta(new Pokemon("Meowth", "Normal", 150, 50, 35, 70, 60));
        j1Pkdx.inserta(new Pokemon("Growlithe", "Fuego", 115, 70, 45, 80, 60));
        j1Pkdx.inserta(new Pokemon("Squirtle", "Agua", 190, 55, 45, 75, 65));

        Pokedex2 j2Pkdx = new Pokedex2();
        j2Pkdx.inserta(new Pokemon("Jigglypuff", "Normal", 150, 50, 35, 70, 60));
        j2Pkdx.inserta(new Pokemon("Charmander", "Fuego", 115, 70, 45, 80, 60));
        j2Pkdx.inserta(new Pokemon("Cloyster", "Agua", 190, 55, 45, 75, 65));

        Jugador j1 = new Jugador("Rojo", j1Pkdx);
        Jugador j2 = new Jugador("Gary", j2Pkdx);


        Batalla b1 = new Batalla(j1,j2);
        b1.iniciarBatalla();
}

}
