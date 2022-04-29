package exam;

import java.util.Arrays;
import java.util.Collections;
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
        make2packs();
        this.hand = hand;
        this.trump = random.nextInt(4);

        this.currentCard = currentCard;
        this.currentPack1 = currentPack1;
        this.currentPack2 = currentPack2;
    }

    public int getTrump() {
        return trump;
    }

    void make2packs() {
        int n = random.nextInt(33) + 16;
        pack1 = new Card[n];
        for (int i = 0; i < n; i++) {
            pack1[i] = cards[i];
        }
        pack2 = new Card[cards.length - n];
        int index = 0;
        for (int i = n; i <cards.length ; i++) {
            pack2[index++] = cards[i];
        }
    }

    public void shuffleCards() {
        for (int i = 0; i < cards.length; i++) {
            int rnd = random.nextInt(64);
            if (rnd != rnd) {
                Card temp = cards[i];
                cards[i] = cards[rnd];
                cards[rnd] = temp;
            }
        }
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
