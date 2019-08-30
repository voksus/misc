package my_tasks.temp;

import java.math.BigDecimal;

/**
 * @author Volodymyr Burtsev at 30.06.2019 14:11
 */
public class Temp1 {

    public static void main(String[] args) {

        /* вычисление шанса совпадения дня рождения у 'peopleCount' людей */
        int peopleCount = 22;
        System.out.println(getChanceOfSameBithrday(peopleCount));

        System.exit(0);



        /* вычисление суммы цифр в диапазоне min..max */
        int min = 0, max = 1_000_000;
        System.out.println(getSum(min, max));
    }

    private static double getChanceOfSameBithrday(int peopleCount) {

        BigDecimal num = new BigDecimal(364);
        for (int i = 1; i < peopleCount; i++) {
            num = num.multiply(new BigDecimal(364 - i));
        }

        num = num.divide(new BigDecimal(365).pow(peopleCount), 16, BigDecimal.ROUND_CEILING);

        return 100 - Double.valueOf(num.toString()) * 100;
    }

    public static int getSum(int min, int max) {
        int sum = 0;
        for(int i = min; i <= max; i++) {
            int l = String.valueOf(i).length();
            String s = Integer.toString(i);
            for(int q = 0; q < l; q++) {
                sum += Integer.valueOf(s.substring(q, q + 1));
            }
        }
        return sum;
    }

}