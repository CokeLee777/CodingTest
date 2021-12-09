package programmers;

import java.util.*;

class Room implements Comparable<Room>{

    private long index;
    private boolean empty;

    public Room(long index, boolean empty) {
        this.index = index;
        this.empty = empty;
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    @Override
    public int compareTo(Room room) {
        //방이 빈 방 우선으로 정렬
        if(this.empty) {
            if(this.index < room.index) return -1;
            else return 1;
        } else {
            if(this.index < room.index) return -1;
            else return 1;
        }
    }
}

public class SetHotelRoom {

    public static Map<Long, Boolean> room = new HashMap<>();

    public static long findEmptyRoom(long want){
        long result = 0L;
        for (Long key : room.keySet()) {
            if(key > want && !room.get(key)){
                result = key;
                room.put(key,true);
                break;
            }
        }

        return result;
    }

    //k: 호텔 방의 개수(1번부터 k까지), room_number: 원하는 방 번호
    public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for(long i = 1; i <= k; i++){
            room.put(i, false);
        }

        int index = 0;
        for (long rn : room_number) {
            //원하는 방이 비었다면
            if(!room.get(rn)) {
                room.put(rn, true);
                answer[index] = rn;
                index++;
            }
            //원하는 방이 비어있지 않다면
            else {
                long emptyRoom = findEmptyRoom(rn);
                answer[index] = emptyRoom;
                index++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        long[] room_number = {1,3,4,1,3,1};
        long[] answer = solution(10, room_number);

        for (long a : answer) {
            System.out.print(a + " ");
        }
    }
}
