package Hotel;

import java.util.concurrent.atomic.*;

public class Reservation
{
	private String customer;
	private int rescode;
	private int arrival;
	private int resdays;
	private int people;
	private static AtomicInteger code = new AtomicInteger(-9);//������� -9 ����� ���� main ���������� ����� 10 �������, ����� � �������� ������� �� ���� �� 10
	Room room;
	
	public int getRescode(){return rescode;}
	public String getCustomer(){return customer;}
	public void setCustomer(String a){customer=a;} 
	public int getArrival(){return arrival;}
	public void setArrival(int a){arrival=a;}
	public int getResdays(){return resdays;}
	public void setResdays(int b){resdays=b;}
	public int getPeople(){return people;}
	public void setPeople(int c){people=c;}
	public Room getRoom(){return room;}
	
	public Reservation()//constructor ��� ����������� ��� ���� ����������� �� ���� ����������� reservation code
	{
		this.room=null;
		rescode= code.getAndIncrement();
	}
	public void setRoom(Room nroom)//������ room ��� �� reservation
	{
		this.room=nroom;
	}
}
