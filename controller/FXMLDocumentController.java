/*
 * Weightloss App
 * Group 5 
 * IST 311
 */
package Controller;

import Model.Usermodel;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FXMLDocumentController implements Initializable {

    //Database manager
    EntityManager manager;

    @FXML
    private Label label;

    @FXML
    private Button buttonCreate;

    @FXML
    private Button buttonRead;

    @FXML
    private Button buttonUpdate;

    @FXML
    private Button buttonDelete;

    @FXML
    private Button buttonFindByNameAge;

    @FXML
    private Button buttonReadByNameAge;
    
    @FXML
    private Button buttonSearch;
    
    @FXML
    private Button buttonAdvancedSearch;
     
    @FXML
    private Button buttonShowDetails;
    
    @FXML
    private Button buttonShowDetailsInPlace;

    @FXML
    private TextField searchBar;

    @FXML
    private TableView<Usermodel> userTable;

    @FXML
    private TableColumn<Usermodel, Integer> userID;

    @FXML
    private TableColumn<Usermodel, String> userName;

    @FXML
    private TableColumn<Usermodel, String> userHeight;

    @FXML
    private TableColumn<Usermodel, Double> userWeight;

    @FXML
    private TableColumn<Usermodel, Integer> userAge;
    
    private ObservableList<Usermodel> userData;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        manager = (EntityManager) Persistence.createEntityManagerFactory("WeightLossAppFXMLPU").createEntityManager();
        
        userName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        userID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        userHeight.setCellValueFactory(new PropertyValueFactory<>("Height"));
        userWeight.setCellValueFactory(new PropertyValueFactory<>("Weight"));
        userAge.setCellValueFactory(new PropertyValueFactory<>("Age"));

        userTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    /************************ CRUD Operations *****************************/

    @FXML
    void createUser(ActionEvent event) { //left these in here for you guys for your tables
        Scanner input = new Scanner(System.in);

        System.out.println("Enter ID: ");
        int id = input.nextInt();

        System.out.println("Enter Name: ");
        String name = input.next();

        System.out.println("Enter Height: ");
        String height = input.next();

        System.out.println("Enter Weight: ");
        Double weight = input.nextDouble();

        System.out.println("Enter Age: ");
        int age = input.nextInt();

        Usermodel user = new Usermodel();

        user.setId(id);
        user.setName(name);
        user.setHeight(height);
        user.setWeight(weight);
        user.setAge(age);

        create(user);
    }

    @FXML
    void readUser(ActionEvent event) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter ID:");
        int id = input.nextInt();

        Usermodel user = readById(id);
        System.out.println(user.toString());
    }

    @FXML
    void updateUser(ActionEvent event) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter ID: ");
        int id = input.nextInt();

        System.out.println("Enter new Name: ");
        String name = input.next();

        System.out.println("Enter new Height: ");
        String height = input.next();

        System.out.println("Enter new Weight: ");
        Double weight = input.nextDouble();

        System.out.println("Enter new Age: ");
        int age = input.nextInt();

        Usermodel user = new Usermodel();

        user.setId(id);
        user.setName(name);
        user.setHeight(height);
        user.setWeight(weight);
        user.setAge(age);

        System.out.println("User of id: " + id + " has been updated.");
        update(user);
    }

    @FXML
    void deleteUser(ActionEvent event) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter ID:");
        int id = input.nextInt();

        Usermodel user = readById(id);
        System.out.println("we are deleting this user: " + user.toString());
        delete(user);

    }

    @FXML
    void findByNameAge(ActionEvent event) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Name:");
        String name = input.next();

        System.out.println("Enter Age:");
        int age = input.nextInt();

        findByNameAndAge(name, age);
    }

    @FXML
    void readByNameAge(ActionEvent event) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Name:");
        String name = input.next();

        System.out.println("Enter Age:");
        int age = input.nextInt();

        List<Usermodel> users = readByNameAndAge(name, age);

    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");

        Query query = manager.createNamedQuery("Usermodel.findAll");
        List<Usermodel> data = query.getResultList();

        for (Usermodel s : data) {
            System.out.println(s.getId() + " " + s.getName() + " " + s.getHeight() + " " + s.getWeight() + " " + s.getAge());
        }
    }
        
    /************************ Table Operations ***************************/
    
    public void setTableData(List<Usermodel> userList) {

        userData = FXCollections.observableArrayList();

        userList.forEach(s -> {
            userData.add(s);
        });

        userTable.setItems(userData);
        userTable.refresh();
    }
    
    @FXML
    void searchForUser(ActionEvent event) {
        String name = searchBar.getText();

        List<Usermodel> users = readByName(name);

        if (users == null || users.isEmpty()) {

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog Box");
            alert.setHeaderText("No user found.");
            alert.setContentText("There wasn't a user that matched your search criteria.");
            alert.showAndWait();
        } else {

            setTableData(users);
        }

    }
    
    @FXML
    void advancedSearch(ActionEvent event) {
        String name = searchBar.getText();

        List<Usermodel> users = readByNameAdvanced(name);

        if (users == null || users.isEmpty()) {

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog Box");
            alert.setHeaderText("No user(s) found.");
            alert.setContentText("There aren't any users that match your search criteria.");
            alert.showAndWait();
        } else {
            setTableData(users);
        }
    }
    
    @FXML
    void showDetails(ActionEvent event) throws IOException {
        Usermodel selectedUser = userTable.getSelectionModel().getSelectedItem();
  
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/DetailedModelView.fxml"));

        Parent detailedModelView = loader.load();

        Scene tableViewScene = new Scene(detailedModelView);

        DetailedModelViewController detailedControlled = loader.getController();

        //detailedControlled.initData(selectedUser);

        Stage stage = new Stage();
        stage.setScene(tableViewScene);
        stage.show();
    }
    
    @FXML
    void showDetailsInPlace(ActionEvent event) throws IOException {
        Usermodel selectedUser = userTable.getSelectionModel().getSelectedItem();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/DetailedModelView.fxml"));

        Parent detailedModelView = loader.load();

        Scene tableViewScene = new Scene(detailedModelView);

        DetailedModelViewController detailedControlled = loader.getController();

        //detailedControlled.initData(selectedUser);

        Scene currentScene = ((Node) event.getSource()).getScene();
        detailedControlled.setPreviousScene(currentScene);

        Stage stage = (Stage) currentScene.getWindow();

        stage.setScene(tableViewScene);
        stage.show();
    }

    /************************ Helper Methods *****************************/
    
    public void create(Usermodel user) {
        try {
            manager.getTransaction().begin();

            if (user.getId() != null) {

                manager.persist(user);

                manager.getTransaction().commit();

                System.out.println(user.toString() + " is created");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Usermodel readById(int id) {
        Query query = manager.createNamedQuery("Usermodel.findById");

        query.setParameter("id", id);

        Usermodel user = (Usermodel) query.getSingleResult();
        if (user != null) {
            System.out.println(user.getId() + " " + user.getName() + " " + user.getHeight() + " " + user.getWeight() + " " + user.getAge());
        }

        return user;
    }

    public void update(Usermodel user) {
        try {
            Usermodel existingUser = manager.find(Usermodel.class, user.getId());

            if (existingUser != null) {
                manager.getTransaction().begin();

                existingUser.setName(user.getName());
                existingUser.setHeight(user.getHeight());
                existingUser.setWeight(user.getWeight());
                existingUser.setAge(user.getAge());

                manager.getTransaction().commit();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Usermodel user) {
        try {
            Usermodel existingUser = manager.find(Usermodel.class, user.getId());

            if (existingUser != null) {

                manager.getTransaction().begin();

                manager.remove(existingUser);

                manager.getTransaction().commit();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int findByNameAndAge(String name, int age) {
        Query query = manager.createNamedQuery("Usermodel.findByNameAndAge");

        query.setParameter("name", name);
        query.setParameter("age", age);

        Usermodel user = (Usermodel)query.getSingleResult();

        if (user != null){
            System.out.println("User with name: " + name + "\nAnd age: " + age + "\nHas an ID of: " + user.getId());
        } else {
            System.out.println("No user was found with those credentials.");
        }

        return user.getId();
    }

    public List<Usermodel> readByNameAndAge(String name, int age) {
        Query query = manager.createNamedQuery("Usermodel.readByNameAndAge");

        query.setParameter("name", name);
        query.setParameter("age", age);

        List<Usermodel> users = query.getResultList();

        if (!users.isEmpty()) {
            for (Usermodel user : users) {
                System.out.println(user.getId() + " " + user.getName() + " " + user.getHeight() + " " + user.getWeight() + " " + user.getAge());
            }
        } else {
            System.out.println("No user was found with those credentials.");
        }

        return users;
    }

    public List<Usermodel> readByName(String name){
        Query query = manager.createNamedQuery("Usermodel.readByName");

        query.setParameter("name", name);

        List<Usermodel> users = query.getResultList();

        if (!users.isEmpty()) {
            for (Usermodel user : users) {
                System.out.println(user.getId() + " " + user.getName() + " " + user.getHeight() + " " + user.getWeight() + " " + user.getAge());
            }
        } else {
            System.out.println("No user was found with that name.");
        }

        return users;
    }
    
    public List<Usermodel> readByNameAdvanced(String name) {
        Query query = manager.createNamedQuery("Usermodel.readByNameAdvanced");

        query.setParameter("name", name);

        List<Usermodel> users = query.getResultList();
        
        if (!users.isEmpty()) {
            for (Usermodel user : users) {
                System.out.println(user.getId() + " " + user.getName() + " " + user.getHeight() + " " + user.getWeight() + " " + user.getAge());
            }
        } else {
            System.out.println("No user was found with that name.");
        }
      
        return users;
    }

}
