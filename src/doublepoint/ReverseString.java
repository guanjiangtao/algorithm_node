package doublepoint;

public class ReverseString {

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length /2 ; i++) {
            char a = s[i];
            s[i] = s[s.length - 1 -i];
            s[s.length - 1 -i] = a;
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString(new char[]{'h','e','l','l','o'});
    }
}
