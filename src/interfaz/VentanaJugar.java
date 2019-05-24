/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import Auxiliares.Par;
import Dominio.Jugador;
import Dominio.Partida;
import Dominio.Sistema;
import Exepciones.TableroPosicionNoValida;
import Musica.Reproductor;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author alumnoFI
 */
public class VentanaJugar extends javax.swing.JFrame implements Observer {

    private AuxMovsPosibles ventMovsAux;

    /**
     * Creates new form VentanaJugar
     *
     * @param unaPartida
     * @param rep
     * @param solitario
     */
    public VentanaJugar(Partida unaPartida, Reproductor rep, boolean solitario) {
        this.solitario = solitario;
        this.ayuda = false;
        this.unaPartida = unaPartida;
        this.unReproductor = rep;
        initComponents();
        this.unReproductor.getObs().addObserver(this);
        cargarIconosPorDefecto();
        iniciarTablero();
        this.setTitle("TRIANGULOS");
        URL iconURL = getClass().getResource("/imagenes/iconoTringulo.png");
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());
        ventMovsAux = new AuxMovsPosibles(unaPartida, this);
//        ventMovsAux.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        if (solitario) {
            this.btnAbandonar.setEnabled(false);
            this.btnTerminar.setEnabled(false);
            this.btnSaltarTurno.setEnabled(false);
        }

    }

    private void cargarIconosPorDefecto() {

        this.iconoFichasRojas = new ImageIcon(getClass().getResource("/imagenes/fichaRoja.png"));
        this.iconoFichasAzules = new ImageIcon(getClass().getResource("/imagenes/fichaAzul.png"));

    }

    private void iniciarTablero() {
        panelJuego.setLayout(new GridLayout(8, 8));
        botones = new JButton[9][9];
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                JButton jButton = new JButton();
                jButton.addActionListener(new ListenerBoton(i, j));
                panelJuego.add(jButton);
                botones[i][j] = jButton;
                botones[i][j].setOpaque(true);
                botones[i][j].setBorderPainted(true);

            }
        }
        cargarPosciosionesBotones();
        eliminarEsquinas();
        unaPartida.getTablero().addObserver(this);
    }

    private void eliminarEsquinas() {
        this.botones[1][2].setVisible(false);
        this.botones[1][this.botones.length - 1].setVisible(false);
        this.botones[this.botones.length - 2][2].setVisible(false);
        this.botones[this.botones.length - 2][this.botones.length - 1].setVisible(false);

    }

    private void cargarPosciosionesBotones() {
        for (int i = 0; i < botones.length - 1; i++) {
            this.botones[this.botones.length - 1][i + 1].setText((char) ('A' + i - 1) + "");
            this.botones[this.botones.length - 1][i + 1].setFont(new Font("Game of Brush", Font.PLAIN, 20));
            this.botones[this.botones.length - 1][i + 1].setEnabled(false);
            this.botones[this.botones.length - 1][i + 1].setBackground(new java.awt.Color(200, 231, 221));
            this.botones[this.botones.length - 1][i + 1].setBorderPainted(false);
        }

        this.botones[this.botones.length - 1][1].setVisible(false);

        for (int i = 1; i < botones.length - 1; i++) {
            this.botones[i][1].setText((7 - i + 1) + "");
            this.botones[i][1].setBackground(new java.awt.Color(200, 231, 221));
            this.botones[i][1].setFont(new Font("Game of Brush", Font.PLAIN, 20));
            this.botones[i][1].setEnabled(false);
            this.botones[i][1].setBorderPainted(false);
        }
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                if (this.botones[i][j].isEnabled()) {
                    botones[i][j].setBackground(new java.awt.Color(181, 213, 191));
                    botones[i][j].setBorder(new LineBorder(new Color(236, 243, 249), 3));

                }
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelJuego = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTurno = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnAbandonar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnSaltarTurno = new javax.swing.JButton();
        btnTerminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(950, 700));
        setResizable(false);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        panelJuego.setBackground(new java.awt.Color(200, 231, 221));
        panelJuego.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(200, 231, 221)));
        panelJuego.setFocusTraversalPolicyProvider(true);
        panelJuego.setMaximumSize(null);
        panelJuego.setLayout(new java.awt.GridLayout(1, 0));
        jPanel1.add(panelJuego);

        jPanel2.setBackground(new java.awt.Color(200, 231, 221));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(236, 243, 249)));
        jPanel2.setMinimumSize(new java.awt.Dimension(120, 120));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Game of Brush", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TURNO");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 550, 150, 60);

        txtTurno.setFont(new java.awt.Font("Game of Brush", 0, 12)); // NOI18N
        txtTurno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTurno.setText("JTURNO");
        jPanel2.add(txtTurno);
        txtTurno.setBounds(10, 610, 150, 50);

        jLabel2.setFont(new java.awt.Font("Game of Brush", 0, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("RESTANTES");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 110, 150, 40);

        jLabel3.setFont(new java.awt.Font("Game of Brush", 0, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("jLabel3");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 150, 150, 50);

        jLabel4.setFont(new java.awt.Font("Game of Brush", 0, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("TURNOS");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 60, 150, 40);

        jButton1.setText("CAMBIAR FICHAS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(20, 380, 120, 60);

        jButton2.setText("AYUDA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(20, 500, 120, 60);

        jButton3.setText("GUARDAR FOTO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(20, 260, 120, 60);

        btnAbandonar.setText("ABANDONAR");
        btnAbandonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbandonarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAbandonar);
        btnAbandonar.setBounds(20, 320, 120, 60);

        jButton5.setText("MUSICA OFF");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(0, 0, 160, 29);

        btnSaltarTurno.setText("SALTAR TURNO");
        btnSaltarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaltarTurnoActionPerformed(evt);
            }
        });
        jPanel2.add(btnSaltarTurno);
        btnSaltarTurno.setBounds(20, 200, 120, 60);

        btnTerminar.setText("TERMINAR");
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnTerminar);
        btnTerminar.setBounds(20, 440, 120, 60);

        jPanel1.add(jPanel2);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VentanaCambiarFichas vent = new VentanaCambiarFichas(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ayuda();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ayuda() {
        if (!ayuda) {
            borrarCliks();
            resetBackground();
            JOptionPane.showMessageDialog(this, "Elija una poscicion vacia para la ayuda");
            ayuda = !ayuda;
        }
    }

    private void ayuda(Par unPar) {
        if (!ayuda) {
            borrarCliks();
            resetBackground();
            JOptionPane.showMessageDialog(this, "Elija una poscicion vacia para la ayuda");
            ayuda = true;
        } else {

            if (VentAyuda == null) {
                VentAyuda = new VentanaAyuda(this.ventMovsAux, unPar);
            } else {
                VentAyuda.actualizarLista(unPar);

            }

            VentAyuda.setVisible(true);
            ayuda = false;
        }
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("TXT", "txt");
        fc.setFileFilter(filtro);
        fc.setAcceptAllFileFilterUsed(false);
        int resp = fc.showSaveDialog(this);
        String loc = fc.getSelectedFile().toString();
        if (!loc.endsWith(".txt")) {
            loc += ".txt";
        }
        if (resp == JFileChooser.APPROVE_OPTION) {
            File file = new File(loc);
            FileWriter fw;
            try {
                fw = new FileWriter(file);
                Date fecha = new Date();
                fw.write(fecha.toString());
                fw.write(printTablero());
                fw.flush();
                fw.close();
            } catch (IOException ex) {

            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnAbandonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbandonarActionPerformed
        //Abandonar: la gana el otro jugador, no suma puntos
        JOptionPane.showMessageDialog(this, "GANO: " + unaPartida.getNoTurno().toString().toUpperCase(), "", JOptionPane.OK_OPTION);
        this.dispose();
    }//GEN-LAST:event_btnAbandonarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        cambiarEstadoMusica();

    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnSaltarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaltarTurnoActionPerformed
        if (this.ventMovsAux.movsPosibles.size() == 0) {
            this.unaPartida.agregarTurno();
            this.update();
        } else {
            JOptionPane.showMessageDialog(this, "Tiene movimietos posibles,"
                    + " no puede saltar de turno");

        }
    }//GEN-LAST:event_btnSaltarTurnoActionPerformed

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
        //terminar en este momento gana mayor triangulo
        if (ganoTurno()) {
                    JOptionPane.showMessageDialog(this, "GANO: " + unaPartida.getTurno().toString().toUpperCase(), "", JOptionPane.OK_OPTION);
                    int tam =this.tamTrianguloMasGrandeTurno();
                    unaPartida.setGanador(unaPartida.getTurno(), unaPartida.getNoTurno(), true);
                } else {
                    JOptionPane.showMessageDialog(this, "GANO: " + unaPartida.getNoTurno().toString().toUpperCase(), "", JOptionPane.OK_OPTION);
                    unaPartida.setGanador(unaPartida.getNoTurno(), unaPartida.getTurno(), true);
                }
    }//GEN-LAST:event_btnTerminarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbandonar;
    private javax.swing.JButton btnSaltarTurno;
    private javax.swing.JButton btnTerminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelJuego;
    private javax.swing.JLabel txtTurno;
    // End of variables declaration//GEN-END:variables
    private JButton[][] botones;
    private final Partida unaPartida;
    public ImageIcon iconoFichasRojas;
    public ImageIcon iconoFichasAzules;
    private final Reproductor unReproductor;
    private boolean ayuda;
    private VentanaAyuda VentAyuda;
    private boolean solitario;

    public void update() {
        actualizarBtnMusica();
        this.txtTurno.setText(unaPartida.getTurno().getAlias().toUpperCase());
        for (int i = 0; i < unaPartida.getTablero().getTablero().length; i++) {
            for (int j = 0; j < unaPartida.getTablero().getTablero()[i].length; j++) {
                Par unaPos = new Par(i, j);
                try {
                    if (this.unaPartida.hayFichaAzul(unaPos)) {
                        this.botones[i + 1][j + 2].setIcon(iconoFichasAzules);
                    } else if (this.unaPartida.hayFichaRoja(unaPos)) {
                        this.botones[i + 1][j + 2].setIcon(iconoFichasRojas);
                    } else {

                        this.botones[i + 1][j + 2].setIcon(null);
                    }
                } catch (TableroPosicionNoValida ex) {

                }
            }
        }
        this.jLabel3.setText((unaPartida.getCantTurnos() - unaPartida.getTurnosJugados()) + "");
        if (VentAyuda != null) {
            VentAyuda.setVisible(false);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        update();

    }

    private void cambiarEstadoMusica() {

        if (this.unReproductor.getMediaPlayer().getVolume() == 0.0) {

            this.unReproductor.getMediaPlayer().setVolume(1.0);
            this.jButton5.setText("MUSICA OFF");

        } else {

            this.unReproductor.getMediaPlayer().setVolume(0.0);
            this.jButton5.setText("MUSICA ON ");

        }

        this.unReproductor.getObs().setChanged();
        this.unReproductor.getObs().notifyObservers();

    }

    private void actualizarBtnMusica() {
        if (this.unReproductor.getMediaPlayer().getVolume() == 0.0) {

            this.jButton5.setText("MUSICA ON ");

        } else {

            this.jButton5.setText("MUSICA OFF");

        }
    }

    private class ListenerBoton implements ActionListener {

        private int x;
        private int y;

        public ListenerBoton(int i, int j) {
// en el constructor se almacena la fila y columna que se presionó
            x = i;
            y = j;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
// cuando se presiona un botón, se ejecutará este método
            if (!ayuda) {
                clickBoton(x, y);
            } else {
                Par click = new Par(x - 1, y - 2);
                ayuda(click);

            }
        }
    }
    public final Par[] clicks = new Par[4];

    private void clickBoton(int fila, int columna) {

        Par click = new Par(fila - 1, columna - 2);
        for (int i = 0; i < clicks.length; i++) {
            if (clicks[i] == null) {
                clicks[i] = click;
                if (i == 2) {
                    botones[fila][columna].setBackground(Color.YELLOW);
                } else if (i == 3) {
                    botones[fila][columna].setBackground(Color.RED);
                }
                break;
            }
        }
        if (clicks[0] == click && clicks[1] == null) {
            try {
                if (unaPartida.hayFichaTurno(click)) {
                    botones[fila][columna].setBackground(Color.CYAN);

                } else {
                    if (unaPartida.getTablero().getPosTabero(click) != null) {
                        JOptionPane.showMessageDialog(this, "Esta ficha es del juador contrario");
                    } else {
                        JOptionPane.showMessageDialog(this, "Esta posicion esta vacia");
                    }
                    clicks[0] = null;
                }
            } catch (TableroPosicionNoValida ex) {

            }

        } else {
            try {
                if (unaPartida.getTablero().getPosTabero(click) == null) {
                    botones[fila][columna].setBackground(Color.DARK_GRAY);
                } else {

                }
            } catch (TableroPosicionNoValida ex) {

            }
        }

//        System.out.println(java.util.Arrays.toString(clicks));
        if (clicks[0] != null && clicks[1] != null && clicks[2] == null && clicks[3] == null) {
            boolean camLibre = unaPartida.getTablero().caminoLibre(clicks[0], clicks[1]);
            if (!camLibre) {
                clicks[0] = null;
                clicks[1] = null;
                resetBackground();
                JOptionPane.showMessageDialog(this, "No tiene el camino libre para realizar este movimiento");

            }

        }
        if (clicks[3] != null) {

            boolean movio = unaPartida.getTablero().mover(clicks[0], clicks[1], clicks[2], clicks[3], unaPartida);
            if (movio) {
                if (!solitario) {
                    unaPartida.invertirTurno();
                } else {
                    try {
                        this.unaPartida.getTablero().setPosTablero(clicks[1], null);
                        this.unaPartida.getTablero().setPosTablero(clicks[2], null);
                        this.unaPartida.getTablero().setPosTablero(clicks[3], null);
                        String mensaje = "LAS FICHAS " + clicks[1] + "," + clicks[2] + "," + clicks[3] + " FUERON REMOVIDAS";
                        JOptionPane.showMessageDialog(this, mensaje);
                    } catch (TableroPosicionNoValida ex) {
                    }
                }

                Par[] fichasCaputradas = unaPartida.getTablero().capturarFichas(clicks[1], clicks[2], clicks[3], unaPartida);

                switch (fichasCaputradas.length) {
                    case 0:
                        JOptionPane.showMessageDialog(this, "USTED NO CAPTURO FICHAS  "
                                + "", "FICHAS CAPTURADAS", 2);
                        break;
                    case 1:
                        resetBackground();
                        JOptionPane.showMessageDialog(this, "USTED CAPTURO LA FICHA  "
                                + Arrays.toString(fichasCaputradas), "FICHAS CAPTURADAS", 2);
                        break;
                    default:
                        JOptionPane.showMessageDialog(this, "USTED CAPTURO LAS FICHAS  "
                                + Arrays.toString(fichasCaputradas), "FICHAS CAPTURADAS", 2);
                        break;
                }

                unaPartida.setTurnosJugados(unaPartida.getTurnosJugados() + 1);
                this.jLabel3.setText(this.unaPartida.getCantTurnos() - this.unaPartida.getTurnosJugados() + "");

            }

            borrarCliks();
            resetBackground();
            ventMovsAux.actualizar();
            if (this.ventMovsAux.movsPosibles.isEmpty()) {
                if (!solitario) {
                    int saltar = JOptionPane.showConfirmDialog(this, "Desea saltar de turno", "SIN MOVIMIENTOS", JOptionPane.YES_NO_OPTION);
                    if (saltar == 0) {

                        unaPartida.invertirTurno();
                        unaPartida.setTurnosJugados(unaPartida.getTurnosJugados() + 1);

                    }
                } else {
                    update();
                    resetBackground();
                    JOptionPane.showMessageDialog(this, "PERDIO NO TIENE MOVIMIETOS POSIBLES", "", JOptionPane.OK_OPTION);
                    this.dispose();
                }
            }
        }

        update();

        this.ventMovsAux.actualizar();
        if (ganoSolitario()) {
            resetBackground();
            JOptionPane.showMessageDialog(this, "GANO", "", JOptionPane.OK_OPTION);
            this.dispose();
        } else {
            if (unaPartida.getCantTurnos() - unaPartida.getTurnosJugados() == 0 ) {
                if (ganoTurno()) {
                    JOptionPane.showMessageDialog(this, "GANO: " + unaPartida.getTurno().toString().toUpperCase(), "", JOptionPane.OK_OPTION);
                    int tam =this.tamTrianguloMasGrandeTurno();
                    unaPartida.setGanador(unaPartida.getTurno(), unaPartida.getNoTurno(), true);
                } else if (tamTrianguloMasGrandeTurno() != tamTrianguloMasGrandeNoTurno()){
                    JOptionPane.showMessageDialog(this, "GANO: " + unaPartida.getNoTurno().toString().toUpperCase(), "", JOptionPane.OK_OPTION);
                    unaPartida.setGanador(unaPartida.getNoTurno(), unaPartida.getTurno(), true);
                }else{
                    JOptionPane.showMessageDialog(this, "EMPATE ", "", JOptionPane.OK_OPTION);
                    unaPartida.getJugador1().agregarPartidaEmpatada();
                    unaPartida.getJugador2().agregarPartidaEmpatada();
                }

                this.dispose();
            }
        }
    }

    public void borrarCliks() {
        for (int i = 0; i < clicks.length; i++) {
            clicks[i] = null;
        }
    }

    public void resetBackground() {
        for (int i = 1; i < botones.length - 1; i++) {
            for (int j = 2; j < botones.length; j++) {
                Par pos = new Par(i - 1, j - 2);
                if (unaPartida.getTablero().posValida(pos)) {

                    botones[i][j].setBackground(new java.awt.Color(181, 213, 191));
                }
            }

        }

    }

    public boolean ganoSolitario() {

        return solitario && this.unaPartida.getTablero().buscadorDeFichas(unaPartida.getNoTurno()).isEmpty();

    }

    public boolean ganoTurno() {
        Par[] trianguloTurno = unaPartida.getTablero().trianguloMasGrandeParaJugador(unaPartida.getTurno());
        Par[] trianguloNoTurno = unaPartida.getTablero().trianguloMasGrandeParaJugador(unaPartida.getNoTurno());

        int tamTurno = unaPartida.getTablero().largoHip(trianguloTurno[0], trianguloTurno[1], trianguloTurno[2]);
        int tamNoTruno = unaPartida.getTablero().largoHip(trianguloNoTurno[0], trianguloNoTurno[1], trianguloNoTurno[2]);
        return tamTurno > tamNoTruno && unaPartida.getTurnosJugados() == unaPartida.getCantTurnos();
    }

    public int tamTrianguloMasGrandeTurno() {
        Par[] trianguloTurno = unaPartida.getTablero().trianguloMasGrandeParaJugador(unaPartida.getTurno());
        int tamTurno = unaPartida.getTablero().largoHip(trianguloTurno[0], trianguloTurno[1], trianguloTurno[2]);
        return tamTurno; 
    }
    public int tamTrianguloMasGrandeNoTurno() {
        Par[] trianguloTurno = unaPartida.getTablero().trianguloMasGrandeParaJugador(unaPartida.getNoTurno());
        int tamNoTurno = unaPartida.getTablero().largoHip(trianguloTurno[0], trianguloTurno[1], trianguloTurno[2]);
        return tamNoTurno; 
    }

    public String printTablero() {
        String ret = "\n";
        Jugador[][] tab = unaPartida.getTablero().getTablero();
        ret += "  \t  +-+-+-+-+-+\n";
        for (int i = 0; i < tab.length; i++) {
            ret+= (i +1 )+ "\t";
            for (int j = 0; j < tab[i].length; j++) {
                try {
                    
                    Par pos = new Par(i, j);
                    if (unaPartida.hayFichaRoja(pos)) {
                        ret += "|R";
                    } else if (unaPartida.hayFichaAzul(pos)) {
                        ret += "|A";
                    } else {
                        ret += "| ";
                    }
                } catch (TableroPosicionNoValida ex) {
                    if (i == tab.length - 1 && j == tab[i].length - 1) {
                        ret += "|";
                    } else {
                        if (i != 1 && j != 6) {
                            ret += "  ";
                        }
                    }
                }

            }
            if (i < tab.length - 1) {
                ret += "|\n\t+-+-+-+-+-+-+-+\n";
            } else {
                ret += "\n\t  +-+-+-+-+-+\n";
            }
            
        }
        ret+="\t A B C D E F G";
        return ret;
    }
    @Override
    public void dispose(){
        Sistema.getInstance().addGame(unaPartida);
        super.dispose();
    }
}
