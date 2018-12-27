package com.practice.osho.healthynepali;

/**
 * Created by osho on 11/9/15.
 */
public class HerbalHelpDiseases {

    private int[] id4images,id4titles,id4nepaliTitles,id4descriptions;

    private HerbalHelpDiseases(int[] id4images, int[] id4titles, int[] id4nepaliTitles, int[] id4descriptions){
        this.id4images=id4images;
        this.id4titles=id4titles;
        this.id4nepaliTitles=id4nepaliTitles;
        this.id4descriptions=id4descriptions;
    }

    public static final HerbalHelpDiseases inDigestion = new HerbalHelpDiseases(
            new int[]{R.drawable.cardamom,R.drawable.coriander,R.drawable.lemon_grass},
            new int[]{R.string.cardamom,R.string.coriander,R.string.lemon_grass},
            new int[]{R.string.cardamom_nepali,R.string.coriander_nepali,R.string.lemon_grass_nepali},
            new int[]{R.string.cardamom_description,R.string.coriander_description,R.string.lemon_grass_description}
    );
    public static final HerbalHelpDiseases diarrhoea = new HerbalHelpDiseases(
            new int[]{R.drawable.peppermint,R.drawable.blackberry,R.drawable.lemon},
            new int[]{R.string.peppermint,R.string.blackberry,R.string.lemon},
            new int[]{R.string.peppermint_nepali,R.string.blackberry_nepali,R.string.lemon_nepali},
            new int[]{R.string.peppermint_description,R.string.blackberry_description,R.string.lemon_description}
    );
    public static final HerbalHelpDiseases commonCold = new HerbalHelpDiseases(
            new int[]{R.drawable.ginger,R.drawable.garlic,R.drawable.black_pepper},
            new int[]{R.string.ginger,R.string.garlic,R.string.black_pepper},
            new int[]{R.string.ginger_nepali,R.string.garlic_nepali,R.string.black_pepper_nepali},
            new int[]{R.string.ginger_description,R.string.garlic_description,R.string.black_pepper_description}
    );
    public static final HerbalHelpDiseases fever = new HerbalHelpDiseases(
            new int[]{R.drawable.chrysanthemum,R.drawable.tulsi,R.drawable.ecalyptus},
            new int[]{R.string.chrysanthemum,R.string.tulsi,R.string.ecalyptus},
            new int[]{R.string.chrysanthemum_nepali,R.string.tulsi_nepali,R.string.ecalyptus_nepali},
            new int[]{R.string.chrysanthemum_description,R.string.tulsi_description,R.string.ecalyptus_description}
    );
    public static final HerbalHelpDiseases pimples = new HerbalHelpDiseases(
            new int[]{R.drawable.aloevera,R.drawable.orange_peel,R.drawable.tomato},
            new int[]{R.string.aloevera,R.string.orange_peel,R.string.tomato},
            new int[]{R.string.aloevera_nepali,R.string.orange_peel_nepali,R.string.tomato_nepali},
            new int[]{R.string.aloevera_description,R.string.orange_peel_description,R.string.tomato_description}
    );





    public int[] getId4images() {
        return id4images;
    }

    public int[] getId4titles() {
        return id4titles;
    }

    public int[] getId4nepaliTitles() {
        return id4nepaliTitles;
    }

    public int[] getId4descriptions() {
        return id4descriptions;
    }
}
