package Dominio;

import Auxiliares.Par;
import java.io.Serializable;

/**
 *
 * @author Santiago Soto 219266
 */
public class Partida implements Serializable {

    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador turno;
    private Tablero tablero;
    private boolean tableroPreConfig;
    private int cantTurnos;
    private int turnosJugados;
    private int puntajeJ1;
    private int puntajeJ2;

    public Partida(Jugador jugador1, Jugador jugador2, Jugador turno,
            int cantTurnos, boolean tableroPreConfig, boolean solitario) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.turno = turno;
        this.cantTurnos = cantTurnos;
        this.tableroPreConfig = tableroPreConfig;
        this.turnosJugados = 0;
        this.tablero = new Tablero(this.tableroPreConfig, jugador1, jugador2, 
                solitario);
        this.puntajeJ1 = 0;
        this.puntajeJ2 = 0;

    }

    public Partida() {
        this.jugador1 = new Jugador("a");
        this.jugador2 = new Jugador("b");
        this.turno = jugador1;
        this.tableroPreConfig = true;
        this.tablero = new Tablero(true, jugador1, jugador2, false);
        this.cantTurnos = 1000;
        this.turnosJugados = 0;
        this.puntajeJ1 = 0;
        this.puntajeJ2 = 0;
    }

    public int getPuntajeJ1() {
        return puntajeJ1;
    }

    public void setPuntajeJ1(int puntajeJ1) {
        this.puntajeJ1 = puntajeJ1;
    }

    public int getPuntajeJ2() {
        return puntajeJ2;
    }

    public void setPuntajeJ2(int puntajeJ2) {
        this.puntajeJ2 = puntajeJ2;
    }

    public Jugador getTurno() {
        return turno;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public int getCantTurnos() {
        return cantTurnos;
    }

    public void setCantTurnos(int cantTurnos) {
        this.cantTurnos = cantTurnos;
    }

    public int getTurnosJugados() {
        return turnosJugados;
    }

    public void setTurnosJugados(int turnosJugados) {
        this.turnosJugados = turnosJugados;
        this.tablero.notifyObservers();

    }

    public void invertirTurno() {
        if (this.jugador1.equals(this.turno)) {
            this.turno = this.jugador2;
        } else {
            this.turno = this.jugador1;
        }
    }

    public Jugador getNoTurno() {
        Jugador ret;
        if (this.turno.equals(this.jugador1)) {
            ret = this.getJugador2();
        } else {
            ret = this.getJugador1();
        }
        return ret;
    }

    public void agregarPuntoJugadorTurno(Jugador ju) {
        if (ju.equals(this.jugador1)) {
            this.puntajeJ1++;
        } else {
            this.puntajeJ2++;
        }
    }

    public boolean hayFichaRoja(Auxiliares.Par pos) 
            throws Exepciones.TableroPosicionNoValida {

        boolean ret = (this.tablero.getPosTabero(pos) != null) && 
                ((this.tablero.getPosTabero(pos).equals(this.jugador1)));

        return ret;
    }

    public boolean hayFichaAzul(Auxiliares.Par pos) throws Exepciones.TableroPosicionNoValida {

        boolean ret = (this.tablero.getPosTabero(pos) != null) && 
                ((this.tablero.getPosTabero(pos).equals(this.jugador2)));

        return ret;
    }

    public boolean hayFichaTurno(Auxiliares.Par pos) throws Exepciones.TableroPosicionNoValida {

        boolean ret = (this.tablero.getPosTabero(pos) != null) &&
                ((this.tablero.getPosTabero(pos).equals(this.turno)));

        return ret;

    }

    public boolean quedanTurnos() {
        return this.getCantTurnos() != 0;
    }

    public void agregarTurno() {
        this.turnosJugados++;
    }

    public void setGanador
        (Jugador ganador, Jugador perdedor, boolean agregarPuntos) {
      
        if (agregarPuntos) {
            int puntos=0;
            if(ganador.equals(this.jugador1)){
                puntos=puntajeJ1;
            }else{
                puntos=puntajeJ2;
            }
            Par[] trianguloTurno = this.getTablero().
                    trianguloMasGrandeParaJugador(ganador);
            int tam = this.getTablero().largoHip(trianguloTurno[0],
                    trianguloTurno[1], trianguloTurno[2]);
            switch (tam) {
                case 5:
                    puntos*=2;
                    break;
                case 7:
                    puntos *= 3;
                    break;
                default:
                   
            }
            ganador.agregarPuntos(puntos);
        }
        ganador.agregarPartidasGanadas();
        perdedor.agregarPartidasJugada();
        ganador.agregarPartidasJugada();
        
    }
}
