package com.example.carito.musicapp;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class AlbumAdapter extends ArrayAdapter<Album> {

        /**
         * CONSTRUCTOR
         * @param context The current context. Used to inflate the layout file.
         * @param albums  A List of albums objects to display in a list.
         *                El constructor inicializa el objeto (AlbumAdapter) por ti.
         */
        public AlbumAdapter(Activity context, ArrayList<Album> albums) {
            super(context, 0, albums);
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
            // List view llama al adapter pidiendole cada una de las vistas que
            // le corresponden a cada item del arreglo de canciones.

            // Check if the existing view is being reused, otherwise inflate the view.
            // Convierte el layout en una vista.
            View albumListItemView = convertView;
            if (albumListItemView == null) {
                albumListItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.albums_list_item, parent, false);
            }
            // Get the {@link Album} object located at this position in the list.
            final Album currentAlbum = getItem(position);

            // Find the TextView in the albums_list_item.xml layout with the ID album_name_text_view
            TextView albumNameTextView = (TextView) albumListItemView.findViewById(R.id.album_name_text_view);
            // Get the Album Name from the current Album object and
            // set this text on the Album Name TextView
            albumNameTextView.setText(currentAlbum.getAlbumName());

            // Find the ImageView in the albums_list_item.xml layout with the ID album_icon_text_view
            ImageView albumIconImageView = (ImageView) albumListItemView.findViewById(R.id.icon_album_image_view);
            // Get the Artist Name from the current Song object and
            // set this text on the Artist Name TextView
            albumIconImageView.setImageResource(currentAlbum.getAlbumIcon());
            /// Hasta aquí, el ListView mostrará todas los albums porque le pidió ayuda al Adapter que
            //  se sabe todas las canciones. Y el listview usará GetView para poder mostrar la lista completa.

            // Ya configuramos el contenido, ahora configuraremos las acciones.
            albumListItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent albumIntent = new Intent(getContext(), AlbumActivity.class);
                    // A current Album le pedimos el Album Name y el Album Icon
                    // y se lo pasamos al intent como un extra.
                    albumIntent.putExtra(Constants.ALBUM_NAME, currentAlbum.getAlbumName());
                    albumIntent.putExtra(Constants.ALBUM_ICON, currentAlbum.getAlbumIcon());
                    getContext().startActivity(albumIntent);
                }
            });

            // Return the whole list item layout (containing 2 TextViews)
            // so that it can be shown in the ListView
            // Retornamos la vista configurada (tiene su layout, su contenido y acciones).
            return albumListItemView;
        }
}