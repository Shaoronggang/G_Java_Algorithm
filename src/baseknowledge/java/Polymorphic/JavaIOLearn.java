package baseknowledge.java.Polymorphic;


import java.io.*;

public class JavaIOLearn {


    public static void main(String[] args) throws IOException {
        JavaIOLearn javaIOLearn = new JavaIOLearn();
//        javaIOLearn.readFlie();
        javaIOLearn.writeFile();
    }

    public void readFlie() throws IOException{
        InputStream in = null;
        try{
            in = new FileInputStream("/Users/srg/Downloads/原图/4T0A6840.jpg");
            for (;;){
                int n ; // 反复调用read方法直到返回-1
                if ((n= in.read()) == -1){
                    break;
                }
//                System.out.println(n);
            }
        }finally {
            if (in != null){
                in.close();
            }
        }
        /*-----------------------------------------------使用了try（resource）流数据读取--------------------------------*/
//      try(resource) 语法，编译器在此自动为我们写入finally并调用close()
        try(InputStream input = new FileInputStream("/Users/srg/Downloads/原图/4T0A6840.jpg")){
                int n ; // 反复调用read方法直到返回-1
                while ((n= input.read()) != -1){
//                System.out.println(n);
                }

        }

        /*-----------------------------------------------使用了try（resource）流数据读取--------------------------------*/

       /*-----------------------------------------------使用了缓冲区进行流数据读取--------------------------------*/
        try(InputStream inputStream = new FileInputStream("/Users/srg/Downloads/原图/4T0A6840.jpg")){
//          定义一个1024个字节大小的缓冲区
            byte[] buffer = new byte[1024];
            int n;
            int total = 0;
            // 读取数据到缓冲区,而且read操作是阻塞的
            while ((n = inputStream.read(buffer)) != -1){
                total += n;
                System.out.println("read:" + n + "bytes");
            }

            System.out.println("总大小：" + total/(1024*1024) + "M");
        }



        /*-----------------------------------------------使用了缓冲区进行流数据读取--------------------------------*/



    }

    public void writeFile() throws IOException{
        // 如果没有hello.txt文件，将创建一个hello.txt文件
//        用try(resource)来保证OutputStream在无论是否发生IO错误的时候都能够正确地关闭
        try(OutputStream output = new FileOutputStream("/Users/srg/Downloads/hello.txt")){
            output.write(72);
            output.write(101);
            output.write(108);
            output.write(108);
            output.write(111);
            // outputStream 提供了相应的write(byte[])方法
            output.write("\nshaoronggang".getBytes("UTF-8"));
        }
        byte[] data;

        try(ByteArrayOutputStream out = new ByteArrayOutputStream()){
            out.write("Hello".getBytes("UTF-8"));
            out.write("world".getBytes("UTF-8"));
            data = out.toByteArray();
        }

        System.out.println(new java.lang.String(data,"UTF-8"));

    }
}
