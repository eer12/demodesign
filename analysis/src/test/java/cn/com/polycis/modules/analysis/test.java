package cn.com.polycis.modules.analysis;

public class test {
    public static void main(String[] args) {
        String str="FA021234561234";
        String str1="";
        String arr[]=new String[str.length()/2];
        for(int i=0;i<str.length();i++){
            str1+=str.charAt(i);
            if((i+1)%2==0){
                arr[i/2]=str1;
                System.out.println(arr[i/2]);
                str1="";
            }
        }
        System.out.println(arr[0]);


      /*  int x =22;
        String string = Integer.toHexString(x);
        System.out.println(string);
        String xx = "4654252";
        System.out.println(Integer.toString(x,16));*/


   /*     int str111=0x10;
        int str11=0X11;
        DecimalFormat df=new DecimalFormat("0000");
        String str2=df.format(str11);
        System.out.println(str2);
        System.out.println(str11);*/

        String string1 = Integer.toHexString(16);
        System.out.println(string1);
        String string2 = Integer.toHexString(16);
        System.out.println(string2);
        boolean b = Integer.toHexString(16).equalsIgnoreCase("e");
        System.out.println(b);

        byte[] bytes = string1.getBytes();
        System.out.println(Integer.toHexString(bytes[0]));

    }





}
