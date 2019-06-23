package Hotel;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;


public class Main {
	
public static void main(String[] args)
{
	
	
	int k=0;
	int n;
	int m;
	int nun = -1;
	int a;
	int fl;
	
	//τυχαια ονοματα για τις τυχαιες κρατησεις
		String[] fnames = new String[20];
		
	fnames[0]="Emma ";fnames[1]="Olivia ";
	fnames[2]="Sophia ";fnames[3]="Ava ";fnames[4]="Isabel ";
	fnames[5]="Mia ";fnames[6]="Emily ";fnames[7]="Anna ";fnames[8]="Alex ";
	fnames[9]="Harper ";fnames[10]="Noah ";fnames[11]="Kayne ";fnames[12]="Liam ";
	fnames[13]="Jacob ";fnames[14]="Ethan ";fnames[15]="Geo ";fnames[16]="Umar ";
	fnames[17]="John ";fnames[18]="Zeus ";fnames[19]="Panos ";

		
	String[] lnames = new String[20];
	lnames[0]="Smith";lnames[1]="Johnson";lnames[2]="Williams";
	lnames[3]="Jones";lnames[4]="Brown";lnames[5]="Davis";
	lnames[6]="Miller";lnames[7]="Wilson";lnames[8]="Moore";
	lnames[9]="Taylor";lnames[10]="Andreson";lnames[11]="Jackson";
	lnames[12]="Lewis";lnames[13]="Thompson";lnames[14]="Garcia";
	lnames[15]="Ali  ";lnames[16]="Clark";lnames[17]="Chang";
	lnames[18]="Obama";lnames[19]="North";
		
	Random rand = new Random();//random number generator
	

	Hotel hotel1 = new Hotel();
	hotel1.setHotelname("Kappa Hotel");
	//φτιαχνουμε 10 δωματια απο ολους τους τυπους και τα προσθετουμε στο room list
	RoomTypeA roomA1 = new RoomTypeA();
	roomA1.setMaxPeople(3);
	roomA1.setPriceperday(45);
	hotel1.addRooom(roomA1);
	
	RoomTypeB roomB1 = new RoomTypeB();
	roomB1.setMaxPeople(4);
	roomB1.setPriceperday(47);
	roomB1.setDiscountperday(10);
	hotel1.addRooom(roomB1);
	
	RoomTypeC roomC1 = new RoomTypeC();
	roomC1.setMaxPeople(5);
	roomC1.setPriceperPerson(22);
	roomC1.setMinDays(2);
	roomC1.setMinPeople(2);
	hotel1.addRooom(roomC1);
	
	RoomTypeD roomD1 = new RoomTypeD();
	roomD1.setMaxPeople(3);
	roomD1.setPriceperPerson(21);
	roomD1.setPriceofRoomService(15);
	hotel1.addRooom(roomD1);
	
	RoomTypeE roomE1 = new RoomTypeE();
	roomE1.setMaxPeople(6);
	roomE1.setPriceperPerson(18);
	hotel1.addRooom(roomE1);
	
	RoomTypeA roomA2 = new RoomTypeA();
	roomA2.setMaxPeople(2);
	roomA2.setPriceperday(90);
	hotel1.addRooom(roomA2);
	
	RoomTypeB roomB2 = new RoomTypeB();
	roomB2.setMaxPeople(3);
	roomB2.setPriceperday(49);
	roomB2.setDiscountperday(15);
	hotel1.addRooom(roomB2);
	
	RoomTypeC roomC2 = new RoomTypeC();
	roomC2.setMaxPeople(4);
	roomC2.setPriceperPerson(19);
	roomC2.setMinDays(3);
	roomC2.setMinPeople(3);
	hotel1.addRooom(roomC2);
	
	Room room1 = new Room();
	room1.setMaxPeople(5);
	room1.setPriceperPerson(23);
	hotel1.addRooom(room1);
	
	Room room2 = new Room();
	room2.setMaxPeople(2);
	room2.setPriceperPerson(15);
	hotel1.addRooom(room2);
	
	for(int i=0; ; i++)
	{
		while(k==0)
		{
			//δημιουργια τυχαιας κρατησης σε τυχαιο ονομα απο τα παραπανω 
			Reservation reservation = new Reservation();
			n=rand.nextInt(fnames.length);
			m=rand.nextInt(lnames.length);
			reservation.setCustomer(fnames[n].concat(lnames[m]));
			reservation.setArrival(rand.nextInt(30));
			reservation.setResdays(rand.nextInt(31-reservation.getArrival()));
			reservation.setPeople(rand.nextInt(6) + 1);
			hotel1.addReservation(reservation);
						
			
			int random_cancel=rand.nextInt(3);//25% πιθανοτητα να κανει cancel καποια τυχαια κρατηση
			if(random_cancel==1)
			{
				
				int ad=rand.nextInt(hotel1.res_list.size());
				try
				{
					hotel1.reservationCancel(hotel1.res_list.get(ad).getRescode());
				}
				catch(IndexOutOfBoundsException e)
				{
					ad+=1;
				}
			}
		    k=1;
		}    
		
		System.out.println(" 0.Rerun\n 1.Add reservation\n 2.Cancel reservation\n 3.Show reservations\n 4.Show rooms\n 5.Show Reservation Plan\n 6.Show Income\n 7.Exit ");
		System.out.println("Enter 0 to 7");
		Scanner scanner = new Scanner (System.in);
		do//τσεκαρει αν ο αριθμος που δινουμε ειναι 0-7 και αν δεν ειναι ξαναζηταει αριθμο
		{
			nun=-1;
			try
			{
				nun = scanner.nextInt();
			}	
			catch(InputMismatchException sd)
			{
				System.out.println("Selection not available.Please enter a valid number.");
				scanner.nextLine();
			}
			
		}
		while(nun<0);
		if(nun==7)
		{
			break;
		}
		
		switch(nun)
		{
		case 0://γινεται ξανα η τυχαια προσθηκη κρατησης
		{
			k=0;
			break;
		}
		case 1:
		{
			scanner.nextLine();//καθαριζουμε το buffer του scanner  
			Reservation resD = new Reservation();
			System.out.println("Enter customer's first name");
			String s1 = scanner.nextLine();
			while(!s1.matches("[a-zA-Z]+"))//τσεκαρει αν το ονομα που δωσαμε εχει μονο γραμματα
			{
				System.out.println("This is not a valid name");
				s1=scanner.nextLine();
			}
			System.out.println("Enter customer's last name");
			String s2 = scanner.nextLine();
			while(!s2.matches("[a-zA-Z]+"))//τσεκαρει αν το ονομα που δωσαμε εχει μονο γραμματα
			{
				System.out.println("This is not a valid name");
				s2 = scanner.nextLine();
			}
			s1= s1+ " ";
			resD.setCustomer(s1.concat(s2));
			System.out.println("Customer full name is: " +resD.getCustomer());
			do//τσεκαρει αν ο αριθμος που δινουμε ειναι 0-29 και αν δεν ειναι ξαναζηταει αριθμο
			{
				resD.setArrival(-1);
				try
				{
					System.out.println("Enter arrival day");
					resD.setArrival(scanner.nextInt()-1);
				
				}
				catch(InputMismatchException ek)
				{
					System.out.println("Please insert a valid day");
					scanner.nextLine();
				}
			}
			while(resD.getArrival()<0 || resD.getArrival()>=30);
			do//τσεκαρει αν ο αριθμος που δινουμε ειναι 1-30 και αν δεν ειναι ξαναζηταει αριθμο
			{
				try
				{
					System.out.println("How many days would you like to stay?");
					resD.setResdays(scanner.nextInt());
				}
				catch(InputMismatchException ek)
				{
					System.out.println("Please insert a valid number");
				}
				scanner.nextLine();

			}
			while(resD.getResdays()<=0 || resD.getResdays()>30 - resD.getArrival());
			do//τσεκαρει αν ο αριθμος που δινουμε ειναι θετικος και αν δεν ειναι ξαναζηταει αριθμο
			{
				try
				{
					System.out.println("For how many people will the reservation be?");
					resD.setPeople(scanner.nextInt());
				
				}
				catch(InputMismatchException ek)
				{
					System.out.println("Please insert a valid number");
				}
				scanner.nextLine();

			}
			while(resD.getPeople()<=0 || peps>6);
			int test;
			System.out.println("Would you prefer a specific room? Press 1 if you do, or else press any key");
			try//τσεκαρει αν του δινουμε 1 η οτιδηποτε αλλο 
			{
				test=scanner.nextInt();
			}
			catch(InputMismatchException rfd)//αν δεν του δινουμε 1 τοτε το κανει 0
			{
				test=0;
			}
			a=10;
			if(test==1)
			{
				while(a<0 || a>9)
				{
					try//τσεκαρει αν ο αριθμος που δινουμε ειναι 0-9 και αν δεν ειναι ξαναζηταει αριθμο
					{
						System.out.println("Enter room code");  
						a= scanner.nextInt();
					}
					catch(InputMismatchException uyfg)
					{
						System.out.println("Enter valid roomcode from 0-9");
					}
					scanner.nextLine();
				}
				hotel1.checkAddRes(resD, a);
			}	
			else
			{
				hotel1.addReservation(resD);
			}
			break;
		}
		case 2:
		{
			fl=-1;
			while(fl<0)//τσεκαρει αν ο αριθμος που δινουμε ειναι ακεραιος και αν δεν ειναι ξαναζηταει αριθμο
			{
				try
				{
					System.out.println("Enter reservation  code");
					fl=scanner.nextInt();
					hotel1.reservationCancel(fl);
				}
				catch(InputMismatchException uyg)
				{
					System.out.println("Enter valid reservation code");
				}
				scanner.nextLine();
			}
			break;
		}
		case 3:
		{
			System.out.println("Reservation code\tCustomer name\t\t\tRoom code ");
			for(Reservation r : hotel1.res_list)
			{
				System.out.println(r.getRescode() + "\t\t\t" + r.getCustomer() + "\t\t\t" + r.room.getRoomNumber());
			}
			System.out.println();
			break;
		}
		case 4:
		{
			System.out.println("Room code\tCompleteness\tProfit");  
			for(Room r1 : hotel1.room_list)
			{
				System.out.println(r1.getRoomNumber() + "\t\t" + r1.occpercent()+"%" + "\t\t" + r1.pricing());
	
			}
			break;
		}
		case 5:
		{
			hotel1.ResPlan();
			break;
		}
		case 6:
		{
			int z=-1;
			int kl;
			try//τσεκαρει αν του δινουμε 1 η οτιδηποτε αλλο
			{
				System.out.println("Would you like to enter a specific room code? If so press 1 else press any key");
				kl=scanner.nextInt();
			}
			catch(InputMismatchException df)
			{
				kl=0;
			}
			if(kl==1)
			{
				while(z<0 ||z>9)
				{
					try//τσεκαρει αν του δινουμε 0-9 και αν δεν ειναι ξαναζηταει αριθμο
					{
						System.out.println("Enter the code");
						z=scanner.nextInt();
	
					}
					catch(InputMismatchException erx)
					{
						System.out.println("Enter a valid code");
					}
				}
				hotel1.findRoom(z);
				hotel1.c.pricing();
				System.out.println("Profit from this room is:" +hotel1.c.pricing());
			}
			else
			{
				System.out.println("Total profit is:" +hotel1.incomeCalc());	
			}
			break;
		}
		default:
		{
			System.out.println("Selection not available.Please enter a valid number.");
			break;
		}
	}
	}
	
}

}


