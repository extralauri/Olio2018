package oliot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mainclass {
    
    public static void main(String[] args) {
    	
    	String name = "";
    	String say = "";
    	
    	System.out.print("Anna koiralle nimi: ");
    	
    	BufferedReader br = new BufferedReader(
    		    new InputStreamReader(System.in));
    		try {
    		    name = br.readLine();
    		} catch (IOException ex) {
    		}
    	
    	Dog a = new Dog(name);
    	
    	System.out.print("Mitä koira sanoo: ");
    	BufferedReader br1 = new BufferedReader(
    		    new InputStreamReader(System.in));
    		try {
    		    say = br1.readLine();
    		} catch (IOException ex) {
    		}
    	a.speak(say);
    }
}
