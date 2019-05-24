package obligatorio2p2;

import Dominio.Jugador;
import Dominio.Partida;
import Dominio.Sistema;
import interfaz.VentanaMenu;
import Musica.*;
import javafx.application.*;
import javafx.stage.Stage;
import javax.swing.UIManager;
import java.awt.Font;

/**
 *
 * @author Santiago Soto 219266
 */
public class Prueba extends Application{

    public static void main(String[] args)  {
      Reproductor unReproductor = new Reproductor("/Mp3/Blues-Loop.mp3");
        unReproductor.start();
        VentanaMenu vent = new VentanaMenu(unReproductor);
        vent.setLocationRelativeTo(null);
        vent.setVisible(true);
        unReproductor.getMediaPlayer().play();
        Sistema s = Sistema.getInstance();
//        if (s.getListaJugadores().size() > 0) {
//            System.out.println("Jugadores en memoria:");
//            s.getListaJugadores().forEach((j) -> {
//                System.out.println("\t" + j);
//            });
//            System.out.println("");
//        } else {
//            System.out.println("No hay Jugadores en memoria\n");
//        }
//
//        if (s.getListaPartidas().size() > 0) {
//            System.out.println("Partidas en memoria:");
//            s.getListaPartidas().forEach((j) -> {
//                System.out.println("\t" + j);
//            });
//            System.out.println("");
//        } else {
//            System.out.println("No hay Partidas en memoria");
//        }
        
    }
    
     @Override
    public void start(Stage primaryStage) throws Exception {
       
    }

}
