import java.util.Comparator;

/**
 * Компаратор для сравнения объектов Personal по имени и фамилии.
 */
public class PersonalComparator implements Comparator<Personal> {

    /**
     * Сравнивает два объекта Personal по имени и фамилии.
     *
     * @param p1 Первый объект Personal.
     * @param p2 Второй объект Personal.
     * @return Значение 0, если имена и фамилии равны; значение больше 0, если
     * текущий объект больше, и значение меньше 0 в противном случае.
     */
    @Override
    public int compare(Personal p1, Personal p2) {
        int nameComparison = p1.getName().compareTo(p2.getName());
        if (nameComparison != 0) {
            return nameComparison;
        }
        return p1.getSoname().compareTo(p2.getSoname());
    }
}
