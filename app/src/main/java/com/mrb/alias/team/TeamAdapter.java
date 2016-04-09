package com.mrb.alias.team;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mrb.alias.R;

import java.util.ArrayList;

/**
 * Created by chvs on 09.04.2016.
 */
public class TeamAdapter extends ArrayAdapter<Team> {


    public TeamAdapter(Context context, ArrayList<Team> teams) {
        super(context, 0, teams);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Team team = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_team_name, parent, false);
        }
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        tvName.setText(team.getName());

        return convertView;
    }
}
