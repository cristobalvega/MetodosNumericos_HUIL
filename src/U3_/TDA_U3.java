import java.util.Arrays;

/**
 * Created by Cristobal on 29/10/2016.
 */
public class TDA_U3 {
   Double matriz[][] = new Double[3][4];
   Double matrizIteracion1[][] = new Double[3][4];
   Double matrizIteracion2[][] = new Double[3][4];
   Double matrizIteracion3[][];

   Double matrizSeidel[][]= new Double[100][2];

   Double vectorSeidelX1[] = new Double[100];
   Double vectorSeidelX2[] = new Double[100];
   Double vectorSeidelX3[] = new Double[100];

  /*public TDA_U3(
    int x11, int x12, int x13, int x14,
    int x21, int x22, int x23, int x24,
    int x31, int x32, int x33, int x34){
    matriz[][]={x11,x12,x13,x14,x21,x22,x23,x24,x31,x32,x33,x34};
  }//TDA_U3 Builder*/
  
   public TDA_U3(){
      matriz[0][0]=3.0;
      matriz[0][1]=2.0;
      matriz[0][2]=7.0;
      matriz[0][3]=6.0;
   
      matriz[1][0]=3.0;
      matriz[1][1]=4.0;
      matriz[1][2]=3.0;
      matriz[1][3]=7.0;
   
      matriz[2][0]=1.0;
      matriz[2][1]=2.0;
      matriz[2][2]=2.0;
      matriz[2][3]=-5.0;

      matrizSeidel[0][0]=0.0;
      matrizSeidel[1][0]=0.0;
      matrizSeidel[2][0]=0.0;
      /*
      vectorSeidelX1[0][0]=0.0;
      vectorSeidelX2[0][0]=0.0;
      vectorSeidelX3[0][0]=0.0;*/
    
   
   }

   /*
   public Double[][] calcularSeidel(Double[][] matriz){
      matriz=this.matriz;
      
      int x1Seidel=(matriz[0][3]-(matriz[0][1]*algo)-(matriz[0][2]*algo))/matriz[0][0];
      //int x2Seidel=(matriz[1][3]-(matriz[1][0]*algo)-(matriz[1][2]*algo))/matriz[1][1];
      //int x3Seidel=(matriz[2][3]-(matriz[2][0]*algo)-(matriz[2][1]*algo))/matriz[2][2];

      return vectorSeidelX1=calcularX1(matriz);
      //vectorSeidelX2=calcularX2(matriz);
      //vectorSeidelX3=calcularX3(matriz);
   }//calcularSeidel*/

  //---------------------------------Gaus Jordan------------------------------------ 
  //-----------------------------Primera Iteracion----------------------------------

   public Double[][] calcularPrimeraIteracionGJ(Double[][] matriz){
      matriz=this.matriz;
      matrizIteracion1=iteracion1(normalizarX11(matriz[0][0],matriz));
      return matrizIteracion1;
   }//calcularPrimeraIteraciónGJ

   private Double[][] normalizarX11(Double normaX, Double[][] matriz){
      matriz[0][0]=matriz[0][0]/normaX;
      matriz[0][1]=matriz[0][1]/normaX;
      matriz[0][2]=matriz[0][2]/normaX;
      matriz[0][3]=matriz[0][3]/normaX;
      return matriz;
   }//normalizarX11

   private Double[][] iteracion1(Double[][] matriz){
      Double pivoteC2=this.matriz[1][0]/this.matriz[0][0];
      matriz[1][0]=ePrima(this.matriz[1][0],pivoteC2);
      matriz[1][1]=fPrima(this.matriz[1][1],pivoteC2);
      matriz[1][2]=gPrima(this.matriz[1][2],pivoteC2);
      matriz[1][3]=hPrima(this.matriz[1][3],pivoteC2);
   
      Double pivoteC3=this.matriz[2][0]/this.matriz[0][0];
      matriz[2][0]=iPrima(this.matriz[2][0],pivoteC3);
      matriz[2][1]=jPrima(this.matriz[2][1],pivoteC3);
      matriz[2][2]=kPrima(this.matriz[2][2],pivoteC3);
      matriz[2][3]=lPrima(this.matriz[2][3],pivoteC3);
      return matriz;
   }//iteracion1

   private Double ePrima(Double x, Double pivote){
      Double resultado=x-pivote*this.matriz[0][0];
      return resultado;
   }//ePrima

   private Double fPrima(Double x, Double pivote){
      Double resultado=x-pivote*this.matriz[0][1];
      return resultado;
   }//fPrima

   private Double gPrima(Double x, Double pivote){
      Double resultado=x-pivote*this.matriz[0][2];
      return resultado;
   }//gPrima

   private Double hPrima(Double x, Double pivote){
      Double resultado=x-pivote*this.matriz[0][3];
      return resultado;
   }//hPrima

   private Double iPrima(Double x, Double pivote){
      Double resultado=x-pivote*this.matriz[0][0];
      return resultado;
   }//iPrima

   private Double jPrima(Double x, Double pivote){
      Double resultado=x-pivote*this.matriz[0][1];
      return resultado;
   }//jPrima

   private Double kPrima(Double x, Double pivote){
      Double resultado=x-pivote*this.matriz[0][2];
      return resultado;
   }//kPrima

   private Double lPrima(Double x, Double pivote){
      Double resultado=x-pivote*this.matriz[0][3];
      return resultado;
   }//lPrima

