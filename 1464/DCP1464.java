/*
  Daily Coding Problem: Problem #1464 [Medium]
  Good morning! Here's your coding interview problem for today.
  This problem was asked by Facebook.

  Given an array of integers in which two elements appear exactly
  once and all other elements appear exactly twice, find the two
  elements that appear only once.

  For example, given the array [2, 4, 6, 8, 10, 2, 6, 10], return 4 and 8. The order does not matter.
  Follow-up: Can you do this in linear time and constant space?
*/
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;

class DCP1464 {
    public static void main(final String [] args) {
        final Integer[] array = {2, 4, 6, 8, 10, 2, 6, 10};

        final List<Integer> result = v0(array, 1);
        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }
    }

    private static List<Integer> v0(Integer[] array, Integer occurrence) {
        final HashMap<Integer,Integer> counter = new HashMap<>();
        final HashMap<Integer,LinkedList<Integer>> result = new HashMap<>();

        for(int i = 0; i < array.length; i++) {
            int num = array[i];
            int c = counter.getOrDefault(num, 0);

            LinkedList previousCounterList = result.get(c);
            if(previousCounterList == null) {
                previousCounterList = new LinkedList<>();
                result.put(c, previousCounterList);
            }

            final ListIterator<Integer> previousCounterIt = previousCounterList.listIterator(0);
            while (previousCounterIt.hasNext()) {
                final Integer n = previousCounterIt.next();
                if(n == num) {
                    previousCounterIt.remove();
                    break;
                }
            }

            counter.put(array[i], c = c + 1);

            LinkedList<Integer> nextList = result.get(c);
            if(nextList == null){
                nextList = new LinkedList<>();
                result.put(c, nextList);
            }
            nextList.add(num);
        }

        //System.out.println(counter);
        //System.out.println(result);
        return result.get(occurrence);
    }
}
