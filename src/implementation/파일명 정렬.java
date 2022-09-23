package implementation;

import java.util.*;

public class FileNameSort {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        File[] file = new File[files.length];

        for (int i = 0; i < files.length; i++) {
            String head = ""; String num = ""; String tail = "";
            for (int j = 0; j < files[i].length(); j++) {
                char c = files[i].charAt(j);

                if (Character.isDigit(c)) {
                    // 숫자는 두 가지로 나뉜다. num에 들어가는 숫자, tail에 들어가는 숫자.
                    if (tail.equals("")) {
                        // tail이 비어있다면 num에 들어가는 숫자.
                        num += c;
                    } else {
                        // 아니라면 tail에 들어가는 숫자.
                        tail += c;
                    }
                } else {
                    // 숫자가 아닌 경우에는 head에 들어가는 문자, tail에 들어가는 문자로 나뉜다.
                    if (num.equals("")) {
                        head += c;
                    } else {
                        tail += c;
                    }
                }
            }
            file[i] = new File(head, num, tail);
        }

        Arrays.sort(file);

        for (int i = 0; i < file.length; i++) {
            answer[i] = file[i].toString();
        }
        return answer;
    }
}

class File implements Comparable<File> {
    String head;
    String num;
    String tail;

    public File(String head, String num, String tail) {
        this.head = head;
        this.num = num;
        this.tail = tail;
    }

    @Override
    public String toString() {
        return this.getHead() + this.getNum() + this.getTail();
    }

    @Override
    public int compareTo(File f) {
        // 대소문자 상관없이 사전순
        String s1 = this.head.toLowerCase();
        String s2 = f.head.toLowerCase();

        if (s1.equals(s2)) {
            // head가 같다면 num 비교
            return Integer.parseInt(this.num) - Integer.parseInt(f.num);
        } else {
            return s1.compareTo(s2);
        }
    }

    private String getHead() {
        return this.head;
    }

    private String getNum() {
        return this.num;
    }

    private String getTail() {
        return this.tail;
    }
}
