import java.util.Random;
import java.util.Scanner;

public class ListaEnlazadaNumeros {

    class Nodo {

        int info;
        Nodo sig;
    }

    private Nodo raiz;

    public ListaEnlazadaNumeros() {

        raiz = null;
    }

    // INSERTAR AL FINAL
    public void insertar(int x) {

        Nodo nuevo = new Nodo();

        nuevo.info = x;
        nuevo.sig = null;

        if(raiz == null) {

            raiz = nuevo;

        } else {

            Nodo reco = raiz;

            while(reco.sig != null) {

                reco = reco.sig;
            }

            reco.sig = nuevo;
        }
    }

    // GENERAR NUMEROS ALEATORIOS
    public void generarLista(int cantidad) {

        Random r = new Random();

        for(int i = 0; i < cantidad; i++) {

            int numero = r.nextInt(100) + 1;

            insertar(numero);
        }
    }

    // MOSTRAR LISTA
    public void imprimir() {

        Nodo reco = raiz;

        while(reco != null) {

            System.out.print(reco.info + " -> ");

            reco = reco.sig;
        }

        System.out.println("null");
    }

    // ELIMINAR MAYORES
    public void eliminarMayores(int valor) {

        while(raiz != null && raiz.info > valor) {

            raiz = raiz.sig;
        }

        Nodo reco = raiz;

        while(reco != null && reco.sig != null) {

            if(reco.sig.info > valor) {

                reco.sig = reco.sig.sig;

            } else {

                reco = reco.sig;
            }
        }
    }

    public static void main(String[] ar) {

        Scanner entrada = new Scanner(System.in);

        ListaEnlazadaNumeros lista =
                new ListaEnlazadaNumeros();

        System.out.print(
        "Cuantos numeros desea generar?: ");

        int cantidad = entrada.nextInt();

        lista.generarLista(cantidad);

        System.out.println("\nLista original:");

        lista.imprimir();

        System.out.print(
        "\nEliminar numeros mayores a: ");

        int valor = entrada.nextInt();

        lista.eliminarMayores(valor);

        System.out.println(
        "\nLista final:");

        lista.imprimir();
    }
}