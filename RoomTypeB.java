package Hotel;

public class RoomTypeB extends RoomTypeA 
{
	private int discountperday;
	public int getDiscountperday(){return discountperday;}
	public void setDiscountperday(int a){discountperday=a;}
	public double pricing()//υπερκαλυψη της pricing(εχουμε υπολογισμο του κοστους με αφαιρεση της εκπτωσης)
	{
		double sum=0;
		double amount;
		double cost;
		int o=1;
		for(i=0;i<=pd.length;i+=o)
		{
			try
			{
				if(pd[i]!=null)
				{
					o=pd[i].getResdays();
					amount=this.getPriceperday();
					cost = this.getPriceperday();
					for(int k=1;k<o;k++)
					{
						if(cost>this.getPriceperday()/2)
						{
							cost=cost-this.getDiscountperday();
							amount=amount+cost;
						}
						else
						{
							cost=this.getPriceperday()/2;
							amount=amount+cost;
						}
					}
					sum=+amount;
				}
				else
				{
					o=1;
				}
			}
			catch(ArrayIndexOutOfBoundsException e){}
		}
		return sum;
	}

	public boolean cancel(int cd)//κανει υπερκαλυψη την cancel και δεν επιτρεπει την ακυρωση κρατησης για αυτο τον τυπο δωματιου
	{
			
		return false;
	}
	
	

}