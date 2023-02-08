package ps.백준.바킹독.시뮬레이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 드래곤_커브_15685 {
    //2:59~
    public static int k, x, y, d, g,answer;
    public static boolean[][] vertexes = new boolean[101][101];
    public static int[] dy = {0, -1, 0, 1};
    public static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());

            curve(x, y, d, g);
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (vertexes[i][j] && vertexes[i][j + 1] && vertexes[i + 1][j] && vertexes[i + 1][j + 1]) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    public static void curve(int x, int y, int d, int g) {
        List<Integer> dirs = new ArrayList<>();
        vertexes[y][x]=true;
        dirs.add(d);

        for (int i = 0; i < g; i++) {
            for (int j = dirs.size()-1; j >=0; j--) {
                dirs.add((dirs.get(j) + 1) % 4);
            }
        }

        for (Integer dir : dirs) {
            y += dy[dir];
            x += dx[dir];
            vertexes[y][x] =true;
        }
    }
}
