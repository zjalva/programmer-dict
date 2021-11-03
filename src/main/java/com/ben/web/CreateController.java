package com.ben.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ben.entity.Category;
import com.ben.entity.Dict;
import com.ben.entity.Mean;
import com.ben.entity.Word;
import com.ben.service.Reader;
import com.ben.service.WordService;
import com.ben.service.impl.TxtReader;

@Controller
@RequestMapping(value = "/create")
public class CreateController {

	
	@Autowired
	WordService wordService;
	
    Logger logger = Logger.getLogger(getClass());
 
 
 
 
    @RequestMapping(value = "/docreate", method = RequestMethod.GET)
    @ResponseBody
    public String create(Model model) throws Exception {
    	Reader reader=new TxtReader();
    	Map<String,Integer> map=new HashMap<String,Integer>();
    	reader.init("E://spring.txt");
    	String s = "\\d+.\\d+|\\w+";
        Pattern  pattern=Pattern.compile(s);
       
    	String line=reader.nextLine();
    	while(line!=null){
            Matcher  ma=pattern.matcher(line); 
            while(ma.find()){ 
            	String wordStr=ma.group().trim();
            	if(!isword(wordStr)||hasToMoreUpperCase(wordStr)||wordStr.length()==1){
            		continue;
            	}
            	wordStr=wordStr.toLowerCase();
            	Integer count=map.get(wordStr);
            	if(count==null){
            		map.put(wordStr, new Integer(1));
            	}else{
            		count=Integer.valueOf(count.intValue()+1);
            		map.put(wordStr, count);
            	}
            } 
    		line=reader.nextLine();
    	}
    	reader.release();
    	Category category=new Category();
   	 	category.setCategoryName("spring");
   	 	wordService.saveCategory(category);
    	searchDict(map,category);
		return "success";
    }

    
    private void searchDict(Map<String, Integer> map,Category category)throws Exception{
    	 Set<Entry<String, Integer>> set=map.entrySet();
    	 
    	 for (Entry<String, Integer> entry : set) {
			String wordStr=entry.getKey();
			 //Word  word=doSearch(wordStr);
			Word  word=doSearchDict(wordStr);
			 word.setCategory(category);
			 word.setFrequency(entry.getValue());
			 wordService.saveWord(word);
		}
    }
    
    private Word doSearchDict(String wordStr) throws Exception{
    	Word word=new Word();
    	word.setXiefa(wordStr);
    	word.setYinbiao(null);
    	Dict dict=wordService.getDict(wordStr);
    	if(dict!=null){
    		word.setDict(dict);
    		word.setShiyi(dict.getJieshi());
    	}
    	return word;
    }
    
    @RequestMapping(value = "/pited", method = RequestMethod.GET)
    @ResponseBody
    public String pited(Model model) throws Exception {
    	 List<Word> words=wordService.noExplainedWrod();
    	 if(words!=null){
    		for (Word word : words) {
    			doSearch(word);
    			wordService.saveWord(word);
			}
    	 }
		return "success";
    }
    
    
    private Word doSearch(Word word) throws Exception{
    	String wordStr=word.getXiefa();
    	List<Mean> listmeans=new ArrayList<Mean>();
    	 
    	 //根据查找单词构造查找地址
        HttpGet getWordMean = new HttpGet("http://dict.youdao.com/search?q=" + wordStr + "&keyfrom=dict.index");
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
            StringBuilder zongMean=new StringBuilder();
            while (m2.find()) {
                //在Java中(.*?)是第1组，所以用group(1)
                String meanStr=m2.group(1);
                zongMean.append(meanStr);
                if(meanStr.indexOf("</a>")!=-1){
                	continue;
                }
                Mean mean=new Mean();
                mean.setJieshi(meanStr);
                mean.setWord(word);
                listmeans.add(mean);
            }
            word.setShiyi(zongMean.toString());
            word.setMeans(listmeans);
        }
    	
    	return word;
    }
    
    
   
    public static void main(String[] args){ 
    	Pattern pattern = Pattern.compile("[a-zA-Z]+"); 
	 	   Matcher isword = pattern.matcher(" 2bacd");
	 	  
	 	  System.out.println( isword.matches()); 
  
    }  
    
    CloseableHttpClient httpClient = HttpClients.createDefault();
    public static boolean containNumeric(String str){
    	  for (int i = str.length();--i>=0;){   
	    	   if (Character.isDigit(str.charAt(i))){
	    		   return true;
	    	   }
    	  }
    	  return false;
   }
    
    
   public static boolean hasToMoreUpperCase(String str){
	     int j=0;
	  	  for (int i = str.length();--i>=0;){   
		    	   if (Character.isUpperCase(str.charAt(i)) ){
		    		   j++;
		    		   if(j>=2){
		    			   return true;
		    		   }
		    		   
		    	   }
	  	  }
	  	  return false;
    }
   
   public static boolean isword(String str){
    	Pattern pattern = Pattern.compile("[a-zA-Z]+"); 
	 	   Matcher isword = pattern.matcher(str);
	 	  
	 	  return isword.matches(); 
  }
   
  
   
   
}
