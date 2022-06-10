package Lv2;

import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

public class FindTheDecimalNumberInTheKNumber {
    public boolean is_prime(long n){
        if( n <= 1 ) return false;
        else if( n == 2 ) return true;
        else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public String k_number(int n, int k){
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

    public int solution(int n, int k){
        int answer = 0;
        String k_num = k_number(n, k);
        String[] moNum = k_num.split("0");
        Long caseNum;
        for(int i = 0; i < moNum.length; i++){
            if(moNum[i] == "") continue;
            caseNum = Long.parseLong(moNum[i]);
            if(is_prime(caseNum)) {
                answer++;
                System.out.println(caseNum);
            }
        }
        System.out.println(Arrays.toString(moNum));
        return answer;
    }
    public static void main(String[] args){
        int main_n;
        int main_k;
        FindTheDecimalNumberInTheKNumber isSolution = new FindTheDecimalNumberInTheKNumber();
        Scanner sc = new Scanner(System.in);
        main_n = sc.nextInt();
        main_k = sc.nextInt();
        int res = isSolution.solution(main_n, main_k);
        System.out.println(res);

    }
}