   //------------------------------------Segunda Iteracion--------------------------------------

   public Double[][] calcularSegundaIteracionGJ(Double[][] matriz){
      matriz=calcularPrimeraIteracionGJ(this.matriz);
      matrizIteracion2=iteracion2(normalizarX21(matriz[1][1],matriz));
      return matrizIteracion2;
      //return matriz;
   }//calcularPrimeraIteraciónGJ 

  private Double[][] normalizarX21(Double normaX, Double[][] matriz){
      matriz[1][0]=matriz[1][0]/normaX;
      matriz[1][1]=matriz[1][1]/normaX;
      matriz[1][2]=matriz[1][2]/normaX;
      matriz[1][3]=matriz[1][3]/normaX;
      return matriz;
   }//normalizarX21

   private Double[][] iteracion2(Double[][] matriz){
      Double pivoteC1=this.matrizIteracion1[0][1]/this.matrizIteracion1[1][1];
      matriz[0][1]=bBiPrima(this.matrizIteracion1[0][1],pivoteC1);
      matriz[0][2]=cBiPrima(this.matrizIteracion1[0][2],pivoteC1);
      matriz[0][3]=dBiPrima(this.matrizIteracion1[0][3],pivoteC1);

      Double pivoteC3=this.matrizIteracion1[2][1]/this.matrizIteracion1[1][1];
      matriz[2][1]=jBiPrima(this.matrizIteracion1[2][1],pivoteC3);
      matriz[2][2]=kBiPrima(this.matrizIteracion1[2][2],pivoteC3);
      matriz[2][3]=lBiPrima(this.matrizIteracion1[2][3],pivoteC3);

      return matriz;      
   }//iteracion2*/

   private Double bBiPrima(Double x, Double pivote){
     Double resultado=x-pivote*matrizIteracion1[1][1];
     return resultado;
   }//bBiPrima

  private Double cBiPrima(Double x, Double pivote){
     Double resultado=x-pivote*matrizIteracion1[1][2];
     return resultado;
   }//cBiPrima

  private Double dBiPrima(Double x, Double pivote){
     Double resultado=x-pivote*matrizIteracion1[1][3];
     return resultado;
   }//dBiPrima

  private Double jBiPrima(Double x, Double pivote){
     Double resultado=x-pivote*matrizIteracion1[1][1];
     return resultado;
   }//jBiPrima

  private Double kBiPrima(Double x, Double pivote){
     Double resultado=x-pivote*matrizIteracion1[1][2];
     return resultado;
   }//kBiPrima

  private Double lBiPrima(Double x, Double pivote){
     Double resultado=x-pivote*matrizIteracion1[1][3];
     return resultado;
   }//lBiPrima

   //------------------Mostrar Gaus - Jordan---------------------------------

   private void mostrarMatrizOriginal(Double[][] matriz){
    matriz=this.matriz;
      for (int i=0;i<3;i++) {
         for (int j=0;j<4;j++) {
            System.out.println("Matriz Original | Pos ["+i+"] ["+j+"]"+matriz[i][j]);
         }//for j
      }//for i
   }//mostrarMatrizOriginal

   private void mostrarIteracion1(Double[][] matriz){
      matriz=calcularPrimeraIteracionGJ(this.matriz);
      for (int i=0;i<3;i++) {
         for (int j=0;j<4;j++) {
            System.out.println("Primera Iteracion | Pos ["+i+"] ["+j+"]"+matriz[i][j]);
         }//for j
      }//for i
   }//mostrarIteracion1

  private void mostrarIteracion2(Double[][] matriz){
      matriz=calcularSegundaIteracionGJ(this.matriz);
      for (int i=0;i<3;i++) {
         for (int j=0;j<4;j++) {
            System.out.println("Segunda Iteracion | Pos ["+i+"] ["+j+"]"+matriz[i][j]);
         }//for j
      }//for i
   }//mostrarIteracion1
  
   public void mostrarGJ(){
      mostrarMatrizOriginal(this.matriz);
      mostrarIteracion1(this.matriz);
      mostrarIteracion2(matrizIteracion1);
   }//mostrar
  
   public static void main(String args[]){
      TDA_U3 tda = new TDA_U3();
      //tda.mostrarGJ();
       //tda.seidel_();
   }//main

    public void seidel_()
    {
        int iterations = 0;
        int n = matriz.length;
        double epsilon = 1e-15;
        double[] X = new double[n]; // Approximations
        double[] P = new double[n]; // Prev
        Arrays.fill(X, 0);

        while (true)
        {
            for (int i = 0; i < n; i++)
            {
                double sum = matriz[i][n]; // b_n

                for (int j = 0; j < n; j++)
                    if (j != i)
                        sum -= matriz[i][j] * X[j];

                // Update x_i to use in the next row calculation
                X[i] = 1/matriz[i][i] * sum;
            }

            //System.out.print("X_" + iterations + " = {");
            for (int i = 0; i < n; i++)
                System.out.print(X[i] + " ");
                System.out.println( P[0]+ "}");

            iterations++;
            if (iterations == 1)
                continue;

            boolean stop = true;
            for (int i = 0; i < n && stop; i++)
                if (Math.abs(X[i] - P[i]) > epsilon)
                    stop = false;

            if (stop || iterations == 100) break;
            P = X.clone();

        }//While

    }//Seidel

}//TDA_U3
