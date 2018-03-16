package com.example.android.tourguideapp;

import android.content.Context;

import java.util.ArrayList;

/**
 *  Created by Lenovo on 13/03/2018.
 */

final class PlacesInput {

    private PlacesInput() {
        throw new AssertionError("No Places Input Instances for you!");
    }

    // Input places by category to array lists
    private static ArrayList<Places> getSeeing(Context context) {
        ArrayList<Places> places=new ArrayList<>();
        places.add(new Places(context.getString(R.string.triumphal_arch), context.getString(R.string.land_free),
                R.drawable.arcul));
        places.add(new Places(context.getString(R.string.athenaeum), context.getString(R.string.concert),
                R.drawable.atheneum));
        places.add(new Places(context.getString(R.string.mansion), context.getString(R.string.museum),
                R.drawable.ceau));
        places.add(new Places(context.getString(R.string.old_court), context.getString(R.string.open_museum),
                R.drawable.cveche));
        places.add(new Places(context.getString(R.string.parliament), context.getString(R.string.landmark),
                R.drawable.casa_poporului));
        places.add(new Places(context.getString(R.string.stavropoleos), context.getString(R.string.architecture),
                R.drawable.stavrop));
        return places;
    }

    private static ArrayList<Places> getArt(Context context) {
        ArrayList<Places> places=new ArrayList<>();
        places.add(new Places(context.getString(R.string.art_collection),
                context.getString(R.string.museum), R.drawable.c_arta));
        places.add(new Places(context.getString(R.string.village_museum),
                context.getString(R.string.open_museum), R.drawable.muzeul_satului));
        places.add(new Places(context.getString(R.string.antipa), context.getString(R.string.museum),
                R.drawable.mantipa));
        places.add(new Places(context.getString(R.string.pallady),
                context.getString(R.string.museum_art), R.drawable.pallady));
        places.add(new Places(context.getString(R.string.kitsch), context.getString(R.string.museum),
                R.drawable.kitsch));
        places.add(new Places(context.getString(R.string.history), context.getString(R.string.museum),
                R.drawable.istorie));
        return places;
    }

    private static ArrayList<Places> getShopping(Context context) {
        ArrayList<Places> places=new ArrayList<>();
        places.add(new Places(context.getString(R.string.unirea), context.getString(R.string.shopping),
                R.drawable.unirea));
        places.add(new Places(context.getString(R.string.afi), context.getString(R.string.mall),
                R.drawable.afi));
        places.add(new Places(context.getString(R.string.peasant), context.getString(R.string.folk),
                R.drawable.mtr));
        places.add(new Places(context.getString(R.string.carusel), context.getString(R.string.books),
                R.drawable.carusel));
        places.add(new Places(context.getString(R.string.tei), context.getString(R.string.souvenirs),
                R.drawable.tei));
        places.add(new Places(context.getString(R.string.vitan), context.getString(R.string.market),
                R.drawable.antichiati));
        return places;
    }

    private static ArrayList<Places> getDining(Context context) {
        ArrayList<Places> places=new ArrayList<>();
        places.add(new Places(context.getString(R.string.caru), context.getString(R.string.rom2),
                R.drawable.bere));
        places.add(new Places(context.getString(R.string.lacrimi), context.getString(R.string.rom3),
                R.drawable.lacrimi));
        places.add(new Places(context.getString(R.string.artist), context.getString(R.string.eur4),
                R.drawable.artist));
        places.add(new Places(context.getString(R.string.osho), context.getString(R.string.steak4),
                R.drawable.osho));
        places.add(new Places(context.getString(R.string.yuki), context.getString(R.string.jap2),
                R.drawable.yuki));
        places.add(new Places(context.getString(R.string.becas), context.getString(R.string.sea_med2),
                R.drawable.beca));
        return places;
    }

    private static ArrayList<Places> getStaying(Context context) {
        ArrayList<Places> places=new ArrayList<>();
        places.add(new Places(context.getString(R.string.epoque), context.getString(R.string.hotel3),
                R.drawable.epoque));
        places.add(new Places(context.getString(R.string.rembrandt), context.getString(R.string.hotel2),
                R.drawable.rembrandt));
        places.add(new Places(context.getString(R.string.inter), context.getString(R.string.hotel3),
                R.drawable.inter));
        places.add(new Places(context.getString(R.string.zet), context.getString(R.string.hotel3),
                R.drawable.z));
        places.add(new Places(context.getString(R.string.capsa), context.getString(R.string.hotel3),
                R.drawable.capsa));
        places.add(new Places(context.getString(R.string.little), context.getString(R.string.hostel1),
                R.drawable.little));
        return places;
    }

    // Return lists of places by category
    static ArrayList<Places> getPlaces(Context context, String category) {
        if (category.equals(context.getString(R.string.see_category))) {
            return getSeeing(context);
        } else if (category.equals(context.getString(R.string.art_category))) {
            return getArt(context);
        } else if (category.equals(context.getString(R.string.dine_category))) {
            return getDining(context);
        } else if (category.equals(context.getString(R.string.shop_category))) {
            return getShopping(context);
        } else if (category.equals(context.getString(R.string.stay_category))) {
            return getStaying(context);
        }
        return new ArrayList<>();
    }
}
