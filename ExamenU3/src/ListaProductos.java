public class ListaProductos {
    NodoProducto inicio,fin;

    public ListaProductos(){
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

    public void agregarProducto(int codigo, String nombre, double precio, int existencia){
        NodoProducto nuevo = new NodoProducto();
        nuevo.codigo = codigo;
        nuevo.nombre = nombre;
        nuevo.precio = precio;
        nuevo.existencia = existencia;
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

    public boolean buscarProducto(int codigo){
        NodoProducto temporal = inicio;
        while (temporal!=null && temporal.codigo!=codigo){
            temporal=temporal.siguiente;
        }
        return temporal!=null;

    }
    //metodo para mostrar datos
    public void imprimirLista(){
        NodoProducto recorrer = inicio;
        while (recorrer!=null){
            System.out.print(recorrer.codigo +"\t");
            System.out.print(recorrer.nombre +"\t");
            System.out.print(recorrer.precio +"\t");
            System.out.print(recorrer.existencia +"\n");
            recorrer = recorrer.siguiente;
        }
    }

    public double retornarPrecio(int codigo){
        NodoProducto recorrer=inicio;
        if (buscarProducto(codigo)){
            System.out.print(recorrer.nombre+"\t");
            System.out.println(recorrer.precio+"\t");
            return recorrer.precio;
        }else {
            return 0.0;
        }
    }

    public void imprimirDatos(int codigo){
        NodoProducto actual = new NodoProducto();
        actual = inicio;
        while (actual != null){
            if (actual.codigo == codigo){
                System.out.print(actual.nombre + "\t");
                System.out.println(actual.precio);
            }
            actual = actual.siguiente;
        }

    }
    public void modificarExistencia(int codigo,int cantidad){
        NodoProducto actual = new NodoProducto();
        actual = inicio;
        while (actual != null){
            if (actual.codigo == codigo){
                actual.existencia= actual.existencia-cantidad;
            }
            actual=actual.siguiente;
        }
    }

    public int getExistencia(int codigo){
        int existencia = 0;
        NodoProducto actual = new NodoProducto();
        actual = inicio;
        while (actual != null){
            if (actual.codigo == codigo){
                existencia =  actual.existencia;
            }
        }
        return existencia;

    }


}
