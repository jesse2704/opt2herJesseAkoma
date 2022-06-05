package src;

import java.util.ArrayList;

public class Auto {
    private String Merk;
    private ArrayList<VerhuurFragment> Fragmenten = new ArrayList<>();
    private static final ArrayList<Auto> Autos = new ArrayList<>();

    public Auto(String merk) {
        this.Merk = merk;
        Autos.add(this);
    }

    public String getMerk() {return Merk;}
    public ArrayList<VerhuurFragment> getFragmenten() {
        return Fragmenten;
    }
    public static ArrayList<Auto> getAutos() {
        return Autos;
    }
    public void addFragment(VerhuurFragment verhuurFragment)
    {
        this.Fragmenten.add(verhuurFragment);
    }
}
