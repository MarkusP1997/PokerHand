public class Hand {
    Card[] cards;

    public Hand (Card[] c) {
        cards = c;
    }

    public void order() {
        for (int i = 0; i < 5; i++) {
            int maxV = cards[i].getV();
            int maxCard = i;
            for (int j = i+1; j < 5; j++) {
                if (cards[j].getV() > maxV) {
                    maxV = cards[j].getV();
                    maxCard = j;
                }
            }
            Card swap = cards[i];
            cards[i] = cards[maxCard];
            cards[maxCard] = swap;
            System.out.println ("Card " + i + ": value=" + maxV);
        }
    }

    public boolean isFlush() {
        for (int i = 1; i < 5; i++) {
            if (cards[i].getS() != cards[0].getS()) {
                System.out.println("no flush");
                return false;
            }
        }
        System.out.println("flush");
        return true;
    }

    public boolean isStraight() {
        for (int i = 1; i < 5; i++) {
            if (cards[i].getV() != cards[i-1].getV() - 1) {
                System.out.println("no straight");
                return false;
            }
        }
        System.out.println("straight");
        return true;
    }

    public boolean isValid() {
        if (cards.length != 5) {
            System.out.println("invalid number of cards on hand");
            return false;
        }
        return true;
    }
}
