package Dominio;

import java.io.Serializable;

/**
 *
 * @author Santiago Soto 219266
 */
public class Partida implements Serializable{

    Jugador jugador1;
    Jugador jugador2;
    Jugador turno;
    Tablero unTablero;
    boolean tableroPreConfig;
    int cantTurnos;
    int turnosJugados;
    int puntajeJ1;
    int puntajeJ2;
    
    public Partida(Jugador jugador1, Jugador jugador2, Jugador turno, int cantTurnos,boolean tableroPreConfig) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.turno = turno;
        this.cantTurnos = cantTurnos;
        this.tableroPreConfig=tableroPreConfig;
        this.turnosJugados=1 ;
        this.unTablero= new Tablero(this.tableroPreConfig, jugador1, jugador2);
        this.puntajeJ1=0;
        this.puntajeJ2=0;
        
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

    public Tablero getUnTablero() {
        return unTablero;
    }

    public void setUnTablero(Tablero unTablero) {
        this.unTablero = unTablero;
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
    }
    
    public void invertirTurno(){
        if(this.jugador1.equals(this.turno)){
           this.turno=this.jugador2; 
        }else{
            this.turno=this.jugador1;
        }
    }
    public Jugador getNoTurno(){
       Jugador ret;
       if(this.turno.equals(this.jugador1)){
            ret=this.getJugador1();
        }else{
           ret= this.getJugador2();
       }
       return ret;
    }
    public void agregarPuntoJugadorTurno(Jugador ju){
        if(ju.equals(this.jugador1)){
            this.puntajeJ1++;
        }else{
            this.puntajeJ2++;
        }
    }
}

