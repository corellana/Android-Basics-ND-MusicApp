package com.example.carito.musicapp;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SongAdapter extends ArrayAdapter<Song> {

    /**
     * CONSTRUCTOR
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param songs   A List of songs objects to display in a list.
     *                El constructor inicializa el objeto (SongAdapter) por ti.
     */
    public SongAdapter(Activity context, ArrayList<Song> songs) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, songs);
    }

    /**
     * * METHOD - GETVIEW
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view.
        View songListItemView = convertView;
        if (songListItemView == null) {
            songListItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.songs_list_item, parent, false);
        }

        // Get the {@link Song} object located at this position in the list.
        final Song currentSong = getItem(position);

        // Find the TextView in the song_list_item.xml layout with the ID song_name_text_view
        TextView songNameTextView = (TextView) songListItemView.findViewById(R.id.song_name_text_view);
        // Get the Song Name from the current Song object and set this text on the Song Name TextView
        songNameTextView.setText(currentSong.getSongName());

        // Find the TextView in the song_list_item.xml layout with the ID artist_name_text_view
        TextView artistNameTextView = (TextView) songListItemView.findViewById(R.id.artist_name_text_view);
        // Get the Artist Name from the current Song object and set this text on the Artist Name TextView
        artistNameTextView.setText(currentSong.getArtistName());


        songListItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent songIntent = new Intent(getContext(), SongActivity.class);
                // A current Song le pedimos el Song Name y se lo pasamos al intent como un extra.
                songIntent.putExtra("Song Name", currentSong.getSongName());
                songIntent.putExtra("Artist Name", currentSong.getArtistName());
                songIntent.putExtra("Album Name", currentSong.getAlbumName());
                songIntent.putExtra("Album Icon", currentSong.getAlbumIcon());
                getContext().startActivity(songIntent);
            }
        });

        // Retornamos la vista configurada (tiene su layout, su contenido y acciones).
        return songListItemView;
    }

}
