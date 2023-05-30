package ps.백준.바킹독.시뮬레이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 이차원_배열과_연산_17140 {
    public static int r, c, k;
    public static int dy[] = {0, 0, -1, 1, 1, 1, -1, -1};
    public static int dx[] = {1, -1, 0, 0, 1, -1, 1, -1};
    public static int dz[] = {0, 0, 0, 0, 1, -1};
    public static long answer = 0;
    public static List<List<Integer>> boardByRow;
    public static List<List<Integer>> boardByCol;
    public static char[] tmp;
    public static int MAX_VAlUE = 10000;
    public static StringBuilder sb = new StringBuilder();

    //18:51~
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());

        boardByRow = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            boardByRow.add(new ArrayList<>());
        }

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                boardByRow.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }
        solution();
    }

    private static void solution() {
        int time = 0;
        if (boardByRow.size() > r && boardByRow.get(0).size() > c &&boardByRow.get(r).get(c) == k) {
            System.out.println(0);
            return;
        }
        while (true) {
            time++;
            if (time > 100) {
                time = -1;
                break;
            }
            if (boardByRow.size() >= boardByRow.get(0).size()) {
                colToRow();
                executeR();
                if (boardByCol.size() <= c || boardByCol.get(0).size() <= r) {
                    continue;
                }
                if (boardByCol.get(c).get(r) == k) {
                    break;
                }
            } else {
                rowToCol();
                executeC();
                if (boardByRow.size() <= r || boardByRow.get(0).size() <= c) {
                    continue;
                }
                if (boardByRow.get(r).get(c) == k) {
                    break;
                }
            }
        }
        System.out.println(time);
    }

    private static void executeR() {
        int maxRowSize = 0;

        for (int i = 0; i < boardByRow.size(); i++) {
            List<Integer> row = boardByRow.get(i);
            Map<Integer, Node> mp = new HashMap<>();
            for (Integer key : row) {
                if (key == 0) {
                    continue;
                }
                Node node = mp.getOrDefault(key, new Node(key, 0));
                node.count++;
                mp.put(key, node);
            }
            List<Node> nodes = mp.values().stream().sorted().collect(Collectors.toList());
            row.clear();

            for (int j = 0; j < nodes.size(); j++) {
                if (j == 51) {
                    break;
                }
                Node node = nodes.get(j);
                row.add(node.key);
                row.add(node.count);
            }
            maxRowSize = Math.max(maxRowSize, row.size());
        }
        for (List<Integer> row : boardByRow) {
            while (row.size() != maxRowSize) {
                row.add(0);
            }
        }
        rowToCol();
    }

    private static void rowToCol() {
        if(boardByRow==null) return;
        boardByCol = new ArrayList<>();
        for (int i = 0; i < boardByRow.get(0).size(); i++) {
            boardByCol.add(new ArrayList<>());
        }

        for (int i = 0; i < boardByRow.get(0).size(); i++) {
            for (int j = 0; j < boardByRow.size(); j++) {
                boardByCol.get(i).add(boardByRow.get(j).get(i));
            }
        }
    }

    private static void executeC() {
        int maxColSize = 0;

        for (int i = 0; i < boardByCol.size(); i++) {
            List<Integer> row = boardByCol.get(i);
            Map<Integer, Node> mp = new HashMap<>();
            for (Integer key : row) {
                if (key == 0) {
                    continue;
                }
                Node node = mp.getOrDefault(key, new Node(key, 0));
                node.count++;
                mp.put(key, node);
            }
            List<Node> nodes = mp.values().stream().sorted().collect(Collectors.toList());
            row.clear();

            for (int j = 0; j < nodes.size(); j++) {
                if (j == 51) {
                    break;
                }
                Node node = nodes.get(j);
                row.add(node.key);
                row.add(node.count);
            }
            maxColSize = Math.max(maxColSize, row.size());
        }
        for (List<Integer> row : boardByCol) {
            while (row.size() != maxColSize) {
                row.add(0);
            }
        }
        colToRow();
    }

    private static void colToRow() {
        if(boardByCol==null) return;
        boardByRow = new ArrayList<>();
        for (int i = 0; i < boardByCol.get(0).size(); i++) {
            boardByRow.add(new ArrayList<>());
        }

        for (int i = 0; i < boardByCol.get(0).size(); i++) {
            for (int j = 0; j < boardByCol.size(); j++) {
                boardByRow.get(i).add(boardByCol.get(j).get(i));
            }
        }
    }

    static class Node implements Comparable<Node> {
        int key;
        int count;

        public Node(int key, int count) {
            this.key = key;
            this.count = count;
        }

        public int compareTo(Node node) {
            if (this.count == node.count) {
                return this.key - node.key;
            }
            return this.count - node.count;
        }
    }
}
