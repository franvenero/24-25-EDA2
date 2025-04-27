
import java.util.ArrayList;
import java.util.List;

public class BuscadorBinario {
    private IndiceOrdenado indice;

    public BuscadorBinario(IndiceOrdenado indice) {
        this.indice = indice;
    }

    public int[] buscarRango(String valorInicial, String valorFinal) {

        if (indice.esDescendente()) {
            String temp = valorInicial;
            valorInicial = valorFinal;
            valorFinal = temp;
        }

        int inicio = buscarIndiceInicial(valorInicial);
        if (inicio == -1) {
            return new int[0];
        }

        int fin = buscarIndiceFinal(valorFinal);
        if (fin == -1 || fin < inicio) {
            return new int[0];
        }

        List<Integer> posicionesList = new ArrayList<>();
        for (int i = inicio; i <= fin; i++) {
            int[] posicionesValor = indice.buscarPorIndice(i);
            for (int pos : posicionesValor) {
                posicionesList.add(pos);
            }
        }

        int[] posiciones = new int[posicionesList.size()];
        for (int i = 0; i < posicionesList.size(); i++) {
            posiciones[i] = posicionesList.get(i);
        }

        return posiciones;
    }

    private int buscarIndiceInicial(String valor) {
        int inicio = 0;
        int fin = indice.getCantidadValores() - 1;
        int resultado = -1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            int comparacion = indice.getValor(medio).compareTo(valor);

            if (indice.esDescendente()) {
                comparacion = -comparacion;
            }

            if (comparacion < 0) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
                resultado = medio;
            }
        }

        if (resultado == -1) {
            return 0;
        }

        return resultado;
    }

    private int buscarIndiceFinal(String valor) {
        int inicio = 0;
        int fin = indice.getCantidadValores() - 1;
        int resultado = -1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            int comparacion = indice.getValor(medio).compareTo(valor);

            if (indice.esDescendente()) {
                comparacion = -comparacion;
            }

            if (comparacion <= 0) {
                inicio = medio + 1;
                resultado = medio;
            } else {
                fin = medio - 1;
            }
        }

        if (resultado == -1) {
            return indice.getCantidadValores() - 1;
        }

        return resultado;
    }
}