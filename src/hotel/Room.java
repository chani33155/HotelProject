/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.io.Serializable;

/**
 *
 * �?ח�?קה זו �?ת�?רת חדר בבית �?�?ו�?
 */
public class Room implements Serializable
{
    //fields
    private final int numRoom;
    private int floor;
    private int level;
    private boolean isActive;
    private static int startPrice=200;
    //private static int counter;
    
    //getters&setters
    public int getNumRoom() {
        return numRoom;
    }

    public int getFloor() {
        return floor;
    }
    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    public boolean getIsActive() {
        return isActive;
    }
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public static int getStartPrice() {
        return startPrice;
    }
    public static void setStartPrice(int startPrice) {
        Room.startPrice = startPrice;
    }

    //c_tor
    public Room(int numRoom, int floor, int level, boolean isActive) {
        this.numRoom = numRoom;
        this.floor = floor;
        this.level = level;
        this.isActive = isActive;
    }
    public Room(int numRoom) {
        this.numRoom = numRoom;
    }
    
    //toString
    @Override
    public String toString() {
        return "numRoom: "+numRoom+" floor: "+floor+" level: "+level+" isActive: "+isActive+" startPrice: "+startPrice;
    }
    
    //equals
    @Override
    public boolean equals(Object obj) 
    {
        return ((Room)obj).getNumRoom()== this.getNumRoom();
    }
}
