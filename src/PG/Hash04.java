package PG;// 해시 문제 #4
// https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%B2%A0%EC%8A%A4%ED%8A%B8%EC%95%A8%EB%B2%94-Java
// https://medium.com/@nsh235482/java-coding-programmers-hash-lv3-%EB%B2%A0%EC%8A%A4%ED%8A%B8-%EC%95%A8%EB%B2%94-278fa3ad4d9c

import java.util.*;

public class Hash04 {

    // Song이라는 객체 생성, 이를 기반으로 비교하기 때문에 comparator 연산자 활용
    class Song implements Comparable<Song> {
        int id, play;
        String genre;

        Song(int id, int play, String genre) {
            this.id = id;
            this.play = play;
            this.genre = genre;
        }

        @Override
        public int compareTo(Song o) {
            if (this.play == o.play) {
                return this.id - o.id;
            } else {
                return -(this.play - o.play);
            }
        }
    }

    ArrayList<Integer> bestAlbum;
    ArrayList<Song> songList;
    HashMap<String, Integer> genreMap;
    HashMap<String, Integer> albumMap;

    public int[] solution(String[] genres, int[] plays) {
        bestAlbum = new ArrayList<>();
        songList = new ArrayList<>();
        genreMap = new HashMap<>();
        albumMap = new HashMap<>();

        // 장르별로 플레이 수 합치는 과정, genreMap이라는 새로운 HashMap에 장르-플레이 총합 수로 정리
        for (int i = 0; i < genres.length; ++i) {
            int id = i;
            int play = plays[i];
            String genre = genres[i];

            songList.add(new Song(id, play, genre));

            if (genreMap.containsKey(genre)) {
                genreMap.put(genre, genreMap.get(genre) + play);
            } else {
                genreMap.put(genre, play);
            }
        }

        // songlist에 같은 인자 있는지, 크기를 비교하는 등 정렬하는 과정
        Collections.sort(songList, new Comparator<Song>() {
            @Override
            public int compare(Song s1, Song s2) {
                if (s1.genre.equals(s2.genre)) {
                    return s1.compareTo(s2);
                } else {
                    return -(genreMap.get(s1.genre) - genreMap.get(s2.genre));
                }
            }
        });

        // 위에서 장르별 높은 순별로 정렬 해놓았으니, 이제는 그 중 최고의 2개를 뽑는 과정
        for (Song song : songList) {
            if (!albumMap.containsKey(song.genre)) {
                albumMap.put(song.genre, 1);
                bestAlbum.add(song.id);
            } else {
                int genreCnt = albumMap.get(song.genre);

                if (genreCnt >= 2) continue;
                else {
                    albumMap.put(song.genre, genreCnt + 1);
                    bestAlbum.add(song.id);
                }
            }
        }

        int[] answer = new int[bestAlbum.size()];
        for (int i = 0; i < answer.length; ++i) {
            answer[i] = bestAlbum.get(i);
        }

        return answer;
    }

}
