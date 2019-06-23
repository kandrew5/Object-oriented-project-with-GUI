package Hotel;
 
public class RoomTypeC extends Room
{
	private int minpeople;
	private int mindays;
	
	public int getMinPeople(){ return minpeople;}
	public void setMinPeople(int a){minpeople = a;}
	public int getMinDays(){return mindays;}
	public void setMinDays(int b){mindays=b;}
	private boolean b;
	
	public boolean add_res(Reservation res)//υπερκαληψη της add_res(πλεον ελεγχει και αν τα ατομα και οι ημερες ξεπερνανε το minimum του δωματιου
	{
		for(i=res.getArrival(); i<res.getArrival()+res.getResdays();i++)
		{
			if(pd[i]==null && res.getPeople()<=this.getMaxPeople() && res.getPeople()>=getMinPeople() && res.getResdays()>=getMinDays())
			{
				res.setRoom(this);
				for(i=res.getArrival(); i<res.getArrival()+res.getResdays();i++)
				{
					pd[i]= res;
				}
				b=true;
			}	
			else
			{
				b=false;
			}	
		}
		return b;
	}
}

