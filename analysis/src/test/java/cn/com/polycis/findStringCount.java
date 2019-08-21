package cn.com.polycis;

import org.springframework.util.StringUtils;

public class findStringCount {
//找出字符串中有几个fd
    public static void main(String[] args) {

        String str ="fddaerfdca";
        char[] chars = str.toCharArray();
        int s=0;
        for(int i=0; i<chars.length;i++){


            if(chars[i]==0x66 && chars[i+1]==0x64){
                s++;
            }
        }
        System.out.println(s);
    }
}
