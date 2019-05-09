package com.fulin.number;

/**
 *  计算2个字符串乘积
 *  ①.定义一个长度为两个字符串长度和的char数组
 *  ②.循环2个字符串的每一个字符，然后相乘，如果结果大于9 则需要进位
 *  ⑤. 将char数组中不为0的部分进行输出
 */
public class MultiplyStrings {


    public static String multiply(String num1, String num2) {
        int result = 0;
        // 如果 输入的整数中存在0 ，则返回结果为0
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int length = num1.length() + num2.length();
        char[] resultArray = new char[length];

        char[] num1Array = num1.toCharArray();
        char[] num2Array = num2.toCharArray();
        for (int i = 0; i < num1Array.length; i++) {
            int currentNum1 = (num1Array[num1Array.length - i - 1] - 48);
            for (int j = 0; j < num2Array.length; j++) {
                int currentNum2 = (num2Array[num2Array.length - j - 1] - 48);
                // 计算当前 乘积的最低位
                int index = i + j;
                result = resultArray[index] + currentNum1 * currentNum2;
                while (result > 9) {
                    int temp = result % 10;
                    resultArray[index] = (char) temp;
                    result = result / 10 + resultArray[index + 1];
                    index++;
                }
                resultArray[index] = (char) result;
            }
        }
        StringBuffer resultBuf = new StringBuffer();
        boolean flag = true;
        for (int i = resultArray.length - 1; i >= 0; i--) {

            if (!flag ) {
                char temp = (char) (resultArray[i] + 48);
                resultBuf.append(temp);
            } else if (resultArray[i] != 0) {
                flag = false;
                char temp = (char) (resultArray[i] + 48);
                resultBuf.append(temp);
            }
        }
        return resultBuf.toString();
    }

}
