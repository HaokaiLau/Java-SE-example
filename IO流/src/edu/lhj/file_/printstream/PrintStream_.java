package edu.lhj.file_.printstream;

import java.io.IOException;
import java.io.PrintStream;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * PrintStream 字节打印流/输出流
 */
public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        //两种定义方式
        PrintStream out = System.out;
        PrintStream printStream = new PrintStream(System.out);
        //默认情况下,PrintStream输出数据的位置是标准输出,即输出到显示器
        /*
            public void print(String s) {
                write(String.valueOf(s));
            }

            private void write(String s) {
                try {
                    synchronized (this) {
                        ensureOpen();
                        textOut.write(s);
                        textOut.flushBuffer();
                        charOut.flushBuffer();
                        if (autoFlush && (s.indexOf('\n') >= 0))
                            out.flush();
                    }
                }
                catch (InterruptedIOException x) {
                    Thread.currentThread().interrupt();
                }
                catch (IOException x) {
                    trouble = true;
                }
            }
         */
        //print方法可以直接传入字符串
        out.print("hello,刘浩楷");
        //因为print方法还是调用的是write方法,所以我们还可以直接调用write方法直接输出
        out.write("你好,刘浩楷".getBytes());
        //我们还可以使用setOut方法修改打印流的输出位置使其输出到指定的位置/设备
        /*
        public static void setOut(PrintStream out) {
            checkIO();
            setOut0(out);
        }

        private static native void setOut0(PrintStream out);
         */
        System.setOut(new PrintStream("d:\\javacode\\FileIO\\a3.txt"));
        System.out.println("变身彩虹,吃定彩虹");

        out.close();
    }
}
