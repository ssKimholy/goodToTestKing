package implementation;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int num = 0;
        int zeroNum = 0;

        while (!s.equals("1")) {
            int pre = s.length();
            s = s.replace("0", "");

            int post = s.length();
            zeroNum += pre - post;

            s = Integer.toBinaryString(post);
            num++;
        }

        answer[0] = num;
        answer[1] = zeroNum;

        return answer;
    }
}
