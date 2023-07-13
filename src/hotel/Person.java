/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.io.Serializable;

/**
 *
 * �?ח�?קת �?ד�? הדרושה �?�?ח�?קת �?ורח
 */
public class Person implements Serializable
{ 
   //fields
   private final int id;
   private String name;
   private String phoneNumber;
   
   //getters&setters
   public int getId()
   {
       return id;
   }
 
   public String getName()
   {
       return name;
   }
   public void setName(String name)
   {
       this.name=name;
   }
   
   public String getPhoneNumber()
   {
       return phoneNumber;
   }
   public void setPhoneNumber(String phoneNumber)
   {
       this.phoneNumber=phoneNumber;
   }
   
   //c_tor
   public Person(int id,String name,String phoneNumber)
   {
       this.id=id;
       this.name=name; 
       this.phoneNumber=phoneNumber;
   }
   
   //toString
    @Override
    public String toString() {
        return "id: "+id+"name: "+name+"phone: "+phoneNumber;
    }
   
}
