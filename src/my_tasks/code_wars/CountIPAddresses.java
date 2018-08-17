package my_tasks.code_wars;

/**
 * @author Volodymyr Burtsev at 24.07.2018 14:12
 */
public class CountIPAddresses {

    public static void main(String[] args) {
        System.out.println(ipsBetween("10.0.0.0", "10.0.0.50"));
        System.out.println(ipsBetween("10.0.0.0", "10.0.1.0"));
        System.out.println(ipsBetween("20.0.0.10", "20.0.1.0"));
    }

    public static long ipsBetween(String start, String end) {
        int result = 0;
        for(int i = 0; i < 4; i++) {
            result += (Integer.valueOf(end.split("\\.")[i])
                    - Integer.valueOf(start.split("\\.")[i]))
                    << (24 - i * 8);
        }
        return result;
    }
}