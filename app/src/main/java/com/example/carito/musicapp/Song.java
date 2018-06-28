package com.example.carito.musicapp;
/**
 * {@link Song} represents a song in the album.
 */
public class Song {

     //STATE - m indicate they are variables of the class

    /** Song Name*/
    private String mSongName;
    /** Artist Name*/
    private String mArtistName;
    /** Album Name*/
    private String mAlbumName;
    /** Album Icon*/
    private int mAlbumIcon;

    // CONSTRUCTOR - Configura/initialize el objeto Song (para la instancia especifica).
    // The name has to match the class name and it has no return type.

    public Song(String songName, String artistName, String albumName, int albumIcon) {
        mSongName = songName;
        mArtistName = artistName;
        mAlbumName = albumName;
        mAlbumIcon = albumIcon;
    }

    //METHODS
    /**
     * Get the Song Name
     */
    public String getSongName() {
        return mSongName;
    }

    /**
     * Get the Artist Name
     */
    public String getArtistName() {
        return mArtistName;
    }

    /**
     * Get the Album Name
     */
    public String getAlbumName() {
        return mAlbumName;
    }
    /**
     * Get the Album Icon
     */
    public int getAlbumIcon(){
        return mAlbumIcon;
    }

}