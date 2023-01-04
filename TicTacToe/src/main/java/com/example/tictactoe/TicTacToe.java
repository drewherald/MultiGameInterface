package com.example.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    private String turn = "x";
    private Label display;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private boolean check = false;


    public void start(Stage window) throws Exception{

        //create items
        this.turn = "x";
        this.display = new Label("Turn "+turn);
        this.display.setFont(Font.font("Monospaced", 40));
        FXMLLoader fxmlLoader = new FXMLLoader(TicTacToe.class.getResource("tictactoe.fxml"));
        GridPane layout = new GridPane();
        HBox row1 = new HBox();
        HBox row2 = new HBox();
        HBox row3 = new HBox();
        one = create();
        two = create();
        three = create();
        four = create();
        five = create();
        six = create();
        seven = create();
        eight = create();
        nine = create();

        row1.getChildren().addAll(one,two,three);
        row2.getChildren().addAll(four,five,six);
        row3.getChildren().addAll(seven,eight,nine);

        layout.setAlignment(Pos.CENTER);
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setPadding(new Insets(10,10,10,10));

        layout.add(display,0,0);
        layout.add(row1,0,1);
        layout.add(row2,0,2);
        layout.add(row3,0,3);


        Scene scene = new Scene(layout, 800, 800);
        window.setScene(scene);
        window.show();







    }

    public Button create() {
        Button b = new Button();
        b.setFont(Font.font("Monospaced", 40));
        b.setPrefSize(80,80);


            b.setOnAction((actionEvent -> {
                if(check){
                    return;
                }
                if(b.getText().isEmpty()){
                    b.setText(turn.toString());
                    if(wins()){
                        this.display.setText(this.turn.toString()+" wins!");
                        this.check = true;
                    }else{
                        if(this.turn.equals("x")){
                            this.turn = "o";
                        }else{
                            this.turn = "x";
                        }
                        this.display.setText("Turn "+turn);

                    }

                }
            }));
        return b;
    }

    public boolean wins(){

        //horizontal

        if(one.getText().equals(two.getText())&&one.getText().equals(three.getText())&&two.getText().equals(three.getText())&&!one.getText().isEmpty()&&!two.getText().isEmpty()&&!three.getText().isEmpty()){
            return true;
        }else if(four.getText().equals(five.getText())&&four.getText().equals(six.getText())&&five.getText().equals(six.getText())&&!four.getText().isEmpty()&&!five.getText().isEmpty()&&!six.getText().isEmpty()){
            return true;
        }else if(seven.getText().equals(eight.getText())&&seven.getText().equals(nine.getText())&&eight.getText().equals(nine.getText())&&!seven.getText().isEmpty()&&!eight.getText().isEmpty()&&!nine.getText().isEmpty()){
            return true;
        }else if(one.getText().equals(four.getText())&&one.getText().equals(seven.getText())&&four.getText().equals(seven.getText())&&!one.getText().isEmpty()&&!four.getText().isEmpty()&&!seven.getText().isEmpty()){
            return true;
        }else if(two.getText().equals(five.getText())&&two.getText().equals(eight.getText())&&five.getText().equals(eight.getText())&&!two.getText().isEmpty()&&!five.getText().isEmpty()&&!eight.getText().isEmpty()){
            return true;
        }else if(three.getText().equals(six.getText())&&three.getText().equals(nine.getText())&&six.getText().equals(nine.getText())&&!three.getText().isEmpty()&&!six.getText().isEmpty()&&!nine.getText().isEmpty()){
            return true;
        }else if(one.getText().equals(five.getText())&&one.getText().equals(nine.getText())&&five.getText().equals(nine.getText())&&!one.getText().isEmpty()&&!five.getText().isEmpty()&&!nine.getText().isEmpty()){
            return true;
        }else if(three.getText().equals(five.getText())&&three.getText().equals(seven.getText())&&five.getText().equals(seven.getText())&&!three.getText().isEmpty()&&!five.getText().isEmpty()&&!seven.getText().isEmpty()){
            return true;
        }



        return false;

    }

    public static void main(String args[]){

        launch(TicTacToe.class);


    }
}
