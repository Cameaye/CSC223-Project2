import java.util.LinkedList;

public class Sorter {

    public static void sort(LinkedList<contact> list) {
        if (list.size() <= 1) return;
        LinkedList<contact> sorted = mergeSort(list);
        list.clear();
        list.addAll(sorted);
    }

    private static LinkedList<contact> mergeSort(LinkedList<contact> list) {
        if (list.size() <= 1) return list;

        int mid = list.size() / 2;
        LinkedList<contact> left = new LinkedList<>(list.subList(0, mid));
        LinkedList<contact> right = new LinkedList<>(list.subList(mid, list.size()));

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private static LinkedList<contact> merge(LinkedList<contact> left, LinkedList<contact> right) {
        LinkedList<contact> result = new LinkedList<>();

        while (!left.isEmpty() && !right.isEmpty()) {
            contact l = left.peek();
            contact r = right.peek();

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
