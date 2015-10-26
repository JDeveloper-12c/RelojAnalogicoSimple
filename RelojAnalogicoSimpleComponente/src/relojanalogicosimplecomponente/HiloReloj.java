package relojanalogicosimplecomponente;
/**
 * Reloj del sistema 
 * @author Mtr. Carlos Alberto Privitera
 * @version 1.0
 */
public class HiloReloj extends Thread {
    /**
     * Constructor
     */
    public HiloReloj() {
        super();
    }
    Escuchador escuchador;
    /**
     * Método que instala el escuchador externo
     * @param escuchador Instala el escuchador externo para avisarle la hora
     */
    public void setVisor(Escuchador escuchador){
        this.escuchador=escuchador;
    }
    /**
     * Método run() que lanza el escuchador externo cada 500ms
     */
    public void run() {
        super.run();
        do {
            try {
                escuchador.lanzador();
                this.sleep(500);
            } catch (InterruptedException e) {
            } catch (Exception e){
            }
        }while(true);
    }
}
