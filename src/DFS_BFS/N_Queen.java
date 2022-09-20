class Solution {
    int answer = 0;
    Queen[] queen;

    
    public int solution(int n) {
        queen = new Queen[n];
        for (int i = 0; i < n; i++) {
            queen[i] = new Queen(i, i);
            // 퀸 초기화 각 퀸은 x좌표가 일정하다. 그러니까 이제 y좌표에 따라 성공 실패가 나뉜다.
        }
        
        dfs(0, n);
        
        return answer;
    }
    
    public void dfs(int dep, int n) {
        
        if (dep == n) {
            // 성공인 경우
            answer++;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            queen[dep].y = i;
            if (check(dep)) {
                dfs(dep+1, n); 
            }
        }
    }
    
    public boolean check(int idx) {
        for (int i = 0; i < idx; i++) {
            // 이태까지 전 퀸들의 y좌표가 겹치지 않는지, 대각선 방향에 있지 않은지 검사한다.
            if (queen[idx].y == queen[i].y) return false;
            if (Math.abs(queen[idx].y - queen[i].y) == Math.abs(queen[idx].x - queen[i].x)) return false;
        }
        
        return true;
    }
  
}

class Queen {
    int x;
    int y;
    
    public Queen (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

