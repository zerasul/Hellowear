package com.indalware.wearuiexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class voiceactivity extends Activity {

    private TextView mTextView;
    private Button btnvoz;
    private static Integer SPEECH_REQUEST_CODE=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voiceactivity);
        mTextView = (TextView)findViewById(R.id.txtvoz);
        btnvoz = (Button)findViewById(R.id.btnvoz);
        btnvoz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activarVoz();
            }
        });
    }

    private void activarVoz(){
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        startActivityForResult(intent, SPEECH_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==SPEECH_REQUEST_CODE && resultCode== RESULT_OK){
            List<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            if(results.size()>0)
                mTextView.setText(results.get(0));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
