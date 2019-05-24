
package Auxiliares;
/*
 *
 * @author Santiago Soto 219266
 */

public class Par {
   private int i;
   private int j;

    public Par(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
    
    @Override
    public boolean equals(Object obj){
       boolean ret=true;
        if(!(obj instanceof Par)){
            ret=false;
        }else{
          Par otroPar = (Par)obj;
            ret=(this.j==otroPar.getJ())&& this.i == otroPar.getI();
            
        }
        return ret;
    }
    
    public Par invertir(){
       int aux;
        aux=this.getI();
        this.setI(this.getJ());
        this.setJ(aux);
        return this;
    }

    @Override
    public String toString() {
        this.invertir();
        char a = (char)(this.getI()+'A');
        int b =  7-(this.getJ());
        this.invertir();
        return (a+""+""+b);
    }
    
    public int difI(Par otroPar){
        return Math.abs(this.getI()-otroPar.getI());
    }
    public int difJ(Par otroPar){
        return Math.abs(this.getJ()-otroPar.getJ());
    }
    public Par puntoMedio(Par otroPar){
        return new Par((this.getI()+otroPar.getI())/2, (this.getJ()+otroPar.getJ())/2);
    }
    public int distanciaEntreDosPuntos(Par otroPar){
        return (int)Math.hypot(this.getI()-otroPar.getI(), this.getJ()-otroPar.getJ());
    }
    public boolean equalAlguno(Par[] otros){
        boolean ret=false;
        for (int k = 0; k < otros.length; k++) {
            ret=this.equals(otros[k]);
            if(ret){
                break;
            }
        }
        return ret;
    }
    public boolean equalLista(Par[] otros){
        boolean ret=false;
        for (int k = 0; k < otros.length; k++) {
            ret=this.equals(otros[k]);
            if(ret){
                break;
            }
        }
        return ret;
    }
}
