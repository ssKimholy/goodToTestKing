import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static LinkedList<Integer> number = new LinkedList<>(); // put number express here.
    static LinkedList<Character> operator = new LinkedList<>(); // put operator express here.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        String num = "";
        int answer = 0;

        for (int i = 0; i < expression.length(); i++) {
            char ex = expression.charAt(i);

            if (Character.isDigit(ex)) {
                num += ex;
            } else {
                number.add(Integer.parseInt(num));
                operator.add(ex);
                num = "";
            }
        }
        number.add(Integer.parseInt(num)); // for last number express.

        while (operator.contains('+')) { // until operator list doesn't has any + operation. (Greedy Algorithm.)
            int idx = operator.indexOf('+');
            operator.remove(idx);
            int a = number.remove(idx+1);
            int b = number.remove(idx);
            int sum = a + b;
            number.add(idx, sum);
        }

        answer = number.removeFirst();
        for (int n : number) {
            answer -= n; // and subtract all number express.
        }

        System.out.println(answer);
    }
}
