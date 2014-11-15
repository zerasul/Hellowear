package com.indalware.wearuiexample;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.Wearable;

import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.List;

public class datasyncActivity extends Activity implements DataApi.DataListener{

    private TextView mTextView;
    private Button btnaumentar;
    private int i=0;

    private static String TAG="DATA SYNC";
    private static String COUNT_KEY="COUNT";
    private GoogleApiClient apiclient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datasync);
        mTextView= (TextView)findViewById(R.id.txtdatos);
        apiclient=getClient();
        apiclient.connect();
        Wearable.DataApi.addListener(apiclient,datasyncActivity.this);
        getDataItem(apiclient);
        btnaumentar= (Button)findViewById(R.id.btnaumentar);
        btnaumentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PutDataMapRequest datamaprequest= PutDataMapRequest.create("/count");
                datamaprequest.getDataMap().putInt(COUNT_KEY,i+1);
                PutDataRequest request = datamaprequest.asPutDataRequest();
                PendingResult<DataApi.DataItemResult> pending= Wearable.DataApi.putDataItem(apiclient,request);
                getDataItem(apiclient);
            }
        });
    }

    private GoogleApiClient getClient(){
        GoogleApiClient mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
                    @Override
                    public void onConnected(Bundle connectionHint) {
                        Log.d(TAG, "onConnected: " + connectionHint);
                        // Now you can use the data layer API
                    }
                    @Override
                    public void onConnectionSuspended(int cause) {
                        Log.d(TAG, "onConnectionSuspended: " + cause);
                    }
                })
                .addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(ConnectionResult result) {
                        Log.d(TAG, "onConnectionFailed: " + result);
                    }
                })
                        // Request access only to the Wearable API
                .addApi(Wearable.API)
                .build();
        return mGoogleApiClient;
    }

    @Override
    public void onDataChanged(DataEventBuffer dataEvents) {
        i= ByteBuffer.wrap(dataEvents.get(0).getDataItem().getData()).getInt();
        mTextView.setText(Integer.toString(i));
    }



    private void getDataItem(GoogleApiClient client){
        PendingResult<DataItemBuffer> results = Wearable.DataApi.getDataItems(client);
        results.setResultCallback(new ResultCallback<DataItemBuffer>() {
            @Override
            public void onResult(DataItemBuffer dataItems) {
                if (dataItems.getCount() != 0) {
                    DataMapItem dataMapItem = DataMapItem.fromDataItem(dataItems.get(0));

                    // This should read the correct value.
                    i = dataMapItem.getDataMap().getInt(COUNT_KEY);
                    mTextView.setText(Integer.toString(i));


                }

                dataItems.release();
            }
        });
    }
}
