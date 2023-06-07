package ps.백준.바킹독.시뮬레이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 프린터_큐_1966 {
    public static int[] dy = new int[]{0, 0, -1, 1};
    public static int[] dx = new int[]{ -1, 1,0, 0};
    public static int n,m,t;
    public static int[][] board;
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());

        while(t-->0){
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            TreeSet<Main.Node> ts = new TreeSet<Main.Node>();
            PriorityQueue<Integer> orders = new PriorityQueue<>(Comparator.reverseOrder());
            Queue<Main.Node> printQ = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n;i++){
                int order = Integer.parseInt(st.nextToken());
                printQ.offer(new Main.Node(i, order));
                orders.offer(order);
//                ts.add(new Node(i, Integer.parseInt(st.nextToken())));
            }
            int time=1;
            while (!printQ.isEmpty()) {
                Main.Node cur = printQ.poll();
                if (cur.order < orders.peek()) {
                    printQ.offer(cur);
                    continue;
                }
                if (cur.key == m) {
                    System.out.println(time);
                    break;
                }
                orders.poll();
                time++;
            }
        }
    }
    static class Node {
        int key;
        int order;
        public Node(int key, int order){
            this.key=key;
            this.order=order;
        }
    }
}
