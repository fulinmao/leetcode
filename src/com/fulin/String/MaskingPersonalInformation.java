package com.fulin.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaskingPersonalInformation {

    public static String maskPII(String s) {
        //如果字符串为空，则返回空字符串
        if(s == null || s.length() ==0){
            return null;
        }
        // 将字符串s 全部修改为小写
        s = s.toLowerCase();
        //判断当前字符串是否为email地址
        if(s.indexOf("@") != -1 && s.indexOf(".")!=-1){
            // 当前字符串中存在@ 和.
            //判断当前字符串中是否只存在一个@ 和 一个 .
            if(s.lastIndexOf("@") == s.indexOf("@")  && s.lastIndexOf(".") == s.indexOf(".")){
                int atIndex = s.indexOf("@");
                String name1 = s.substring(0,atIndex);
                int dotIndex = s.indexOf(".");
                String name2 = s.substring(atIndex+1,dotIndex);
                String name3 = s.substring(dotIndex+1);

                //检查 name1 name2 name3 是否是合法字符串
                if(!checkNameValid(name1,name2,name3)){
                    return null;
                }
                StringBuffer result = new StringBuffer();
                result.append(name1.charAt(0));
                result.append("*****");
                result.append(name1.charAt(name1.length() -1));
                result.append("@");
                result.append(name2);
                result.append(".");
                result.append(name3);
                return result.toString();

            }else{
                return null;
            }
        }else{
            // 判断当前字符串是否为手机号
            List valid = Arrays.asList('0','1','2','3','4','5','6','7','8','9','+', '-', '(', ')', ' ');
            List digitList = new ArrayList();
            for(char t : s.toCharArray()){
                // 如果输入字符串不在valid 内则返回
                if(!valid.contains(t)){
                    return null;
                }
                if(t >='0' && t <='9'){
                    digitList.add(t);
                }
            }

            // 如果数字长度大于13 或者长度小于10，这直接返回null
            if(digitList.size() >13 || digitList.size() <10){
                return null;
            }
            StringBuffer result = new StringBuffer();
            if(digitList.size() ==10){
                // 本地号码
                result.append("***-***-");
                result.append(digitList.get(6));
                result.append(digitList.get(7));
                result.append(digitList.get(8));
                result.append(digitList.get(9));
            }else{
                // 存在country code
                result.append("+");
                for(int i=0;i<digitList.size()-10;i++){
                    result.append("*");
                }
                result.append("-");
                result.append("***-***-");
                result.append(digitList.get(digitList.size()-4));
                result.append(digitList.get(digitList.size()-3));
                result.append(digitList.get(digitList.size()-2));
                result.append(digitList.get(digitList.size()-1));
            }
            return result.toString();
        }
    }

    /**
     * 检查名字是否符合要求
     *  长度大于等于 2
     *  是a-z 或者A-Z
     * @param name
     * @return
     */
    public static boolean checkNameValid(String ... name){
        boolean result =  true;
        if(name == null || name.length ==0){
            result = false;
            return result;
        }

        for(String n : name){
            // 名字的长度应该大于等于2
            if(n == null || n.length() <2){
                result = false;
                return result;
            }
            for(char t : n.toLowerCase().toCharArray()){
                if(t>'z' & t <'a'){
                    result = false;
                    return result;
                }
            }
        }
        return result;
    }



}
