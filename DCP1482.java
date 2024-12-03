/*
  Write a program that checks whether an integer is a palindrome.
  For example, 121 is a palindrome, as well as 888. 678 is not a palindrome.
  Do not convert the integer into a string.
*/

//2 147 483 647;
import java.util.Arrays;

public class DCP1482 {
    public static void main(final String[] args) {
        /*
        v0(888);
        v0(121);
        v0(272);
        v0(678);
        */

        assert v1(888);
        assert v1(121);
        assert v1(272);
        assert v1(678) == false;
        assert v1(-121) == false;
    }

    private static boolean v1(final int num) {
        final int size = (int) Math.floor(Math.log10(Math.abs(num))) + 1;
        if(size < 2)
            return true;

        final int[] digits = new int[size];
        int lastIndex = size - 1;

        parseDigits(num, digits, lastIndex);

        int endOfBegin = size / 2;
        if (size > 3) {
            boolean isOdd = (size % 3) == 0;
            endOfBegin = size / 2;
            if(isOdd)
                endOfBegin = endOfBegin - 1;
        }

        boolean isPalindrome = true;
        for(int begin = 0; begin < endOfBegin && isPalindrome; begin++) {
            isPalindrome = digits[begin] == digits[lastIndex--];
        }

        System.out.println(num);
        System.out.println(Arrays.toString(digits));
        System.out.println(isPalindrome);
        return isPalindrome;
    }

    private static void parseDigits(int num, int[] digits, int lastIndex) {
        final int head = num / 10;
        final int lastDigit =  num % 10;
        digits[lastIndex] = lastDigit;
        lastIndex = lastIndex - 1;
        if(lastIndex > 0) {
            parseDigits(head, digits, lastIndex);
        } else {
            digits[lastIndex] = head;
        }
    }

    private static void v0(final int num) {
        int unit = ((num % 100) % 10);
        int cent = (num / 100);

        System.out.print(num);
        System.out.print(" is");
        if( unit != cent ) {
            System.out.print(" not");
        }
        System.out.println(" a palindrome.");
    }
}
