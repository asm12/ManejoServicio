package com.android.mdw.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


public class CustomBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "CustomBroadcastReceiver";
    private Intent intent;
    private Context context;

    @Override
    public void onReceive(Context context, Intent intent) {
        this.context = context;
        this.intent = intent;
        checkAction();

    }

    private void checkAction() {
        String action = intent.getStringExtra("action");
        Intent toSend = new Intent(context, ElServicio.class);
        boolean stop = false;

        if (action != null) {
            if (action.equals(context.getString(R.string.iniciar_sonido))) {

                toSend.putExtra("action", context.getString(R.string.iniciar_sonido));
                SingleToast.show(context, "Intent recibido" +
                        "ElReceptor - Inicio reproducción Sonido", Toast.LENGTH_SHORT);

            } else if (action.equals(context.getString(R.string.iniciar_cancion))) {

                toSend.putExtra("action", context.getString(R.string.iniciar_cancion));
                SingleToast.show(context, "Intent recibido" +
                        "ElReceptor - Inicio reproducción Cancion", Toast.LENGTH_SHORT);
            } else {
                stop = true;
                toSend.putExtra("action", context.getString(R.string.detener));
                SingleToast.show(context, "Intent recibido" +
                        "ElReceptor - Detención Reproducción", Toast.LENGTH_SHORT);
            }
            if (stop) {
                context.stopService(toSend);
            } else {
                context.startService(toSend);
            }
        }
    }
}

