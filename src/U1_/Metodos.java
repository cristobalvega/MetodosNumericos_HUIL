package U1_;

public class Metodos{

        String cadT="",cad="";
        int con1=2,con2=1;
        double actTemp=0,antTemp=0,pi=2;
        double vec[];

    public void reiniciar(double v[]){
        cad="No.\tEt\tEa\n";
        cadT="Orden\tTermino            \t\tSumatoria\t\tError\n";
        con2=1;
        actTemp=antTemp=0;pi=con1=2;
        vec=v;
    }

    public double significativa(int n){
        return .5*Math.pow(10,(2-n));
    }

    public double fact(double n){
        if(n==0)return 1;
        else
            return n*fact(n-1);
    }

    public double Et(double Vv,double AAct){
        return Math.abs((Vv-AAct)/Vv)*100;
    }

    public double Ea(int it,double AAct, double AAnt){
        if(it==0)return 0;
        return Math.abs((AAct-AAnt)/AAct)*100;
    }

    public boolean Aprobado(int n,double Es,double Ea){
        if (n==0) return false;
        return Ea<Es;
    }

    public double valVer(int num,double x){
        switch(num){
            case 1:
                return Math.exp(x);
            case 2:
                return Math.exp(-x);
            case 3:
                return Math.exp(-x);
            case 4:
                return 1/(1-x);
            case 5:
                return Math.PI;
            case 6:
                return (Math.PI)/4;
            case 7:
                return Math.log(x+1);
            case 8:
                return Math.sin(x);
            case 9:
                return Math.cos(x);
            case 10:
                return Math.atan(x);
            case 11:
                return Math.sinh(x);
            case 12:
                return Math.cosh(x);
            case 13:
                return Math.PI;
        }
        return 0;
    }

    public double op(int num,double Aant,double x, int it,double den){
        switch(num){
            case 1:
                return opEj1(Aant,x, it);
            case 2:
                return opEj2(Aant,x, it);
            case 3:
                return opEj3(Aant,x, it);
            case 4:
                return opEj4(Aant,x, it);
            case 5:
                return opEj5(Aant,x, it,den);
            case 6:
                return opEj6(Aant,x, it,den);
            case 7:
                return opEj7(Aant,x, it);
            case 8:
                return opEj8(Aant,x, it,den);
            case 9:
                return opEj9(Aant,x, it);
            case 10:
                return opEj10(Aant,x, it,den);
            case 11:
                return opEj11(Aant,x, it,den);
            case 12:
                return opEj12(Aant,x, it);
            case 13:
                return opEj13(Aant, it);
        }
        return 0;
    }

    public double opEj1(double Aant,double x, int it){
        return Aant+(Math.pow(x, it))/fact(it);
    }

    public double opEj2(double Aant,double x, int it){
        antTemp=actTemp;
        actTemp=opEj1(antTemp,x,it);
        return 1/actTemp;
    }
    public double opEj3(double Aant,double x, int it){
        if(it==0)return 1;
        if(it%2==0)return Aant+(Math.pow(x, it))/fact(it);
        return Aant-(Math.pow(x, it))/fact(it);
    }
    public double opEj4(double Aant,double x, int it){
        return Aant+(Math.pow(x, it));
    }
    public double opEj5(double Aant,double x, int it,double den){
        if(it==0)return 4;
        if(it%2==0)return Aant+(4/den);
        return Aant-(4/den);
    }
    public double opEj6(double Aant,double x, int it,double den){
        if(it==0)return 1;
        if(it%2==0)return Aant+(1/den);
        return Aant-(1/den);
    }
    public double opEj7(double Aant,double x, int it){
        it++;
        if(it==1)return x;
        if(it%2!=0)return Aant+(Math.pow(x, it))/it;        
        return Aant-(Math.pow(x, it))/it;
    }
    public double opEj8(double Aant,double x, int it,double den){
        it++;
        if(it==1)return x;
        if(it%2!=0)return Aant+(double)(Math.pow(x, den))/fact(den);
        return Aant-(double)(Math.pow(x, den))/fact(den);
    }
    public double opEj9(double Aant,double x, int it){
        it++;
        if(it==1)return 1;
        if(it%2!=0)return Aant+(Math.pow(x, (it-1)*2))/fact((it-1)*2);
        return Aant-(Math.pow(x, (it-1)*2))/fact((it-1)*2);
    }
    public double opEj10(double Aant,double x, int it,double den){
        it++;
        if(it==1)return x;
        if(it%2!=0)return Aant+(double)(Math.pow(x, den))/(den);
        return Aant-(double)(Math.pow(x, den))/(den);
    }
    public double opEj11(double Aant,double x, int it,double den){
        it++;
        if(it==1)return x;
        return Aant+(double)(Math.pow(x, den))/fact(den);
    }
    public double opEj12(double Aant,double x, int it){
        it++;
        if(it==1)return 1;
        return Aant+(Math.pow(x, (it-1)*2))/fact((it-1)*2);
    }
    public double opEj13(double Aant, int it){
        return pi*=(con1/(double)con2);
        
    }
    public String ejX(int num,int n,double x){
        double Es=significativa(n), Vv=valVer(num,x);
        int it=0;
        double Aact=0,Aant=0,den=1;
        while(!Aprobado(it,Es,Ea(it,Aact,Aant))){
            Aant=Aact;
            Aact=op(num,Aant,x, it,den);
            cad+=(it+1)+"\t"+Aact+"\t\t"+Et(Vv,Aact)+"\t\t"+Ea(it,Aact,Aant)+"\n";
            den=den+2;
            if(it%2==0)con2+=2;
             else con1+=2;
            it++;
        }
        return cad;
    }

