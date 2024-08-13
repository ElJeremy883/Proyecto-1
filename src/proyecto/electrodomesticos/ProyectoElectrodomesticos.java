package proyecto.electrodomesticos;

import java.util.Scanner;

public class ProyectoElectrodomesticos {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Scanner entrada = new Scanner(System.in);
        Atributos datos[] = new Atributos[15];

        int op = 0;
        while (op != 5) {
            System.out.println("-----------TIENDA DE ELECTRODOMESTICOS-------------");
            System.out.println("1. Guardar");
            System.out.println("2. Buscar individual ");
            System.out.println("3. Ver todos");
            System.out.println("4. Modificar");
            System.out.println("5. Salir");
            System.out.println("Ingrese el numero de opcion ");
            op = teclado.nextInt();

            if (op == 1) {
                System.out.println("Ingrese el codigo del electrodomestico");
                int codigo = teclado.nextInt();
                System.out.println("Ingrese el nombre del electrodomestico");
                String nombre = entrada.next().toLowerCase();
                System.out.println("Ingrese la marca del electrodomestico");
                String marca = entrada.next().toLowerCase();
                System.out.println(NuevoElec(codigo, nombre, marca, datos));
            } else if (op == 2) {
                System.out.println("Ingrese el codigo del electrodomestico");
                int codigo = teclado.nextInt();
                System.out.println(BuscarElec(codigo, datos));
            } else if (op == 3) {
                System.out.println(VerTodo(datos));
            } else if (op == 4) {
                System.out.println("Ingrese el codigo del electrodomestico");
                int codigo = teclado.nextInt();
                if (ModElec(codigo, datos)) {
                    System.out.println("Ingrese el nuevo nombre del electrodomestico");
                    String nombre = entrada.next().toLowerCase();
                    System.out.println("Ingrese la nueva marca del electrodomestico");
                    String marca = entrada.next().toLowerCase();
                    System.out.println(ModAtri(codigo, nombre, marca, datos));
                } else {
                    System.out.println("Codigo innexistente");
                }

            }
        }
        System.out.println("-----Programa finalizado-----");
    }

    public static String NuevoElec(int codigo, String nombre, String marca, Atributos arreglo[]) {
        boolean lleno = true;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == null) {
                arreglo[i] = new Atributos(codigo, nombre, marca);
                lleno = false;
                break;
            } else if (arreglo[i].getCodigo() == codigo) {
                return "Codigo existente";
            }
        }
        if (!lleno) {
            return "Guardado con exito";
        } else {
            return "Espacio insuficiente";
        }
    }

    public static String BuscarElec(int codigo, Atributos arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getCodigo() == codigo) {
                return "----- DATOS ----- \nNombre: " + arreglo[i].getNombre() + "\n" + "Marca: " + arreglo[i].getMarca();
            }
        }
        return "Codigo innexistente";
    }

    public static boolean ModElec(int codigo, Atributos arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public static String VerTodo(Atributos arreglo[]) {
        String cadena = "";
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null) {
                cadena = cadena + "Codigo: " + arreglo[i].getCodigo() + "\n" + "Nombre: " + arreglo[i].getNombre() + "\n" + "Marca: " + arreglo[i].getMarca() + "\n";
            }
        }
        return cadena;
    }

    public static String ModAtri(int codigo, String nombre, String marca, Atributos arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getCodigo() == codigo) {
                arreglo[i].setNombre(nombre);
                arreglo[i].setMarca(marca);
                return "Modificado con exito";
            }
        }
        return "";
    }
}
