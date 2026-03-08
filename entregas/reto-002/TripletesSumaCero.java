import java.util.ArrayList;

public class TripletesSumaCero {
    public static void main(String[] args) {
        int[] numeros = { -1, 0, 1, 2, -1, -4 };
        int[][] resultado = encontrarTripletes(numeros);

        System.out.println("Tripletes que suman cero:");
        for (int[] triplete : resultado) {
            System.out.println("[" + triplete[0] + "," + triplete[1] + "," + triplete[2] + "]");
        }
    }

    public static int[][] encontrarTripletes(int[] nums) {
        int n = nums.length;
        
        ArrayList<int[]> listaResultados = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        int[] triplete = { nums[i], nums[j], nums[k] };
                        ordenarTriplete(triplete);

                        if (!esDuplicado(triplete, listaResultados)) {
                            listaResultados.add(triplete); 
                        }
                    }
                }
            }
        }

        return listaResultados.toArray(new int[0][]);
    }

    private static void ordenarTriplete(int[] triplete) {
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (triplete[i] > triplete[j]) {
                    int temp = triplete[i];
                    triplete[i] = triplete[j];
                    triplete[j] = temp;
                }
            }
        }
    }

    private static boolean esDuplicado(int[] candidato, ArrayList<int[]> resultados) {
        for (int[] existente : resultados) {
            if (existente[0] == candidato[0] && existente[1] == candidato[1] && existente[2] == candidato[2]) {
                return true;
            }
        }
        return false;
    }
}