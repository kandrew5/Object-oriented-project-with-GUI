package Hotel;

public class RoomTypeA extends Room
{
	private double priceperday;
	public double getPriceperday(){return priceperday;}
	public void setPriceperday(double a){priceperday=a;}
	public double pricing()//����� ����������� ��� ������� pricing ��� ���������� �� ����� �� �� price per day
	{
		int sum=0;
		for(Reservation res : pd)
		{
			if(res==null)
			{
				sum+=0;
			}
			else
			{
				sum+=priceperday;		
			}
		}	
		return sum;
	}	
		
}