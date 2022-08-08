package usingMapSet;

import java.util.*;

public class RankingSearch {
    HashMap<String, Integer> map = new HashMap<>();
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public int[] solution(String[] infos, String[] querys) {
        int[] answer = new int[querys.length];

        for (int i = 0; i < 108; i++) {
            list.add(new ArrayList<>());
        }

        map.put("-", 0);
        map.put("java", 1);
        map.put("cpp", 2);
        map.put("python", 3);
        map.put("frontend", 1);
        map.put("backend", 2);
        map.put("junior", 1);
        map.put("senior", 2);
        map.put("pizza", 1);
        map.put("chicken", 2);

        for (String info : infos) {
            String[] str = info.split(" ");
            int score = Integer.parseInt(str[4]);

            for (int i = 0; i < (1<<4); i++) {
                // 16가지 경우의 수 비트마스킹
                int num = 0;
                for (int j = 0; j < 4; j++) {
                    if ((i & (1<<j)) != 0) {
                        num += (int) Math.pow(3, 3-j) * map.get(str[j]);
                    }
                }
                list.get(num).add(score);
            }
        }

        for (int i = 0; i < 108; i++) {
            Collections.sort(list.get(i));
        }

        int idx = 0;
        for (String query : querys) {
            String[] str = query.split(" ");
            int num = 0;
            int sq = 3;
            int score = Integer.parseInt(str[7]);

            for (int j = 0; j < str.length; j++) {
                if (j % 2 == 0) {
                    // 규칙에 따라 인덱스 찾기
                    num += (int) Math.pow(3, sq--) * map.get(str[j]);
                }
            }

            int tmp = search(score, list.get(num)); // 이분탐색으로 탐색시간 줄이기

            answer[idx] = list.get(num).size() - tmp;
            idx++;
        }
        return answer;
    }

    int search(int target, ArrayList<Integer> list) {
        int left = 0;
        int right = list.size()-1;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;

            if (list.get(mid) >= target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return left;
    }
}