package _3DEngine.Vector;

public class Matrix3D {
    // Ein 4x4-Array für die Matrix-Darstellung
    private float[][] m;

    public Matrix3D() {
        m = new float[4][4];
    }


    // Erstellt und gibt eine Einheitsmatrix zurück
    public static Matrix3D identity() {
        Matrix3D matrix = new Matrix3D();
        for (int i = 0; i < 4; i++) {
            matrix.m[i][i] = 1;
        }
        return matrix;
    }

    // Multipliziert die Matrix mit einem anderen Matrix3D-Objekt
    public Matrix3D multiply(Matrix3D matrix) {
        Matrix3D result = new Matrix3D();
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                for (int i = 0; i < 4; i++) {
                    result.m[row][col] += this.m[row][i] * matrix.m[i][col];
                }
            }
        }
        return result;
    }

    // Multipliziert die Matrix mit einem Vector3D-Objekt
    public Vector3D transform(Vector3D v) {
        return new Vector3D(
                m[0][0] * v.x + m[0][1] * v.y + m[0][2] * v.z + m[0][3],
                m[1][0] * v.x + m[1][1] * v.y + m[1][2] * v.z + m[1][3],
                m[2][0] * v.x + m[2][1] * v.y + m[2][2] * v.z + m[2][3]
        );
    }

    // Erstellt eine Skalierungsmatrix
    public static Matrix3D scale(float sx, float sy, float sz) {
        Matrix3D result = Matrix3D.identity();
        result.m[0][0] = sx;
        result.m[1][1] = sy;
        result.m[2][2] = sz;
        return result;
    }

    // Erstellt eine Translationsmatrix
    public static Matrix3D translate(float tx, float ty, float tz) {
        Matrix3D result = Matrix3D.identity();
        result.m[0][3] = tx;
        result.m[1][3] = ty;
        result.m[2][3] = tz;
        return result;
    }

    // Erstellt eine Rotationsmatrix um die X-Achse
    public static Matrix3D rotateX(float angle) {
        Matrix3D result = Matrix3D.identity();
        float cosTheta = (float)Math.cos(angle);
        float sinTheta = (float)Math.sin(angle);

        result.m[1][1] = cosTheta;
        result.m[1][2] = -sinTheta;
        result.m[2][1] = sinTheta;
        result.m[2][2] = cosTheta;

        return result;
    }
}

