package parallel;

public class PageManager {
	
	
	static PageManager pm= new PageManager();
	
	private PageManager() {
		
	}
	
	public static PageManager getInstance() {
		
		return pm;
		
	}
	
	
	
	

}
