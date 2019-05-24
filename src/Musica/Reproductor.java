/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Musica;

import java.io.File;
import java.util.Observable;
import javafx.beans.InvalidationListener;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Santiago Soto 219266
 *
 */
public class Reproductor extends Thread{
 
    private Media hit;
   private String bip;
    private ObservableReproductor obs;
    public Media getHit() {
        return hit;
    }

    public void setHit(Media hit) {
        this.hit = hit;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
        
    }
    private MediaPlayer mediaPlayer;

    @Override
    public void run() {
        try {

            this.hit = new Media(getClass().getResource(bip).toURI().toString());
            this.mediaPlayer = new MediaPlayer(hit);
            this.mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
          

        } catch (Exception ex) {
            System.out.println("Se rompio");
        }

    }

    public Reproductor(String dir) {
        this.obs = new ObservableReproductor();
        this.bip = dir;
        
    }

    public ObservableReproductor  getObs() {
        return obs;
    }

    public void setObs(ObservableReproductor obs) {
        this.obs = obs;
    }
    
    

}
