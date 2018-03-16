package com.example.android.tourguideapp;

/**
 *  Created by Lenovo on 13/03/2018.
 */

class Places {

    private static final int NO_IMAGE_PROVIDED=-1;
    private String name;
    private String description;
    private int imageResourceId=NO_IMAGE_PROVIDED;

    /**
     * Constructor
     *
     * @param name            is the place's name
     * @param description     is a short description of the place
     * @param imageResourceId is the associated image
     */
    Places(String name, String description, int imageResourceId) {
        this.name=name;
        this.description=description;
        this.imageResourceId=imageResourceId;
    }

    public String getName() {
        return this.name;
    }

    String getDescription() {
        return this.description;
    }

    int getImageResourceId() {
        return this.imageResourceId;
    }

    /**
     * Returns whether or not there is an image associated
     */
    boolean hasImage() {
        return this.imageResourceId != NO_IMAGE_PROVIDED;
    }
}
