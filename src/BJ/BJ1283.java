package BJ;// 아직 풀이중

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1283 {

    static boolean[] charArr = new boolean[128];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        String[] strOut = new String[N];

        // 단어 입력
        for(int i=0; i<N; i++) {
            str[i] = br.readLine();
        }

        // 단어마다 검증 test
        for(int j=0; j<N; j++) {

            // 단어마다 글자별로 test
            for(int k=0; k < str[j].length(); k++) {
                char word = str[j].charAt(k);
                int wordNum = word;
                System.out.println("==============");
                System.out.println("word : " + word);
                System.out.println("wordNum : " + wordNum);
                System.out.println("k : " + k);

                if(!charArr[wordNum]) {
                    if(wordNum > 64 && wordNum <= 90) { // 대문자 처리
                        charArr[wordNum] = true;
                        charArr[wordNum + 32] = true;

                        strOut[j] = str[j].substring(0,k) + "[" + str[j].charAt(k) + "]" + str[j].substring(k+1);
                        System.out.println(strOut[j]);
                        break;
                    } else if(wordNum > 96 && wordNum <= 122) { // 소문자 처리

                        //System.out.println(charArr[wordNum-32]);

                        if(charArr[wordNum - 32]) { // 대문자 방문 경력 있다면
                            System.out.println("HEY");
                            charArr[wordNum] = true;
                            // charArr[wordNum - 32] = true;

                            strOut[j] = str[j].substring(0,k) + "[" + str[j].charAt(k) + "]" + str[j].substring(k+1);
                            System.out.println(strOut[j]);
                            break;
                        } else if(!charArr[wordNum - 32]) { // 대문자 방문 경력이 없다면
                            System.out.println("HEY2");
//                            charArr[wordNum] = true;
//                            charArr[wordNum - 32] = true;
//
                            strOut[j] = str[j].substring(0,k) + "[" + str[j].charAt(k) + "]" + str[j].substring(k+1);
                            System.out.println(strOut[j]);
//                            break;
                            continue;
                        }

//                        int wordNum2 = word - 32;
//                        char word2 = (char) wordNum2;

                        //System.out.println(word2);

//                        if(str[j].contains(word2)) {
//                            System.out.println("HI");
//                        }


                    }
                }
            }
        }

        System.out.println(Arrays.toString(strOut));



    }
}
