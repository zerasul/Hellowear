package com.indalware.wearuiexample;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import android.support.wearable.view.CardFragment;
import android.support.wearable.view.WatchViewStub;
import android.widget.TextView;

public class wearmainactivity extends Activity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wearmainactivity);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
            }
        });
        FragmentManager fragmentmanage = getFragmentManager();

        FragmentTransaction transaction=fragmentmanage.beginTransaction();
        CardFragment fragment = CardFragment.create(getString(R.string.titulocard),getString(R.string.textocard));

        transaction.add(R.id.layout_card,fragment);
        transaction.commit();
    }
}
