package com.hzwq.socket.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: shaoRongGang
 * @Description: Socket 的服务端  需要先将java文件编译成class文件在运行class文件来验证
 * @Date:Created in 22:02 2020/3/30
 * @Modifid By:
 * @Version：
 */
public class Server {
    public static void main(String[] args) throws IOException {
//        服务端套接字
        ServerSocket serverSocket = new ServerSocket(2000);

        System.out.println("服务器准备就绪");
        System.out.println("服务器信息：" + "P:" + serverSocket.getInetAddress() + "port:" + serverSocket.getLocalPort());

        while (true) {
            //        等待客户端连接
            Socket client = serverSocket.accept();
            //开启一个线程，并将客户端传入
            new ClientThread(client).start();
        }


    }

    /**
     * 一个服务器可能对应多个客户端
     */
    private static class ClientThread extends Thread {
        private Socket cliet; // 客户端
        private boolean flag = true;

        public ClientThread(Socket cliet) {
            this.cliet = cliet;
        }

        @Override
        public void run() {
            super.run();
            //    接收
            System.out.println("新客户端的信息：" + "IP:" + cliet.getInetAddress() + "Port:" + cliet.getPort());

            try {
                // 构建打印流，用于数据输出，服务器回送数据使用
                PrintStream socketPrintStream = new PrintStream(cliet.getOutputStream());
                // 获取客户端的输入流,接收客户端数据
                BufferedReader socketBufferdReader = new BufferedReader(new InputStreamReader(cliet.getInputStream()));

                do {
                    String echo = socketBufferdReader.readLine();
                    if ("bye".equalsIgnoreCase(echo)) {
                        flag = false;
                        socketPrintStream.println("bye");
                    } else {
                        System.out.println(echo);
                        if (echo != null)
                            socketPrintStream.println("回送：" + echo.length());
                    }
                } while (flag);

                socketBufferdReader.close();
                socketPrintStream.close();

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("连接异常中断");
            } finally {
                try {
                    cliet.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            System.out.println("客户端关闭：" + "P:" + cliet.getInetAddress() + "Port:" + cliet.getPort());
        }
    }
}
