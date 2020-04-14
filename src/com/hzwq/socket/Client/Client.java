package com.hzwq.socket.Client;

import java.io.*;
import java.net.*;

/**
 * @Author: shaoRongGang
 * @Description:
 * @Date:Created in 22:02 2020/3/30
 * @Modifid By:
 * @Version：
 */
public class Client {
    public static void main(String[] args) {
        Socket socket = new Socket();
        try {
//            超时时间
            socket.setSoTimeout(3000);
//            连接本地，端口2000，超时时间3000
            socket.connect(new InetSocketAddress(InetAddress.getLocalHost(),2000),3000);
            System.out.println("已发起服务器连接，并进入到后续流程~");
            System.out.println("客户端信息："+ socket.getLocalAddress()+" P1_1_FindInt:" + socket.getLocalPort());
            System.out.println("服务端信息："+ socket.getInetAddress()+" P1_1_FindInt:" + socket.getPort());
        } catch (IOException e) {
            e.printStackTrace();
        }

//      发送接收数据
        try {
            todo(socket);
        } catch (IOException e) {
            System.out.println("异常关闭");
        }

        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("客户端已退出");

    }

    /**
     * 发送数据
     * @param client
     * @throws IOException
     */
    private static void todo(Socket client) throws IOException{
//      读取键盘输入流
        InputStream in= System.in;
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

//       得到socket的输出流，并转化为打印流
        OutputStream out = client.getOutputStream();
        PrintStream socketPrintStream = new PrintStream(out);

//        得到Socket输入流,并转换为BufferedReader
        InputStream inputStream= client.getInputStream();
        BufferedReader socketBufferReader = new BufferedReader(new InputStreamReader(inputStream));


//       键盘读取一行
        String str = reader.readLine();
//        发送到服务器
        socketPrintStream.println(str);

        boolean flag = true;
        do {
//      从服务器读取一行
            String echo = socketBufferReader.readLine();
            if ("bye".equalsIgnoreCase(echo)){
                flag = false;
            }else{
                System.out.println(echo);
            }
        } while (flag);

//        资源释放
        socketPrintStream.close();
        socketBufferReader.close();

    }


}
