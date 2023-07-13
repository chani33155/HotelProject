/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.io.Serializable;

/**
 *
 * ×?×—×?×§×ª ×?×•×¨×— ×?×ª×?×¨×ª ×?×•×¨×— ×‘×‘×™×ª ×?×?×•×?
 */
public class Guest implements Serializable
{
    //fields
    private Person myGuest;
    private static int numVisit;
    
   //getters&setters
   public Person getMyGuest()
   {
       return myGuest;
   }
   public void setMyGuest(Person myGuest)
   {
       this.myGuest=myGuest;
   }
   public int getNumVisit()
   {
       return numVisit;
   }
   public void setNumVisit()
   {
       this.numVisit++;
   }
   
   //c_tor
   public Guest(Person myGuest)
   {
       this.myGuest=myGuest;
       this.numVisit=1;
   }
   
   //toString
    @Override
    public String toString() {
        return  myGuest.toString() +"numVisit: "+numVisit; 
        
    }
   
    //equals
    @Override
    public boolean equals(Object obj) 
    {
        return ((Guest)obj).getMyGuest().getId()== this.getMyGuest().getId();
    }
    
           
   
   

    
            
            
    
    
}
