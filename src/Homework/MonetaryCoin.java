package Homework;

public class MonetaryCoin extends Coin {
    private int value;

    public MonetaryCoin(Face face) {
        super(face);
    }

    public MonetaryCoin(Face face, int value) {
        super(face);
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
