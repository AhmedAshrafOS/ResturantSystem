/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pizaaelsultan;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */    

public class AdminController implements Initializable {
         @FXML
    private Label addLEmployee;
     @FXML
    private TextField idEmployee;
     @FXML
    private TextField nameEmployee;
     @FXML
    private TextField ageEmployee;
     @FXML
    private TextField phoneNumberEmployee;
     @FXML
    private TextField userEmployee;
     @FXML
    private TextField passEmployee;
     @FXML
    private TextField price;
     @FXML
    private BorderPane bb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

@FXML
    private void addEmployee(MouseEvent event) {
        loadPage("addEmployee.fxml");

    }
    public void addBEmployee(ActionEvent event){
Admin a1=new Admin(Integer.valueOf(idEmployee.getText()),nameEmployee.getText(),Integer.valueOf(ageEmployee.getText()),phoneNumberEmployee.getText(),userEmployee.getText(),passEmployee.getText());
           addLEmployee.setText(a1.add());
        }
    @FXML
    private void listEmployee(MouseEvent event) {
        loadPage("listEmployee.fxml");
    }
    public void listBEmployee(ActionEvent event){
            Admin a1=new Admin();
            String a =" ";
            for(int i=0;i<a1.list().size();i++){
                a=a+" "+(String) a1.list().get(i)+"\n";
                    }
               addLEmployee.setText(a);
        }
    @FXML
    private void searchEmployee(MouseEvent event) {
        loadPage("searchEmployee.fxml");
    }
    public void searchBEmployee(ActionEvent event){
         Admin a1=new Admin();
         String a=" "+a1.search(Integer.valueOf(idEmployee.getText()),"0")+" ";
         addLEmployee.setText(a);  
        }
    @FXML
    private void removeEmployee(MouseEvent event) {
        loadPage("removeEmployee.fxml");
    }
    public void removeBEmployee(ActionEvent event){
         Admin a1=new Admin();
         String a=" "+a1.removeID(Integer.valueOf(idEmployee.getText()))+" ";
         addLEmployee.setText(a);  
        }
    @FXML
    private void updateEmployee(MouseEvent event) {
        loadPage("updateEmployee.fxml");
    }
    public void updateBEmployee(ActionEvent event){
         Admin a1=new Admin();
         String a=" "+a1.updateEmployee(Integer.valueOf(idEmployee.getText()),nameEmployee.getText(),ageEmployee.getText(),phoneNumberEmployee.getText(),userEmployee.getText(),passEmployee.getText());
         addLEmployee.setText(a);  
        }
    @FXML
    private void addMeals(MouseEvent event) {
        loadPage("addMeals.fxml");
    }
    public void addBMeals(ActionEvent event){
         Admin a1=new Admin();
         String a=" "+a1.addMeals(Integer.valueOf(idEmployee.getText()),nameEmployee.getText(),Integer.valueOf(price.getText()));
         addLEmployee.setText(a);
        }
    @FXML
    private void listMeals(MouseEvent event) {
        loadPage("listMeals.fxml");
    }
    public void listBMeals(ActionEvent event){
            Admin a1=new Admin();
            String a =" ";
            for(int i=0;i<Admin.listMeals().size();i++){
                a=a+" "+(String) Admin.listMeals().get(i)+"\n";
                    }
               addLEmployee.setText(a);
        }
    @FXML
    private void searchMeals(MouseEvent event) {
        loadPage("searchMeals.fxml");
    }
        public void searchBMeals(ActionEvent event){
         Admin a1=new Admin();
         String a=" "+a1.searchMeals(Integer.valueOf(idEmployee.getText()))+" ";
         addLEmployee.setText(a);  
        }
    @FXML
    private void removeMeals(MouseEvent event) {
        loadPage("removeMeals.fxml");
    }
    public void removeBMeals(ActionEvent event){
         Admin a1=new Admin();
         String a=" "+a1.removeMeals(Integer.valueOf(idEmployee.getText()))+" ";
         addLEmployee.setText(a);  
        }
    @FXML
    private void updateMeals(MouseEvent event) {
        loadPage("updateMeals.fxml");
    }
    public void updateBMeals(ActionEvent event){
         Admin a1=new Admin();
         String a=" "+a1.updateMeals(Integer.valueOf(idEmployee.getText()),nameEmployee.getText(),Integer.valueOf(price.getText()));
         addLEmployee.setText(a);
        }
    @FXML
    private void logOrder(MouseEvent event) {
        loadPage("logOrder.fxml");
    }
        public void listBOrder(ActionEvent event){
         Embloyee a1=new Embloyee();
            String a =" ";
            for(int i=0;i<a1.bilingList().size();i++){
                a=a+" "+(String) a1.bilingList().get(i)+"\n";
                    }
               addLEmployee.setText(a);
        }
    public void userlogout(ActionEvent event) throws IOException{
              PizaaElsultan m=new PizaaElsultan();
              m.changeScene("Login.fxml");
    }
        private void loadPage(String page){
        Parent root=null;
        try {
            root=FXMLLoader.load(getClass().getResource(page));
        } catch (IOException ex) {
        }
        
        bb.setCenter(root);
    }
}
