import _3DEngine.Vector.Vector3D;

public class Main {
    public static void main(String[] args) {
        Vector3D vektor = new Vector3D(1, 0, 0); // Erstellt einen neuen Vektor entlang der x-Achse
        Vector3D achse = new Vector3D(0, 0, 1); // Die Rotationsachse (z-Achse)

        float winkelInGrad = 90; // Winkel der Rotation
        float winkelInRadianten = (float)Math.toRadians(winkelInGrad); // Umwandlung von Grad in Radianten

        Vector3D rotierterVektor = vektor.rotate(achse, winkelInRadianten);

        System.out.println("Originalvektor: " + vektor);
        System.out.println("Rotierter Vektor: " + rotierterVektor);
    }
}