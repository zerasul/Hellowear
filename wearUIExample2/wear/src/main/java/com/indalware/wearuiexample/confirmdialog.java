package com.indalware.wearuiexample;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.DelayedConfirmationView;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class confirmdialog extends Activity implements DelayedConfirmationView.DelayedConfirmationListener{

    private TextView mTextView;
    private DelayedConfirmationView confview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmdialog);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
            }
        });
         confview = (DelayedConfirmationView)findViewById(R.id.delayed_confirm);
        confview.setListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        confview.setTotalTimeMs(5000l);
        confview.start();
    }

    @Override
    public void onTimerFinished(View view) {
        Log.i("TIMER","Timer Finalizado");
    }

    @Override
    public void onTimerSelected(View view) {
        Log.i("TIMER", "Seleccionado");
    }
}
