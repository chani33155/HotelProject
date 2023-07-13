/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * ׳?׳—׳?׳§׳” ׳–׳• ׳?׳ ׳”׳?׳× ׳?׳¢׳¨׳? ׳”׳–׳?׳ ׳•׳×
 */
public class ListOrder 
{
    //fields
     private static ArrayList<Order> arrayOrder;
    
    //c_tor
    public ListOrder() 
    {
    	arrayOrder = new ArrayList<Order>();
    }
    
    
    //function
    
    //פונקציות חיפוש
    public static Optional<Order> searchOrder(Guest g)
    {
       return arrayOrder.stream().filter(x->x.getMyGuest().equals(g)).findAny();
    }
    public static Optional<Order> searchOrder(Room r)
    {
       return arrayOrder.stream().filter(x->x.getMyRoom().equals(r)).findAny();
    }
    //פונקצית הוספת הזמנה
    public static boolean addOrder(Order newOrder)
    {
        for(Order order:arrayOrder)
        {
            if(order.getNumOrder()== newOrder.getNumOrder())
            {
                return false;
            }
        }
       arrayOrder.add(newOrder);
       return true;
    }
    //פונקצית מחיקת הזמנה
    public static int deleteOrder(Guest g)
    {
    	Order o=searchOrder(g).get();
        if(searchOrder(g).isPresent())
        {
            arrayOrder.remove(o);
            return o.getMyRoom().getNumRoom();
        }
        return -1;
    }
    //פונקציות הדפסה
    public static boolean printOrder(Guest g)
    {
        for(Order order:arrayOrder)
        {
            if(order.getMyGuest().equals(g))
            {
                System.out.println(order);
                return true;
            }
        }
       return false;
    }
    public static boolean printOrder(Room r)
    {
        for(Order order:arrayOrder)
        {
            if(order.getMyRoom().equals(r))
            {
                System.out.println(order);
                return true;
            }
        }
       return false;
    }
    public static void printOrder()
    {
        for(Order order:arrayOrder)
        {
            System.out.println(order);
        }
    }
    //הפקת דו"חות
    public static void writeByNumDays(String fileName,int numDays) 
    {
        ObjectOutputStream dos = null;
        try {
            dos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
            ArrayList<Order> conect = new ArrayList<Order>();
            for(Order o:arrayOrder)
            {
            	if(o.getNumDays()==numDays)
            		conect.add(o);
            }
            for(Order c:conect)
            {
            	dos.writeObject(c);
            }
            dos.flush();
        } 
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        } 
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        finally{
            if(dos != null)
                try {
                    dos.close();//צריך לסגור רק את הסטרים החיצוני
            } 
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
       
    }
    public static void writeByDate(String fileName,Date date) 
    {
        ObjectOutputStream dos = null;
        try {
            dos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
            ArrayList<Order> conect = new ArrayList<Order>();
            for(Order o:arrayOrder)
            {
            	if(o.getOrderDate().equals(date))
            		conect.add(o);
            }
            for(Order c:conect)
            {
            	dos.writeObject(c);
            }
            dos.flush();
        } 
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        } 
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        finally{
            if(dos != null)
                try {
                    dos.close();//צריך לסגור רק את הסטרים החיצוני
            } 
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
       
    }
    
    
}
