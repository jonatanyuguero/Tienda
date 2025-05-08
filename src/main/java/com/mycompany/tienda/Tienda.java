/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.tienda;

import java.time.LocalDate;
import java.util.ArrayList;
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
    }

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

    }

    private void listadoPedidos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void pedidosPorImporteBackup() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void leerPedidosPorImporte() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void nuevoArticulo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void modificarArticulo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void eliminarArticulo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void listadoArticulos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void reponerArticulos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void backupPorSeccion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void nuevoCliente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void modificarCliente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void eliminarCliente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void listadoClientes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void clientesTxtBackup() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void clientesTxtLeer() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

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
}
