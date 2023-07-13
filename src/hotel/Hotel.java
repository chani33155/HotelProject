/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * 
 * 
 */

public class Hotel 
{
	 Scanner input = new Scanner(System.in);
	 
    //fields
    private String name="galey tzanz";
    private String address="natanya";
    private String phoneNumber="0733565985";
    private ListRoom listRoom;
    private ListGuest listGuest;
    private ListOrder listOrder;  
    private int countOrders=0;
    private static Hotel instence;
  
    //singleton
    public static Hotel hotel()
    {
        return instence == null ? new Hotel():instence;
    }
    
    //c_tor
    private Hotel() 
    {
    	listRoom = new ListRoom();
    	listGuest = new ListGuest();
    	listOrder = new ListOrder();
    	addRooms();
    }
    
    
    //function
    
    
    // ������� ����� ����� ����
    
    public void startOrder() 
    {
    	addOrConectGuest();
    }
    
    public void addOrConectGuest() 
    {
    	int id;
        String name,phone;
        
        System.out.println("press your id :");
        id=input.nextInt();
        
        if(!(listGuest.searchGuestById(id).isPresent()))
        {
        	System.out.println("your id did'nt found, you are a new guest, please press your details :");
            System.out.println("press your name :");
            name=input.next();
            System.out.println("press your phone :");
            phone=input.next();
            Person p = new Person(id, name, phone);
            System.out.println("press your bussines code ,if you are not bussines guest press -1");
            int bussinesGuestCode=input.nextInt();
            Guest g = GuestFactory.createGuest(p, bussinesGuestCode);
            listGuest.addGuest(g);
        }
        else
        {
        	listGuest.searchGuestById(id).get().setNumVisit();
        }
        
        conectRoom(id);
	}
    
    public void conectRoom(int id)
    {
    	int numRoom;
    	
        System.out.println("press the room's number :");
        numRoom=input.nextInt();
        
        Room r = listRoom.searchByNumRoom(numRoom);
        while(r == null || !(listRoom.searchByNumRoom(numRoom).getIsActive()))
        {
        	System.err.println("the room is not availible, please prees another number :");
            numRoom=input.nextInt();
            r = listRoom.searchByNumRoom(numRoom);
        }

        r.setIsActive(false); 
        addOrder(id,r);
    }
    
    public void addOrder(int id,Room r)
    {
    	int numDays;
    	
    	System.out.println("press count of days :");
        numDays=input.nextInt();
    	
    	Guest g = listGuest.searchGuestById(id).get();
        Order o = new Order(countOrders++,g,r,LocalDate.now(),numDays);
        listOrder.addOrder(o); 
        System.out.println("sucseed");
        againMenu() ;
    }
    
    
    
    
    //������� ����� �����
    public void deleteOrder()
    {
        System.out.println("press your id:");
        int id=input.nextInt();
        deleteOrder(id);
        System.out.println("sucseed");
    }
    public void deleteOrder(int id) 
    {
        deleteOrder(listGuest.searchGuestById(id).get());
    }
    public void deleteOrder(Guest g) 
    {
        if(g==null)
        {
        	System.out.println("your id did'nt found, please press again :");
            deleteOrder();
        }
        int numRoom = listOrder.deleteOrder(g);
        if(numRoom == -1)
            return;
        System.out.println("the room's number "+numRoom+" is free !!!");
        Room r = listRoom.searchByNumRoom(numRoom);
        r.setIsActive(true);
        againMenu() ;
    }
    
    //������� ����� ���
    public Room searchRoom(int numR)
    {
    	return listRoom.searchByNumRoom(numR);
    }
    
    //������� �����
    public void menu() 
    {
    	int pkuda;
        System.out.println("press 1: to print hotel details\n"
                + "press 2: to add order\n"
                + "press 3: to delete order\n"
                + "press 4: to print orders\n"
                + "press 5: to print reports of rooms\n"
                + "press 6: to print guest details\n");
        pkuda = input.nextInt();
        switch (pkuda) 
        {
			case 1:printHotelDetails();break;
			case 2:startOrder();break;
			case 3:deleteOrder();break;
			case 4:menuPrintOrders();break;
			case 5:menuWrite();break;
			case 6:printGuests();break;
		}
        
    }
    
    private void menuWrite() 
    {
    	int pkuda=0;
		System.out.println("press 1 to write to file the free rooms\n"+"press 2 to write to file the unfree rooms\n ");
		pkuda=input.nextInt();
		if(pkuda==1)
			writeFreeToFile();
		else writeNotFreeToFile();
	}
    
    private void menuPrintOrders() 
    {
    	 System.out.println("\t press 1: to print all orders\n"
                 + "\t press 2: to print order by guest\n"
                 + "\t press 3: to print order by room\n");
         int pkuda = input.nextInt();
             switch (pkuda)
             {
                 case 1:printOrders(); break;
                 case 2:
                 {
                		 System.out.println("press name's guest to print :");
                         String name = input.next();
                         Guest g = listGuest.searchGuestByName(name).get();
                		 printOrders(g);break;
                 }
                 case 3:
            	 {
            		 System.out.println("press num of room to print :");
                     int num = input.nextInt();
                     Room r=searchRoom(num);
            		 printOrders(r);break;
            	 }
             }
	}
    
    public void againMenu() 
    {
    	System.out.println("if you want to start the manu again press 1");
        int again = input.nextInt();
        if(again == 1)
        	menu();
	}
    
    private void printHotelDetails() 
    {
		System.out.println(this);
		System.out.println("if you want to start the manu again press 1");
        int again = input.nextInt();
        if(again == 1)
        	menu();
    }
    private void printOrders() 
    {
		listOrder.printOrder();
		againMenu();
	}
    private void printOrders(Guest g) 
    {
		listOrder.printOrder(g);
		againMenu() ;
	}
    private void printOrders(Room r) 
    {
		listOrder.printOrder(r);
		againMenu() ;
	}
    private void printGuests() 
    {
		listGuest.printGuest();
		againMenu() ;
	}
    private void writeFreeToFile() 
    {
		listRoom.writeFreeRoom("myFile");
	}
    private void writeNotFreeToFile() 
    {
		listRoom.writeNotFreeRoom("myFile");
	}
    
    @Override
	public String toString() 
    {
		return  " name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber;


	}
    
    
	//����� �����
    public void addRooms()
    {
       
       listRoom.addRoom(new Room(100,0,4,true)) ;
       listRoom.addRoom(new Room(101,0,5,true)) ;
       listRoom.addRoom(new Room(102,1,3,true)) ;
       listRoom.addRoom(new Room(103,1,2,true)) ; 
       listRoom.addRoom(new Room(104,2,1,true)) ;
       listRoom.addRoom(new Room(105,2,1,false)) ;
       listRoom.addRoom(new Room(106,3,1,true)) ;
       listRoom.addRoom(new Room(107,3,2,false)) ;
       listRoom.addRoom(new Room(108,4,3,true)) ;
       listRoom.addRoom(new Room(109,4,3,false)) ;
       listRoom.addRoom(new Room(110,5,4,true)) ;
       listRoom.addRoom(new Room(111,5,5,false)) ;
       listRoom.addRoom(new Room(112,6,5,false)) ;
       listRoom.addRoom(new Room(113,6,4,true)) ;
       listRoom.addRoom(new Room(114,7,5,false)) ;
       listRoom.addRoom(new Room(115,7,5,true)) ;
       listRoom.addRoom(new Room(116,8,5,true)) ;
       listRoom.addRoom(new Room(117,8,5,true)) ;
    }

  
}
