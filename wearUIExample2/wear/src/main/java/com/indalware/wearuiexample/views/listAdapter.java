package com.indalware.wearuiexample.views;

import android.content.Context;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.indalware.wearuiexample.R;

/**
 * Created by victor on 14/11/14.
 */
public class listAdapter extends WearableListView.Adapter {

    private Context context;
    private Integer[] dataset;
    TextView texto;
    public listAdapter(Context context, Integer[] dataset) {
        this.context=context;
        this.dataset=dataset;

    }

    @Override
    public WearableListView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(this.context);
        return new itemHolder(inflater.inflate(R.layout.item,null));
    }

    @Override
    public void onBindViewHolder(WearableListView.ViewHolder viewHolder, int i) {

        itemHolder holder = (itemHolder)viewHolder;
        holder.textView.setText(""+dataset[i]);
    }

    @Override
    public int getItemCount() {
        return this.dataset.length;
    }

    private class itemHolder extends WearableListView.ViewHolder{
        public TextView textView;
        public itemHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.texto);

        }
    }
}
