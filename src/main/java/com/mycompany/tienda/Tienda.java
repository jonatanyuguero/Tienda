/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.tienda;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Jonatan
 */
public class Tienda {

    Scanner sc = new Scanner(System.in);
    private ArrayList<Pedido> pedidos;
    private HashMap<String, Articulo> articulos;
    private HashMap<String, Cliente> clientes;

    public Tienda() {
        pedidos = new ArrayList();
        articulos = new HashMap();
        clientes = new HashMap();
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public HashMap<String, Articulo> getArticulos() {
        return articulos;
    }

    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }

    public static void main(String[] args) {
        Tienda t = new Tienda();
        t.cargaDatos();
        t.menu();
        //t.backup();
        //t.leerArchivos();
    }
    //<editor-fold defaultstate="collapsed" desc="MENÚS">
    private void menu() {

        int opcion = 0;
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tTIENDA");
            System.out.println("\t\t\t\t1 - PEDIDOS");
            System.out.println("\t\t\t\t2 - ARTICULOS");
            System.out.println("\t\t\t\t3 - CLIENTES");
            System.out.println("\t\t\t\t9 - SALIR");
            try {
                opcion = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Introduce un número válido.");
                sc.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    menuPedidos();
                    break;
                case 2:
                    menuArticulos();
                    break;
                case 3:
                    menuClientes();
                    break;

            }
        } while (opcion != 9);
    }

    private void menuPedidos() {

        int opcion = 0;
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tPEDIDOS");
            System.out.println("\t\t\t\t1 - NUEVO PEDIDO");
            System.out.println("\t\t\t\t2 - ELIMINAR PEDIDO");
            System.out.println("\t\t\t\t3 - MODIFICAR PEDIDO");
            System.out.println("\t\t\t\t4 - LISTADO DE PEDIDOS");
            System.out.println("\t\t\t\t5 - BACKUP POR IMPORTE");
            System.out.println("\t\t\t\t6 - LEER PEDIDOS POR IMPORTE");
            System.out.println("\t\t\t\t9 - SALIR");

            try {
                opcion = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Introduce un número válido.");
                sc.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    nuevoPedido();
                    break;
                case 2:
                    eliminarPedido();
                    break;
                case 3:
                    modificarPedido();
                    break;
                case 4:
                    listadoPedidos();
                    break;
                case 5:
                    pedidosPorImporteBackup();
                    break;
                case 6:
                    leerPedidosPorImporte();
                    break;
            }
        } while (opcion != 9);
    }

    private void menuArticulos() {

        int opcion = 0;
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tARTICULOS");
            System.out.println("\t\t\t\t1 - NUEVO ARTICULO");
            System.out.println("\t\t\t\t2 - MODIFICAR ARTICULO");
            System.out.println("\t\t\t\t3 - ELIMINAR ARTICULO");
            System.out.println("\t\t\t\t4 - LISTADO DE ARTICULOS");
            System.out.println("\t\t\t\t5 - REPONER ARTICULO");
            System.out.println("\t\t\t\t6 - COPIA DE SEGURIDAD POR SECCIONES");
            System.out.println("\t\t\t\t9 - SALIR");

            try {
                opcion = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Introduce un número válido.");
                sc.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    nuevoArticulo();
                    break;
                case 2:
                    modificarArticulo();
                    break;
                case 3:
                    eliminarArticulo();
                    break;
                case 4:
                    listadoArticulos();
                    break;
                case 5:
                    reponerArticulos();
                    break;
                case 6:
                    backupPorSeccion();

                    break;
                case 7:
                    leerArchivosSeccion();
                    break;
            }
        } while (opcion != 9);
    }

    private void menuClientes() {

        int opcion = 0;
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tCLIENTES");
            System.out.println("\t\t\t\t1 - NUEVO CLIENTE");
            System.out.println("\t\t\t\t2 - MODIFICAR CLIENTE");
            System.out.println("\t\t\t\t3 - ELIMINAR CLIENTE");
            System.out.println("\t\t\t\t4 - LISTADO DE CLIENTES");
            System.out.println("\t\t\t\t4 - HACER BACK UP CLIENTES CSV");
            System.out.println("\t\t\t\t5 - LEER BACKUP CLIENTES CSV");
            System.out.println("\t\t\t\t9 - SALIR");

            try {
                opcion = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Introduce un número válido.");
                sc.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    nuevoCliente();
                    break;
                case 2:
                    modificarCliente();
                    break;
                case 3:
                    eliminarCliente();
                    break;
                case 4:
                    listadoClientes();
                    break;
                case 5:
                    clientesTxtBackup();
                    break;
                case 6:
                    clientesTxtLeer();
                    break;

            }
        } while (opcion != 9);
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GESTIÓN DE PEDIDOS">
    public void stock(String id, int unidadesPed) throws StockAgotado, StockInsuficiente {
        int n = articulos.get(id).getExistencias();
        if (n == 0) {
            throw new StockAgotado("Stock AGOTADO para el artículo: " + articulos.get(id).getDescripcion());
        } else if (n < unidadesPed) {
            throw new StockInsuficiente("No hay stock suficiente. Me pide " + unidadesPed + " de " + articulos.get(id).getDescripcion() + " y sólo se dispone de: " + n);
        }
    }

    public String generaIdPedido(String idCliente) {
        int contador = 0;
        String nuevoId;
        for (Pedido p : pedidos) {
            if (p.getClientePedido().getDni().equalsIgnoreCase(idCliente)) {
                contador++;
            }
        }
        contador++;
        nuevoId = idCliente + "-" + String.format("%03d", contador) + "/" + LocalDate.now().getYear();
        return nuevoId;
    }

    private void nuevoPedido() {
        //ARRAYLIST AUXILIAR PARA CREAR EL PEDIDO
        ArrayList<LineaPedido> CestaCompraAux = new ArrayList();
        String dniT, idT, opc, pedidasS;
        int pedidas = 0;
        sc.nextLine();
        do {
            System.out.println("CLIENTE PEDIDO (DNI):");
            dniT = sc.nextLine().toUpperCase();
            //EN CUALQUIER MOMENTO PODEMOS SALIR DEL BUCLE TECLEANDO RETORNO
            if (dniT.isBlank()) {
                break;
            }
            if (!MetodosAux.validarDni(dniT) || !clientes.containsKey(dniT)) {
                System.out.println("El DNI no es válido O NO ES CLIENTE DE LA TIENDA");
            };
        } while (!clientes.containsKey(dniT));

        if (!dniT.isBlank()) {
            System.out.println("\t\tCOMENZAMOS CON EL PEDIDO");
            System.out.println("INTRODUCE CODIGO ARTICULO (RETURN PARA TERMINAR): ");
            idT = sc.nextLine();

            while (!idT.isEmpty()) {
                if (!articulos.containsKey(idT)) {
                    System.out.println("El ID articulo tecleado no existe");
                } else {
                    System.out.print("(" + articulos.get(idT).getDescripcion() + ") - UNIDADES? ");
                    do {
                        pedidasS = sc.nextLine();
                    } while (!MetodosAux.esInt(pedidasS));

                    pedidas = Integer.parseInt(pedidasS);

                    try {
                        stock(idT, pedidas); // LLAMO AL METODO STOCK, PUEDEN SALTAR 2 EXCEPCIONES
                        CestaCompraAux.add(new LineaPedido(idT, pedidas));
                        articulos.get(idT).setExistencias(articulos.get(idT).getExistencias() - pedidas);
                    } catch (StockAgotado e) {
                        System.out.println(e.getMessage());
                    } catch (StockInsuficiente e) {
                        System.out.println(e.getMessage());
                        int disponibles = articulos.get(idT).getExistencias();
                        System.out.print("QUIERES LAS " + disponibles + " UNIDADES DISPONIBLES? (S/N) ");
                        opc = sc.next();
                        if (opc.equalsIgnoreCase("S")) {
                            CestaCompraAux.add(new LineaPedido(idT, disponibles));
                            articulos.get(idT).setExistencias(articulos.get(idT).getExistencias() - disponibles);
                        }
                    }
                }
                System.out.println("INTRODUCE CODIGO ARTICULO (RETURN PARA TERMINAR): ");
                idT = sc.nextLine();
            }

            //IMPRIMO EL PEDIDO Y SOLICITO ACEPTACION DEFINITIVA DEL MISMO 
            for (LineaPedido l : CestaCompraAux) {
                System.out.println(articulos.get(l.getIdArticulo()).getDescripcion() + " - (" + l.getUnidades() + ")");
            }
            System.out.println("ESTE ES TU PEDIDO. PROCEDEMOS? (S/N)   ");
            opc = sc.next();
            if (opc.equalsIgnoreCase("S")) {
                // ESCRIBO EL PEDIDO DEFINITIVAMENTE Y DESCUENTO LAS EXISTENCIAS PEDIDAS DE CADA ARTICULO
                LocalDate hoy = LocalDate.now();
                pedidos.add(new Pedido(generaIdPedido(dniT), clientes.get(dniT), hoy, CestaCompraAux));
            } else {
                for (LineaPedido l : CestaCompraAux) {
                    articulos.get(l.getIdArticulo()).setExistencias(articulos.get(l.getIdArticulo()).getExistencias() + l.getUnidades());
                }
            }
        }
    }

    private void eliminarPedido() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el ID del pedido a eliminar: ");
        String id = sc.next();
        Pedido pedidoToRemove = null;
        for (Pedido p : pedidos) {
            if (p.getIdPedido().equalsIgnoreCase(id)) {
                pedidoToRemove = p;
                break;
            }
        }
        if (pedidoToRemove != null) {
            // Se devuelven las existencias de cada línea del pedido
            for (LineaPedido lp : pedidoToRemove.getCestaCompra()) {
                Articulo art = articulos.get(lp.getIdArticulo());
                art.setExistencias(art.getExistencias() + lp.getUnidades());
            }
            pedidos.remove(pedidoToRemove);
            System.out.println("Pedido eliminado.");
        } else {
            System.out.println("Pedido no encontrado.");
        }
    }

    private void modificarPedido() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el ID del pedido a modificar: ");
        String id = sc.next();
        Pedido pedidoToModify = null;
        for (Pedido p : pedidos) {
            if (p.getIdPedido().equalsIgnoreCase(id)) {
                pedidoToModify = p;
                break;
            }
        }
        if (pedidoToModify == null) {
            System.out.println("Pedido no encontrado.");
            return;
        }
        System.out.println("Pedido encontrado:");
        System.out.println(pedidoToModify);
        System.out.print("¿Desea agregar una nueva línea de pedido? (S/N): ");
        String opc = sc.next();
        if (opc.equalsIgnoreCase("S")) {
            System.out.print("Introduce el código del artículo: ");
            String idArticulo = sc.next();
            if (!articulos.containsKey(idArticulo)) {
                System.out.println("Artículo no encontrado.");
                return;
            }
            System.out.print("Introduce el número de unidades: ");
            int unidades = sc.nextInt();
            try {
                stock(idArticulo, unidades);
                pedidoToModify.getCestaCompra().add(new LineaPedido(idArticulo, unidades));
                // Se descuenta el stock
                Articulo art = articulos.get(idArticulo);
                art.setExistencias(art.getExistencias() - unidades);
                System.out.println("Línea agregada al pedido.");
            } catch (StockAgotado | StockInsuficiente e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private double totalPedido(Pedido p) {
        double total = 0;
        for (LineaPedido L : p.getCestaCompra()) {

            total += (articulos.get(L.getIdArticulo()).getPvp())
                    * L.getUnidades();
        }
        return total;
    }

    private void listadoPedidos() {
        System.out.println("Como desea ver los pedidos");
        int opcion = 0;
        do {
            System.out.println("\t\t\t\t1 - IMPORTE TOTAL");
            System.out.println("\t\t\t\t2 - POR FECHA");
            System.out.println("\t\t\t\t3 - IMPORTE QUE SE SOLICITA POR TECLADO");
            System.out.println("\t\t\t\t4 - SALIR");
            try {
                opcion = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Introduce un número válido.");
                sc.nextLine();
                continue;
            }
            switch (opcion) {
                case 1:
                    pedidos.stream().sorted(Comparator.comparing(p -> totalPedido(p))).forEach(p -> System.out.println(p + "\t - IMPORTE TOTAL: " + totalPedido(p) + " Euro"));
                    break;
                case 2:
                    pedidos.stream().sorted(Comparator.comparing(Pedido::getFechaPedido)).forEach(p -> System.out.println("El pedido fue efectuado en la siguiente fecha: " + p.getFechaPedido() + " y el ID del pedido es: " + p.getIdPedido()));
                    break;
                case 3:
                    System.out.println("Introduce el importe minimo");
                    Double importe = sc.nextDouble();
                    pedidos.stream().filter(p -> totalPedido(p) > importe).forEach(p -> System.out.println("El cliente " + p.getClientePedido().getNombre() + " Compro " + p.getCestaCompra() + " IMPORTE TOTAL " + totalPedido(p) + " Euros"));

                    break;
            }
        } while (opcion != 4);
    }

    private void pedidosPorImporteBackup() {
        try (ObjectOutputStream oosPedidosImporte = new ObjectOutputStream(new FileOutputStream("pedidosPorImporte.dat"))) {
            // Ordenamos los pedidos por importe total (de mayor a menor)
            List<Pedido> pedidosOrdenados = new ArrayList<>(pedidos);
            pedidosOrdenados.sort((p1, p2) -> Double.compare(totalPedido(p2), totalPedido(p1)));

            // Guardamos cada pedido en el archivo
            for (Pedido p : pedidosOrdenados) {
                oosPedidosImporte.writeObject(p);
            }

            System.out.println("Copia de seguridad de pedidos por importe realizada con exito.");
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    private void leerPedidosPorImporte() {
        List<Pedido> pedidosImporte = new ArrayList<>();

        try (ObjectInputStream oisPedidosImporte = new ObjectInputStream(new FileInputStream("pedidosPorImporte.dat"))) {
            Pedido p;
            while ((p = (Pedido) oisPedidosImporte.readObject()) != null) {
                pedidosImporte.add(p);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.toString());
        } catch (EOFException e) {
            // Fin del archivo alcanzado (comportamiento normal)
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.toString());
        }

        // Mostramos los pedidos recuperados con su importe
        System.out.println("PEDIDOS ORDENADOS POR IMPORTE:");
        System.out.println("ID_PEDIDO\tCLIENTE\tFECHA\tIMPORTE");
        for (Pedido p : pedidosImporte) {
            System.out.println("ID: " + p.getIdPedido()
                    + ", Cliente: " + p.getClientePedido().getNombre()
                    + ", Fecha: " + p.getFechaPedido()
                    + ", Total: " + totalPedido(p));
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GESTIÓN DE ARTICULOS">
    private void nuevoArticulo() {
        String id, descripcion;
        int existencias;
        double precio;

        do {
            System.out.print("Ingrese el ID del artículo: ");
            id = sc.nextLine();
            if (articulos.containsKey(id)) {
                System.out.println("El ID ya existe. Intente con otro.");
                return;
            }
        } while (id.isEmpty());

        System.out.print("Ingrese la descripción del artículo: ");
        descripcion = sc.nextLine();

        do {
            System.out.print("Ingrese la cantidad en stock: ");
            while (!sc.hasNextInt()) {
                System.out.println("Por favor, introduzca un número válido.");
                sc.next();
            }
            existencias = sc.nextInt();
        } while (existencias < 0);

        do {
            System.out.print("Ingrese el precio: ");
            while (!sc.hasNextDouble()) {
                System.out.println("Por favor, introduzca un precio válido.");
                sc.next();
            }
            precio = sc.nextDouble();
        } while (precio <= 0);

        Articulo a = new Articulo(id, descripcion, existencias, precio);
        articulos.put(id, a);
        System.out.println("Artículo añadido correctamente.");
    }

    private void modificarArticulo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el código del artículo a modificar: ");
        String id = sc.next();
        if (!articulos.containsKey(id)) {
            System.out.println("El artículo no existe.");
            return;
        }
        Articulo art = articulos.get(id);
        System.out.println("Artículo actual: " + art);
        sc.nextLine(); // limpiar buffer
        System.out.print("Introduce la nueva descripción (dejar en blanco para no cambiar): ");
        String descripcion = sc.nextLine();
        if (!descripcion.isBlank()) {
            art.setDescripcion(descripcion);
        }
        System.out.print("Introduce las nuevas existencias (o -1 para no cambiar): ");
        int existencias = sc.nextInt();
        if (existencias != -1) {
            art.setExistencias(existencias);
        }
        System.out.print("Introduce el nuevo precio (o -1 para no cambiar): ");
        double precio = sc.nextDouble();
        if (precio != -1) {
            art.setPvp(precio);
        }
        System.out.println("Artículo modificado.");
    }

    private void eliminarArticulo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el codigo del articulo a eliminar: ");
        String id = sc.next();
        if (!articulos.containsKey(id)) {
            System.out.println("El articulo no existe.");
            return;
        }
        articulos.remove(id);
        System.out.println("Articulo eliminado.");
    }

    private void listadoArticulos() {
        ArrayList<Articulo> articulosAux = new ArrayList(articulos.values());
        Collections.sort(articulosAux);
        for (Articulo a : articulosAux) {
            System.out.println(a);
        }

        System.out.println("");
        System.out.println("AL REVÉS");
        System.out.println("");

        Collections.reverse(articulosAux);
        for (Articulo a : articulosAux) {
            System.out.println(a);
        }

        System.out.println("");
        System.out.println("ORDENADO POR PRECIO");
        System.out.println("");

        Collections.sort(articulosAux, new ComparaArticulosPorPrecio());
        for (Articulo a : articulosAux) {
            System.out.println(a);
        }

        System.out.println("");
        System.out.println("ORDENADO POR EXISTENCIAS");
        System.out.println("");

        Collections.sort(articulosAux, new ComparaArticulosPorExistencias());
        for (Articulo a : articulosAux) {
            System.out.println(a);
        }

        System.out.println("");

        articulos.values().stream().sorted().forEach(System.out::println);
        System.out.println("");
        articulos.values().stream().sorted(new ComparaArticulosPorExistencias()).forEach(System.out::println);
        System.out.println("");
        articulos.values().stream().sorted(new ComparaArticulosPorPrecio()).forEach(System.out::println);

        System.out.println("");
    }

    private int cantidadTotalVendida(String idArticulo) {
        return pedidos.stream().flatMap(p -> p.getCestaCompra().stream()).filter(lp -> lp.getIdArticulo().equals(idArticulo)).mapToInt(LineaPedido::getUnidades).sum();
    }

    private void listarArticulosPorDemanda() {
        articulos.values().stream()
                .sorted(Comparator.comparing(a -> cantidadTotalVendida(a.getIdArticulo()), Comparator.reverseOrder()))
                .forEach(a -> System.out.println(a + " \t - el número de artículos vendidos es: " + cantidadTotalVendida(a.getIdArticulo())));
    }

    private void reponerArticulos() {
        System.out.println("Introduce el codigo del articulo a reponer");
        String id = sc.next();
        if (!articulos.containsKey(id)) {
            System.out.println("El articulo no existe");
            return;
        }
        int existencias = articulos.get(id).getExistencias();
        System.out.println("La cantidad es actual de existencias es : " + existencias + " unidades.");
        System.out.println("Cuantas unidades desea reponer?");
        int reponer = sc.nextInt();
        System.out.println("Articulos anadidos");
        articulos.get(id).setExistencias(existencias + reponer);
        System.out.println("La cantidad se ha actualizado a " + articulos.get(id).getExistencias());
    }

    private void leerArchivosSeccion() {
        System.out.println("Teclea la sección de los artículos que quieres recuperar");
        System.out.println("1 - PERIFERICOS");
        System.out.println("2 - ALMACENAMIENTO");
        System.out.println("3 - IMPRESORAS");
        System.out.println("4 - MONITORES");
        System.out.println("5 - TODOS");
        String id = sc.next();
        ArrayList<Articulo> articulosAux = new ArrayList();
        Articulo a;

        try (ObjectInputStream oisArticulos = new ObjectInputStream(new FileInputStream("articulos.dat"))) {
            while ((a = (Articulo) oisArticulos.readObject()) != null) {
                if (id.equals("5")) {
                    articulosAux.add(a);
                } else if (a.getIdArticulo().startsWith(id)) {
                    articulosAux.add(a);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());

        } catch (EOFException e) {

        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.toString());
        }
        articulosAux.forEach(System.out::println);
    }

    private void backupPorSeccion() {
        System.out.println("Teclea la sección de la que quiere hacer una copia de seguridad =)");
        System.out.println("1 - PERIFERICOS");
        System.out.println("2 - ALMACENAMIENTO");
        System.out.println("3 - IMPRESORAS");
        System.out.println("4 - MONITORES");
        System.out.println("5 - TODOS");
        String id = sc.next();

        try (ObjectOutputStream oosPerifericos = new ObjectOutputStream(new FileOutputStream("perifericos.dat")); ObjectOutputStream oosAlmacenamiento = new ObjectOutputStream(new FileOutputStream("almacenamiento.dat")); ObjectOutputStream oosImpresoras = new ObjectOutputStream(new FileOutputStream("impresoras.dat")); ObjectOutputStream oosMonitores = new ObjectOutputStream(new FileOutputStream("monitores.dat"))) {

            for (Articulo a : articulos.values()) {
                char seccion = a.getIdArticulo().charAt(0);
                switch (seccion) {
                    case '1':
                        oosPerifericos.writeObject(a);
                        break;
                    case '2':
                        oosAlmacenamiento.writeObject(a);
                        break;
                    case '3':
                        oosImpresoras.writeObject(a);
                        break;
                    case '4':
                        oosMonitores.writeObject(a);
                        break;
                }
            }

            System.out.println("Copia de seguridad realizada con éxito =)");
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GESTIÓN DE CLIENTES">
    private void nuevoCliente() {
        String dni, nombre, telefono, email;

        do {
            System.out.print("Deme su DNI: ");
            dni = sc.nextLine().toUpperCase();
            if (!MetodosAux.validarDni(dni)) {
                System.out.println("DNI no válido. Inténtelo de nuevo.");
            } else if (clientes.containsKey(dni)) {
                System.out.println("Ese cliente ya existe. Intente con otro DNI.");
                return;
            }
        } while (!MetodosAux.validarDni(dni));

        System.out.print("Deme su NOMBRE: ");
        nombre = sc.nextLine();

        do {
            System.out.print("Deme su TELÉFONO: ");
            telefono = sc.nextLine();
            if (!telefono.matches("\\d{9}")) {
                System.out.println("Número de teléfono no válido. Debe tener 9 dígitos.");
            }
        } while (!telefono.matches("\\d{9}"));

        do {
            System.out.print("Deme su EMAIL: ");
            email = sc.nextLine();
            if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                System.out.println("Correo electrónico no válido. Inténtelo de nuevo.");
            }
        } while (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$"));

        Cliente c = new Cliente(dni, nombre, telefono, email);
        clientes.put(dni, c);
        System.out.println("Cliente añadido correctamente.");
    }

    private void modificarCliente() {
        System.out.print("Introduce el DNI del cliente a modificar: ");
        String dni = sc.next().toUpperCase();
        if (!clientes.containsKey(dni)) {
            System.out.println("El cliente no existe.");
            return;
        }
        Cliente cliente = clientes.get(dni);
        System.out.println("Cliente actual: " + cliente);
        sc.nextLine(); // limpiar buffer

        System.out.print("Introduce el nuevo teléfono (dejar en blanco para no cambiar): ");
        String telefono = sc.nextLine();
        if (!telefono.isBlank()) {
            cliente.setTelefono(telefono);
        }
        System.out.print("Introduce el nuevo email (dejar en blanco para no cambiar): ");
        String email = sc.nextLine();
        if (!email.isBlank()) {
            cliente.setEmail(email);
        }
        System.out.println("Cliente modificado.");
    }

    private void eliminarCliente() {
        System.out.print("Introduce el DNI del cliente a eliminar: ");
        String dni = sc.next().toUpperCase();
        if (!clientes.containsKey(dni)) {
            System.out.println("El cliente no existe.");
            return;
        }
        clientes.remove(dni);
        System.out.println("Cliente eliminado.");
    }

    private void listadoClientes() {
        System.out.println("Listado de Clientes:");
        for (Cliente c : clientes.values()) {
            System.out.println(c);
        }
    }

    private void clientesTxtBackup() {
        try (BufferedWriter bfwClientes = new BufferedWriter(new FileWriter("clientes.csv"))) {
            for (Cliente c : clientes.values()) {
                bfwClientes.write(c.getDni() + "," + c.getNombre() + "," + c.getTelefono() + "," + c.getEmail() + "\n");
            }
            System.out.println("Backup realizado con exito");
        } catch (FileNotFoundException e) {
            System.out.println("lanzo exception " + e.toString());
        } catch (IOException e) {
            System.out.println("lanzo exception " + e.toString());
        }
    }

    private void clientesTxtLeer() {
        // LEEMOS LOS CLIENTES DESDE EL ARCHIVO .csv A UNA COLECCION HASHMAP AUXILIAR Y LA IMPRIMIMOS
        HashMap<String, Cliente> clientesAux = new HashMap();
        File file = new File("clientes.csv");
        try (Scanner scClientes = new Scanner(file)) {
            while (scClientes.hasNextLine()) {
                String[] atributos = scClientes.nextLine().split("[,]");
                Cliente c = new Cliente(atributos[0], atributos[1], atributos[2], atributos[3]);
                clientesAux.put(atributos[0], c);
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        clientesAux.values().forEach(System.out::println);
    }
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="OTROS MÉTODOS">
    public void cargaDatos() {

        clientes.put("80580845T", new Cliente("80580845T", "ANA ", "658111111", "ana@gmail.com"));
        clientes.put("36347775R", new Cliente("36347775R", "LOLA", "649222222", "lola@gmail.com"));
        clientes.put("63921307Y", new Cliente("63921307Y", "JUAN", "652333333", "juan@gmail.com"));
        clientes.put("02337565Y", new Cliente("02337565Y", "EDU", "634567890", "edu@gmail.com"));

        articulos.put("1-11", new Articulo("1-11", "RATON LOGITECH ST ", 14, 15));
        articulos.put("1-22", new Articulo("1-22", "TECLADO STANDARD  ", 9, 18));
        articulos.put("2-11", new Articulo("2-11", "HDD SEAGATE 1 TB  ", 16, 80));
        articulos.put("2-22", new Articulo("2-22", "SSD KINGSTOM 256GB", 9, 70));
        articulos.put("2-33", new Articulo("2-33", "SSD KINGSTOM 512GB", 0, 200));
        articulos.put("3-22", new Articulo("3-22", "EPSON PRINT XP300 ", 5, 80));
        articulos.put("4-11", new Articulo("4-11", "ASUS  MONITOR  22 ", 5, 100));
        articulos.put("4-22", new Articulo("4-22", "HP MONITOR LED 28 ", 5, 180));
        articulos.put("4-33", new Articulo("4-33", "SAMSUNG ODISSEY G5", 12, 580));

        LocalDate hoy = LocalDate.now();
        pedidos.add(new Pedido("80580845T-001/2024", clientes.get("80580845T"), hoy.minusDays(1), new ArrayList<>(List.of(new LineaPedido("1-11", 3), new LineaPedido("4-22", 3)))));
        pedidos.add(new Pedido("80580845T-002/2024", clientes.get("80580845T"), hoy.minusDays(2), new ArrayList<>(List.of(new LineaPedido("4-11", 3), new LineaPedido("4-22", 2), new LineaPedido("4-33", 4)))));
        pedidos.add(new Pedido("36347775R-001/2024", clientes.get("36347775R"), hoy.minusDays(3), new ArrayList<>(List.of(new LineaPedido("4-22", 1), new LineaPedido("2-22", 3)))));
        pedidos.add(new Pedido("36347775R-002/2024", clientes.get("36347775R"), hoy.minusDays(5), new ArrayList<>(List.of(new LineaPedido("4-33", 3), new LineaPedido("2-11", 3)))));
        pedidos.add(new Pedido("63921307Y-001/2024", clientes.get("63921307Y"), hoy.minusDays(4), new ArrayList<>(List.of(new LineaPedido("2-11", 5), new LineaPedido("2-33", 3), new LineaPedido("4-33", 2)))));
    }

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="PERSISTENCIA">
       public void backup() {
        try (ObjectOutputStream oosArticulos = new ObjectOutputStream(new FileOutputStream("articulos.dat"));
            ObjectOutputStream oosClientes = new ObjectOutputStream(new FileOutputStream("clientes.dat"));
            ObjectOutputStream oosPedidos = new ObjectOutputStream (new FileOutputStream("pedidos.dat"))) {
	   	   
            //COLECCIONES COMPLETAS
            oosArticulos.writeObject(articulos);
            oosClientes.writeObject(clientes);
            //LOS PEDIDOS SE GUARDAN OBJETO A OBJETO    
            for (Pedido p:pedidos){
                 oosPedidos.writeObject(p);
            }
            
            System.out.println("Copia de seguridad realizada con éxito.");
	    
        } catch (FileNotFoundException e) {
                 System.out.println(e.toString());                                                          
        } catch (IOException e) {
                 System.out.println(e.toString());
        } 
    }  
    
    public void leerArchivos() {
        try (ObjectInputStream oisArticulos = new ObjectInputStream(new FileInputStream("articulos.dat"));
             ObjectInputStream oisClientes = new ObjectInputStream(new FileInputStream("clientes.dat"));
             ObjectInputStream oisPedidos = new ObjectInputStream(new FileInputStream("pedidos.dat"))){
            
            articulos = (HashMap<String,Articulo>) oisArticulos.readObject();
            clientes = (HashMap<String,Cliente>) oisClientes.readObject();
            
            //LOS PEDIDOS SE IMPORTAN OBJETO A OBJETO
            Pedido p=null;
            while ( (p=(Pedido)oisPedidos.readObject()) != null){
                 pedidos.add(p);
            } 
            System.out.println("Colecciones importadas con éxito.");
            
	} catch (FileNotFoundException e) {
                 System.out.println(e.toString());    
        } catch (EOFException e){
            
        } catch (ClassNotFoundException | IOException e) {
                System.out.println(e.toString()); 
        } 
        
   }  
   
    public void backupPedidosClientes() {
       
        /*OPCION 1 - CLIENTE A CLIENTE - IMPLICA PROCESAR CADA CLIENTE POR SEPARADO Y RECORRER PEDIDOS 
        TANTAS VECES COMO CLIENTES HAY */
        boolean tienePedidos;
        String archivo;
        for (Cliente c:clientes.values()){
            tienePedidos=false;       
            for (Pedido p: pedidos ){
                if(p.getClientePedido().equals(c)){
                    tienePedidos=true;
                    break;
                }
            }
            if (tienePedidos){
                archivo="PedidosCliente_" + c.getNombre()+".dat";
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo)))
                {
                   for (Pedido p: pedidos ){
                        if(p.getClientePedido().equals(c)) {
                            oos.writeObject(p);
                        }
                   }
                } catch (IOException e) {
                   System.out.println(e.toString());
                } 
                
            }
        }
        System.out.println("ARCHIVOS CREADOS CORRECTAMENTE\n");
        
        /*AHORA SOLICITAMOS EL DNI DE UN CLIENTE PARA MOSTRAR SUS PEDIDOS
        DESDE EL ARCHIVO .dat CORRESPONDIENTE*/
         
        String dniT; 
        //NO PERMITIMOS ENTRADA DE DNIs NO VÁLIDOS O QUE NO ESTÁN EN LA TIENDA
        do{
            System.out.println("DNI CLIENTE:");
            dniT=sc.next().toUpperCase();    
        }while (!clientes.containsKey(dniT)||!MetodosAux.validarDni(dniT));
        
        //COMPROBAMOS AHORA SI EL DNI TIENE PEDIDOS.
        //SI NO LOS TIENE NO SE CREÓ SU ARCHIVO
        tienePedidos=false;       
        for (Pedido p: pedidos ){
            if(p.getClientePedido().equals(clientes.get(dniT))) {
                tienePedidos=true;
                break;
            }
        }
        
        if (tienePedidos){
            archivo="PedidosCliente_" + clientes.get(dniT).getNombre()+".dat";
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo)))
            {
                Pedido p;
                while ( (p=(Pedido)ois.readObject()) != null){
                     System.out.println("\nPEDIDO: " + p.getIdPedido() + " DE: " + p.getClientePedido().getNombre());
                     for (LineaPedido l:p.getCestaCompra()){
                         System.out.println(articulos.get(l.getIdArticulo()).getDescripcion()
                                 + "\t Unidades: " +l.getUnidades());
                     }
                } 
            } catch (EOFException e) {
                System.out.println("Fin archivo");
            } catch (IOException e) {
                System.out.println("No existen pedidos para ese DNI");
            } catch (ClassNotFoundException ex) {
            }
        } 
         
        /* BACKUP OPCION 2 - VAMOS PEDIDO A PEDIDO Y SOBRE LA MARCHA ABRIENDO 1 ObjectOutputStream POR CLIENTE
        Y PASANDO SUS PEDIDOS AL CORRESPONDIENTE ARCHIVO - LO HACEMOS TODO DE UNA PASADA PERO HAY QUE ABRIR
        A LA VEZ BASTANTES CANALES DE E/S Y MANEJAR UN HASHMAP DE CLIENTES --> ObjectOutputStream */ 
        /*
        HashMap <String,ObjectOutputStream> clientesConPedido =new HashMap();
        String archivo;
        String nombreCliente;
        for (Pedido p:pedidos){
            nombreCliente=p.getClientePedido().getNombre();
            try{
                if (!clientesConPedido.containsKey(nombreCliente)){
                    archivo= "PedidosCliente_" + nombreCliente +".dat";
                    clientesConPedido.put(nombreCliente, new ObjectOutputStream(new FileOutputStream(archivo)));
                    clientesConPedido.get(nombreCliente).writeObject(p);
                }else{
                    clientesConPedido.get(nombreCliente).writeObject(p);
                }
            }
            catch (IOException e) {
                System.out.println(e.toString());
            } 
        }
        //Cerramos todos los canales de serialización hacía los archivos pues no hemso podido hacer Try_with_resources
        for (ObjectOutputStream oos: clientesConPedido.values()){
            try {
                oos.close();
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }
        
        String dniT; 
        do{
            System.out.println("DNI CLIENTE:");
            dniT=sc.next().toUpperCase();    
        }while (!clientes.containsKey(dniT)||!MetodosAux.validarDni(dniT));
        
              
        if (clientesConPedido.containsKey(clientes.get(dniT).getNombre())){
            archivo="PedidosCliente_" + clientes.get(dniT).getNombre()+".dat";
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo)))
            {
                Pedido p=null;
                while ( (p=(Pedido)ois.readObject()) != null){
                     System.out.println("\nPEDIDO: " + p.getIdPedido() + " DE: " + p.getClientePedido().getNombre());
                     for (LineaPedido l:p.getCestaCompra()){
                         System.out.println(articulos.get(l.getIdArticulo()).getDescripcion()
                                 + "\t Unidades: " +l.getUnidades());
                     }
                } 
            } catch (EOFException e) {
                System.out.println("Fin archivo");
            } catch (IOException e) {
                System.out.println(e.toString());
            } catch (ClassNotFoundException e) {
                System.out.println(e.toString());
            }
        }*/
        
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="EJERCICIOS SEMANA SANTA">
    //DE MAYOR A MENOR SE MOSTRARAN LOS PEDIDOS Y EL NUMERO DE UNIDADES VENDIDAS DE ESE ARTÍCULO EN CADA UNO DE LOS PEDIDOS 

    public void unidadesVendidasArticuloEnPedidos()
    {
	String id;
        do{
            System.out.println("Teclea idArticulo para contabilizar en pedidos:");
            id=sc.next();
        }while(!articulos.containsKey(id));
        
        System.out.println("Unidades vendidas del artículo: " + articulos.get(id).getDescripcion());
       
        final String id2 = id;
        pedidos.stream().sorted(Comparator.comparing(p-> articuloEnPedido2(id2, (Pedido)p)).reversed()).
                forEach(p-> System.out.println("Pedido " +p.getIdPedido() + "-" + p.getFechaPedido()  
                     + " : " + articuloEnPedido2(id2,p) + " unidades"  ));
      
    }
    
    //METODO CLÁSICO
    public int articuloEnPedido(String idArticulo, Pedido p){
       int contador=0;
       for (LineaPedido l:p.getCestaCompra()){
           if (l.getIdArticulo().equals(idArticulo)){
               contador+=l.getUnidades();
               break;
           }
       }
       return contador;
    }
    
    /* MÉTODO PROGRAMACIÓN FUNCIONAL - ES NECESARIO CONTROLAR LA EXCEPCIÓN
      NoSuchElementException QUE SALTA CUANDO el idArticulo no aparece en el Pedido.
      En ese caso devolvemos 0 unidades */
    
    public int articuloEnPedido2(String idArticulo, Pedido p){
        /* ALTERNATIVA 1 - NECESITO MANEJAR LA EXCEPCION NoSuchElementException
        try {
            return p.getCestaCompra().stream().filter(l->l.getIdArticulo().equals(idArticulo))
             .findFirst().get().getUnidades();
        } catch (NoSuchElementException e){
            return 0;
        }*/
        
        //ALTERNATIVA 2 - USANDO mapToInt
        return p.getCestaCompra().stream().filter(l->l.getIdArticulo().equals(idArticulo))
                .mapToInt(LineaPedido::getUnidades).sum();
    }
    
    public void articuloUsuariosLoHanComprado(){
        /*
        IMPORTANTE TENER EN CUENTA QUE UN USUARIO PUEDE HABER COMPRADO EL MISMO ARTÍCULO EN PEDIDOS
        DISTINTOS Y NO DEBEN DE SALIR VARIAS LÍNEAS EN EL LISTADO PARA ESE USUARIO/A. 
        DEBE DE SALIR UNA ÚNICA LÍNEA CON EL TOTAL DE UNIDADES DEL ARTÍCULO COMPRADAS POR EL USUARIO
        ESTO ES UNA COMPLEJIDAD PARA EL EJERCICIO 
        */
        
        String id;
        do{
            System.out.println("Teclea idArticulo para contabilizar en pedidos:");
            id=sc.next();
        }while(!articulos.containsKey(id));
        
        System.out.println("Usuarios que han comprado el articulo: " + articulos.get(id).getDescripcion());
        
        /* METODO CLÁSICO 
        for (Cliente c:clientes.values()){
            int unidades=0;
            for (Pedido p:pedidos){
                if (p.getClientePedido().equals(c)){
                    for(LineaPedido l:p.getCestaCompra()){
                        if (l.getIdArticulo().equals(id)){
                            unidades+= l.getUnidades();
                        }
                    }
                }
            }
            if (unidades>0){
                System.out.println(c.getNombre()+
                  " ha comprado " + unidades + " unidades") ;
            }
        }*/
        
        final String id2=id;
        for (Cliente c:clientes.values()){
            int unidades= pedidos.stream().filter(p-> p.getClientePedido().equals(c))
                    .mapToInt(p -> p.getCestaCompra().stream().filter(l->l.getIdArticulo().equals(id2))
                        .mapToInt(LineaPedido::getUnidades).sum()).sum();     
            
            if (unidades>0){
                System.out.println(c.getNombre() + ": " + unidades);
            }
        }                   
    }
    
    
    public void perdidosOrdenadosPorImporte(){
        pedidos.stream().sorted(Comparator.comparing(p->totalPedido((Pedido) p))
            .reversed()).forEach(p-> System.out.println(p.getIdPedido() + ":\t "+ totalPedido(p)));
    }
    
    public void clientesOrdenadosPorGasto(){
        clientes.values().stream().sorted(Comparator.comparing(c->totalCliente((Cliente) c))
            .reversed()).forEach
            (c-> System.out.println(c.getNombre() + ":\t "+ totalCliente(c)));
    }
    
    public double totalCliente(Cliente c){
        /* VERSIÓN CLÁSICA
        double total=0;
        for(Pedido p:pedidos){
            if (p.getClientePedido().equals(c)){
                total+=totalPedido(p);
            }
        }
        return total;*/
        return pedidos.stream().filter(p-> p.getClientePedido().equals(c))
                .mapToDouble(p -> totalPedido(p)).sum();
    }
    
   
    public double totalPedido2(Pedido p)
    {
        /* VERSIÓN CLÁSICA
        double total=0;
        for (LineaPedido l:p.getCestaCompra())
        {
            total+=(articulos.get(l.getIdArticulo()).getPvp())
                    *l.getUnidades();
        }
        return total;*/
        return p.getCestaCompra().stream().mapToDouble(l-> articulos.get(l.getIdArticulo()).getPvp()
                    *l.getUnidades()).sum();
    }    
    
    //ALTERNATIVA
    //TOTAL POR CLIENTE TODO EN UN MISMO MÉTODO, SIN NECESIDAD DE UTILIZAR totalPedido
    public double totalCliente2(Cliente c){
        return pedidos.stream().filter(p -> p.getClientePedido().equals(c))
            .mapToDouble(p -> p.getCestaCompra().stream().mapToDouble
            (lp -> lp.getUnidades() * articulos.get(lp.getIdArticulo()).getPvp()).sum()).sum();
    }
    
    
    public void listarArticulos() {
        Scanner sc=new Scanner(System.in);
        String opcion;
        do{
            System.out.println("\n\n\n\n\n\t\t\t\tLISTAR ARTICULOS\n");
            System.out.println("\t\t\t\t0 - TODOS LOS ARTICULOS");
            System.out.println("\t\t\t\t1 - PERIFERICOS");
            System.out.println("\t\t\t\t2 - ALMACENAMIENTO");
            System.out.println("\t\t\t\t3 - IMPRESORAS");
            System.out.println("\t\t\t\t4 - MONITORES");
            System.out.println("\t\t\t\t9 - SALIR");
            do
                opcion=sc.next();
            while (!opcion.matches("[0-4,9]"));
            if (opcion!="9"){
                listados(opcion);
            }
        }while (!opcion.equals("9"));
    }
    public void listados (String seccion){
        String[] secciones={"TODAS","PERIFERICOS","ALMACENAMIENTO","IMPRESORAS","MONITORES"};
        int s=Integer.parseInt(seccion);
        if (seccion.equals("0")){ 
            System.out.println("LISTADO ARTICULOS DE LA SECCION: " + secciones[s]);
            articulos.values().stream().forEach(System.out::println);
        } else{
            System.out.println("LISTADO ARTICULOS DE LA SECCION: " + secciones[s]);
            articulos.values().stream().filter(a -> a.getIdArticulo().startsWith(seccion))
                    .forEach(System.out::println);
        }
    }
    
     /* PARA HACER LISTADOS ORDENADOS TAN SOLO HAY QUE AÑADIR .sorted() al stream()
    
    Si no le pasamos argumento al sorted() Java buscará en la clase Articulo a ver si hemos 
    implementado el interface Comparable y usará el criterio que hayamos programado en el método
    public int compareTo(Articulo a)
    
    Si creamos clases Comparator propias podemos usarlas para definir nuestras propias ordenaciones
    o bien utilizar el método Comparator.comparing(predicado)
    
    También podemos cambiar el sentido de las ordenaciones con .reversed();
    
    */
       public void examenPara7yMedio(){
        ArrayList<Cliente> clientesSin = new ArrayList();
        ArrayList<Cliente> clientesCon = new ArrayList();
               
        try(BufferedWriter bfwClientesCon=new BufferedWriter(new FileWriter("clientesCon.csv"));
            BufferedWriter bfwClientesSin=new BufferedWriter(new FileWriter("clientesSin.csv"))    ){
            
            for (Cliente c : clientes.values()) {
                /* ESTILO CLÁSICO 
                boolean tienePedido = false;
                for (Pedido p : pedidos) {
                    if (p.getClientePedido() == c) {
                        tienePedido = true;
                        break;
                    }
                } 
                if (tienePedido) {
                   bfwClientesCon.write(c.getDni() + "," + c.getNombre() + "," + c.getTelefono() + "," + c.getEmail() + "\n");
                } else{
                   bfwClientesSin.write(c.getDni() + "," + c.getNombre() + "," + c.getTelefono() + "," + c.getEmail() + "\n"); clientesSin.add(c);
                }*/

                //CON STREAMS Y EL METODO anyMatch
                if (pedidos.stream().anyMatch(p-> p.getClientePedido().equals(c))){
                   bfwClientesCon.write(c.getDni() + "," + c.getNombre() + "," + c.getTelefono() + "," + c.getEmail() + "\n");
                } else{
                   bfwClientesSin.write(c.getDni() + "," + c.getNombre() + "," + c.getTelefono() + "," + c.getEmail() + "\n");
                }
            }
        }catch (FileNotFoundException e) {
                 System.out.println(e.toString());   
        }catch(IOException e){
            System.out.println(e.toString());
        }
 
        try(Scanner scClientesCon=new Scanner(new File("clientesCon.csv"))){
            while (scClientesCon.hasNextLine()){
                String [] atributos = scClientesCon.nextLine().split("[,]");                                                              
                Cliente c=new Cliente(atributos[0],atributos[1],atributos[2],atributos[3]); 
                clientesCon.add(c);
            }
        }catch(IOException e){
            System.out.println(e.toString());
        }
        
        try(Scanner scClientesSin=new Scanner(new File("clientesSin.csv"))){
            while (scClientesSin.hasNextLine()){
                String [] atributos = scClientesSin.nextLine().split("[,]");                                                              
                Cliente c=new Cliente(atributos[0],atributos[1],atributos[2],atributos[3]); 
                clientesSin.add(c);
            }
        }catch(IOException e){
            System.out.println(e.toString());
        }
        System.out.println("\nLISTADOS EXAMEN VERSIÓN 7,5 PUNTOS:");
        System.out.println("\nCLIENTES CON PEDIDOS:");
        clientesCon.forEach(System.out::println);
        System.out.println("\nCLIENTES SIN PEDIDOS:");
        clientesSin.forEach(System.out::println);
    }
    
    public void examenPara10(){
        ArrayList<Cliente> clientesSin = new ArrayList();
        ArrayList<Cliente> clientesCon = new ArrayList();
        ArrayList<Cliente> clientesMas1000 = new ArrayList();
               
        try(BufferedWriter bfwClientesCon=new BufferedWriter(new FileWriter("clientesCon.csv"));
            BufferedWriter bfwClientesSin=new BufferedWriter(new FileWriter("clientesSin.csv"));
            BufferedWriter bfwClientesMas1000=new BufferedWriter(new FileWriter("clientesMas1000.csv")))
        {
            
            for (Cliente c : clientes.values()){
                if (totalCliente(c)==0){
                    bfwClientesSin.write(c.getDni() + "," + c.getNombre() + "," + c.getTelefono() + "," + c.getEmail() + "\n");
                }else if (totalCliente(c)>=1000){
                      bfwClientesCon.write(c.getDni() + "," + c.getNombre() + "," + c.getTelefono() + "," + c.getEmail() + "\n");
                      bfwClientesMas1000.write(c.getDni() + "," + c.getNombre() + "," + c.getTelefono() + "," + c.getEmail() + "\n");
                    }else {
                       bfwClientesCon.write(c.getDni() + "," + c.getNombre() + "," + c.getTelefono() + "," + c.getEmail() + "\n");
                    }
            }
            
        }catch (FileNotFoundException e) {
                 System.out.println(e.toString());   
        }catch(IOException e){
            System.out.println(e.toString());
        }
 
        try(Scanner scClientesCon=new Scanner(new File("clientesCon.csv"))){
            while (scClientesCon.hasNextLine()){
                String [] atributos = scClientesCon.nextLine().split("[,]");                                                              
                Cliente c=new Cliente(atributos[0],atributos[1],atributos[2],atributos[3]); 
                clientesCon.add(c);
            }
        }catch(IOException e){
            System.out.println(e.toString());
        }
        
        try(Scanner scClientesSin=new Scanner(new File("clientesSin.csv"))){
            while (scClientesSin.hasNextLine()){
                String [] atributos = scClientesSin.nextLine().split("[,]");                                                              
                Cliente c=new Cliente(atributos[0],atributos[1],atributos[2],atributos[3]); 
                clientesSin.add(c);
            }
        }catch(IOException e){
            System.out.println(e.toString());
        }
        
        try(Scanner scClientesSin=new Scanner(new File("clientesMas1000.csv"))){
            while (scClientesSin.hasNextLine()){
                String [] atributos = scClientesSin.nextLine().split("[,]");                                                              
                Cliente c=new Cliente(atributos[0],atributos[1],atributos[2],atributos[3]); 
                clientesMas1000.add(c);
            }
        }catch(IOException e){
            System.out.println(e.toString());
        }
        System.out.println("\nLISTADOS EXAMEN VERSIÓN 10 PUNTOS:");
        System.out.println("\nCLIENTES CON PEDIDOS:");
        clientesCon.forEach(System.out::println);
        System.out.println("\nCLIENTES SIN PEDIDOS:");
        clientesSin.forEach(System.out::println);
        System.out.println("\nCLIENTES CON MAS DE 1000€ GASTADOS:");
        clientesMas1000.forEach(System.out::println);
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="EXAMEN 14/02">
        private void listadoSeccion() {
        String opcion;
        
        do{
            System.out.println("\n\n\n\n\n\t\t\t\tELIJA SECCION PARA VER ARTICULOS (RETURN PARA REGRESAR):\n");
            System.out.println("\t\t\t\t1 - PERIFERICOS");
            System.out.println("\t\t\t\t2 - ALMACENAMIENTO");
            System.out.println("\t\t\t\t3 - IMPRESORAS");
            System.out.println("\t\t\t\t4 - MONITORES");
            System.out.println("\t\t\t\t5 - TODAS");
            opcion=sc.next();
            if (opcion.isBlank() || !opcion.matches("[1-5]")) break;
            lista(opcion);
        }while(opcion.matches("[1-5]"));
    }

    public void lista (String seccion){
            
        String[] secciones={"","PERIFERICOS","ALMACENAMIENTO","IMPRESORAS","MONITORES","TODAS"};
        
        System.out.println("ARTICULOS DE LA SECCION: "+ secciones[Integer.parseInt(seccion)]);
        if (seccion.equals("5")){
            //Listamos todos los artículos ordenados por PRECIO
            articulos.values().stream().sorted().forEach(System.out::println);
        }else{
            //Listamos los artículos de la sección indicada ordenados por PRECIO
            articulos.values().stream().filter(a -> a.getIdArticulo().startsWith(seccion))
                          .sorted().forEach(System.out::println);
        }
    }

    private void total() {
       
       pedidos.forEach(System.out::println);
        
       System.out.println("INTRODUCE EL ID DEL PEDIDO PARA CALCULAR TOTAL: ");
       String id = sc.next();
       //buscamos el id_pedido
       int pos=-1;
       for (int i=0; i<pedidos.size();i++) {
          if (pedidos.get(i).getIdPedido().equals(id)){
              pos=i;
              break;
          }
       }
       if (pos==-1) {
           System.out.println("No se encuentra el pedido SOLICITADO");
       }else{
           double total=0;     
           System.out.println("LISTADO DE ARTICULOS PEDIDO " + id +":\n");
           for (LineaPedido lp:pedidos.get(pos).getCestaCompra()){
                Double totLinea=articulos.get(lp.getIdArticulo()).getPvp()* lp.getUnidades();
                System.out.println("\t" + articulos.get(lp.getIdArticulo()).getDescripcion()+
                   "\t" + articulos.get(lp.getIdArticulo()).getPvp() +
                   " * " + lp.getUnidades() + " Unidades  = " + totLinea +"€");
                total+= totLinea;
            }
            System.out.println("\nEL TOTAL DEL PEDIDO " + id + " ES: " + total + "€");
       }
    }
    
   
    private void listadoClientesGasto() { 
        System.out.println("CLIENTES ORDENADOS DE > a < POR TOTAL GASTADO:\n"); 
        clientes.values().stream().sorted(Comparator.comparing
        (c -> totalCliente((Cliente) c)).reversed()).forEach
        (c -> System.out.println("\t" + c + "\t\tTotal Gastado: " + totalCliente(c))); 
    } 
    
    public double totalCliente3 (Cliente c) { 
        double total = 0;
        for (Pedido p: pedidos) {
            if (p.getClientePedido().equals(c)) { 
                for (LineaPedido l : p.getCestaCompra()) { 
                    total += articulos.get(l.getIdArticulo()).getPvp() * l.getUnidades(); 
                } 
            }
        }
        return total; 
    } 
    
    private void listadoArticulosStock() {
        System.out.println("TECLEA LIMITE DE UNIDADES A COMPROBAR: ");
        int unidades=sc.nextInt();
        System.out.println("LOS SIGUIENTES ARTICULOS TIENEN MENOS DE: " + unidades + " UNIDADES DISPONIBLES");
        
        articulos.values().stream().filter(a->a.getExistencias()<unidades)
                .forEach(System.out::println);
    }
    //</editor-fold>
}
