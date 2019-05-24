
package Dominio;

import Exepciones.*;
import Auxiliares.*;
import java.io.BufferedReader;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 *
 * @author Santiago Soto 219266
 */
public class Tablero extends Observable implements Serializable {

    private Jugador[][] tablero;

    public Tablero() {
        tablero = new Jugador[7][7];
    }

    public Tablero(boolean tableroPreConfig, Jugador jugador1, 
            Jugador jugador2, boolean solitario) {
        this.tablero = new Jugador[7][7];
        if (tableroPreConfig) {
            preConfigurado(jugador1, jugador2);
        } else {
            aleatorio(jugador1, jugador2, solitario);
        }
    }

    public boolean mover(Par salida, Par llegada, Par vertice2,
            Par vertice3, Partida par) {
        boolean ret = true;
        int f1 = salida.getI();
        int f2 = llegada.getI();
        int c1 = salida.getJ();
        int c2 = llegada.getJ();

        if (((f1 == f2) || (c1 == c2) || (Math.abs(f1 - f2) 
                == Math.abs(c1 - c2))) && !salida.equals(llegada) &&
                mismoJugador(vertice3, vertice2)
                && !vertice2.equals(salida) && !vertice3.equals(salida)) {
            try {

                Jugador jSalida = getPosTabero(salida);
                if (getPosTabero(llegada) == null && 
                        jSalida.equals(par.getTurno())) {
                    if (caminoLibre(salida, llegada)) {
                        setPosTablero(llegada, jSalida);
                        setPosTablero(salida, null);
                        if (!trianguloValido2(llegada, vertice2, vertice3)) {
                            setPosTablero(llegada, null);
                            setPosTablero(salida, jSalida);
                            ret = false;
                        }
                    } else {
                        ret = false;
                    }
                } else {
                    ret = false;
                }
            } catch (Exception e) {
                ret = false;
            }
        } else {
            ret = false;
        }
        return ret;

    }

    private void preConfigurado(Jugador jTurno, Jugador jNoTurno) {

        this.tablero[1][0] = jTurno;
        this.tablero[3][0] = jTurno;
        this.tablero[6][1] = jTurno;
        this.tablero[5][2] = jTurno;
        this.tablero[1][4] = jTurno;
        this.tablero[6][4] = jTurno;
        this.tablero[2][5] = jTurno;
        this.tablero[3][5] = jTurno;

        this.tablero[5][1] = jNoTurno;
        this.tablero[6][2] = jNoTurno;
        this.tablero[4][4] = jNoTurno;
        this.tablero[1][5] = jNoTurno;
        this.tablero[5][5] = jNoTurno;
        this.tablero[3][6] = jNoTurno;

    }

    private void aleatorio(Jugador jTurno, Jugador jNoTurno, 
            boolean solitario) {
        ArrayList<Par> pares = new ArrayList<>();

        for (int i = 0; i < this.getTablero().length; i++) {
            for (int j = 0; j < this.getTablero()[i].length; j++) {

                Par unPar = new Par(i, j);
                if (posValida(unPar)) {
                    pares.add(unPar);

                }
            }

        }

        if (solitario) {
            ArrayList<Par> remover = new ArrayList<>();

            String posVacias[] = new String[]
            {"B7", "F7", "A6", "G6", "A2", "G2", "B1", "F1"};
            for (Par par : pares) {
                String parString = par.toString();
                for (String posVacia : posVacias) {
                    if (parString.equals(posVacia)) {
                        remover.add(par);
                    }
                }

            }
            pares.removeAll(remover);
        }
        Collections.shuffle(pares);

        for (int i = 0; i < 34; i++) {

            if (i < 17) {
                this.tablero[pares.get(i).getI()]
                        [pares.get(i).getJ()] = jTurno;
            } else {

                this.tablero[pares.get(i).getI()]
                        [pares.get(i).getJ()] = jNoTurno;
            }

        }
        this.setChanged();
        this.notifyObservers();
    }

