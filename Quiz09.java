package Quiz03;
//계단산 문제
public class Quiz09 {
    public static void main(String[] args) {
        /* () 는 계단 1칸 - > 높이 단위 1
        * # 는 급경사
        * # 나오고 다시 #이 나오기전까지 경사 유지
        * 칼로리 소모 일반 계단에서 1, 경사에서는 2배
        * ((#(())#(())))
        * 1 + 2 + 6 + 8 + 8 + 6 + 3 + 4 + 4 + 3 + 2 + 1 = 48 소모*/
       /*
        * 처음 나오는 #후 다음 나오는 #의 위치 길이를 구해서 (이 나오는 위치 구하기 3,4
        * => 몇칸이 급경사인지 구한다
        * 열리는 괄호 닫히는 괄호 구분해서 층수를 구한다
        * (((())))  <= 경사 부분을 제외한 문자열로 총 높이 => 4
        * */
        //1단계 : 문자열 입력하기
        String stair = "((#(())#(())))";
        //2단계: 첫번쨰 # 위치 구하기
        String shap = "";
        for(int i = 0; i< stair.length(); i++){
                    if(stair.charAt(i) == '#') {
                        shap += i;
            }
        }
        //3단계 : #사이 문자열
        int shap_toInt = Integer.parseInt(shap);
        String center ="";
        center = stair.substring((shap_toInt/10)+1 ,(shap_toInt%10));

        //4단계: 총 높이 구하기
        int height = 0;
        for(int i = 0; i< stair.length(); i++){
            if(stair.charAt(i) == '('){
                height++;
            }
            if(stair.charAt(i) == ')'){
                break;
            }
        }
        // 총 높이가 4층일 때, 2개의 층수가 경사니까 마지막 배열의 2자리가 큰값
        int[] result = new int[height];
        for(int i =0; i <height; i++){
            result[i] = i+1; //1,2,3,4
        }
        int sum = 0;
        for(int i =0; i <height; i++){
            sum += result[i];
        }
        sum += result[height-1] *2 + result[height-2]*2;
        System.out.println(sum*2);

    }
}
