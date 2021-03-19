package com.hzwq.socket.Client;

import java.io.*;
import java.net.*;

/**
        * Tcp 是面向连接的协议,只能用于端到端的通信
        * udp是面向无连接的协议，udp的数据包括目的端口号和源端口号，可以实现广播发送，不局限于端到端
        * tcp 有发送，还有接收，是双向的，有反馈
        * udp只管发送，不会有回复
        * tcp/ip中两个进程间通信的主要模式是C/S 模型
        * <p>
 * 构建一个TCP的客户端  Tcp:
         * 客户端发送数据
         * 服务器端读取数据并打印
         *
         * 查看一下Socket的源码
         */
public class Client {
    /**
     * 1. 使用套接字来连接到指定服务器
     * 2. 发送数据
     * 3. 资源释放
     *
     */

    public static void main(String[] args) throws IOException {


        /**
         *  第二章节中
         * Socket socket = new Socket();
         * //      设置超时时间
         *         socket.setSoTimeout(3000);
         */

        Socket socket = createSocket();
        initSocket(socket);

//        设置将套接字连接到具有指定超时时间的服务器
        socket.connect(new InetSocketAddress(Inet4Address.getLocalHost(), 2000), 3000);

        System.out.println("已发起服务器连接，正在进入后续流程");
//        getLocalAddress ：获取套接字所绑定的本地地址， getLocalPort获取套接字所绑定的本地端口号
        System.out.println("客户端信息：" + " IP:" + socket.getLocalAddress() + "Port：" + socket.getLocalPort());
//        getInetAddress 返回套接字连接的远程地址， getPort 返回套接字连接的远程端口号
        System.out.println("服务端信息：" + "IP:" + socket.getInetAddress() + "Port:" + socket.getPort());

        try {
//          发送接收数据
            todo(socket);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("异常退出");
        }

        //  释放资源
        socket.close();
        System.out.println("客户端已经退出");

    }

    private static void initSocket(Socket socket) {

    }

    private static Socket createSocket() {
        // 无代理模式，等效于空构造函数
        Socket socket = new Socket(Proxy.NO_PROXY);
        // 新建一份具有HTTP代理的套接字，传输数据将通过www.baidu.com:8080端口
        Proxy  

        return null;
    }

    /**
     *  发送数据
     *  1.构建输入流
     *  2. 构建socket输出流 然后发送到服务器
     *  3. socket 的输入流 将从服务器接收到的数据打印出来，或者进行处理
     *  4. 操作完需要释放资源
     * @param client
     * @throws IOException
     */
    private static void todo(Socket client) throws IOException {
        //        构建键盘输入流
        InputStream in = System.in;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

        //  构建Socket输出流，并转换为打印流
        OutputStream socketOutputStream = client.getOutputStream();
        PrintStream printStream = new PrintStream(socketOutputStream);

//       从socket的输入流，并且转换为socketBufferReader
        InputStream socketInputStream = client.getInputStream();
        BufferedReader socketBufferReader = new BufferedReader(new InputStreamReader(socketInputStream));
        boolean flag = true;

        do {
// 键盘读取一行
            String str = bufferedReader.readLine();
//        发送到服务器
            printStream.println(str);

//        从服务器读取一行
            String socketStr = socketBufferReader.readLine();

            if ("bye".equalsIgnoreCase(socketStr))
                flag = false;

            else
                System.out.println(socketStr);
        } while (flag);


        // 操作完资源释放
        printStream.close();
        socketBufferReader.close();

    }


}
