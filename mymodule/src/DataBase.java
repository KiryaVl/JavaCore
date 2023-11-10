import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;

/**
 * Класс, представляющий базу данных сотрудников.
 */

public class DataBase implements Iterable<Personal> {
    private List<Personal> personals = new ArrayList<>();

    /**
     * Добавляет сотрудника в базу данных.
     *
     * @param personal Сотрудник для добавления.
     */

    public void addPersonal(Personal personal) {
        personals.add(personal);
    }

    /**
     * Возвращает итератор для базы данных сотрудников.
     *
     * @return Итератор для базы данных сотрудников.
     */
    @Override
    public Iterator<Personal> iterator() {
        return personals.iterator();
    }

    /**
     * Сортирует сотрудников по месячной зарплате.
     */
    public void sortBySalary() {
        Collections.sort(personals);
    }

    /**
     * Сортирует сотрудников по имени и фамилии.
     */
    public void sortByNameAndSoname() {
        Collections.sort(personals, new PersonalComparator());
    }
}
