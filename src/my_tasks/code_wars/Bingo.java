package my_tasks.code_wars;

/**
 * @author Volodymyr Burtsev at 18.01.2018 16:35
 *
 * After yet another dispute on their game the Bingo Association decides to change course and automize the game.
 *
 * Can you help the association by writing a method to create a random Bingo card?
 *
 * Task:
 *
 * Finish method:
 * BingoCard.getCard()
 * A Bingo card contains 24 unique and random numbers according to this scheme:
 *      5 numbers from the B column in the range 1 to 15
 *      5 numbers from the I column in the range 16 to 30
 *      4 numbers from the N column in the range 31 to 45
 *      5 numbers from the G column in the range 46 to 60
 *      5 numbers from the O column in the range 61 to 75
 *
 * The card must be returned as an array of Bingo style numbers:
 * { "B14", "B12", "B5", "B6", "B3", "I28", "I27", ... }
 * The numbers must be in the order of their column: B, I, N, G, O. Within the columns the order of the numbers is random.
 *
 */
public class Bingo {

    public static void main(String[] args) {
        String[] bingo = getCard();
        for (int i = 0; i < 24; i++) {
            System.out.printf("%4s", bingo[i]);
        }
    }

    public static String[] getCard() {
        String[] arr = new String[25];
        int count = 0, nextRandom;
        String tmp;
        char[] ch = "BINGO".toCharArray();
        for (int i = 0; i < 5; i++) {
            for (int c = 0; c < 5; c++) {
                nextRandom = (int)(Math.random() * Integer.MAX_VALUE) % 15 + 1 + i * 15;
                tmp = ch[i] + String.valueOf(nextRandom);
                arr[count] = tmp;
                count++;
            }
        }
        String[] result = new String[24];
        System.arraycopy(arr, 0, result, 0, 13);
        System.arraycopy(arr, 13, result, 12, 12);
        return result;
    }
}