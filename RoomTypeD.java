package Hotel;

public class RoomTypeD extends Room
{
	private int PriceofRoomService;
	public int getPriceofRoomService(){ return PriceofRoomService;}
	public void setPriceofRoomService(int a){PriceofRoomService = a;}
	
		public double pricing()//το δωματιο αυτο εχει επιπλεον χρεωση γιατι εχει room service
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
			if(sum==0)
			{
				return 0;
			}
			else
			{
				return sum + this.getPriceofRoomService();
			}	
		} 
}
