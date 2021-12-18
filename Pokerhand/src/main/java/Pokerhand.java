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

        Card[] h1 = {new Card(C,2), new Card(C,6), new Card(C,3), new Card(C,5), new Card(C,4)};
        Hand hand1 = new Hand (h1);
        Card[] h2 = {new Card(H,2), new Card(D,2), new Card(H,J), new Card(S,2), new Card(S,J)};
        Hand hand2 = new Hand (h2);

        if (hand1.isValid() && hand2.isValid()) {
            System.out.println("valid hands");
            System.out.println("");
            System.out.println("Hand 1:");
            hand1.order();
            hand1.isFlush();
            hand1.isStraight();
            System.out.println("");
            System.out.println("Hand 2:");
            hand2.order();
            hand2.isFlush();
            hand2.isStraight();
        }
    }
}
