import java.io.*;

public class Foo implements Serializable {
    private int a;
    private int b;


    public void setB(int b) {
        this.b = b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.setA(5);
        foo.setB(15);

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\dev\\files\\Foo.ser"));
            os.writeObject(foo);
            os.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        foo = null;


        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("C:\\dev\\files\\Foo.ser"));
            Foo fooRestore = (Foo) is.readObject();
            System.out.println(fooRestore.getA());
            System.out.println(fooRestore.getB());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}