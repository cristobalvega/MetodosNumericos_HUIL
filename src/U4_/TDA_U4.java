package U4_;

import com.sun.corba.se.spi.presentation.rmi.IDLNameTranslator;

public class TDA_U4{

    public Double c,x,x1,x2,x3,x4,x5,a,b,n,
            VALOR_VERDADERO,
            FEPCILON
            = 0.0;

    Double[] vectorX = new Double[6];
    Double[] vector_Primera_Derivada = new Double[5];
    Double[] vector_Segunda_Derivada = new Double[4];
    Double[] vector_Tercera_Derivada = new Double[3];
    Double[] vector_Cuarta_Derivada  = new Double[2];

    public TDA_U4(Double c,Double x1, Double x2, Double x3, Double x4, Double x5,Double a,Double b){
        this.c=c;
        this.x1=x1;
        this.x2=x2;
        this.x3=x3;
        this.x4=x4;
        this.x5=x5;
        this.a=a;
        this.b=b;
        iniciar();
    }//Constructor

    private void iniciar(){
        asignar_VectorX();
        derivarPrimera();
        derivarSegunda();
        derivarTercera();
        derivarCuarta();
        fEpcilon();
        fEpcilon_cuarta();
        valorVerdadero();
    }//iniciar

    private void asignar_VectorX(){
        vectorX[0]=this.c;
        vectorX[1]=this.x1;
        vectorX[2]=this.x2;
        vectorX[3]=this.x3;
        vectorX[4]=this.x4;
        vectorX[5]=this.x5;
    }//asignar_VectorX

    private void derivarPrimera(){
        vector_Primera_Derivada[0]=vectorX[1];
        vector_Primera_Derivada[1]=vectorX[2]*2;
        vector_Primera_Derivada[2]=vectorX[3]*3;
        vector_Primera_Derivada[3]=vectorX[4]*4;
        vector_Primera_Derivada[4]=vectorX[5]*5;
    }//derivarPrimera

    private void derivarSegunda(){
        vector_Segunda_Derivada[0]=vector_Primera_Derivada[1];
        vector_Segunda_Derivada[1]=vector_Primera_Derivada[2]*2;
        vector_Segunda_Derivada[2]=vector_Primera_Derivada[3]*3;
        vector_Segunda_Derivada[3]=vector_Primera_Derivada[4]*4;
    }//derivarSegunda

    private void derivarTercera(){
        vector_Tercera_Derivada[0]=vector_Segunda_Derivada[1];
        vector_Tercera_Derivada[1]=vector_Segunda_Derivada[2]*2;
        vector_Tercera_Derivada[2]=vector_Segunda_Derivada[3]*3;
    }//derivarTercera

    private void derivarCuarta(){
        vector_Cuarta_Derivada[0]=vector_Tercera_Derivada[1];
        vector_Cuarta_Derivada[1]=vector_Tercera_Derivada[2]*2;
    }//derivarCuarta

    private Double eTrue(Double integrando){
        Double error_verdadero=Math.abs((VALOR_VERDADERO-integrando)/VALOR_VERDADERO)*100;
        return error_verdadero;
    }//eTrue

    private Double evaluarPolinomio(Double valor){
        Double e=this.c+this.x1*valor+this.x2*(Math.pow(valor,2))+this.x3*(Math.pow(valor,3))+this.x4*(Math.pow(valor,4))+this.x5*(Math.pow(valor,5));
        return e;
    }//evaluarFuncion

    private Double funcionPrimitivaEpcilon(Double valor){
        Double e=vector_Primera_Derivada[1]*valor+vector_Primera_Derivada[2]*(Math.pow(valor,2))+
                vector_Primera_Derivada[3]*(Math.pow(valor,3))+vector_Primera_Derivada[4]*(Math.pow(valor,4));
        return e;
    }//evaluarFuncionPrimitiva

    private Double derivada(Double valor){
        Double d=vectorX[1]+(vectorX[2]*2*valor)+(vectorX[3]*3*Math.pow(valor,2))+((vectorX[4]*4*Math.pow(valor,3)));
        return d;
    }

