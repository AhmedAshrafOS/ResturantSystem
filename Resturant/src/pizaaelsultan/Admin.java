/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizaaelsultan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import pizaaelsultan.General;

/**
 *
 * @author Ahmed
 */
public class Admin extends General {

    public Admin(){
                this.fileData="C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\Data\\employee.txt";
                 this.fileDelete="C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\Data\\employee.txt";
                 this.fileSearch="C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\Data\\employee.txt";
                 this.fileLogin="C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\employee.txt";
    }    
    public Admin(int id,String name,int  age,String phoneNumber,String user,String pass){
            super(id,name,age,phoneNumber,user,pass);
                 this.fileData="C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\Data\\employee.txt";
                 this.fileDelete="C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\Data\\employee.txt";
                 this.fileSearch="C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\Data\\employee.txt";
                 this.fileLogin="C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\employee.txt";
        
    }

   
    public String addMeals(int id,String meals,int price) {

       try{
           OutputStream fmeal= new FileOutputStream ("C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\Data\\meals.txt",true);
                      try(
                              PrintWriter meal=new PrintWriter(fmeal);
                              )

                      {                           

                           meal.write(id+" "+meals+" "+price+"\n");

                      }
       }
    catch(FileNotFoundException e){
            return "Couldn't find file meals";
    }
       return "add Successfully";
    }
    public static ArrayList listMeals(){
                try{
                        File flist=new File("C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\Data\\meals.txt");
                        ArrayList<String> list=new ArrayList<>();
                      try (Scanner employee=new Scanner(flist)) {
                        String line;

                        int i=0;
                                 while (employee.hasNext()){
                                     line=employee.nextLine();
                                                        list.add(i, line+"\n");
                                                                i++;
                                                 }
                           
                        }
                                 return list;
                  } 

      catch (FileNotFoundException ex) {
          return null;
         }

}
    public String searchMeals(int id){

    try {
      File fadmin = new File("C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\Data\\meals.txt");
//open mealtxt for search
              try(
         Scanner embloyee=new Scanner(fadmin);
  //open file and close it by it self                    
                      )
                        {
                        String []info;
                        String idTemp=String.format("%d",id);
                      while (embloyee.hasNext()) {
                                 String temp = embloyee.nextLine();
                                    info = temp.split(" ");
                                    if(info[0].equals(idTemp)){
                                                    return temp;
                                            }
                                 }
                        }
      }
        catch (FileNotFoundException ex) {
            return "File Not Found";
    }
    return "Wrong ID";
     }
    public String removeMeals(int id){

    try {

      File fadmin = new File("C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\Data\\meals.txt");
      File tempFile = new File(fadmin.getAbsolutePath() + ".tmp");
        try(

         Scanner embloyee=new Scanner(fadmin);
          PrintWriter pw = new PrintWriter(tempFile);)
        {
        String []info;
        String idTemp=String.format("%d",id);
        //same number as "2"
      while (embloyee.hasNext()) {
                 String temp = embloyee.nextLine();
                 //temp="1 KOFTA 29"
                    info = temp.split(" ");
                    //info[0]=1 info[1]=kofta info[2]=29
                    if(!info[0].equals(idTemp)){
                           pw.print(temp);
                           pw.print("\n");
                            }
                 }
        }
      if (!fadmin.delete()) {
        return "Could not delete file";
      }
      if (!tempFile.renameTo(fadmin))
                return "Could not rename file";
      
    }
    catch (FileNotFoundException ex) {
        return null;
    }
    return "deleted Successfully";
  }
    public String updateMeals(int id,String name,int price){

    try {

      File fadmin = new File("C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\Data\\meals.txt");
      File tempFile = new File(fadmin.getAbsolutePath() + ".tmp");
        try(

         Scanner embloyee=new Scanner(fadmin);
          PrintWriter pw = new PrintWriter(tempFile);)
        {
        String []info;
        String idTemp=String.format("%d",id);
      while (embloyee.hasNext()) {
                 String temp = embloyee.nextLine();
                  //temp="1 KOFTA 29"
                    info = temp.split(" ");
                    if(info[0].equals(idTemp)){
                                temp=info[0]+" "+name+" "+price;
                            }
                       pw.print(temp);
                       pw.print("\n");
                 }
        }

      if (!fadmin.delete()) {
        return "Could not delete file";
      }
      if (!tempFile.renameTo(fadmin))
         return "Could not Rename file";

    }
    catch (FileNotFoundException ex) {
    }
    return "updated Successfully";
  }
    public String updateEmployee(int id,String name,String age,String phoneNumber,String user,String pass){
    try {
      File fadmin = new File("C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\Data\\employee.txt");
      File tempFile = new File(fadmin.getAbsolutePath() + ".tmp");
      File femployee = new File("C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\employee.txt");
      File tempFile2 = new File(femployee.getAbsolutePath() + ".tmp");
        try(
         Scanner embloyee=new Scanner(fadmin);
          PrintWriter pw = new PrintWriter(tempFile);)
        {
        String []info;
        String idTemp=String.format("%d",id);
      while (embloyee.hasNext()) {
                 String temp = embloyee.nextLine();
                    info = temp.split(" ");
                    if(info[0].equals(idTemp)){
                                temp=info[0]+" "+name+" "+age+" "+phoneNumber;
                            }
                       pw.print(temp);
                       pw.print("\n");
                 }
        }
        try(

         Scanner embloyee=new Scanner(femployee);
          PrintWriter pw = new PrintWriter(tempFile2);)
        {
        String []info;
      while (embloyee.hasNext()) {
                 String temp = embloyee.nextLine();
                    info = temp.split(" ");
                    if(info[0].equals(user)){
                                temp=user+" "+pass;
                            }
                       pw.print(temp);
                       pw.print("\n");
                 }
        }
      if (!fadmin.delete()) {
        return "Could not delete file";
      }
      if (!tempFile.renameTo(fadmin)){
        return "Could not rename file";
    }
      if (!femployee.delete()) {
        return "Could not delete file";
      }
      if (!tempFile2.renameTo(femployee)){
        return "Could not rename file";
    }
          return "Updated Successfully";
        }
    catch (FileNotFoundException ex) {
    }
    return "ID NOT FOUND";
    
}
}

