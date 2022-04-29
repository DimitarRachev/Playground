package exam;

public class Card {
    public static String[] faces = {"ACE", "KING", "QUEEN", "JACK", "TEN", "NINE", "EIGHT", "SEVEN"};
    public static String[] suits = {"CLUBS", "DIAMONDS", "HEARTS", "SPADES"};
    private int face;
    private int suit;

    public Card(int face, int suit) {
        this.face = face;
        this.suit = suit;
    }

    public int getFace() {
        return face;
    }

    public void setFace(int face) {
        this.face = face;
    }

    public int getSuit() {
        return suit;
    }

    private String getFaceName() {
        return faces[face];
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    String getSuitName() {
        return suits[suit];
    }

    @Override
    public String toString() {
        return getFaceName() + " of " + getSuitName();
    }
}
