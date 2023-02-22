package ps.백준.바킹독.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 머지소트 {

    public static int n;
    public static int[] arr, tmp;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr= new int[n];
        tmp= new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0,n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <n; i++) {
            sb.append(arr[i]);
            sb.append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void mergeSort(int start, int end) {
        if(end==start+1) return;
        int mid = (start+end)/2;
        mergeSort(start,mid);
        mergeSort(mid,end);
        merge(start,end);
    }

    private static void merge(int start, int end) {
        int mid = (start+end)/2;
        int leftIdx=start;
        int rightIdx=mid;

        for(int i=start; i<end; i++){
            if (rightIdx == end) {
                tmp[i] = arr[leftIdx++];
            } else if (leftIdx == mid) {
                tmp[i] = arr[rightIdx++];
            } else if (arr[leftIdx] < arr[rightIdx]) {
                tmp[i] = arr[leftIdx++];
            }
            else tmp[i] = arr[rightIdx++];
        }
        for (int i = start; i < end; i++) {
            arr[i]=tmp[i];
        }
    }
}