    //determinar grado
    public int grad(double vec[]){
        int grado=0;
        if(vec[7]!=0)return 7;
        for(int i=0;i<=7;i++){
            if(vec[i]!=0&&vec[i+1]==0){
                grado=i;
            }
        }
        return grado;
    }

//derivar
    public void corr(double vec[],int grad){
        for(int i=0;i<=6;i++){
            vec[i]=vec[i+1]*(i+1);
        }
        vec[grad]=0;
    }
    
        public String derivada(String trig) {
        switch(trig){
            case "sen":
                return "cos";
            case "cos":
                return "-sen";
            case "-sen":
                return "-cos";
            case "-cos":
                return "sen";
        }
        return "";
    }
    
    public double calcTrig(String trig, double x) {
        
        switch(trig){
            case "sen":
                return Math.sin(x);
            case "cos":
                return Math.cos(x);
            case "-sen":
                return -Math.sin(x);
            case "-cos":
                return -Math.cos(x);
        }
        return 0;
    }

    public Double Tay1(double vec[],double x1,double x2,int it, int grad){
        //poli
        double h=x2-x1;
        double val=0;
        for(int i=0;i<=7;i++){
            val+=(vec[i]*Math.pow(x1,i));
        }
        val*=(Math.pow(h, it)/fact(it));
        actTemp+=val;
        corr(vec,grad);
        return val;
    }
    public String TaylorLn(double x, double x2, int n) {
        double Vv = Math.log(x2);
        double suma = 0;
        double Es = significativa(n);
        double h = x2 - x;
        int it = 0;
        double Aact = 0, Aant = 0;
        while (Et(Vv, suma) > Es) {
            if (it == 0) {
                Aant = Aact;
                Aact = (Math.log(x) / fact(it)) * Math.pow(h, it);
                suma += Aact;
                cadT += (it + 1) + "\t" + Aact + "\t\t" + suma + "\t\t" + Et(Vv, suma) + "\n";
                it++;
            } else {
                Aant = Aact;
                Aact = ((Math.pow(-1, it - 1) * (fact(it - 1) / Math.pow(x, it))) / fact(it)) * Math.pow(h, it);
                suma += Aact;
                cadT += (it + 1) + "\t" + Aact + "\t\t" + suma + "\t\t" + Et(Vv, suma) + "\n";
                it++;
            }
        }
        return cadT;
    }
    public String TaylorSC(double x1, double x2, int n, String trig) {
        double Vv = calcTrig(trig, x2);
        double h = x2 - x1;
        double suma = 0;
        int it = 0;
        double Aact = 0, Aant = 0;
        double Es = significativa(n);
        while (Et(Vv, suma) > Es) {
            Aant = Aact;
            Aact = ((calcTrig(trig, x1)) / fact(it)) * Math.pow(h, it);
            suma += Aact;
            cadT += (it + 1) + "\t" + Aact + "\t\t" + suma + "\t\t" + Et(Vv, suma) + "\n";
            trig = derivada(trig);
            it++;
        }
        return cadT;
    }
    
    public String TaylorPoli(double x1,double x2){
        int it=0,tope=grad(vec);
        double Aact=0,Aant=0;
        while(it<=tope){
            Aant=Aact;
            Aact=Tay1(vec,x1,x2,it,grad(vec));
            cadT+=it+"\t"+Aact+"\t\t"+actTemp+"\t\t"+Ea(it,Aact,Aant)+"\n";
            it++;
        }
        return cadT;
    }
    
}