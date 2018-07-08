package com.example.carito.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

            /**
             * This method is called when Image Back Previous Activity is clicked.
             * @param view Image View Back Previous Activity
             */

            ImageView backButton = (ImageView) findViewById(R.id.back_button);

            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent songIntent = new Intent(getBaseContext(), AlbumActivity.class);
                    songIntent.putExtra(Constants.ALBUM_ICON, getAlbumIcon);
                    songIntent.putExtra(Constants.ALBUM_NAME, getAlbumName);
                    startActivity(songIntent);
                }
            });
        }

//    // Intent for the activity to open when user selects the notification
//    Intent detailsIntent = new Intent(this, AlbumActivity.class);
//
//    // Use TaskStackBuilder to build the back stack and get the PendingIntent
//    PendingIntent pendingIntent = TaskStackBuilder.create(this)
//                    // add all of DetailsActivity's parents to the stack,
//                    // followed by DetailsActivity itself
//                    .addNextIntentWithParentStack(detailsIntent)
//                    .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
//
//    NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
//    builder.setContentIntent(pendingIntent);
    }
}


