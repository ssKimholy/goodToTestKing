package BruteForce;

class VowelDic {
    char[] words = {'A', 'E', 'I', 'O', 'U'};
    int[] ex = {781, 156, 31, 6, 1}; // 각 자리수가 변할 때 드는 시간들
    public int solution(String word) {
        int answer = word.length(); // 우선 현재 word의 길이까지 오는데 드는 시간을 더해주고

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int wornum = 0;
            for (int j = 0; j < words.length; j++) {
                if (words[j] == c) {
                    // 각 자리수가 변할 때 드는 길이에 word사이의 길이를 곱하여 답을 얻는다.
                    wornum = j;
                    break;
                }
            }

            answer += ex[i] * wornum;
        }

        return answer;
    }
}
