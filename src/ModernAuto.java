package src;

import java.util.ArrayList;

public class ModernAuto implements AutoInterface {

    private String Merk;
    private Boolean cruiseControl;
    private int aantalDeuren;
    private int aantalAirbags;
    private ArrayList <VerhuurFragment> Fragmenten = new ArrayList < > ();
    private static final ArrayList < ModernAuto > Autos = new ArrayList < > ();
    private Boolean isHired = false;

    public void setMerk(String merk) {
        this.Merk = merk;
    }

    public Boolean getCruiseControl() {
        return cruiseControl;
    }

    public void setCruiseControl(Boolean cruiseControl) {
        this.cruiseControl = cruiseControl;
    }

    public void setAantalDeuren(int aantalDeuren) {
        this.aantalDeuren = aantalDeuren;
    }

    public int getAantalAirbags() {
        return aantalAirbags;
    }

    public void setAantalAirbags(int aantalAirbags) {
        this.aantalAirbags = aantalAirbags;
    }

    public void setFragmenten(ArrayList <VerhuurFragment> fragmenten) {
        Fragmenten = fragmenten;
    }
    public ModernAuto getModernAuto() {
        return this;
    }

    @Override
    public String getMerk() {
        return this.Merk;
    }

    @Override
    public int getAantalDeuren() {
        return this.aantalDeuren;
    }

    @Override
    public void maakSchoon() {
        this.setHired(false);
        System.out.println(this.getMerk() + " is schoongemaakt en gereed voor verhuur");
    }

    @Override
    public void addFragment(VerhuurFragment verhuurFragment) {
        this.Fragmenten.add(verhuurFragment);
    }
    public static ArrayList < ModernAuto > getAutos() {
        return Autos;
    }

    public ArrayList <VerhuurFragment> getFragmenten() {
        return Fragmenten;
    }

    public Boolean getHired() {
        return isHired;
    }

    public void setHired(Boolean hired) {
        isHired = hired;
    }
}