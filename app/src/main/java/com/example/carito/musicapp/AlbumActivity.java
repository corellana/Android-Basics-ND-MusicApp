package com.example.carito.musicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        //Get the content for each Album with a Bundle (Icon and Name Album)
        ImageView albumIcon = (ImageView) findViewById(R.id.icon_album_image_view);
        TextView albumName = (TextView) findViewById(R.id.album_name_text_view);

        //Create arrayList
        ArrayList<Song> songs = new ArrayList<Song>();

        Bundle extras = this.getIntent().getExtras();
        if (extras != null) {
            int getAlbumIcon = extras.getInt(Constants.ALBUM_ICON);
            String getAlbumName = extras.getString(Constants.ALBUM_NAME);
            albumIcon.setImageResource(getAlbumIcon);
            albumName.setText(getAlbumName);

            //Add elements in arrayList
            if (getAlbumName.equals("Soundtrack GOT 7")) {
                songs.add(new Song("Main Titles", "Ramin Djawadi", getAlbumName, getAlbumIcon));
                songs.add(new Song("Dragonstone", "Ramin Djawadi", getAlbumName, getAlbumIcon));
                songs.add(new Song("Shall we begin?", "Ramin Djawadi", getAlbumName, getAlbumIcon));
                songs.add(new Song("The Queen Justice", "Ramin Djawadi", getAlbumName, getAlbumIcon));
                songs.add(new Song("A Game I Like to Play", "Ramin Djawadi", getAlbumName, getAlbumIcon));
                songs.add(new Song("I Am the Storm", "Ramin Djawadi", getAlbumName, getAlbumIcon));
                songs.add(new Song("The Gift", "Ramin Djawadi", getAlbumName, getAlbumIcon));
                songs.add(new Song("Dragonglass", "Ramin Djawadi", getAlbumName, getAlbumIcon));
                songs.add(new Song("Spoils of War, Pt. 1", "Ramin Djawadi", getAlbumName, getAlbumIcon));
                songs.add(new Song("Spoils of War, Pt. 2", "Ramin Djawadi", getAlbumName, getAlbumIcon));
                songs.add(new Song("The Dagger", "Ramin Djawadi", getAlbumName, getAlbumIcon));
                songs.add(new Song("Home", "Ramin Djawadi", getAlbumName, getAlbumIcon));
            }
            if (getAlbumName.equals("Both Sides")) {
                songs.add(new Song("Both Sides of the Story", "Phil Collins", getAlbumName, getAlbumIcon));
                songs.add(new Song("Can't Turn Back The Years", "Phil Collins", getAlbumName, getAlbumIcon));
                songs.add(new Song("Everyday", "Phil Collins", getAlbumName, getAlbumIcon));
                songs.add(new Song("I've Forgotten Everything", "Phil Collins", getAlbumName, getAlbumIcon));
                songs.add(new Song("We're Sons Of Our Fathers", "Phil Collins", getAlbumName, getAlbumIcon));
                songs.add(new Song("Can't find My Way", "Phil Collins", getAlbumName, getAlbumIcon));
                songs.add(new Song("Survivors", "Phil Collins", getAlbumName, getAlbumIcon));
                songs.add(new Song("We Fly So close", "Phil Collins", getAlbumName, getAlbumIcon));
            }
            if (getAlbumName.equals("Soundtrack Wonder Woman")) {
                songs.add(new Song("Amazon of Themyscira", "Rupert Gregson-Williams", getAlbumName, getAlbumIcon));
                songs.add(new Song("History Lesson", "Rupert Gregson-Williams", getAlbumName, getAlbumIcon));
                songs.add(new Song("Angel on the Wing", "Rupert Gregson-Williams", getAlbumName, getAlbumIcon));
                songs.add(new Song("Ludendorff, Enough!", "Rupert Gregson-Williams", getAlbumName, getAlbumIcon));
                songs.add(new Song("Pain, Loss & Love", "Rupert Gregson-Williams", getAlbumName, getAlbumIcon));
                songs.add(new Song("No Man's Land", "Rupert Gregson-Williams", getAlbumName, getAlbumIcon));
                songs.add(new Song("Fausta", "Rupert Gregson-Williams", getAlbumName, getAlbumIcon));
                songs.add(new Song("The God of War", "Rupert Gregson-Williams", getAlbumName, getAlbumIcon));
            }
        }

        // OnCreate crea un adapter para pasarle a la vista la lista de canciones.
        // El activity le pasa las canciones al adapter
        SongAdapter adapter = new SongAdapter(this, songs);

        // Después buscas la vista en tu layout.
        ListView listView = (ListView) findViewById(R.id.songs_list);

        // Y le decimos al List View que use ese adapter para mostrar la lista. SUJETO.set = haz esto.
        listView.setAdapter(adapter);
        //  Luego, el list view llamará a getView en el SongAdapter, una vez por cada canción.

    }
}


