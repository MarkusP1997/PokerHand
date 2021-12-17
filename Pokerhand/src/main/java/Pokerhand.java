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

        Card[] hand1 = {new Card(C,2), new Card(C,6), new Card(C,3), new Card(C,5), new Card(C,4)};
        Card[] hand2 = {new Card(H,2), new Card(D,2), new Card(H,J), new Card(S,2), new Card(S,J)};

        if (isValid(hand1) && isValid(hand2)) {
            System.out.println("valid hands");
        }
    }
    public static boolean isValid(Card[] hand) {
        if (hand.length != 5) {
            System.out.println("invalid number of cards on hand");
            return false;
        }
        return true;
    }
}
