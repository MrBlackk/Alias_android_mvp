package com.mrb.alias.round;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.mrb.alias.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Adapter to show word results
 * Created by Volodymyr Chornyi on 18.04.2016.
 */
public class WordsResultAdapter extends BaseAdapter {

    private final ArrayList mData;


    public WordsResultAdapter(LinkedHashMap<String, Boolean> map) {
        mData = new ArrayList();
        mData.addAll(map.entrySet());
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public LinkedHashMap.Entry<String, Boolean> getItem(int position) {
        return (LinkedHashMap.Entry<String, Boolean>) mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_words_list, parent, false);
        }

        final LinkedHashMap.Entry<String, Boolean> item = getItem(position);

        TextView tvWord = (TextView) convertView.findViewById(R.id.results_adapter_tvWord);
        tvWord.setText(item.getKey());

        final TextView tvIsGuessed = (TextView) convertView.findViewById(R.id.results_adapter_tvIsGuessed);
        tvIsGuessed.setText(String.valueOf(item.getValue()));

        final Button btnPlus = (Button) convertView.findViewById(R.id.results_adapter_btnPlus);
        final Button btnMinus = (Button) convertView.findViewById(R.id.results_adapter_btnMinus);
        final Button btnSkip = (Button) convertView.findViewById(R.id.results_adapter_btnSkip);

        btnPlus.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    item.setValue(true);
                    tvIsGuessed.setText(String.valueOf(item.getValue()));
                    btnPlus.setPressed(true);
                    btnMinus.setPressed(false);
                    btnSkip.setPressed(false);
                }
                return true;
            }
        });

        btnMinus.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    item.setValue(false);
                    tvIsGuessed.setText(String.valueOf(item.getValue()));
                    btnPlus.setPressed(false);
                    btnMinus.setPressed(true);
                    btnSkip.setPressed(false);
                }
                return true;
            }
        });

        btnSkip.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    item.setValue(null);
                    tvIsGuessed.setText(String.valueOf(item.getValue()));
                    btnPlus.setPressed(false);
                    btnMinus.setPressed(false);
                    btnSkip.setPressed(true);
                }

                return true;
            }
        });

        Boolean value = item.getValue();

        if(Boolean.TRUE.equals(value)){
            btnPlus.setPressed(true);
            btnMinus.setPressed(false);
            btnSkip.setPressed(false);
        } else if (value == null){
            btnPlus.setPressed(false);
            btnMinus.setPressed(false);
            btnSkip.setPressed(true);
        } else {
            btnPlus.setPressed(false);
            btnMinus.setPressed(true);
            btnSkip.setPressed(false);
        }

        return convertView;
    }
}
