package ele32_lab3;

public class Matematica {
	
	public static byte[][] multiplicarComXor(byte[][] A, byte[][] B) {

        int aRows = A.length;
        int aColumns = A[0].length;
        int bRows = B.length;
        int bColumns = B[0].length;

        if (aColumns != bRows) {
            throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
        }

        byte[][] C = new byte[aRows][bColumns];
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bColumns; j++) {
                C[i][j] = 0;
            }
        }

        for (int i = 0; i < aRows; i++) { // aRow
            for (int j = 0; j < bColumns; j++) { // bColumn
                for (int k = 0; k < aColumns; k++) { // aColumn
                    C[i][j] = (byte) ((C[i][j] + A[i][k] * B[k][j])%2);
                }
            }
        }

        return C;
    }
	
	public static byte[] multiplicarVetorComXor(byte[] A, byte[][] B) {

        int aColumns = A.length;
        int bRows = B.length;
        int bColumns = B[0].length;

        if (aColumns != bRows) {
            throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
        }

        byte[] C = new byte[bColumns];
        for (int j = 0; j < bColumns; j++) {
            C[j] = 0;
        }

        for (int j = 0; j < bColumns; j++) { // bColumn
            for (int k = 0; k < aColumns; k++) { // aColumn
                C[j] = (byte) ((C[j] + A[k] * B[k][j])%2);
            }
        }

        return C;
    }
	
	
}
