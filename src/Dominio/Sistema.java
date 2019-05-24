package Dominio;

import java.io.*;
import java.util.*;


/**
 *
 * @author Santiago Soto 219266
 */
public class Sistema  extends Observable implements Serializable {

    private ArrayList<Jugador> listaJugadores;
    private ArrayList<Partida> listaPartidas;

    private static Sistema instancia;

    private Sistema() {
        try {
            ObjectInputStream entrada = new ObjectInputStream
        (new FileInputStream("datos"));
            instancia = (Sistema) entrada.readObject();
            listaJugadores = instancia.getListaJugadores();
            listaPartidas = instancia.getListaPartidas();

        } catch (IOException | ClassNotFoundException e) {
            listaJugadores = new ArrayList<>();
            listaPartidas = new ArrayList<>();
        }

    }

    public static Sistema getInstance() {
        if (instancia == null) {
            instancia = new Sistema();
        }
        return instancia;
    }

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
        serializar();
    }

    public ArrayList<Partida> getListaPartidas() {
        return listaPartidas;
    }

    public void setListaPartidas(ArrayList<Partida> listaPartidas) {
        this.listaPartidas = listaPartidas;
        serializar();
    }

    public void addPlayer(Jugador unJugador) {
        this.listaJugadores.add(unJugador);
        setChanged();
        notifyObservers();
        serializar();
    }

    public void addGame(Partida unaPartida) {
        this.listaPartidas.add(unaPartida);
        serializar();
    }

    public void serializar() {
        
        try {
            ObjectOutputStream salida = new ObjectOutputStream
        (new FileOutputStream(new File(("datos"))));
            salida.writeObject(this);
            salida.flush();
            salida.close();
            
        } catch (IOException e) {
        }
    }

    public boolean aliasUnico(String alias){
        return !listaJugadores.stream().anyMatch((jug) -> 
                (jug.getAlias().equals(alias)));
    }
            
}
