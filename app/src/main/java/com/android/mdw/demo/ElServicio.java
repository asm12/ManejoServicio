package com.android.mdw.demo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class ElServicio extends Service {

	private MediaPlayer player;

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		SingleToast.show(this, getString(R.string.creaserv), Toast.LENGTH_LONG);
		player = MediaPlayer.create(this, R.raw.train);
		player.setLooping(true);
	}

	@Override
	public void onDestroy() {
		SingleToast.show(this, getString(R.string.finaserv), Toast.LENGTH_LONG);
		player.stop();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startid) {
		SingleToast.show(this, getString(R.string.iniserv), Toast.LENGTH_LONG);
		player.start();
		return startid;		
	}	

}
