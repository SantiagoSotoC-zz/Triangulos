/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Musica;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author santiago
 */
public class Reproductor extends Thread {

    private Media hit;
    private String bip;
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
    public void run(){
         try {
            
             this.hit = new Media(getClass().getResource(bip).toURI().toString());
            this.mediaPlayer = new MediaPlayer(hit);
            this.mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            this.mediaPlayer.play();

        } catch (Exception ex) {
            System.out.println("Se rompio");
        }
    
    }
    public Reproductor(String dir) {
        this.bip=dir;
    }

}
