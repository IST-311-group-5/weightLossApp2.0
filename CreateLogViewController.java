/*
 * Weightloss App
 * Group 5 
 * IST 311
 */
package Controller;

import Model.Logmodel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;


/**
 * FXML Controller class
 * Empty commit
 * 
 */
public class CreateLogViewController implements Initializable {

    //Database manager
    EntityManager manager;
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField logNumberField;

    @FXML
    private TextField logDateField;

    @FXML
    private TextArea logContentField;

    @FXML
    private Button saveLogButton;

    @FXML
    private Button cancelLogButton;

     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        manager = (EntityManager) Persistence.createEntityManagerFactory("WeightLossAppFXMLPU").createEntityManager();
    }
    
    /********************************Button Operations************************************/
    
    @FXML
    void cancelLog(ActionEvent event) {

    }

    /**
     * This is a CREATE function
     * 
     * @param event 
     */
    @FXML
    void saveLog(ActionEvent event) {
        Integer logNum = Integer.parseInt(logNumberField.getText());
        String logDate = logDateField.getText();
        String logContent = logContentField.getText();
        
        Logmodel log = new Logmodel();
        
        log.setId(logNum);
        log.setDate(logDate);
        log.setContent(logContent);
        
        save(log);
    }
    
    /********************************Helper Methods************************************/

    public void save(Logmodel log){
          try {
            manager.getTransaction().begin();

            if (log.getId() != null) {

                manager.persist(log);

                manager.getTransaction().commit();

                System.out.println(log.toString() + " has been created & saved.");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

   
}
