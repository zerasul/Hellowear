package com.indalware.wearuiexample.views;

import android.content.Context;
import android.support.wearable.view.WearableListView;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.indalware.wearuiexample.R;

/**
 * Created by victor on 14/11/14.
 */
public class itemViewList extends LinearLayout implements WearableListView.Item {

    private Integer data;

    public void setData(Integer data){
        this.data=data;
    }

    public itemViewList(Context context) {
        super(context);
    }

    public itemViewList(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public itemViewList(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TextView texto = (TextView)findViewById(R.id.texto);
        texto.setText(data);
    }

    @Override
    public float getProximityMinValue() {
        return 0;
    }

    @Override
    public float getProximityMaxValue() {
        return 0;
    }

    @Override
    public float getCurrentProximityValue() {
        return 0;
    }

    @Override
    public void setScalingAnimatorValue(float v) {

    }

    @Override
    public void onScaleUpStart() {

    }

    @Override
    public void onScaleDownStart() {

    }
}
