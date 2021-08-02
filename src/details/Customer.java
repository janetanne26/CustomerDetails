
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
   public int getCustid(){
        return custid;
    }
    public void setCustid(int custid){
        this.custid=custid;
    }
    public String getName(){
        return name;
    }
     public void setName(String name){
        this.name=name;
    }
   
    public String getPassword(){
        return password;
    }
     public void setPassword(String password){
       this.password=password;
    }
      public String getEmailid(){
        return emailid;
    }
     public void setEmailid(String emailid){
        this.emailid=emailid;
    }
    public String getPhno(){
        return phno;
    }
     public void setPhno(String phno){
        this.phno=phno;
    }   

    static class getcustid extends Customer {

        public getcustid() {
        }
    }
    
    
}
