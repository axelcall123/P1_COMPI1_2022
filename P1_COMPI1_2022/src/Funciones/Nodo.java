
package Funciones;

public class Nodo {
  Object info;
  Nodo sigL;
  Nodo antL;
  Nodo sigR;
  Nodo antR;
  private Nodo cabeza;

  public void insertarU(Object info, int posicionNodo) {
    Nodo nuevo = new Nodo();
    nuevo.info = info;
    if (cabeza == null) {
      Nodo hastac = new Nodo();
      hastac.info = "*";
      cabeza = nuevo;
      cabeza.sigR = hastac;
      hastac.antR = cabeza;
    } else {
      Nodo aux = new Nodo();
      aux = cabeza;
      if (info.toString().equals(".") | info.toString().equals("|")) {

        while (aux.antL != null) {
          aux = aux.sigL;
        }
        aux.sigL = nuevo;
        nuevo.antL = aux;
      } else {
        for (int i = 0; i < posicionNodo; i++) {
          aux = aux.sigL;
        }
        if (info.toString().equals("?")) {
          aux.sigR.info = "|";
          aux.sigR.antR = aux;

          aux.sigR.sigL = nuevo;
          aux.sigR.sigL.antR = aux.sigR;

          aux.sigR.sigR.info = "e";
          aux.sigR.sigR.antR = aux.sigR;

        } else if (info.toString().equals("+")) {
          aux.sigR.info = ".";
          aux.sigR.antR = aux;

          aux.sigR.sigL= nuevo;
          aux.sigR.sigL.antL=aux.sigR;

          aux.sigR.sigR.info="*";
          aux.sigR.sigR.antR=aux.sigR;

          aux.sigR.sigR.sigR=nuevo;
          aux.sigR.sigR.sigR.antR=aux.sigR.sigR;
        } else if (info.toString().equals("*")) {
          aux.sigR.info = "*";
          aux.sigR.antR = aux;

          aux.sigR.sigR = nuevo;
          aux.sigR.sigR.antR = aux.sigR;
        }
      }
    }
  }
  
  public void insertarD(Object infoU, Object infoD,Object infoT){
    Nodo nodoA= new Nodo();
    Nodo nodoB= new Nodo();
    nodoA.info=infoD;
    nodoB.info=infoT;
    if(cabeza==null){
      if(infoU=="."){
        cabeza.info="i";
        cabeza.sigR=nodoA;
        cabeza.sigR.sigR=nodoB;
        cabeza.sigR.sigR.sigR.info="f";

      }else if(infoU == "|"){
        //ARRIBA
        cabeza.info="i";
        cabeza.sigL.info="e";
        cabeza.sigL.sigR=nodoA;
        cabeza.sigL.sigR.sigR.info="e";
        cabeza.sigL.sigR.sigR.sigR.info="f";//ESTE->
        //ABAJO
        cabeza.sigR.info="e";
        cabeza.sigR.sigR=nodoB;
        cabeza.sigR.sigR.sigR.info="e";
        cabeza.sigR.sigR.sigR.sigL.info=cabeza.sigL.sigR.sigR.sigR;//ESTE->
      }
    }else{
      
    }
    

  }
}
