package com.jdbc.app;

import java.sql.*;
import java.util.Scanner;

public class JDBCPrepareStatement {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the empno: ");
        int eno= sc.nextInt();
        System.out.println("Enter the empname: ");
        String ename= sc.next();
        System.out.println("enter salary: ");
        float sal= sc.nextFloat();


        try{
            // load the driver:
            Class.forName("org.postgresql.Driver");

            //establish the connection:
            System.out.println("Connecting to Database...");
            Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase", "postgres", "Global@777#");
            System.out.println("Sucessfully Connected...");

            // creating table :
//          PreparedStatement st= con.prepareStatement("insert into employyeess values("+eno+",'"+ename+"',"+sal+")");
//          st.executeUpdate(); --- if write like this then above 4 lines of code gets reduce. and you don't need to write them again.
// we write employee name in double quotes because when we set the employee values means if you want to print
// a string in double quotes then you have to use '"hello"' and it will print it in double quotes like: "hello"
            PreparedStatement st= con.prepareStatement("insert into employyeess values(?,?,?)");
            st.setInt(1,eno);
            st.setString(2,ename);
            st.setFloat(3, sal);


            st.executeUpdate();
            System.out.println("Inserted...");

            // so we have completed our CRUD Operation using JDBC.

            // close the statement:
            st.close();
            // close the connection:
            con.close();
        } catch(Exception e){
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        //finally {
        //    st.close();
        //    con.close(); it throws you an sql exception so better to add it in your method signature.
        // and one more thing just after your main method just define Connection con=null; and PreparedStatement st=null;

    }
}



