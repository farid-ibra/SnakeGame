// Farid Ibrahimli
//
// DQWMYW
//
// PSE_Second_Assignment
//
// 2019/01/07 16:30:20
//
// This solution was submitted and prepared by Farid Ibrahimli, DQWMYW for the
// Snake game assignment of the Practical software engineering I. course.
//
// I declare that this solution is my own work.
//
// I have not copied or used third party solutions.
//
// I have not passed my solution to my classmates, neither  made it public.
//
// Students’ regulation of Eötvös Loránd University (ELTE Regulations
// Vol. II. 74/C. § ) states that as long as a student presents another
// student’s work - or at least the significant part of it - as his/her own
// performance, it will count as a disciplinary fault. The most serious
// consequence of a disciplinary fault can be dismissal of the student from
// the University.
package mysnakegame;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;


public class Database {

    public static String[][] mTemp = new String[100][2];
    public static int count = 0;
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/TEST";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "thepassword";

    public static void createTable(){
                Connection conn = null;
                Statement stmt = null;
                try{
                    //STEP 2: Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    //STEP 3: Open a connection
                    
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);

                    //STEP 4: Execute a query
                    
                    stmt = conn.createStatement();

                    String sql = "CREATE TABLE DATA " +
                            "(name VARCHAR(255), " +
                            " score INTEGER, "  +
                            " PRIMARY KEY ( name ))";

                    stmt.executeUpdate(sql);
                    
                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                }catch(Exception e){
                    //Handle errors for Class.forName
                    e.printStackTrace();
                }
                
    }//end creating


    public static void getter(){
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
           
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT name,score FROM DATA ORDER BY score DESC" ;
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            count = 0;
            while(rs.next()){
                //Retrieve by column name

                String name = new String(rs.getString("name"));
                int score = rs.getInt("score");
                //String first = rs.getString("first");
                //String last = rs.getString("last");

                //Display values

                //System.out.print("Name: " + name);
                //System.out.print(", Score: " + score);
                mTemp[count][0] = name;
                mTemp[count][1] = (""+score);



                       
                count = count + 1;

                
            }

            //STEP 6: Clean-up environment
            rs.close();
            
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        
        
    }

    public static void adder(String name,int score){
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            

            //STEP 4: Execute a query
            
            stmt = conn.createStatement();

            String sql = "INSERT INTO DATA " +
                    "VALUES ('" + name + "', '" + score + "')";
            stmt.executeUpdate(sql);

           

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        

    }


}