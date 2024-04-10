package com.auto_test.testng;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public class DeleteOne {
    /**
     * 删除单个文件
     *
     * @param fileName
     *            要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                log.info("删除单个文件" + fileName + "成功！");
                return true;
            } else {
                log.info("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else {
            log.info("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }


    /**
     * 强制删除
     * @param fileName
     * @return
     */
    public static boolean forceDelete(String fileName)
    {
        File f = new File(fileName);
        boolean result = false;
        int tryCount = 0;
        while(!result && tryCount++ <10)
        {
            log.info("try to delete file "+ f.getName() +" cnt:"+tryCount);
            System.gc();
            result = f.delete();
        }
        return result;
    }

    public static void main(String[] args) {
        String pathString = "C:\\Users\\Administrator\\AppData\\Roaming\\baidu\\BaiduNetdisk\\yunshellextv164.pp";
        //String pathString = "C:\\Users\\Administrator\\AppData\\Roaming\\baidu\\BaiduNetdisk\\999.txt";
        //deleteFile(pathString);
        forceDelete(pathString);
    }
}
