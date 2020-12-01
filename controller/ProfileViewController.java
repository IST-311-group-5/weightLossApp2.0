/*
 * Weightloss App
 * Group 5 
 * IST 311
 */
package Controller;
import Model.Usermodel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 */

public class ProfileViewController implements Initializable {
    
    EntityManager manager;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button viewLogButton;

    @FXML
    private Button createLogButton;
    
    @FXML
    private TextField idBox;
    
    @FXML
    private TextField nameBox;

    @FXML
    private TextField heightBox;

    @FXML
    private TextField weightBox;

    @FXML
    private Text goalsBox;

    @FXML
    private TextField ageBox;

    @FXML
    private TextField bmiBox;

    @FXML
    private TextField bmiStatus;

    @FXML
    private TableView<?> logsTable;

    @FXML
    private TableColumn<?, ?> logID;

    @FXML
    private TableColumn<?, ?> logDate;

    @FXML
    private TableColumn<?, ?> logPreview;
    
    @FXML
    private Button updateInfo;
    
    @FXML
    private Button logOut;

    @FXML
    private Button quit;
    
    Scene previousScene;


    @FXML
    void createLog(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/CreateLogView.fxml"));

        Parent detailedModelView = loader.load();

        Scene tableViewScene = new Scene(detailedModelView);

        CreateLogViewController newLogController = loader.getController();

        Stage stage = new Stage();
        stage.setScene(tableViewScene);
        stage.show();

    }
    
    public void setPreviousScene(Scene scene) {
        previousScene = scene;

    }

    @FXML
    void viewLog(ActionEvent event) {
        System.out.println("You are a twinkie");

    }
    
    @FXML
    void idBox(ActionEvent event) {

    }
    
      @FXML
    void ageBox(ActionEvent event) {

    }

    @FXML
    void bmiBox() {

    }

    @FXML
    void bmiStatus(ActionEvent event) {

    }

    @FXML
    void heightBox(ActionEvent event) {

    }

    @FXML
    void nameBox(ActionEvent event) {

    }
    
    @FXML
    void weightBox(ActionEvent event) {

    }
    
    @FXML
    void updateInfo(ActionEvent event) throws IOException { //opens up the update info page. 
                
        Usermodel user = new Usermodel();
        
        String id = idBox.getText();        
        int intUserID = Integer.parseInt(id);

        String name = nameBox.getText();

        String height = heightBox.getText();

        String weight = weightBox.getText();
        Double userWeight = Double.parseDouble(weight);

        String age = ageBox.getText();
        int userAge = Integer.parseInt(age);

        user.setId(intUserID);
        user.setName(name);
        user.setHeight(height);
        user.setWeight(userWeight);
        user.setAge(userAge);
        
    //------------------Close the profile page and update account------------------  

        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/UpdateInfoView.fxml"));

        Parent profileView = loader.load();

        Scene newScene = new Scene(profileView);

        UpdateAccountController updateAccount = loader.getController();

        updateAccount.initData(user);

        Stage stage = new Stage();
        stage.setScene(newScene);
        
        Stage closeAccountInfo = (Stage) ((Node) event.getSource()).getScene().getWindow();
        closeAccountInfo.close();
              

        stage.show();

    }
    
    @FXML
    void logOut(ActionEvent event) throws IOException { // it means what is says
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/LogInView.fxml"));

        Parent logIn = loader.load();

        Scene logInScene = new Scene(logIn);
        
        Stage profileView = (Stage) ((Node) event.getSource()).getScene().getWindow();
        profileView.close();

        Stage stage = new Stage();
        stage.setScene(logInScene);
        stage.show();

    }
    
