package U1_;

import javax.swing.*;

/**
 * Este código fue creado por Miguel Cervantes.
 * Este TDA contiene el algoritmo general para cada función.
 */

//Se debe de llamar TDA_U1 <-----
public class Metodos13Funciones {
    double N[],error_a[];

    public Metodos13Funciones(int n){
        N=new double[n];
    }

    public int factorial(int n){
        if(n==0){
            return 1;
        }
        return n*factorial(n-1);
    }

    public double[] algoritmo1(int nIteraciones,double valorX){
        double n=0;
        for(int i=0;i<nIteraciones;i++){
            N[i]=(Math.pow(valorX,i)/(double)factorial(i))+n;
            n=N[i];
        }
        //JOptionPane.showMessageDialog(null,"Hola"+N);
        return N;
    }

    public double[] algoritmo2(int nIteraciones,double valorX){
        double n=0,c;
        for(int i=0;i<nIteraciones;i++){
            c=((double)Math.pow(valorX,i)/(double)factorial(i))+n;
            N[i]=1/c;
            n=c;
        }
        return N;
    }

    public double[] algoritmo3(int nIteraciones,double valorX){
        double n=0;
        for(int i=0;i<nIteraciones;i++){
            if(i%2==0){
                N[i]=((double)Math.pow(valorX,i)/(double)factorial(i))+n;
            }else{
                N[i]=(-1)*((double)Math.pow(valorX,i)/(double)factorial(i))+n;
            }
            n=N[i];
        }
        return N;
    }

    public double[] algoritmo4(int nIteraciones,double valorX){
        double n=0;
        for(int i=0;i<nIteraciones;i++){
            N[i]=Math.pow(valorX,i)+n;
            n=N[i];
        }
        return N;
    }

    public double[] algoritmo5(int nIteraciones){
        double n=0,d=1;
        for(int i=0;i<nIteraciones;i++){
            if(i%2==0){
                N[i]=4/(d)+n;
            }else{
                N[i]=(-1)*(4/(d))+n;
            }
            n=N[i];
            d+=2;
        }
        return N;
    }

    public double[] algoritmo6(int nIteraciones){
        double n=0,d=1;
        for(int i=0;i<nIteraciones;i++){
            if(i%2==0){
                N[i]=1/(d)+n;
            }else{
                N[i]=(-1)*(1/(d))+n;
            }
            n=N[i];
            d+=2;
        }
        return N;
    }

    public double[] algoritmo7(int nIteraciones,double valorX){
        double n=0;
        for(int i=0;i<nIteraciones;i++){
            if(i%2==0){
                N[i]=(Math.pow(valorX,i+1)/(i+1))+n;
            }else{
                N[i]=(-1)*(Math.pow(valorX,i+1)/(i+1))+n;
            }
            n=N[i];
        }
        return N;
    }

    public double[] algoritmo8(int nIteracion,double valorX){
        double n=0;
        int d=1;
        for(int i=0;i<nIteracion;i++){
            if(i%2==0){
                N[i]=(double)(Math.pow(valorX,d)/(double)factorial(d))+n;
            }else{
                N[i]=(-1)*(double)(Math.pow(valorX,d)/(double)factorial(d))+n;
            }
            n=N[i];
            d+=2;
        }
        return N;
    }

    public double[] algoritmo9(int nIteraciones,double valorX){
        double n=0;
        for(int i=0;i<nIteraciones;i++){
            if(i%2==0){
                N[i]=Math.pow(valorX,i*2)/factorial(i*2)+n;
            }else{
                N[i]=(-1)*Math.pow(valorX,i*2)/factorial(i*2)+n;
            }
            n=N[i];
        }
        return N;
    }

    public double[] algoritmo10(int nIteraciones,double valorX){
        double n=0,d=1;
        for(int i=0;i<nIteraciones;i++){
            if(i%2==0){
                N[i]=(Math.pow(valorX,d)/d)+n;
            }else{
                N[i]=(-1)*(Math.pow(valorX,d)/d)+n;
            }
            n=N[i];
            d+=2;
        }
        return N;
    }

