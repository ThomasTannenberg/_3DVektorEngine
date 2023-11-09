package _3DEngine;
import _3DEngine.Vector.Vector3D;
import _3DEngine.Vector.Matrix3D;

public class Engine {
    public Vector3D transformVector(Vector3D v, Matrix3D m) {
        return m.transform(v);
    }

    // Hier könnten wir Methoden hinzufügen, die komplexe Szenen-Transformationen handhaben,
    // wie das Anwenden einer Reihe von Transformationen auf eine Gruppe von Vektoren (ein 3D-Objekt).
}
