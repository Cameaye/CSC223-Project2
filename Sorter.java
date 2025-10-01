import java.util.LinkedList;

public class Sorter {

    // Public method to call merge sort on LinkedList
    public static void sortByFirstName(LinkedList<Person> list) {
        if (list.size() <= 1) return;
        LinkedList<Person> sorted = mergeSort(list, true);
        list.clear();
        list.addAll(sorted);
    }

    public static void sortByLastName(LinkedList<Person> list) {
        if (list.size() <= 1) return;
        LinkedList<Person> sorted = mergeSort(list, false);
        list.clear();
        list.addAll(sorted);
    }

    // Merge Sort core
    private static LinkedList<Person> mergeSort(LinkedList<Person> list, boolean sortByFirst) {
        if (list.size() <= 1) return list;

        int mid = list.size() / 2;
        LinkedList<Person> left = new LinkedList<>(list.subList(0, mid));
        LinkedList<Person> right = new LinkedList<>(list.subList(mid, list.size()));

        left = mergeSort(left, sortByFirst);
        right = mergeSort(right, sortByFirst);

        return merge(left, right, sortByFirst);
    }

    // Merge step
    private static LinkedList<Person> merge(LinkedList<Person> left, LinkedList<Person> right, boolean sortByFirst) {
        LinkedList<Person> result = new LinkedList<>();

        while (!left.isEmpty() && !right.isEmpty()) {
            Person l = left.peek();
            Person r = right.peek();

            int cmp;
            if (sortByFirst) {
                cmp = l.getFirstName().compareToIgnoreCase(r.getFirstName());
            } else {
                cmp = l.getLastName().compareToIgnoreCase(r.getLastName());
            }

            if (cmp <= 0) {
                result.add(left.poll());
            } else {
                result.add(right.poll());
            }
        }

        result.addAll(left);
        result.addAll(right);
        return result;
    }
}
