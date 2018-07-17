public class Book {
    private int id;
    private String name;
    private String type;

    public Book() {
    }

    public Book(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void test(String msg, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(msg);
        }
    }
}