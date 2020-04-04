package com.example.memorygamehrantprod;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private View soundBtn;
    private boolean isGreen = true;

    private Button accept_btn, play_btn;

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // full screen activity_____________________________________________________________________________________________

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // open new Activity to use Intent  with onClick____________________________________________________________________

        final Intent intent = new Intent(this, GameActivity.class);


        play_btn = findViewById(R.id.play_btn);
        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        // search ACCEPT btn and set onClick , then get name for EditTExt & use name into Game Winner Text,
        // then setGONE EditText & setVISIBILITY Play Button________________________________________________________________

        accept_btn = findViewById(R.id.accept_name_btn);
        accept_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.edit_name);
                if (editText.getText().toString().equals("")) {
                   Toast toast = Toast.makeText(getApplicationContext(),
                            "Please type your name !!!", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    name = editText.getText().toString();
                    intent.putExtra("player_name", name);

                    play_btn.setVisibility(View.VISIBLE);
                    editText.setVisibility(View.GONE);
                    accept_btn.setVisibility(View.GONE);
                }
            }
        });


        //  Create media____________________________________________________________________________________________________

        mediaPlayer = MediaPlayer.create(this, R.raw.memory);
        soundBtn = findViewById(R.id.sound_btn);
        soundBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                isGreen = !isGreen;
                if (isGreen) {
                    soundBtn.setBackground(getDrawable(R.drawable.sound_on));
                    mediaPlayer.start();
                } else {
                    soundBtn.setBackground(getDrawable(R.drawable.sound_off));
                    mediaPlayer.pause();
                }
            }
        });

    }

    // To Use LIFE CYCLE & then Override` onStart, onPause, OnDestroy
    // to make media in application ________________________________________________________________________________________
    @Override
    protected void onStart() {
        super.onStart();
        mediaPlayer = MediaPlayer.create(this, R.raw.memory);
        mediaPlayer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }
}
