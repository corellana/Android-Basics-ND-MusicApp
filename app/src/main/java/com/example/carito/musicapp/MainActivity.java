package com.example.carito.musicapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        //Create arrayList of "albums" objects.
        ArrayList<Album> albums = new ArrayList<Album>();
        albums.add(new Album("Soundtrack GOT 7", R.drawable.game_of_thrones));
        albums.add(new Album("Both Sides", R.drawable.both_sides));
        albums.add(new Album("Soundtrack Wonder Woman", R.drawable.wonder_woman));

        // Create an {@link AlbumAdapter}, whose data source is a list of {@link albums}.
        // The adapter knows how to create list item views for each item in the list.
        AlbumAdapter adapter = new AlbumAdapter(this, albums);

        // Get a reference to the ListView (Después buscas la vista en tu layout)
        ListView listView = (ListView) findViewById(R.id.album_list);

        // And attach the adapter to the listview.
        listView.setAdapter(adapter);
        //  Luego, el list view llamará a getView en el AlbumAdapter, una vez por cada album.
        // Set a click listener on that View >> En este caso quedó seteado en AlbumAdapter.
    }
}


