package U4_;

import javafx.application.Application;
import javafx.beans.property.adapter.JavaBeanObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;

import static java.awt.SystemColor.window;
 


public class Main extends Application {

    Stage stage;
    Label lable_resultado,lbl_c, lbl_x,lbl_x2,lbl_x3,lbl_x4,lbl_x5,lbl_a,lbl_b,
            lbl_Integrando_Numerico_RTL,lbl_Ea_RTL,lbl_FEpcilon,lbl_Valor_verdadero,lbl_Et,lbl_fx,
            lbl_resultado_Integrando_Numerico_RTL, lbl_resultado_Ea_RTL, lbl_resultado_FEpcilon,
            lbl_resultado_Valor_Verdadero, lbl_resultado_ET,lbl_resultado_fx, label_Numero_Segementos,label_x_derivadaNumerica, label_tamano_paso,
    label_esPAR;

    TextField txt_c,txt_x,txt_x2,txt_x3,txt_x4,txt_x5,txt_a,txt_b, txt_Segmentos,txt_x_derivada,txt_tamano_paso;

    Button btn_RTL,btn_RTM,btn_Simpson_1_3,btn_Simpson_1_3_Multiple,btn_Simpson_3_8,btn_Derivacion,btn_Creditos,btn_tamano_paso;

    HBox hbox_RTL_Button, hbox_Polinomio_1, hbox_Polinomio_2,hbox_Polinomio_3,hbox_a,hbox_b,hbox_RTL,
            hBox_Trapezoidal,hBox_Simpson_1_3,hBox_Simpson3_8_Derivacion;

    VBox vbox_RTL,vbox_RTL_Resultados,vbox_a_b,vbox_Segmentos,vBox_x_derivadaNumerica;

    TextArea txt_area_salidas_principales,txt_area_salidas_secundarias;

    TDA_U4 tda_u4;
    Scene scene,sceneCreditos;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage=primaryStage;
        stage.setTitle("Unidad 4 | Equipo 6 de 3:00 a 4:00");
        stage.show();
        stage.setOnCloseRequest(e->primaryStage.close());

        autores();

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        //Creacion de Labels Polinomio
        lbl_c = new Label(" + ");
        lbl_x = new Label("x+ ");
        lbl_x2 = new Label("x^2 + ");
        lbl_x3 = new Label("x^3 + ");
        lbl_x4 = new Label("x^4 + ");
        lbl_x5 = new Label("x^5");
        lbl_a  = new Label("a :");
        lbl_b  = new Label("b :");

        //Creacion de Labels Resutado
        lbl_Integrando_Numerico_RTL = new Label("  Integrando Numerico  :");
        lbl_Ea_RTL = new Label("  Ea RTL :");
        lbl_FEpcilon = new Label("  FEpcilon :");
        lbl_Valor_verdadero = new Label("  Valor Verdadero :");
        lbl_Et = new Label("   Et  :");
        lbl_fx = new Label("   F(x) :");

        label_esPAR = new Label("El valor para h debe ser par");
        label_esPAR.setVisible(false);

        //Creacion de Labels que muestran el resutado de cada método
        lbl_resultado_Integrando_Numerico_RTL = new Label();
        lbl_resultado_Ea_RTL = new Label();
        lbl_resultado_ET = new Label();
        lbl_resultado_FEpcilon = new Label();
        lbl_resultado_fx = new Label();
        lbl_resultado_Valor_Verdadero = new Label();

        lable_resultado = new Label(" Resultados ");
        label_Numero_Segementos = new Label("Numero de Segmentos");
        label_x_derivadaNumerica = new Label("Valor X (Derivada)");
        label_tamano_paso = new Label("Tamaño de paso (Derivada)");



        //Creación de TextFields
        txt_c  = new TextField("0.2");
        txt_x  = new TextField("25");
        txt_x2 = new TextField("-200");
        txt_x3 = new TextField("675");
        txt_x4 = new TextField("-900");
        txt_x5 = new TextField("400");

        txt_Segmentos = new TextField("5");
        txt_x_derivada = new TextField("0.6");
        txt_tamano_paso = new TextField("0.5");

        //Se establecen el tamaño ideal
        txt_c.setPrefWidth(50);
        txt_x.setPrefWidth(50);
        txt_x2.setPrefWidth(50);
        txt_x3.setPrefWidth(50);
        txt_x4.setPrefWidth(50);
        txt_x5.setPrefWidth(50);
        txt_Segmentos.setPrefWidth(50);


