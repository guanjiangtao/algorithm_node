package doublepoint;

import java.util.Arrays;

public class ReverseWords {

    public static String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            char[] c =  str[i].toCharArray();
            for (int j = 0; j < c.length /2 ; j++) {
                char a = c[j];
                c[j] = c[c.length - 1 -j];
                c[c.length - 1 -j] = a;
            }
            stringBuffer.append(String.valueOf(c)).append(" ");
        }

        return stringBuffer.deleteCharAt(stringBuffer.length() - 1).toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));;
    }

}
