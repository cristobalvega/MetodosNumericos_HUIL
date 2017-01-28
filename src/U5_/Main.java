import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.naming.spi.DirObjectFactory;

public class Main extends Application {

    Stage stage;
    Scene scene,sceneCreditos;

    TDA_U5 tda_u5;

    Label   lbl_c,lbl_x,lbl_x2,lbl_x3,
            lbl_X,lbl_X0,lbl_X1,lbl_X2,
            lbl_Fx0,lbl_Fx1,lbl_Fx2;

    Button  btn_LinealNewton,btn_CuadraticaNewton,
            btn_LinealLaGranje,btn_CuadraticaLaGranje,
            btn_LinealNewton_Academico,btn_CuadraticaNewton_Academico,
            btn_LinealLaGranje_Academico,btn_CuadraticaLaGranje_Academico,btn_Creditos;

    TextField   txt_c,txt_x,txt_x2,txt_x3,
                txt_X,txt_X0,txt_X1,txt_X2,
                txt_Fx0,txt_Fx1,txt_Fx2;

    TextArea  txtArea,txtArea2;

    HBox hbox_1,hbox_2,hbox_3;
    VBox vbox_1,vbox_2,vbox_3,vbox_4;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage=primaryStage;
        stage=primaryStage;
        stage.setTitle("Unidad 5 | Equipo 6 de 3:00 a 4:00");
        stage.show();
        stage.setOnCloseRequest(e->primaryStage.close());

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        autores();

        lbl_c = new Label("c + ");
        txt_c = new TextField("7");
        txt_c.setPrefSize(30,30);

        lbl_x = new Label("x + ");
        txt_x = new TextField("2");
        txt_x.setPrefSize(30,30);

        lbl_x2 = new Label("x^2 + ");
        txt_x2 = new TextField("-0.3");
        txt_x2.setPrefSize(30,30);

        lbl_x3 = new Label("x^3");
        txt_x3 = new TextField("0.1");
        txt_x3.setPrefSize(30,30);

        lbl_X = new Label("Valor en X :");
        txt_X = new TextField("10");
        txt_X.setPrefSize(60,30);

        lbl_X0 = new Label("Valor en X0 :");
        txt_X0 = new TextField("2");
        txt_X0.setPrefSize(60,30);

        lbl_X1 = new Label("Valor en X1 :");
        txt_X1 = new TextField("7");
        txt_X1.setPrefSize(60,30);

        lbl_X2 = new Label("Valor en X2 :");
        txt_X2 = new TextField("12");
        txt_X2.setPrefSize(60,30);

        lbl_Fx0 = new Label("F(x0) = ");
        txt_Fx0 = new TextField("10.6");

        lbl_Fx1 = new Label("F(x1) = ");
        txt_Fx1 = new TextField("40.6");

        lbl_Fx2 = new Label("F(x1) = ");
        txt_Fx2 = new TextField("160.6");

        txtArea = new TextArea();
        txtArea.setEditable(false);
        txtArea.setPrefWidth(120);

        txtArea2 = new TextArea();
        txtArea2.setPrefWidth(220);
        txtArea2.setEditable(false);

        btn_LinealNewton = new Button("Lineal Newton");
        btn_CuadraticaNewton = new Button("Cuadratica Newton");
        btn_LinealLaGranje = new Button("Lineal LaGranje");
        btn_CuadraticaLaGranje = new Button("Cuadratica LaGranje");

        btn_LinealNewton_Academico = new Button("Lineal Newton Discreto");
        btn_CuadraticaNewton_Academico = new Button("Cuadratica Newton Discreto");
        btn_LinealLaGranje_Academico = new Button("Lineal LaGranje Discreto");
        btn_CuadraticaLaGranje_Academico = new Button("Cuadratica LaGranje Discreto");

        hbox_1 = new HBox();
        hbox_1.getChildren().addAll(
                txt_c,
                lbl_c,
                txt_x,
                lbl_x,
                txt_x2,
                lbl_x2,
                txt_x3,
                lbl_x3
        );

