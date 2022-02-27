package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Camera {

    class Car {

        private final int enterTime;
        private final int exitTime;

        public Car(int enterTime, int exitTime) {
            this.enterTime = enterTime;
            this.exitTime = exitTime;
        }

        public int getEnterTime() {
            return enterTime;
        }

        public int getExitTime() {
            return exitTime;
        }
    }

    public int mySourceCode(int[][] routes) {

        List<Car> routeList = new ArrayList<>();
        for(int[] route : routes){
            routeList.add(new Car(route[0], route[1]));
        }

        Collections.sort(routeList, (o1, o2) -> {
            if(o1.enterTime < o2.enterTime) return -1;
            else return 1;
        });

        int cctv = 1;
        int maxEnterTime = Integer.MIN_VALUE;
        int minExitTime = Integer.MAX_VALUE;

        for (Car car : routeList) {
            maxEnterTime = Math.max(maxEnterTime, car.getEnterTime());
            minExitTime = Math.min(minExitTime, car.getExitTime());

            if(maxEnterTime > minExitTime){
                maxEnterTime = car.getEnterTime();
                minExitTime = car.getExitTime();
                cctv++;
            }
        }

        return cctv;
    }
}
