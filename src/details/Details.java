/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package details;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.*;

/**
 *
 * @author Admin
 */
class Details {

    /**
     * @param args the command line arguments
     */
   private int acctno;
   private int custid;
   private double balance;
   
   public Details(){}
   public Details(int acctno,int custid,double balance){
       this.acctno=acctno;
        this.custid=custid;
        this.balance=balance;
        
    }
    public int getacctno(){
        return acctno;
    }
    public void setacctno(){
         this.acctno=acctno;
    }
    public int getcustid(){
        return custid;
    }
    public void settcustid(){
        this.custid=custid;
    }
    public double getbalance(){
        return balance;
    }
    public void setbalance(){
        this.balance=balance;
    }  
    
    public static void main(String[] args) {
         Connection con=DbConnection.con();
         HashMap<Integer, HashMap<Integer, Details>> outerMap = new HashMap<Integer, HashMap<Integer,Details>>();
    HashMap<Integer, Details> innerMap = new HashMap<Integer, Details>();  
        Scanner sc=new Scanner(System.in);
        Statement st = null;
        ResultSet rs = null;
         Statement st1 = null;
        ResultSet rs1 = null;
        Details d;       
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM accounts");
            
            while(rs.next()){
                Integer acctno = rs.getInt(1);
                Integer custid = rs.getInt(2);
                Double balance = rs.getDouble(3);
                d = new Details(acctno, custid,balance);              
               innerMap.put(acctno, d);
              
   
                
            }         
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
         
        try{
            st1= con.createStatement();
            rs1= st.executeQuery("SELECT * FROM customer");
            while(rs1.next()){
                Integer custid=rs1.getInt(1);
                outerMap.put(custid, innerMap);
                
            }
            
        }catch(Exception ex){
            System.out.println(ex);
        }     
     System.out.println("enter the customer ID");
        int t=sc.nextInt();
       Iterator hmIterator = innerMap.entrySet().iterator();  
       
       while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)hmIterator.next();
       
            Details ds= (Details) mapElement.getValue();
            if(ds.getcustid()==t){
                 System.out.println(ds.getacctno()+" "+ds.getcustid()+" "+ds.getbalance()+" ");
            }   
        
        
       }
          
       
   
        
    }
    
    
}


     



