
package pizaaelsultan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Ahmed
 */

public class Login {
//class Login 
    public Login(){
        
    }
     @FXML
    private Button loginButton;
     @FXML
    private Label wrongLogin;
     @FXML
    private TextField user;
     @FXML
    private PasswordField pass;
     
  public void userLogin(ActionEvent event) throws IOException{
      PizaaElsultan m=new PizaaElsultan();
        switch (checklog(user,pass)) {
            case 1:
                wrongLogin.setText("Successfully Login as Admin user");
                m.changeScene("Admin.fxml");
                break;
            case 2:
                wrongLogin.setText("Successfully Login as Employee user");
               m.changeScene("Employee.fxml"); 
                break;
            default:
                wrongLogin.setText("Wrong user name or password!!");
                break;
        }
      
  }
public int checklog(TextField user,TextField pass){
       try{ 
           File fadmin= new File ("C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\admin.txt");
           File femployee= new File ("C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\employee.txt");
//open 2 file 1 for admin and 1 for employee 
                              
                    try(
                              Scanner admin=new Scanner(fadmin);
//scan for read lines from project                            
                                    )

                      {

                          String []info;
                              while(admin.hasNextLine()){
                                String temp = admin.nextLine();
                                info = temp.split(" ");
                                if(info[0].equals(user.getText()) && info[1].equals(pass.getText()))
                                {

                                  return 1;
                                }
                                }

                      }
                  try(Scanner employee =new Scanner(femployee);){
                          String []info;
                           while(employee.hasNextLine()){
                                   String temp = employee.nextLine();
                                   info = temp.split(" ");
                                            if(info[0].equals(user.getText()) && info[1].equals(pass.getText()))
                                                    {
                                                        return 2;
                                                    } 
                                        }
                           }
       }
    catch(FileNotFoundException e){
        System.out.println("Couldn't find file 1");
}
       return 0;
}
public static   boolean checkrRepeat(int id,String user){
           File femployee= new File ("C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\admin.txt");
           File femployee2= new File ("C:\\Users\\Ahmed\\Documents\\NetBeansProjects\\PizaaElsultan\\Files\\Data\\employee.txt");
       try{
                      try(
                              Scanner employee=new Scanner(femployee);
                              Scanner employee2 =new Scanner(femployee2);
                              )

                      {

                          String []info;
                              while(employee.hasNextLine()){
                                String temp = employee.nextLine();
                                info = temp.split(" ");

                                //info[0] = id, info[1] = username, info[2] = password, info[3] 
                                //Right here that means the username and password is correct
                                if(info[0].equals(user))
                                {
                                         while(employee2.hasNextLine()){
                                              int temp2 = employee2.nextInt();
                                
                                //info[0] = id, info[1] = username, info[2] = password, info[3] 
                                //Right here that means the username and password is correct
                                if(id==temp2)
                                {
                                    return true;
                                } }
                                }

                                }
                            return false;
                      }
       }
    catch(FileNotFoundException e){
        System.out.println("Couldn't find file"); 
            return false;
    }
    
    
}
}