        txt_a = new TextField("0.3");
        txt_b = new TextField("0.8");
        txt_a.setPrefWidth(110);
        txt_b.setPrefWidth(110);

        btn_RTL = new Button("RTL");
        btn_RTL.setPrefSize(90,50);

        btn_RTM = new Button("RTM");
        btn_RTM.setPrefSize(90,50);

        btn_Simpson_1_3 = new Button("1/3");
        btn_Simpson_1_3.setPrefSize(90,50);

        btn_Simpson_1_3_Multiple = new Button("1/3 M");
        btn_Simpson_1_3_Multiple.setPrefSize(90,50);

        btn_Simpson_3_8 = new Button("3/8");
        btn_Simpson_3_8.setPrefSize(90,50);

        btn_Derivacion = new Button("Derivacion");
        btn_Derivacion.setPrefSize(90,50);


        btn_Creditos = new Button("Créditos");
        GridPane.setConstraints(btn_Creditos,2,2);

        vbox_RTL = new VBox(6);
        vbox_RTL.getChildren().addAll(
                lbl_Integrando_Numerico_RTL,
                lbl_Ea_RTL,
                lbl_Et,
                lbl_Valor_verdadero
        );
        txt_area_salidas_principales = new TextArea(" Salidas Principales");
        txt_area_salidas_principales.setPrefSize(300,300);
        txt_area_salidas_principales.setEditable(false);
        GridPane.setConstraints(txt_area_salidas_principales,3,2);

      //GridPane.setConstraints(vbox_RTL,3,2);

        vbox_RTL_Resultados = new VBox(6);
        vbox_RTL_Resultados.getChildren().addAll(
                lbl_resultado_Integrando_Numerico_RTL,
                lbl_resultado_Ea_RTL,
                lbl_resultado_ET,
                lbl_resultado_Valor_Verdadero
        );
        txt_area_salidas_secundarias = new TextArea(" Salidas Secundarias ");
        txt_area_salidas_secundarias.setPrefSize(300,300);
        txt_area_salidas_secundarias.setEditable(false);
        GridPane.setConstraints(txt_area_salidas_secundarias,3,3);

        GridPane.setConstraints(lable_resultado,3,1);
        GridPane.setConstraints(label_esPAR,3,4);

        hbox_Polinomio_1 = new HBox(4);
        hbox_Polinomio_1.getChildren().addAll(
                txt_c,
                lbl_c,
                txt_x,
                lbl_x
        );
        GridPane.setConstraints(hbox_Polinomio_1,0,1);

        hbox_Polinomio_2 = new HBox(4);
        hbox_Polinomio_2.getChildren().addAll(
                txt_x2,
                lbl_x2
        );
        GridPane.setConstraints(hbox_Polinomio_2,1,1);

        hbox_Polinomio_3 = new HBox(4);
        hbox_Polinomio_3.getChildren().addAll(
                txt_x3,
                lbl_x3,
                txt_x4,
                lbl_x4,
                txt_x5,
                lbl_x5
        );
        GridPane.setConstraints(hbox_Polinomio_3,2,1);

        hbox_a = new HBox(2);
        hbox_a.getChildren().addAll(
          lbl_a,
          txt_a
        );
        hbox_b = new HBox(2);
        hbox_b.getChildren().addAll(
                lbl_b,
                txt_b
        );
        vbox_a_b = new VBox(2);
        vbox_a_b.getChildren().addAll(
                hbox_a,
                hbox_b
        );
        GridPane.setConstraints(vbox_a_b,0,2);

        vbox_Segmentos = new VBox(2);
        vbox_Segmentos.getChildren().addAll(
                label_Numero_Segementos,
                txt_Segmentos
        );
        GridPane.setConstraints(vbox_Segmentos,0,3);

        vBox_x_derivadaNumerica = new VBox(2);
        vBox_x_derivadaNumerica.getChildren().addAll(
                label_x_derivadaNumerica,
                txt_x_derivada,
                label_tamano_paso,
                txt_tamano_paso
        );
        GridPane.setConstraints(vBox_x_derivadaNumerica,0,4);

        hBox_Trapezoidal = new HBox(2);
        hBox_Trapezoidal.getChildren().addAll(
                btn_RTL,
                btn_RTM
        );
        GridPane.setConstraints(hBox_Trapezoidal,1,2);