        vbox_2 = new VBox();
        vbox_2.getChildren().addAll(
                btn_LinealNewton,
                btn_LinealLaGranje,
                btn_CuadraticaNewton,
                btn_CuadraticaLaGranje
        );

        vbox_3 = new VBox();
        vbox_3.getChildren().addAll(
                btn_LinealNewton_Academico,
                btn_LinealLaGranje_Academico,
                btn_CuadraticaNewton_Academico,
                btn_CuadraticaLaGranje_Academico
        );

        vbox_1 = new VBox();
        vbox_1.getChildren().addAll(
                lbl_X0,
                txt_X0,
                lbl_X,
                txt_X,
                lbl_X1,
                txt_X1,
                lbl_X2,
                txt_X2
        );

        vbox_4 = new VBox();
        vbox_4.getChildren().addAll(
                lbl_Fx0,
                txt_Fx0,
                lbl_Fx1,
                txt_Fx1,
                lbl_Fx2,
                txt_Fx2
        );


        btn_Creditos = new Button("Creditos");
        btn_Creditos.setOnAction(e->stage.setScene(sceneCreditos));

        GridPane.setConstraints(hbox_1,0,0);
        GridPane.setConstraints(vbox_1,0,1);
        GridPane.setConstraints(vbox_2,1,1);
        GridPane.setConstraints(btn_Creditos,1,3);
        GridPane.setConstraints(vbox_3,2,1);
        GridPane.setConstraints(vbox_4,3,1);
        GridPane.setConstraints(txtArea,0,2);
        GridPane.setConstraints(txtArea2,1,2);

        btn_LinealNewton.setOnAction(e->linealNewton());
        btn_LinealLaGranje.setOnAction(e->linealLaGranje());
        btn_CuadraticaNewton.setOnAction(e-> cuadraticaNewton());
        btn_CuadraticaLaGranje.setOnAction(e->cuadraticaLaGranje());

        btn_LinealNewton_Academico.setOnAction(e->linealNewtonDiscreto());
        btn_LinealLaGranje_Academico.setOnAction(e->linealLaGranjeDiscreto());
        btn_CuadraticaNewton_Academico.setOnAction(e-> cuadraticaNewtonDiscreto());
        btn_CuadraticaLaGranje_Academico.setOnAction(e->cuadraticaLaGranjeDiscreto());


        gridPane.getChildren().addAll(
                hbox_1,
                vbox_1,
                vbox_2,
                vbox_3,
                vbox_4,
                txtArea,
                txtArea2,
                btn_Creditos
        );

