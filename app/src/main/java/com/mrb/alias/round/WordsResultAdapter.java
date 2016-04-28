package com.mrb.alias.round;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.mrb.alias.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Adapter to show word results
 * Created by Volodymyr Chornyi on 18.04.2016.
 */
public class WordsResultAdapter extends BaseAdapter {

    private final ArrayList mData;


    public WordsResultAdapter(HashMap<String, Boolean> map) {
        mData = new ArrayList();
        mData.addAll(map.entrySet());
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public HashMap.Entry<String, Boolean> getItem(int position) {
        return (HashMap.Entry<String, Boolean>) mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_words_list, parent, false);
        }

        final HashMap.Entry<String, Boolean> item = getItem(position);

        TextView tvWord = (TextView) convertView.findViewById(R.id.results_adapter_tvWord);
        tvWord.setText(item.getKey());

        final TextView tvIsGuessed = (TextView) convertView.findViewById(R.id.results_adapter_tvIsGuessed);
        tvIsGuessed.setText(String.valueOf(item.getValue()));

        Button btnPlus = (Button) convertView.findViewById(R.id.results_adapter_btnPlus);
        Button btnMinus = (Button) convertView.findViewById(R.id.results_adapter_btnMinus);
        Button btnSkip = (Button) convertView.findViewById(R.id.results_adapter_btnSkip);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.setValue(true);
                tvIsGuessed.setText(String.valueOf(item.getValue()));
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.setValue(false);
                tvIsGuessed.setText(String.valueOf(item.getValue()));
            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.setValue(null);
                tvIsGuessed.setText(String.valueOf(item.getValue()));
            }
        });

        return convertView;
    }
}