    @FXML
    void quit(ActionEvent event) { // closes the whole app
        
        Platform.exit();

    }
    
    
    public void calculateBMI(String height, Double weight) { // fix cancel on the uodate account

        int userFeet;
        int userInches;

        if(heightBox.getText().length() == 4){

            String feet = heightBox.getText().substring(0,1);
            String inches = heightBox.getText().substring(2,3);

            userFeet = Integer.parseInt(feet);
            userInches = Integer.parseInt(inches);

            int heightInInches = (userFeet * 12) + userInches;
            Double bmi = (weight * 703.0) / (heightInInches * heightInInches);
            String stringBmi = String.format("%.2f", bmi);

            bmiBox.setText(stringBmi);
            getBMICategory(bmi);

        } else if (heightBox.getText().length() == 5){

            String feet = heightBox.getText().substring(0,1);
            String inches = heightBox.getText().substring(2,4);

            userFeet = Integer.parseInt(feet);
            userInches = Integer.parseInt(inches);

            int heightInInches = (userFeet * 12) + userInches;
            Double bmi = (weight * 703) / (heightInInches * heightInInches);
            String stringBmi = String.format("%.2f", bmi);
            
            bmiBox.setText(stringBmi);  
            getBMICategory(bmi);
        }

    }
    public void getBMICategory(Double bmi) { 
        
        if (bmi <= 18.5) {
            bmiStatus.setText("Underweight");
        } else if (bmi < 25) {
            bmiStatus.setText("Normal Weight");
        } else if (bmi < 30) {
            bmiStatus.setText("Overweight");
        } else{
            bmiStatus.setText("Obese");
        }
              
    }
    
     public void initData(Usermodel user) {  // initial data when the page is opened. 
        
        idBox.setText("" + user.getId());
        nameBox.setText(user.getName());
        heightBox.setText(user.getHeight());
        weightBox.setText("" + user.getWeight());
        ageBox.setText("" + user.getAge());
        
        calculateBMI(user.getHeight(), user.getWeight());
               
    }
    
    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        assert nameBox != null : "fx:id=\"nameBox\" was not injected: check your FXML file 'ProfileView.fxml'.";
        assert heightBox != null : "fx:id=\"heightBox\" was not injected: check your FXML file 'ProfileView.fxml'.";
        assert weightBox != null : "fx:id=\"weightBox\" was not injected: check your FXML file 'ProfileView.fxml'.";
        assert goalsBox != null : "fx:id=\"goalsBox\" was not injected: check your FXML file 'ProfileView.fxml'.";
        assert ageBox != null : "fx:id=\"ageBox\" was not injected: check your FXML file 'ProfileView.fxml'.";
        assert bmiBox != null : "fx:id=\"bmiBox\" was not injected: check your FXML file 'ProfileView.fxml'.";
        assert bmiStatus != null : "fx:id=\"bmiStatus\" was not injected: check your FXML file 'ProfileView.fxml'.";
        assert logsTable != null : "fx:id=\"logsTable\" was not injected: check your FXML file 'ProfileView.fxml'.";
        assert logID != null : "fx:id=\"logID\" was not injected: check your FXML file 'ProfileView.fxml'.";
        assert logDate != null : "fx:id=\"logDate\" was not injected: check your FXML file 'ProfileView.fxml'.";
        assert logPreview != null : "fx:id=\"logPreview\" was not injected: check your FXML file 'ProfileView.fxml'.";
        assert viewLogButton != null : "fx:id=\"viewLogButton\" was not injected: check your FXML file 'ProfileView.fxml'.";
        assert createLogButton != null : "fx:id=\"createLogButton\" was not injected: check your FXML file 'ProfileView.fxml'.";
        assert updateInfo != null : "fx:id=\"updateInfo\" was not injected: check your FXML file 'ProfileView.fxml'.";
        assert idBox != null : "fx:id=\"idBox\" was not injected: check your FXML file 'ProfileView.fxml'.";
        assert logOut != null : "fx:id=\"logOut\" was not injected: check your FXML file 'ProfileView.fxml'.";
        assert quit != null : "fx:id=\"quit\" was not injected: check your FXML file 'ProfileView.fxml'.";

    }
   

}
