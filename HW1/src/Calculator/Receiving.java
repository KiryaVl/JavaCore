package Calculator;

import java.util.Scanner;

public class Receiving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int num1 = scanner.nextInt();

        System.out.print("Введите оператор (+, -, *, /): ");
        String operator = scanner.next();

        System.out.print("Введите второе число: ");
        int num2 = scanner.nextInt();

        int result = 0;

        // Выполните операцию в зависимости от оператора
        switch (operator) {
            case "+":
                result = Calculated.add(num1, num2);
                break;
            case "-":
                result = Calculated.sub(num1, num2);
                break;
            case "*":
                result = Calculated.mult(num1, num2);
                break;
            case "/":
                result = Calculated.div(num1, num2);
                break;
            default:
                System.out.println("Ошибка: Неверный оператор");
        }

        // Используйте декоратор для форматирования и вывода результата
        System.out.println(Decorator.formatResult(result));

        scanner.close();
    }
}