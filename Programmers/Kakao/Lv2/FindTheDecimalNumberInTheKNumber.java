package Lv2;

import java.util.Scanner;

public class FindTheDecimalNumberInTheKNumber {
    public static String k_number(int n, int k){
        String stringN = Integer.toString(n);
        StringBuilder sb = new StringBuilder();
        if(k == 10){
            return stringN;
        }
        while(n > 0){
            if(n % k < 10){
                sb.append(n % k);
            } else {
                sb.append((char)(n%k - 10 + 'A'));
            }
            n /= k;
        }
        return sb.reverse().toString();
    }

    public static int solution(int n, int k){
        int answer = -1;
        return answer;
    }
    public static void main(String[] args){
        int main_n;
        int main_k;
        int res;
        Scanner sc = new Scanner(System.in);
        main_n = sc.nextInt();
        main_k = sc.nextInt();
        res = solution(main_n, main_k);

        String res1 = k_number(main_n, main_k);
        System.out.println(res);
        System.out.println(res1);
    }
}