        hBox_Simpson_1_3 = new HBox(2);
        hBox_Simpson_1_3.getChildren().addAll(
                btn_Simpson_1_3,
                btn_Simpson_1_3_Multiple
        );
        GridPane.setConstraints(hBox_Simpson_1_3,1,3);

        hBox_Simpson3_8_Derivacion = new HBox(2);
        hBox_Simpson3_8_Derivacion.getChildren().addAll(
                  btn_Simpson_3_8,
                  btn_Derivacion
        );
        GridPane.setConstraints(hBox_Simpson3_8_Derivacion,1,4);

        btn_RTL.setOnAction(e -> rtl());
        btn_RTM.setOnAction(e -> rtl_M());

        btn_Simpson_1_3.setOnAction(e->r_simpson_1_3());
        btn_Simpson_1_3_Multiple.setOnAction(e->r_simpson_1_3_multiple());

        btn_Simpson_3_8.setOnAction(e->r_simpson_3_8());
        btn_Derivacion.setOnAction(e->dervacion_numerica());

        btn_Creditos.setOnAction(e->stage.setScene(sceneCreditos));

        gridPane.getChildren().addAll(
                hbox_Polinomio_1,
                hbox_Polinomio_2,
                hbox_Polinomio_3,
                vbox_a_b,
                //vbox_RTL,
                txt_area_salidas_principales,
                txt_area_salidas_secundarias,
                hBox_Trapezoidal,
                hBox_Simpson_1_3,
                hBox_Simpson3_8_Derivacion,
                vbox_Segmentos,
                vBox_x_derivadaNumerica,
                btn_Creditos,
                //vbox_RTL_Resultados,
                lable_resultado
        );

