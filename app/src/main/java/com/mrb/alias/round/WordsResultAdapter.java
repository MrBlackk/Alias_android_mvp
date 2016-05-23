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
    private RoundPresenter presenter;


    public WordsResultAdapter(LinkedHashMap<String, Boolean> map, RoundPresenter presenter) {
        mData = new ArrayList();
        mData.addAll(map.entrySet());
        this.presenter = presenter;
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
    public View getView(int position, View convertView, final ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_words_list, parent, false);
            holder = new ViewHolder();
            holder.tvWord = (TextView) convertView.findViewById(R.id.results_adapter_tvWord);
            holder.tvIsGuessed = (TextView) convertView.findViewById(R.id.results_adapter_tvIsGuessed);
            holder.btnPlus = (Button) convertView.findViewById(R.id.results_adapter_btnPlus);
            holder.btnMinus = (Button) convertView.findViewById(R.id.results_adapter_btnMinus);
            holder.btnSkip = (Button) convertView.findViewById(R.id.results_adapter_btnSkip);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final LinkedHashMap.Entry<String, Boolean> item = getItem(position);

        Boolean value = item.getValue();

        holder.tvWord.setText(item.getKey());
        holder.tvIsGuessed.setText(String.valueOf(value));

        if (Boolean.TRUE.equals(value)) {
            holder.btnPlus.setPressed(true);
            holder.btnMinus.setPressed(false);
            holder.btnSkip.setPressed(false);
        } else if (value == null) {
            holder.btnPlus.setPressed(false);
            holder.btnMinus.setPressed(false);
            holder.btnSkip.setPressed(true);
        } else {
            holder.btnPlus.setPressed(false);
            holder.btnMinus.setPressed(true);
            holder.btnSkip.setPressed(false);
        }

        holder.btnPlus.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    item.setValue(true);
                    notifyDataSetChanged();
                    presenter.getAndShowCurrentPoints();
                }
                return true;
            }
        });

        holder.btnMinus.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    item.setValue(false);
                    notifyDataSetChanged();
                    presenter.getAndShowCurrentPoints();
                }
                return true;
            }
        });

        holder.btnSkip.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    item.setValue(null);
                    notifyDataSetChanged();
                    presenter.getAndShowCurrentPoints();
                }
                return true;
            }
        });

        return convertView;
    }

    public static class ViewHolder {
        public TextView tvWord;
        public TextView tvIsGuessed;
        public Button btnPlus;
        public Button btnMinus;
        public Button btnSkip;
    }
}
