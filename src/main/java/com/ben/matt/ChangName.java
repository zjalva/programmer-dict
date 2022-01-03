package com.matt;

import java.io.File;

public class ChangName {


    public static void main(String[] args) {
        String path = "/Volumes/Elements/学习资料.7z/601----684";        //要遍历的路径
        File file = new File(path);        //获取其file对象
        File[] fs = file.listFiles();    //遍历path下的文件和目录，放在File数组中
        for (File f : fs) {                    //遍历File[]数组
            if (!f.isDirectory())     {
                //若非目录(即文件)，则打印

                String filename=f.getAbsolutePath();
                if(filename.indexOf(".doc")!=-1)
                {
                    filename = filename.substring(0,filename.lastIndexOf("."));
                    if(f.renameTo(new File(filename+".mp4")))
                    {
                        System.out.println("修改成功!");
                    }  else  {
                    System.out.println("修改失败");
                }
                }


            }


        }
    }
}
