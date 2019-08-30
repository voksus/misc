package my_tasks.solutions;

/**
 * @author Volodymyr Burtsev at 27.06.2019 1:41
 */
public enum LCol {


    RESET(),
    BOLD_FONT(1),
    UNDERLINE(4),
    INVERTED(7),
    WHITE(30),
    RED(31),
    GRASS_GREEN(32),
    YELLOW_GR(33),
    BLUE(34),
    MAGENTA_GR(35),
    TEAL(36),
    GRAY(37),
    BCK_White(40),
    BCK_RED(41),
    BCK_GRASS_GREEN(42),
    BCK_YELLOW_GR(43),
    BCK_BLUE(44),
    BCK_MAGENTA_GR(45),
    BCK_TEAL(46),
    BCK_GRAY(47),
    DARK_GRAY(90),
    LIGHT_RED(91),
    GRASS_GREEN_2(92),
    YELLOW(93),
    LIGHT_BLUE(94),
    LIGHT_MAGENTA(95),
    CYAN(96),
    BLACK(97),
    BCK_DARK_GRAY(100),
    BCK_LIGHT_RED(101),
    BCK_GRASS_GREEN_2(102),
    BCK_YELLOW(103),
    BCK_LIGHT_BLUE(104),
    BCK_LIGHT_MAGENTA(105),
    BCK_CYAN(106),
    BCK_BLACK(107);

    private int index;

    LCol() {
        index = 0;
    }

    LCol(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void use() {
        System.out.print(this);
    }

    @Override
    public String toString() {
        return "\u001B[" +
                index +
                'm';
    }
}