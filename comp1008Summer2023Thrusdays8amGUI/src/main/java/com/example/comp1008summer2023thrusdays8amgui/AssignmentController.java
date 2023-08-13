package com.example.comp1008summer2023thrusdays8amgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Random;


public class AssignmentController {
// putting the JavaFX components from the FXML file

    @FXML
    private ColorPicker colorfill;

    @FXML
    private TextField name;

    @FXML
    private Pane p1;

    @FXML
    private Pane p2;

    @FXML
    private Pane p3;

    @FXML
    private Pane p4;

    @FXML
    private Pane p5;

    @FXML
    private Pane p6;

    @FXML
    private Pane p7;

    @FXML
    private Pane p8;

    @FXML
    private Pane p9;
    @FXML
    private Text s1;

    @FXML
    private Text s2;

    @FXML
    private Text s3;

    @FXML
    private Text s4;

    @FXML
    private Text s5;

    @FXML
    private Text s6;
    @FXML
    private Label displayError;

    @FXML
    private Text s7;

    @FXML
    private Text s8;

    @FXML
    private Text s9;

    @FXML
    private Text congratulatoryMessage;

    // ArrayList to keep track of chosen seat numbers by the user
    ArrayList<Integer> aList = new ArrayList<Integer>(10);

    // Flag to count the no. of registered students
    int flag=0;

    // This ia the function to generate a random non-repeating number b/w 1 and 9
    int RFunc(int randomNum){

        while(true){
            Random rand = new Random();
            int max = 9;
            int min = 1;
            int range = max - min + 1;
            int ran = (int) (Math.random() * range) + min;

            if(aList.contains(ran)){
                continue;
            }else{
                aList.add(ran);
                return ran;

            }
        }
    }

    // Check if the color has been chosen by another student
    private boolean checkColorTaken(Color color) {
        String colorRgb = "#" + color.toString().substring(2);  // Convert color to RGB string
        String p1Color = p1.getStyle().replace("-fx-background-color: ", "");
        String p2Color = p2.getStyle().replace("-fx-background-color: ", "");
        String p3Color = p3.getStyle().replace("-fx-background-color: ", "");
        String p4Color = p4.getStyle().replace("-fx-background-color: ", "");
        String p5Color = p5.getStyle().replace("-fx-background-color: ", "");
        String p6Color = p6.getStyle().replace("-fx-background-color: ", "");
        String p7Color = p7.getStyle().replace("-fx-background-color: ", "");
        String p8Color = p8.getStyle().replace("-fx-background-color: ", "");
        String p9Color = p9.getStyle().replace("-fx-background-color: ", "");

        return colorRgb.equals(p1Color) || colorRgb.equals(p2Color) ||
                colorRgb.equals(p3Color) || colorRgb.equals(p4Color) ||
                colorRgb.equals(p5Color) || colorRgb.equals(p6Color) ||
                colorRgb.equals(p7Color) || colorRgb.equals(p8Color) ||
                colorRgb.equals(p9Color);
    }


