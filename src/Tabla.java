/**
 * Created by cristobalcompaqmini on 15/10/16.
 */
public class Tabla {

    Metodos13Funciones metodoTabla;

    private String fx,acepta,et,ea;

    public Tabla(){
        this.fx=null;
        this.et=null;
        this.ea=null;
        this.acepta=null;
    }//Builder

    /*
    Miguel dice:
    n=el tamaño del vector
    ni=Numero de Iteraciones
    nd=Valor de X
     */


    public Tabla(int numero, int numeroIteraciones, double valorX, int cifras){
        metodoTabla = new Metodos13Funciones(100);
        if(numero==1) {
            this.fx=algoritmo1E(numeroIteraciones,valorX);
            this.et=errorVerdadero(metodoTabla.algoritmo1(numeroIteraciones,valorX),Math.exp(valorX));
            this.ea=errorAproximado(metodoTabla.algoritmo1(numeroIteraciones,valorX));
            this.acepta=aceptar(cifras);
        }//Condición If para el primer algoritmo1

        if(numero==2){
            this.fx=algoritmo2(numeroIteraciones,valorX);
            this.et=errorVerdadero(metodoTabla.algoritmo2(numeroIteraciones,valorX),1/(Math.exp(valorX)));
            this.ea=errorAproximado(metodoTabla.algoritmo2(numeroIteraciones,valorX));
            this.acepta=aceptar(cifras);
        }//Condición If para el primer algoritmo2


        if(numero==3){
            this.fx=algoritmo3E(numeroIteraciones,valorX);
            this.et=errorVerdadero(metodoTabla.algoritmo3(numeroIteraciones,valorX),(1/(Math.exp(valorX))));
            this.ea=errorAproximado(metodoTabla.algoritmo3(numeroIteraciones,valorX));
            this.acepta=aceptar(cifras);
        }//Condición If para el primer algoritmo3


        if(numero==4){
            this.fx=algoritmo4(numeroIteraciones,valorX);
            this.et=errorVerdadero(metodoTabla.algoritmo4(numeroIteraciones,valorX),1/(1-valorX));
            this.ea=errorAproximado(metodoTabla.algoritmo4(numeroIteraciones,valorX));
            this.acepta=aceptar(cifras);
        }//Condición If para el primer algoritmo4


        if(numero==5){
            this.fx=algoritmo5(numeroIteraciones);
            this.et=errorVerdadero(metodoTabla.algoritmo5(numeroIteraciones),Math.PI);
            this.ea=errorAproximado(metodoTabla.algoritmo5(numeroIteraciones));
            this.acepta=aceptar(cifras);
        }//Condición If para el primer algoritmo5


        if(numero==6){
            this.fx=algoritmo6(numeroIteraciones);
            this.et=errorVerdadero(metodoTabla.algoritmo6(numeroIteraciones),(Math.PI)/4);
            this.ea=errorAproximado(metodoTabla.algoritmo6(numeroIteraciones));
            this.acepta=aceptar(cifras);
        }//Condición If para el primer algoritmo6


        if(numero==7){
            this.fx=algoritmo7(numeroIteraciones,valorX);
            this.et=errorVerdadero(metodoTabla.algoritmo7(numeroIteraciones,valorX),Math.log(valorX+1));
            this.ea=errorAproximado(metodoTabla.algoritmo7(numeroIteraciones,valorX));
            this.acepta=aceptar(cifras);
        }//Condición If para el primer algoritmo7


        if(numero==8){
            this.fx=algoritmo8(numeroIteraciones,valorX);
            this.et=errorVerdadero(metodoTabla.algoritmo8(numeroIteraciones,valorX),Math.sin(valorX));
            this.ea=errorAproximado(metodoTabla.algoritmo8(numeroIteraciones,valorX));
            this.acepta=aceptar(cifras);
        }//Condición If para el primer algoritmo8


        if(numero==9){
            this.fx=algoritmo9(numeroIteraciones,valorX);
            this.et=errorVerdadero(metodoTabla.algoritmo9(numeroIteraciones,valorX),Math.cos(valorX));
            this.ea=errorAproximado(metodoTabla.algoritmo9(numeroIteraciones,valorX));
            this.acepta=aceptar(cifras);
        }//Condición If para el primer algoritmo9


        if(numero==10){
            this.fx=algoritmo10(numeroIteraciones,valorX);
            this.et=errorVerdadero(metodoTabla.algoritmo10(numeroIteraciones,valorX),Math.atan(valorX));
            this.ea=errorAproximado(metodoTabla.algoritmo10(numeroIteraciones,valorX));
            this.acepta=aceptar(cifras);
        }//Condición If para el primer algoritmo10


        if(numero==11){
            this.fx=algoritmo11(numeroIteraciones,valorX);
            this.et=errorVerdadero(metodoTabla.algoritmo11(numeroIteraciones,valorX),Math.sinh(valorX));
            this.ea=errorAproximado(metodoTabla.algoritmo11(numeroIteraciones,valorX));
            this.acepta=aceptar(cifras);
        }//Condición If para el primer algoritmo11


        if(numero==12){
            this.fx=algoritmo12(numeroIteraciones,valorX);
            this.et=errorVerdadero(metodoTabla.algoritmo12(numeroIteraciones,valorX),Math.cosh(valorX));
            this.ea=errorAproximado(metodoTabla.algoritmo12(numeroIteraciones,valorX));
            this.acepta=aceptar(cifras);
        }//Condición If para el primer algoritmo12


        if(numero==13){
            this.fx=algoritmo13(numeroIteraciones);
            this.et=errorVerdadero(metodoTabla.algoritmo13(numeroIteraciones),Math.PI);
            this.ea=errorAproximado(metodoTabla.algoritmo13(numeroIteraciones));
            this.acepta=aceptar(cifras);
        }//Condición If para el primer algoritmo13

    }//Builder

