public class Pokerhand {
    public static void main (String[] args) {
        final int C = 0;
        final int D = 1;
        final int H = 2;
        final int S = 3;

        final int T = 10;
        final int J = 11;
        final int Q = 12;
        final int K = 13;
        final int A = 14;

        Card[] h1 = {new Card(C,2), new Card(C,6), new Card(D,4), new Card(C,5), new Card(C,8)};
        Card[] h2 = {new Card(C,2), new Card(H,8), new Card(C,5), new Card(C,6), new Card(C,3)};
        //Card[] h2 = {new Card(H,2), new Card(D,2), new Card(H,J), new Card(S,2), new Card(S,J)};
        Hand hand1 = new Hand (h1);
        Hand hand2 = new Hand (h2);

        if (hand1.isValid() && hand2.isValid()) {
            System.out.println("Hand 1:");
            hand1.order();
            hand1.isFlush();
            hand1.isStraight();
            hand1.findPairs();
            System.out.println("");
            System.out.println("Hand 2:");
            hand2.order();
            hand2.isFlush();
            hand2.isStraight();
            hand2.findPairs();
            int winner = 0;   //0 means draw
            if (hand1.getRank() < hand2.getRank()) {
                winner = 2;
            } else if (hand1.getRank() > hand2.getRank()) {
                winner = 1;
            } else {
                for (int i = 0; i < 5; i++) {
                    if (hand1.cards[i].getV() < hand2.cards[i].getV()) {
                        winner = 2;
                        break;
                    } else if (hand1.cards[i].getV() > hand2.cards[i].getV()) {
                        winner = 1;
                        break;
                    }
                }
            }
            switch (winner) {
                case 2:
                    System.out.println("Hand 2 has won");
                    break;
                case 1:
                    System.out.println("Hand 1 has won");
                    break;
                default:
                    System.out.println("Draw");
                    break;
            }
        }
    }
}
