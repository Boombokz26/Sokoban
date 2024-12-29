package com.example.sokoban;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LevelLoader {
    private String fileName;
    private final int TILE_SIZE = 40;
    private Image imageBox;
    private Image imageHero;
    private Image imageEndpoint;
    private Image imageWall;
    private Image boxEnd;
    private ImageView imageViewBox;
    public  ArrayList<Character> map = new ArrayList<>();
    private ImageView EndPoint;
    private int playerX;
    private int Box;
    private int BoxEnd;
    ImageView imageViewHero;
    Pane pane;
    LevelLoader(String fileName, Pane pane) throws IOException {
        this.fileName = fileName;
        this.pane = pane;
        imageBox = new Image(getClass().getResourceAsStream("/Boxs/Crate_Blue.png"));
        imageHero = new Image(getClass().getResourceAsStream("/Characters_directory/Character4.png"));
        imageEndpoint = new Image(getClass().getResourceAsStream("/Endpoints/EndPoint_Blue.png"));
        imageWall = new Image(getClass().getResourceAsStream("/Wals/Wall_Gray.png"));
        boxEnd = new Image(getClass().getResourceAsStream("/Boxs/CrateDark_Blue.png"));
        loadLevel();
        MoveHero();

    }
    // drawing a map as well as adding it to a variable map
    private void loadLevel() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int y = 0;
            while ((line = reader.readLine()) != null) {
                for (int x = 0; x < line.length(); x++) {
                    char tile = line.charAt(x);
                    map.add(tile);
                    switch (tile) {
                        case '#': // Wall
                            ImageView imageViewWall = new ImageView(imageWall);
                            imageViewWall.setX(x * TILE_SIZE);
                            imageViewWall.setY(y * TILE_SIZE);
                            imageViewWall.setFitHeight(TILE_SIZE);
                            imageViewWall.setFitWidth(TILE_SIZE);
                            pane.getChildren().add(imageViewWall);
                            break;
                        case '@': // Player
                            imageViewHero = new ImageView(imageHero);

                            imageViewHero.setX(x * TILE_SIZE);
                            imageViewHero.setY(y * TILE_SIZE);
                            imageViewHero.setFitHeight(TILE_SIZE);
                            imageViewHero.setFitWidth(TILE_SIZE);
                            pane.getChildren().add(imageViewHero);
                            break;
                        case ' ':
                            break;
                        case '%': // endpoint
                            EndPoint = new ImageView(imageEndpoint);
                            EndPoint.setFitHeight(TILE_SIZE);
                            EndPoint.setFitWidth(TILE_SIZE);
                            EndPoint.setX(x * TILE_SIZE);
                            EndPoint.setY(y * TILE_SIZE);
                            pane.getChildren().add(EndPoint);
                            break;
                        case '&': // box
                            imageViewBox = new ImageView(imageBox);
                            imageViewBox.setFitHeight(TILE_SIZE);
                            imageViewBox.setFitWidth(TILE_SIZE);
                            imageViewBox.setX(x * TILE_SIZE);
                            imageViewBox.setY(y * TILE_SIZE);
                            pane.getChildren().add(imageViewBox);
                            break;

                    }
                }
                y++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // character and box movement

        private void MoveHero(){
            findPlayerPosition();
            System.out.println(playerX);
            imageViewHero.setFocusTraversable(Boolean.TRUE);
            imageViewHero.requestFocus();
            imageViewHero.setOnKeyPressed(e -> {
                switch (e.getCode()) {
                    case UP:
                        if(map.get(playerX-12).equals('#') ){
                            break;
                        } else{
                            deletePlayerPosition();
                            if(playerX-12 == Box){
                                Box-=12;
                                imageViewBox.setY(imageViewBox.getY() - 40);
                            }
                            imageViewHero.setY(imageViewHero.getY() -40);
                            playerX-=12;
                            setPlayerPosition();
                            if(Box == BoxEnd){
                                EndPoint.setVisible(false);
                                imageViewBox.setImage(boxEnd);
                                endText();
                            }
                            break;
                        }

                    case DOWN:
                        if(map.get(playerX+12).equals('#')){
                            break;
                        } else{
                            deletePlayerPosition();
                            if(playerX+12 == Box){
                                Box+=12;
                                imageViewBox.setY(imageViewBox.getY() + 40);
                                if(Box == 112){
                                    EndPoint.setVisible(false);
                                    imageViewBox.setImage(boxEnd);
                                }
                            }
                            playerX+=12;
                            imageViewHero.setY(imageViewHero.getY() + 40);
                            setPlayerPosition();
                            if(Box == BoxEnd){
                                EndPoint.setVisible(false);
                                imageViewBox.setImage(boxEnd);
                                endText();
                            }
                            break;
                        }

                    case LEFT:
                        if(map.get(playerX-1).equals('#')){
                            break;
                        } else {
                            if(playerX-1 == Box){
                                Box-=1;
                                imageViewBox.setX(imageViewBox.getX() - 40);
                            }
                            imageViewHero.setX(imageViewHero.getX() - 40);
                            playerX-=1;
                            if(Box == BoxEnd){
                                EndPoint.setVisible(false);
                                imageViewBox.setImage(boxEnd);
                                endText();
                            }
                            break;
                        }

                    case RIGHT:
                        if(map.get(playerX+1).equals('#')){
                            break;
                        } else{
                            if(playerX+1 == Box){
                                Box+=1;
                                imageViewBox.setX(imageViewBox.getX() + 40);
                            }
                            imageViewHero.setX(imageViewHero.getX() + 40);
                            playerX+=1;
                            if(Box == BoxEnd){
                                EndPoint.setVisible(false);
                                imageViewBox.setImage(boxEnd);
                                endText();

                            }
                            break;
                        }

                }
            });
        }
    // deleting a player's position on the map
    private void deletePlayerPosition(){
        map.set(playerX,' ');
    }
    // seting a player's position on the map
    private void setPlayerPosition(){
        map.set(playerX,'@');
    }
    //find a player's and box position on the map
    private void findPlayerPosition() {
        int d= 0;
        for (Character a : map){
            if(a.equals('@')){
                playerX=d;
            }else if(a.equals('&')){
                Box=d;
            } else if(a.equals('%')){
                BoxEnd = d;
            }
            d+=1;
        }
    }
    // when the game is over, the text appears
    private void endText(){
        Text text = new Text();
        text.setText("Finished");
        text.setX(pane.getWidth()/3);
        text.setY(pane.getHeight()/2);
        text.setFont(new Font("Arial",50));
        pane.getChildren().add(text);
    }

}

