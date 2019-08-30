package my_tasks.solutions;

import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Volodymyr Burtsev at 04.08.2019 17:57
 *
 * Ищем т.н. магические квадраты.
 * На текущий момент это квадрат 3х3, в котором сумма квадратов чисел
 * будет одинаковой для всех строк, колонок и диагоналей.
 *
 * Этапы:
 * - ( ) Вывод результатов в консоль и сохранение в файл.
 * - ( ) Оценка вариантов поиска.
 * - ( ) Объём проверенных вариантов по принципу прямого перебора.
 *          Сделано : от 9 до ....
 */
public class MagicSquare {

    // константы
    private static final LCol logOnlyColor = LCol.DARK_GRAY;        //
    private static final LCol logOnlyValue = LCol.GRAY;             //
    private static final LCol logWithFileColor = LCol.WHITE;        //
    private static final LCol logWithFileValue = LCol.CYAN;         //
    private static final LCol logWithFileAfter = LCol.DARK_GRAY;    //
    private static final Calculate calcThread = new Calculate();    // поток для поиска и просчёта
    private static final TimeLogger timeLog = new TimeLogger();     // поток для онтроля времени

    // глобальные переменные
    private static String fileName;             // имя текстового файла для хранения результата
    private static Path fileToSave;             // текстовый файл для сохранения результатов
    private static int progressMinValue = 1;    // нижний предел, до которого дошёл просчёт вариантов
    private static int progressMaxValue = 9;    // верхний предел, до которого дошёл просчёт вариантов
    private static Calendar date;               // переменная для фиксации времени
    private static long uptimeLimit = 2;        // длительность работы поиска значений (сек)
    private volatile static boolean nonStop = true;      // флаг для остановки программы в процессе поиска по времени
    private volatile static boolean found = false;       // флаг поиска комбинации чисел

    // ячейки в переменных
    private static int[][] result = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    public static void main(String[] args) {

        date = new GregorianCalendar();
        DateFormat dfFileName = new SimpleDateFormat("yyy-MM-dd_HH-mm-ss");
        DateFormat dfLog = new SimpleDateFormat("d MMMM yyyy, HH:mm:ss");

        // подготовка файла для записи
        fileName = "MagicSquare_result_" + dfFileName.format(date.getTime()) + ".txt";
        // fileToSave = Files.createFile(fileName, );
        log("File to save:  ", fileName, logOnlyValue, false);

        log("Job Started:   ", dfLog.format(date.getTime()), logWithFileValue, true);


        calcThread.start();
        timeLog.start();
    }

    private static void log(String before, String info, LCol logColor, boolean saveToFile) {

        // определение цвета для 'before' и вывод в лог
        if (!saveToFile)
            System.out.print(logOnlyColor + before);
        else
            System.out.print(logWithFileColor + before);

        // вывод в лог информации 'info'
        System.out.print(logColor + info + LCol.RESET);

        if (!saveToFile) {
            System.out.println();
            return;
        }

        // сохранение информации в файл     >> in progress...
        System.out.println(logWithFileAfter + "  >> saved" + LCol.RESET);
    }

    // TODO : реализовать запись текущего состояния поиска для будущего продолжения
    private static void saveProgress() {

    }

    // основной поток для перебора и поиска 'Магического Квадрата'
    private static class Calculate extends Thread {
        @Override
        public void run() {
            square();
        }

        private void square() {
            // временные переменные
            long r1, r2, r3,    // строки (row)
                    c1, c2, c3, // колонки (column)
                    d1, d2;     // диагонали (diagonal)
            do {

                found = true;
                // присвоение временным переменным суммы квадратов строк, колонок и диагоналей
                r1 = comb(result[0][0], result[0][1], result[0][2]);
                r2 = comb(result[1][0], result[1][1], result[1][2]);
                r3 = comb(result[2][0], result[2][1], result[2][2]);
                c1 = comb(result[0][0], result[1][0], result[2][0]);
                c2 = comb(result[0][1], result[1][1], result[2][1]);
                c3 = comb(result[0][2], result[1][2], result[2][2]);
                d1 = comb(result[0][0], result[1][1], result[2][2]);
                d2 = comb(result[0][2], result[1][1], result[2][0]);

                // проверяем временные переменные : если одна из сумм меньше нуля, то примитив 'long' уже не подходит
                if (r1 < 0 || r2 < 0 || r3 < 0 || c1 < 0 || c2 < 0 || c3 < 0 || d1 < 0 || d2 < 0) {
                    // TODO : обработать случай когда сумма квадратов больше Long.MAX_VALUE
                }
                // проверка : если не одинаковая сумма 1й строки с остальными суммами, то идём к следующей итерации
                if (r1 != r2)           // сравнение 1го и 2го ряда
                    getNext();
                else if (r1 != r3)      // сравнение 1го и 3го ряда
                    getNext();
                else if (r1 != c1)      // сравнение 1го ряда и 1й колонки
                    getNext();
                else if (r1 != c2)      // сравнение 1го ряда и 2й колонки
                    getNext();
                else if (r1 != c3)      // сравнение 1го ряда и 3й колонки
                    getNext();
                else if (r1 != d1)      // сравнение 1го ряда и 1й диагонали
                    getNext();
                else if (r1 != d2)      // сравнение 1го ряда и 2й диагонали
                    getNext();
                // TODO : БИНГО !!!   Здесь нужно вывести результат, который наконец-то нашли :)
            progressMaxValue++;
            } while (nonStop);

        }

        private long comb(int arg1, int arg2, int arg3) {
            return arg1 * arg1 + arg2 * arg2 + arg3 * arg3;
        }

        // TODO : реализовать следующую итерацию для проверки 'Магического Квадрата'
        private void getNext() {
            found = false;
        }
    }

    private static class TimeLogger extends Thread {
        @Override
        public void run() {
            uptimeLimit *= 1000;
            do {
                try {
                    this.sleep(100);
                } catch (InterruptedException e) {
                    nonStop = false;
                    e.printStackTrace();
                    return;
                }
                System.out.print(date.getTime().getTime() + uptimeLimit - System.currentTimeMillis() + " . ");
                System.out.println(progressMinValue);
            } while (date.getTime().getTime() + uptimeLimit > System.currentTimeMillis());
            nonStop = false;
        }

    }
}