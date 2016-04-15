package com.mrb.alias.game;

import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mrb.alias.R;
import com.mrb.alias.utils.DataBaseHelper;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity {

    @Bind(R.id.textView5)
    TextView tvWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);

//        DataBaseHelper myDbHelper = new DataBaseHelper(this);
        DataBaseHelper myDbHelper;
        myDbHelper = new DataBaseHelper(this);

        try {

            myDbHelper.createDataBase();

        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }

        try {

            myDbHelper.openDataBase();

        }catch(SQLException sqle){

            throw sqle;

        }

        String word = myDbHelper.getRandomWord();

        tvWord.setText(word);
    }

}
