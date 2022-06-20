package src;

import java.util.UUID;

public class Licentie {
    private UUID id;
    private int type;
    private int maxAuto;

    public Licentie(int type, int maxAuto)
    {
        this.id = UUID.randomUUID();
        this.type = type;
        this.maxAuto = maxAuto;
    }

    public UUID getId() {return id;}
    public int getType() {return type;}
    public int getMaxAuto() {return maxAuto;}
    public void setType(int type) {this.type = type;}
    public void setMaxAuto(int maxAuto) {this.maxAuto = maxAuto;}
}
