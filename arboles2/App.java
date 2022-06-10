import java.util.Scanner;

public class App {


    public static void main(String[] args) {

        Arbol arbol = new Arbol();
        int control = 1;
        // String instrumento;
        Scanner input = new Scanner(System.in);
        int dni;
        System.out.println("Hola bienvenido, este programa funciona para ingresar sus dni");
        do {

            System.out.println("1 - Insertar nodo");
            System.out.println("2 - Recorrer arbol");
            System.out.println("3 - Eliminar nodo");
            System.out.println("0 - Salir");
            int menu = input.nextInt();
            System.out.print("\033[H\033[2J");
            System.out.flush();

            switch (menu) {
                case 1:

                    // System.out.println("Ingrese el DNI");
                    // dni = input.nextInt();
                    // System.out.println(" ");

                    /// While para controlar el ingreso de datos
                    // while (dni > 99999999 || dni < 10000000) {
                    // System.out.println("El numero no corresponde, ingrese otro");
                    // dni = input.nextInt();
                    // }
                    // arbol.Insertar(dni);
                    // System.out.println("su DNI es " + dni);

                    // Yo le ingrese valores para ir probando
                    arbol.Insertar(40304367);
                    arbol.Insertar(41695013);
                    arbol.Insertar(44722387);
                    arbol.Insertar(42217895);
                    arbol.Insertar(45179739);

                    System.out.println("Se han insertado de manera correcta!");
                    break;

                case 2:
                    // recorrer arbol
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("1 - En orden");
                    System.out.println("2 - Pre orden");
                    System.out.println("3 - Post orden");
                    int menu2 = input.nextInt();

                    // While para controlar q no ingrese > 3 o < 1
                    while (menu2 > 3 || menu2 < 1) {
                        System.out.println("El numero no corresponde, ingresa otro");
                        System.out.println("1 - En orden");
                        System.out.println("2 - Pre orden");
                        System.out.println("3 - Post orden");
                        menu2 = input.nextInt();
                    }

                    switch (menu2) {
                        case 1:
                            arbol.recorrerEnOrden(arbol.raiz);
                            break;

                        case 2:
                            arbol.recorrerPreOrden(arbol.raiz);
                            break;

                        case 3:
                            arbol.recorrerEnOrden(arbol.raiz);
                            break;

                        case 0:
                            break;
                    }

                    break;

                case 3:
                    // Eliminar nodo
                    System.out.println("Ingrese el dni del nodo q desea eliminar");
                    int clave = input.nextInt();

                    // While para controlar el ingreso de datos
                    while (clave > 99999999 || clave < 10000000) {
                        System.out.println("El numero no corresponde, ingrese otro");
                        clave = input.nextInt();
                    }

                    arbol.eliminar(arbol.raiz, clave);
                    System.out.println("Se ha eliminado de manera correcta!");
                    break;

                case 0:
                    System.out.println("El programa ha finalizado");
                    control = control - 1;
                    break;
            }

        } while (control != 0);

    }
}
