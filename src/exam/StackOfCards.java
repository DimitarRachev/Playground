package exam;

import java.util.Random;

public class StackOfCards {
    Card[] cards;
    Card[] pack1;
    Card[] pack2;
    Card[] hand; // текущо изтеглена ръка от най- много 12 карти
    int trump; // индекс на цвят в Cards.suits, Коз на играта
    Random random = new Random(); // генератор на случайни числа
    int currentCard; // брой карти изтеглени текущо от cards
    int currentPack1; // брой карти изтеглени текущо от pack2
    int currentPack2; // брой карти изтеглени текущо от pack1

    public StackOfCards() {
        this.cards = getCards();
        this.pack1 = pack1;
        this.pack2 = pack2;
        this.hand = hand;
        this.trump = random.nextInt(4);

        this.currentCard = currentCard;
        this.currentPack1 = currentPack1;
        this.currentPack2 = currentPack2;
    }

    public int getTrump() {
        return trump;
    }

    private Card[] getCards() {
        Card[] cards = new Card[64];
        int index = 0;
        for (int i = 0; i < Card.faces.length; i++) {
            int face = i;
            for (int j = 0; j < Card.suits.length; j++) {
                int suit = j;
                cards[index++] = new Card(face, suit);

            }
        }
        return cards;
    }
}
