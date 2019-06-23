package Hotel;

import java.util.*;

public class Hotel 
{
	Reservation d=null;
	Room c=null;
	String hotel_name;
	public void setHotelname(String s){hotel_name=s;}
	public String getHotelname(){return hotel_name;}
	ArrayList<Room> room_list = new ArrayList<Room>();//����� ��������
	ArrayList<Reservation> res_list = new ArrayList<Reservation>();//����� ���������
	public void addRooom(Room r)//��������� ��� ������� ���� ����� ��������
	{
		room_list.add(r);
	}
	
	public Room findRoom(int roomID)//������� �� ������ �������� ��� ���������� �� �������
	{
		for(Room ak : room_list)
		{
			if(ak.getRoomNumber() == roomID)
			{
				c=ak;
				break;
			}
			else
			{
				c=null;
			}
				
		}
		return c;
	}
	public Reservation findReservation(int resID)//������� �� ������ �������� ��� ���������� ��� �������
	{
		for(Reservation pt : res_list)
		{
			if(pt.getRescode() == resID)
			{
				d=pt;
				break;
			}
			else
			{
				d=null;
			}
		}
		return d;
	}
	
	public boolean checkAddRes(Reservation res1, int roomcode)//������� ��� ������� ��� ��� ������ �������� ��� ������������� ��� ������� ��� ���������� �� ���������� ������������
	{
		boolean q=true;
		if(findRoom(roomcode)!=null)
		{
			if(findRoom(roomcode).add_res(res1))
			{
				res_list.add(res1);
				q = true;
			}
			else
			{
				res1.setRoom(null);
				q = false;
			}
		}

		if(q==true)
		{
			System.out.println("The reservation was successful(reservation code is: " + res1.getRescode() + ")");
		}
		else
		{
			System.out.println("The reservation was not successful");
		}
		resissuccessful = q;
		return q;
	}
	
	public boolean resissuccessful;
	public int addReservation(Reservation res2) //������� ��� ������� ��� ��� ��������� �� ����� ������� ������ �� ���������
	{
		int p=0;
		boolean v=true;
		for(int i=0;i<room_list.size();i++)
		{
			res2.setRoom(room_list.get(i));
			if(res2.room.add_res(res2))
			{
				res_list.add(res2);
				System.out.println("The reservation was successful(reservation code is: " + res2.getRescode() +")");
				System.out.println("Roomcode for this reservation is " + res2.room.getRoomNumber());
				v=true;
				for(i=res2.getArrival(); i<res2.getArrival()+res2.getResdays();i++)
				{
					res2.getRoom().pd[i]= res2;
				}
				p=res2.room.getRoomNumber();
				break;
			}
			else
			{
				p=0;
				v=false;
			}
			
		}
		if(v==false)
		{
			System.out.println("The reservation was not successful");
			res2.setRoom(null);
		}
		resissuccessful=v;
		return p;
	}
	
	boolean resiscanceled;
	public void reservationCancel(int reservationID) //������� ��� ������ ��� �������� ��� �� ������� ��� ����� ���������, ��� ��������
	{
		try
		{
		if(findReservation(reservationID) != null)
		{
			
			try
			{
				if(findReservation(reservationID).room.cancel(reservationID) && d.room.cancel(reservationID))
				{
					res_list.remove(d);	
					System.out.println("The reservation with reservation code " + reservationID + " was canceled");
					resiscanceled = true;
				}
				else
				{
					System.out.println("The reservation with reservation code " + reservationID + "was not canceled");
					resiscanceled=false;
				}
				d.room.cancel(reservationID);				
				
					
			}	
		catch(NullPointerException i){}
		}
		else
		{
			System.out.println("The reservation with reservation code " + reservationID + "was not canceled");
			resiscanceled = false;
		}
		}
		catch(ArrayIndexOutOfBoundsException n){}
	}
	public double incomeCalc(int roomNum1) //������� ������ �������� ��� ���������� �� �����
	{
		findRoom(roomNum1);
		return c.pricing();
		
	}
	public double incomeCalc()// ���������� �� ����� ���� ��� ��������
	{
		double total=0;
		for(Room rg : room_list)
		{
			total = total + rg.pricing();
		}
		return total;
	}
	public void ResPlan()//��������� �� ����� ���������
	{
		int i;
		System.out.print("���� :\t");
		for(i=1;i<=30;i++)
		{
			System.out.printf("%02d ", i);
		}
		System.out.printf("\n");
		System.out.println("�������");
		for(i=0;i<room_list.size();i++)
		{
			System.out.print(+room_list.get(i).getRoomNumber() +"\t");
			for(Reservation rs : room_list.get(i).pd)
			{
				if(rs!=null)
				{
					System.out.print("*  ");
				}
				else
				{
					System.out.print("_  ");
				}
			}	
			System.out.println("");
		}
	}
}
	
