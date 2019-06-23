package Hotel;

public class RoomTypeE extends Room
{
	private boolean h;
	
	public boolean add_res(Reservation res)//γινεται υπερκαλυψη της add_res(αν η ημερα που φτανει ειναι 15 να μη γινει η κρατηση
	{
		for(i=res.getArrival(); i<res.getArrival()+res.getResdays();i++)
		{
			if(pd[i]==null && res.getPeople()<=this.getMaxPeople() && res.getArrival()!=15)
			{
				res.setRoom(this);
				for(i=res.getArrival(); i<res.getArrival()+res.getResdays();i++)
				{
					pd[i]= res;
				}
				h=true;
			}	
			else
			{
				h=false;
			}
		}
		return h;
	}
}