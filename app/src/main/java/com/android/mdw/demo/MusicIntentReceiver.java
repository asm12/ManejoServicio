package com.android.mdw.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class MusicIntentReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_HEADSET_PLUG)) {
            int state = intent.getIntExtra("state", -1);
            Intent toSend = new Intent(context, ElServicio.class);

            switch (state) {
                case 0:
                    Log.d(TAG, "Headset is unplugged");

                    context.stopService(toSend);
                    SingleToast.show(context, "Intent recibido ElReceptor " +
                            "- EVENTO DEL SISTEMA OFF", Toast.LENGTH_SHORT);
                    break;
                case 1:
                    Log.d(TAG, "Headset is plugged");

                    toSend.putExtra("action", context.getString(R.string.iniciar_cancion));
                    context.startService(toSend);
                    SingleToast.show(context, "Intent recibido ElReceptor " +
                            "- EVENTO DEL SISTEMA ON", Toast.LENGTH_SHORT);

                    break;
                default:
                    Log.d(TAG, "I have no idea what the headset state is");
            }
        }
    }
}
