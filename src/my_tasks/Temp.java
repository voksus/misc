package my_tasks;

import java.math.BigInteger;

/**
 * @author Volodymyr Burtsev at 13.04.2018 0:23
 */
public class Temp {
    public static void main(String[] args) {
        BigInteger bi1 = new BigInteger("7905")
                .multiply(new BigInteger("2").pow(352281))
                .add(new BigInteger("1"));
        System.out.println(bi1.toString().length());

        BigInteger bi2 = new BigInteger("475856")
                .pow(524288);
        System.out.println(bi2.toString().length());
//        System.out.println(bi.isProbablePrime(1));
    }
}