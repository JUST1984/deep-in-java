package priv.just1984.deep.in.java.basic.demo;

import java.io.UnsupportedEncodingException;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-10-09 11:47
 */
public class EncodeDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "æ\\u0083 å·\\u009Eå¸\\u0082æ\\u0083 å\\u009F\\u008Eå\\u008Cºæ°´å\\u008F£è\\u0090¥ä¸\\u009Aé\\u0083¨";
        System.out.println(new String(s.getBytes(), "GBK"));
    }

}