    private Double funcionPrimitivaEpcilonCuarta(Double valor){
        Double e=vector_Cuarta_Derivada[0]*valor+((vector_Cuarta_Derivada[1]*Math.pow(valor,2))/2.0);
        return e;
    }//funcionPrimitivaEpcilonCuarta

    private Double funcionPrimitivaValorVerdadero(Double valor){
        Double e=vectorX[0]*valor+(vectorX[1]/2)*Math.pow(valor,2)+(vectorX[2]/3)*Math.pow(valor,3)+
                    (vectorX[3]/4)*Math.pow(valor,4)+(vectorX[4]/5)*Math.pow(valor,5)+(vectorX[5]/6)*Math.pow(valor,6);
        return e;
    }//evaluarFuncion_PrimitivaV

    private void fEpcilon(){
        //System.out.println("funcionPrimitivaEpcilon(this.b) = "+funcionPrimitivaEpcilon(this.b));
        //System.out.println("funcionPrimitivaEpcilon(this.a) = "+funcionPrimitivaEpcilon(this.a));
        FEPCILON=(funcionPrimitivaEpcilon(this.b)-funcionPrimitivaEpcilon(this.a))/(this.b-this.a);
    }//fEpcilon

    private void fEpcilon_cuarta(){
        System.out.println("vector_Cuarta_Derivada[0] = "+vector_Cuarta_Derivada[0]);
        System.out.println("vector_Cuarta_Derivada[1] = "+vector_Cuarta_Derivada[1]);
        System.out.println("funcionPrimitivaEpcilonCuarta(this.b) = "+funcionPrimitivaEpcilonCuarta(this.b));
        System.out.println("funcionPrimitivaEpcilonCuarta(this.a) = "+funcionPrimitivaEpcilonCuarta(this.a));
        FEPCILON_CUARTA=(funcionPrimitivaEpcilonCuarta(this.b)-funcionPrimitivaEpcilonCuarta(this.a))/(this.b-this.a);
    }//fEpcilon_cuarta

    private void valorVerdadero(){
        VALOR_VERDADERO=funcionPrimitivaValorVerdadero(this.b)-funcionPrimitivaValorVerdadero(this.a);;
    }//valorVerdadero

/*--------------------------------------------------Regla Trapezoidal Linea---------------------------------------------------------------*/

    Double  INTEGRANDO_LINEAL,
            EALINEAL,
            ERROR_LINEAL,
            FUNCION_A,
            FUNCION_B=0.0;

    public void trapezoidalLineal(){
        FUNCION_A=evaluarPolinomio(this.a);
        FUNCION_B=evaluarPolinomio(this.b);
        INTEGRANDO_LINEAL=((this.b-this.a)*((FUNCION_A+FUNCION_B)/2.0));
        ERROR_LINEAL=eTrue(INTEGRANDO_LINEAL);
        EALINEAL=((-1/12.0)*(FEPCILON)*(Math.pow(this.b-this.a,3)));
    }//trapezoidalLineal

    /*----------------------------------Regla Trapezoidal Multiple----------------------------------------------------*/

    int numero_segmentos;
    public void asignar_n(int n){
        this.numero_segmentos=n;
    }//asignar_n

    public void trapezoidal_Multiple(int n){
        asignar_n(n);
        numeroSegmentos();
        evaluarSegmentos();
        sumaFuncionesTrapezoidalesMultiples();
        inegrandoTrapezoidalMultiple();
        eaLinealMultiple();
        etLinealMultiple();
    }//trapezoidal_Multiple

    private void etLinealMultiple() {
        ET_LINEAL_MULTIPLE=eTrue(INTEGRANDO_LINEAL_MUTIPLE);
    }//etLinealMultiple

    Double INTEGRANDO_LINEAL_MUTIPLE,
            SUMA_FUNCIONES_TRAPEZOIDAL_MULTIPLE,
            EALINEAL_MULTIPLE,
            ET_LINEAL_MULTIPLE=0.0;

    private void inegrandoTrapezoidalMultiple(){
        INTEGRANDO_LINEAL_MUTIPLE=((this.b-this.a)*((SUMA_FUNCIONES_TRAPEZOIDAL_MULTIPLE)/(2.0*this.numero_segmentos)));
        //System.out.println("INTEGRANDO_LINEAL_MUTIPLE "+INTEGRANDO_LINEAL_MUTIPLE);
    }//inegrandoTrapezoidalMultiple

