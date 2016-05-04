package com.mrb.alias.team;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mrb.alias.R;
import com.mrb.alias.utils.Data;

import java.util.ArrayList;
import java.util.Random;

/**
 * Adapter to show list of teams with names (and points)
 * Created by Volodymyr Chornyi on 09.04.2016.
 */
public class TeamAdapter extends ArrayAdapter<Team> {

    protected boolean showPoints;
    protected ArrayList<Team> teams;

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    public TeamAdapter(Context context, ArrayList<Team> teams, boolean showPoints) {
        super(context, 0, teams);
        this.showPoints = showPoints;
        this.teams = teams;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Team team = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_team_name, parent, false);
        }
        final TextView tvName = (TextView) convertView.findViewById(R.id.team_adapter_tvName);
        tvName.setText(team.getName());
        TextView tvPoints = (TextView) convertView.findViewById(R.id.team_adapter_tvPoints);

        if (showPoints) {
            tvPoints.setText(String.valueOf(team.getPoints()));
        } else {
            tvPoints.setVisibility(View.GONE);

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idx = new Random().nextInt(Data.teamNamesCount());
                    String teamName = Data.getTeamName(idx);

                    while (teams.get(0).getName().equals(teamName) || teams.get(1).getName().equals(teamName)) {
                        idx = new Random().nextInt(Data.teamNamesCount());
                        teamName = Data.getTeamName(idx);
                    }

                    final String finalTeamName = teamName;
                    tvName.setText(finalTeamName);
                    team.setName(finalTeamName);
                }
            });
        }

        return convertView;
    }
}
