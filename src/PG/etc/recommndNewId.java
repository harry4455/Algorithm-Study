/*
 * # 신규 아이디 추천
 *
 * 2021 카카오 블라인드 채용 기출
 * 
 * 조건대로 풀어도 문제는 없지만, 정규식을 활용해서 풀어야 원하는 채점기준을 받을 수 있을듯
 * -> 정규식 활용해서 다시 풀이하기
 */

package PG.etc;

public class recommndNewId {

    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        System.out.println(solution(new_id));
    }

    public static String solution(String new_id) {
        String answer = "";

        // 1. 대문자 -> 소문자 치환
        // 2. 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표 제외 제거
        // 3. 마침표(.) 두번 이상 연속 된 부분은 하나로 치환
        // 4. 마침표가 처음이나 끝에 있으면 제거
        // 5. 빈 문자열이면, "a"를 대입
        // 6. 16자리 이상이면 첫 15 문자를 제외한 나머지 문자 제거
        // 제거 후 마침표가 끝에 위치한다면 끝에 위치한 마침표 문자를 제거
        // 7. 2자 이하라면 마지막 문자를 길이가 3이 될때까지 반복해서 끝에 붙임

        String trans_id = new_id.toLowerCase();
        StringBuilder sb = new StringBuilder();

        for(char c : trans_id.toCharArray()) {
            if((c >= 97 && c <= 122) || (c >= '0' && c <= '9') ||c == '-' || c == '_' || c == '.' ) {
                sb.append(c);
            }
        }

        String trans_id2 = sb.toString().replace("..",".");
        while(trans_id2.contains("..")) {
            trans_id2 = trans_id2.replace("..",".");
        }

        if(trans_id2.length() > 0) {
            if(trans_id2.charAt(0) == '.') {
                trans_id2 = trans_id2.substring(1, trans_id2.length());
            }
        }

        if(trans_id2.length() > 0){
            if(trans_id2.charAt(trans_id2.length() - 1) == '.') {
                trans_id2 = trans_id2.substring(0, trans_id2.length() - 1);
            }
        }

        if(trans_id2.equals("")) {
            trans_id2 = "a";
        }

        if(trans_id2.length() >= 16) {
            trans_id2 = trans_id2.substring(0, 15);

            if(trans_id2.charAt(trans_id2.length() - 1) == '.') {
                trans_id2 = trans_id2.substring(0, trans_id2.length() - 1);
            }
        }

        StringBuilder trans_id3 = new StringBuilder(trans_id2);
        if(trans_id3.length() <= 2) {
            char last = trans_id3.charAt(trans_id3.length() - 1);

            while(trans_id3.length() < 3) {
                trans_id3.append(last);
            }
        }

        answer = String.valueOf(trans_id3);
        return answer;
    }
}
