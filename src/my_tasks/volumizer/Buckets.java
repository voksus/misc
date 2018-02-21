package my_tasks.volumizer;

/**
 * @author Volodymyr Burtsev at 15.12.2017 19:07
 */

import my_tasks.volumizer.filling.exceptions.NegativeAmountException;
import my_tasks.volumizer.filling.exceptions.NoProperFillingException;
import my_tasks.volumizer.filling.exceptions.NullAmountException;

import java.util.*;

public class Buckets {

    public static void main(String[] args) {

//        int amount = new Random().nextInt(100);
        int amount = 9;

        List<Integer> volumes = Arrays.asList(20, 10, 5, 2, 1);

        long begin = System.nanoTime();
        List<Map<Integer, Integer>> variants = getVariants(amount, volumes);
        System.out.println("time = " + (System.nanoTime() - begin));

        for (Map<Integer, Integer> map : variants) {
            //TODO
            String f = "", s = "";
            for (Map.Entry<Integer, Integer> solution : map.entrySet()) {
                //TODO
                s = "";
                System.out.print(solution.getValue() + "*" + solution.getKey() + "л ");
            }
            //TODO
            System.out.printf(f, s);
            System.out.println();
        }

        System.out.println("For amount = " + amount + " total variants = " + variants.size());

    }

    public static List<Map<Integer, Integer>> getVariants(int amount, List<Integer> volumes) {

        if (amount < 0) throw new NegativeAmountException();

        if (amount == 0) throw new NullAmountException();

        if (amount < Collections.min(volumes)) throw new NoProperFillingException();

        List<Map<Integer, Integer>> solutions = new ArrayList<>();

        Map<Integer, Integer> solution = new HashMap<>();

        calculate(amount, volumes, solutions, solution);

        return solutions;
    }

    private static void calculate(int amount, List<Integer> volumes,
                                  List<Map<Integer, Integer>> solutions,
                                  Map<Integer, Integer> solution) {

        Integer firstVolume = volumes.get(0);

        if (volumes.size() == 1) {
            if (amount % firstVolume == 0) {
                solution.put(firstVolume, amount / firstVolume);
                solutions.add(solution);
            }

        } else if (volumes.size() > 1) {

            List<Integer> nextVolumes = volumes.subList(1, volumes.size());

            for (int i = amount / firstVolume; i >= 0; i--) {

                Map<Integer, Integer> nextSolution = new HashMap<>(solution);

                nextSolution.put(firstVolume, i);

                int nextAmount = amount - i * firstVolume;

                calculate(nextAmount, nextVolumes, solutions, nextSolution);
            }
        }
    }
}