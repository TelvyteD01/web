package org.example.company.testOfTables;

import org.example.company.connection.JDBC;

import java.sql.*;
import java.util.*;

public class GetAllRows {

    public static void main(String[] args) {
        try{
            Statement stmt = null;
            JDBC.connect();
            stmt = JDBC.connection.createStatement();
            getAuthors(stmt);
            getPublishers(stmt);
            getAuthorisbn(stmt);
            getTitles(stmt);
        }
        catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } finally {
            // Finally block, used to close resources
            JDBC.close();
        }
    }
    public static void getAuthors(Statement stmt){
        try{
            String exampleQuery1 = "SELECT * FROM Authors";
            System.out.println("Authors:");
            ResultSet rs1 = stmt.executeQuery(exampleQuery1);
            while (rs1.next()) {
                int id = rs1.getInt("authorID");
                String firstName = rs1.getString("firstName");
                String lastName = rs1.getString("lastName");
                System.out.println(id + "\t" + firstName + "\t" + lastName);
            }

        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        }
    }

    public static void getPublishers(Statement stmt){

        try{
            String queryAuthor = "SELECT * FROM publishers";

            System.out.println("Show all publishers");

            ResultSet rs1 = stmt.executeQuery(queryAuthor);
            while (rs1.next()) {
                int id = rs1.getInt("publisherID");
                String pubName = rs1.getString("publisherName");
                System.out.println(id + "\t" + pubName);
            }

        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }
    }

    public static void getTitles(Statement stmt){
        try{
            String queryTitles = "SELECT * FROM titles";

            System.out.println("Show all titles");

            ResultSet rs1 = stmt.executeQuery(queryTitles);
            while (rs1.next()) {
                String isbn = rs1.getString("isbn");
                String title = rs1.getString("title");
                int editionNumber = rs1.getInt("editionNumber");
                int publisherId = rs1.getInt("publisherId");
                String year = rs1.getString("year");
                String price = rs1.getString("price");
                System.out.println(isbn + '\t' + title + '\t' + editionNumber + '\t' + publisherId + '\t' + year + '\t' + price);
            }

        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }
    }
    public static void getAuthorisbn(Statement stmt){
        try{
            String queryAuthorisbn = "SELECT * FROM authorisbn";

            System.out.println("Show all authorisbn");

            ResultSet rs1 = stmt.executeQuery(queryAuthorisbn);
            while (rs1.next()) {
                String isbn = rs1.getString("isbn");
                int authorId = rs1.getInt("authorID");
                System.out.println(isbn + '\t' + authorId);
            }

        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }
    }
}