/*
    #1517 버블 소트

    문제이름이 버블소트라고 그렇게 풀다간 큰 코 다침.
    왜냐면 n의 범위가 50만 까지 있기 떄문.

    따라서 merge sort를 활용하여 풀이하기.

 */
package BJ;

import java.util.Scanner;

public class BJ1517 {
    static int n;
    static long[] arr;
    static long[] arrcopy;
    static long cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new long[n];
        arrcopy = new long[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        cnt = 0;
        Merge(0, n-1);

        System.out.println(cnt);

    }

    private static void Merge(int left, int right) {
        if(left != right) {
            int mid = (left + right) / 2;
            Merge(left, mid);
            Merge(mid+1, right);
            MergeSort(left, right);
        }
    }

    private static void MergeSort(int left, int right) {
        int mid = (left + right) / 2;
        int i = left;
        int j = mid+1;
        int k = left;

        // 합치기
        while(i <= mid && j <= right) {
            // i가 mid로 오고, j가 맨끝으로 가면 반복문을 멈춤
            if(arr[i] > arr[j]) {
                // 왼쪽에 있는 배열이 더 크면 더 작은 오른쪽에 있는 배열을 arrcopy에 담는다.
                arrcopy[k++] = arr[j++];
                cnt += mid - i + 1;
            } else {
                // 반대의 경우
                arrcopy[k++] = arr[i++];
            }
        }

        if(i > mid) { // 오른쪽에 배열이 남은 경우
            while(j <= right) {
                arrcopy[k++] = arr[j++];
            }
        } else {    // 왼쪽에 배열이 남은 경우
            while(i <= mid) {
                arrcopy[k++] = arr[i++];
            }
        }

        // arrcopy에 담아놓은 배열을 arr 배열에 다시 담는다.
        for(int h = left; h <= right; h++) {
            arr[h] = arrcopy[h];
        }
    }
}
