package dynamic_1_re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14002 {
    static int A[], dp[], v[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 1;
        A = new int[n];
        dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();


        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;// 기본 길이는 1
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {// 다음꺼가 더 클때만
                    dp[i] = Math.max(dp[j] + 1, dp[i]);//0부터 i까지의 최대 길이, 전에 구한 젤 긴거에+1
                }
            }
        }
        max = Arrays.stream(dp).max().getAsInt();
        System.out.println(max);

        for (int i = n-1; i >=0; i--) {
            if(dp[i] == max){
                sb.insert(0, A[i]+" ");
                max-=1;
            }
        }

        System.out.println(sb.toString());
    }
}
