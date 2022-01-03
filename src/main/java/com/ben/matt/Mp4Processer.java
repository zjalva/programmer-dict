package com.matt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mp4Processer {



    private static boolean processMp4(String m3u8Path,String pichi){
        {


            try {

                ProcessBuilder processBuilder = new ProcessBuilder(
                        "/Users/matt/ffmpeg",

                       "-protocol_whitelist" ,"file,http,https,tcp,tls,crypto",  "-ss", "00:00:19",
                "-i",m3u8Path,"-c","copy",
                        "/Users/matt/outputs/new_"+pichi+".mp4"
                );
                processBuilder.redirectErrorStream(true);
                Process process = processBuilder.start();


                BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line = null;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                process.waitFor();

                System.err.println(pichi+"^^ success ^^"+m3u8Path);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }


    public static void main(String[] args) {
        Random random = new Random();

        int pichi=random.nextInt();
        int index=0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/Users/matt/m3u8Paths.txt")),
                    "UTF-8"));
            String lineTxt = null;
            while ((lineTxt = br.readLine()) != null) {
                String m3u8Path=lineTxt.trim();
                if(m3u8Path.length()!=0)
                processMp4(  m3u8Path,pichi +"-P-"+index++);
            }
            br.close();
            System.err.println("**********************************");
        } catch (Exception e) {
            System.err.println("read errors :" + e);
        }



    }

}