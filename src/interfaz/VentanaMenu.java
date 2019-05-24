package interfaz;

import Dominio.*;
import Musica.Reproductor;
import java.awt.Font;
import java.awt.HeadlessException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.plaf.FontUIResource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Santiago Soto 219266
 */
public class VentanaMenu extends javax.swing.JFrame implements Observer {

    public VentanaMenu(Reproductor rep) {
        URL iconURL = getClass().getResource("/imagenes/iconoTringulo.png");
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());
        this.unReproductor = rep;
        this.unReproductor.getObs().addObserver(this);
        initComponents();
        this.setTitle("TRIANGULOS");
        actualizarBtnMusica();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        jPanel1 = new javax.swing.JPanel();
        lblInversiones = new javax.swing.JLabel();
        btnRanking = new javax.swing.JButton();
        btnAyuda = new javax.swing.JButton();
        btnRegistrarJugador = new javax.swing.JButton();
        btnJugar = new javax.swing.JButton();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        btnMusica = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(205, 221, 240));
        setMinimumSize(new java.awt.Dimension(647, 450));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(199, 231, 221));
        jPanel2.setToolTipText("");
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setDoubleBuffered(false);
        jPanel2.setMaximumSize(new java.awt.Dimension(647, 450));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(filler3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 164, 117, -1));

        jPanel1.setBackground(new java.awt.Color(181, 213, 191));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(236, 243, 249), 4));

        lblInversiones.setFont(new java.awt.Font("Game of Brush", 0, 32)); // NOI18N
        lblInversiones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInversiones.setText("TRIANGULOS");
        lblInversiones.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        btnRanking.setBackground(new java.awt.Color(207, 232, 239));
        btnRanking.setFont(new java.awt.Font("Game of Brush", 0, 13)); // NOI18N
        btnRanking.setText("RANKING");
        btnRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRankingActionPerformed(evt);
            }
        });

        btnAyuda.setBackground(new java.awt.Color(207, 232, 239));
        btnAyuda.setFont(new java.awt.Font("Game of Brush", 0, 13)); // NOI18N
        btnAyuda.setText("JUGAR SOLITARIO");
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });

        btnRegistrarJugador.setBackground(new java.awt.Color(207, 232, 239));
        btnRegistrarJugador.setFont(new java.awt.Font("Game of Brush", 0, 13)); // NOI18N
        btnRegistrarJugador.setText("REGISTRAR JUGADOR");
        btnRegistrarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarJugadorActionPerformed(evt);
            }
        });

        btnJugar.setBackground(new java.awt.Color(207, 232, 239));
        btnJugar.setFont(new java.awt.Font("Game of Brush", 0, 13)); // NOI18N
        btnJugar.setText("JUGAR 1 VS 1");
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRanking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrarJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInversiones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblInversiones, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btnAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistrarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 413, 420));
        jPanel2.add(filler4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 164, 117, -1));

        btnMusica.setBackground(new java.awt.Color(181, 213, 191));
        btnMusica.setFont(new java.awt.Font("Game of Brush", 0, 8)); // NOI18N
        btnMusica.setText("MUSICA OFF");
        btnMusica.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(236, 243, 249), 2));
        btnMusica.setOpaque(true);
        btnMusica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMusicaActionPerformed(evt);
            }
        });
        jPanel2.add(btnMusica, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 10, -1, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRankingActionPerformed
        if (Sistema.getInstance().getListaJugadores().isEmpty()) {
            String mensaje = "Ingrese al menos un jugador";
            JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            VentanaRanking ventRanking = new VentanaRanking();
            ventRanking.setVisible(true);
        }
    }//GEN-LAST:event_btnRankingActionPerformed

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
        if (!Sistema.getInstance().getListaJugadores().isEmpty()) {
            VentanaSeleccionarJugadorSolitario ventSolitario = new VentanaSeleccionarJugadorSolitario(unReproductor);
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese al un jugador");
        }
    }//GEN-LAST:event_btnAyudaActionPerformed

    private void btnRegistrarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarJugadorActionPerformed
        VentanaAgregarJugador vent = new VentanaAgregarJugador();
        vent.setLocationRelativeTo(null);
        vent.setVisible(true);

    }//GEN-LAST:event_btnRegistrarJugadorActionPerformed

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        if (Sistema.getInstance().getListaJugadores().size() > 1) {
            VentanaSeleccionarJugadores1VS1 vent = new VentanaSeleccionarJugadores1VS1(unReproductor);
            vent.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Ingrese al menos dos jugadores","",JOptionPane.OK_OPTION);
        }

    }//GEN-LAST:event_btnJugarActionPerformed

    private void btnMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusicaActionPerformed
        if (this.unReproductor.getMediaPlayer().getVolume() == 0.0) {
            this.unReproductor.getMediaPlayer().setVolume(1.0);

        } else {
            this.unReproductor.getMediaPlayer().setVolume(0.0);

        }
        unReproductor.getObs().setChanged();
        unReproductor.getObs().notifyObservers();

    }//GEN-LAST:event_btnMusicaActionPerformed
    private void actualizarBtnMusica() {
        if (this.unReproductor.getMediaPlayer().getVolume() == 0.0) {
            this.btnMusica.setText(" MUSICA ON  ");

        } else {

            this.btnMusica.setText(" MUSICA OFF ");

        }
    }

    @Override
    public void dispose() {

    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnJugar;
    private javax.swing.JButton btnMusica;
    private javax.swing.JButton btnRanking;
    private javax.swing.JButton btnRegistrarJugador;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblInversiones;
    // End of variables declaration//GEN-END:variables
    private final Reproductor unReproductor;

    @Override
    public void update(Observable o, Object arg) {
        actualizarBtnMusica();
    }
}
