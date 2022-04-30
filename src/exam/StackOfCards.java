package exam;

import java.util.Random;

public class StackOfCards {
    Card[] cards; // масив от всички карти в тестето от карти
    Card[] pack1; // масив на първото тесте след деленето на картите
    Card[] pack2; // масив на второто тесте след деленето на картите
    Card[] hand; // текущо изтеглена ръка от най- много 12 карти
    int trump; // индекс на цвят в Cards.suits, Коз на играта
    Random random; // генератор на случайни числа
    int currentCard; // брой карти изтеглени текущо от cards
    int currentPack1; // брой карти изтеглени текущо от pack2
    int currentPack2; // брой карти изтеглени текущо от pack1


    public StackOfCards() {
        this.cards = getCards();
        make2packs();
        this.trump = random.nextInt(4);
        currentCard = 0;
        currentPack1 = 0;
        currentPack2 = 0;
        dealHand();
    }

    boolean dealHand() {
        hand = new Card[12];
        for (int i = 0; i < hand.length; i++) {
            if (currentPack1 < pack1.length) {
                hand[i] = pack1[currentPack1++];
            } else if (currentPack2 < pack2.length) {
                hand[i] = pack2[currentPack2++];
            } else {
                return false;
            }
        }
        return true;
    }

    boolean has4ACE() {
        int aces = 0;
        for (Card card : hand) {
            if (card.getFace() == 0) {
                aces++;
                if (aces == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean hasKQ() {
        for (Card card : hand) {
            if (card.getFace() == 2) {
                for (Card card1 : hand) {
                    if (card1.getFace() == 3 && card1.getSuit() == card.getSuit()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    String printCards() {
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        for (Card card : hand) {
            counter++;
            sb.append(card);
            if (counter == 4) {
                sb.append(System.lineSeparator());
                counter = 0;
            }
        }
        return sb.toString();
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
        for (int i = n; i < cards.length; i++) {
            pack2[index++] = cards[i];
        }
    }

    public void shuffleCards() {
        currentCard = 0;
        for (int i = 0; i < cards.length; i++) {
            int rnd = random.nextInt(64);
            if (rnd != i) {
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
            for (int j = 0; j < Card.suits.length; j++) {
                cards[index++] = new Card(i, j);
            }
        }
        return cards;
    }
}
