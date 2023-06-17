/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package pizaaelsultan;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed
 */
public class PizaaElsultan extends Application {
   private static Stage stg;
    @Override
    public void start(Stage stage) throws Exception {
        stg=stage;
       stage.setResizable(false);
                Parent root=FXMLLoader.load(getClass().getResource("Login.fxml"));
                Scene scene =new Scene(root);
                stage.setTitle("PizzaElsultan");
                //scene.getStylesheets().add(getClass().getResource("admin.css").toExternalForm());
                 stage.setScene(scene);
                  stage.show();
    }

    
   public void changeScene(String fxml) throws IOException{
       Parent admin=FXMLLoader.load(getClass().getResource(fxml));
       stg.getScene().setRoot(admin);
      admin.getStylesheets().add(getClass().getResource("admin.css").toExternalForm());
   }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
       boolean x;
       System.out.println(x);
    }
    
}
