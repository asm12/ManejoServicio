package com.android.mdw.demo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class ElServicio extends Service {

    private MediaPlayer soundPlayer;
    private MediaPlayer songPlayer;
    private Intent intent;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate() {
        SingleToast.show(this, getString(R.string.creaserv), Toast.LENGTH_LONG);
        soundPlayer = new MediaPlayer();
        songPlayer = new MediaPlayer();
        super.onCreate();
    }

    private void createSoundPlayer() {
        String action = intent.getStringExtra("action");
        if (action != null) {
            if (action.equals(getString(R.string.iniciar_sonido)) && !soundPlayer.isPlaying()) {
                soundPlayer = MediaPlayer.create(this, R.raw.train);
                soundPlayer.setLooping(true);
                soundPlayer.start();

            } else if (!songPlayer.isPlaying()) {
                songPlayer = MediaPlayer.create(this, R.raw.tank);
                songPlayer.setLooping(true);
                songPlayer.start();

            }
        }
    }

    @Override
    public void onDestroy() {
        SingleToast.show(this, getString(R.string.finaserv), Toast.LENGTH_LONG);
        if (songPlayer.isPlaying()) {
            songPlayer.stop();
        }
        if (soundPlayer.isPlaying()) {
            soundPlayer.stop();
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startid) {
        SingleToast.show(this, getString(R.string.iniserv), Toast.LENGTH_LONG);
        this.intent = intent;
        createSoundPlayer();
        return startid;
    }

}
