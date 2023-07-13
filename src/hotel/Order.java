/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * �?ח�?קה זו �?ת�?רת הז�?נה בבית �?�?ו�?
 */
public class Order implements Serializable
{
    //fields
    private final int numOrder;
    private Guest myGuest;
    private Room myRoom;
    private LocalDate orderDate;
    private  int numDays;
    
    //c_tor
    public Order(int numOrder, Guest myGuest, Room myRoom, LocalDate orderDate, int numDays) {
        this.numOrder = numOrder;
        this.myGuest = myGuest;
        this.myRoom = myRoom;
        this.orderDate = orderDate;
        this.numDays = numDays;
    }
    
    //getters&setters
    public int getNumOrder() {
        return numOrder;
    }

    public Guest getMyGuest() {
        return myGuest;
    }
    public void setMyGuest(Guest myGuest) {
        this.myGuest = myGuest;
    }

    public Room getMyRoom() {
        return myRoom;
    }
    public void setMyRoom(Room myRoom) {
        this.myRoom = myRoom;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public int getNumDays() {
        return numDays;
    }
    public void setNumDays(int numDays) {
        this.numDays = numDays;
    }
    
    @Override
	public String toString() {
		return "Order [numOrder=" + numOrder + ", myGuest=" + myGuest + ", myRoom=" + myRoom + ", orderDate="
				+ orderDate + ", numDays=" + numDays + "]";
	}

	//function
    public double calcPrice()
    {
        if(myGuest instanceof BussinesGuest)
            return ((BussinesGuest)myGuest).getDiscountPercent()*numDays*Room.getStartPrice();
        else
           return numDays*Room.getStartPrice();
    }
    
    
    
}
