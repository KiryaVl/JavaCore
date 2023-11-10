public class Main {
    public static void main(String[] args) {
        /**
         * Создание БД сотрудников и самих сотрудников.
         */
        DataBase dataBase = new DataBase();
        Freelancer freelancer1 = new Freelancer("Nikolay", "Pupkin", 25, false, 250);
        Freelancer freelancer2 = new Freelancer("Sergey", "Vupkin", 26, false, 240);
        Freelancer freelancer3 = new Freelancer("Nikolay", "Shybkin", 33, false, 450);
        Worker worker1 = new Worker("Alice",  "Selezneva", 18, true);
        Worker worker2 = new Worker("Anastasia",  "Kisegach", 44, true);
        Worker worker3 = new Worker("Leonid",  "Slytskiy", 53, true);
        Worker worker4 = new Worker("Anatoly",  "Medvedev", 51, true);

        /**
         * Установка оплаты сотрудников с фиксированной ЗП.
         */
        worker1.setMonthSolary(23000);
        worker2.setMonthSolary(24000);
        worker3.setMonthSolary(28000);
        worker4.setMonthSolary(42000);

        /**
         * Добавление работников в БД.
         */
        dataBase.addPersonal(freelancer1);
        dataBase.addPersonal(freelancer2);
        dataBase.addPersonal(freelancer3);
        dataBase.addPersonal(worker1);
        dataBase.addPersonal(worker2);
        dataBase.addPersonal(worker3);
        dataBase.addPersonal(worker4);

        /**
         * Перебор сотрудников из БД
         */

        for (Personal p: dataBase){
            System.out.println(p.getMonthSolary());
        }

        /**
         * Перебор сотрудников из БД и применении сортировки по ЗП
         */
        dataBase.sortBySalary();
        System.out.println("Sorted by Salary:");
        for (Personal p : dataBase) {
            System.out.println(p.getMonthSolary());
        }

        /**
         * Перебор сотрудников из БД и применении сортировки по имени
         */
        dataBase.sortByNameAndSoname();
        System.out.println("Sorted by Name and Soname:");
        for (Personal p : dataBase) {
            System.out.println(p.getName() + " " + p.getSoname());
        }
    }
}