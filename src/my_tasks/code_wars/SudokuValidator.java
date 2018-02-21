package my_tasks.code_wars;

/**
 * @author Volodymyr Burtsev at 27.01.2018 23:52
 *
 * Sudoku Background
 * Sudoku is a game played on a 9x9 grid. The goal of the game is to fill
 * all cells of the grid with digits from 1 to 9, so that each column, each row,
 * and each of the nine 3x3 sub-grids (also known as blocks) contain all of the digits from 1 to 9.
 * (More info at: http://en.wikipedia.org/wiki/Sudoku)
 *
 * Sudoku Solution Validator
 * Write a function validSolution/ValidateSolution/valid_solution() that accepts
 * a 2D array representing a Sudoku board, and returns true if it is a valid solution,
 * or false otherwise. The cells of the sudoku board may also contain 0's, which will
 * represent empty cells. Boards containing one or more zeroes are considered to be invalid solutions.
 *
 * The board is always 9 cells by 9 cells, and every cell only contains integers from 0 to 9.
 *
 * Examples
 * validSolution([
 * [5, 3, 4, 6, 7, 8, 9, 1, 2],
 * [6, 7, 2, 1, 9, 5, 3, 4, 8],
 * [1, 9, 8, 3, 4, 2, 5, 6, 7],
 * [8, 5, 9, 7, 6, 1, 4, 2, 3],
 * [4, 2, 6, 8, 5, 3, 7, 9, 1],
 * [7, 1, 3, 9, 2, 4, 8, 5, 6],
 * [9, 6, 1, 5, 3, 7, 2, 8, 4],
 * [2, 8, 7, 4, 1, 9, 6, 3, 5],
 * [3, 4, 5, 2, 8, 6, 1, 7, 9]
 * ]); // => true
 *
 * validSolution([
 * [5, 3, 4, 6, 7, 8, 9, 1, 2],
 * [6, 7, 2, 1, 9, 0, 3, 4, 8],
 * [1, 0, 0, 3, 4, 2, 5, 6, 0],
 * [8, 5, 9, 7, 6, 1, 0, 2, 0],
 * [4, 2, 6, 8, 5, 3, 7, 9, 1],
 * [7, 1, 3, 9, 2, 4, 8, 5, 6],
 * [9, 0, 1, 5, 3, 7, 2, 1, 4],
 * [2, 8, 7, 4, 1, 9, 6, 3, 5],
 * [3, 0, 0, 4, 8, 1, 1, 7, 9]
 * ]); // => false
 *
 */
public class SudokuValidator {

    public static void main(String[] args) {
        // int num = Integer.parseInt("1111111110", 2);    // when 1..9 bits is ON this will be 1022
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int res = 0;
        for(int n: numbers) {
            res += 1 << n;
        }
//        System.out.println(res + " > " + Integer.toBinaryString(res));

        int[][] sudoku = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        /*for (int[] row: sudoku) {
            for (int c: row) {
                System.out.printf("%3d", c);
            }
            System.out.println();
        }
        for (int i = 0; i < 81; i++) {
            if (i > 0 && i % 9 == 0) System.out.println();
            System.out.printf("%3d", sudoku[i / 9][i % 9]);
        }*/
        if (!check(sudoku)) System.out.println("Ooops.. =(");
    }

    public static boolean check(int[][] sudoku) {

        if (sudoku == null || sudoku.length != 9) return false;

        // check in rows, return false when '0' found
        for (int[] row: sudoku) {
            int res = 0;
            for (int num: row) {
                if (num == 0) return false;
                res += 1 << num;
            }
            if (res != 1022) return false;
        }

        // check in columns
        for (int column = 0; column < 9; column++) {
            int res = 0;
            for (int[] row: sudoku) {
                res += 1 << row[column];
            }
            if (res != 1022) return false;
        }

        // check in blocks
        int[] block = new int[]{
                0, 0, 0,
                0, 0, 0,
                0, 0, 0};
        for (int i = 0; i < 81; i++) {
            block[i / 9] += 1 << sudoku[i / 9][i % 9];
        }
        for (int res: block) {
            if (res != 1022) return false;
        }

        // System.out.println("Good =)");
        return true;
    }

}