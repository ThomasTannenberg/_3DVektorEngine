import _3DEngine.Vector.Matrix3D;
import _3DEngine.Vector.Vector3D;

public class Main {
    public static void main(String[] args) {
        Vector3D vektor = new Vector3D(1, 1, 1); // Ein Vektor zum Transformieren
        Matrix3D scaleMatrix = Matrix3D.scale(2, 2, 2); // Verdoppelt die Größe in allen Richtungen
        Matrix3D rotateMatrix = Matrix3D.rotateX((float)Math.PI / 2); // Rotiert um 90 Grad um die X-Achse
        Matrix3D translateMatrix = Matrix3D.translate(3, 3, 3); // Verschiebt um 3 Einheiten in allen Richtungen

        // Kombiniert die Transformationen durch Matrixmultiplikation, wobei die Reihenfolge wichtig ist
        Matrix3D transformation = translateMatrix.multiply(rotateMatrix).multiply(scaleMatrix);

        // Wenden Sie die Transformation auf den Vektor an
        Vector3D transformedVector = transformation.transform(vektor);

        System.out.println("Transformierter Vektor: " + transformedVector);
    }
}