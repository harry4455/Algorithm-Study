/*
 * # 캐시 (2018 카카오 기출)
 *
 * LinkedList 활용법 숙지 더 필요.
 */
package PG.Level2;

import java.util.LinkedList;

public class cache {
    static final int CACHE_HIT = 1;
    static final int CACHE_MISS = 5;

    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        solution(cacheSize, cities);
    }

    public static int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return cities.length * 5;

        int answer = 0;

        LinkedList<String> cache = new LinkedList<>();

        for(int i=0; i<cities.length; ++i) {
            String city = cities[i].toUpperCase();

            // cache hit
            if(cache.remove(city)) {
                cache.addFirst(city);
                answer += CACHE_HIT;
            } else {    // CACHE_MISS
                int currentSize = cache.size();

                if(currentSize == cacheSize) {
                    cache.pollLast();
                }

                cache.addFirst(city);
                answer += CACHE_MISS;
            }
        }

        return answer;
    }
}
