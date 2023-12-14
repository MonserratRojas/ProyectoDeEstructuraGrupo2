package Juego;

import Juego.Jugador;
import Juego.Pokedex2;


public class Juego {
    public void iniciarJuego() {
        

        Pokedex2 j1Pkdx = new Pokedex2();
        j1Pkdx.inserta(new Pokemon("Rattata", "Normal", 160, 40, 30, 60, 50)); 
        j1Pkdx.inserta(new Pokemon("Charmander", "Fuego", 115, 70, 45, 80, 60));
        j1Pkdx.inserta(new Pokemon("Squirtle", "Agua", 190, 55, 45, 75, 65));
        j1Pkdx.inserta(new Pokemon("Pidgeotto", "Normal", 170, 55, 40, 70, 55)); 

        Pokedex2 j2Pkdx = new Pokedex2();
        j2Pkdx.inserta(new Pokemon("Pidgeotto", "Normal", 170, 55, 40, 70, 55)); 
        j2Pkdx.inserta(new Pokemon("Charmeleon", "Fuego", 115, 70, 45, 80, 60));
        j2Pkdx.inserta(new Pokemon("Starmie", "Agua", 190, 55, 45, 75, 65));
        j2Pkdx.inserta(new Pokemon("Meowth", "Normal", 165, 45, 35, 65, 50)); 

        Pokedex2 j3Pkdx = new Pokedex2();
        j3Pkdx.inserta(new Pokemon("Squirtle", "Agua", 150, 50, 35, 70, 60));
        j3Pkdx.inserta(new Pokemon("Vulpix", "Fuego", 115, 70, 45, 80, 60));
        j3Pkdx.inserta(new Pokemon("Psyduck", "Agua", 190, 55, 45, 75, 65));
        j3Pkdx.inserta(new Pokemon("Meowth", "Normal", 165, 45, 35, 65, 50)); 

        Pokedex2 j4Pkdx = new Pokedex2();
        j4Pkdx.inserta(new Pokemon("Pidgey", "Normal", 150, 50, 35, 70, 60));
        j4Pkdx.inserta(new Pokemon("Growlithe", "Fuego", 190, 55, 45, 75, 65));
        j4Pkdx.inserta(new Pokemon("Staryu", "Agua", 190, 55, 45, 75, 65));
        j4Pkdx.inserta(new Pokemon("Eevee", "Normal", 160, 45, 40, 65, 55)); 



        Jugador j1 = new Jugador("Rojo", j1Pkdx);
        Jugador j2 = new Jugador("Iris", j2Pkdx);
        Jugador j3 = new Jugador("Máximo", j3Pkdx);
        Jugador j4 = new Jugador("Cynthia", j4Pkdx);
        
        
        Batalla b1 = new Batalla(j1,j2,j3,j4);
        b1.iniciarBatalla();
    }
    
    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.iniciarJuego();
    }
}
