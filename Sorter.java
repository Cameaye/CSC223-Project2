import java.util.LinkedList;

public class Sorter {

    public static void sort(LinkedList<Person> list) {
        if (list.size() <= 1) return;
        LinkedList<Person> sorted = mergeSort(list);
        list.clear();
        list.addAll(sorted);
    }

    private static LinkedList<Person> mergeSort(LinkedList<Person> list) {
        if (list.size() <= 1) return list;

        int mid = list.size() / 2;
        LinkedList<Person> left = new LinkedList<>(list.subList(0, mid));
        LinkedList<Person> right = new LinkedList<>(list.subList(mid, list.size()));

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private static LinkedList<Person> merge(LinkedList<Person> left, LinkedList<Person> right) {
        LinkedList<Person> result = new LinkedList<>();

        while (!left.isEmpty() && !right.isEmpty()) {
            Person l = left.peek();
            Person r = right.peek();

            int cmp = l.getLastName().compareToIgnoreCase(r.getLastName());
            if (cmp == 0) {
                cmp = l.getFirstName().compareToIgnoreCase(r.getFirstName());
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
