class Solution {
    public int[] solution(String[][] places) {
        int[] answer = {};
        answer = new int[5];
        for(int i = 0; i< 5; i++){
            answer[i] = search(places[i]);
        }
        return answer;
    }
    public static char[][] temp(String[] place){
        char[][] temp = new char[5][5];
        //대기실별 배열을 확인해서 결과 값에 저장하기
        for (int i = 0; i < place.length; i++) {
            String str = place[i];
            for (int j = 0; j < 5; j++) {
                // 대기실 배열 생성후 자리 위치 넣어주기
                temp[i][j] = str.charAt(j);
            }
        }
        return temp;
    }
    public static int search(String[] place){
        char[][] ch = temp(place);
        int count = 0;
        //거리두기 지키지 않은 경우
        //P가 있는 부분만 확인하기
        //위 아래, 오른쪽 왼쪽 1칸 주변으로 P가 있는 경우
        //위 아래, 오른쪽 왼쪽 1칸 주변으로 O가 있으면서 다음칸과 대각선에 P가 있는 경우
        for(int row =0 ; row< 5; row++){
            for(int col = 0; col<5; col++){
                
                if(ch[row][col] == 'P'){
                    //0행일 때 위로 못올라감
                    if(row != 0){
                        if(ch[row-1][col] == 'P'){
                            count++;
                        }if(row >1 && ch[row-1][col] == 'O' && ch[row-2][col] =='P'){
                                count++;
                            }
                        if(0<col&& col<4){
                            if(ch[row-1][col] == 'O' 
                               && (ch[row-1][col+1] =='P'||ch[row-1][col-1] =='P')){
                                count++;
                            }
                        }
                    }
                    //마지막 행일 때 아래로 못내려감
                    if(row != 4){
                        if(ch[row+1][col] == 'P'){
                            count++;
                        }if(row < 3 && ch[row+2][col] == 'O' && ch[row+2][col] =='P'){
                            count++;
                        }if(0<col&& col<4){
                            if(ch[row+1][col] == 'O' 
                               && (ch[row+1][col-1] =='P'||ch[row+1][col+1] =='P')){
                                count++;
                            }
                        }

                    }
                    //0열일 때 왼쪽을 못감
                    if(col != 0){
                        if(ch[row][col-1] == 'P'){
                            count++;
                        }if(col >1 && ch[row][col-1] == 'O' && ch[row][col-2] =='P'){
                            count++;
                        }
                    }
                    //마지막 열일 때 오늘쪽으로 못감
                    if(col != 4){
                        if(ch[row][col+1] == 'P'){
                            count++;
                        }if(col <3 && ch[row][col+1] == 'O' && ch[row][col+2] =='P'){
                            count++;
                        }
                    }
                }
            }
        }
        if(count !=0){
            return 0;
        }else return 1;
    }
}
