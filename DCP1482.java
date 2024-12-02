/*
  Write a program that checks whether an integer is a palindrome.
  For example, 121 is a palindrome, as well as 888. 678 is not a palindrome.
  Do not convert the integer into a string.
*/

public class DCP1482 {
    public static void main(final String[] args) {
        v0(888);
        v0(121);
        v0(272);
        v0(678);
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