    public Jugador getPosTabero(Par pos) throws TableroPosicionNoValida {

        if (!posValida(pos)) {
            throw new TableroPosicionNoValida("Posicion no valida");

        } else {
            try {
                return this.tablero[pos.getI()][pos.getJ()];
            } catch (Exception ex) {

            }

        }
        return null;
    }

    public void setPosTablero(Par pos, Object obj)
            throws TableroPosicionNoValida {

        if (!posValida(pos)) {

            throw new TableroPosicionNoValida("Posicion no valida");
        } else {
            if (obj == null) {
                this.getTablero()[pos.getI()][pos.getJ()] = null;
            } else {
                this.getTablero()[pos.getI()][pos.getJ()] = (Jugador) obj;

            }
            this.setChanged();
            this.notifyObservers();
        }

    }

    public boolean posValida(Par par) {
        boolean ret = false;

        int x = par.getI();
        int y = par.getJ();

        if (!((y == 0 && x == 0) || (y == 0 && x == 6) ||
                (y == 6 && x == 0) || (x == 6 && y == 6))) {
            ret = true;
        }

        return ret;
    }

    public Jugador[][] getTablero() {
        return tablero;
    }

    public void setTablero(Jugador[][] tablero) {
        this.tablero = tablero;
    }

    public Par[] verticesHipYotroVertice(Par vertice1, Par vertice2,
            Par vertice3) {
        Par[] vertices = new Par[3];

        if (esHip(vertice1, vertice2)) {
            vertices[0] = vertice1;
            vertices[1] = vertice2;
            vertices[2] = vertice3;

        } else if (esHip(vertice1, vertice3)) {

            vertices[0] = vertice1;
            vertices[1] = vertice3;
            vertices[2] = vertice2;

        } else if (esHip(vertice2, vertice3)) {

            vertices[0] = vertice2;
            vertices[1] = vertice3;
            vertices[2] = vertice1;

        }
        return vertices;
    }

    public boolean mismoJugador(Par vertice1, Par vertice2) {
        Jugador j1;
        boolean ret;
        try {
            j1 = this.getPosTabero(vertice1);

            ret = j1.equals(this.getPosTabero(vertice2));

        } catch (Exception ex) {
            ret = false;
        }
        return ret;
    }

    public boolean mismoJugador(Par vertice1, Par vertice2, Par vertice3) {
        Jugador j1;
        boolean ret;
        try {
            j1 = this.getPosTabero(vertice1);

            ret = j1.equals(this.getPosTabero(vertice2)) 
                    && j1.equals(this.getPosTabero(vertice3));

        } catch (Exception ex) {
            ret = false;
        }
        return ret;
    }

    public boolean esHip(Par vertice1, Par vertice2) {

        return vertice1.getI() == vertice2.getI() || 
                vertice1.getJ() == vertice2.getJ();

    }

    public boolean hipUnica(Par vertice1, Par vertice2, Par vertice3) {
        int cont = 0;
        boolean ret = false;
        if (esHip(vertice1, vertice2)) {
            cont++;
        }
        if (esHip(vertice1, vertice3)) {
            cont++;
        }
        if (esHip(vertice2, vertice3)) {
            cont++;
        }
        if (cont == 1) {
            ret = true;
        }
        return ret;
    }

    public int largoHip(Par vertice1, Par vertice2) {
        int ret = -1;
        if (vertice1.getI() == vertice2.getI()) {
            ret = vertice1.difJ(vertice2);

        } else if (vertice1.getJ() == vertice2.getJ()) {
            ret = vertice1.difI(vertice2);
        }
        return ret + 1;
    }

    @Override
    public boolean equals(Object obj) {
        Tablero otroTablero = (Tablero) obj;
        boolean ret = true;
        if (this.tablero.length == otroTablero.getTablero().length 
                && this.tablero[0].length == otroTablero.getTablero().length) {
            for (int i = 0; i < this.tablero.length; i++) {
                for (int j = 0; j < this.tablero[0].length; j++) {
                    try {
                        if (ret &&
                                this.tablero[i][j].
                                        equals(otroTablero.getTablero()[i][j])) {
                            ret = true;
                        } else {
                            ret = false;
                            break;
                        }
                    } catch (NullPointerException ex) {
                        ret = false;
                    }
                }
            }
        }
        return ret;
    }

