import java.security.PublicKey;

//import javax.lang.model.util.ElementScanner14;

public class Arbol {
    Nodo raiz;

    // constructor para inicializar en null
    public Arbol() {
        this.raiz = null;
    }

    // Procedimiento para insertar nodos, pasandole el indice y el contenido
    public void Insertar(int dni) {

        Nodo n = new Nodo();
        n.contenido = dni; // asigna a el contenido del nodo el dni

        if (raiz == null) {
            raiz = n; // si la raiz es null, asigna el nuevo nodo como raiz
        } else {
            Nodo aux = raiz; // sino crea un aux q va a ser la raiz
            while (aux != null) {
                n.padre = aux; // si tiene algo va a ser padre
                if (n.contenido >= aux.contenido) {
                    aux = aux.derecha; // si el indice del nodo nuevo es > al del aux, el aux va a la derecha
                } else {
                    aux = aux.izquierda; // sino va a a la izquierda
                }
            }

            if (n.contenido < n.padre.contenido) { // si el indice del nodo nuevo es menor al del padre
                // el padre de la izquierda va a ser el nodo nuevo.
                n.padre.izquierda = n;
            } else {
                n.padre.derecha = n; // sino va a la derecha
            }
        }

    }

    // procedimiento para comparar cual es mas grande
    public int comparar(Object elemento1, Object elemento2) {
        if (elemento1 instanceof Integer && elemento2 instanceof Integer) { // verifica q sean enteros
            if ((Integer) elemento1 < (Integer) elemento2) { // si el elemento1 es menor al 2, retorna -1
                return -1;
            } else if ((Integer) elemento1 > (Integer) elemento2) {// si el elemento1 es mayor al 2, retorna 1
                return 1;
            }
        }
        return 0;
    }

    // procedimiento para ver si tiene sucesor
    public Nodo sucesor(Nodo nodo) {
        if (nodo.izquierda != null) {
            return sucesor(nodo.izquierda);
        }
        return nodo;
    }

    public Nodo eliminar(Nodo nodo, Object dni) {
        if (nodo != null) {
            if (dni.equals(nodo.contenido)) {

                if (nodo.izquierda == null && nodo.derecha == null) { // si nodo izq es null y der null, retorna raiz
                    return nodo = null;

                } else {

                    if (nodo.izquierda == null && nodo.derecha != null) { // si izq es null, y der NO es null
                        return nodo = nodo.derecha;// nodo= nodo.derecha
                    } else // sino

                    if (nodo.izquierda != null && nodo.derecha == null) { // si izq no es null, y der es null
                        return nodo = nodo.izquierda; // nodo = nodo.izquierda
                    } else if (nodo.izquierda != null && nodo.derecha != null) { // si izq no es null y der no es null
                        Nodo der = nodo.derecha; // der = derecha;
                        Nodo temp = sucesor(der); // temp = sucesor(der)

                        temp.izquierda = nodo.izquierda; // izq del temporal = izquierda
                        return temp; // retorna el temporal.
                    }
                }
            }

        }

        // procedimiento para comparar los dni
        if (comparar(dni, nodo.contenido) < 0) { // si el dni y contenido del nodo q se quiere borrar es < 0
            nodo.izquierda = eliminar(nodo.izquierda, dni); // se borraria el izquierdo
        } else { // sino
            nodo.derecha = eliminar(nodo.derecha, dni); // se borra el derecho
        }
        return nodo; // retorna el nodo.
    }

    // RECORRER POSTORDEN
    public void recorrerEnOrden(Nodo n) {
        if (n != null) {
            recorrerEnOrden(n.izquierda); // primero recorre izquierda
            System.out.println("Su DNI es: " + n.contenido); // recorre raiz
            recorrerEnOrden(n.derecha); // recorre derecha
        }
    }

    // RECORRER PREORDEN
    public void recorrerPreOrden(Nodo n) {
        if (n != null) {
            System.out.println("Su DNI es: " + n.contenido); // recorre raiz
            recorrerPreOrden(n.izquierda); // recorre izquierda
            recorrerPreOrden(n.derecha); // recorre derecha
        }
    }

    // RECORRER ENORDEN
    public void recorrerPostOrden(Nodo n) {
        if (n != null) {
            recorrerPostOrden(n.izquierda); // recorre izquierda
            recorrerPostOrden(n.derecha); // recorre derecha
            System.out.println("Su DNI es: " + n.contenido); // recorre raiz
        }
    }

    // Class del tipo nodo
    public class Nodo {
        public Nodo padre;
        public Nodo izquierda;
        public Nodo derecha;
        public int contenido;

        // Constructor de nodo para inicializar las variables.
        public Nodo() {
            derecha = null;
            izquierda = null;
            padre = null;
            contenido = 0;
        }

    }

}