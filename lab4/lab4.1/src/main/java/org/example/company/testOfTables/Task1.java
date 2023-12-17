package org.example.company.testOfTables;

import org.example.company.connection.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Task1 {
    public static void main(String[] args) {
        Statement stmt;
        try{
            JDBC.connect();
            stmt = JDBC.connection.createStatement();
            getAuthorsAndSort(stmt);
            insertPublisher(stmt);
            GetAllRows.getPublishers(stmt);
            updatePublisher(stmt);
            getTilesDefPublisher(stmt);
            insertAuthor(stmt);
            updateAuthor(stmt);
            insertTitle(stmt);
            insertISBN(stmt);

        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        finally {
            JDBC.close();
        }
    }
    public static void getAuthorsAndSort(Statement stmt){
        try{
            String exampleQuery1 = "SELECT * FROM authors ORDER BY firstName ASC, lastName DESC ";
            System.out.println("Authors:");
            ResultSet rs1 = stmt.executeQuery(exampleQuery1);
            while (rs1.next()) {
                int id = rs1.getInt("authorID");
                String firstName = rs1.getString("firstName");
                String lastName = rs1.getString("lastName");
                System.out.println(id + "\t" + firstName + "\t" + lastName);
            }
        } catch(SQLException se) {
            se.printStackTrace();
        }
    }

    public static void insertPublisher(Statement stmt){
        try{
            String publisherName = "Artem";
            String insertPublishersTable = "INSERT INTO publishers (publisherName)" + "VALUES ('" + publisherName + "')";
            stmt.executeUpdate(insertPublishersTable);
            System.out.println("Publisher added");
        } catch(SQLException se) {
            System.out.println("Execute Update Failed!");
            se.printStackTrace();
        }
    }
    public static void updatePublisher(Statement stmt) {
        try {
            int publisherId = 1;
            String newPublisherName = "Vovka";
            String updatePublisherTable = "UPDATE publishers SET publisherName='" + newPublisherName + "' WHERE publisherID =" + publisherId;
            stmt.executeUpdate(updatePublisherTable);
            System.out.println("PublisherName changed");
        } catch (SQLException se) {
            System.out.println("Execute Update Failed!");
            se.printStackTrace();
        }
    }

    public static void getTilesDefPublisher(Statement stmt) {
        try {
            int publisherIdFind = 1;
            String exampleQuery1 = "SELECT * FROM titles WHERE publisherID="+publisherIdFind+" ORDER BY price DESC ";
            System.out.println("Titles where publisherId = "+publisherIdFind+":");
            ResultSet rs1 = stmt.executeQuery(exampleQuery1);
            while (rs1.next()) {
                String isbn = rs1.getString("isbn");
                String title = rs1.getString("title");
                int editionNumber = rs1.getInt("editionNumber");
                int publisherId = rs1.getInt("publisherId");
                String year = rs1.getString("year");
                String price = rs1.getString("price");
                System.out.println(isbn + '\t' + title + '\t' + editionNumber + '\t' + publisherId + '\t' + year + '\t' + price);
            }
        } catch (SQLException se) {
            System.out.println("Execute Update Failed!");
            se.printStackTrace();
        }
    }

    public static void insertAuthor(Statement stmt){
        try{
            String firstName = "Artem";
            String lastName = "Grudko";
            String insertAuthorTable = "INSERT INTO authors (firstName, lastName)" + "VALUES ('" + firstName + "', '"+ lastName + "')";
            stmt.executeUpdate(insertAuthorTable);
            System.out.println("Author added");
        } catch(SQLException se) {
            System.out.println("Execute Update Failed!");
            se.printStackTrace();
        }
    }

    public static void updateAuthor(Statement stmt) {
        try {
            int authorId = 1;
            String newAuthorName = "Vovanchik";
            String updatePublisherTable = "UPDATE authors SET firstName='" + newAuthorName + "' WHERE authorID =" + authorId;
            stmt.executeUpdate(updatePublisherTable);
            System.out.println("FirstName changed");
        } catch (SQLException se) {
            System.out.println("Execute Update Failed!");
            se.printStackTrace();
        }
    }

    public static void insertTitle(Statement stmt){
        try {
            String isbn = "0307114278";
            String title = "Animal farm";
            String editionNumber = "1";
            String year = "1945";
            String price = "10";
            String publisherName = "Artem";
            String insertTitleTable = "INSERT INTO titles (isbn, title, editionNumber, year, publisherID, price) VALUES ('"+ isbn + "', '"+title +"', " + editionNumber + ", '" + year + "', "+ "(SELECT publisherID FROM publishers WHERE publisherName='"+publisherName+"')" + ", '" + price +"')";
            stmt.executeUpdate(insertTitleTable);
            System.out.println("Title added");
        } catch (SQLException se) {
            System.out.println("Execute Update Failed!");
            se.printStackTrace();
        }
    }
    public static void insertISBN(Statement stmt){
        try {
            String firstName = "Artem";
            String lastName = "Grudko";
            String isbn = "0307114278";
            String updateAuthorISBNTable = "INSERT INTO authorISBN (isbn, authorID) VALUES ('"+isbn+"', (SELECT authorID FROM authors WHERE firstName='"+firstName+"' AND lastName='"+lastName+"'))";
            stmt.executeUpdate(updateAuthorISBNTable);
            System.out.println("ISBNAuthor added");
        } catch (SQLException se) {
            System.out.println("Execute Update Failed!");
            se.printStackTrace();
        }
    }
}