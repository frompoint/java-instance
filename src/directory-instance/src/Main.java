import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // 0x00. Java 实例 - 递归创建目录
        String directories = "D:\\a\\b\\c\\d\\e\\f\\g\\h\\i";
        File file = new File(directories);
        boolean result = file.mkdirs();
        System.out.println("Status = " + result);

        // 0x01. Java 实例 - 删除目录
        deleteDir(new File("D:\\dist"));

        // 0x02. Java 实例 - 判断目录是否为空
        if (file.isDirectory()) {
            if (file.list().length > 0) {
                System.out.println("目录不为空!");
            } else {
                System.out.println("目录为空!");
            }
        } else {
            System.out.println("这不是一个目录!");
        }

        // 0x03. Java 实例 - 判断文件是否隐藏
        System.out.println(file.isHidden());

        // 0x04. Java 实例 - 获取目录大小
        System.out.println(FileUtils.sizeOfDirectory(file));

        // 0x05. Java 实例 - 获取文件的上级目录
        System.out.println("文件的上级目录为 : " + file.getParent());

        // 0x06. Java 实例 - 获取目录最后修改时间
        System.out.println(file.lastModified());

        // 0x07. Java 实例 - 打印目录结构
        showDir(1, new File("D:\\appservice"));

        // 0x08. Java 实例 - 在指定目录中查找文件
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept
                    (File dir, String name) {
                return name.startsWith("c");
            }
        };
        String[] children = new File("D:\\appservice\\service.config").list(filter);
        if (children == null || children.length < 1) {
            System.out.println("目录不存在或它不是一个目录");
        } else {
            for (int i = 0; i < children.length; i++) {
                String filename = children[i];
                System.out.println(filename);
            }
        }

        // 0x09. Java 实例 - 查看系统根目录
        File[] roots = File.listRoots();
        System.out.println("系统所有根目录：");
        for (int i=0; i < roots.length; i++) {
            System.out.println(roots[i].toString());
        }

        // 0x0a. Java 实例 - 查看当前工作目录
        String curDir = System.getProperty("user.dir");
        System.out.println("你当前的工作目录为 :" + curDir);
    }

    public static void showDir(int indent, File file) throws IOException {
        for (int i = 0; i < indent; i++) {
            System.out.print("-");
        }
        System.out.println(file.getName());

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                showDir(indent + 4, files[i]);
            }
        }
    }

    public static boolean deleteDir(File file) {
        if (file.isDirectory()) {
            String[] files = file.list();
            for (String path : files) {
                boolean success = deleteDir(new File(file, path));
                if (!success) {
                    return false;
                }
            }
        }
        if (file.delete()) {
            System.out.println("目录已被删除！");
            return true;
        } else {
            System.out.println("目录删除失败！");
            return false;
        }
    }
}
