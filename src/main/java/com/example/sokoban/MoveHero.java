//package com.example.sokoban;
//
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static java.awt.SystemColor.text;
//
//public class MoveHero {
//
//    private int playerX = 18 ;
//    private int Box = 52 ;
//    private ArrayList<Character> map;
//
//    Image boxEnd = new Image(getClass().getResourceAsStream("/Boxs/CrateDark_Blue.png"));
//
//    MoveHero(ImageView Hero,ArrayList<Character> map,ImageView box,ImageView EndPoint){
//        this.map=map;
////        for (char c : map){
////            System.out.print(c);
////        }
//        int counter = 0; // Счетчик для элементов
//        for (int i = 0; i < map.size(); i++) {
//            System.out.print(map.get(i));
//            counter++;
//            if (counter == 12) { // Если вывели 11 символов
//                System.out.println(); // Переход на новую строку
//                counter = 0; // Сбрасываем счетчик
//            }
//        }
////
//        // Если остались символы, не вошедшие в полные строки
//        if (counter != 0) {
//            System.out.println(); // Завершаем последнюю строку
//        }
//        System.out.println(map.get(24)+"142421");
//        System.out.println(map.get(25)+"142421");
//
//
////        findPlayerPosition();
////        findPlayerPosition();
//        System.out.println(playerX);
//        Hero.setFocusTraversable(Boolean.TRUE);
//        Hero.requestFocus();
//        Hero.setOnKeyPressed(e -> {
//           switch (e.getCode()) {
//               case UP:
//                   if(map.get(playerX-12).equals('#')){
//                       break;
//                   } else{
//                   deletePlayerPosition();
//                   if(playerX-12 == Box){
//                       Box-=12;
//                       box.setY(box.getY() - 40);
//                   }
//                   Hero.setY(Hero.getY() -40);
//                   playerX-=12;
//                   setPlayerPosition();
//                   if(Box == 112){
//                       EndPoint.setVisible(false);
//                       box.setImage(boxEnd);
//                   }
//                   System.out.println(playerX);
//                   break;
//                   }
//
//               case DOWN:
//                   if(map.get(playerX+12).equals('#')){
//                       break;
//               } else{
//                   deletePlayerPosition();
//                   if(playerX+12 == Box){
//                       Box+=12;
//                       box.setY(box.getY() + 40);
//                       if(Box == 112){
//                           EndPoint.setVisible(false);
//                           box.setImage(boxEnd);
//                       }
//                   }
//                   playerX+=12;
//                   Hero.setY(Hero.getY() + 40);
//                   setPlayerPosition();
//
//                   System.out.println(playerX);
//                   break;
//               }
//
//               case LEFT:
//                   if(map.get(playerX-1).equals('#')){
//                       break;
//                   } else {
//                       if(playerX-1 == Box){
//                           Box-=1;
//                           box.setX(box.getX() - 40);
//                       }
//                       Hero.setX(Hero.getX() - 40);
//                       playerX-=1;
//                       if(Box == 112){
//                           EndPoint.setVisible(false);
//                           box.setImage(boxEnd);
//                       }
//                       System.out.println(playerX);
//                       break;
//                   }
//
//               case RIGHT:
//                   if(map.get(playerX+1).equals('#')){
//                       break;
//                   } else{
//                       if(playerX+1 == Box){
//                           Box+=1;
//                           box.setX(box.getX() + 40);
//                       }
//                       Hero.setX(Hero.getX() + 40);
//                       playerX+=1;
//                       if(Box == 112){
//                           EndPoint.setVisible(false);
//                           box.setImage(boxEnd);
//                       }
//                       System.out.println(playerX);
//                       break;
//                   }
//
//           }
//        });
//
//        System.out.println(playerX);
//
//    }
//    private void findPlayerPosition() {
//        int d= 0;
//        for (Character a : map){
//            if(a.equals('@')){
//                playerX=d;
//            }else if(a.equals('#')){
//                System.out.println(d);
////                Box=d;
////                System.out.println(Box + "gsdgsgdg");
//            }
//
//            d+=1;
//        }
//    }
//
//    private void deletePlayerPosition(){
//        map.set(playerX,' ');
//    }
//    private void setPlayerPosition(){
//        map.set(playerX,'@');
//    }
//    private void setBoxPosition(){
//        map.set(Box,'&');
//    }
//    private void deleteBoxPosition(){
//        map.set(Box,' ');
//    }
////    private void removeHero() {
////        int d= 0;
////        for (String a : map){
////            int g = 0;
////            for (String b : a.split(" ")){
////                if (b.equals("@")) {
////                    map.remove(b);
////                }
////                g+=1;
////            }
////            d+=1;
////
////        }
////    }
//}
//// поменять со строк на символы карту