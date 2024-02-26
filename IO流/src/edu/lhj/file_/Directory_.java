package edu.lhj.file_;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class Directory_ {
    public static void main(String[] args) {

    }

    @Test
    public void m1() {
        //判断d:\javacode\FileIO\news1.txt是否存在,存在就删除
        String parent = "d:\\javacode\\FileIO";
        String child = "news1.txt";
        File file = new File(parent,child);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        }else {
            System.out.println("你要删除的文件不存在");
        }
    }

    @Test
    public void m2() {
        //判断d:\demo02目录是否存在,存在就删除
        //这里我们可以体会到,目录在java中也被当做文件
        String pathname = "d:\\demo02";
        File file = new File(pathname);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        }else {
            System.out.println("你要删除的目录不存在");
        }
    }

    @Test
    public void m3() {
        //判断d:\demo02\a\b\c目录是否存在,存在就提示存在,并且删除,不存在就删除
        //这里我们可以体会到,目录在java中也被当做文件
        String directoryPath = "d:\\demo02\\a\\b\\c";
        File file = new File(directoryPath);
        if (!file.exists()) {
            //创建一级目录使用mkdir,创建多级目录使用mkdirs
            if (file.mkdirs()) {
                System.out.println("创建成功");
            }else {
                System.out.println("创建失败");
            }
        }else {
            System.out.println("你要创建的目录已存在");
        }
    }

}