    public double[] algoritmo11(int nIteracion,double valorX){
        double n=0;
        int d=1;
        for(int i=0;i<nIteracion;i++){
            N[i]=(double)(Math.pow(valorX,d)/(double)factorial(d))+n;
            n=N[i];
            d+=2;
        }
        return N;
    }

    public double[] algoritmo12(int nIteraciones,double valorX){
        double n=0;
        for(int i=0;i<nIteraciones;i++){
            N[i]=Math.pow(valorX,i*2)/factorial(i*2)+n;
            n=N[i];
        }
        return N;
    }

    public double[] algoritmo13(int nIteraciones){
        double a=0,c=1,n=0,d=1;
        for(int i=0;i<nIteraciones;i++){
            if(i%2==0){
                n+=2;
            }else{
                d+=2;
            }
            a=(n/d)*c;
            N[i]=2*a;
            c=a;
        }
        return N;
    }

    public String[] error_t(double arr[],double n){
        String err[];
        err=new String[arr.length];
        for(int i=0;i<arr.length;i++){
            err[i]=Math.abs((n-arr[i])/n)*100+"%";
        }
        return err;
    }

    public String[] error_a(double arr[]){
        String err[];
        err=new String[arr.length];
        error_a=new double[arr.length];
        for(int i=0;i<arr.length;i++){
            if(i==0){
                err[i]="-";
                error_a[i]=100;
            }else{
                err[i]=Math.abs((arr[i]-arr[i-1])/arr[i])*100+"%";
                error_a[i]=Math.abs((arr[i]-arr[i-1])/arr[i])*100;
            }
        }
        return err;
    }

    public String[] validar(int n){
        String val[]=new String[error_a.length];
        double num=0.5*Math.pow(10,2-n);
        for(int i=0;i<error_a.length;i++){
            if(num>Math.abs(error_a[i])){
                val[i]="Aceptado";
            }else{
                val[i]="No Aceptado";
            }
        }
        return val;
    }

    public String mostrar(double[] arr){
        String cad="";
        for(int i=0;i<arr.length;i++){
          //if(double[i]<=error){
            cad+="["+(i+1)+"] "+arr[i]+"\n";
          //}//if
        }//for
        return cad;
    }//Hola

    public String mostrarAceptacion(String[] arr){
        String cad="";
        for(int i=0;i<arr.length;i++){
            cad+=arr[i]+"\n";
        }
        return cad;
    }

    public String mostrarError(String[] arr){
        String cad="";
        for(int i=0;i<arr.length;i++){
            cad+="["+(i+1)+"] "+arr[i]+"\n";
        }
        return cad;
    }

    public double[] serieTaylor(double a,double b,double c,double d,double e,double x1, double x2){
        double h=x2-x1;
        double [] t= new double [5];
        t[0]=((a*Math.pow(x1,4))+(b*Math.pow(x1,3))+(c*Math.pow(x1,2))+(d*x1)+e);
        t[1]=t[0]+(((4*a*Math.pow(x1,3))+(3*b*Math.pow(x1,2))+(2*c*x1)+(d))*h);
        t[2]=t[1]+((((4*3*a*Math.pow(x1,2))+(3*2*b*x1)+(2*c))*Math.pow(h,2))/2);
        t[3]=t[2]+((((4*3*2*a*x1)+(3*2*b))*Math.pow(h,3))/6);
        t[4]=t[3]+((4*3*2*a)*(Math.pow(h,4))/24);
        return t;
    }

    public Double[] ErrorTaylor(Double[] s){
        Double [] t= new Double[5];
        t[0]=Math.abs((s[4]-s[0])/s[4]);
        t[1]=Math.abs((s[4]-s[1])/s[4]);
        t[2]=Math.abs((s[4]-s[2])/s[4]);
        t[3]=Math.abs((s[4]-s[3])/s[4]);
        t[4]=Math.abs((s[4]-s[4])/s[4]);
        return t;
    }


}
