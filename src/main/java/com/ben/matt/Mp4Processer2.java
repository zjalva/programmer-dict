package com.matt;

import java.io.*;
import java.util.Random;

public class Mp4Processer2{


    public static void main(String[] args) {
        Random random = new Random();

        int pichi=random.nextInt();
        int index=0;
        try {
            BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("/Users/matt/m3u8PathsFull.txt")),
                    "UTF-8"));
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/Users/matt/m3u8Paths.txt")),
                    "UTF-8"));
            String lineTxt = null;
            while ((lineTxt = br.readLine()) != null) {
                String m3u8Path=lineTxt.trim();
                if(m3u8Path.length()!=0){
                    // 方案1
                    String commands ="/Users/matt/ffmpeg -protocol_whitelist \"file,http,https,tcp,tls,crypto\" -i \""
                            +m3u8Path
                            +"\" -c copy /Users/matt/outputs/new_"+pichi+"_P"+index+++".mp4";
                    wr.write(commands);
                    wr.newLine();
                }


            }
            br.close();
            wr.close();
            System.err.println("**********************************");
        } catch (Exception e) {
            System.err.println("read errors :" + e);
        }



    }

}
