package com.andrew;

import org.apache.commons.lang.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrew Yang
 * @className OrderApplicationMain
 * @description
 * @package com.andrew.springcloud
 * @create 2021-05-30 16:00
 */
@EnableEurekaClient
@SpringBootApplication
public class PaymentApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplicationMain.class, args);
    }

    public static void main2(String args[]) {

        PaymentApplicationMain wordTest = new PaymentApplicationMain();
        List<String> words = new ArrayList<>();            //分词词典
        words.add("三笑");
        words.add("TB");
        words.add("适齿");
        words.add("三重深洁");
        words.add("丝");
        words.add("三效优护");
        words.add("超洁净");
        words.add("单支装");
        words.add("牙间刷");
        words.add("双核");
        words.add("牙膏");

        List<String> wordList = wordTest.getWordList("高露洁高效泡沫抗敏牙膏(直立式)100ml90g+深层洁净牙刷2支", words);    //查询语句分词
        StringBuilder sb1 = new StringBuilder();
        for (String string : wordList) {
            sb1.append(string).append(",");
        }
        System.out.println("查询关键字：" + sb1);
    }

    //判断当前查询标题包含的关键词密度
    public int getkeywordDensity(List<String> words, List<String> title) {
        int num = 0;
        for (String string : title) {
            if (words.contains(string)) {
                num += 1;
            }
        }
        return num;
    }

    public List<String> getWordList(String a, List<String> wordList) {
        List<String> splitWords = new ArrayList<>();
        if (StringUtils.isBlank(a)) {
            return splitWords;
        }
        //String[] cs =  {"你好","请问","什么","名字","springboot","java","mysql","CentOS","编译","Python3","Python2","句子"};//词典
        a = a.toLowerCase();
        String[] cs2 = new String[100]; //结果数组
        int jud = 0;//找到匹配字符串与否的标志
        int j = 0;
        String temp = null;//初始化临时字符串
        while (a.length() > 0) {
            for (int i = 0; i < a.length(); i++) {
                temp = a.substring(i);//每次截取掉首个字符
                if (isin(wordList, temp))//如果目标字符串在数组中
                {
                    cs2[j] = temp;
                    jud = 1;
                    int number = temp.length();
                    a = a.substring(0, a.length() - number);
                }
            }
            if (jud == 0)//没有找到匹配字符串
            {
                cs2[j] = a.substring(a.length() - 1, a.length());//将最后一个元素放在cs2里面
                a = a.substring(0, a.length() - 1);//截掉最后一个元素继续循环。
            }
            jud = 0;
            j++;
        }

        for (; j >= 0; j--) {
            if (cs2[j] != null) {
                if (cs2[j].length() >= 2) {
                    //System.out.print(cs2[j]+"	");
                    splitWords.add(cs2[j]);
                }
            }
        }
        return splitWords;
    }

    /*
     * 下面为判断字符串是否在词典中的函数方法
     */

    static public boolean isin(List<String> wordList, String temp)//判断目标字符串是否在对比字符串数组中
    {
        int i;
        for (i = 0; i < wordList.size(); ) {
            if (temp.equals(wordList.get(i)))
                i = wordList.size() + 1;
            else
                i++;
        }
        return i == wordList.size() + 1;
    }
}
