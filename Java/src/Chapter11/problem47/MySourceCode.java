package Chapter11.problem47;

import java.util.*;

class Fish{

    private int index;
    private int direction;

    public Fish(int index, int direction) {
        this.index = index;
        this.direction = direction;
    }

    public int getIndex() {
        return index;
    }

    public int getDirection() {
        return direction;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

}

public class MySourceCode {

    public static ArrayList<ArrayList<Fish>> graph = new ArrayList<>();
    //방향 제자리,북,북서,서,남서,남,남동,동,동북
    public static int[] dx = {0,-1,-1,0,1,1,1,0,-1};
    public static int[] dy = {0,0,-1,-1,-1,0,1,1,1};

    public static final int INF = (int)1e9;

    //45도 회전하는 함수
    public static int turnLeft(int direction){
        if(direction + 1 > 8) return 1;
        else return direction + 1;
    }

    //특정 번호의 물고기 위치 찾기
    public static int[] findFish(int index){
        int[] result = new int[2];

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(graph.get(i).get(j).getIndex() == index){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        //특정 번호의 물고기가 없다면 null 반환
        return null;
    }

    //물고기가 이동하는 함수
    public static void moveFish(int nowX, int nowY){
        //1번부터 16번까지 물고기에 대해 이동 수행
        for(int i = 1; i < 17; i++){
            int[] fish = findFish(i);
            //찾는 물고기가 없다면 무시
            if(fish == null) continue;
            //찾는 물고기가 있다면
            else {
                int x = fish[0];
                int y = fish[1];
                int index = graph.get(x).get(y).getIndex();
                int direction = graph.get(x).get(y).getDirection();
                //해당 물고기의 방향을 45도 돌리면서 이동가능 여부 확인
                for(int j = 0; j < 8; j++){
                    int nx = x + dx[direction];
                    int ny = y + dy[direction];
                    //벽이 아니고
                    if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4){
                        //현재 상어의 위치가 아니라면 이동
                        if(nx != nowX && ny != nowY){
                            int moveIndex = graph.get(nx).get(ny).getIndex();
                            graph.get(x).get(y).setIndex(moveIndex);
                            graph.get(nx).get(ny).setIndex(index);
                            break;
                        }
                    }
                    //이동할 수 없다면 45도 회전
                    direction = turnLeft(direction);
                }
            }
        }
    }

    //상어가 현재 위치에서 먹을 수 있는 모든 물고기의 위치 반환하는 함수
    public static void getPossiblePositions(int nowX, int nowY){

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //그래프 초기화
        for(int i = 0; i < 4; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                //물고기의 번호와 방향 입력받기
                int a = sc.nextInt();
                int b = sc.nextInt();

                if(i == 0 && j == 0){
                    graph.get(i).get(j).setIndex(INF);
                    graph.get(i).get(j).setDirection(b);
                } else{
                    graph.get(i).get(j).setIndex(a);
                    graph.get(i).get(j).setDirection(b);
                }
            }
        }


    }
}
