//  a list of type parameters, inside angle brackets

//  class Cmp {
//     public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
//         return p1.getKey().equals(p2.getKey()) &&
//                p1.getValue().equals(p2.getValue());
//     }
// }
class Cmp {
    public static <K extends Comparable<K> , V extends Comparable<V> > boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
               p1.getValue().equals(p2.getValue());
    }
}

 class Pair<K, V> {

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) { this.key = key; }
    public void setValue(V value) { this.value = value; }
    public K getKey()   { return key; }
    public V getValue() { return value; }
}

public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> p1 = new Pair<>(1, "apple");
        Pair<Integer, String> p2 = new Pair<>(2, "pear");
        
        System.out.println("two pairs are same    "+Cmp.<Integer, String>compare(p1, p2));
    }
}




// t isIn( ) can be used only with objects that are capable of
// being compared.
// Comparable gneric interface in java.lang

class GenMethDemo {
    static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
        for(int i=0; i < y.length; i++)
            if(x.equals(y[i])) return true;
        return false;
    }
    public static void main(String args[]) {
        
        Integer nums[] = { 1, 2, 3, 4, 5 };
        if(isIn(2, nums))
            System.out.println("2 is in nums");
        if(!isIn(7, nums))
            System.out.println("7 is not in nums");
        System.out.println();
        String strs[] = { "one", "two", "three","four", "five" };
        if(isIn("two", strs))
            System.out.println("two is in strs");
        if(!isIn("seven", strs))
            System.out.println("seven is not in strs");
        
    }
}





class GenCon {
    private double val;
    <T extends Number> GenCon(T arg) {
        val = arg.doubleValue();
    }
    void getVal() {
        System.out.println("val: " + val);
    }
}
class Main {
    public static void main(String args[]) {
        GenCon c1 = new GenCon(100);
        GenCon c2 = new GenCon(123.5F);
        c1.getVal();
        c2.getVal();
    }
}




interface MinMax<T extends Comparable<T>> {
    T min();
    T max();
}
// T is declared by Arr and then passed to MinMax
//the implementing class  must specify the same bound.
// class Arr<T extends Comparable<T>> implements MinMax<T extends Comparable<T> >
class Arr<T extends Comparable<T>> implements MinMax<T> {
    T[] vals;
    Arr(T[] vals) {
        this.vals = vals; 
    }
    public T min() {
        T v = vals[0];
        for(int i=1; i < vals.length; i++)
            if(vals[i].compareTo(v) < 0) v = vals[i];
        return v;
    }
    public T max() {
        T v = vals[0];
        for(int i=1; i < vals.length; i++)
            if(vals[i].compareTo(v) > 0) v = vals[i];
        return v;
    }
}
class Main {
    public static void main(String args[]) {
        Integer inums[] = {3, 6, 2, 8, 6 };
        Character chs[] = {'b', 'r', 'p', 'w' };
        Arr<Integer> iob = new Arr<Integer>(inums);
         Arr<Character> cob = new Arr<Character>(chs);
        System.out.println("Max value in inums: " + iob.max());
        System.out.println("Min value in inums: " + iob.min());
        System.out.println("Max value in chs: " + cob.max());
        System.out.println("Min value in chs: " + cob.min());
    }
}




class Gen<T> {
    T obj;
    Gen(T o) {
        obj = o;
    }
    T getob() {
        return obj;
    }
}
class NonGen {
    int num;
    NonGen(int i) {
        num = i;
    }
    int getnum() {
        return num;
    }
}
class NonGen2<T> extends NonGen{
    T obj; 
    NonGen2(T o, int i) {
        super(i);
        obj = o;
    }
    T getob() {
        return ob;
    }
}
class Gen2<T1, V> extends Gen<T1> {
    V ob2;
    Gen2(T1 o, V o2) {
        super(o);
        ob2 = o2;
    }
    V getob2() {
        return ob2;
    }
}

public class Main {
    public static void main(String[] args) {
        Gen2<String, Integer> x = new Gen2<>("Value is: ", 99);
        System.out.print(x.getob());
        System.out.println(x.getob2());
       // System.out.println("Hello World!");
    }
}



// "static void main" must be defined in a public class.

class Gen<T> {
    T obj;
    Gen(T o) {
        obj = o;
    }
    T getob() {
        return obj;
    }
}

class Gen2<T1, V> extends Gen<T1> {
    V ob2;
    Gen2(T1 o, V o2) {
        super(o);
        ob2 = o2;
    }
    // T1 getob() { 
    //      System.out.println("Gen2's getob(): ");
    //      return obj;
    //  }
    
    V getob2() {
        return ob2;
    }
}

class NonGen {
    int num;
    NonGen(int i) {
        num = i;
    }
    int getnum() {
        return num;
    }
}
class NonGen2<T> extends NonGen{
    T obj; 
    NonGen2(T o, int i) {
        super(i);
        obj = o;
    }
    T getob() {
        return obj;
    }
}

public class Main {
    public static void main(String[] args) {
        Gen2<String, Integer> x = new Gen2<>("Value is: ", 99);
        System.out.print(x.getob());
        System.out.println(x.getob2());
        
        System.out.println("x is instance of Gen2    "+ (x instanceof Gen2<?,?> ));
        System.out.println("x is instance of Gen    "+ (x instanceof Gen<?> ));
       // System.out.println("Hello World!");
        
        NonGen2<String> w = new NonGen2<String>("Hello", 47);
        System.out.print(w.getob() + " ");
        System.out.println(w.getnum());
        
        System.out.println("w is instance of NonGen2    "+ (w instanceof NonGen2<?> ));
        System.out.println("w is instance of NonGen    "+ (w instanceof NonGen));
    }
}

