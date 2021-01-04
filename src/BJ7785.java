import java.util.*;
import java.io.*;
import java.lang.*;

public class BJ7785 {
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Set<String> set = new TreeSet<>();
        while(n > 0) {
            stk = new StringTokenizer(br.readLine());
            String name = stk.nextToken();
            String commute = stk.nextToken();

            if(commute.equals("enter")) {
                set.add(name);
            } else if(commute.equals("leave")) {
                set.remove(name);
            }

            n--;

        }

        for(Iterator<String> itr = ((TreeSet<String>) set).descendingIterator(); itr.hasNext() ;) {
            sb.append(itr.next()).append("\n");
        }

        System.out.println(sb.toString());
    }

}