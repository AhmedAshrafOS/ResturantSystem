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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class EmployeeController implements Initializable {

         @FXML
    private Label addLCustomers;
     @FXML
    private TextField idCustomers;
     @FXML
    private TextField nameCustomers;
     @FXML
    private TextField ageCustomers;
     @FXML
    private TextField phoneNumberCustomers;
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
    private void addCustomers(MouseEvent event) {
        loadPage("addCustomers.fxml");

    }
    public void addBCustomers(ActionEvent event){
Embloyee a1=new Embloyee(Integer.valueOf(idCustomers.getText()),nameCustomers.getText(),Integer.valueOf(ageCustomers.getText()),phoneNumberCustomers.getText(),userEmployee.getText(),passEmployee.getText());
           addLCustomers.setText(a1.add());
        }
    @FXML
    private void listCustomers(MouseEvent event) {
        loadPage("listCustomers.fxml");
    }
    public void listBCustomers(ActionEvent event){
            Embloyee a1=new Embloyee();
            String a =" ";
            for(int i=0;i<a1.list().size();i++){
                a=a+" "+(String) a1.list().get(i)+"\n";
                    }
               addLCustomers.setText(a);
        }
    @FXML
    private void searchCustomers(MouseEvent event) {
        loadPage("searchCustomers.fxml");
    }
    public void searchBCustomers(ActionEvent event){
         Embloyee a1=new Embloyee();
         String a=" "+a1.search(0,phoneNumberCustomers.getText())+" ";
         addLCustomers.setText(a);
        }
    @FXML
    private void removeCustomers(MouseEvent event) {
        loadPage("removeCustomers.fxml");
    }
    public void removeBCustomers(ActionEvent event){
         Embloyee a1=new Embloyee();
         String a=" "+a1.removeID(Integer.valueOf(idCustomers.getText()))+" ";
         addLCustomers.setText(a);
        }
    @FXML
    private void updateCustomers(MouseEvent event) {
        loadPage("updateCustomers.fxml");
    }
    public void updateBCustomers(ActionEvent event){
         Embloyee a1=new Embloyee();
         String a=" "+a1.updateCustomer(Integer.valueOf(idCustomers.getText()),nameCustomers.getText(),ageCustomers.getText(),phoneNumberCustomers.getText());
         addLCustomers.setText(a);
        }
    @FXML
    private void makeOrder(MouseEvent event) {
        loadPage("Order.fxml");
    }
    public void makeBOrder(ActionEvent event){
         Embloyee a1=new Embloyee();
         String a=" "+a1.order(phoneNumberCustomers.getText(), Integer.valueOf(idCustomers.getText()), Integer.valueOf(ageCustomers.getText()));
         addLCustomers.setText(a);
        }
    @FXML
    private void cancelOrder(MouseEvent event) {
        loadPage("cancelOrder.fxml");
    }
    public void cancelBOrder(ActionEvent event){
            Embloyee a1=new Embloyee();
         String a=" "+a1.cancelOrder(Integer.valueOf(ageCustomers.getText()),phoneNumberCustomers.getText())+" ";
         addLCustomers.setText(a);  
        }
    @FXML
    private void searchOrder(MouseEvent event) {
        loadPage("searchOrder.fxml");
    }
        public void searchBOrder(ActionEvent event){
         Embloyee a1=new Embloyee();
         String a=" "+a1.bilingSearch(Integer.valueOf(idCustomers.getText()))+" ";
         addLCustomers.setText(a);  
        }
    @FXML
    private void logOrder(MouseEvent event) {
        loadPage("logOrder.fxml");
    }
        public void listBOrder(ActionEvent event){
         Embloyee a1=new Embloyee();
            String a =" ";
            for(int i=0;i<a1.list().size();i++){
                a=a+" "+(String) a1.bilingList().get(i)+"\n";
                    }
               addLCustomers.setText(a);
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
