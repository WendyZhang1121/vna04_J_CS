package vna04_J_CS;

public class exampleClientCode {
	
	private volatile USCurrency currency; // ...
	
	public exampleClientCode() {
		Thread t1 = new Thread(new Runnable() { 
			@Override public void run() {
			currency = USCurrency.Builder.newInstance().
					setQuarters(1).setDimes(1).build();
			} 
		});
		
	t1.start();
	
		Thread t2 = new Thread(new Runnable() {
			@Override public void run() {
			currency = USCurrency.Builder.newInstance().
					setQuarters(2).setDimes(2).build();
	    } 
	});
		
	t2.start();
	//... 
	}
	
	public static void main(String[] args) throws Exception {
		
		exampleClientCode test = new exampleClientCode();
	}
}
