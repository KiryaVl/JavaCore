/*
1). Создать программу управления банковским счетом (Account).

Программа должна позволять пользователю вводить начальный баланс счета, сумму депозита и сумму снятия средств. При этом она должна обрабатывать следующие исключительные ситуации:

Попытка создать счет с отрицательным начальным балансом должна вызывать исключение IllegalArgumentException с соответствующим сообщением.
Попытка внести депозит с отрицательной суммой должна вызывать исключение IllegalArgumentException с соответствующим сообщением.
Попытка снять средства, сумма которых превышает текущий баланс, должна вызывать исключение InsufficientFundsException с сообщением о недостаточных средствах и текущим балансом.

Продемонстрируйте работу вашего приложения:
Программа должна обрабатывать все исключения с помощью конструкции try-catch, выводя соответствующие сообщения об ошибках.

2*.
Создать несколько типов счетов, унаследованных от Account, например: CreditAccount, DebitAccount.
Создать класс (Transaction), позволяющий проводить транзакции между счетами (переводить сумму с одного счета на другой)

Класс Transaction должен возбуждать исключение в случае неудачной попытки перевести деньги с одного счета на другой.

Продемонстрируйте работу вашего приложения:
Программа должна обрабатывать все исключения с помощью конструкции try-catch, выводя соответствующие сообщения об ошибках.
 */
public class Main {
    public static void main(String[] args) {
        try {
            Account account1 = new Account("Arkadi", "qwerty123", 120);
            Account account2 = new Account("Maria", "qwerty12321", 123);
            Account account3 = new Account("Robinovich", "qwerty1234", 120000.50);

            account1.deposit(500);
            account2.deposit(-100);
            account3.deposit(1);

            account1.withdrawMoney(100);
            account2.withdrawMoney(5000);
            account3.withdrawMoney(2);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            Account account1 = new DebitAccount("Arkadi", "qwerty123", 120);
            Account account2 = new CreditAccount("Maria", "qwerty12321", 123, 1000);

            account1.deposit(500);
            account2.deposit(1);

            account1.withdrawMoney(100);
            account2.withdrawMoney(2000);

            Transaction.transfer(account1, account2, 50);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}