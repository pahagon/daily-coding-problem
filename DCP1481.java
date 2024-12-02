/*
  Given a string and a set of delimiters,
  reverse the words in the string while maintaining the relative order of the delimiters.
  For example, given "hello/world:here", return "here/world:hello"
  Follow-up: Does your solution work for the following cases:
  "hello/world:here/", "hello//world:here"
*/

import java.util.List;
import java.util.LinkedList;

public class DCP1481 {
    private final char[] alphabet;
    private final char[] delimiters;

    public static void main(String[] args) {
        char[] alphabet = "abcdefghijklmnopqrstuvxz".toCharArray();
        char[] delimiters = { '/', ':' };
        final DCP1481 instance = new DCP1481(alphabet, delimiters);

        final String case1 = "hello/world:here/";
        final String reversed = instance.v0(case1);

        System.out.print(case1);
        System.out.print(" = ");
        System.out.println(reversed);

        final String case2 = "hello//world:here";
        final String reversed2 = instance.v0(case2);

        System.out.print(case2);
        System.out.print(" = ");
        System.out.println(reversed2);

    }

    public DCP1481(final char[] alphabet, final char[] delimiters) {
        this.alphabet = alphabet;
        this.delimiters = delimiters;
    }

    public String v0(final String str) {
        final List<String> tokens = new LinkedList<String>();
        Integer i = 0;

        while(i < str.length()) {
            final StringBuilder s = new StringBuilder();
            i = scanToken(str, i, s);
            tokens.add(s.toString());
        }

        final StringBuilder result = new StringBuilder();
        for(int j = tokens.size() - 1; j >= 0; j--)
            result.append(tokens.get(j));

        return result.toString();
    }

    private Integer scanToken(final String text, Integer index, final StringBuilder token) {
        while(index < text.length()){
            char c = text.charAt(index++);
            if(isDelimiter(c)){
                if (token.length() > 0) {
                    return --index;
                } else {
                    token.append(c);
                    return index;
                }
            } else {
                token.append(c);
            }
        }
        return index;
    }

    private boolean isDelimiter(char c) {
        return c == '/' || c == ':';
    }
}
