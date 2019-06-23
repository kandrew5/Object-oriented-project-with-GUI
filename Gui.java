package Hotel;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class Gui extends JFrame
{

	private JButton btn_rerun;
	private JButton btn_add_res;
	private JButton btn_cancel_res;
	private JButton btn_show_res;
	private JButton btn_show_rooms;
	private JButton btn_res_plan;
	private JButton btn_show_income;
	private JButton btn_exit;
	private JLabel lbl_name_of_the_hotel;
	private JLabel lbl_hotelmessage;
	
	public Hotel Kappa_hotel = new Hotel();
	
	public void addRooms()
	{

		Kappa_hotel.setHotelname("Kappa Hotel");
		RoomTypeA roomA1 = new RoomTypeA();
		roomA1.setMaxPeople(3);
		roomA1.setPriceperday(45);
		Kappa_hotel.room_list.add(roomA1);
	
		RoomTypeB roomB1 = new RoomTypeB();
		roomB1.setMaxPeople(4);
		roomB1.setPriceperday(47);
		roomB1.setDiscountperday(10);
		Kappa_hotel.room_list.add(roomB1);
		
		RoomTypeC roomC1 = new RoomTypeC();
		roomC1.setMaxPeople(5);
		roomC1.setPriceperPerson(22);
		roomC1.setMinDays(2);
		roomC1.setMinPeople(2);
		Kappa_hotel.room_list.add(roomC1);
		
		RoomTypeD roomD1 = new RoomTypeD();
		roomD1.setMaxPeople(3);
		roomD1.setPriceperPerson(21);
		roomD1.setPriceofRoomService(15);
		Kappa_hotel.room_list.add(roomD1);
		
		RoomTypeE roomE1 = new RoomTypeE();
		roomE1.setMaxPeople(6);
		roomE1.setPriceperPerson(18);
		Kappa_hotel.room_list.add(roomE1);
		
		RoomTypeA roomA2 = new RoomTypeA();
		roomA2.setMaxPeople(2);
		roomA2.setPriceperday(90);
		Kappa_hotel.room_list.add(roomA2);
		
		RoomTypeB roomB2 = new RoomTypeB();
		roomB2.setMaxPeople(3);
		roomB2.setPriceperday(49);
		roomB2.setDiscountperday(15);
		Kappa_hotel.room_list.add(roomB2);
		
		RoomTypeC roomC2 = new RoomTypeC();
		roomC2.setMaxPeople(4);
		roomC2.setPriceperPerson(19);
		roomC2.setMinDays(3);
		roomC2.setMinPeople(3);
		Kappa_hotel.room_list.add(roomC2);
		
		Room room1 = new Room();
		room1.setMaxPeople(5);
		room1.setPriceperPerson(23);
		Kappa_hotel.room_list.add(room1);
		
		Room room2 = new Room();
		room2.setMaxPeople(2);
		room2.setPriceperPerson(15);
		Kappa_hotel.room_list.add(room2);
	}
	
	int n;
	int m;
	int rows;
	String tab = "     ";
	private String[] first_names = new String[20];
	private String[] last_names = new String[20];
	{
	
	first_names[0]="Emma ";	first_names[1]="Olivia "; first_names[2]="Sophia ";
	first_names[3]="Ava "; first_names[4]="Isabel "; first_names[5]="Mia ";	
	first_names[6]="Emily "; first_names[7]="Anna "; first_names[8]="Alex ";
	first_names[9]="Harper "; first_names[10]="Noah "; first_names[11]="Kayne ";
	first_names[12]="Liam " ;first_names[13]="Jacob "; first_names[14]="Ethan ";
	first_names[15]="John "; first_names[16]="Umar ";first_names[17]="John ";
	first_names[18]="Zeus "; first_names[19]="PANARAS ";
	
	last_names[0]="Smith"; last_names[1]="Johnson";	last_names[2]="Williams";
	last_names[3]="Jones"; last_names[4]="Brown"; last_names[5]="Davis";
	last_names[6]="Miller";	last_names[7]="Wilson";	last_names[8]="Moore";
	last_names[9]="Taylor";	last_names[10]="Andreson"; last_names[11]="Jackson";
	last_names[12]="Lewis";	last_names[13]="Thompson"; last_names[14]="Garcia";
	last_names[15]="Ali  ";	last_names[16]="Clark";	last_names[17]="Chang";
	last_names[18]="Obama";	last_names[19]="ARGIANIDIS";
	}
	
	Random rand = new Random();

	
	public Gui()
	{
		setTitle("Options Menu");
		setLayout(null);
		setSize(1024,768);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lbl_name_of_the_hotel = new JLabel("Kappa Hotel Menu");
		lbl_name_of_the_hotel.setBounds(472, 35, 200, 20);
				
		lbl_hotelmessage = new JLabel("What would you like to do?");
		lbl_hotelmessage.setBounds(447, 65, 300, 20);
		
		btn_rerun = new JButton("Rerun");
		btn_rerun.setBounds(337, 120, 350, 40);
		
		btn_add_res = new JButton("Add Reservation");
		btn_add_res.setBounds(70, 215, 300, 55);
		
		btn_cancel_res = new JButton("Cancel Reservation");
		btn_cancel_res.setBounds(654, 215, 300, 55);
		
		btn_show_res = new JButton("Show Reservations");
		btn_show_res.setBounds(70, 330, 300, 40);
		
		btn_show_rooms = new JButton("Show Rooms");
		btn_show_rooms.setBounds(654, 330, 300, 40);
		
		btn_res_plan = new JButton("Show Reservations Plan");
		btn_res_plan.setBounds(362, 435, 300, 40);
		
		btn_show_income = new JButton("Show Income");
		btn_show_income.setBounds(362, 540, 300, 40);
		
		btn_exit = new JButton("Exit");
		btn_exit.setBounds(337, 645, 350, 40);

		add(btn_rerun);add(btn_add_res);add(btn_cancel_res);add(btn_show_res);add(btn_show_rooms);add(btn_res_plan);add(btn_show_income);add(btn_exit);
		add(lbl_name_of_the_hotel);add(lbl_hotelmessage);
				
		
		
		btn_rerun.addActionListener(new ListenToZero());
		btn_add_res.addActionListener(new ListenToOne());
		btn_cancel_res.addActionListener(new ListenToTwo());
		btn_show_res.addActionListener(new ListenToThree());
		btn_show_rooms.addActionListener(new ListenToFour());
		btn_res_plan.addActionListener(new ListenToFive());
		btn_show_income.addActionListener(new ListenToSix());
		btn_exit.addActionListener(new ListenToSeven());
		
		addRooms();
	}
	
	
	private class ListenToZero implements ActionListener
	{
		public void actionPerformed(ActionEvent ae0)
		{							
						
			Reservation reservation1 = new Reservation();
			n=rand.nextInt(first_names.length);
			m=rand.nextInt(last_names.length);
			reservation1.setCustomer(first_names[n].concat(last_names[m]));
			reservation1.setArrival(rand.nextInt(30));
			reservation1.setResdays(rand.nextInt(31-reservation1.getArrival()));
			reservation1.setPeople(rand.nextInt(6) + 1);
			Kappa_hotel.addReservation(reservation1);
			
			String burnermessage="";
			int ad;
			int random_cancel=rand.nextInt(3);//25% πιθανοτητα να κανει cancel καποια τυχαια κρατηση
			if(random_cancel==1)
			{
				
				ad=rand.nextInt(Kappa_hotel.res_list.size());
				
				if(Kappa_hotel.res_list.get(ad).getRoom().getRoomNumber()==1)
					burnermessage = "Reservations in room 1 cannot be canceled (Tried to cancel reservation: "+Kappa_hotel.res_list.get(ad).getRescode() +" )";
				else
					burnermessage = "Reservation with code " + Kappa_hotel.res_list.get(ad).getRescode() +" was canceled";
				
				try
				{
					Kappa_hotel.reservationCancel(Kappa_hotel.res_list.get(ad).getRescode());
				}
				catch(IndexOutOfBoundsException iooe)
				{
					ad+=1;
					System.out.println("Kappa"); 
				}
			} 
			else
			{
				ad=-1;
				burnermessage = "No reservation was canceled";
			}
			
			
			if(Kappa_hotel.resissuccessful)
			{
				try
				{
					JOptionPane.showMessageDialog(null, "Added a reservation to the name :"+reservation1.getCustomer()+ "\nReservation Code is: "+reservation1.getRescode()+"\nThey will be staying at room: "+reservation1.getRoom().getRoomNumber() +"\nArrival Day: " +reservation1.getArrival() +"\nDays of stay: " +reservation1.getResdays() +"\nPeople: "+reservation1.getPeople()+"\n\n"+burnermessage);
				}	
				catch(NullPointerException npe){}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "The reservation was not successful"+"\n\n" +burnermessage);
			}
		}
	}
	
	private class ListenToOne implements ActionListener
	{
		public void actionPerformed(ActionEvent ae1)
		{
			int whileflag=0;
			while(whileflag ==0)
			{
				Reservation nreservation = new Reservation();
			
				String fn = JOptionPane.showInputDialog("Enter customer's first name");
				while(!fn.matches("[a-zA-Z]+"))
				{			
					fn = JOptionPane.showInputDialog("Not a valid name \nPlease enter a valid name \nEnter customer's first name");
				} 
				String ln = JOptionPane.showInputDialog("Enter customer last name");
				while(!ln.matches("[a-zA-Z]+"))
				{
					ln = JOptionPane.showInputDialog("Not a valid name \nPlease enter a valid name \nEnter customer's last name");
				}
				
				if(fn==null || ln == null)
					break;
				
				fn = fn +" ";
				nreservation.setCustomer(fn.concat(ln));
			
				int arr=-1;
				String sn="";
				do
				{
					try
					{
						if(arr>=30)
							sn = JOptionPane.showInputDialog("Please insert a valid arrival day(1 to 30)");					
						else	
							sn = JOptionPane.showInputDialog("Enter arrival day(1 to 30)");
					
						arr = Integer.parseInt(sn);
					}	
					catch(NumberFormatException nfe)
					{
						if(sn==null)
							break;						
						else	
						{
							JOptionPane.showMessageDialog(null, "Please insert a valid arrival day(1 to 30)");
							
						}
					}
				}while(arr<=0 || arr>=30);
				if(sn==null)
					break;
				nreservation.setArrival(arr-1);
			
				int show = 31-arr;
				String thn ="" ;
				int days=-1;
				do
				{
					try
					{
						if(days>show)
							thn = JOptionPane.showInputDialog("Please insert a valid number(1 to " +show +")" );
						else
							thn = JOptionPane.showInputDialog("How many days would you like to stay?(1 to " +show +")");
					
						days = Integer.parseInt(thn);
					}
					catch(NumberFormatException nfe)
					{
						if(thn == null)
							break;
						else
						{	
							JOptionPane.showMessageDialog(null,"Please insert a valid number(1 to " +show +")" );							
							
						}
					}
				}while(days<=0 || days>show);
				if(thn == null)
					break;
				nreservation.setResdays(days);
			
				String fon="";
				int ppl=-1;
				do
				{
					try
					{
						if(ppl>6)
							fon = JOptionPane.showInputDialog("Please ensert a valid number of people(1 to 6)");
						else
							fon = JOptionPane.showInputDialog("For how many people will the reservation be?(0-6)");
						ppl = Integer.parseInt(fon);
					}
					catch(NumberFormatException nfe)
					{
						if(fon==null)
							break;
						else
						{
							JOptionPane.showMessageDialog(null,"Please ensert a valid number of people(1 to 6)");
						}
					}
				}while(ppl<=0 || ppl>6);
				if(fon==null)
					break;
				nreservation.setPeople(ppl);
			
				String fifn ="";
				int flag;
				fifn = JOptionPane.showInputDialog("Would you prefer a specific room? Press 1 if you do, or else press any key");
				try
				{
					flag = Integer.parseInt(fifn);
				}
				catch(NumberFormatException nfe)
				{
					flag =0;
				}
				if(fifn==null)
					break;
			
				int ID=-1;
				String sixn="";
				if(flag ==1)
				{
					do
					{
						try
						{
							if(ID>9)
								sixn = JOptionPane.showInputDialog("Please enter a room code from 0 to 9");
							else
								sixn = JOptionPane.showInputDialog("Enter room code(0-9)");
							ID = Integer.parseInt(sixn);
						}
						catch(NumberFormatException nfe)
						{
							if(sixn==null)
								break;
							else
							{
								JOptionPane.showMessageDialog(null,"Please enter a room code from 0 to 9");
								
							}
						}
					}while(ID<0 || ID>9);
					if(sixn==null)
						break;
					Kappa_hotel.checkAddRes(nreservation, ID);
				}
				else
				{
					Kappa_hotel.addReservation(nreservation);
				}
			
				if(Kappa_hotel.resissuccessful)				
					JOptionPane.showMessageDialog(null, "Added a reservation to the name :"+nreservation.getCustomer()+ "\nReservation Code is: "+nreservation.getRescode()+"\nThey will be staying at room: "+nreservation.getRoom().getRoomNumber() +"\nArrival Day: " +nreservation.getArrival() +"\nDays of stay: " +nreservation.getResdays() +"\nPeople: "+nreservation.getPeople());
				else
					JOptionPane.showMessageDialog(null, "Couldn't add a reservation with the given characteristics");
				
				whileflag=1;//used to end the first while loop
			}//end first while loop
		}
	}

	private class ListenToTwo implements ActionListener
	{
		public void actionPerformed(ActionEvent ae2)
		{
			int loopflag =0;
			while(loopflag==0)
			{
				int add=-1;
				String cdd="";
				do
				{	
					try
					{
						if(add>0 && Kappa_hotel.findReservation(add)==null)
							cdd = JOptionPane.showInputDialog("Wrong reservation code  \nIf you are not sure of a number then press cancel and go to option show reservations \nReminder:Reservations in room 1 cannot be canceled");
						else
							cdd = JOptionPane.showInputDialog("Enter the reservation code of the reservation you want to cancel");
						
						add = Integer.parseInt(cdd);
					}
					catch(NumberFormatException nfe)
					{
						if(cdd==null)
							break;
					
						JOptionPane.showMessageDialog(null,"Wrong reservation code  \nIf you are not sure of a number then press cancel and go to option show reservations");
					}
				}while(add <0 || Kappa_hotel.findReservation(add)==null);
				if(cdd==null)
					break;
			
					Kappa_hotel.reservationCancel(add);
			
					if(Kappa_hotel.resiscanceled)
						JOptionPane.showMessageDialog(null, "Reservation with code: "+add +" was canceled");
					else
						JOptionPane.showMessageDialog(null, "No reservation was canceled \nReminder:Reservations in room 1 cannot be canceled");
					
					loopflag=1;//used to end first while loop
			}//end first while loop
		}
	}
	
	/*
	 * 
	 * 
	 * 
	 * SHOULD MAKE A JTABLE HERE!!!!!
	 * 
	 * 
	 * 
	 * 
	*/
	
	private class ListenToThree implements ActionListener
	{
		public void actionPerformed(ActionEvent ae3)
		{	
			int rows = Kappa_hotel.res_list.size();
			String[][] reservations_data= new String[rows][3];
			String[] reservations_columns = {"Reservation Code","Customer Name","Room"};
			for(int i=0; i<=rows;i++)
			{
				try
				{
					reservations_data[i][0] = Integer.toString(Kappa_hotel.res_list.get(i).getRescode());
					reservations_data[i][1] = Kappa_hotel.res_list.get(i).getCustomer();
					reservations_data[i][2] = Integer.toString(Kappa_hotel.res_list.get(i).getRoom().getRoomNumber());
				}
				catch(ArrayIndexOutOfBoundsException e){i+=1;}
			}
			Table res_table = new Table("Reservations",rows,reservations_data,reservations_columns);
			res_table.setVisible(true);
			res_table.setSize(900,300);
			res_table.setLocationRelativeTo(null);
			
		}
	}
	
	private class ListenToFour implements ActionListener
	{
		public void actionPerformed(ActionEvent ae4)
		{	
			int rows = Kappa_hotel.room_list.size();
			String[][]	rooms_data = new String[rows][3];
			String[]	rooms_columns = {"Room Code","Completeness","Profit"};
			for(int i=0;i<=rows;i++)
			{
				try
				{
					rooms_data[i][0] = Integer.toString(Kappa_hotel.room_list.get(i).getRoomNumber());
					rooms_data[i][1] = Integer.toString(Kappa_hotel.room_list.get(i).occpercent()) + "%";
					rooms_data[i][2] = Double.toString(Kappa_hotel.room_list.get(i).pricing());
				}
				catch(ArrayIndexOutOfBoundsException e){i+=1;}
			}
			Table rooms_table = new Table("Rooms",rows,rooms_data,rooms_columns);
			rooms_table.setVisible(true);
			rooms_table.setSize(900,225);
			rooms_table.setLocationRelativeTo(null);
		}
	}
	
	private class ListenToFive implements ActionListener
	{
		public void actionPerformed(ActionEvent ae5)
		{
			int rows = Kappa_hotel.room_list.size();
			String[] res_plan_columns={"Room","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
			String[][] res_plan_data = new String[rows][31];
			
			for(int i=0;i<rows;i++)
			{
				res_plan_data[i][0] = Integer.toString(Kappa_hotel.room_list.get(i).getRoomNumber());
				for(int j=1;j<30;j++)
				{
					if(Kappa_hotel.room_list.get(i).pd[j]==null)
						res_plan_data[i][j] = " ";
					else
						res_plan_data[i][j] = "*";
				}	
			}
			Table res_plan_table = new Table("Reservations plan for this month",rows,res_plan_data,res_plan_columns);
			res_plan_table.setVisible(true);
			res_plan_table.setSize(1100,225);
			res_plan_table.setLocationRelativeTo(null);
			
		}
	}
	
	
	private class ListenToSix implements ActionListener
	{
		public void actionPerformed(ActionEvent ae6)
		{
			int whileloopflag=0;
			while(whileloopflag==0)
			{
				int num1;
				String msg =JOptionPane.showInputDialog("Would you like to enter a specific room code? If so press 1 else press any key");
				if(msg==null)
					break;
				try
				{
					num1 = Integer.parseInt(msg);
				}
				catch(NumberFormatException nfe)
				{
					num1=0;
				}
				
				int num2=-1;
				String cdd="";
				if(num1==1)
				{
					do
					{
						try
						{
							if(num2>9)
								cdd = JOptionPane.showInputDialog("Wrong code \nPlease enter a valid code from 0 to 9");
							else
								cdd = JOptionPane.showInputDialog("Enter the code");
							
							num2 = Integer.parseInt(cdd);
						}
						catch(NumberFormatException nfe)
						{
							if(cdd==null)
								break;
							JOptionPane.showMessageDialog(null,"Wrong code \nPlease enter a valid code from 0 to 9");
						}
					}while(num2<0 || num2>9);
					if(cdd==null)
						break;
					
					JOptionPane.showMessageDialog(null, "Profit from this room is: " +Kappa_hotel.findRoom(num2).pricing());
				}
				else
					JOptionPane.showMessageDialog(null, "Profit from all rooms is: "+Kappa_hotel.incomeCalc());
					
				whileloopflag=1;//used to end first while loop
			}//while loop ends
		}
	}
	
	private class ListenToSeven implements ActionListener
	{
		public void actionPerformed(ActionEvent ae7)
		{
			System.exit(0);
		}
	}
	
	public class Table extends JFrame
	{
		JTable table;
		
		public Table(String title,int rows,String[][] data,String[] columns)
		{
			setTitle(title);
			String[] res_columns = new String[3];
			res_columns = columns;
			String[][] res_data= new String [rows][3];
			res_data = data;
			
			table = new JTable(res_data,res_columns)
				{
					public boolean isCellEditable(int data,int columns)
					{
						return false;
					}
				};
			table.setPreferredScrollableViewportSize(new Dimension(500,150));
			table.setFillsViewportHeight(true);
			
			
			JScrollPane scroll = new JScrollPane(table);
			add(scroll);
		}
	}
}