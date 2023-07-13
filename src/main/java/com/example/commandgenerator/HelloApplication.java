package com.example.commandgenerator;

import com.example.commandgenerator.command.Command;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloApplication extends Application {

    private static final Map<String, String> moduleID = new HashMap<>();
    private static final Map<String, String> commandID = new HashMap<>();
    @Override
    public void start(Stage stage) {

        setModuleID();
        setCommandID();

        Command component1 = new Command(moduleID, commandID);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        Scene scene = new Scene(grid, 720, 480);

        // Labels
        Label moduleLabel = new Label("#Module ID#");
        Label commandLabel = new Label("#Command ID#");
        Label sizeLabel = new Label("#Size#");

        grid.add(moduleLabel, 0, 0);
        grid.add(commandLabel, 1, 0);
        grid.add(sizeLabel, 2, 0);
        // End of Labels

        // Text fields

        TextField dataInput = new TextField();

        //End of text fields

        // Visibility settings

        commandLabel.setVisible(true);

        // END of Visibility settings

        // Generic menu buttons
        MenuItem mod1 = new MenuItem("Module 1");
        MenuItem mod2 = new MenuItem("Module 2");
        MenuItem mod3 = new MenuItem("Module 3");
        MenuButton moduleID = new MenuButton("Module ID", null, mod1, mod2, mod3);
        MenuButton commandID = new MenuButton();
        Label size = new Label();

        commandID.setText("CommandID");

        Button generate = new Button("Generate command");
        TextField generatedCommand = new TextField("");
        Button copy = new Button("Copy");

        grid.add(moduleID, 0, 1);
        grid.add(commandID, 1, 1);
        grid.add(size, 2, 1);
        grid.addRow(2);
        grid.add(generate, 3, 3, 2, 1);
        grid.add(dataInput, 0, 3, 3, 1);
        grid.addRow(4);
        grid.add(generatedCommand, 0, 5, 3, 1);
        grid.add(copy, 3, 5);

        size.setText("0");
        dataInput.setPromptText("Data[] input");

        // END of Generic menu buttons

        // Active/Inactive text fields

        dataInput.setEditable(false);

        // End of Active/Inactive text fields

        // Specific menu buttons

        MenuItem mod1_commandID1 = new MenuItem("Module1 Command1");
        MenuItem mod1_commandID2 = new MenuItem("Module1 Command2");
        MenuItem mod1_commandID3 = new MenuItem("Module1 Command3");

        MenuItem mod2_commandID1 = new MenuItem("Module2 Command1");
        MenuItem mod2_commandID2 = new MenuItem("Module2 Command2");
        MenuItem mod2_commandID3 = new MenuItem("Module2 Command3");

        MenuItem mod3_commandID1 = new MenuItem("Module3 Command1");
        MenuItem mod3_commandID2 = new MenuItem("Module3 Command2");
        MenuItem mod3_commandID3 = new MenuItem("Module3 Command3");

        // END of Specific menu buttons

        // setOnActions

        // moduleID
        mod1.setOnAction(e -> {
            moduleID.setText(mod1.getText());

            commandID.setText("Module1 Command IDs");

            if(!commandID.getItems().isEmpty()){
                commandID.getItems().clear();
            }

            commandID.getItems().addAll(mod1_commandID1, mod1_commandID2, mod1_commandID3);
        });

        mod2.setOnAction(e -> {
            moduleID.setText(mod2.getText());

            commandID.setText("Module2 Command IDs");

            if(!commandID.getItems().isEmpty()){
                commandID.getItems().clear();
            }

            commandID.getItems().addAll(mod2_commandID1, mod2_commandID2, mod2_commandID3);
        });

        mod3.setOnAction(e -> {
            moduleID.setText(mod3.getText());

            commandID.setText("Module3 Command IDs");

            if(!commandID.getItems().isEmpty()){
                commandID.getItems().clear();
            }

            commandID.getItems().addAll(mod3_commandID1, mod3_commandID2, mod3_commandID3);
        });
        // END of moduleID

        // mod1_commandID1
        mod1_commandID1.setOnAction(e -> {
            commandID.setText(mod1_commandID1.getText());

            generatedCommand.clear();

            dataInput.setEditable(true);
        });

        // mod1_commandID2
        mod1_commandID2.setOnAction(e -> {
            commandID.setText(mod1_commandID2.getText());

            generatedCommand.clear();

            dataInput.setEditable(true);
        });

        // mod1_commandID3
        mod1_commandID3.setOnAction(e -> {
            commandID.setText(mod1_commandID3.getText());

            generatedCommand.clear();

            dataInput.setEditable(true);
        });

        // here
        mod2_commandID1.setOnAction(e -> {
            commandID.setText(mod2_commandID1.getText());

            generatedCommand.clear();

            dataInput.setEditable(true);
        });
        mod2_commandID2.setOnAction(e -> {
            commandID.setText(mod2_commandID2.getText());

            generatedCommand.clear();

            dataInput.setEditable(true);
        });
        mod2_commandID3.setOnAction(e -> {
            commandID.setText(mod2_commandID3.getText());

            generatedCommand.clear();

            dataInput.setEditable(true);
        });

        mod3_commandID1.setOnAction(e -> {
            commandID.setText(mod3_commandID1.getText());

            generatedCommand.clear();


            dataInput.setEditable(true);
        });
        mod3_commandID2.setOnAction(e -> {
            commandID.setText(mod3_commandID2.getText());

            generatedCommand.clear();

            dataInput.setEditable(true);
        });
        mod3_commandID3.setOnAction(e -> {
            commandID.setText(mod3_commandID3.getText());

            generatedCommand.clear();

            dataInput.setEditable(true);
        });
        //until here

        //Button actions

        generate.setOnAction(e -> {
            if (dataInput.getText().isBlank()){
                component1.setSize("0");
                size.setText("0");
                generatedCommand.setText(component1.toStringEmptyData(moduleID.getText(),commandID.getText()));
            }else {
                component1.setData(breakStringsToList(dataInput.getText()));
                component1.setSize(Integer.toString(component1.getData().size()));
                size.setText(Integer.toString(component1.getData().size()));
                generatedCommand.setText(component1.toString(moduleID.getText() ,commandID.getText()));
            }
        });

        copy.setOnAction(e -> {
            final Clipboard clipboard = Clipboard.getSystemClipboard();
            final ClipboardContent clipboardContent = new ClipboardContent();
            clipboardContent.putString(generatedCommand.getText());
            clipboard.setContent(clipboardContent);
        });
        // END of Button actions

        stage.setTitle("Command Generator");
        stage.setScene(scene);
        stage.show();
    }

    public static List<String> breakStringsToList(String str){
        List<String> result = new ArrayList<>();
        String dataIn[];

        dataIn = str.split(" ");

        for(String a : dataIn){
            result.add(a);
        }

        return result;
    }

    public static  void setModuleID(){
        moduleID.put("Module 1", "0");
        moduleID.put("Module 2", "1");
        moduleID.put("Module 3", "2");
    }

    public static void setCommandID(){
        commandID.put("Module1 Command1", "11");
        commandID.put("Module1 Command2", "12");
        commandID.put("Module1 Command3", "13");

        commandID.put("Module2 Command1", "21");
        commandID.put("Module2 Command2", "22");
        commandID.put("Module2 Command3", "23");

        commandID.put("Module3 Command1", "31");
        commandID.put("Module3 Command2", "32");
        commandID.put("Module3 Command3", "33");
    }

    public static void main(String[] args) {
        launch();
    }
}