/*
Program Name: Sorter.java
Author: Cameron Ayers
Date: 10/24/2025
Input: A LinkedList of Contact objects that need to be sorted.
Output: A sorted LinkedList of Contact objects (sorted in place).
Description:
This class provides sorting functionality for a LinkedList of Contact objects.
It uses the merge sort algorithm to order contacts alphabetically by last name,
and then by first name if last names are identical. The sort is performed using
LinkedList operations for compatibility with the rest of the program.
*/
import java.util.LinkedList;

public class Sorter {



    /*
    Sorts a LinkedList of Contact objects in ascending order by last name and first name.

    Signature: public static void sort(LinkedList<Contact> list)
    Parameters:
        - list (LinkedList<Contact>): The list of contacts to be sorted.
    Return Type: void
    Precondition: The provided list must not be null. The Contact objects within the list
                  must have non-null first and last names for proper comparison.
    Postcondition: The provided list is sorted alphabetically by last name, then by first name.
    */
    public static void sort(LinkedList<Contact> list) {
        if (list.size() <= 1) return;
        LinkedList<Contact> sorted = mergeSort(list);
        list.clear();
        list.addAll(sorted);
    }

    /*
    Recursively divides and sorts a LinkedList of Contact objects using the merge sort algorithm.

    Signature: private static LinkedList<Contact> mergeSort(LinkedList<Contact> list)
    Parameters:
        - list (LinkedList<Contact>): The list of contacts to be sorted.
    Return Type: LinkedList<Contact> – A new sorted LinkedList of Contact objects.
    Precondition: The provided list must not be null. Each Contact must contain valid name data.
    Postcondition: Returns a new sorted LinkedList of contacts without modifying the original list.
    */
    private static LinkedList<Contact> mergeSort(LinkedList<Contact> list) {
        if (list.size() <= 1) return list;

        int mid = list.size() / 2;
        LinkedList<Contact> left = new LinkedList<>(list.subList(0, mid));
        LinkedList<Contact> right = new LinkedList<>(list.subList(mid, list.size()));

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }


    /*
    Merges two sorted LinkedLists of Contact objects into a single sorted LinkedList.

    Signature: private static LinkedList<Contact> merge(LinkedList<Contact> left, LinkedList<Contact> right)
    Parameters:
        - left (LinkedList<Contact>): A sorted list of contacts.
        - right (LinkedList<Contact>): Another sorted list of contacts.
    Return Type: LinkedList<Contact> – A new LinkedList containing all contacts from both lists, sorted.
    Precondition: Both input lists must already be sorted by last name, then by first name.
    Postcondition: A new merged and sorted LinkedList is returned containing all contacts
                   from both input lists in sorted order.
    */
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
