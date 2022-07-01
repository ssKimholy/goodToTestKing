package BruteForce;

class Carfet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int len = (int) Math.sqrt(yellow); // 세로 길이의 최대값은 rootY이다. (가로 세로가 같아질 때가 최대)
        int r;

        for (int c = 1; c <= len; c++) { // 가로를 증가시켜도 된다. (다만 세로가 가로보다 작거나 같아야 하기 때문에 세로를 기준으로 돌렸다.)
            if (yellow % c != 0) continue; // yellow의 크기를 맞추고
            r = yellow / c;
            // yellow의 크기를 맞췄다면 그 가로,세로 길이로 brown의 크기도 맞출 수 있는지 확인.
            if ((r+c)*2 + 4 == brown) {
                answer[0] = r+2;
                answer[1] = c+2;
                return answer;
                // 맞다면 리턴.
            }
        }
        return answer;
    }
}
