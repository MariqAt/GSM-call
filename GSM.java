package Task2;

public class GSM {

	String model;
	boolean hasSimCard;
	String simMobileNumber;
	int outgoingCallsDuration = 0;
	Call lastIncomingCall;
	Call lastOutgoingCall;

	void insertSimCard (String simMobileNumber) {
		int count = 0;
		for (int i = 0; i < simMobileNumber.length(); i++) {
			if (simMobileNumber.charAt(i) >= '0' && simMobileNumber.charAt(i) <= '9'){
				count++;
			}
		}
		if (simMobileNumber.charAt(0) == '0' && simMobileNumber.charAt(1) == '8' && count == 10) {	
			this.hasSimCard = true;
			this.simMobileNumber = simMobileNumber;	
		} else {
			System.out.println("Невалиден телефон!");
		}
	}
	
	void removeSimCard () {
		this.hasSimCard = false;
		this.simMobileNumber = null;
	}
	
	void call (GSM receiver, double duration) {
	
		if (duration > 0) {
			if (!(this.equals(receiver))) {
				if (this.hasSimCard && receiver.hasSimCard) {
					Call call = new Call();
					call.duration = duration;
					call.caller = this;
					call.receiver = receiver;
					
					this.lastOutgoingCall = call;
					receiver.lastIncomingCall = call;
					this.outgoingCallsDuration += duration;
				}
			}
		}
	}
	
	double getSumForCall () {
		Call call = new Call();
		return this.outgoingCallsDuration * call.getPriceForAMinute();
		
	}
	
	void printInfoForTheLastOutgoingCall() {
		if (this.lastOutgoingCall != null) {
			System.out.println("Последното изходящо обаждане е към телефон с номер: " + lastOutgoingCall.receiver.simMobileNumber);
			System.out.println("Продължителност на разговора: " + lastOutgoingCall.duration);
			System.out.println("Цена на разговора заминута: " + lastOutgoingCall.getPriceForAMinute());
		} else {
			System.out.println("Няма изходящи обаждания!");
		}
	}
	
	void printInfoForTheLastIncomingCall() {
		if (lastIncomingCall != null) {
			System.out.println("Последното входящо обаждане е от телефон с номер: " + lastIncomingCall.caller.simMobileNumber);
			System.out.println("Продължителност на разговора: " + lastIncomingCall.duration);
			System.out.println("Цена на разговора за минута: " + lastIncomingCall.getPriceForAMinute());
		} else {
			System.out.println("Няма входящи обаждания!");
		}
	}
}
