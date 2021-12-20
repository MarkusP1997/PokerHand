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

        Card[] highCard1 = {new Card(C,2), new Card(C,6), new Card(D,4), new Card(C,5), new Card(C,8)};
        Card[] highCard2 = {new Card(C,2), new Card(H,8), new Card(C,5), new Card(C,6), new Card(C,4)};
        Card[] pair1 = {new Card(C,8), new Card(C,6), new Card(D,4), new Card(C,4), new Card(C,2)};
        Card[] pair2 = {new Card(C,6), new Card(H,2), new Card(C,5), new Card(C,6), new Card(C,3)};
        Card[] twoPairs1 = {new Card(C,8), new Card(C,6), new Card(D,4), new Card(C,4), new Card(C,6)};
        Card[] twoPairs2 = {new Card(C,6), new Card(H,5), new Card(C,5), new Card(C,6), new Card(C,3)};
        Card[] triple1 = {new Card(C,J), new Card(H,5), new Card(C,5), new Card(C,5), new Card(C,3)};
        Card[] triple2 = {new Card(C,2), new Card(C,6), new Card(D,6), new Card(C,4), new Card(C,6)};
        Card[] straight1 = {new Card(C,2), new Card(C,A), new Card(D,4), new Card(C,5), new Card(C,3)};
        Card[] straight2 = {new Card(C,7), new Card(H,8), new Card(C,5), new Card(C,6), new Card(C,4)};
        Card[] flush1 = {new Card(C,2), new Card(C,6), new Card(C,Q), new Card(C,7), new Card(C,8)};
        Card[] flush2 = {new Card(S,2), new Card(S,8), new Card(S,5), new Card(S,6), new Card(S,Q)};
        Card[] fullHouse1 = {new Card(H,2), new Card(D,2), new Card(H,J), new Card(S,2), new Card(S,J)};
        Card[] fullHouse2 = {new Card(H,3), new Card(D,3), new Card(H,4), new Card(S,4), new Card(S,4)};
        Card[] quadruple1 = {new Card(C,A), new Card(C,6), new Card(D,6), new Card(C,6), new Card(C,6)};
        Card[] quadruple2 = {new Card(C,T), new Card(H,K), new Card(C,K), new Card(C,K), new Card(C,K)};
        Card[] straightFlush1 = {new Card(H,2), new Card(H,4), new Card(H,5), new Card(H,A), new Card(H,3)};
        Card[] straightFlush2 = {new Card(D,7), new Card(D,6), new Card(D,4), new Card(D,5), new Card(D,8)};
        Hand hand1 = new Hand (fullHouse1);
        Hand hand2 = new Hand (quadruple2);

        if (hand1.isValid() && hand2.isValid()) {
            //System.out.println("Hand 1:");
            hand1.order();
            hand1.isFlush();
            //hand1.isStraight();
            hand1.findPairs();
            int rank1 = hand1.getRank();
            //System.out.println("Rank: " + rank1);

            //System.out.println("Hand 2:");
            hand2.order();
            hand2.isFlush();
            //hand2.isStraight();
            hand2.findPairs();
            int rank2 = hand2.getRank();
            //System.out.println("Rank: " + rank2);

            int winner = 0;   //0 means draw
            if (rank1 < rank2) {
                winner = 2;
            } else if (rank1 > rank2) {
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
