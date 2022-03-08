package programmers;

import java.util.*;

public class BestAlbums {

    public static class MySourceCode{

        class Album implements Comparable<Album>{
            private int index;
            private int plays;

            public Album(int index, int plays) {
                this.index = index;
                this.plays = plays;
            }

            public int getIndex() {
                return index;
            }

            @Override
            public int compareTo(Album a) {
                if(this.plays > a.plays) return -1;
                else if (this.plays == a.plays) return this.index - a.index;
                else return 1;
            }
        }

        class Genre implements Comparable<Genre>{
            private String name;
            private int play;

            public Genre(String name, int play) {
                this.name = name;
                this.play = play;
            }

            public String getName() {
                return name;
            }

            public void addPlay(int play){
                this.play += play;
            }

            @Override
            public int compareTo(Genre o) {
                return o.play - this.play;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Genre genre = (Genre) o;
                return Objects.equals(name, genre.name);
            }

            @Override
            public int hashCode() {
                return Objects.hash(name);
            }
        }

        public Integer[] solution(String[] genres, int[] plays) {
            Map<String, PriorityQueue<Album>> genresToAlbums = new HashMap<>();
            List<Genre> genreList = new ArrayList<>();

            for(int i = 0; i < genres.length; i++){
                String genre = genres[i];
                int play = plays[i];
                //현재 장르가 이미 존재한다면
                if(genresToAlbums.containsKey(genre)){
                   genresToAlbums.get(genre).offer(new Album(i, play));
                }//존재하지 않는다면 새로 삽입
                else {
                    PriorityQueue<Album> pq = new PriorityQueue<>();
                    pq.offer(new Album(i, play));
                    genresToAlbums.put(genre, pq);
                }

                //리스트에 삽입
                if(genreList.contains(new Genre(genre, play))){
                    genreList.get(genreList.indexOf(new Genre(genre, play))).addPlay(play);
                } else {
                    genreList.add(new Genre(genre, play));
                }
            }
            //재생된 수가 많은 순서대로 장르 정렬
            Collections.sort(genreList);

            List<Integer> ans = new ArrayList<>();
            for(int i = 0; i < genreList.size(); i++){
                //현재 장르
                Genre genre = genreList.get(i);
                //맵에서 장르에 속한 앨범을 꺼낸다
                PriorityQueue<Album> albums = genresToAlbums.get(genre.getName());
                int cnt = 0;
                while(cnt++ < 2 && !albums.isEmpty()){
                    Album album = albums.poll();
                    ans.add(album.getIndex());
                }
            }

            return ans.toArray(new Integer[ans.size()]);
        }
    }
}
