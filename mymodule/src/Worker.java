/**
 * Класс, представляющий работника с фиксированной ежемесячной оплатой.
 */
public class Worker extends Personal{
    public Worker(String name, String soname, int age, boolean fixedSolary) {
        super(name, soname, age, fixedSolary);
    }

    /**
     * Получает месячную зарплату работника.
     *
     * @return Месячная зарплата работника.
     */

    @Override
    public double monthSolary() {
        return getMonthSolary();
    }
}
