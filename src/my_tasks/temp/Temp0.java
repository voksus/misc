package my_tasks.temp;

import my_tasks.solutions.LCol;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author Volodymyr Burtsev
 */
public class Temp0 {

    public static void main(String[] args) {

        File f1 = new File("./src");

        if (f1.isDirectory()) {
            String[] d = f1.list();
            for (int i = 0; i < d.length; i++) {
                System.out.println(d[i]);
            }
        }

        File f2 = new File("./src/Factorial.java");

        if (f2.isFile()) {
            System.out.println("\n" + f2.length());

            try {
                FileInputStream fis = new FileInputStream(f2);

                System.out.println(fis.available());
                byte[] data = new byte[fis.available()];
                fis.read(data);

                String fileTextData = new String(data);

                LCol.INVERTED.use();
                LCol.BOLD_FONT.use();

                System.out.println(fileTextData);

                LCol.RESET.use();

            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }
}