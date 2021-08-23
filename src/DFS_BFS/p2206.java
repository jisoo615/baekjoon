package DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p2206 {
	static int N;
    static int M;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1][2];

        for (int i = 1; i <= N; i++) {
            str = br.readLine().split("");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(str[j-1]);
            }
        }
        
        bfs(1, 1);

	}
    
    public static void bfs(int x, int y) {
    	Queue<Point> que = new LinkedList<>();
    	que.offer(new Point(x, y, 0, 1));
    	visited[x][y][0] = true;
    	visited[x][y][1] = true;
    	
    	while(!que.isEmpty()) {
    		Point p = que.poll();
    		
    		if (p.x == N && p.y == M) {//N,M �����ϸ� ����
                System.out.println(p.cnt);
                return;
            }
    		
    		for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int breakWall = p.breakWall;
                int cnt = p.cnt;
                
                if (nx <= 0 || ny <= 0 || nx > N || ny > M) continue;
                
                if(map[nx][ny]==1) {//���϶�
                	if(breakWall==0 && !visited[nx][ny][1]) {//���μ�������
                		visited[nx][ny][1] = true;
                		que.offer(new Point(nx, ny, 1, cnt+1));
                	}
                }else {//��ĭ�϶�
                	if( !visited[nx][ny][breakWall] ) {//���� ��尡 ���� �ν����� �Ⱥν������� ���� �湮 Ȯ����
                		visited[nx][ny][breakWall] = true;
                		que.offer(new Point(nx, ny, breakWall, cnt+1));
                	}
                }
               
    		}
    		
    	}//while
    	System.out.print(-1);
    }
    
    static class Point{
    	int x; int y;
    	int breakWall;
    	int cnt;
    	
    	public Point(int x, int y, int breakWall, int cnt) {
    		this.x = x;	//���� x = this.x �� �ƴ�::
    		this.y = y;
    		this.breakWall = breakWall;
    		this.cnt = cnt;
    	}
    	
    }

}
