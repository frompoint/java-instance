public class Main {

    public static void main(String[] args) {
        Class book1=null;
        Class book2=null;
        Class book3=null;
        //获取Class对象的第一种方法
        try {
            book1=Class.forName("Book");
            System.out.println("book1==>"+book1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //第二种方法
        Book book=new Book();
        Object object=book;
        book2=object.getClass();
        System.out.println("book2==>"+book2);
        //第三种方法
        book3=Book.class;
        System.out.println("book3==>"+book3);
        //接下来使用newInstance方法来创建一个Book对象。
        try {
            Book book4= (Book) book3.newInstance();
            System.out.println("book4==>"+book4);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
