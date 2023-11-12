public class Account {
    private String userName;
    private String userPassword;
    private double balance;

    public Account(String userName, String userPassword, double balance) {
        this.userName = userName;
        this.userPassword = userPassword;

        try {
            if (balance < 0) {
                throw new IllegalArgumentException("Начальный баланс не может быть отрицательным.");
            }

            this.balance = balance;
            System.out.printf("Пользователь %s успешно создан, баланс пользователя %.2f\n", getUserName(), getBalance());
        } catch (IllegalArgumentException e) {
            System.out.printf("Попытка создать счет с отрицательным начальным балансом: %s\n", e.getMessage());
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Сумма депозита должна быть положительной.");
            }

            setBalance(getBalance() + amount);
            System.out.printf("На ваш баланс успешно положены средства в размере %.2f, ваш баланс %.2f\n", amount, getBalance());
        } catch (IllegalArgumentException e) {
            System.out.printf("Попытка внести депозит с отрицательной суммой: %s \n", e.getMessage());
        }
    }

    public void withdrawMoney(double amount) {
        try {
            if (getBalance() < amount) {
                throw new InsufficientFundsException(amount);
            }

            setBalance(getBalance() - amount);
            System.out.printf("С вашего баланса успешно сняты средства в размере %.2f, ваш баланс %.2f\n", amount, getBalance());
        } catch (InsufficientFundsException e) {
            System.out.printf("Попытка снятия со счёта суммы больше допустимой: %s\n", e.getMessage());
        }
    }
}