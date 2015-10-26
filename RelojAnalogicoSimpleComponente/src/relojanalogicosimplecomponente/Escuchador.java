package relojanalogicosimplecomponente;
/**
 * Esta clase define la interfaz para instalar un escuchador que el reloj lanzar�
 * m�s tarde para notificar el cambio de hora a la intefaz gr�fica
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
     * M�todo a sobre escribir en la sub clase que implemente la clase Escuchador
     */
    public abstract void lanzador();
}
