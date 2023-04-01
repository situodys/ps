package ps.백준.바킹독.그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 거짓말_1043 {

    public static int n, m, knownCnt;
    public static List<List<Integer>> people;
    public static List<List<Integer>> party;
    public static List<Integer> knownPeople;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static boolean visited[];
    private static long answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        people = new ArrayList<>();
        party = new ArrayList<>();
        visited = new boolean[n + 1];
        knownPeople = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            people.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            party.add(new ArrayList<Integer>());
        }

        st = new StringTokenizer(br.readLine());
        knownCnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < knownCnt; i++) {
            knownPeople.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int peopleInParty = Integer.parseInt(st.nextToken());
            for (int j = 0; j < peopleInParty; j++) {
                party.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        for (List<Integer> l : party) {
            for (int i = 0; i < l.size()-1; i++) {
                Integer person = l.get(i);
                for (int j = i+1; j < l.size(); j++) {
                    people.get(person).add(l.get(j));
                    people.get(l.get(j)).add(person);
                }
            }
        }

        List<List<Integer>> distinctPeople = new ArrayList<>();
        for (int i = 0; i < people.size(); i++) {
            List<Integer> cur = people.get(i);
            distinctPeople.add(cur.stream().distinct().collect(Collectors.toList()));
        }

        for (int i = 0; i < knownCnt; i++) {
            int start = knownPeople.get(i);
            if(visited[start]) continue;
            Queue<Integer> q = new LinkedList<>();
            q.offer(start);
            visited[start] = true;

            while(!q.isEmpty()){
                int cur = q.poll();
                for (Integer nxt : distinctPeople.get(cur)) {
                    if(visited[nxt]) continue;
                    q.offer(nxt);
                    visited[nxt]=true;
                }
            }
        }

        for (List<Integer> people : party) {
            boolean canLie =true;
            for (Integer person : people) {
                if (visited[person]) {
                    canLie=false;
                    break;
                }
            }
            if(canLie) answer++;
        }
        System.out.println(answer);
    }
}
