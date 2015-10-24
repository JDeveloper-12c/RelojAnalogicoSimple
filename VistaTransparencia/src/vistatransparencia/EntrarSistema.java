package vistatransparencia;


public class EntrarSistema {
    public EntrarSistema() {
        super();
    }
    private static VentanaPrincipal vp = new VentanaPrincipal();
    public static void main(String[] args) {
        EntrarSistema entrarSistema = new EntrarSistema();
        vp.setDefaultCloseOperation(vp.EXIT_ON_CLOSE);
        vp.setVisible(true);
    }
}
