package edu.lhj.tankgame06;

import java.io.*;
import java.util.Vector;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class Recorder {
    //记录我方击毁敌方坦克数量
    private static int enemyTankNum = 0;
    //定义IO对象,把信息写入到文件中
    private static BufferedWriter bw = null;//处理流/包装流
    private static String recordFile = "src\\myRecord.txt";
    //定义一个Vector集合,添加set方法,用于获取MyPanel类中的enemyTanks集合
    private static Vector<EnemyTank> enemyTanks = null;
    //定义一个Vector集合,用于保存退出游戏时候敌人坦克的信息
    private static Vector<Node> nodes = new Vector<>();
    //定义IO对象,读取文件中的信息
    private static BufferedReader br = null;//处理流/包装流

    public static void saveRecord() {
        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            bw.write(enemyTankNum + "");
            bw.newLine();
            //记录剩余坦克的xy坐标和方向
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = enemyTanks.get(i);
                String record = enemyTank.getX() + " " + enemyTank.getY() + " " +
                        enemyTank.getDirect();
                bw.write(record);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //定义一个方法,用于读取myRecord.txt文件中存放的信息,返回一个Vector<Node>
    //我们只需要在游戏开始的时候调用这个方法即可读取到上一局游戏的信息
    public static Vector<Node> readRecord() {
        try {
            br = new BufferedReader(new FileReader(recordFile));
            String data = "";
            //第一行存放的是剩余敌方坦克的数量,单独读出来
            enemyTankNum = Integer.parseInt(br.readLine());
            //循环读取坦克的位置、方向信息
            while ((data = br.readLine()) != null) {
                String[] s = data.split(" ");//根据空格分割成xy坐标和方向
                Node node = new Node(Integer.parseInt(s[0]), Integer.parseInt(s[1]),
                        Integer.parseInt(s[2]));//要把字符串转成Integer
                nodes.add(node);//把取出来的信息保存到nodes集合中
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//关闭流
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return nodes;
        }
    }

    public static String getRecordFile() {
        return recordFile;
    }

    public static int getEnemyTankNum() {
        return enemyTankNum;
    }

    public static void setEnemyTankNum(int destroyEnemyTank) {
        Recorder.enemyTankNum = destroyEnemyTank;
    }

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    public static void destroyEnemyTankNum() {
        enemyTankNum++;
    }
}
