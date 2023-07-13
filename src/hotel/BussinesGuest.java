/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

/**
 *
 * �?ח�?קת �?ורח עיסקי ה�?ח�?קה יורשת �?ת �?ח�?קת �?ורח
 */
public class BussinesGuest extends Guest
{
   //fields
   private final int bussinesGuestCode;
   private static double discountPercent=0.95;
    
    
   //getters&setters
   public double getBussinesGuestCode()
   {
       return bussinesGuestCode;
   }
   
   public double getDiscountPercent()
   {
       return discountPercent;
   }
   public void setDiscountPercent(int discountPercent)
   {
       this.discountPercent=discountPercent;
   }
    
   //c_tor
   public BussinesGuest(Person myGuest,int bussinesGuestCode) 
   {
       super(myGuest);
       this.bussinesGuestCode=bussinesGuestCode;
   }
    
}
