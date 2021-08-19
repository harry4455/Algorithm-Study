/*
 * # 오픈채팅방
 * 2019 KAKAO BLIND RECRUITMENT
 *
 */

package PG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class OpenChatting {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        solution(record);
    }

    public static String[] solution(String[] record) {
        ArrayList<String> logs = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();

        int len = record.length;

        for(int i=0; i<len; i++) {
            String[] line = record[i].split(" ");
            String command = line[0];
            String uid = line[1];

            if(line.length == 3) {  // enter, change
                String nickname = line[2];
                map.put(uid, nickname);
                if(command.equals("Enter")) {
                    logs.add(uid + "님이 들어왔습니다.");
                }
            } else {
                logs.add(uid + "님이 나갔습니다.");
            }
        }

        String[] answer = new String[logs.size()];
        int logIdx = 0;

        for(String word : logs) {
            int idIdxEnd = word.indexOf("님");
            String userId = word.substring(0, idIdxEnd);

            answer[logIdx++] = word.replaceAll(userId, map.get(userId));
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }
}
