import java.util.LinkedList;

public class Sorter {

    public static void sort(LinkedList<Contact> list) {
        if (list.size() <= 1) return;
        LinkedList<Contact> sorted = mergeSort(list);
        list.clear();
        list.addAll(sorted);
    }

    private static LinkedList<Contact> mergeSort(LinkedList<Contact> list) {
        if (list.size() <= 1) return list;

        int mid = list.size() / 2;
        LinkedList<Contact> left = new LinkedList<>(list.subList(0, mid));
        LinkedList<Contact> right = new LinkedList<>(list.subList(mid, list.size()));

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private static LinkedList<Contact> merge(LinkedList<Contact> left, LinkedList<Contact> right) {
        LinkedList<Contact> result = new LinkedList<>();

        while (!left.isEmpty() && !right.isEmpty()) {
            Contact l = left.peek();
            Contact r = right.peek();

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
