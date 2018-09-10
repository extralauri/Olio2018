package oliot;

public class Dog {
	
	private String name;
    
    public Dog(String n) {
		System.out.println("Hei, nimeni on " + n + "!");
		name = n;
    }
    
    public void speak(String s) {
		System.out.println(name + ": " +s);
    }
}