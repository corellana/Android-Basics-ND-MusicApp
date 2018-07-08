package com.example.carito.musicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        TextView albumName = (TextView) findViewById(R.id.album_name_text_view);
        ImageView albumIcon = (ImageView) findViewById(R.id.icon_album_image_view);
        TextView songName = (TextView) findViewById(R.id.song_name_text_view);
        TextView artistName = (TextView) findViewById(R.id.artist_name_text_view);

        Bundle extras = this.getIntent().getExtras();
        if (extras != null) {
            final String getAlbumName = extras.getString(Constants.ALBUM_NAME);
            final int getAlbumIcon = extras.getInt(Constants.ALBUM_ICON);
            String getSongName = extras.getString(Constants.SONG_NAME);
            String getArtistName = extras.getString(Constants.ARTIST_NAME);
            albumIcon.setImageResource(getAlbumIcon);
            albumName.setText(getAlbumName);
            songName.setText(getSongName);
            artistName.setText(getArtistName);
        }
    }
}


