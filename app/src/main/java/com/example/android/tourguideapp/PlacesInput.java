package com.example.android.tourguideapp;

import android.content.Context;

import java.util.ArrayList;

/**
 *  Created by Lenovo on 13/03/2018.
 */

class PlacesInput {

    // Input places by category to array lists
    private static ArrayList<Places> getSeeing() {
        ArrayList<Places> places=new ArrayList<>();
        places.add(new Places("Triumphal Arch", "Landmark • Free",
                R.drawable.arcul));
        places.add(new Places("Romanian Athenaeum", "Architecture • Concert Hall",
                R.drawable.atheneum));
        places.add(new Places("Ceausescu Mansion", "Museum",
                R.drawable.ceau));
        places.add(new Places("Old Princely Court & Church", "Open Air Museum",
                R.drawable.cveche));
        places.add(new Places("Parliament Palace", "Landmark",
                R.drawable.casa_poporului));
        places.add(new Places("Stavropoleos Church", "Architecture",
                R.drawable.stavrop));
        return places;
    }

    private static ArrayList<Places> getArt() {
        ArrayList<Places> places=new ArrayList<>();
        places.add(new Places("Art Collection Museum", "Museum",
                R.drawable.c_arta));
        places.add(new Places("National Village Museum", "Open Air Museum",
                R.drawable.muzeul_satului));
        places.add(new Places("Grigore Antipa Museum of Natural History", "Museum",
                R.drawable.mantipa));
        places.add(new Places("Theodor Pallady Museum", "Museum • Art Gallery",
                R.drawable.pallady));
        places.add(new Places("Romanian Kitsch Museum", "Museum",
                R.drawable.kitsch));
        places.add(new Places("National History Museum of Romania", "Museum",
                R.drawable.istorie));
        return places;
    }

    private static ArrayList<Places> getShopping() {
        ArrayList<Places> places=new ArrayList<>();
        places.add(new Places("Unirea Shopping Center", "Shopping Center",
                R.drawable.unirea));
        places.add(new Places("AFI Palace Cotroceni Mall", "Mall",
                R.drawable.afi));
        places.add(new Places("Museum of the Romanian Peasant Gift Shop", "Folk-Art Shop",
                R.drawable.mtr));
        places.add(new Places("Carturesti Carusel", "Books & Gifts",
                R.drawable.carusel));
        places.add(new Places("Hanul cu Tei", "Souvenirs & Gifts",
                R.drawable.tei));
        places.add(new Places("Targul Vitan", "Flea Market",
                R.drawable.antichiati));
        return places;
    }

    private static ArrayList<Places> getDining() {
        ArrayList<Places> places=new ArrayList<>();
        places.add(new Places("Caru' cu Bere", "Romanian • $$",
                R.drawable.bere));
        places.add(new Places("Lacrimi si Sfinti", "Romanian • $$$",
                R.drawable.lacrimi));
        places.add(new Places("the Artist", "European • $$$$",
                R.drawable.artist));
        places.add(new Places("OSHO", "Steakhouse • $$$$",
                R.drawable.osho));
        places.add(new Places("YUKI japanese home dining", "Japanese • $$",
                R.drawable.yuki));
        places.add(new Places("Beca's Kitchen - Homemade Food", "Seafood, Mediterranean • $$",
                R.drawable.beca));
        return places;
    }

    private static ArrayList<Places> getStaying() {
        ArrayList<Places> places=new ArrayList<>();
        places.add(new Places("Epoque Hotel", "Hotel • $$$",
                R.drawable.epoque));
        places.add(new Places("Rembrandt Hotel", "Hotel • $$",
                R.drawable.rembrandt));
        places.add(new Places("Bucuresti Intercontinental Hotel", "Hotel • $$$",
                R.drawable.inter));
        places.add(new Places("Z Hotel", "Hotel • $$$",
                R.drawable.z));
        places.add(new Places("Hotel Casa Capsa", "Hotel • $$$",
                R.drawable.capsa));
        places.add(new Places("Little Bucharest Old Town Hostel", "Hostel • $",
                R.drawable.little));
        return places;
    }

    // Return lists of places by category
    static ArrayList<Places> getPlaces(Context context, String category) {
        if (category.equals(context.getString(R.string.see_category))) {
            return getSeeing();
        } else if (category.equals(context.getString(R.string.art_category))) {
            return getArt();
        } else if (category.equals(context.getString(R.string.dine_category))) {
            return getDining();
        } else if (category.equals(context.getString(R.string.shop_category))) {
            return getShopping();
        } else if (category.equals(context.getString(R.string.stay_category))) {
            return getStaying();
        }
        return new ArrayList<>();
    }
}