        scene = new Scene(gridPane,1000,500);
        //scene.getStylesheets().add("DarkTheme.css");
        stage.setScene(scene);
        stage.show();
    }//start

    Label lblCristobal,lblEdgar,lblFrancisco;
    Button buttonUnidad5;


    private void autores() {
        GridPane gridPane=new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);



        lblCristobal = new Label("Vega Luna Cristobal Elihu \n      - No. Control 14401015 \n " +
                "Nuñez Gonzalez Edgar Eduardo  \n      - No. Control 14400979  \n"  +
                "Gallegos Gomez Francisco Javier  \n   - No. Control 13400409  \n" );
        lblEdgar = new Label("Instituto Tecnológico de Tepic \n Métodos Númericos:  Unidad 5 \n Interpolación Númerica \n " +
                "Programa de de unidad  \n Hora: 3:00 p.m. - 4:00 p.m. \n Grupo A \n Autores : \n  ");
        lblFrancisco=   new Label(" Para el Docente:\n" +
                "M.A. Hugo Ulyses Ibarra López");

        //Image image = new Image(getClass().getResourceAsStream("1.-Instituto_Tecnologico_de_Tepic.png"));
        //lbl_Tec = new Label("Search",new ImageView(image));
        //lbl_Tec.setGraphic(new ImageView(image));




        GridPane.setConstraints(lblCristobal,0,2);
        GridPane.setConstraints(lblEdgar,0,1);
        GridPane.setConstraints(lblFrancisco,0,3);
        //GridPane.setConstraints(lbl_Tec,0,4);


        buttonUnidad5 = new Button("Regresar a la Unidad 5");
        buttonUnidad5.setOnAction(e -> stage.setScene(scene));
        GridPane.setConstraints(buttonUnidad5,0,4);

        gridPane.getChildren().addAll(
                lblCristobal,
                lblEdgar,
                lblFrancisco,
                buttonUnidad5
        );


        sceneCreditos= new Scene(gridPane,300,500);
        //sceneCreditos.getStylesheets().add("DarkTheme.css");
    }//autores

    private void cuadraticaLaGranjeDiscreto() {
        tda_u5 = new TDA_U5();
        tda_u5.iniciarCuadraticoDiscreto(
                Double.parseDouble(txt_X.getText()),
                Double.parseDouble(txt_X0.getText()),
                Double.parseDouble(txt_Fx0.getText()),
                Double.parseDouble(txt_X1.getText()),
                Double.parseDouble(txt_Fx1.getText()),
                Double.parseDouble(txt_X2.getText()),
                Double.parseDouble(txt_Fx2.getText())
        );

        txtArea.setText(
                "Interpolacion Cuadratica de LaGranje    | "+"\n"+
                        "X = "+tda_u5.X+"\n"+
                        "X0 = "+tda_u5.X0+"\n"+
                        "X1 = "+tda_u5.X1+"\n"+
                        "X2 = "+tda_u5.X2+"\n"+
                        "F(X) = "+tda_u5.VALOR_VERDADERO+"\n"+
                        "F(X0) = "+tda_u5.FX0+"\n"+
                        "F(X1) = "+tda_u5.FX1+"\n"+
                        "F(X1) = "+tda_u5.FX2+"\n"+
                        "Interpolacion = "+tda_u5.FX2_LAGRANJE+"\n"+
                        "Error Cuadrático LaGranje = "+tda_u5.ERROR_CUADRATICO_LAGRANJE+"%"
        );

        txtArea2.setText(
                "Cuadro Comparativo        |       ->"+"\n"+
                        "Interpolacion Lineal Newton= "+tda_u5.FX1_NEWTON+"\n"+
                        "Error Lineal Newton "+tda_u5.ERROR_LINEAL_NEWTON+"%"+"\n"+
                        "Interpolacion Lineal LaGranje = "+tda_u5.FX1_LAGRANJE+"\n"+
                        "Error Lineal LaGranje "+tda_u5.ERROR_LINEAL_LAGRANJE+"%"+"\n"+
                        "Interpolacion Cuadratico Newton = "+tda_u5.FX2_NEWTON+"\n"+
                        "Error Cuadratico Newton =  "+tda_u5.ERROR_CUADRATICO_NEWTON+"%"+"\n"+
                        "Interpolacion Cuadrático LeGranje = "+tda_u5.FX2_LAGRANJE+"\n"+
                        "Error Cuadrático LeGranje = "+tda_u5.ERROR_CUADRATICO_LAGRANJE+"%"
        );
    }

    private void cuadraticaNewtonDiscreto() {
        tda_u5 = new TDA_U5();
        tda_u5.iniciarCuadraticoDiscreto(
                Double.parseDouble(txt_X.getText()),
                Double.parseDouble(txt_X0.getText()),
                Double.parseDouble(txt_Fx0.getText()),
                Double.parseDouble(txt_X1.getText()),
                Double.parseDouble(txt_Fx1.getText()),
                Double.parseDouble(txt_X2.getText()),
                Double.parseDouble(txt_Fx2.getText())
        );

        txtArea.setText(
                "Interpolacion Cuadrática de Newton    | "+"\n"+
                        "X = "+tda_u5.X+"\n"+
                        "X0 = "+tda_u5.X0+"\n"+
                        "X1 = "+tda_u5.X1+"\n"+
                        "X2 = "+tda_u5.X2+"\n"+
                        "F(X) = "+tda_u5.VALOR_VERDADERO+"\n"+
                        "F(X0) = "+tda_u5.FX0+"\n"+
                        "F(X1) = "+tda_u5.FX1+"\n"+
                        "F(X2) = "+tda_u5.FX2+"\n"+
                        "a0 = "+tda_u5.a0+"\n"+
                        "a1 = "+tda_u5.a1+"\n"+
                        "a2 = "+tda_u5.a2+"\n"+
                        "b0 = "+tda_u5.b0+"\n"+
                        "b1 = "+tda_u5.b1+"\n"+
                        "b2 = "+tda_u5.b2+"\n"+
                        "Interpolacion = "+tda_u5.FX2_NEWTON+"\n"+
                        "Error Cuadratico Newton = "+tda_u5.ERROR_CUADRATICO_NEWTON+"%"
        );

        txtArea2.setText(
                "Cuadro Comparativo        |       ->"+"\n"+
                        "Interpolacion Lineal Newton= "+tda_u5.FX1_NEWTON+"\n"+
                        "Error Lineal Newton "+tda_u5.ERROR_LINEAL_NEWTON+"%"+"\n"+
                        "Interpolacion Lineal LaGranje = "+tda_u5.FX1_LAGRANJE+"\n"+
                        "Error Lineal LaGranje "+tda_u5.ERROR_LINEAL_LAGRANJE+"%"+"\n"+
                        "Interpolacion Cuadratico Newton = "+tda_u5.FX2_NEWTON+"\n"+
                        "Error Cuadratico Newton =  "+tda_u5.ERROR_CUADRATICO_NEWTON+"%"+"\n"+
                        "Interpolacion Cuadrático LeGranje = "+tda_u5.FX2_LAGRANJE+"\n"+
                        "Error Cuadrático LeGranje = "+tda_u5.ERROR_CUADRATICO_LAGRANJE+"%"
        );
    }

    private void linealLaGranjeDiscreto() {
        tda_u5 = new TDA_U5();
        tda_u5.iniciarLinealDiscreto(
                Double.parseDouble(txt_X.getText()),
                Double.parseDouble(txt_X0.getText()),
                Double.parseDouble(txt_Fx0.getText()),
                Double.parseDouble(txt_X1.getText()),
                Double.parseDouble(txt_Fx1.getText())
        );

        txtArea.setText(
                "Interpolacion Lineal de LaGranje    | "+"\n"+
                        "X = "+tda_u5.X+"\n"+
                        "X0 = "+tda_u5.X0+"\n"+
                        "X1 = "+tda_u5.X1+"\n"+
                        "F(X) = "+tda_u5.VALOR_VERDADERO+"\n"+
                        "F(X0) = "+tda_u5.FX0+"\n"+
                        "F(X1) = "+tda_u5.FX1+"\n"+
                        "Interpolacion = "+tda_u5.FX1_LAGRANJE+"\n"+
                        "Error Lineal LaGranje = "+tda_u5.ERROR_LINEAL_LAGRANJE+"%"
        );

        txtArea2.setText(
                "Cuadro Comparativo        |       ->"+"\n"+
                        "Interpolacion Lineal Newton= "+tda_u5.FX1_NEWTON+"\n"+
                        "Error Lineal Newton "+tda_u5.ERROR_LINEAL_NEWTON+"%"+"\n"+
                        "Interpolacion Lineal LaGranje = "+tda_u5.FX1_LAGRANJE+"\n"+
                        "Error Lineal LaGranje "+tda_u5.ERROR_LINEAL_LAGRANJE+"%"+"\n"+
                        "Interpolacion Cuadratico Newton = "+tda_u5.FX2_NEWTON+"\n"+
                        "Error Cuadratico Newton =  "+tda_u5.ERROR_CUADRATICO_NEWTON+"%"+"\n"+
                        "Interpolacion Cuadrático LeGranje = "+tda_u5.FX2_LAGRANJE+"\n"+
                        "Error Cuadrático LeGranje = "+tda_u5.ERROR_CUADRATICO_LAGRANJE+"%"
        );
    }

    private void linealNewtonDiscreto() {
        tda_u5 = new TDA_U5();
        tda_u5.iniciarLinealDiscreto(
                Double.parseDouble(txt_X.getText()),
                Double.parseDouble(txt_X0.getText()),
                Double.parseDouble(txt_Fx0.getText()),
                Double.parseDouble(txt_X1.getText()),
                Double.parseDouble(txt_Fx1.getText())
                );

        txtArea.setText(
                "Interpolacion Lineal de Newton    | "+"\n"+
                        "X = "+tda_u5.X+"\n"+
                        "X0 = "+tda_u5.X0+"\n"+
                        "X1 = "+tda_u5.X1+"\n"+
                        "F(X) = "+tda_u5.VALOR_VERDADERO+"\n"+
                        "F(X0) = "+tda_u5.FX0+"\n"+
                        "F(X1) = "+tda_u5.FX1+"\n"+
                        "Interpolacion = "+tda_u5.FX1_NEWTON+"\n"
        );

        txtArea2.setText(
                "Cuadro Comparativo        |       ->"+"\n"+
                        "Interpolacion Lineal Newton= "+tda_u5.FX1_NEWTON+"\n"+
                        "Interpolacion Lineal LaGranje = "+tda_u5.FX1_LAGRANJE+"\n"+
                        "Interpolacion Cuadratico Newton = "+tda_u5.FX2_NEWTON+"\n"+
                        "Interpolacion Cuadrático LeGranje = "+tda_u5.FX2_LAGRANJE+"\n"
        );
    }

    private void linealNewton() {
        tda_u5 = new TDA_U5();
        tda_u5.iniciarLineal(
                Double.parseDouble(txt_c.getText()),
                Double.parseDouble(txt_x.getText()),
                Double.parseDouble(txt_x2.getText()),
                Double.parseDouble(txt_x3.getText()),
                Double.parseDouble(txt_X.getText()),
                Double.parseDouble(txt_X0.getText()),
                Double.parseDouble(txt_X1.getText())
        );

        txtArea.setText(
                        "Interpolacion Lineal de Newton    | "+"\n"+
                        "X = "+tda_u5.X+"\n"+
                        "X0 = "+tda_u5.X0+"\n"+
                        "X1 = "+tda_u5.X1+"\n"+
                        "F(X) = "+tda_u5.VALOR_VERDADERO+"\n"+
                        "F(X0) = "+tda_u5.FX0+"\n"+
                        "F(X1) = "+tda_u5.FX1+"\n"+
                        "Interpolacion = "+tda_u5.FX1_NEWTON+"\n"+
                        "Error Lineal Newton = "+tda_u5.ERROR_LINEAL_NEWTON+"%"
        );

        txtArea2.setText(
                "Cuadro Comparativo        |       ->"+"\n"+
                        "Interpolacion Lineal Newton= "+tda_u5.FX1_NEWTON+"\n"+
                        "Error Lineal Newton "+tda_u5.ERROR_LINEAL_NEWTON+"%"+"\n"+
                        "Interpolacion Lineal LaGranje = "+tda_u5.FX1_LAGRANJE+"\n"+
                        "Error Lineal LaGranje "+tda_u5.ERROR_LINEAL_LAGRANJE+"%"+"\n"+
                        "Interpolacion Cuadratico Newton = "+tda_u5.FX2_NEWTON+"\n"+
                        "Error Cuadratico Newton =  "+tda_u5.ERROR_CUADRATICO_NEWTON+"%"+"\n"+
                        "Interpolacion Cuadrático LeGranje = "+tda_u5.FX2_LAGRANJE+"\n"+
                        "Error Cuadrático LeGranje = "+tda_u5.ERROR_CUADRATICO_LAGRANJE+"%"
        );
    }//linaealNewton

    private void linealLaGranje() {
        tda_u5 = new TDA_U5();
        tda_u5.iniciarLineal(
                Double.parseDouble(txt_c.getText()),
                Double.parseDouble(txt_x.getText()),
                Double.parseDouble(txt_x2.getText()),
                Double.parseDouble(txt_x3.getText()),
                Double.parseDouble(txt_X.getText()),
                Double.parseDouble(txt_X0.getText()),
                Double.parseDouble(txt_X1.getText())
        );

        txtArea.setText(
                "Interpolacion Lineal de LaGranje    | "+"\n"+
                        "X = "+tda_u5.X+"\n"+
                        "X0 = "+tda_u5.X0+"\n"+
                        "X1 = "+tda_u5.X1+"\n"+
                        "F(X) = "+tda_u5.VALOR_VERDADERO+"\n"+
                        "F(X0) = "+tda_u5.FX0+"\n"+
                        "F(X1) = "+tda_u5.FX1+"\n"+
                        "Interpolacion = "+tda_u5.FX1_LAGRANJE+"\n"+
                        "Error Lineal LaGranje = "+tda_u5.ERROR_LINEAL_LAGRANJE+"%"
        );

        txtArea2.setText(
                "Cuadro Comparativo        |       ->"+"\n"+
                        "Interpolacion Lineal Newton= "+tda_u5.FX1_NEWTON+"\n"+
                        "Error Lineal Newton "+tda_u5.ERROR_LINEAL_NEWTON+"%"+"\n"+
                        "Interpolacion Lineal LaGranje = "+tda_u5.FX1_LAGRANJE+"\n"+
                        "Error Lineal LaGranje "+tda_u5.ERROR_LINEAL_LAGRANJE+"%"+"\n"+
                        "Interpolacion Cuadratico Newton = "+tda_u5.FX2_NEWTON+"\n"+
                        "Error Cuadratico Newton =  "+tda_u5.ERROR_CUADRATICO_NEWTON+"%"+"\n"+
                        "Interpolacion Cuadrático LeGranje = "+tda_u5.FX2_LAGRANJE+"\n"+
                        "Error Cuadrático LeGranje = "+tda_u5.ERROR_CUADRATICO_LAGRANJE+"%"
        );

    }//linealLaGranje

    private void cuadraticaNewton() {
        tda_u5 = new TDA_U5();
        tda_u5.iniciarCuadratico(
                Double.parseDouble(txt_c.getText()),
                Double.parseDouble(txt_x.getText()),
                Double.parseDouble(txt_x2.getText()),
                Double.parseDouble(txt_x3.getText()),
                Double.parseDouble(txt_X.getText()),
                Double.parseDouble(txt_X0.getText()),
                Double.parseDouble(txt_X1.getText()),
                Double.parseDouble(txt_X2.getText())
        );

        txtArea.setText(
                "Interpolacion Cuadrática de Newton    | "+"\n"+
                        "X = "+tda_u5.X+"\n"+
                        "X0 = "+tda_u5.X0+"\n"+
                        "X1 = "+tda_u5.X1+"\n"+
                        "X2 = "+tda_u5.X2+"\n"+
                        "F(X) = "+tda_u5.VALOR_VERDADERO+"\n"+
                        "F(X0) = "+tda_u5.FX0+"\n"+
                        "F(X1) = "+tda_u5.FX1+"\n"+
                        "F(X2) = "+tda_u5.FX2+"\n"+
                        "a0 = "+tda_u5.a0+"\n"+
                        "a1 = "+tda_u5.a1+"\n"+
                        "a2 = "+tda_u5.a2+"\n"+
                        "b0 = "+tda_u5.b0+"\n"+
                        "b1 = "+tda_u5.b1+"\n"+
                        "b2 = "+tda_u5.b2+"\n"+
                        "Interpolacion = "+tda_u5.FX2_NEWTON+"\n"+
                        "Error Cuadratico Newton = "+tda_u5.ERROR_CUADRATICO_NEWTON+"%"
        );

        txtArea2.setText(
                "Cuadro Comparativo        |       ->"+"\n"+
                        "Interpolacion Lineal Newton= "+tda_u5.FX1_NEWTON+"\n"+
                        "Error Lineal Newton "+tda_u5.ERROR_LINEAL_NEWTON+"%"+"\n"+
                        "Interpolacion Lineal LaGranje = "+tda_u5.FX1_LAGRANJE+"\n"+
                        "Error Lineal LaGranje "+tda_u5.ERROR_LINEAL_LAGRANJE+"%"+"\n"+
                        "Interpolacion Cuadratico Newton = "+tda_u5.FX2_NEWTON+"\n"+
                        "Error Cuadratico Newton =  "+tda_u5.ERROR_CUADRATICO_NEWTON+"%"+"\n"+
                        "Interpolacion Cuadrático LeGranje = "+tda_u5.FX2_LAGRANJE+"\n"+
                        "Error Cuadrático LeGranje = "+tda_u5.ERROR_CUADRATICO_LAGRANJE+"%"
        );
    }//cuadraticaNewton

    private void cuadraticaLaGranje() {
        tda_u5 = new TDA_U5();
        tda_u5.iniciarCuadratico(
                Double.parseDouble(txt_c.getText()),
                Double.parseDouble(txt_x.getText()),
                Double.parseDouble(txt_x2.getText()),
                Double.parseDouble(txt_x3.getText()),
                Double.parseDouble(txt_X.getText()),
                Double.parseDouble(txt_X0.getText()),
                Double.parseDouble(txt_X1.getText()),
                Double.parseDouble(txt_X2.getText())
        );

        txtArea.setText(
                "Interpolacion Cuadratica de LaGranje    | "+"\n"+
                        "X = "+tda_u5.X+"\n"+
                        "X0 = "+tda_u5.X0+"\n"+
                        "X1 = "+tda_u5.X1+"\n"+
                        "X2 = "+tda_u5.X2+"\n"+
                        "F(X) = "+tda_u5.VALOR_VERDADERO+"\n"+
                        "F(X0) = "+tda_u5.FX0+"\n"+
                        "F(X1) = "+tda_u5.FX1+"\n"+
                        "F(X1) = "+tda_u5.FX2+"\n"+
                        "Interpolacion = "+tda_u5.FX2_LAGRANJE+"\n"+
                        "Error Cuadrático LaGranje = "+tda_u5.ERROR_CUADRATICO_LAGRANJE+"%"
        );

        txtArea2.setText(
                "Cuadro Comparativo        |       ->"+"\n"+
                        "Interpolacion Lineal Newton= "+tda_u5.FX1_NEWTON+"\n"+
                        "Error Lineal Newton "+tda_u5.ERROR_LINEAL_NEWTON+"%"+"\n"+
                        "Interpolacion Lineal LaGranje = "+tda_u5.FX1_LAGRANJE+"\n"+
                        "Error Lineal LaGranje "+tda_u5.ERROR_LINEAL_LAGRANJE+"%"+"\n"+
                        "Interpolacion Cuadratico Newton = "+tda_u5.FX2_NEWTON+"\n"+
                        "Error Cuadratico Newton =  "+tda_u5.ERROR_CUADRATICO_NEWTON+"%"+"\n"+
                        "Interpolacion Cuadrático LeGranje = "+tda_u5.FX2_LAGRANJE+"\n"+
                        "Error Cuadrático LeGranje = "+tda_u5.ERROR_CUADRATICO_LAGRANJE+"%"
        );
    }//cuadraticaLaGranje

    public static void main(String[] args) {
        launch(args);
    }
}//main
