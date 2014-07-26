package org.enthusia.app.enthusia.model;

import org.enthusia.app.R;

public final class EnthusiaEvents {

    public final static int[] drawables = {
            R.drawable.img_enthusia_cricket,
            R.drawable.img_enthusia_football,
            R.drawable.img_enthusia_basketball,
            R.drawable.img_enthusia_volleyball,
            R.drawable.img_enthusia_rink,
            R.drawable.img_enthusia_tennis,
            R.drawable.img_enthusia_tt,
            R.drawable.img_enthusia_kabaddi,
            R.drawable.img_enthusia_athletics,
            R.drawable.img_enthusia_throwball,
            R.drawable.img_enthusia_squash,
            R.drawable.img_enthusia_boxing,
            R.drawable.img_enthusia_carrom,
            R.drawable.img_enthusia_chess,
            R.drawable.img_enthusia_dodgeball,
            R.drawable.img_enthusia_badminton,
            R.drawable.img_enthusia_khokho,
            R.drawable.img_enthusia_swimming,
            R.drawable.img_enthusia_marathon,
            R.drawable.img_enthusia_handball
    };

    public final static String[] events = {
            "Cricket",
            "Football",
            "Basketball",
            "Volleyball",
            "Rink Football",
            "Tennis",
            "Table Tennis",
            "Kabaddi",
            "Athletics",
            "Throwball",
            "Squash",
            "Boxing",
            "Carrom",
            "Chess",
            "Dodgeball",
            "Badminton",
            "Kho Kho",
            "Swimming",
            "Marathon",
            "Handball"
    };

    public final static int[] rules = {
            R.string.enthusia_cricket,
            R.string.enthusia_football,
            R.string.enthusia_basketball,
            R.string.enthusia_volleyball,
            R.string.enthusia_rink,
            R.string.enthusia_tennis,
            R.string.enthusia_tt,
            R.string.enthusia_kabaddi,
            R.string.enthusia_athletics,
            R.string.enthusia_throwball,
            R.string.enthusia_squash,
            R.string.enthusia_boxing,
            R.string.enthusia_carrom,
            R.string.enthusia_chess,
            R.string.enthusia_dodgeball,
            R.string.enthusia_badminton,
            R.string.enthusia_kho,
            R.string.enthusia_swimming,
            R.string.enthusia_marathon,
            R.string.enthusia_handball
    };

    // TODO Add Event Heads
    public final static String[] getEventHead (int position) {
        switch (position) {
            case 0:
                return new String[] { "Malay Nandgave: +919167776210", "Varad Raut: +919833817238", "Rishab Mistry: +919769182868" };
        }
        return new String[] { "X: +91xxxxxxxxxx" };
    }
}