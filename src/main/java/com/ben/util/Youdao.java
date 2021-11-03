package com.ben.util;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Youdao {
	    public static void main(String[] args) throws IOException {
	        CloseableHttpClient httpClient = HttpClients.createDefault();

	        System.out.print("请输入你要查的单词:");
	        Scanner s = new Scanner(System.in);
	        String word = s.nextLine();
	        word = word.replaceAll(" ","+");

	        //根据查找单词构造查找地址
	        HttpGet getWordMean = new HttpGet("http://dict.youdao.com/search?q=" + word + "&keyfrom=dict.index");
	        CloseableHttpResponse response = httpClient.execute(getWordMean);//取得返回的网页源码

	        String result = EntityUtils.toString(response.getEntity());
	        response.close();
	        //注意(?s)，意思是让'.'匹配换行符，默认情况下不匹配
	        Pattern searchMeanPattern = Pattern.compile("(?s)<div class=\"trans-container\">.*?<ul>.*?</div>");
	        Matcher m1 = searchMeanPattern.matcher(result); //m1是获取包含翻译的整个<div>的

	        if (m1.find()) {
	            String means = m1.group();//所有解释，包含网页标签
	            Pattern getChinese = Pattern.compile("(?m)<li>(.*?)</li>"); //(?m)代表按行匹配
	            Matcher m2 = getChinese.matcher(means);

	            System.out.println("释义:");
	            while (m2.find()) {
	                //在Java中(.*?)是第1组，所以用group(1)
	                System.out.println("\t" + m2.group(1));
	            }
	        } else {
	            System.out.println("未查找到释义.");
	            System.exit(0);
	        }
	    }
}
