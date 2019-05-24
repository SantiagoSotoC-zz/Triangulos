/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.Objects;

/**
 *
 * @author Santiago Soto 219266
 */
public class Jugador implements Comparable<Jugador> {

    private String nombre;
    private String alias;
    private int edad;
    private int cantPartidas;
    private int cantGanadas;
    private int cantEmpatadas;
    private int cantPuntos;

    public Jugador(String nombre, String alias, int edad) {
        this.nombre = nombre;
        this.alias = alias;
        this.edad = edad;
        this.cantPartidas = 0;
        this.cantGanadas = 0;
        this.cantEmpatadas = 0;
        this.cantPuntos = 0;
    }

    public Jugador() {
        this.nombre = "";
        this.alias = "";
        this.edad = -1;
        this.cantPartidas = 0;
        this.cantGanadas = 0;
        this.cantEmpatadas = 0;
        this.cantPuntos = 0;
    }

    public Jugador(String alias) {
        this.alias = alias;
        this.nombre = "";
        this.edad = -1;
        this.cantPartidas = 0;
        this.cantGanadas = 0;
        this.cantEmpatadas = 0;
        this.cantPuntos = 0;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCantPartidas() {
        return cantPartidas;
    }

    public void setCantPartidas(int cantPartidas) {
        this.cantPartidas = cantPartidas;
    }

    public int getCantGanadas() {
        return cantGanadas;
    }

    public void setCantGanadas(int cantGanadas) {
        this.cantGanadas = cantGanadas;
    }

    public int getCantEmpatadas() {
        return cantEmpatadas;
    }

    public void setCantEmpatadas(int cantEmpatadas) {
        this.cantEmpatadas = cantEmpatadas;
    }

    @Override
    public boolean equals(Object obj) {
        boolean ret = false;
        Jugador otroJugador = new Jugador("-1", "-1", -1);

        if (obj instanceof Jugador) {
            otroJugador = (Jugador) obj;
        }
        if (otroJugador.getEdad() != -1) {
            if (this.alias.equals(otroJugador.alias)) {
                ret = true;
            }
        }
        return ret;
    }

    @Override
    public int compareTo(Jugador otroJugador) {
        return otroJugador.getCantPuntos() - this.getCantPuntos();
    }

    public int getCantPuntos() {
        return cantPuntos;
    }

    public void setCantPuntos(int cantPuntos) {
        this.cantPuntos = cantPuntos;
    }

    @Override
    public String toString() {
        return  "Alias: "+ this.getAlias() + " Cantidad de partidas ganadas: "+ this.getCantGanadas() + " Puntaje: "+this.getCantPuntos() ;
    }
    

}
