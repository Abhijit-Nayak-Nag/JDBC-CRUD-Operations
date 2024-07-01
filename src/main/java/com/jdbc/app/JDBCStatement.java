package com.jdbc.app;
import java.lang.*;
import java.sql.*;

public class JDBCStatement {
    public static void main(String[] args) {
        try{
            // load the driver:
            Class.forName("org.postgresql.Driver");

            //establish the connection:
            System.out.println("Connecting to Database...");
            Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase", "postgres", "Global@777#");
            System.out.println("Sucessfully Connected...");

            // creating table :
            Statement st= con.createStatement();
//            st.execute("create table employees (eno int, ename varchar(10), salary float )");
//            System.out.println("Table created...");

            // Inserting values into the table:
//            st.execute("insert into employees values(111, 'Raj',8000)");
//            st.execute("insert into employees values(112, 'Abhijit', 9000)");
//            st.execute("insert into employees values(113, 'Sonu', 10000)");
//            st.execute("insert into employees values(114, 'Rahul', 11000)");
              System.out.println("Inserted...");

           //update records: we are updating salary 7000 in all records because since,
           // we didn't use any condition for set the salary in a particular employee so salary gets updated in all the records.
            st.executeUpdate("update employees set salary =7000");
            System.out.println("Updated sucessfully...");

            // delete records: since we have not used any particular condition so all the records will be deleted.
            st.executeUpdate("delete from employees");
            System.out.println("record delete successfully...");

 // if you want to see how many records gets updated or deleted then you have to use a variable.

//           int n= st.executeUpdate("delete from employees");
//            System.out.println(n + "record delete successfully..."); O/P: 3 record delete successfully...

            //Retrieve the data or Select statement:

            ResultSet rs= st.executeQuery("select *from employee");
            //traverse the result set

            while (rs.next()){
    // here you can pass in rs.getInt()/ getString()/ get()Float your column name and your column
    // number also. column name start from 0.
                System.out.println(rs.getInt("eno") + " "+ rs.getString("ename") +" "+ rs.getFloat("3"));
            }
            System.out.println("Records Retrieve sucessfully...");

            // so we have completed our CRUD Operation using JDBC.

           // close the statement:
            st.close();
            // close the connection:
            con.close();
       } catch(Exception e){
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}

