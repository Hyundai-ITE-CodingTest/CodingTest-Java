package Answer02;

public class Quiz05 {
    public static void main(String[] args) {
        for(int i = 0 ; i<5; i++){
                for(int j =0 ; j<=i; j++){
                    System.out.print("*");
                }
                System.out.println();
            }
        for(int i=4; i>0; i--){
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
