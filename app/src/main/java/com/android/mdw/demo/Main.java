package com.android.mdw.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Main extends Activity implements OnClickListener {
    private Intent in;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        createButtons();

        in = new Intent(this, CustomBroadcastReceiver.class);
    }

    private void createButtons() {
        Button btnSonido = (Button) findViewById(R.id.boton_sonido);
        Button btnCancion = (Button) findViewById(R.id.boton_cancion);
        Button btnFin = (Button) findViewById(R.id.boton_fin);

        btnSonido.setOnClickListener(this);
        btnCancion.setOnClickListener(this);
        btnFin.setOnClickListener(this);
    }

    @Override
    public void onClick(View src) {
        switch (src.getId()) {
            case R.id.boton_sonido:
                in.putExtra("action", getString(R.string.iniciar_sonido));
                SingleToast.show(this, getString(R.string.toast_sonido), Toast.LENGTH_SHORT);
                break;
            case R.id.boton_cancion:
                in.putExtra("action", getString(R.string.iniciar_cancion));
                SingleToast.show(this, getString(R.string.toast_cancion), Toast.LENGTH_SHORT);
                break;
            case R.id.boton_fin:
                in.putExtra("action", getString(R.string.detener));
                SingleToast.show(this, getString(R.string.detener), Toast.LENGTH_SHORT);
                break;
        }
        sendBroadcast(in);
    }
}