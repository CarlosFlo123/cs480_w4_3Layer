/*
+-------------------------------------+
| D                                   |
|  int d;                             |
|  +------------------------------+   |
|  | B                            |   |
|  |    int b;                    |   |
|  |  +-----------+  +---------+  |   |
|  |  | A         |  | E       |  |   |
|  |  |   int a   |  |   int e |  |   |
|  |  +-----------+  +---------+  |   |
|  +------------------------------+   |
+-------------------+-----------------+
                    |
                    |
             +------+--------+
             | F             |
             |    int f      |
             +---------------+
Model Implementation Order: AEBDF 
 */

class A{
    private int a;

    private void trace(String s) {
        System.out.println(s);
    }

    public A(int a1){
        this.a = a1;
    }

    public boolean isLargeValue(){
        return this.a > 100;
    }

    public void changeToZero(){
        this.a = 0;
    }

    public void setA(int a1){
        this.a = a1;
    }

    public int getA(){
        return this.a;
    }

    public String toString(){
        return "\nA value: " + this.a;
    }
}

class E{
    private int e;

    private void trace(String s) {
        System.out.println(s);
    }

    public E(int e1){
        this.e = e1;
    }

    public boolean isLargeValue(){
        return this.e > 100;
    }

    public void changeToZero(){
        this.e = 0;
    }

    public void setE(int e1){
        this.e = e1;
    }

    public int getE(){
        return this.e;
    }

    public String toString(){
        return "\nE value: " + this.e;
    }
}

class B{
    private int b;
    private A aObj = new A(0);
    private E eObj = new E(0);

    private void trace(String s) {
        System.out.println(s);
    }

    public B(int b1, int a1, int e1){
        this.b = b1;
        this.aObj.setA(a1);
        this.eObj.setE(e1);
    }

    public boolean isLargeValue(){
        return this.b > 100 && aObj.isLargeValue() && eObj.isLargeValue();
    }

    public void changeToZero(){
        this.b = 0;
    }

    public int getB(){
        return this.b;
    }

    public void setB(int b1){
        this.b = b1;
    }

    public A getAobj(){
        return this.aObj;
    }

    public void setAobj(A aObj1){
        this.aObj = aObj1;
    }

    public E getEobj(){
        return this.eObj;
    }

    public void setEobj(E eObj1){
        this.eObj = eObj1;
    }

    public String toString(){
        return "\nB value: " + this.b + this.aObj.toString() + this.eObj.toString();
    }
}

class D{
    private int d;
    private B bObj = new B(0, 0, 0);  //bc we use get/set at constructor

    private void trace(String s) {
        System.out.println(s);
    }

    public D(int d1, int b1, int a1, int e1){
        this.d = d1;
        this.bObj.setB(b1);
        this.bObj.getAobj().setA(a1);
        this.bObj.getEobj().setE(e1);
    }

    public boolean isLargeValue(){
        return this.d > 100 && aObj.isLargeValue() && eObj.isLargeValue();
    }

    public void changeToZero(){
        this.d = 0;
    }

    public int getD(){
        return this.d;
    }

    public void setD(int d1){
        this.d = d1;
    }

    public B getBobj(){
        return this.bObj;
    }

    public void setBobj(B bObj1){
        this.bObj = bObj1;
    }

    public String toString(){
        return "\nD value: " + this.d + this.bObj.toString();
    }
}

class F extends D{
    private int f;

    private void trace(String s) {
        System.out.println(s);
    }

    public F(int f1, int d1, int b1, int a1, int e1){
        super(d1, b1, a1, e1);
        this.f = f1;
    }

    public boolean isLargeValue(){
        return this.f > 100;
    }

    public void changeToZero(){
        this.f = 0;
    }

    public void setF(int f1){
        this.f = f1;
    }

    public int getF(){
        return this.f;
    }

    public String toString(){
        return "\nF value: " + this.f + super.toString();
    }
}

public class ThreeLayerOOP {
    public static void main(String argv[]) {
        F f = new F(5, 1, 2, 3, 4);
        System.out.println(f);
        System.out.println("\nChanging values...............\n");
        f.getBobj().setB(7);
        f.getBobj().getAobj().setA(6);
        System.out.println(f);
    }
}