    private void eaLinealMultiple(){
        EALINEAL_MULTIPLE=(-1.0*(Math.pow(this.b-this.a,3))*FEPCILON)/(12.0*Math.pow(numero_segmentos,2));
        System.out.println("FEPCILON "+FEPCILON);
    }//eaLinealMultiple

    Double[] vector_Segmentos;
    Double[] vector_Segmentos_Evaluados;
    Double h=0.0;


    private void numeroSegmentos(){
        vector_Segmentos=new Double[numero_segmentos+1];
        h=((this.b-this.a)/numero_segmentos);
        //System.out.println("h="+h);
        vector_Segmentos[0]=this.a;
        for(int i=1;i<=numero_segmentos;i++){
            vector_Segmentos[i]=vector_Segmentos[i-1]+h;
            System.out.println("x"+i+" = "+vector_Segmentos[i]);
        }//for
    }//numeroSegmentos

    private void evaluarSegmentos(){
        System.out.println("No. Segmentos  "+numero_segmentos);
        vector_Segmentos_Evaluados = new Double[numero_segmentos+1];
        for(int i=0;i<=numero_segmentos;i++){
            vector_Segmentos_Evaluados[i]=evaluarPolinomio(vector_Segmentos[i]);
            //System.out.println("Fx ("+i+")="+vector_Segmentos_Evaluados[i]);
        }//for
    }//evaluarSegmentos

    private void sumaFuncionesTrapezoidalesMultiples(){
        Double suma_temporal=0.0;
        for(int i=1;i<numero_segmentos;i++) {
            suma_temporal=suma_temporal+ vector_Segmentos_Evaluados[i];
            //System.out.println("suma_temporal "+suma_temporal+ " Valor en i = "+i);
        }
        Double suma_temporalx2=(2.0*suma_temporal);
        SUMA_FUNCIONES_TRAPEZOIDAL_MULTIPLE=vector_Segmentos_Evaluados[0]+suma_temporalx2+vector_Segmentos_Evaluados[numero_segmentos];
        //System.out.println("vector_Segmentos_Evaluados[0]  "+vector_Segmentos_Evaluados[0]);
        //System.out.println("SUMA_FUNCIONES_TRAPEZOIDAL_MULTIPLE "+SUMA_FUNCIONES_TRAPEZOIDAL_MULTIPLE);
        //System.out.println("vector_Segmentos_Evaluados[numero_segmentos]  "+vector_Segmentos_Evaluados[numero_segmentos]);
    }//sumaFuncionesTrapezoidalesMultiples


    /*--------------------------------------------------Regla de Simpson 1/3------------------------------------------------------------------*/
    Double X0_SIMPSON,
            X1_SIMPSON,
            X2_SIMPSON,
            FX0_SIMPSON_1_3,
            FX1_SIMPSON_1_3,
            FX2_SIMPSON_1_3,
            INTEGRANDO_SIMPSON,
            FEPCILON_CUARTA,
            EA_SIMPSON,
            ERROR_SIMPSON_1_3=0.0;

    public void reglaSimpson_1_3(){
        asignar_valores_Simpson();
        integrandoSimson();
        eaSimson();
        etSimpson_1_3();
    }//reglaSimpson

    private void asignar_valores_Simpson(){
        X0_SIMPSON=this.a;
        X1_SIMPSON=(this.b+this.a)/2.0;
        X2_SIMPSON=this.b;
        FX0_SIMPSON_1_3=evaluarPolinomio(X0_SIMPSON);
        FX1_SIMPSON_1_3=evaluarPolinomio(X1_SIMPSON);
        FX2_SIMPSON_1_3=evaluarPolinomio(X2_SIMPSON);
        //System.out.println("X0_SIMPSON = "+X0_SIMPSON);
        //System.out.println("X1_SIMPSON = "+X1_SIMPSON);
        //System.out.println("X2_SIMPSON = "+X2_SIMPSON);
    }//asignar_valores_Simpson

