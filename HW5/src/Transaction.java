class Transaction {
    public static void transfer(Account fromAccount, Account toAccount, double amount) {
        try {
            fromAccount.withdrawMoney(amount);
            toAccount.deposit(amount);
            System.out.printf("Транзакция прошла успешно. Сумма перевода: %.2f\n", amount);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка валидации: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Ошибка недостаточных средств: " + e.getMessage());
        }
    }
}