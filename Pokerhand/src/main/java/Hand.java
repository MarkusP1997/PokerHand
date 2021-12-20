public class Hand {

    Card[] cards;

    int pair;
    int pair2;
    int triple;
    int quadruple;

    public Hand (Card[] c) {
        cards = c;
    }

    public boolean isValid() {
        if (cards.length != 5) {
            System.out.println("invalid number of cards on hand");
            return false;
        }
        return true;
    }
    public void order() {
        System.out.print ("Card values: ");
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
            System.out.print (maxV + " ");
        }
        System.out.println ("");
    }
    public void swap (int a, int b) {
        Card swap = cards[a];
        cards[a] = cards[b];
        cards[b] = swap;

    }

    public boolean isFlush() {
        for (int i = 1; i < 5; i++) {
            if (cards[i].getS() != cards[0].getS()) {
                //System.out.println("no flush");
                return false;
            }
        }
        //System.out.println("flush");
        return true;
    }

    public boolean isStraight() {
        for (int i = 1; i < 5; i++) {
            if (cards[i].getV() != cards[i-1].getV() - 1) {
                //System.out.println("no straight");
                return false;
            }
        }
        //System.out.println("straight");
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
                        System.out.println("pair: " + cards[i - 1].getV());
                        if (pair == 0) {
                            pair = cards[i - 1].getV();
                        } else {
                            pair2 = cards[i - 1].getV();
                        }
                        break;
                    case 3:
                        System.out.println("triple: " + cards[i - 1].getV());
                        triple = cards[i - 1].getV();
                        break;
                    case 4:
                        System.out.println("quadruple: " + cards[i - 1].getV());
                        quadruple = cards[i - 1].getV();
                        break;
                }
                counter = 1;
            }
        }
    }
    public int getRank() {
        if (pair != 0) {
            if (pair2 != 0) {
                return 2; //Two pairs
            } if (triple != 0) {
                return 6; //Full House
            }
            return 1; //Pair
        }
        if (triple != 0) {
            return 3; //Three of a kind
        }
        if(isStraight()) {
            if(isFlush()) {
                return 8;
            }
            return 4;
        }
        if(isFlush()) {
            return 5; //Flush
        }
        if(quadruple != 0) {
            return 7; //Four of a kind
        }
        return 0;
    }
}
