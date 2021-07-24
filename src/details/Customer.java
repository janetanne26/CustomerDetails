
package details;
class Customer {
    private int custid;
    private String name;
     private String password;
    private String emailid;
    private String phno;
    
    public Customer(){}
    public Customer(int custid,String name,String password,String emailid,String phno){
        super();
        this.custid=custid;
        this.name=name;
        this.password=password;
        this.emailid=emailid;
        this.phno=phno;
    }
    public int getcustid(){
        return custid;
    }
    public void setcustid(int id){
        this.custid=custid;
    }
    public String getname(){
        return name;
    }
     public void setname(String id){
        this.name=name;
    }
   
    public String getpassword(){
        return password;
    }
     public void setpassword(String id){
       this.password=password;
    }
      public String getemailid(){
        return emailid;
    }
     public void setemailid(String id){
        this.emailid=emailid;
    }
    public String getphno(){
        return phno;
    }
     public void setphno(String id){
        this.phno=phno;
    }

    static class getcustid extends Customer {

        public getcustid() {
        }
    }
    
    
}
