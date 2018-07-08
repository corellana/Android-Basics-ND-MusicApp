package com.example.carito.musicapp;

public class Album {
    //STATE - m indicate they are variables of the class

    /** Album Name*/
    private String mAlbumName;
    /** Album Icon*/
    private int mAlbumIcon;

    // CONSTRUCTOR
    public Album(String albumName, int albumIcon) {
        mAlbumName = albumName;
        mAlbumIcon = albumIcon;
    }

    //METHODS
    /**
     * Get the Album Name
     */
    public String getAlbumName() {
        return mAlbumName;
    }

    /**
     * Get the Album Icon
     */
    public int getAlbumIcon() {
        return mAlbumIcon;
    }

 }

