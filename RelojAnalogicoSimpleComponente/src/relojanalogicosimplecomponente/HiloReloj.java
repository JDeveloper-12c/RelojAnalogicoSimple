package relojanalogicosimplecomponente;

public class HiloReloj extends Thread {
    public HiloReloj() {
        super();
    }
    Escuchador escuchador;

    public void setVisor(Escuchador escuchador){
        this.escuchador=escuchador;
    }
    public void run() {
        super.run();
        do {
            try {
                escuchador.lanzador();
                this.sleep(500);
            } catch (InterruptedException e) {
            }
        }while(true);
    }
}
