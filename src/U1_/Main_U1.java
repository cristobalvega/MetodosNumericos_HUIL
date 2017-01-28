package U1_;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;


public class Main_U1 extends Application {

    //Declaración de Variables
    Stage window;
    Scene sceneFunciones,sceneSeries,sceneAutores;
    Button buttonClose,buttonSerie,buttonFunciones,buttonValidar,buttonCalcular,buttonCalcularSerie,buttonFuncionesAutores;
    TextField txtCifras;
    Label labelFunciones,labelSeries,labelValorX,labelParametriza,labelEstatus,lblCristobal,lblFrancisco,lblEdgar;
    ComboBox<String> comboBox;

    TableView<Tabla> tableView = new TableView<>();


    TextField txtValorX = new TextField();
    TextField txtIteraciones = new TextField();

    Button buttonSerieCalular;
    TextField txtA,txtB, txtC, txtD, txtE, txtX1, txtX2;
    Label lblA,lblB, lblC, lblD, lblE, lblX1, lblX2;



    @Override
    public void start(Stage primaryStage) throws Exception{
        window=primaryStage;
        window.setTitle("Unidad 1 | Equipo 6");
        window.setOnCloseRequest(e -> primaryStage.close());

        funciones();
        seriesTyalor();
        autores();
        crearTabla();
        buttonCalcular.setOnAction(e -> llenarTabla());
        buttonCalcularSerie.setOnAction(e->llenarArea());

        window.setScene(sceneFunciones);
        window.setHeight(600);
        window.setWidth(500);
        window.setResizable(true);
        window.show();
    }//start

    public void autores(){
        GridPane gridPane=new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        lblCristobal  = new Label("Vega Luna Cristobal Elihu       - No. Control 14401015");
        lblEdgar =      new Label("Nuñez Gonzalez Edgar Eduardo    - No. Control 14400979");
        lblFrancisco=   new Label("Gallegos Gomez Francisco Javier - No. Control 13400409");

        GridPane.setConstraints(lblCristobal,0,1);
        GridPane.setConstraints(lblEdgar,0,2);
        GridPane.setConstraints(lblFrancisco,0,3);

        buttonFuncionesAutores = new Button("Regresar a Funciones");
        buttonFuncionesAutores.setOnAction(e -> window.setScene(sceneFunciones));
        GridPane.setConstraints(buttonFuncionesAutores,0,4);

        gridPane.getChildren().addAll(
                lblCristobal,
                lblEdgar,
                lblFrancisco,
                buttonFuncionesAutores
        );

        sceneAutores = new Scene(gridPane,300,500);
        sceneAutores.getStylesheets().add("DarkTheme.css");
    }


    public ObservableList<Tabla> obtenerNumeros(int numeroIterciones, double valorX, int cifra){
        ObservableList<Tabla> tablaObservable= FXCollections.observableArrayList();
        tablaObservable.add(new Tabla(seleccionMetodo(),numeroIterciones,valorX,cifra));
        return tablaObservable;
    }//ObtenerNumeros

    public void crearTabla(){
        //TableView
        //Columna Fx
        TableColumn<Tabla,Double> columnaFx = new TableColumn<>("f(x)");
        columnaFx.setMinWidth(50);
        columnaFx.setCellValueFactory(new PropertyValueFactory<>("fx"));
        //Columna Et
        TableColumn<Tabla,Double> columnaEt = new TableColumn<>("Et");
        columnaEt.setMinWidth(50);
        columnaEt.setCellValueFactory(new PropertyValueFactory<>("et"));
        //Columna Ea
        TableColumn<Tabla,Double> columnaEa = new TableColumn<>("Ea");
        columnaEa.setMinWidth(50);
        columnaEa.setCellValueFactory(new PropertyValueFactory<>("ea"));
        //Columna Aceptación
        TableColumn<Tabla,String> columnaAcepta = new TableColumn<>("Aceptación");
        columnaAcepta.setMinWidth(100);
        columnaAcepta.setCellValueFactory(new PropertyValueFactory<>("acepta"));

        tableView.setItems(null);
        tableView.getColumns().addAll(columnaFx,columnaEt,columnaEa,columnaAcepta);
    }//crearTabla

    public void llenarTabla(){
        tableView.setItems(


                obtenerNumeros(
                Integer.parseInt(txtIteraciones.getText()),
                Double.parseDouble(txtValorX.getText()),
                Integer.parseInt(txtCifras.getText())
                )
        );
        System.out.println("llenarTabla()");
    }//LlenarTabla

