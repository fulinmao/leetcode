package com.fulin.Math;
import java.util.HashMap;
/**
 * Created by fulin on 18-2-11.
 */
public class ReverseBits {

    public static void main(String[] args){
        System.out.println(Long.toBinaryString(2147483647L));
//        System.out.println(reverseBits(2147483647L));
    }

    public int reverseBits(int n) {
        int result = 0;
        for(int i=0;i< 32 ;i++ , n >>= 1){
            result = result << 1 | n & 1;
        }
        return result;
    }

    private HashMap<Byte ,Integer> cache = new HashMap<Byte ,Integer> ();
    public int reverseBitsForMult(int n) {
        byte[] bytes = new byte[4];
        for (int i = 0; i < 4; i++) // convert int into 4 bytes
            bytes[i] = (byte)((n >>> 8*i) & 0xFF);
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result += reverseByte(bytes[i]); // reverse per byte
            if (i < 3)
                result <<= 8;
        }
        return result;
    }

    private Integer reverseByte(Byte b){
        Integer result = cache.get(b);
        if(result != null){
            return result;
        }
        result = 0;
        for (int i = 0; i < 8; i++) {
            result += ((b >>> i) & 1);
            if (i < 7)
                result <<= 1;
        }
        cache.put(b, result);

        return result;

    }
}