    public boolean caminoLibre(Par salida, Par llegada) {
        boolean libre = true;
        Jugador[][] tab = this.getTablero();
        if (salida.equals(llegada)) {
            return false;
        }
        salida.invertir();
        llegada.invertir();

        int difY = llegada.getJ() - salida.getJ();
        int difX = llegada.getI() - salida.getI();

        if (difX == 0) {
            if (difY < 0) {//arriba
                for (int i = 1; i < Math.abs(difY); i++) {
                    if (tab[salida.getJ() - i][salida.getI()] != null) {
                        libre = false;
                        break;
                    }

                }
            } else {
                for (int i = 1; i < Math.abs(difY); i++) {//abajo
                    if (tab[salida.getJ() + i][salida.getI()] != null) {
                        libre = false;
                        break;
                    }
                }
            }
        } else if (difY == 0) {
            if (difX < 0) {
                for (int i = 1; i < Math.abs(difX); i++) {//izquierda
                    if (tab[salida.getJ()][salida.getI() - i] != null) {
                        libre = false;
                        break;
                    }
                }
            } else {
                for (int i = 1; i < Math.abs(difX); i++) {//izquierda
                    if (tab[salida.getJ()][salida.getI() + i] != null) {
                        libre = false;
                        break;
                    }
                }
            }
        } else {

            if (difX > 0 && difY > 0) {//abajo derecha
                for (int i = 1; i < Math.abs(difX); i++) {
                    if (tab[salida.getJ() + i][salida.getI() + i] != null) {
                        libre = false;
                        break;
                    }
                }
            }
            if (difX > 0 && difY < 0) {//arriba derecha
                for (int i = 1; i < Math.abs(difX); i++) {
                    if (tab[salida.getJ() - i][salida.getI() + i] != null) {
                        libre = false;
                        break;
                    }
                }
            }
            if (difX < 0 && difY < 0) {//arriba izquierda
                for (int i = 1; i < Math.abs(difX); i++) {
                    if (tab[salida.getJ() - i][salida.getI() - i] != null) {
                        libre = false;
                        break;
                    }
                }
            }
            if (difX < 0 && difY > 0) {//abajo izquirda
                for (int i = 1; i < Math.abs(difX); i++) {
                    if (tab[salida.getJ() + i][salida.getI() - i] != null) {
                        libre = false;
                        break;
                    }
                }
            }
        }
        salida.invertir();
        llegada.invertir();
        return libre;
    }

    public int largoHip(Par vertice1, Par vertice2, Par vertice3) {
        Par[] ordenado = verticesHipYotroVertice(vertice1, vertice2, vertice3);
        Par ver1 = ordenado[0];
        Par ver2 = ordenado[1];
        return largoHip(ver1, ver2);
    }

    public Par[] trianguloMasGrandeParaJugador(Jugador ju) throws NullPointerException {
        Par[] ret = new Par[3];
        int maxHip = 0;
        ArrayList<Par[]> triangulosJugador = buscadorDeTriangulos(ju);

        for (int i = 0; i < triangulosJugador.size(); i++) {
            int largoHip = largoHip(triangulosJugador.get(i)[0], triangulosJugador.get(i)[1], triangulosJugador.get(i)[2]);

            if (maxHip < largoHip) {
                maxHip = largoHip;
                ret = new Par[]{triangulosJugador.get(i)[0], triangulosJugador.get(i)[1], triangulosJugador.get(i)[2]};
            }
        }

        return ret;
    }

    public boolean triangulosIguales(Par t1v1, Par t1v2, Par t1v3, Par t2v1, Par t2v2, Par t2v3) {
        Par[] t2 = {t2v1, t2v2, t2v3};
        return t1v1.equalAlguno(t2) && t1v2.equalAlguno(t2) && t1v3.equalAlguno(t2);
    }

