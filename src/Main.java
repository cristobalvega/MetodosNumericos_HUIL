import U1_.Main_U1;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    private BorderPane root_principal;
    private Stage stage_principal;
    private Scene scene_principal,sceneSeries;

    private Main_U1 main_u1 = new Main_U1();
    @Override
    public void start(Stage stage) throws Exception{
        ///////Ventana
        root_principal  = new BorderPane();
        stage_principal = stage;
        scene_principal = new Scene(root_principal, 1250, 600);
        stage_principal.setTitle("Métodos Númericos - HUIL");
        stage.setScene(scene_principal);
        root_principal.setCenter(crearVentana());
        stage_principal.show();
    }//start

    private GridPane crearVentana(){
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(10,15,20,15));
        gridpane.setHgap(0);
        gridpane.setVgap(5);

        Button buttonSeries = new Button("Series");
        //buttonSeries.setOnAction( e -> stage_principal.setScene(sceneSeries));
        GridPane.setConstraints(buttonSeries,0,0);
        gridpane.getChildren().add(buttonSeries);
        return gridpane;
    }//crearVentana

    public static void main(String[] args) {
        launch(args);
    }//main

}//Main