    public void cambiarLabel(){
        labelFunciones.setText(comboBox.getValue());
    }//cambiar LAbel

    private int seleccionMetodo(){
        if(comboBox.getValue()=="Seleccione la función") return -1;
        if(comboBox.getValue()==" 1: e^x"){
            txtIteraciones.setEditable(true);
            return 1;
        }
        if(comboBox.getValue()==" 2: 1/e^x") return 2;
        if(comboBox.getValue()==" 3: e^-x") return  3;
        if(comboBox.getValue()==" 4: 1/(1-x)") return 4;
        if(comboBox.getValue()==" 5: Pi") {
            txtIteraciones.setEditable(false);
            return 5;
        }
        if(comboBox.getValue()==" 6: Pi/4") return 6;
        if(comboBox.getValue()==" 7: ln(x+1)") return 7;
        if(comboBox.getValue()==" 8: sen(x)") return 8;
        if(comboBox.getValue()==" 9: cos(x)") return 9;
        if(comboBox.getValue()=="10: tan^-1(x)") return 10;
        if(comboBox.getValue()=="11: senh(x)") return 11;
        if(comboBox.getValue()=="12: cosh(x)") return 12;
        if(comboBox.getValue()=="13: Algoritmo de Wallis") return 13;
        return -1;
    }//SeleccionMetodo

    private void funciones(){

        VBox box = new VBox(4);


        //Declaración de diseño de sceneFunciones
        GridPane gridPane=new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        labelFunciones=new Label("Funciones");
        GridPane.setConstraints(labelFunciones,0,0);

        buttonValidar = new Button();
        buttonValidar.setText("Autores");
        buttonValidar.setOnAction(e -> window.setScene(sceneAutores));
        GridPane.setConstraints(buttonValidar,0,1);



        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
                " 1: e^x",
                " 2: 1/e^x",
                " 3: e^-x",
                " 4: 1/(1-x)",
                " 5: Pi",
                " 6: Pi/4",
                " 7: ln(x+1)",
                " 8: sen(x)",
                " 9: cos(x)",
                "10: tan^-1(x)",
                "11: senh(x)",
                "12: cosh(x)",
                "13: Algoritmo de Wallis"
        );
        comboBox.setPromptText("Seleccione la función");
        comboBox.setOnAction(e ->System.out.println("Se ha Seleccionado: "+ comboBox.getValue()));
        GridPane.setConstraints(comboBox,0,2);

        labelEstatus = new Label("Función que esta en uso");
        GridPane.setConstraints(labelEstatus,0,3);


        labelValorX = new Label("________________");
        GridPane.setConstraints(labelValorX,1,0);

        buttonSerie = new Button();
        buttonSerie.setText("Series de Tylor");
        GridPane.setConstraints(buttonSerie,1,1);
        buttonSerie.setOnAction(e -> window.setScene(sceneSeries));

        buttonClose = new Button();
        buttonClose.setText("Cerrar");
        GridPane.setConstraints(buttonClose,1,2);
        buttonClose.setOnAction(e -> window.close());

        labelParametriza = new Label();
        labelParametriza.setText("Parametriza el calculo :");
        GridPane.setConstraints(labelParametriza,1,3);

        txtValorX.setPromptText("Valor en X");
        GridPane.setConstraints(txtValorX,1,4);

        txtIteraciones.setPromptText("No. de Iteraciones");
        GridPane.setConstraints(txtIteraciones,1,5);

        buttonCalcular = new Button();
        buttonCalcular.setText("Calcular");
        GridPane.setConstraints(buttonCalcular,1,7);

        txtCifras = new TextField();
        txtCifras.setPromptText("No. de Cifras Significativas");
        GridPane.setConstraints(txtCifras,1,6);

        GridPane.setConstraints(tableView,0,3);

        box.getChildren().addAll(
                labelParametriza,
                txtValorX,
                txtCifras,
                txtIteraciones,
                buttonCalcular
               );

        GridPane.setConstraints(box,1,3);

