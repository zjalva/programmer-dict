package com.matt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class Mp4SplitProcesser {


    private static boolean processMp4(String m3u8Path ,String newfilename) {

        try {

             ProcessBuilder processBuilder = new ProcessBuilder(
                    "/Users/matt/ffmpeg",
                    "-protocol_whitelist", "file,http,https,tcp,tls,crypto",
                    "-ss", "00:00:19",
                    "-i", m3u8Path, "-c", "copy",
                    newfilename
            );
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();


            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            process.waitFor();

            System.err.println(  "^^ success ^^" + m3u8Path);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    public static void main(String[] args) {


        File file = new File("/Volumes/Blue/1YYYYYY2020主题/顶 红床/1");
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null == files || files.length == 0) {
                System.out.println("文件夹是空的!");
                return;
            } else {

                try {

                    for (File file2 : files) {

                       String  filename=file2.getAbsolutePath();

                        System.out.println("文件:" + filename);

                        String  newfilename = filename.substring(0,filename.indexOf(".mp4")) +" .mp4";

                         processMp4(filename, newfilename);

                    }
                    System.err.println("***********  finished ***********************");

                } catch (Exception e) {
                    System.err.println("read errors :" + e);
                }



            }
        }












    }

}