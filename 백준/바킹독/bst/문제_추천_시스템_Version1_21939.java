package ps.백준.바킹독.bst;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class 문제_추천_시스템_Version1_21939 {

    public static int n, m;
    public static int[] arr;
    public static TreeMap<Integer, TreeSet<Integer>> difficulties;
    public static TreeMap<Integer,Integer> noes;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static long answer = 1;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        difficulties = new TreeMap<>();
        noes = new TreeMap<>();

        int no;
        int difficulty;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            no = Integer.parseInt(st.nextToken());
            difficulty = Integer.parseInt(st.nextToken());

            add(no, difficulty);
        }

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (order.equals("add")) {
                no = Integer.parseInt(st.nextToken());
                difficulty = Integer.parseInt(st.nextToken());
                add(no, difficulty);
            } else if (order.equals("solved")) {
                no = Integer.parseInt(st.nextToken());
                difficulty= noes.get(no);
                noes.remove(no);
                TreeSet<Integer> noesOfSameDiff = difficulties.get(difficulty);
                noesOfSameDiff.remove(no);
                if (noesOfSameDiff.isEmpty()) {
                    difficulties.remove(difficulty);
                }
            }else{
                if (st.nextToken().equals("1")) {
                    TreeSet<Integer> hardestNoes = difficulties.lastEntry().getValue();
                    bw.write("" + hardestNoes.last()+"\n");
                    bw.flush();
                }
                else{
                    TreeSet<Integer> hardestNoes = difficulties.firstEntry().getValue();
                    bw.write("" + hardestNoes.first()+"\n");
                    bw.flush();
                }
            }
        }
        bw.flush();
        bw.close();

    }
    public static void add(int no,int diff) {
        TreeSet<Integer> noesOfSameDiff = difficulties.getOrDefault(diff, new TreeSet<>());
        noesOfSameDiff.add(no);
        difficulties.put(diff, noesOfSameDiff);
        noes.put(no, diff);
    }
}
