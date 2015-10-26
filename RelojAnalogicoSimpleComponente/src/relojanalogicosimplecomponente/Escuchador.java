package relojanalogicosimplecomponente;
/**
 * Esta clase define la interfaz para instalar un escuchador que el reloj lanzará
 * más tarde para notificar el cambio de hora a la intefaz gráfica
 * @author Mtr. Carlos Alberto Privitera
 * @see <a href="https://github.com/carlosprivitera/RelojAnalogicoSimple"> Proyecto OpenSource GitHub: RelojAnalogicoSimple </a>
 */
public abstract class Escuchador {
    /**
     * Constructor de la clase Escuchador
     */

    public Escuchador() {
        super();
    }

    /**
     * Método a sobre escribir en la sub clase que implemente la clase Escuchador
     */
    public abstract void lanzador();
}
