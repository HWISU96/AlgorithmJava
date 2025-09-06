import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5_2744_대소문자바꾸기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder(str);

        for (int i=0; i<str.length(); i++) {
            if (Character.isUpperCase(sb.charAt(i))) {
                char tmp = Character.toLowerCase((sb.charAt(i)));
                sb.setCharAt(i, tmp);
            } else {
                char tmp = Character.toUpperCase((sb.charAt(i)));
                sb.setCharAt(i, tmp);
            }
        }

        System.out.println(sb);
    }
}