    public ArrayList<Par[]> buscadorDeTriangulos(Jugador ju) {
        ArrayList<Par[]> ret = new ArrayList<>();
        ArrayList<Par> fichasJug = buscadorDeFichas(ju);
        for (int i = 0; i < fichasJug.size(); i++) {
            Par cord1 = fichasJug.get(i);
            for (int j = i + 1; j < fichasJug.size(); j++) {
                Par cord2 = fichasJug.get(j);
                for (int k = j + 1; k < fichasJug.size(); k++) {
                    Par cord3 = fichasJug.get(k);
                    try {
                        if (trianguloValido2(cord1, cord2, cord3)) {
                            Par[] aux = {cord1, cord2, cord3};
                            if (!ret.contains(aux)) {
                                ret.add(aux);
                            }
                        }
                    } catch (Exception ex) {

                    }
                }
            }
        }

        return ret;
    }

    public ArrayList<Par> buscadorDeFichas(Jugador ju) {
        ArrayList<Par> ret = new ArrayList<>();
        for (int i = 0; i < this.tablero.length; i++) {
            for (int j = 0; j < this.tablero[i].length; j++) {
                try {
                    Par unPar = new Par(i, j);
                    if (this.getPosTabero(unPar).equals(ju)) {
                        ret.add(unPar);
                    }
                } catch (Exception ex) {

                }

            }
        }
        return ret;
    }

    public static int[] puntoMedio(int x1, int y1, int x2, int y2) {
        int ret[] = new int[2];
        ret[0] = (x1 + x2) / 2;
        ret[1] = (y1 + y2) / 2;
        return ret;
    }

    public static double distancia(double x1, double y1, double x2, double y2) {

        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

    }

    public boolean trianguloValido2(Par p1, Par p2, Par p3) {
        boolean cumple = false;
        try {

            int datos[] = {p1.getI(), p1.getJ(), p2.getI(), p2.getJ(), p3.getI(), p3.getJ()};
            // a 0,1
            // b 2,3
            // c 4,5

            double ab = distancia(datos[0], datos[1], datos[2], datos[3]);
            double bc = distancia(datos[2], datos[3], datos[4], datos[5]);
            double ac = distancia(datos[0], datos[1], datos[4], datos[5]);

            int[] puntoD;
            double altura = 0;
            if ((ab == bc && bc != ac)) {
                puntoD = puntoMedio(datos[0], datos[1], datos[4], datos[5]);
                altura = distancia(puntoD[0], puntoD[1], datos[2], datos[3]);

                if (datos[0] == datos[4] || datos[1] == datos[5]) {
                    if (ac / 2 == altura) {
                        cumple = true;
                    }
                }
            } else if (ab == ac && ab != bc) {
                puntoD = puntoMedio(datos[2], datos[3], datos[4], datos[5]);
                altura = distancia(puntoD[0], puntoD[1], datos[0], datos[1]);
                if (datos[2] == datos[4] || datos[3] == datos[5]) {
                    if (bc / 2 == altura) {
                        cumple = true;
                    }
                }
            } else if (bc == ac && ac != ab) {
                puntoD = puntoMedio(datos[0], datos[1], datos[2], datos[3]);
                altura = distancia(puntoD[0], puntoD[1], datos[4], datos[5]);
                if (datos[0] == datos[2] || datos[1] == datos[3]) {
                    if (ab / 2 == altura) {
                        cumple = true;
                    }
                }
            }

        } catch (Exception ex) {
            cumple = true;
        }
        return cumple && mismoJugador(p1, p2, p3);

    }

