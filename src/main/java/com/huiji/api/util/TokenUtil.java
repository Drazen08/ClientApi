package com.huiji.api.util;

import java.util.Random;

/**
 * Created by 孙文剑 on 2016/7/17 0017.
 */
public class TokenUtil {
    private static final String[] model={"e","f"
            ,"m","x","y","z","A","B","C","D"
            ,"E","F","G","K","6","8","5"};
    private Random random=new Random();

    /**
     * 生成令牌编号,每个令牌对应一个不重复的编号
     */
    public  String nowNumber() {
        String result=null;
        for(int i=0;i<10;i++){
            String temp=model[random.nextInt(model.length)];
            result+=generate(temp);
        }
        return result.substring(0, 15);
    }
    /**
     * 令牌编号生成策略
     */
    private String generate(String str) {
        String s=null;
        char ch=str.charAt(0);
        if(ch>'1' && ch<'9'){
            s=String.valueOf(Math.abs(random.nextInt()%10+48));
        }else{
            s=String.valueOf(Math.abs(random.nextInt()%26+97));
        }
        return s;
    }
}
