package my_tasks.code_wars;

/**
 * @author Volodymyr Burtsev at 03.06.2019 1:09
 */
public class SeatsInTheater {

    public static void main(String[] args) {
        System.out.println(seatsInTheater(16,11,5,3));
    }

    public static int seatsInTheater(int nCols, int nRows, int col, int row) {

        return (nRows - row) * (nCols - col + 1);

    }
}