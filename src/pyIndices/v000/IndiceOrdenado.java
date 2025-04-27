
public class IndiceOrdenado extends Indice {
    private boolean descendente;

    public IndiceOrdenado(int capacidadMaxima, AlgoritmoOrdenacion algoritmoOrdenacion, boolean descendente) {
        super(capacidadMaxima, algoritmoOrdenacion);
        this.descendente = descendente;
    }

    @Override
    public void agregar(String valor, int posicion) {

        super.agregar(valor, posicion);
    }

    @Override
    protected void ordenar() {

        super.ordenar();

        if (descendente) {
            invertirOrden();
        }
    }

    private void invertirOrden() {
        int inicio = 0;
        int fin = getCantidadValores() - 1;

        while (inicio < fin) {
            intercambiarValores(inicio, fin);
            inicio++;
            fin--;
        }
    }

    private void intercambiarValores(int i, int j) {

        String tempValor = getValor(i);
        setValor(i, getValor(j));
        setValor(j, tempValor);

        int[] tempPosiciones = getPosiciones(i);
        setPosiciones(i, getPosiciones(j));
        setPosiciones(j, tempPosiciones);

        int tempContador = getContador(i);
        setContador(i, getContador(j));
        setContador(j, tempContador);
    }

    public boolean esDescendente() {
        return descendente;
    }

    public String getValorMinimo() {
        if (getCantidadValores() == 0)
            return null;
        return descendente ? getValor(getCantidadValores() - 1) : getValor(0);
    }

    public String getValorMaximo() {
        if (getCantidadValores() == 0)
            return null;
        return descendente ? getValor(0) : getValor(getCantidadValores() - 1);
    }
}