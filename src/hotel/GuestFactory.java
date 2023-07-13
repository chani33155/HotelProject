/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

/**
 *
 * @author angular
 */
public class GuestFactory 
{
    /**
     * This function creates new guest according the logic:
     * if the guest has a bussinesGuestCode creates BussinesGuest, else creates Guest
     * @param guestDetails
     * @param bussinesGuestCode - if has not - send -1
     * @return
     */
    public static Guest createGuest(Person guestDetails, int bussinesGuestCode)
    {
    	if(bussinesGuestCode == -1)
    		return new Guest(guestDetails);
    	else
    		return new BussinesGuest(guestDetails, bussinesGuestCode);
    }
    
}
