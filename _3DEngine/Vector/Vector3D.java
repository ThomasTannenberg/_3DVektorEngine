package _3DEngine.Vector;

public class Vector3D {

    public float x, y, z;

    public Vector3D(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D add (Vector3D v) {
        return new Vector3D(this.x + v.x, this.y + v.y, this.z + v.z);
    }

    public Vector3D sub (Vector3D v) {
        return new Vector3D(this.x - v.x, this.y - v.y, this.z - v.z);
    }

    public Vector3D scale(float scalar) {
        return new Vector3D(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    public double dot(Vector3D v) {
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }


    public Vector3D cross(Vector3D v) {
        return new Vector3D(this.y * v.z - this.z * v.y,
                this.z * v.x - this.x * v.z,
                this.x * v.y - this.y * v.x);

    }

    public Vector3D rotateZ (float angle) {
        float cosTheta = (float) Math.cos(angle);
        float sinTheta = (float) Math.sin(angle);
        return new Vector3D(
                x * cosTheta - y * sinTheta,
                x * sinTheta + y * cosTheta,
                z
        );
    }

    public Vector3D rotate(Vector3D axis, float angle) {
        float cosTheta = (float)Math.cos(angle);
        float sinTheta = (float)Math.sin(angle);
        float oneMinusCosTheta = 1.0f - cosTheta;

        Vector3D normalizedAxis = axis.normalize(); // Eine Methode, die den Vektor normalisiert, müssen wir noch implementieren.

        // Berechnung der Rotationsmatrix-Komponenten
        float xx = normalizedAxis.x * normalizedAxis.x;
        float yy = normalizedAxis.y * normalizedAxis.y;
        float zz = normalizedAxis.z * normalizedAxis.z;
        float xy = normalizedAxis.x * normalizedAxis.y;
        float xz = normalizedAxis.x * normalizedAxis.z;
        float yz = normalizedAxis.y * normalizedAxis.z;

        // Anwenden der Rotationsmatrix auf den Vektor
        return new Vector3D(
                x * (xx * oneMinusCosTheta + cosTheta) + y * (xy * oneMinusCosTheta - normalizedAxis.z * sinTheta) + z * (xz * oneMinusCosTheta + normalizedAxis.y * sinTheta),
                x * (xy * oneMinusCosTheta + normalizedAxis.z * sinTheta) + y * (yy * oneMinusCosTheta + cosTheta) + z * (yz * oneMinusCosTheta - normalizedAxis.x * sinTheta),
                x * (xz * oneMinusCosTheta - normalizedAxis.y * sinTheta) + y * (yz * oneMinusCosTheta + normalizedAxis.x * sinTheta) + z * (zz * oneMinusCosTheta + cosTheta)
        );
    }

    // Eine Methode, um den Vektor zu normalisieren
    public Vector3D normalize() {
        float length = (float)Math.sqrt(x * x + y * y + z * z);
        return new Vector3D(x / length, y / length, z / length);
    }

    public Vector3D subtract(Vector3D v) {
        return new Vector3D(this.x - v.x, this.y - v.y, this.z - v.z);
    }


    // Methode zur Ausgabe des Vektors als String, für Debugging Zwecke!!!
    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