    private void integrandoSimson(){
        INTEGRANDO_SIMPSON=(this.b-this.a)*((evaluarPolinomio(X0_SIMPSON)+(4.0*evaluarPolinomio(X1_SIMPSON))+evaluarPolinomio(X2_SIMPSON))/6.0);
        //System.out.println("evaluarPolinomio(X0_SIMPSON) = "+evaluarPolinomio(X0_SIMPSON));
        //System.out.println("evaluarPolinomio(X1_SIMPSON) = "+evaluarPolinomio(X1_SIMPSON));
        //System.out.println("evaluarPolinomio(X2_SIMPSON) = "+evaluarPolinomio(X2_SIMPSON));
    }//integrandoSimson

    private void etSimpson_1_3(){
        ERROR_SIMPSON_1_3=eTrue(INTEGRANDO_SIMPSON);
    }//etSimpson_1_3

    private void eaSimson(){
        EA_SIMPSON=((-1*(Math.pow(this.b-this.a,5)*FEPCILON_CUARTA))/2880.0);
        System.out.println("FEPCILON_CUARTA = "+FEPCILON_CUARTA);
    }//eaSimson

    /*---------------------------------------SIMPSON MULTIPLE 1_3----------------------------------------------------*/

    Double INTEGRANDO_SIMPSON_MULTIPLE_1_3,
            SUMA_IMPARES_MULTIPLE,
            SUMA_PARES_MULTIPLE,
            POS_1,
            POS_ULTIMA,
            EA_SIMPSON_MULTIPLE_1_3,
            ET_SIMPSON_MULTIPLE_1_3=0.0;

    private boolean esPar(int valor){
        if(valor%2==0) return true;
        return false;
    }//esPar

    public void simpsonMultiple_1_3(int n){
        if(esPar(n)){
            asignar_n(n);
            numeroSegmentos();
            evaluarSegmentos();
            sumaSimpson_1_3_Multiple();
            eaSimpson_1_3_multiple();

            INTEGRANDO_SIMPSON_MULTIPLE_1_3=(((this.b-this.a)*(POS_1+SUMA_IMPARES_MULTIPLE+SUMA_PARES_MULTIPLE+POS_ULTIMA))/(3.0*numero_segmentos));
            etSimpson_1_3_multiple();
            return;            
        }//if
        System.out.println("No es impar el número : "+numero_segmentos);
        return;
    }//simpsonMultiple



    private void etSimpson_1_3_multiple() {
        ET_SIMPSON_MULTIPLE_1_3=eTrue(INTEGRANDO_SIMPSON_MULTIPLE_1_3);
    }

    private void eaSimpson_1_3_multiple() {
        EA_SIMPSON_MULTIPLE_1_3=((-1*(Math.pow(this.b-this.a,5)*FEPCILON_CUARTA))/(180.0*Math.pow(numero_segmentos,4)));
    }//eaSimpson_1_3

    private void sumaSimpson_1_3_Multiple(){
        Double temporal_Impares=0.0;
        Double temporal_Pares=0.0;
        POS_1=vector_Segmentos_Evaluados[0];
        for(int i=1;i<=numero_segmentos-1;i++){
            if(esPar(i)){
                temporal_Pares+=vector_Segmentos_Evaluados[i];
            }//if Pares
            if(!esPar(i)){
                temporal_Impares+=vector_Segmentos_Evaluados[i];
            }//if Impares
        }//for
        SUMA_IMPARES_MULTIPLE=4.0*temporal_Impares;
        SUMA_PARES_MULTIPLE  =2.0*temporal_Pares;
        POS_ULTIMA=vector_Segmentos_Evaluados[numero_segmentos];
    }//sumaImparesMultiple

/*-------------------------------Regla Simpson 3/8------------------------------------------------*/

    Double INTEGRANDO_SIMPSON_3_8,
            X0_SIMPSON_3_8,
            X1_SIMPSON_3_8,
            X2_SIMPSON_3_8,
            X3_SIMPSON_3_8,
            FX0_SIMPSON_3_8,
            FX1_SIMPSON_3_8,
            FX2_SIMPSON_3_8,
            FX3_SIMPSON_3_8,
            EA_SIMPSON_3_8,
            ET_SIMPSON_3_8
            =0.0;

    public void simpson_3_8(){
        segmentosSimpson3_8();
        integrandoSimson_3_8();
        eaSimpson_3_8();
        etSimpson_3_8();
    }//simpson_3_8

