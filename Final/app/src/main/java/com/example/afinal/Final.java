package com.example.afinal;

import android.database.Cursor;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class Final extends AppCompatActivity {
    private ImageButton btn_up;
    private ImageButton btn_pause;
    private ImageButton btn_down;
    private MediaPlayer mediaPlayer;
    private boolean ispause=false;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.list,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.first){
            mediaPlayer = MediaPlayer.create(this, R.raw.whalien52);
        }else {
            mediaPlayer = MediaPlayer.create(this, R.raw.alltoowell);
        }
        return super.onOptionsItemSelected(item);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        btn_up = findViewById(R.id.up);
        btn_pause = findViewById(R.id.pause);
        btn_down = findViewById(R.id.down);
//        btn_up.setOnClickListener((View.OnClickListener) this);
//        btn_down.setOnClickListener((View.OnClickListener) this);
        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying() && !ispause) {
                    mediaPlayer.pause();
                    ispause = true;
                    ((ImageButton) v).setImageDrawable(getResources().getDrawable(R.drawable.pause, null));
                } else {
                    mediaPlayer.start();//开始播放音频
                    ispause = false;
                    ((ImageButton) v).setImageDrawable(getResources().getDrawable(R.drawable.play, null));
                }
            }
        });
    }
}