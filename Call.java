package Task2;

public class Call {

	private double priceForAMinute = 0.11;
	GSM caller;
	GSM receiver;
	double duration = 0;
	
	
	void setPriceForAMinute (double priceForAMinute) {
		if (priceForAMinute > 0) {
			this.priceForAMinute = priceForAMinute;
		}
	}
	
	public double getPriceForAMinute() {
		return priceForAMinute;
	}
	
	
}
