package org.example;

import java.sql.*;
import java.util.*;
public class Database {


    public static Connection connect(){
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "Kjeks142356";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e); }

        return connection;

    }

    public static boolean CheckUserNameExist(String username) {

        Connection connection = null;
        boolean result = false;

        try
        {
            connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement("Select username from users where username = ?");
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()){
                result = true;
            }
        } catch ( Exception e)
        {
            e.printStackTrace();
        }

        return result;
    }

    public static String checkAccess(String username, String password){

        Connection connection = null;
        String name = null;
        int id = 0;
        String access = null;
        try
        {
            connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement("Select access from users where username = ? and password = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()){
                access = rs.getString("access");
            }
            connection.close();
        } catch (Exception e) { e.printStackTrace(); }

        return access;

    }

    public static boolean newUser(String username, String password, String access){

        Connection connection = null;
        boolean successfull = false;

        try
        {
            connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (username, password, access) VALUES (?, ?, ?)");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, access);
            preparedStatement.executeUpdate();
            connection.close();

            successfull = true;

        } catch (Exception e) { e.printStackTrace(); }

        return successfull;
    }

    public static boolean newQuestion(String question,String answer, String author){

        Connection connection = null;
        boolean successfull = false;

        try
        {
            connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Questions (Question, Answer, Author) VALUES (?, ?, ?)");
            preparedStatement.setString(1, question);
            preparedStatement.setString(2, answer);
            preparedStatement.setString(3, author);

            preparedStatement.executeUpdate();
            connection.close();

            successfull = true;

        } catch (Exception e) { e.printStackTrace(); }

        return successfull;
    }

    public static String getQuestion() {

        Connection connection = null;

        ArrayList<String> questions = new ArrayList<>();
        Random generator = new Random();

        try
        {
            connection = connect();
            String query = "SELECT Question FROM Questions";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                questions.add(rs.getString("Question"));
            }

        } catch (Exception e) { e.printStackTrace(); }


        int random = generator.nextInt(questions.size());
        return questions.get(random);
    }

    public static ArrayList<String> getAllQuestions() {

        Connection connection = null;

        ArrayList<String> questions = new ArrayList<>();

        try
        {
            connection = connect();
            String query = "SELECT Question FROM Questions";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                questions.add(rs.getString("Question"));
            }

        } catch (Exception e) { e.printStackTrace(); }



        return questions;
    }

    public static String getAnswerOne() {

        Connection connection = null;
        Map<String, String> questionsAnswers = new HashMap<String, String>();

        Random generator = new Random();

        try
        {
            connection = connect();

            String query = "SELECT Question, Answer FROM Questions";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                questionsAnswers.put(rs.getString("Question"), rs.getString("Answer"));
            }

        } catch (Exception e) { e.printStackTrace(); }

        String[] answers = new String[questionsAnswers.size()];
        int index = 0;
        for (Map.Entry<String, String> mapEntry : questionsAnswers.entrySet()){
            answers[index] = mapEntry.getValue();
            index++;
        }

        int random = generator.nextInt(questionsAnswers.size());
        return answers[random];
    }

    public static ArrayList<Integer> getId() {

        Connection connection = null;

        ArrayList<Integer> id = new ArrayList<>();

        try
        {
            connection = connect();
            String query = "SELECT id FROM users";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                id.add(rs.getInt("id"));
            }

        } catch (Exception e) { e.printStackTrace(); }

        return id;

    }

    public static ArrayList<String> getUserName() {

        Connection connection = null;

        ArrayList<String> username = new ArrayList<>();

        try
        {
            connection = connect();
            String query = "SELECT username FROM users";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                username.add(rs.getString("username"));
            }

        } catch (Exception e) { e.printStackTrace(); }

        return username;

    }

    public static HashMap<Integer, String[]> getUser() {

        Connection connection = null;

        HashMap<Integer, String[]> users = new HashMap<>();
        try
        {
            connection = connect();
            String query = "SELECT id, username, access FROM users";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                users.put(rs.getInt("id"), new String[] {rs.getString("username"), rs.getString("access")});
            }

        } catch (Exception e) { e.printStackTrace(); }

        return users;

    }

    public static ArrayList<String> getAccessDb() {

        Connection connection = null;

        ArrayList<String> access = new ArrayList<>();

        try
        {
            connection = connect();
            String query = "SELECT access FROM users";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                access.add(rs.getString("access"));
            }

        } catch (Exception e) { e.printStackTrace(); }

        return access;

    }

    public static boolean deleteUser(int id, String username){

        Connection connection = null;
        boolean successfull = false;

        try
        {
            connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id = ? and username = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, username);

            preparedStatement.executeUpdate();
            connection.close();
            successfull = true;

        } catch (Exception e) { e.printStackTrace(); }

        return successfull;
    }

    public static String findQuestionSource(String question) throws Exception {

        List<String> questionSplit = List.of(question.split(" "));
        Set<String> questionSourceSet = Set.of("name", "population", "capital", "area", "region", "subregion", "language", "nativeName");
        String source = "";

        for (String s: questionSplit ){
            for (String k: questionSourceSet){
                if (s.equalsIgnoreCase(k)){
                    source += k;
                    break;
                }
            }
        }

        return source;
    }

    public static String findQuestionCountry(String question) throws Exception{

        String [] questionSplitString = question.split(" ");
        ArrayList<String> names = new ArrayList<>(Api.countryNamesArrayList());
        StringBuilder country = new StringBuilder();
        ArrayList<String> questionSplit = new ArrayList<>(Arrays.asList(questionSplitString));

        for (String s: questionSplit){
            for (String j: names){
                if (s.equalsIgnoreCase(j)){
                    country.append(s);
                    break;
                }
            }
        }

        return country.toString();
    }

    public static String findQuestionCapital(String question) throws Exception{

        String [] questionSplitString = question.split(" ");
        ArrayList<String> capitalList = new ArrayList<>(Api.countryCapitalArrayList());
        StringBuilder capital = new StringBuilder();
        ArrayList<String> questionSplit = new ArrayList<>(Arrays.asList(questionSplitString));

        for (String s: questionSplit){
            for (String j: capitalList){
                if (s.equalsIgnoreCase(j)){
                    capital.append(s);
                    break;
                }
            }
        }

        return capital.toString();
    }


}
