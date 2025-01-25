package programmers.Level3;

public class N으로표현 {
    static int n = 5;
    static int number = 12;
    public static void main(String[] args) {
        int n = 5;
        int number = 13;

        func(0, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
    static int min = Integer.MAX_VALUE;
    private static void func(int depth, int sum) {
        if(sum == number){
            if(min > depth) min = depth;
        }
        if(depth >= 9){
            return;
        }
        for(int i = 0; i < 5; i++){
            if(i == 0){
                func(depth + 1, sum + n);
            } else if(i == 1){
                func(depth + 1, sum * n);
            } else if(i == 2){
                func(depth + 1, sum / n);

            } else if(i ==3){
                func(depth + 1, sum - n);
            }
            else {
                func(depth + 2, n * 11);
            }
        }
    }
}
