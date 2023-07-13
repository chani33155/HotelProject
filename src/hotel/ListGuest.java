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
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * ׳?׳—׳?׳§׳” ׳–׳• ׳?׳ ׳”׳?׳× ׳?׳¢׳¨׳? ׳?׳•׳¨׳—׳™ ׳”׳?׳?׳•׳?
 */
public class ListGuest 
{
	
    //fields
    private ArrayList<Guest> arrayGuest;
    
    //c_tor
    public ListGuest() 
    {
    	arrayGuest = new ArrayList<Guest>();
    }
    
    //functions      
    
    //פונקציות חיפוש
    public Optional<Guest> searchGuestById(int id)
    {
        return arrayGuest.stream().filter(x->x.getMyGuest().getId() == id).findAny();
    }   
    public Optional<Guest> searchGuestByName(String name)
    {
        return arrayGuest.stream().filter(x->x.getMyGuest().getName().equals(name)).findAny();
    } 
    public Optional<Guest> searchGuestByPhone(String phone)
    {
        return arrayGuest.stream().filter(x->x.getMyGuest().getPhoneNumber().equals(phone)).findAny();
    }
    //פונקצית הוספת לקוח
    public boolean addGuest(Guest newGuest)
    {
       if(!(searchGuestById(newGuest.getMyGuest().getId()).isPresent()))
       {
            arrayGuest.add(newGuest);
            return true;
       }
       else return false;
    }
    //פונקצית מחיקת לקוח רק אם אין לו הזמנה
    public boolean deleteGuest(Guest newGuest)
    {
    	if(!(ListOrder.searchOrder(newGuest).isPresent()))
    	{
	          arrayGuest.remove(newGuest);
	          return true;
    	}
        else return false;
    }
    
    //פונקציות הדפסה
    public boolean printGuest(int id)
    {
        if(searchGuestById(id).isPresent())
        {
           System.out.println(searchGuestById(id).get());
           return true;
        }
        else return false;
    }
    public boolean printGuest(String name)
    {
        if(searchGuestByName(name).isPresent())
        {
            System.out.println(searchGuestByName(name).get());
            return true;
        }
        return false;
    }
    public void printGuest()
    {
    	arrayGuest.forEach(System.out::println);
    	
//        for(Guest g:arrayGuest)
//        {
//            System.out.println(g);
//        }  
    }
    
    //הפקת דו"חות
    public void writeActiveGuest(String fileName) 
    {
        ObjectOutputStream dos = null;
        try {
            dos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
            ArrayList<Guest> activeGuest=new ArrayList<Guest>();
            for(Guest g:arrayGuest)
            {
            	if(ListOrder.searchOrder(g).isPresent())
            		activeGuest.add(g);
            }
            for(Guest a:activeGuest)
            {
            	dos.writeObject(a);
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
