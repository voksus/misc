package my_tasks;

/**
 * @author Volodymyr Burtsev at 18.06.2019 10:18
 */

public class TestInitOrder {

    public static void main(String[] args) {
        Cat cat = new Cat("Rizhick");
    }
}

class Pet {

    private String name;

    static {
        System.out.println("1 - Static block in Pet");
    }

    {
        System.out.println("3 - First block in Pet");
    }

    {
        System.out.println("4 - Second block in Pet");
    }

    public Pet() {
        System.out.println("Pet empty constructor");
    }

    public Pet(String name) {
        System.out.println("5 - Pet constructor with Name " + name);
        this.name = name;
    }
}

class Cat extends Pet {

    private String name;

    static {
        System.out.println("2 - Static block in Cat");
    }

    {
        System.out.println("6 - First block in Cat");
    }

    {
        System.out.println("7 - Second block in Cat");
    }

    public Cat() {
        System.out.println("... Cat empty constructor");
    }

    public Cat(String name) {
        super(name); // without this will call super(). Если эту строчку убрать, то будет вызван конструктор Pet();
        System.out.println("8 - Cat constructor with Name: " + name);
        this.name = name;
    }

}
