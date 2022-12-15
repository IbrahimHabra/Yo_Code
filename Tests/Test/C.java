package Test;

public class C implements A{

    @Override
    public void print() {
        System.out.println("Hello world");
    }

    @Override
    public double add(int a,int b) {
        return a+b;
    }
}
