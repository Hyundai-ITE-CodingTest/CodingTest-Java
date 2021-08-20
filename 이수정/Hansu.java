import java.util.Scanner;

public class Hansu {
    public static void main(String[] args) {
        //등차수열 : 일정 값 더해짐
        //1보다 크거나 같고 N보다 작거나 같고
        //입력 값(N)의 각 자리가 등차수열? => 한수 ex> 123, 135, 147
        //N까지의 자연수 중에 한수가 있는지?
        //입력 : 110, 1자리 2자리는 무조건 포함 1~ 99
        //3자리 수(1000보다 작은수 까지 입력들어옴) 100 111 123.. 각 자리수의 차가 동일한지?
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int count = 0;
        for(int i = 1; i<= N; i++){
            if(i <= 99)
                count++;
            else {
                int first = (i%100) % 10;
                int second = (i%100) / 10;
                int third = i/100;
                if(second - first == third - second){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}

