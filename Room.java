package Hotel;

import java.util.concurrent.atomic.*;

public class Room extends Reservation
{
	private int roomNumber;
	private int maxpeople;
	private double priceperperson;
	int i;
	Reservation pd[] = new Reservation[30];//������� �������������� ���������
	private static AtomicInteger roomcode = new AtomicInteger();

	public Room()//constructor ��� ����������� ����������� roomNumber ��� ���� ����������� 
	{
		roomNumber= roomcode.getAndIncrement();
	}
	
	public int getRoomNumber(){return roomNumber;}
	public int getMaxPeople(){return maxpeople;}
	public void setMaxPeople(int a){maxpeople=a;}
	public double getPriceperPerson(){return priceperperson;}
	public void setPriceperPerson(int b){priceperperson=b;}
	
	
	public boolean add_res(Reservation res)//�� ����� ����� �� ����������� ��� ������ �� ����� ���� ��������� ��� ������� ���� ����� ���������
	{
		boolean a=true;
		for(i=res.getArrival(); i<res.getArrival()+res.getResdays();i++)
			{
				if(pd[i]!=null)
					{
						a=false;
						break;
					}
				else
					{
						a=true;
					}
			}
		if(res.getPeople()<=this.getMaxPeople() && a)
			{
				for(i=res.getArrival(); i<res.getArrival()+res.getResdays();i++)
					{
						pd[i]= res;
					}
				res.setRoom(this);
				return true;
			}
		else
		{
			res.setRoom(null);
			return false;
		}
	}
	
	public double pricing()//���������� �� �������� ������ ���� �������� ��� ���� ��� ���������
		{
		    double sum=0;
		    double price;
			for(Reservation r : pd)
			{
				if(r==null)
				{
					price=0;
				}
				else
				{
				    price = r.getPeople() *this.getPriceperPerson();
					sum= sum + price;
				}
			}
			return sum;
		}
	public boolean cancel(int cd)// ������� ��� ������ ��� �������� ��� ��� ������� ��� ��������
	{
		for(int j=0;j<pd.length;j++)
		{
			try
			{
				if(cd==pd[j].getRescode())
				{
					if(pd[j]!=null)
					{
						pd[j]=null;
					}
				}
			}
			catch(NullPointerException e){continue;}
			
		}	
		return true;
	}
	public int occpercent()// ���������� �� ������� ��� ����� ��������� ��� ������� 
	{
		int counter=0;
		for(Reservation r : pd)
		{
			if(r!=null)
			{
				counter+= 1 ;
			}	
		}
		return 100*counter/30;
	}
}