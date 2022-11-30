import java.util.ArrayList;

public class ListaVentas {
    NodoVenta inicio,fin;

    public ListaVentas(){
        inicio = null;
        fin = null;
    }

    public boolean estaVacia(){
        if (inicio == null){
            return true;
        }else {
            return false;
        }
    }

    public void agregarVenta(int folioVenta, double total){
        NodoVenta nuevo = new NodoVenta();
        nuevo.folioVenta = folioVenta;
        nuevo.total = total;
        if (inicio == null){
            inicio = nuevo;
            inicio.siguiente = null;
            fin = inicio;
        }else {
            fin.siguiente = nuevo;
            nuevo.siguiente = null;
            fin = nuevo;
        }
    }

    public void imprimirVentas(){
        NodoVenta recorrer = inicio;
        while(recorrer!=null){
            System.out.println("----------------------------------------------------------");
            System.out.println("                Haciendo Devolucion                     ");
            System.out.println("----------------------------------------------------------");
            System.out.print("Folio: "+ recorrer.folioVenta + "\t");
            System.out.println("Total: "+recorrer.total);
            recorrer = recorrer.siguiente;
        }

    }

    //Borrar venta
    public void devolucion(int folioVenta){
        if (!estaVacia()){
            if (inicio == fin && folioVenta== inicio.folioVenta){
                inicio=fin=null;
            } else if (folioVenta == inicio.folioVenta) {
                inicio=inicio.siguiente;
            }else {
                NodoVenta anterior,temporal;
                anterior = inicio;
                temporal = inicio.siguiente;
                while (temporal!=null && temporal.folioVenta!=folioVenta) {
                    anterior = anterior.siguiente;
                    temporal=temporal.siguiente;
                }
                if (temporal!=null){
                    anterior.siguiente=temporal.siguiente;
                    if (temporal == fin){
                        fin = anterior;
                    }
                }
            }
        }
    }

    //buscar venta
    public boolean buscarVenta(int folioVenta){
        NodoVenta temporal = inicio;
        while (temporal!= null && temporal.folioVenta!=folioVenta){
            temporal = temporal.siguiente;
        }
        return temporal != null;
    }
}
