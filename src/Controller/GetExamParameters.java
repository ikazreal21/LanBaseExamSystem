/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Admin
 */
public class GetExamParameters {
    private static int multilimits;
    private static int idenlimits;
    
    private static String Student_name;
    private static String Subject;
    private static String GradePer;
    
    private static int Score;
   
    public static void setMultiLimit(int limit, String subject, String gradeper){
        multilimits = limit;
        Subject = subject;
        GradePer = gradeper;
        System.out.println(multilimits);
        System.out.println(Subject);
    }
    
    public static int GetMultiLimit(){
        System.out.println(multilimits);
        return multilimits;
    }
    
    public static String GetSubject(){
        System.out.println(Subject);
        return Subject;
    }
    
    public static String GetGrading(){
        return GradePer;
    }
    
    public static void setIdentLimit(int limit, String subject, String gradeper){
        idenlimits = limit;
        Subject = subject;
        GradePer = gradeper;
        System.out.println(idenlimits);
    }
    
    public static int GetIdenLimit(){
        System.out.println(idenlimits);
        return idenlimits;
    }
    
    public static void SetStudentName(String student){
        Student_name = student;
    }
    
    public static String GetStudent(){
        return Student_name;
    }
    
    public static void AddScore() {
        Score = Score + 1;
        System.out.println("Score:" + Score);
    }
    
    public static int GetScore() {
        return Score;
    }
    
    public static void ResetScore() {
        Score = 0;
    }
}
