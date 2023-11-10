/**
 * Класс, представляющий фрилансера с переменной оплатой за час.
 */
public class Freelancer extends Personal {
    private double hourPay;

    public Freelancer(String name, String soname, int age, boolean fixedSolary, double hourPay) {
        super(name, soname, age, fixedSolary);
        this.hourPay = hourPay;
    }

    @Override
    public double getMonthSolary() {
        return monthSolary();
    }

    /**
     * Получает месячную зарплату фрилансера на основе оплаты за час.
     *
     * @return Месячная зарплата фрилансера.
     */
    @Override
    public double monthSolary() {
        return setMonthSolary(20.8 * 8 * getHourPay());
    }

    /**
     * Получает ставку оплаты за час фрилансера.
     *
     * @return Оплата за час работы.
     */
    public double getHourPay() {
        return hourPay;
    }

    /**
     * Устанавливает ставку оплаты за час фрилансера.
     *
     * @param hourPay Новая ставка оплаты за час.
     */

    public void setHourPay(double hourPay) {
        this.hourPay = hourPay;
    }
}
