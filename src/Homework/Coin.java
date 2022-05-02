package Homework;

import java.util.Random;

public class Coin {
    private Random rand;
   private Face face;

    public Coin(Face face) {
        this.face = face;
        rand = new Random();
    }

   public void flip() {
        if (face == Face.HEAD) {
            face = Face.TAIL;
        } else {
            face = Face.HEAD;
        }
    }

    public boolean isHeads() {
        return face == Face.HEAD;
    }

    public Face getFace() {
        return face;
    }

    public void setFace(Face face) {
        this.face = face;
    }

    @Override
    public String toString() {
        return "Coin with face " + (face == Face.HEAD ? "head" : "tail");
    }
}
