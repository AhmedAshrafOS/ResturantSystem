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
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ahmed
 */
public class Embloyee extends General  {
    private String fileLog;
        public Embloyee(){
                  this.fileData="C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\Data\\customers.txt";
                 this.fileDelete="C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\Data\\customers.txt";
                 this.fileSearch="C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\Data\\customers.txt";
                 this.fileLogin="C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\log\\customersAddlog.txt";
                 this.fileLog="C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\log\\order.txt";
    }    
    public Embloyee(int id,String name,int  age,String phoneNumber,String user,String pass){
            super(id,name,age,phoneNumber,user,pass);
                 this.fileData="C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\Data\\customers.txt";
                 this.fileDelete="C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\Data\\customers.txt";
                 this.fileSearch="C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\Data\\customers.txt";
                 this.fileLogin="C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\log\\customersAddlog.txt";
                 this.fileLog="C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\log\\order.txt";
    }

    
    //order for phone number for food id
    public  String order(String phoneNumber,int id,int numOrder){
        double sum=0;
    try {
      File fadmin = new File("C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\Data\\meals.txt");
      OutputStream forder= new FileOutputStream (fileLog,true);
              try(
         Scanner embloyee=new Scanner(fadmin);
         PrintWriter order=new PrintWriter(forder);
                      )

                        {
                        String []info;
                        String idTemp=String.format("%d",id);
                      while (embloyee.hasNext()) {
                                 String temp = embloyee.nextLine();
                                    info = temp.split(" ");
                                    if(info[0].equals(idTemp)){
                                           profile(phoneNumber);
                                        switch (points(phoneNumber)){
                                            case 1: 
                                                  sum=.02*Integer.parseInt(info[2])+Integer.parseInt(info[2]);
                                               order.print(numOrder+" The "+info[1]+" and its id "+info[0]+" ordered  for Silver Customer "+phoneNumber+" total price is "+sum);
                                                            order.print("\n");
                                                  return  " The order created for Silver Customer and it is a "+info[1]+" Total Price is:  "+sum+" he got 2% in his bill ";
                                            case 2: 
                                                  sum=.05*Integer.parseInt(info[2])+Integer.parseInt(info[2]);
                                               order.print(numOrder+" The "+info[1]+" and its id "+info[0]+" ordered  for Gold Customer "+phoneNumber+" total price is "+sum);
                                                            order.print("\n");
                                                  return " The order has been created for Gold Customer and it is a "+info[1]+" Total Price is:  "+sum+" he got 5% in his bill ";
                                            case 3: 
                                                  sum=.1*Integer.parseInt(info[2])+Integer.parseInt(info[2]);
                                               order.print(numOrder+" The "+info[1]+" and its id "+info[0]+" ordered by  for Diamond Customer "+phoneNumber+" total price is "+sum);
                                                            order.print("\n");
                                                  return " The order created for Diamond Customer and it is a "+info[1]+" Total Price is:  "+sum+" he got 10% in his bill ";
                                            default: 
                                                  sum=Integer.parseInt(info[2]);
                                               order.print(numOrder+" The "+info[1]+" and its id "+info[0]+" ordered for this Customer "+phoneNumber+" total price is "+sum);
                                                            order.print("\n");
                                                  return " The order created for new Customer and the order is  "+info[1]+" Total Price is: "+sum;
                                        }



                                            }
                                 }

                        }
      }
        catch (FileNotFoundException ex) {
    }
    return "WrongID";
    }
    private void profile(String phoneNumber){
        try {
         String [] info =this.search(id,phoneNumber).split(" ");
         String []info2;
         File f = new File("C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\Profiles\\"+info[0]+".txt");
            if(f.exists()) { 
                         File femployee= new File ("C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\Profiles\\"+info[0]+".txt");
                         try( 
                                 Scanner employees=new Scanner(femployee);
                                 ){

                                        String temp;
                                                     temp=employees.nextLine();
                                                     info2=temp.split(" ");

                         }
                         try( 
                                 PrintWriter employee=new PrintWriter(femployee);
                                 ){
                                                     String point;
                                                     String temp;
                                                      int i=Integer.valueOf(info2[4])+15;
                                                       point= String.format("%d",i);
                                                       temp=info2[0]+" "+info2[1]+" "+info2[2]+" "+info2[3]+" "+point;
                                                           employee.print(temp);
                         }
                        }
            else                         
                try( PrintWriter profile=new PrintWriter("C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\Profiles\\"+info[0]+".txt");){
                             profile.println(this.search(id,phoneNumber)+" "+15);
                         }

        } 
        catch (FileNotFoundException ex) {
        }
    }
    private  int points(String phoneNumber){
        try {
         String [] info =this.search(0,phoneNumber).split(" ");
                         File femployee= new File ("C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\Profiles\\"+info[0]+".txt");
                         try( Scanner profile=new Scanner(femployee);){
                             String[]info2=profile.nextLine().split(" ");
                               int i=Integer.parseInt(info2[4]);
                                if(i>=30&&i<100){
                                    return 1;
                                }
                                if(i>=100&&i<500){
                                    return 2;
                                }
                                if(i>=500){
                                    return 3;
                                }
                         }



        } 
        catch (FileNotFoundException ex) {
        }
        return 4;
    }
    public String cancelOrder(int numOrder,String phoneNumber){
         String [] info2 =this.search(0,phoneNumber).split(" ");
         String[]info3;
                    try {

                            File fadmin = new File(this.fileLog);
                            File tempFile = new File(fadmin.getAbsolutePath() + ".tmp");
                            File fprofile = new File("C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\Profiles\\"+info2[0]+".txt");

                        try(
                                
                         Scanner embloyee=new Scanner(fadmin);
                          PrintWriter pw = new PrintWriter(tempFile);)
                        {
                        String []info;
                        String idTemp=String.format("%d",numOrder);
                      //Read from the original file and write to the new
                      //unless content matches data to be removed.
                      while (embloyee.hasNext()) {
                                 String temp = embloyee.nextLine();
                                    info = temp.split(" ");
                                    if(!info[0].equals(idTemp)){
                                                     pw.print(temp);
                                                    pw.print("\n");
                                            }

                                 }
                        }
                             try( 
                                 Scanner employees=new Scanner(fprofile);
                                 ){

                                        String temp;
                                                     temp=employees.nextLine();
                                                     info3=temp.split(" ");

                         }
                         try( 
                                 PrintWriter employee=new PrintWriter(fprofile);
                                 ){
                                                     String point;
                                                     String temp;
                                                      int i=Integer.valueOf(info3[4])-15;
                                                       point= String.format("%d",i);
                                                       temp=info3[0]+" "+info3[1]+" "+info3[2]+" "+info3[3]+" "+point;
                                                           employee.print(temp);
                         }

                      if (!fadmin.delete()) {
                        System.out.println("Could not delete file");
                      }
                      if (!tempFile.renameTo(fadmin)){
                        System.out.println("Could not rename file");
                      }
                              return "Order Cancelled Successfully!!";
                    }
                    catch (FileNotFoundException ex) {
                    }
        
        
        return "Wrong Num Order";
    }
    public ArrayList bilingList(){


               try{
                        ArrayList<String> list=new ArrayList<>();
                        //make list from type string
                        File flist=new File(fileLog);
                        //make file open filelog refere to order.txt
                      try (Scanner employee=new Scanner(flist)) {
                        String line;
                        int i=0;
                                    if(!employee.hasNext()){
                                           list.add(0,"NoOrder");
                                    }
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
    public String bilingSearch(int id){
        //id refer to order number
    try {
      File fadmin = new File("C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\log\\order.txt");
      if (!fadmin.isFile()) {
        System.out.println("File Not Found");
      }
              try(
         Scanner embloyee=new Scanner(fadmin);)
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
                            return "NotFound";
                        }
      }
        catch (FileNotFoundException ex) {
    }
        return null;
    }
    public String updateCustomer(int id,String name,String age,String phoneNumber){
    try {

      File fadmin = new File("C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\Data\\customers.txt");
      File tempFile = new File(fadmin.getAbsolutePath() + ".tmp");
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

      if (!fadmin.delete()) {
        return "Could not delete file";
      }
      if (!tempFile.renameTo(fadmin))
         return "Could not Rename file";
      
          return "UpdatedSuccessfully!!";

    }
    catch (FileNotFoundException ex) {
        
    }

        return "ID NOT FOUND";
}
}
