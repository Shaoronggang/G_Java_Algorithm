package com.hzwq.socket;

/**
 * @Author: shaoRongGang
 * @Description: socket学习基础,socket学习的难点：数据粘包，心跳维持，数据丢包，性能问题，系统学习，demo肤浅
 * 学习目标：自己实现一套推送框架，IM传输原理不再成为技术上的盲点，胜任物联网相关开发，协议的定制者，
 * 技术收获：NIO：byteBuffer,Channel,  Socket运用：数据分片，消息粘包，性能调试，并发封装，桥接技术，内存复用
 * 案例内容：群聊天，文件快传，即时语音
 * 底层协议：报文 协议 Mac地址  IP 端口 服务器   -----> TCP、UDP  ----> Selector  Channel:FileChannel SocketChannel ReadChannel
 * Buffer:ByteBuffer IntBuffer CharBuffer
 * ByteBuffer的put 操作：三个重要的变量：position --- 当前坐标 capacity --- 最大容量 limit --- 当前可操作的最大区域
 * 群聊天：多客户端链接 UDP扫描功能 聊天消息转发 向NIO转型  心跳包的实现
 * 文件快传：基于流的传输  文件发送中断 消息分片技术 消息混发技术
 * 即时语音：直播推流  语音采集 语音压缩 接收与播放 实时消息模型  -----> 桥接技术
 * 高性能的调度规则  健壮的数据消费流程
 * 学习的态度：不急躁，有独立处理问题的能力
 *
 * @Date:Created in 16:30 2020/3/22
 * @Modifid By:
 * @Version：1.0.0
 */
public class SocketDemo {

    private static final String TAG = "SocketDemo";

    public static void main(String[] args) {
        System.out.printf("");
        System.out.println();
    }

}