    public Par[] capturarFichas(Par p1, Par p2, Par p3, Partida unaPartida) {
        Par aux[] = verticesHipYotroVertice(p1, p2, p3);
        p1 = aux[0];
        p2 = aux[1];
        p3 = aux[2];
        Par[] datos = capturarFichas(p1, p2, p3, false);

        Par[] ret = new Par[0];

        for (int i = 0; i < datos.length; i++) {
            try {
                if (this.getPosTabero(datos[i]) != null) {

                    this.setPosTablero(datos[i], null);
                    ret = concatenate(ret, new Par[]{datos[i]});
                    if (this.getPosTabero(datos[i]).equals(unaPartida.getNoTurno())) {
                        unaPartida.agregarPuntoJugadorTurno(unaPartida.getTurno());
                    }

                }
            } catch (TableroPosicionNoValida | NullPointerException ex) {

            }
        }

        return ret;

    }

    private Par[] capturarFichas(Par p1, Par p2, Par p3, boolean rec) {
        Par[] ret = new Par[0];
        int largoHip = largoHip(p1, p2, p3);
        if (largoHip == 3) {
            if (!rec) {
                ret = new Par[]{p1.puntoMedio(p2)};
            } else {
                ret = new Par[]{p1.puntoMedio(p2), p1, p2};
            }
        } else {
            if (largoHip == 5) {
                ret = capturarFichas(p1.puntoMedio(p3), p2.puntoMedio(p3), p3, true);
                ret = concatenate(ret, new Par[]{p1.puntoMedio(p2).puntoMedio(p1), p1.puntoMedio(p2).puntoMedio(p2), p1.puntoMedio(p2)});

            } else {
                if (largoHip == 7) {
                    ret = concatenate(ret, new Par[]{p1.puntoMedio(p2)});
                    if (p1.difI(p2) == 0) {
                        Par[] aux = new Par[]{new Par(p1.getI(), p1.getJ() + 1),
                            new Par(p1.getI(), p1.getJ() + 2), new Par(p1.getI(), p1.getJ() + 4), new Par(p1.getI(), p1.getJ() + 5)};

                        ret = concatenate(ret, aux);
                    } else {
                        Par[] aux = new Par[]{new Par(p1.getI() + 1, p1.getJ()),
                            new Par(p1.getI() + 2, p1.getJ()), new Par(p1.getI() + 3, p1.getJ()), new Par(p1.getI() + 4, p1.getJ()), new Par(p1.getI() + 5, p1.getJ())};

                        ret = concatenate(ret, aux);
                    }
                }
            }
        }
        this.setChanged();
        this.notifyObservers();
        return ret;
    }

    public synchronized ArrayList<Par[]> movimientosPosibles(Partida unaPartida) {
        ArrayList<Par[]> ret = new ArrayList<>();
        int tam = this.getTablero().length;
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                Par salida = new Par(i, j);
                try {
                    if (this.getPosTabero(salida).equals(unaPartida.getTurno())) {
                        for (int k = 0; k < tam; k++) {
                            for (int l = 0; l < tam; l++) {
                                Par llegada = new Par(k, l);
                                if (this.posValida(salida) && this.posValida(llegada)) {

                                    for (int m = 0; m < tam; m++) {
                                        for (int n = 0; n < tam; n++) {
                                            Par v1 = new Par(m, n);

                                            for (int o = 0; o < tam; o++) {
                                                for (int p = 0; p < tam; p++) {
                                                    Par v2 = new Par(o, p);

                                                    if (mover(salida, llegada, v1, v2, unaPartida)) {
                                                        try {
                                                            this.setPosTablero(salida, this.getPosTabero(llegada));
                                                            this.setPosTablero(llegada, null);
                                                            ret.add(new Par[]{salida, llegada, v1, v2});
                                                        } catch (TableroPosicionNoValida e) {
                                                            System.out.println(e.toString());
                                                        }

                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception ex) {

                }
            }
        }
        return ret;
    }

    private <T> T[] concatenate(T[] a, T[] b) {
        int aLen = a.length;
        int bLen = b.length;

        @SuppressWarnings("unchecked")
        T[] c = (T[]) Array.newInstance(a.getClass().getComponentType(), aLen + bLen);
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);

        return c;
    }

}
