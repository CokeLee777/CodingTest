package com.company;

import java.util.*;

class Music implements Comparable<Music>{

    private int number;
    private int plays;

    public Music(int number, int plays){
        this.number = number;
        this.plays = plays;
    }

    public int getNumber(){
        return this.number;
    }

    public int getPlays(){
        return this.plays;
    }

    @Override
    public int compareTo(Music music) {
        if(this.plays > music.plays) return -1;
        else if (this.plays == music.plays){
            if(this.number < music.number) return -1;
            else return 1;
        }
        else return 1;
    }
}

public class Main {

    public static Map<String, List<Music>> musics = new HashMap<>();
    public static List<String> sortedList = new ArrayList<>();

    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        Set<String> genre = new HashSet<>(Arrays.asList(genres));

        for(int i = 0; i < plays.length; i++){
            List<Music> music = new ArrayList<>();
            if(musics.get(genres[i]) == null){
                music.add(new Music(i, plays[i]));
                musics.put(genres[i], music);
            } else {
                musics.get(genres[i]).add(new Music(i, plays[i]));
            }
        }

        for (String g : genre) {
            Collections.sort(musics.get(g));
        }

        int maxPlay = 0;
        String maxGenre = "";

        for (String g : genre) {
            Music music = musics.get(g).get(musics.size() - 1);
            if(music.getPlays() > maxPlay) maxGenre = g;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        solution(genres, plays);
    }
}
