package Calculator;

public class Calculated {
    public static int mult(int a, int b) {
        //Метод производящий умножение
        return a * b;
    }

    public static int div(int a, int b) {
        //Метод производящий деление и проверяющий, что деление не на 0
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Не дели на ноль!");
            e.getMessage();
        }
        return 0;
    }

    public static int add(int a, int b) {
        //Метод производящий сложение
        return a + b;
    }

    public static int sub(int a, int b) {
        //Метод производящий вычитание
        return a - b;
    }
}
