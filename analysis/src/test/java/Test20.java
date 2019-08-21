public class Test20 {

    public static void main(String[] args) {
        System.out.println(getCount(50));

    }

    public static long getCount(Integer n){

        if(n==1){
           return 1;

        }
        if(n==2){
            return 0;
        }
        if(n==3){
            return 1;
        }

        return getCount(n-1)-2*getCount(n-2)+getCount(n-3);

    }
}
