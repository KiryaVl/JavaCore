/**
 * Абстрактный класс, представляющий базовый тип сотрудника.
 */
abstract class Personal implements Comparable<Personal> {
    private String name, soname;
    private int age;
    private boolean fixedSolary;
    private double monthSolary;

    public Personal(String name, String soname, int age, boolean fixedSolary) {
        this.name = name;
        this.soname = soname;
        this.age = age;
        this.fixedSolary = fixedSolary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSoname() {
        return soname;
    }

    public void setSoname(String soname) {
        this.soname = soname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getFixedSolary() {
        return fixedSolary;
    }

    public void setFixedSolary(boolean fixedSolary) {
        this.fixedSolary = fixedSolary;
    }

    public boolean isFixedSolary() {
        return fixedSolary;
    }

    public double getMonthSolary() {
        return monthSolary;
    }

    public double setMonthSolary(double monthSolary) {
        return this.monthSolary = monthSolary;
    }

    abstract public double monthSolary();

    /**
     * Сравнивает текущий объект с другим объектом Personal по месячной зарплате.
     *
     * @param other Другой объект Personal для сравнения.
     * @return Значение 0, если зарплаты равны; значение больше 0, если текущая
     * зарплата больше, и значение меньше 0 в противном случае.
     */

    @Override
    public int compareTo(Personal other) {
        return Double.compare(this.getMonthSolary(), other.getMonthSolary());
    }

}
