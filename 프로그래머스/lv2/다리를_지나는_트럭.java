package ps.프로그래머스.lv2;
import java.util.*;

public class 다리를_지나는_트럭 {
    // 12:42~13:40
    //

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int idx=0;

        Bridge bridge = new Bridge(weight,bridge_length);
        Car car;

        while(idx != truck_weights.length){
            car = new Car(truck_weights[idx],answer);
            bridge.update(answer);

            if(bridge.canAddNextCar(car)){
                bridge.addCar(car);
                idx++;
            }
            answer++;
        }

        while(!bridge.cars.isEmpty()){
            bridge.update(answer);
            answer++;
        }

        return answer;
    }

    public class Bridge{
        int curWeight;
        int maxWeight;
        int length;
        Queue<Car> cars;

        public Bridge(int maxWeight, int length){
            cars = new LinkedList<>();
            this.maxWeight= maxWeight;
            this.length = length;
            this.curWeight=0;
        }

        public boolean canAddNextCar(Car nextCar){
            if(curWeight+nextCar.weight>maxWeight){
                return false;
            }
            return true;
        }

        public void addCar(Car car){
            cars.offer(car);
            this.curWeight += car.weight;
        }

        public void update(int time){
            if(cars.isEmpty()) return;
            Car firstCar = cars.peek();
            if(time - firstCar.location == length){
                this.curWeight-=cars.poll().weight;
            }
        }
    }

    public class Car {
        int location;
        int weight;

        public Car(int weight, int location){
            this.location = location ;
            this.weight = weight ;
        }
    }
}
