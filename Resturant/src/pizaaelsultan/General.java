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
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Ahmed
 */
public abstract class General {
            protected int id;
            protected String name;
            protected int  age;
            protected String phoneNumber;
            protected String fileData;
            protected String fileLogin;
            protected String fileDelete;
            protected String fileSearch;
            protected String user;
            protected String pass;
        public General(){
            
        }
        public General( int id,String name,int  age,String phoneNumber,String user,String pass){
                this.id=id;
                this.name=name;
                this. age=age;
                this.phoneNumber=phoneNumber;
                this.user=user;
                this.pass=pass;      
        }
        public String add() {

                try{
                    OutputStream femployee= new FileOutputStream (fileLogin,true);
                    OutputStream femployee2= new FileOutputStream (fileData,true);
                               try(
                                       PrintWriter employee2=new PrintWriter(femployee2);
                                       PrintWriter employee=new PrintWriter(femployee);
                                       )

                               {                           
                                    employee2.print(this.id+" "+this.name+" "+this.age+" "+this.phoneNumber);
                                    employee2.print("\n");
                                    employee.write(this.user+" ");
                                    employee.println(this.pass);
                                    return "add Successfully";
                               }
                }
             catch(FileNotFoundException e){
                 return"Couldn't find file employee"; 
                 }
             }
        public ArrayList list(){
                try{
                        File flist=new File(fileData);
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
        public String search(int id,String phoneNumber){

    try {

      File fadmin = new File(fileSearch);
              try(
         Scanner employee=new Scanner(fadmin);)
                        {
                        String []info;
                        String idTemp=String.format("%d",id);
                      while (employee.hasNext()) {
                                 String temp = employee.nextLine();
                                    info = temp.split(" ");
                                    if(info[3].equals(phoneNumber)){
                                                return temp;
                                            }
                                    else if(info[0].equals(idTemp)){
                                                return temp;
                                            }
                                 }
                        return "Not Found ";
                        }
      }
        catch (FileNotFoundException ex) {
              return "File Not Found";
    }

     }
        public String removeID(int id){

    try {

      File fadmin = new File(fileDelete);
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
                    if(!info[0].equals(idTemp)){
                           pw.print(temp);
                           pw.print("\n");
                            }
                 }
            }

      if (!fadmin.delete()) {
        return "Could not delete file" ;
      }
      if (!tempFile.renameTo(fadmin))
        return "Could not rename file" ;
      return "Removed Successfully";
    }
    catch (FileNotFoundException ex) {
        return "Could Found file" ;
    }

  }
}

