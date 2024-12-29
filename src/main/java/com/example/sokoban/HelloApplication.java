package com.example.sokoban;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;


public class HelloApplication extends Application {

    LevelLoader levelLoader;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Button btn1 = new Button();
        Button btn2 = new Button();
        Button btn3 = new Button();
        btn1.setText("1 level");
        btn1.setOnAction(event -> {
            Pane rootLevel1 = new Pane();
            try {
                levelLoader = new LevelLoader("src/main/resources/text.txt", rootLevel1);
                Scene sceneLevel1 = new Scene(rootLevel1,500,500);
                Stage stage = new Stage();
                stage.setScene(sceneLevel1);
                primaryStage.hide();
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        btn2.setText("2 level");
        btn2.setOnAction(event -> {
            Pane rootLevel2 = new Pane();
            try {
                levelLoader = new LevelLoader("src/main/resources/level2.txt", rootLevel2);
                Scene sceneLevel2 = new Scene(rootLevel2,500,500);
                Stage stage = new Stage();
                stage.setScene(sceneLevel2);
                primaryStage.hide();
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        btn3.setText("3 level");
        btn3.setOnAction(event -> {
            Pane rootLevel3 = new Pane();
            try {
                levelLoader = new LevelLoader("src/main/resources/level3.txt", rootLevel3);
                Scene sceneLevel3 = new Scene(rootLevel3,500,500);
                Stage stage = new Stage();
                stage.setScene(sceneLevel3);
                primaryStage.hide();
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        btn1.setLayoutX(200);
        btn1.setLayoutY(200);
        btn2.setLayoutX(200);
        btn2.setLayoutY(230);
        btn3.setLayoutX(200);
        btn3.setLayoutY(260);

        root.getChildren().addAll(btn1,btn2,btn3);

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Level Loader");
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }



}
