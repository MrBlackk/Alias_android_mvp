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

    protected boolean showPoints;

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    public TeamAdapter(Context context, ArrayList<Team> teams, boolean showPoints) {
        super(context, 0, teams);
        this.showPoints = showPoints;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Team team = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_team_name, parent, false);
        }
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        tvName.setText(team.getName());
        TextView tvPoints = (TextView) convertView.findViewById(R.id.tvPoints);

        if(this.showPoints){
            tvPoints.setText(String.valueOf(team.getPoints()));
        } else {
            tvPoints.setVisibility(View.GONE);
        }

        return convertView;
    }
}