        scene = new Scene(gridPane,1000,500);
        scene.getStylesheets().add("DarkTheme.css");
        stage.setScene(scene);
        stage.show();

    }//start

    Label lblCristobal,
            lblEdgar,
            lblFrancisco,
            lbl_Autores;
    //Label lbl_Tec;
    Button buttonUnidad4;
    private void autores() {
        GridPane gridPane=new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        lblCristobal = new Label("Vega Luna Cristobal Elihu \n      - No. Control 14401015 \n " +
                "Nuñez Gonzalez Edgar Eduardo  \n      - No. Control 14400979  \n"  +
                "Gallegos Gomez Francisco Javier  \n   - No. Control 13400409  \n" );
        lblEdgar = new Label("Instituto Tecnológico de Tepic \n Métodos Númericos:  Unidad 4 \n Integración Númerica \n " +
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


        buttonUnidad4 = new Button("Regresar a la Unidad 4");
        buttonUnidad4.setOnAction(e -> stage.setScene(scene));
        GridPane.setConstraints(buttonUnidad4,0,4);

        gridPane.getChildren().addAll(
                lblCristobal,
                lblEdgar,
                lblFrancisco,
                buttonUnidad4
        );


        sceneCreditos= new Scene(gridPane,300,500);
        sceneCreditos.getStylesheets().add("DarkTheme.css");
    }//autores

    private void r_simpson_3_8() {
        tda_u4 = new TDA_U4(
                Double.parseDouble(txt_c.getText()),
                Double.parseDouble(txt_x.getText()),
                Double.parseDouble(txt_x2.getText()),
                Double.parseDouble(txt_x3.getText()),
                Double.parseDouble(txt_x4.getText()),
                Double.parseDouble(txt_x5.getText()),
                Double.parseDouble(txt_a.getText()),
                Double.parseDouble(txt_b.getText())
        );

        tda_u4.simpson_3_8();

        lable_resultado.setText("Resultados: Regla de Simpson 3/8");

        txt_area_salidas_principales.setText(
                "Salidas Principales--------------------------|  \n"+
                "Integrando Númerico = "+tda_u4.INTEGRANDO_SIMPSON_3_8+"\n"+
                "Ea = "+tda_u4.EA_SIMPSON_3_8+"\n"+
                "Integrando Análitico = "+tda_u4.VALOR_VERDADERO+"\n"+
                "Et = "+tda_u4.ET_SIMPSON_3_8+"%"+"\n"
        );

        txt_area_salidas_secundarias.setText("Salidas Secundarias--------------------------|  \n"+
                "n = "+3+"\n"+
                "h = "+tda_u4.H_SIMPSON_3_8+"\n"+
                "F(x0) = "+tda_u4.FX0_SIMPSON_3_8+"\n"+
                "F(x1) = "+tda_u4.FX1_SIMPSON_3_8+"\n"+
                "F(x2) = "+tda_u4.FX2_SIMPSON_3_8+"\n"+
                "F(x3) = "+tda_u4.FX3_SIMPSON_3_8+"\n"+
                "FEpcilon 4ta = "+tda_u4.FEPCILON_CUARTA
        );
    }//r_simpson_3_8

    private void dervacion_numerica() {
        tda_u4 = new TDA_U4(
                Double.parseDouble(txt_c.getText()),
                Double.parseDouble(txt_x.getText()),
                Double.parseDouble(txt_x2.getText()),
                Double.parseDouble(txt_x3.getText()),
                Double.parseDouble(txt_x4.getText()),
                Double.parseDouble(txt_x5.getText()),
                Double.parseDouble(txt_a.getText()),
                Double.parseDouble(txt_b.getText())
        );
        tda_u4.diferenciacionNumerica(Double.parseDouble(txt_x_derivada.getText()),Double.parseDouble(txt_tamano_paso.getText()));

        lable_resultado.setText("Resultados: Diferenciacion Númerica");

        txt_area_salidas_principales.setText(
                "Salidas Principales--------------------------|  \n"+
                        "f'(x1) = "+tda_u4.DIFERENCIAL_NUMERICO_xi_menos1+"\n"+
                        //"Et = "+tda_u4.ET_Xi_MAS1+"%"+"\n"+
                        "f'(x2) = "+tda_u4.DIFERENCIAL_NUMERICO_xi+"\n"+
                        //"Et = "+tda_u4.ET_Xi+"%"+"\n"+
                        "f'(x3) = "+tda_u4.DIFERENCIAL_NUMERICO_xi_mas1+"\n"
                        //"Et = "+tda_u4.ET_Xi_MENOS1+"%"+"\n"
        );

        txt_area_salidas_secundarias.setText("Salidas Secundarias--------------------------|  \n"+
                "Xi-1 = "+tda_u4.XiMENOS1+"\n"+
                "f(xi-1) = "+tda_u4.FX_XiMENOS1+"\n"+
                "Xi = "+tda_u4.Xi+"\n"+
                "f(xi) = "+tda_u4.F_Xi+"\n"+
                "Xi+1 = "+tda_u4.XiMAS1+"\n"+
                "f(xi+1) = "+tda_u4.FX_XiMAS1+"\n"
        );
    }//dervacion_numerica

    private void rtl(){
        tda_u4 = new TDA_U4(
                Double.parseDouble(txt_c.getText()),
                Double.parseDouble(txt_x.getText()),
                Double.parseDouble(txt_x2.getText()),
                Double.parseDouble(txt_x3.getText()),
                Double.parseDouble(txt_x4.getText()),
                Double.parseDouble(txt_x5.getText()),
                Double.parseDouble(txt_a.getText()),
                Double.parseDouble(txt_b.getText())
        );

        tda_u4.trapezoidalLineal();

        lable_resultado.setText("Resultados: Regla de Trapezoidal Lineal");

        txt_area_salidas_principales.setText(
                "Salidas Principales--------------------------|  \n"+
                        "Integrando Númerico = "+tda_u4.INTEGRANDO_LINEAL+"\n"+
                        "Ea = "+tda_u4.EALINEAL+"\n"+
                        "Integrando Análitico = "+tda_u4.VALOR_VERDADERO+"\n"+
                        "Et = "+tda_u4.ERROR_LINEAL+"%"+"\n"
        );

        txt_area_salidas_secundarias.setText("Salidas Secundarias--------------------------|  \n"+
                "F(a) = "+tda_u4.FUNCION_A+"\n"+
                "F(b) = "+tda_u4.FUNCION_B+"\n"+
                "FEpcilon = "+tda_u4.FEPCILON
        );
    }//unidad_4

    private void rtl_M(){
        tda_u4 = new TDA_U4(
                Double.parseDouble(txt_c.getText()),
                Double.parseDouble(txt_x.getText()),
                Double.parseDouble(txt_x2.getText()),
                Double.parseDouble(txt_x3.getText()),
                Double.parseDouble(txt_x4.getText()),
                Double.parseDouble(txt_x5.getText()),
                Double.parseDouble(txt_a.getText()),
                Double.parseDouble(txt_b.getText())
        );

        tda_u4.trapezoidal_Multiple(Integer.parseInt(txt_Segmentos.getText()));

        lable_resultado.setText("Resultados: Regla de Trapezoidal Lineal");

        txt_area_salidas_principales.setText(
                        "Salidas Principales--------------------------|  \n"+
                        "Integrando Númerico = "+tda_u4.INTEGRANDO_LINEAL_MUTIPLE+"\n"+
                        "Ea = "+tda_u4.EALINEAL_MULTIPLE+"\n"+
                        "Integrando Análitico = "+tda_u4.VALOR_VERDADERO+"\n"+
                        "Et = "+tda_u4.ET_LINEAL_MULTIPLE+"%"+"\n"
        );

        txt_area_salidas_secundarias.setText("Salidas Secundarias--------------------------|  \n"+
                "n = "+tda_u4.numero_segmentos+"\n"+
                "h = "+tda_u4.h+"\n"+
                "FEpcilon = "+tda_u4.FEPCILON
        );
    }//rtl_M

    private void r_simpson_1_3(){
        tda_u4 = new TDA_U4(
                Double.parseDouble(txt_c.getText()),
                Double.parseDouble(txt_x.getText()),
                Double.parseDouble(txt_x2.getText()),
                Double.parseDouble(txt_x3.getText()),
                Double.parseDouble(txt_x4.getText()),
                Double.parseDouble(txt_x5.getText()),
                Double.parseDouble(txt_a.getText()),
                Double.parseDouble(txt_b.getText())
        );

        tda_u4.reglaSimpson_1_3();

        lable_resultado.setText("Resultados: Regla de Simpson 1/3");

        txt_area_salidas_principales.setText(
                        "Salidas Principales--------------------------|  \n"+
                        "Integrando Númerico = "+tda_u4.INTEGRANDO_SIMPSON+"\n"+
                        "Ea = "+tda_u4.EA_SIMPSON+"\n"+
                        "Integrando Análitico = "+tda_u4.VALOR_VERDADERO+"\n"+
                        "Et = "+tda_u4.ERROR_SIMPSON_1_3+"%"+"\n"
        );

        txt_area_salidas_secundarias.setText("Salidas Secundarias--------------------------|  \n"+
                "n = "+tda_u4.numero_segmentos+"\n"+
                "h = "+tda_u4.h+"\n"+
                "F(x0) = "+tda_u4.FX0_SIMPSON_1_3+"\n"+
                "F(x1) = "+tda_u4.FX1_SIMPSON_1_3+"\n"+
                "F(x2) = "+tda_u4.FX2_SIMPSON_1_3+"\n"+
                "FEpcilon 4ta = "+tda_u4.FEPCILON_CUARTA
        );
    }//r_simpson_1_3

    private boolean esPar(int valor){
        if(valor%2==0) return true;
        return false;
    }//esPar

    private void r_simpson_1_3_multiple(){
        if(!esPar(Integer.parseInt(txt_Segmentos.getText()))){
            JOptionPane.showMessageDialog(null,"No es Par");
        }
        tda_u4 = new TDA_U4(
                Double.parseDouble(txt_c.getText()),
                Double.parseDouble(txt_x.getText()),
                Double.parseDouble(txt_x2.getText()),
                Double.parseDouble(txt_x3.getText()),
                Double.parseDouble(txt_x4.getText()),
                Double.parseDouble(txt_x5.getText()),
                Double.parseDouble(txt_a.getText()),
                Double.parseDouble(txt_b.getText())
        );

            tda_u4.simpsonMultiple_1_3(Integer.parseInt(txt_Segmentos.getText()));

            lable_resultado.setText("Resultados: Regla de Simpson 1/3 Multiple");


            txt_area_salidas_principales.setText(
                    "Salidas Principales--------------------------|  \n" +
                            "Integrando Númerico = " + tda_u4.INTEGRANDO_SIMPSON_MULTIPLE_1_3 + "\n" +
                            "Ea = " + tda_u4.EA_SIMPSON_MULTIPLE_1_3 + "\n" +
                            "Integrando Análitico = " + tda_u4.VALOR_VERDADERO + "\n" +
                            "Et = " + tda_u4.ET_SIMPSON_MULTIPLE_1_3 + "%" + "\n"
            );

            txt_area_salidas_secundarias.setText("Salidas Secundarias--------------------------|  \n" +
                    "n = " + tda_u4.numero_segmentos + "\n" +
                    "h = " + tda_u4.h + "\n" +
                    "FEpcilon 4ta = " + tda_u4.FEPCILON_CUARTA
            );
         }//r_simpson_1_3_multiple

    public static void main(String[] args) {
        launch(args);
    }//main

}//class
