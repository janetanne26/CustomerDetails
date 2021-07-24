package details;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import details.Details;
import details.Customer;

public class MainClass {

    public static void main(String[] args) {
        List < Customer > list = new ArrayList < > ();
        list.add(new Customer(502, "Denial", "denial", "denial@gmail.com", "978907364"));
       list.add(new Customer(203, "Rocky", "rocky", "rocky@gmail.com", "856780013"));
        list.add(new Customer(300, "Steve", "steve", "steve@gmail.com", "8348784758"));
        list.add(new Customer(400, "Ramesh", "ramesh", "ramesh@gmail.com", "8957348758"));
       
        
        List < Details > list1 = new ArrayList < > ();
        list1.add(new Details(7400916,502,150000.00 ));
        list1.add(new Details(7586267,500,250000));
        list1.add(new Details(7827918,500,300000));
        list1.add(new Details(7067918,500,300000));
        list1.add(new Details(7242487,500, 100000));
     
        

        String INSERT_USERS_SQL = "INSERT INTO customer" + "  (CustomerID, Name, Password, EmailID,PhoneNumber) VALUES " +
             "(?, ?, ?, ?, ?);";
        String INSERT_ACCOUNTS_SQL = "INSERT INTO accounts" + "  (AccountNumber,CustomerID,Balance) VALUES " +
             "(?, ?, ?);";

        try (Connection connection = DbConnection.con();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            connection.setAutoCommit(false);
            for (Iterator < Customer > iterator = list.iterator(); iterator.hasNext();) {
                Customer customer = (Customer) iterator.next();
                preparedStatement.setInt(1, customer.getcustid());
                preparedStatement.setString(2, customer.getname());
                preparedStatement.setString(3, customer.getpassword());
                preparedStatement.setString(4, customer.getemailid());
                preparedStatement.setString(5, customer.getphno());
                preparedStatement.addBatch();
                System.out.println(preparedStatement);
            }
            int[] updateCounts = preparedStatement.executeBatch();
            System.out.println(Arrays.toString(updateCounts));
            connection.commit();
            connection.setAutoCommit(true);
        } catch (BatchUpdateException batchUpdateException) {
            printBatchUpdateException(batchUpdateException);
        } catch (SQLException e) {
            printSQLException(e);
        }
        
        
        try (Connection connection1 = DbConnection.con();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement1 = connection1.prepareStatement(INSERT_ACCOUNTS_SQL)) {
            connection1.setAutoCommit(false);
            for (Iterator < Details > iterator = list1.iterator(); iterator.hasNext();) {
                Details acct = (Details) iterator.next();
                preparedStatement1.setInt(1, acct.getacctno());
                preparedStatement1.setInt(2, acct.getcustid());
                preparedStatement1.setDouble(3, acct.getbalance());
                preparedStatement1.addBatch();
                System.out.println(preparedStatement1);
            }
            int[] updateCounts = preparedStatement1.executeBatch();
            System.out.println(Arrays.toString(updateCounts));
            connection1.commit();
            connection1.setAutoCommit(true);
        } catch (BatchUpdateException batchUpdateException) {
            printBatchUpdateException(batchUpdateException);
        } catch (SQLException e) {
            printSQLException(e);
        } 
        
    }
        
    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
       

    public static void printBatchUpdateException(BatchUpdateException b) {

        System.err.println("----BatchUpdateException----");
        System.err.println("SQLState:  " + b.getSQLState());
        System.err.println("Message:  " + b.getMessage());
        System.err.println("Vendor:  " + b.getErrorCode());
        System.err.print("Update counts:  ");
        int[] updateCounts = b.getUpdateCounts();

        for (int i = 0; i < updateCounts.length; i++) {
            System.err.print(updateCounts[i] + "   ");
        }
    }     
        
}       
  


