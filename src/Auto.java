package src;

import java.util.Collection;

public class Auto {
    public String Merk;
    public Collection<VerhuurFragment> Fragmenten;

    public String getMerk() {
        return Merk;
    }

    public Collection<VerhuurFragment> getFragmenten() {
        return Fragmenten;
    }
}