    private String algoritmo1E(int numeroIteraciones,double valorX ){
       /*double [] vectorResultadoNormal= new double[100];
        double [] vectorResultadoBien  = new double[numeroIteraciones];
        vectorResultadoNormal=metodoTabla.algoritmo1(numeroIteraciones,valorX);

        for(int i=0;i<vectorResultadoNormal.length-1;i++){

            if(vectorResultadoNormal[i]<Math.exp(valorX)){
                vectorResultadoBien[i]=vectorResultadoNormal[i];
            }//if
        }//for*/
        return this.fx=metodoTabla.mostrar(metodoTabla.algoritmo1(numeroIteraciones,valorX));
    }//algoritmo1E

    private String algoritmo2(int numeroIteraciones,double valorX){return this.fx=metodoTabla.mostrar(metodoTabla.algoritmo2(numeroIteraciones,valorX));}//algoritmo2E

    private String algoritmo3E(int  numeroIteraciones,double valorX){return this.fx=metodoTabla.mostrar(metodoTabla.algoritmo3( numeroIteraciones,valorX));}////Algoritmo3

    private String algoritmo4(int  numeroIteraciones,double valorX){return this.fx=metodoTabla.mostrar(metodoTabla.algoritmo4( numeroIteraciones,valorX));}//Algoritmo4

    private String algoritmo5(int  numeroIteraciones){return this.fx=metodoTabla.mostrar(metodoTabla.algoritmo5(numeroIteraciones));}//Algoritmo5

    private String algoritmo6(int  numeroIteraciones){return this.fx=metodoTabla.mostrar(metodoTabla.algoritmo6( numeroIteraciones));}//Algoritmo6

    private String algoritmo7(int  numeroIteraciones, double valorX){return this.fx=metodoTabla.mostrar(metodoTabla.algoritmo7(numeroIteraciones,valorX));}//Algoritmo7

    private String algoritmo8(int  numeroIteraciones, double valorX){return this.fx=metodoTabla.mostrar(metodoTabla.algoritmo8(numeroIteraciones,valorX));}//Algoritmo8

    private String algoritmo9(int  numeroIteraciones,double valorX){return this.fx=metodoTabla.mostrar(metodoTabla.algoritmo9( numeroIteraciones, valorX));}//Algoritmo9

    private String algoritmo10(int  numeroIteraciones, double valorX){return this.fx=metodoTabla.mostrar(metodoTabla.algoritmo10( numeroIteraciones, valorX));}//Algoritmo10

    private String algoritmo11(int  numeroIteraciones, double valorX){return this.fx=metodoTabla.mostrar(metodoTabla.algoritmo11( numeroIteraciones, valorX));}//Algoritmo11

    private String algoritmo12(int  numeroIteraciones, double valorX){return this.fx=metodoTabla.mostrar(metodoTabla.algoritmo12( numeroIteraciones, valorX));}//Algoritmo12

    private String algoritmo13(int  numeroIteraciones){return this.fx=metodoTabla.mostrar(metodoTabla.algoritmo13( numeroIteraciones));}//Algoritmo13

    private String errorVerdadero(double arr[],double n){return this.et=metodoTabla.mostrarError(metodoTabla.error_t(arr, n));}//Error Verdadero

    private String errorAproximado(double arr[]){return this.ea=metodoTabla.mostrarError(metodoTabla.error_a(arr));}//Error Aproximando

    private String aceptar(int n){return this.acepta=metodoTabla.mostrarAceptacion(metodoTabla.validar(n));}

    public String getFx() {
        return fx;
    }

    public void setFx(String fx) {
        this.fx = fx;
    }

    public String getEt() {
        return et;
    }

    public void setEt(String et) {
        this.et = et;
    }

    public String getEa() {
        return ea;
    }

    public void setEa(String ea) {
        this.ea = ea;
    }

    public String getAcepta() {
        return acepta;
    }

    public void setAcepta(String acepta) {
        this.acepta = acepta;
    }

}//Class