    private void integrandoSimson_3_8(){
        INTEGRANDO_SIMPSON_3_8=((this.b-this.a)*(FX0_SIMPSON_3_8+3*FX1_SIMPSON_3_8+3*FX2_SIMPSON_3_8+FX3_SIMPSON_3_8)/8.0);
    }//integrandoSimpso_3_8

    Double H_SIMPSON_3_8=0.0;
    private void segmentosSimpson3_8(){
        H_SIMPSON_3_8=(this.b-this.a)/3.0;
        X0_SIMPSON_3_8=this.a;
        X1_SIMPSON_3_8=X0_SIMPSON_3_8+H_SIMPSON_3_8;
        X2_SIMPSON_3_8=X1_SIMPSON_3_8+H_SIMPSON_3_8;
        X3_SIMPSON_3_8=X2_SIMPSON_3_8+H_SIMPSON_3_8;
        FX0_SIMPSON_3_8=evaluarPolinomio(X0_SIMPSON_3_8);
        FX1_SIMPSON_3_8=evaluarPolinomio(X1_SIMPSON_3_8);
        FX2_SIMPSON_3_8=evaluarPolinomio(X2_SIMPSON_3_8);
        FX3_SIMPSON_3_8=evaluarPolinomio(X3_SIMPSON_3_8);
    }//segmentosSimpson3_8

    private void eaSimpson_3_8(){
        EA_SIMPSON_3_8=(((-1.0*(Math.pow((this.b-this.a),5)))*FEPCILON_CUARTA)/6480.0);
    }//eaSimpson_3_8

    private void etSimpson_3_8(){
        ET_SIMPSON_3_8=eTrue(INTEGRANDO_SIMPSON_3_8);
    }//etSimpson_3_8

    /*----------------------Diferenciacion Numerica---------------------------------------------*/

    Double  DIFERENCIAL_NUMERICO_xi,
            DIFERENCIAL_NUMERICO_xi_mas1,
            DIFERENCIAL_NUMERICO_xi_menos1,
            Xi,
            XiMENOS1,
            XiMAS1,
            F_Xi,
            FX_XiMENOS1,
            FX_XiMAS1,
            ET_Xi,
            ET_Xi_MAS1,
            ET_Xi_MENOS1,
            DERIVADAVERDADERA_Xi,
            DERIVADAVERDADERA_XiMAS1,
            DERIVADAVERDADERA_XiMENOS1
            =0.0;

    public void diferenciacionNumerica(Double x, Double h_derivada){

        Xi=x;
        XiMENOS1=x-h_derivada;
        XiMAS1=x+h_derivada;
        F_Xi=evaluarPolinomio(Xi);
        FX_XiMENOS1=evaluarPolinomio(XiMENOS1);
        FX_XiMAS1=evaluarPolinomio(XiMAS1);
        evaluarDerivada();
        DIFERENCIAL_NUMERICO_xi=(FX_XiMAS1-F_Xi)/(XiMAS1-Xi);
        DIFERENCIAL_NUMERICO_xi_menos1=(F_Xi-FX_XiMENOS1)/(Xi-XiMENOS1);
        DIFERENCIAL_NUMERICO_xi_mas1=(FX_XiMAS1-FX_XiMENOS1)/(XiMAS1-XiMENOS1);
        ET_Xi=Math.abs((DERIVADAVERDADERA_Xi-DIFERENCIAL_NUMERICO_xi)/DERIVADAVERDADERA_Xi)*100;
        ET_Xi_MAS1=Math.abs((DERIVADAVERDADERA_XiMAS1-DIFERENCIAL_NUMERICO_xi_mas1)/DERIVADAVERDADERA_XiMAS1)*100;
        ET_Xi_MENOS1=Math.abs((DERIVADAVERDADERA_XiMENOS1-DIFERENCIAL_NUMERICO_xi_menos1)/DERIVADAVERDADERA_XiMENOS1)*100;

    }//diferenciacionNumerica

    public void evaluarDerivada(){
        DERIVADAVERDADERA_Xi=derivada(Xi);
        DERIVADAVERDADERA_XiMAS1=derivada(Xi);
        DERIVADAVERDADERA_XiMENOS1=derivada(Xi);
    }


}//class