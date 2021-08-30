abstract class Vehicle{
   int num_tyres;
    int gear;
    int speed;
    int color;
    public Vehicle(){
        System.out.println("From base");
    }
    //method declared final cannot be overridden
    public Vehicle(int num_tyres,int gear,int speed,int color){
        this.num_tyres=num_tyres;
        this.gear=gear;
        this.speed=speed;
        this.color=color;
        

    }
    abstract   void applyBreak(int decrement);
     abstract void accelerate(int increment);
}
//declaring a class final prevents inheritence 
// cannot declare both final and abstract for a class
class Bicycle extends Vehicle{
    public int seatHeight;
    public Bicycle(){
        System.out.println("From child");
    }
    public Bicycle(int num_tyres,int gear,int speed,int color,int seatHeight){
        
        super(num_tyres,gear,speed,color);
        //System.out.println("From child");

        
        this.seatHeight=seatHeight;
    }
    //overriding
    public void applyBreak(int decrement){
        decrement++;
        speed-=decrement;
    }
    //overloading
    public void applyBreak(int decrement,int time){
        decrement=decrement*time;
        speed-=decrement;
    }
    void accelerate(int increment){
        speed+=increment;
    }
}
class Main{
    public static void main(String args[]){
        //order of execution of constructors
        //Bicycle b=new Bicycle();
        
        //System.out.println(b instanceof Vehicle);
        Bicycle b=new Bicycle(2,1,20,2,5);
        
        
        Vehicle v ;//=new Vehicle();   
        //A Superclass Variable Can Reference a Subclass Object
        v=b;
       // Dynamic Method Dispatch
        v.applyBreak(5);
        //v.applyBreak(5,2);   --Error;
         

        System.out.println(v.speed);

    }
}






abstract class Vehicle{
   int num_tyres;
    int gear;
    int speed;
    int color;
    public Vehicle(){
        System.out.println("From base");
    }
    //method declared final cannot be overridden
    public Vehicle(int num_tyres,int gear,int speed,int color){
        this.num_tyres=num_tyres;
        this.gear=gear;
        this.speed=speed;
        this.color=color;
        

    }
    public void applyBreak(int decrement){
        speed-=decrement;
    }
    abstract void accelerate(int increment);
}
//declaring a class final prevents inheritence 
// cannot declare both final and abstract for a class
class Bicycle extends Vehicle{
    public int seatHeight;
    public Bicycle(){
        System.out.println("From child");
    }
    public Bicycle(int num_tyres,int gear,int speed,int color,int seatHeight){
        
        super(num_tyres,gear,speed,color);
        //System.out.println("From child");

        super.color=color;
        this.seatHeight=seatHeight;
    }
    //overriding
    public void applyBreak(int decrement){
        decrement++;
        speed-=decrement;
    }
    //overloading
    public void applyBreak(int decrement,int time){
        decrement=decrement*time;
        speed-=decrement;
    }
    void accelerate(int increment){
        speed+=increment;
    }
}
class Main{
    public static void main(String args[]){
        //order of execution of constructors
        //Bicycle b=new Bicycle();
        Bicycle b=new Bicycle(2,1,20,2,5);
        Vehicle v ;  //=new Vehicle(); --cannot instansiate abstract class;
        //A Superclass Variable Can Reference a Subclass Object
        v=b;
       // Dynamic Method Dispatch
        v.applyBreak(5);
        //v.applyBreak(5,2); --Error;
        System.out.println(b instanceof Vehicle);

        System.out.println(v.speed);

    }
}

