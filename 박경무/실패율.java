import java.util.*;

class Point{
    double val;
    int index;
    Point(double val, int index){
        this.val = val;
        this.index = index;
    }
}

class Solution {

    static ArrayList<Point> list = new ArrayList<>();
    static int[] solve;
    public int[] solution(int N, int[] stages) {
        solve = new int[N];
        HashMap<Integer,Integer> map = new HashMap<>(); 
        
        //map 입력 -> 몇번 스테이지에 몇명의 회원이 있는지
        //solve 입력 -> 총 스테이지에 몇명의 회원이 통과했는지
        for(int i=0; i<stages.length; i++){
            if(map.get(stages[i]-1)==null){
                map.put(stages[i]-1,1);
            }else{
                map.put(stages[i]-1,1+map.get(stages[i]-1));
            }
            // for(int j=0; j<stages[i];j++){
            //     solve[j]++;
            // }
        }
        double[] answer = new double[N];
        double nowUser = stages.length;
        double totalUser = stages.length;
        
        
        for(int i=0; i<N; i++){
            if(map.get(i)==null){
                if(nowUser==0){
                   list.add(new Point(0,i));
                }else{
                   list.add(new Point(0,i));
                }                
            }else{
                double lock = map.get(i);
                if(nowUser==0){
                   list.add(new Point(0,i));
                }else{
                    // answer[i]=lock/nowUser;
                    list.add(new Point(lock/nowUser,i));
                    nowUser-=lock;
                }                  
            }
        }
        // System.out.print(Arrays.toString(answer));
        
        //
        Collections.sort(list,(s1,s2)->{
            if(s1.val>s2.val){
                return -1;
            }else if(s1.val==s2.val){
                return 0;
            }else{
                return 1;
            }
        });
        int cnt=0;
        for(Point p : list){
            // System.out.print(p.val+" ");
            // System.out.print(p.index+" ");
            solve[cnt]=p.index+1;
            cnt++;
        }
        //실수값으로 있는 배열을 크기 순서대로 정렬하되 인덱스는 유지하기
        
        
        return solve;
    }
}