        //Agregar toda la cosa al sceneFunciones
        gridPane.getChildren().addAll(
                labelFunciones,
                buttonClose,
                buttonSerie,
                //labelParametriza,
                //txtValorX,
                //txtIteraciones,
                //txtCifras,
                labelValorX,
                comboBox,
                buttonValidar,
                //buttonCalcular,
                box,
                tableView);
        sceneFunciones=new Scene(gridPane,600,250);
        sceneFunciones.getStylesheets().add("DarkTheme.css");
    }//Funciones

    Metodos13Funciones metodos = new Metodos13Funciones(13);

    TextArea txtArea = new TextArea();

    private void llenarArea(){
        txtArea.setText(
                metodos.mostrar(
                        metodos.serieTaylor(
                                Double.parseDouble(txtA.getText()),
                                Double.parseDouble(txtB.getText()),
                                Double.parseDouble(txtC.getText()),
                                Double.parseDouble(txtD.getText()),
                                Double.parseDouble(txtE.getText()),
                                Double.parseDouble(txtX1.getText()),
                                Double.parseDouble(txtX2.getText())
                        )//serieTylor
                )//Mostrar
        );//setText
    }

    private void seriesTyalor(){


        //Declaración de Diseño en seriesTylor
        GridPane gridPane=new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        HBox hBoxLabels = new HBox();
        HBox hBoxText = new HBox();
        HBox hBoxCosas = new HBox();

        hBoxCosas.setPadding(new Insets(0,0,0,30));
        hBoxText.setPadding(new Insets(0,20,0,10));


        //Declaracion de botones en sceneSeries
        buttonFunciones = new Button("Funciones");
        buttonFunciones.setOnAction(e -> window.setScene(sceneFunciones));
        //GridPane.setConstraints(buttonFunciones,3,0);

        buttonCalcularSerie = new Button("Calcular Serie");
        //GridPane.setConstraints(buttonCalcularSerie,4,0);

        buttonClose = new Button();
        buttonClose.setText("Cerrar");
        //GridPane.setConstraints(buttonClose,5,0);
        buttonClose.setOnAction(e -> window.close());

        //Declaración de Label en sceneSeries
        labelSeries = new Label("Series de Tylor");
        //GridPane.setConstraints(labelSeries,0,0);

        hBoxCosas.getChildren().addAll(
                buttonFunciones,
                buttonCalcularSerie,
                buttonClose,
                labelSeries
        );

        GridPane.setConstraints(hBoxCosas,0,0);

        ///
        lblA = new Label("A");
        lblB = new Label("B");
        lblC = new Label("C");
        lblD = new Label("D");
        lblE = new Label("E");
        lblX1 = new Label("X1");
        lblX2 = new Label("X2");
        /*GridPane.setConstraints(lblA,0,1);
        GridPane.setConstraints(lblB,1,1);
        GridPane.setConstraints(lblC,2,1);
        GridPane.setConstraints(lblD,3,1);
        GridPane.setConstraints(lblE,4,1);
        GridPane.setConstraints(lblX1,5,1);
        GridPane.setConstraints(lblX2,6,1);*/

        hBoxLabels.getChildren().addAll(
                lblA,
                lblB,
                lblC,
                lblD,
                lblE,
                lblX1,
                lblX2
        );

        GridPane.setConstraints(hBoxLabels,0,1);

        //TextField
        txtA= new TextField();
        txtA.setPromptText("Valor X^4");

        txtB= new TextField();
        txtB.setPromptText("Valor X^3");

        txtC= new TextField();
        txtC.setPromptText("Valor X^2");

        txtD= new TextField();
        txtD.setPromptText("Valor X");

        txtE= new TextField();
        txtE.setPromptText("Constante");

        txtX1= new TextField();
        txtX1.setPromptText("X");

        txtX2= new TextField();
        txtX2.setPromptText("X+1");
        /*GridPane.setConstraints(txtA,0,2);
        GridPane.setConstraints(txtB,1,2);
        GridPane.setConstraints(txtC,2,2);
        GridPane.setConstraints(txtD,3,2);
        GridPane.setConstraints(txtE,4,2);
        GridPane.setConstraints(txtX1,5,2);
        GridPane.setConstraints(txtX2,6,2);*/

        hBoxText.getChildren().addAll(
                txtA,
                txtB,
                txtC,
                txtD,
                txtE,
                txtX1,
                txtX2,
                txtArea
        );

        GridPane.setConstraints(hBoxText,0,2);

        GridPane.setConstraints(txtArea,0,3);

        //bind



        //Agregar toda la cosa al GridPane
        gridPane.getChildren().addAll(
               /* buttonFunciones,
                buttonCalcularSerie,
                buttonClose,
                labelSeries,*/
                hBoxCosas,
               // hBoxLabels,
                hBoxText,
                txtArea
        );
        sceneSeries=new Scene(gridPane,300,250);
        sceneSeries.getStylesheets().add("DarkTheme.css");
    }//Series de Tylor

    public static void main(String[] args) {
        launch(args);
    }//main

}//U1_.Main_U1