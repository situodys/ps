package ps.백준.바킹독.시뮬레이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트럭_13335 {

    //10"09~
    public static char[][] board;
    public static int[][] visited;
    public static int[] dy = {-1, 0, 1, 0};
    public static int[] dx = {0, 1, 0, -1};
    public static int n,w,l;
    public static int curLoadWeight=0;
    public static Queue<Car> load = new LinkedList<>();
    public static Queue<Integer> cars = new LinkedList<>();
    public static int answer=0;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n;i++){
            cars.add(Integer.parseInt(st.nextToken()));
        }

        while(!cars.isEmpty() || !load.isEmpty()){
            answer++;
            if (!load.isEmpty()) {
                for (Car car : load) {
                    car.move();
                }
                check();
            }
            if(load.size()==w) continue;
            if(cars.isEmpty())continue;
            if(curLoadWeight+cars.peek()>l) continue;
            int weight = cars.poll();
            load.offer(new Car(weight, 0, load));
            curLoadWeight+=weight;
        }

        System.out.println(answer);
    }

    public static void check() {
        Car head = load.peek();
        if (head.order == w) {
            load.poll();
            curLoadWeight -= head.weight;
        }
    }

    public static class Car{
        private int weight;
        private int order;
        private Queue<Car> load;

        public Car(int weight, int order, Queue<Car> load) {
            this.weight = weight;
            this.order = order;
            this.load = load;
        }

        public void move() {
            this.order++;
        }
    }
}
