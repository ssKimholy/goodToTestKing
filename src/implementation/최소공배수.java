package implementation;

import java.util.*;

public class LCM {
    public int solution(int[] arr) {

        return getLcm(arr);
    }

    public int getLcm(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }

        int gcd = getGcd(arr[0], arr[1]);
        int lcm = (arr[0] * arr[1]) / gcd;

        for (int i = 2; i < arr.length; i++) {
            gcd = getGcd(lcm, arr[i]);
            lcm = (lcm*arr[i]) / gcd;
        }

        return lcm;
    }

    public int getGcd(int a, int b) {
        if (a%b == 0) {
            return b;
        }
        return getGcd(b, a%b);
    }
}
