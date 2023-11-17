package Juego;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ReproductorSonido {
        public static void reproducirSonidoWAV(String rutaArchivo) {
            try {
                File archivoSonido = new File(rutaArchivo);
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivoSonido);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        }
    }

