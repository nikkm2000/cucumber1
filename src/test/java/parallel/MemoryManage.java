package parallel;

public class MemoryManage {
	
	

	public static void main(String[] args) {
		
		String s= "I am nikhil";
		String output= "nikhil am I";
		
		String s1[]= s.split(" ");
		for(int i=s1.length-1; i>=0; i--) {
			System.out.print(s1[i]+ " ");
		}
		
		
// ==--------------refrence check
//		equals()-----content verify
		
		
		
	}

}
