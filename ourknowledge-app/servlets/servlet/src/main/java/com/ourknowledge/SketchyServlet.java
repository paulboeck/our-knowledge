package com.ourknowledge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * SketchyServlet
 */
public class SketchyServlet {

    
    public List<String> getTodosOfStatus(String status) {

        List<String> todos = new ArrayList<>();

        Statement stm=null;

        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:~/test");
            stm = conn.createStatement();
            String sqlquery = "SELECT description from todos where status=" + status;
            System.out.println("executing: " + sqlquery);
            ResultSet res = stm.executeQuery(sqlquery);

            while(res.next()){
                todos.add(res.getString("description"));
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return todos;
    }
}