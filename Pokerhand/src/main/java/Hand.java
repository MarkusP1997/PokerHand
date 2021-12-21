public class Hand {

    private final Card[] cards;

    private int rank;
    private int pair;
    private int pair2;
    private int triple;
    private int quadruple;

    public Hand (Card[] c) {
        cards = c;
        if(isValid()) {
            order();
            findPairs();
            rank = determineRank();
        }
    }

    public boolean isValid() {
        if (cards.length != 5) {
            System.out.println("invalid number of cards on hand");
            return false;
        }
        return true;
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
            swap (i, maxCard);
        }
    }

    public void swap (int a, int b) {
        Card swap = cards[a];
        cards[a] = cards[b];
        cards[b] = swap;
    }

    public boolean isFlush() {
        for (int i = 1; i < 5; i++) {
            if (cards[i].getS() != cards[0].getS()) {
                return false;
            }
        }
        return true;
    }

    public boolean isStraight() {
        for (int i = 3; i > -1; i--) {
            if (cards[i].getV() != cards[i+1].getV() + 1) {
                if (i==0 && cards[0].getV() == 14 && cards[1].getV() == 5) { //A,5,4,3,2 is a straight
                    swap(0,1); //in this case 5 is the highest card. The order of the rest doesn´t matter
                    return true;
                }
                return false;
            }
        }
        return true;
    }


    public void findPairs() {
        int counter = 1;
        for (int i = 1; i < 6; i++) {
            if (i < 5 && cards[i - 1].getV() == cards[i].getV()) {
                counter++;
            } else {
                switch (counter) {
                    case 2:
                        if (pair != 0) {
                            pair2 = cards[i - 1].getV();
                            swap(2, i-2);
                            swap(3, i-1);
                        } else if (triple != 0) {
                            pair = cards[i - 1].getV();
                            swap(3, i-2);
                            swap(4, i-1);
                        } else {
                            pair = cards[i - 1].getV();
                            swap(0, i-2);
                            swap(1, i-1);
                        }
                        break;
                    case 3:
                        triple = cards[i - 1].getV();
                        swap(0, i-2);
                        swap(1, i-1);
                        break;
                    case 4:
                        quadruple = cards[i - 1].getV();
                        swap(0, i-1);
                        break;
                }
                counter = 1;
            }
        }
    }

    public int determineRank() {
        if (pair != 0) {
            if (pair2 != 0) {
                return 2; //Two pairs
            } else if (triple != 0) {
                return 6; //Full House
            }
            return 1; //Pair
        }
        if (triple != 0) {
            return 3; //Three of a kind
        }
        if(isStraight()) {
            if(isFlush()) {
                return 8; //Straight Flush
            }
            return 4;   //Straight
        }
        if(isFlush()) {
            return 5; //Flush
        }
        if(quadruple != 0) {
            return 7; //Four of a kind
        }
        return 0;
    }

    public Card getCard(int i) {
        return cards[i];
    }

    public int getRank() {
        return rank;
    }
}
