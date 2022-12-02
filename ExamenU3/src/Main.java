import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("        ***** BIENVENIDOS A LA TIENDA DE ABARROTES GUZMAN *****    ");
        System.out.println("---------------------------------------------------------------------------");
        Scanner leer = new Scanner(System.in);
        ListaProductos producto = new ListaProductos();
        ListaVentas venta = new ListaVentas();
        int opcion = 0, opcVenta;
        int codigo,folioVenta;
        int cantidad;
        double totalVenta = 0;
        List<NodoProducto> invetario = new ArrayList<NodoProducto>();
        List<NodoVenta> ventas = new ArrayList<NodoVenta>();

        invetario.add(producto.agregarProducto(234,"Coca Cola 600ml",17.0,10));
        invetario.add(producto.agregarProducto(345,"Jarrito 600ml",11.0,10));
        invetario.add(producto.agregarProducto(456,"Cheetos Naranjas",15.0,10));
        invetario.add(producto.agregarProducto(567,"Cheetos Azules",15.0,10));
        invetario.add(producto.agregarProducto(678,"Cheetos rojos",15.0,10));
        invetario.add(producto.agregarProducto(789,"Doritos",16.0,10));
        invetario.add(producto.agregarProducto(890,"Chokis",17.0,10));
        invetario.add(producto.agregarProducto(901,"Florentinas",17.0,10));
        invetario.add(producto.agregarProducto(112,"Boiong",15.0,10));
        invetario.add(producto.agregarProducto(123,"Red cola",15.0,10));
        System.out.println();
        do {
            System.out.println("1.-Agregar venta \n" +
                    "2.- Hacer devolucion \n" +
                    "3.- Cerrar caja");
            opcion = leer.nextInt();
            switch (opcion){
                case 1:
                    folioVenta = (int)(Math.round(Math.random()*100));
                    System.out.println("------------------------------");
                    System.out.println("    Comenzando la  Venta...   ");
                    System.out.println("------------------------------");
                    do{
                        codigo = leerDatos();
                        if (producto.buscarProducto(codigo)){
                            producto.imprimirDatos(codigo);
                            System.out.println("¿Confirmar?");
                            System.out.println("1.- Si" + "\n" + "2.- No");
                            int confirmar = leer.nextInt();
                            if (confirmar == 1){
                                double totalcantidad = producto.retornarPrecio(codigo);
                                totalVenta += totalcantidad;
                            }else {
                                System.out.println("No Se agrego el Producto");
                            }
                        }else if(codigo == -1){
                            System.out.println("Venta realizada y almacenada");
                        }else {
                            System.out.println("Producto No Encontrado");
                        }
                    }while (codigo!=-1);
                    if (totalVenta > 0){
                        System.out.println("Si se hizo");
                        venta.agregarVenta(folioVenta,totalVenta);
                    }
                    else {
                        System.out.println("no se agrego");
                    }
                    break;
                case 2:
                    venta.imprimirVentas();
                    break;
                case 3:
                    System.out.println("Saliendo");
                    break;

            }
        }while(opcion!=3);

    }

    public static int leerDatos(){
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingresa el codigo del producto...");
        System.out.println("| -1 Finalizar venta |");
        int codigo = leer.nextInt();
        return codigo;
    }
}