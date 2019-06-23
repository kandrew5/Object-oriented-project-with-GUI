package Hotel;

public class RoomTypeA extends Room
{
	private double priceperday;
	public double getPriceperday(){return priceperday;}
	public void setPriceperday(double a){priceperday=a;}
	public double pricing()//κανει υπεροκαλυψη της μεθοδου pricing και υπολογιζει τα εσοδα με το price per day
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