/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlcircle;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.paint.Color; 
import javafx.scene.shape.Circle;
    
public class ControlCircle extends Application {
    
    //Instanciación del Círculo
    private final CirclePane circlePane = new CirclePane();
    
    
    @Override
    public void start(Stage primaryStage) {
        
        //Creación del HBOX y Botones
        HBox hBox = new HBox(5);
        Button btEnlarge = new Button("Agrandar");
        Button btShrink = new Button("Encoger");
 
        //Configuración de botones en el HBox y Alineación
        hBox.getChildren().addAll(btEnlarge,btShrink);
        hBox.setAlignment(Pos.BOTTOM_CENTER);
        
        //Creación del evento de HBox
        btEnlarge.setOnAction(new EnlargeHandler());
        btShrink.setOnAction(new ShrinkHandler());
       
        //Creamos el Border Pane
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        borderPane.setBottom(hBox);
        

        
        Scene scene = new Scene(borderPane, 300, 250);
        primaryStage.setTitle("ControlCircle");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene); 
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    // Inner Class Enlarge
    class EnlargeHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            circlePane.enlarge();
        }
    }
    // Inner Class Shrink
    class ShrinkHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            circlePane.shrink();
        }
    }
}
class CirclePane extends StackPane {
    private final Circle circle = new Circle(50);
    
    public CirclePane() {
        getChildren().add(circle);
        circle.centerXProperty().bind(widthProperty().divide(2));
        circle.centerYProperty().bind(widthProperty().divide(2));
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

    }
    public void enlarge() {
       circle.setRadius(circle.getRadius() + 2);
  
    }
    public void shrink() {
        circle.setRadius(circle.getRadius() > 2
        ? circle.getRadius() - 2 : circle.getRadius());
    }
}