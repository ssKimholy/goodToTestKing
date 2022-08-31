package BruteForce;

public class BitUnder2 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            // 1. 짝수일때 홀수일때 나누기 (짝수일때는 마지막비트가 무조건 0이므로 +1만 하면 된다.)
            // 2. 홀수인데 모든 비트가 1인경우와 아닌경우로 나누기 (모두가 1인 경우 맨앞비트를 제외하고 그 바로 뒤에 0을 붙인다.)
            long number = numbers[i];
            if (number % 2 == 0) answer[i] = number+1;
            else {
                String binary = Long.toBinaryString(number);
                int zeroIdx = binary.lastIndexOf("0");
                if (zeroIdx == -1) {
                    binary = "10" + binary.substring(1, binary.length());
                } else {
                    binary = binary.substring(0, zeroIdx) + "10" + binary.substring(zeroIdx+2, binary.length());
                }
                answer[i] = Long.parseLong(binary, 2);
            }
        }

        return answer;
    }
}
