import jdk.nashorn.internal.ir.WhileNode;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    public static void main(String[] args) throws Exception {
        // 0x00. Java 实例 - 获取指定主机的IP地址
        InetAddress address = null;
        try {
            address = InetAddress.getByName("www.baidu.com");
        } catch (UnknownHostException ex) {
            System.exit(2);
        }

        System.out.println(address.getHostName() + " = " + address.getHostAddress());
        //System.exit(0);

        // 0x01. Java 实例 - 查看端口是否已使用
        Socket skt;
        String host = "localhost";
        if (args.length > 0) {
            host = args[0];
        }
        for (int i = 1023; i < 1024; i++) {
            try {
                System.out.println("查看 " + i);
                skt = new Socket(host, i);
                System.out.println("端口 " + i + " 已被使用");
            } catch (UnknownHostException e) {
                System.out.println("UnknownHostException occured" + e);
                break;
            } catch (IOException e) {
                System.out.println("IOException occured" + e);
            }
        }

        // 0x02. Java 实例 - 获取本机ip地址及主机名
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println("Local HostAddress:" + addr.getHostAddress());
        String hostname = addr.getHostName();
        System.out.println("Local host name: " + hostname);

        // 0x03. Java 实例 - 获取远程文件大小
        URL url = new URL("http://www.runoob.com/wp-content/themes/runoob/assets/img/newlogo.png");
        URLConnection conn = url.openConnection();
        conn.setUseCaches(false);
        int size = conn.getContentLength();
        if (size < 0)
            System.out.println("无法获取文件大小。");
        else
            System.out.println("文件大小为：" + size + " bytes");

        // 0x04. Java 实例 - 查看主机指定文件的最后修改时间
        System.out.println("newlogo.png 文件最后修改时间 :" + conn.getLastModified());

        conn.getInputStream().close();

        // 0x05. Java 实例 - 使用 Socket 连接到指定主机
        try {
            Socket sock = new Socket("www.runoob.com", 80);
            System.out.println("连接到 " + sock.getInetAddress());
            sock.close();
        } catch (java.io.IOException e) {
            System.out.println("无法连接 " + args[0]);
            System.out.println(e);
        }

        // 0x06. Java 实例 - 网页抓取
        url = new URL("http://www.baidu.com/");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        BufferedWriter writer = new BufferedWriter(new FileWriter("data.html"));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            writer.write(line);
            writer.newLine();
        }

        reader.close();
        writer.close();

        // 0x07. Java 实例 - 解析 URL
        url = new URL("http://www.runoob.com/wp-content/themes/runoob/assets/img/newlogo.png");
        System.out.println("URL 是 " + url.toString());
        System.out.println("协议是 " + url.getProtocol());
        System.out.println("文件名是 " + url.getFile());
        System.out.println("主机是 " + url.getHost());
        System.out.println("路径是 " + url.getPath());
        System.out.println("端口号是 " + url.getPort());
        System.out.println("默认端口号是 " + url.getDefaultPort());
    }
}
