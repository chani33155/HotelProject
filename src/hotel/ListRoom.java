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

/**
 *
 * ׳?׳—׳?׳§׳” ׳–׳• ׳?׳ ׳”׳?׳× ׳?׳¢׳¨׳? ׳—׳“׳¨׳™ ׳”׳?׳?׳•׳?
 */
public class ListRoom 
{
	//fields
     private ArrayList<Room> arrayRoom ;
     
     
    
    
    //c_tor
    public ListRoom() 
    {
         arrayRoom = new ArrayList<Room>();
    }
    
    //function
    
    //פונקצית חיפוש חדר
    public Room searchByNumRoom(int num) 
    {
        for (Room room : arrayRoom) 
        {
            if (room.getNumRoom() == num) 
            {
                return room;
            }
        }
        return null;
    }
    
    //פונקצית הוספת חדר
    public void addRoom(Room newRoom)
    {
       arrayRoom.add(newRoom);
    }
    //פונקצית מחיקת חדר
    public boolean printRoomByNumRoom(int numRoom)
    {
        for(Room room:arrayRoom)
        {
            if(room.getNumRoom() == numRoom)
            {
                System.out.println(room);
                return true;
            }
        }
       return false;
    }
    //פונקציות הדפסה
    public void printRooms()
    {
        for(Room room:arrayRoom)
        {
            System.out.println(room);
        }
    }
    public boolean printRoomByLevel(int lev)
    {
        for(Room room:arrayRoom)
        {
            if(room.getLevel() == lev)
            {
                System.out.println(room);
                return true;
            }
        }
       return false;
    } 
    public boolean printRoomByFloor(int flo)
    {
        for(Room room:arrayRoom)
        {
            if(room.getFloor() == flo)
            {
                System.out.println(room);
                return true;
            }
        }
       return false;
    }
    //הפקת דו"חות
    public void writeFreeRoom(String fileName) 
    {
        ObjectOutputStream dos = null;
        try {
            dos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
            ArrayList<Room> free=new ArrayList<Room>();
            for(Room r:arrayRoom)
            {
            	if(r.getIsActive())
            		free.add(r);
            }
            for(Room f:free)
            {
            	dos.writeObject(f);
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
    
    public void writeNotFreeRoom(String fileName) 
    {
        ObjectOutputStream dos = null;
        try {
            dos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
            ArrayList<Room> free=new ArrayList<Room>();
            for(Room r:arrayRoom)
            {
            	if(!(r.getIsActive()))
            		free.add(r);
            }
            for(Room f:free)
            {
            	dos.writeObject(f);
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
