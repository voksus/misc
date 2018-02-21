package my_tasks.solutions;

public class TestNPE {
    public static String handle(Formatter f, String s) {
        if (s.isEmpty()) {
            return "(none)";
        }
        return f.format(s.trim());
    }
}

class Formatter {
    public String format(String value) {
        return "[" + value + "]";
    }
}

class Launch {
    public static void main(String[] args) {
        Formatter f = new Formatter();
        TestNPE.handle(f, "ushdf");
        long start = System.currentTimeMillis();
        while (start + 1000 > System.currentTimeMillis()) {}
    }
}