    // onclick button to generate events
    @FXML
    void onGenerate(ActionEvent event) throws Exception {
        Random rand = new Random();
        int wrong=0;
        String FLNAME=name.getText();

        // Check if the name is at least 3 characters long
        if (FLNAME.length() < 3) {
            displayError.setText("Name must be at least 3 characters");
            displayError.setStyle("-fx-background-color: transparent");
            displayError.setVisible(true);
            return;
        }else {
            displayError.setVisible(false);
        }

        // Get the chosen color
        Color color= colorfill.getValue();

        // Check if white color is chosen
        if (color.equals(Color.WHITE)) {
            displayError.setText("White cannot be chosen as a color");
            displayError.setStyle("-fx-background-color: transparent");
            displayError.setVisible(true);
            return;
        } else {
            displayError.setVisible(false);
        }

        // Check if the color is already chosen by another student
        boolean isColorTaken = checkColorTaken(color);
        if (isColorTaken) {
            displayError.setText("Color already chosen");
            displayError.setStyle("-fx-background-color: transparent");
            displayError.setVisible(true);
            return;
        } else {
            displayError.setVisible(false);
        }

        // Check if all seats are taken
        if (flag == 9) {
            displayError.setVisible(true);
            displayError.setText("All seats taken!!");
            return;
        }

        // Generate a random number for the student
        int randomnum = rand.nextInt(1, 10);
        int num = RFunc(randomnum);

        // Check if the entered name already exists among the showed names
        if (isNameTaken(FLNAME)) {
            displayError.setText("The name '" + FLNAME + "' already exists");
            displayError.setStyle("-fx-background-color: transparent");
            displayError.setVisible(true);
            return;
        }

        // Check if registration is full
        if (flag == 9) {
            displayError.setVisible(true);
            displayError.setText("Congratulations! Registration is full.");
            return;
        }

        // Check if the same name is chosen by another student
        if(s1.getText().compareTo(FLNAME)==0||s2.getText().compareTo(FLNAME)==0||s3.getText().equals(FLNAME)
                ||s4.getText().equals(FLNAME)||s5.getText().equals(FLNAME)||s6.getText().equals(FLNAME)||
                s7.getText().equals(FLNAME)||s8.getText().equals(FLNAME)||s9.getText().equals(FLNAME)){
            wrong=1;

            aList.remove(aList.indexOf(num));
        }

        // Check if white color is chosen
        if(color.toString().equals("0xffffffff"))
            wrong=2;

        // Check if the chosen color is already taken
        if(p1.getStyle().equals("-fx-background-color: #"+color.toString().substring(2)) || p2.getStyle().equals("-fx-background-color: #"+color.toString().substring(2))
                ||p3.getStyle().equals("-fx-background-color: #"+color.toString().substring(2))
                ||p4.getStyle().equals("-fx-background-color: #"+color.toString().substring(2))
                ||p5.getStyle().equals("-fx-background-color: #"+color.toString().substring(2))
                ||p6.getStyle().equals("-fx-background-color: #"+color.toString().substring(2))
                ||p7.getStyle().equals("-fx-background-color: #"+color.toString().substring(2))
                ||p8. getStyle().equals("-fx-background-color: #"+color.toString().substring(2))
                ||p9.getStyle().equals("-fx-background-color: #"+color.toString().substring(2)))
            wrong=2;

        if(FLNAME.isEmpty()){
            wrong=90;
            displayError.setText("Please enter a Name");
            displayError.setVisible(true);
            aList.remove(num);
            aList.remove(aList.indexOf(num));
        }

        // If all checks pass, update seat information
        if(wrong==0){
            flag++;

            // Update the chosen seat's color and student name
            if(num==1){
                displayError.setVisible(false);
                p1.setStyle("-fx-background-color: #" +color.toString().substring(2));
                s1.setText(FLNAME);
                s1.setVisible(true);

                if(flag==9){
                    displayError.setVisible(true);
                    displayError.setText("Congratulations! Registration is full.");

                }

            }
            if(num==2){
                displayError.setVisible(false);
                p2.setStyle("-fx-background-color: #" +color.toString().substring(2));
                s2.setText(FLNAME);
                s2.setVisible(true);
                if(flag==9){
                    displayError.setVisible(true);
                    displayError.setText("Congratulations! Registration is full.");

                }
            }

            if(num==3){
                displayError.setVisible(false);
                p3.setStyle("-fx-background-color: #" +color.toString().substring(2));
                s3.setText(FLNAME);
                s3.setVisible(true);

                if(flag==9){
                    displayError.setVisible(true);
                    displayError.setText("Congratulations! Registration is full.");

                }

            }
            if(num==4){
                displayError.setVisible(false);
                p4.setStyle("-fx-background-color: #" +color.toString().substring(2));
                s4.setText(FLNAME);
                s4.setVisible(true);
                if(flag==9){
                    displayError.setVisible(true);
                    displayError.setText("Congratulations! Registration is full.");

                }

            }
            if(num==5){
                displayError.setVisible(false);
                p5.setStyle("-fx-background-color: #" +color.toString().substring(2));
                s5.setText(FLNAME);
                s5.setVisible(true);
                if(flag==9){
                    displayError.setVisible(true);
                    displayError.setText("Congratulations! Registration is full.");

                }

            }
            if(num==6){
                displayError.setVisible(false);
                p6.setStyle("-fx-background-color: #" +color.toString().substring(2));
                s6.setText(FLNAME);
                s6.setVisible(true);
                if(flag==9){
                    displayError.setVisible(true);
                    displayError.setText("Congratulations! Registration is full.");

                }

            }

            if(num==7){
                displayError.setVisible(false);
                p7.setStyle("-fx-background-color: #" +color.toString().substring(2));
                s7.setText(FLNAME);
                s7.setVisible(true);
                if(flag==9){
                    displayError.setVisible(true);
                    displayError.setText("Congratulations! Registration is full.");

                }

            }

            if(num==8){
                displayError.setVisible(false);
                p8.setStyle("-fx-background-color: #" +color.toString().substring(2));
                s8.setText(FLNAME);
                s8.setVisible(true);
                if(flag==9){
                    displayError.setVisible(true);
                    displayError.setText("Congratulations! Registration is full.");
                }
            }

            if(num==9){
                displayError.setVisible(false);
                p9.setStyle("-fx-background-color: #" +color.toString().substring(2));
                s9.setText(FLNAME);
                s9.setVisible(true);
                if(flag==9){
                    congratulatoryMessage.setVisible(true);
                    displayError.setVisible(true);

                    // Set text to include both messages
                    displayError.setText("Congratulations! Registration is full.");
                }
            }

            // Show congratulatory message when seating arrangement is complete
//            if (flag == 9) {
//                congratulatoryMessage.setVisible(true);
//                displayError.setVisible(true);
//                displayError.setText("Congratulations! Seating arrangement is complete.");
//            }
        }

        else if(wrong==1) {
            displayError.setText("The name already exists");
            displayError.setStyle("-fx-background-color: transparent");
            displayError.setVisible(true);
            aList.remove((Integer) num);

        }
        else if(wrong==2) {
            displayError.setText("The color is already chosen");
            displayError.setStyle("-fx-background-color: transparent");
            displayError.setVisible(true);

            aList.remove(aList.indexOf(num));
        } else {
            displayError.setVisible(false);
            displayError.setText("All seats are taken");
            displayError.setStyle("-fx-background-color: transparent");
            displayError.setVisible(true);
        }
    }

    // Handle the GUI components
    @FXML
    void initialize(){
        // Set visibility of seat texts and displayError label to false
        s1.setVisible(false);
        s3.setVisible(false);
        s2.setVisible(false);
        s4.setVisible(false);
        s5.setVisible(false);
        s6.setVisible(false);
        s7.setVisible(false);
        s8.setVisible(false);
        s9.setVisible(false);
        displayError.setVisible(false);
    }

    // check if the entered name already exists
    private boolean isNameTaken(String nameToCheck) {
        return s1.getText().equalsIgnoreCase(nameToCheck) ||
                s2.getText().equalsIgnoreCase(nameToCheck) ||
                s3.getText().equalsIgnoreCase(nameToCheck) ||
                s4.getText().equalsIgnoreCase(nameToCheck) ||
                s5.getText().equalsIgnoreCase(nameToCheck) ||
                s6.getText().equalsIgnoreCase(nameToCheck) ||
                s7.getText().equalsIgnoreCase(nameToCheck) ||
                s8.getText().equalsIgnoreCase(nameToCheck) ||
                s9.getText().equalsIgnoreCase(nameToCheck);
    }
}