/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beer;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author dvosy
 */
public class Mysql {
    private Connection con = null;
    private String quarry;
    private Data start;
    
    /**
     * creates starting point and sql quarry to get data from DB
     * @param lat - start point latitude
     * @param longit - starting point longitude
     */
    public Mysql(double lat, double longit)
    {
        start = new Data(-1, lat, longit, "HOME", null);
        
        quarry="SELECT `geocodes`.`id`,`geocodes`.`latitude`, `geocodes`.`longitude`, `breweries`.`name` as brew, `table 6`.`name`as beer \n" +
            "FROM `geocodes` \n" +
            "	Left JOIN (`breweries` \n" +
            "   		Left join `table 6` \n" +
            "          	ON `table 6`.`brewery_id` = `breweries`.`id`)\n" +
            "        on `breweries`.`id` = `geocodes`.`brewery_id` \n" +
            "WHERE 111.111 * \n" +
            "	DEGREES(ACOS(COS(RADIANS("+lat+")) * \n" +
            "    	COS(RADIANS(`geocodes`.`latitude`)) * \n" +
            "        COS(RADIANS("+longit+" - `geocodes`.`longitude`)) + \n" +
            "        SIN(RADIANS("+lat+")) * \n" +
            "        SIN(RADIANS(`geocodes`.`latitude`)))) < 1000 \n" +
            "GROUP BY `table 6`.`id`\n" +
            "ORDER By id";
    }
    
    /**
     * connects to database
     */
    public void connect()
    {
        try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("Where is your MySQL JDBC Driver?");
		return;
	}
	try {
		con = DriverManager
		.getConnection("jdbc:mysql://localhost:3301/beer?useSSL=false","root", "");

	} catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		return;
	}

	if (con == null) {
		System.out.println("Failed to make connection!");
	}
    }
    
    /**
     * executes quarry and process data
     * @return returns breweries name, beer names and point data
     */
    public LinkedList<Data> getData()
    {
        LinkedList<Data> data = new LinkedList<>();
        data.add(start);
        ResultSet rs;
        try
        {
            int id;
            Statement stmt=con.createStatement();  
            rs=stmt.executeQuery(quarry); 
            Data info = new Data();
            while (rs.next()) {
                id = rs.getInt(1);
                if(id != info.getId() && info.getId() != -1)
                {
                    data.add(info);
                    info = new Data();
                }
                info.setId(id);
                info.setLat(rs.getDouble(2));
                info.setLongit(rs.getDouble(3));
                info.setBrew(rs.getString(4));
                info.setBeer(rs.getString(5));
            }
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
            return null;
        }
        return data;
    }
    
}
