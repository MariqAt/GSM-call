package Task2;

public class DemoCall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GSM telefon1 = new GSM();
		telefon1.model = "Iphone";
		telefon1.insertSimCard("0885 45 46 47");
		
		GSM telefon2 = new GSM();
		telefon2.insertSimCard("0887859535");
		
		telefon1.call(telefon2, 45);
		
		System.out.println("���� �������������� �� �������� ��������� ���� ��������: " + telefon1.outgoingCallsDuration);
		System.out.println("����������������� �� ��������� �: " + telefon1.outgoingCallsDuration + " ������");
		
		System.out.println("������ �� ����������� ��������� �: " + telefon1.getSumForCall());
		telefon1.printInfoForTheLastOutgoingCall();
		telefon1.printInfoForTheLastIncomingCall();
		System.out.println();
		telefon2.printInfoForTheLastOutgoingCall();
		telefon2.printInfoForTheLastIncomingCall();
		
	}

}
