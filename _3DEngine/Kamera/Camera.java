package _3DEngine.Kamera;

import _3DEngine.Vector.Matrix3D;
import _3DEngine.Vector.Vector3D;

public class Camera {
    private Vector3D position;
    private Vector3D target;
    private Vector3D up;

    public Camera(Vector3D position, Vector3D target, Vector3D up) {
        this.position = position;
        this.target = target;
        this.up = up;
    }

    // Diese Methode erstellt eine Blickpunkttransformation
    public Matrix3D lookAt() {
        // Vektoren für die Kameraachse berechnen
        Vector3D zAxis = position.subtract(target).normalize(); // Die Kamera sieht entlang der negativen Z-Achse
        Vector3D xAxis = up.cross(zAxis).normalize();
        Vector3D yAxis = zAxis.cross(xAxis).normalize();

        // Blickpunkttransformation erstellen
        Matrix3D viewMatrix = Matrix3D.identity();
        viewMatrix.m[0][0] = xAxis.x;
        viewMatrix.m[0][1] = xAxis.y;
        viewMatrix.m[0][2] = xAxis.z;
        viewMatrix.m[1][0] = yAxis.x;
        viewMatrix.m[1][1] = yAxis.y;
        viewMatrix.m[1][2] = yAxis.z;
        viewMatrix.m[2][0] = zAxis.x;
        viewMatrix.m[2][1] = zAxis.y;
        viewMatrix.m[2][2] = zAxis.z;
        viewMatrix.m[0][3] = -xAxis.dot(position);
        viewMatrix.m[1][3] = -yAxis.dot(position);
        viewMatrix.m[2][3] = -zAxis.dot(position);

        return viewMatrix;
    }

    // Weitere Kamera-bezogene Methoden könnten hier hinzugefügt werden...
}

