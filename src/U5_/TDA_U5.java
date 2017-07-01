package U5_;

public class TDA_U5{

    Double c,x,x2,x3=0.0;
    Double X,X0,X1,X2=0.0;
    Double VALOR_VERDADERO,FX0,FX1,FX2=0.0;

    public void iniciarLineal(Double c, Double x, Double x2, Double x3, Double X, Double X0, Double X1){
        this.c=c;
        this.x=x;
        this.x2=x2;
        this.x3=x3;
        this.X=X;
        this.X0=X0;
        this.X1=X1;
        iniciarLineal();
    }//Constructor

    public void iniciarLinealDiscreto(Double x,Double x0,Double fx0,Double x1,Double fx1){
        this.X=x;
        this.X0=x0;
        this.X1=x1;
        this.FX0=fx0;
        this.FX1=fx1;
        linealDiscretoNewton();
        linealLagranjeDiscreto();
    }

    public void iniciarCuadraticoDiscreto(Double x,Double x0,Double fx0,Double x1,Double fx1,Double x2,Double fx2){
        this.X=x;
        this.X0=x0;
        this.X1=x1;
        this.X2=x2;
        this.FX0=fx0;
        this.FX1=fx1;
        this.FX2=fx2;
        linealDiscretoNewton();
        linealLagranjeDiscreto();
        cuadraticaDiscretoNewton();
        cuadraticaDiscretoLagranje();
    }

    public void iniciarCuadratico(Double c, Double x, Double x2, Double x3, Double X, Double X0, Double X1, Double X2){
        this.c=c;
        this.x=x;
        this.x2=x2;
        this.x3=x3;
        this.X=X;
        this.X0=X0;
        this.X1=X1;
        this.X2=X2;
        iniciarCuadratico();
    }//Constructor


    public TDA_U5(){

    }

    private void iniciarLineal(){
        VALOR_VERDADERO=evaluarPolinomio(X);
        FX0=evaluarPolinomio(X0);
        FX1=evaluarPolinomio(X1);
        linealNewton();
        linealLagranje();
    }//iniciar

    private void iniciarCuadratico(){
        VALOR_VERDADERO=evaluarPolinomio(X);
        FX0=evaluarPolinomio(X0);
        FX1=evaluarPolinomio(X1);
        FX2=evaluarPolinomio(X2);
        linealNewton();
        linealLagranje();
        cuadraticaNewton();
        cuadraticaLagranje();
    }//iniciar

    private Double evaluarPolinomio(Double valor){
        Double e=this.c+this.x*valor+this.x2*(Math.pow(valor,2))+this.x3*(Math.pow(valor,3));
        return e;
    }//evaluarFuncion

    private Double eTrue(Double integrando){
        Double error_verdadero=Math.abs((VALOR_VERDADERO-integrando)/VALOR_VERDADERO)*100;
        return error_verdadero;
    }//eTrue

    /*--------------------------Lineal de Newton-----------------------------------------*/
    Double FX1_NEWTON,ERROR_LINEAL_NEWTON=0.0;

    private void linealNewton(){
        FX1_NEWTON=FX0+((FX1-FX0)/(X1-X0))*(X-X0);
        ERROR_LINEAL_NEWTON=eTrue(FX1_NEWTON);
    }//lieanlNewton

    private void linealDiscretoNewton(){
        FX1_NEWTON=FX0+((FX1-FX0)/(X1-X0))*(X-X0);
    }

    Double FX2_NEWTON,a0,a1,a2,b0,b1,b2,ERROR_CUADRATICO_NEWTON=0.0;

    private void cuadraticaNewton(){
        b0=FX0;
        b1=((FX1-FX0)/(X1-X0));
        b2=((((FX2-FX1)/(X2-X1))-((FX1-FX0)/(X1-X0)))/(X2-X0));
        a0=b0-b1*X0+b2*X0*X1;
        a1=b1-b2*X0-b2*X1;
        a2=b2;
        FX2_NEWTON=a0+a1*X+a2*X*X;
        ERROR_CUADRATICO_NEWTON=eTrue(FX2_NEWTON);
    }//cuadraticaNewton

    private void cuadraticaDiscretoNewton(){
        b0=FX0;
        b1=((FX1-FX0)/(X1-X0));
        b2=((((FX2-FX1)/(X2-X1))-((FX1-FX0)/(X1-X0)))/(X2-X0));
        a0=b0-b1*X0+b2*X0*X1;
        a1=b1-b2*X0-b2*X1;
        a2=b2;
        FX2_NEWTON=a0+a1*X+a2*X*X;
    }

    /*-------------------------------------LaGranje-----------------------------------*/

    Double FX1_LAGRANJE,ERROR_LINEAL_LAGRANJE=0.0;

    private void linealLagranje(){
        FX1_LAGRANJE=((X-X1)/(X0-X1))*FX0+((X-X0)/(X1-X0))*FX1;
        ERROR_LINEAL_LAGRANJE=eTrue(FX1_LAGRANJE);
    }//linealLagranje

    private void linealLagranjeDiscreto(){
        FX1_LAGRANJE=((X-X1)/(X0-X1))*FX0+((X-X0)/(X1-X0))*FX1;
    }

    Double FX2_LAGRANJE,ERROR_CUADRATICO_LAGRANJE=0.0;

    private void cuadraticaLagranje(){
        FX2_LAGRANJE=((((X-X1)*(X-X2))/((X0-X1)*(X0-X2)))*FX0)+
                     ((((X-X0)*(X-X2))/((X1-X0)*(X1-X2)))*FX1)+
                     (((X-X0)*(X-X1))/((X2-X0)*(X2-X1))*FX2);
        ERROR_CUADRATICO_LAGRANJE=eTrue(FX2_LAGRANJE);
    }//cuadraticaLagranje

    private void cuadraticaDiscretoLagranje(){
        FX2_LAGRANJE=((((X-X1)*(X-X2))/((X0-X1)*(X0-X2)))*FX0)+
                ((((X-X0)*(X-X2))/((X1-X0)*(X1-X2)))*FX1)+
                (((X-X0)*(X-X1))/((X2-X0)*(X2-X1))*FX2);
    }
}//Class