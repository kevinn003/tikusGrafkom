package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_TRIANGLE_FAN;

public class Sphere extends Circle {
    float radiusZ;
    int sectorCount;
    int stackCount;

    public Sphere(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices,
                  Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ, int sectorCount, int stackCount, int choose) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;
        this.sectorCount = sectorCount;
        this.stackCount = stackCount;

        if (choose == 1)
            createBox();
        if (choose == 2)
            createSphere();
        if (choose == 3)
            createEllipsoid();
        if (choose == 4)
            createHyperBoloid1Side();
        if (choose == 5)
            createHyperBoloid2Side();
        if (choose == 6)
            createEllipticCone();
        if (choose == 7)
            createEllipticParaboloid();
        if (choose == 8)
            createHyperboloidParaboloid();
        if (choose == 9)
            createSphereTemp();
        setupVAOVBO();
    }

    public void createBox() {
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        //object 3d kotak
        //TITIK 1
        temp.x = centerPoint.get(0) - radiusX / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 2
        temp.x = centerPoint.get(0) + radiusX / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 3
        temp.x = centerPoint.get(0) + radiusX / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 4
        temp.x = centerPoint.get(0) - radiusX / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 5
        temp.x = centerPoint.get(0) - radiusX / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 6
        temp.x = centerPoint.get(0) + radiusX / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 7
        temp.x = centerPoint.get(0) + radiusX / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 8
        temp.x = centerPoint.get(0) - radiusX / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();

        vertices.clear();
        //kotak di sisi belakang
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));

        //kotak di sisi depan
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));

        //kotak di sisi kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));

        //kotak di sisi kanan
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));

        //kotak di sisi atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));

        //kotak di sisi bawah
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
    }

//    public void draw() {
//        drawSetup();
//
//        //Draw the vertices
//        //optional
//        glLineWidth(1); //ketebalan garis
//        glPointSize(0); //besar kecil vertex
//
//        //wajib
//        //GL_LINES, GL_LINE_STRIP, GL_LINE_LOOP, GL_TRIANGLES, GL_TRIANGLES_FAN, GL_POINT -> YG SERING DIPAKAI
//        //GL_POLYGON -> alternatif buat kotak
//        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
//    }

    public void createSphere() {
        float pi = (float) Math.PI;
        float sectorStep = 2 * (float) Math.PI / sectorCount;
        float stackStep = (float) Math.PI / stackCount;
        float sectorAngle, StackAngle, x, y, z;
        for (int i = 0; i <= stackCount; ++i) {
            StackAngle = pi / 2 - i * stackStep;
            x = radiusX * (float) Math.cos(StackAngle);
            y = radiusY * (float) Math.cos(StackAngle);
            z = radiusZ * (float) Math.sin(StackAngle);

            for (int j = 0; j <= sectorCount; ++j) {
                sectorAngle = j * sectorStep;
                Vector3f temp_vector = new Vector3f();
                temp_vector.x = centerPoint.get(0) + x * (float) Math.cos(sectorAngle);
                temp_vector.y = centerPoint.get(1) + y * (float) Math.sin(sectorAngle);
                temp_vector.z = centerPoint.get(2) + z;
                vertices.add(temp_vector);
            }
        }
    }

    public void createSphereTemp() {
        float pi = (float) Math.PI;
        float sectorStep = (float) Math.PI / sectorCount;
        float stackStep = (float) Math.PI / stackCount;
        float sectorAngle, StackAngle, x, y, z;
        for (int i = 0; i <= stackCount; ++i) {
            StackAngle = pi / 2 - i * stackStep;
            x = radiusX * (float) Math.cos(StackAngle);
            y = radiusY * (float) Math.cos(StackAngle);
            z = radiusZ * (float) Math.sin(StackAngle);

            for (int j = 0; j <= sectorCount; ++j) {
                sectorAngle = j * sectorStep;
                Vector3f temp_vector = new Vector3f();
                temp_vector.x = centerPoint.get(0) + x * (float) Math.cos(sectorAngle);
                temp_vector.y = centerPoint.get(1) + y * (float) Math.sin(sectorAngle);
                temp_vector.z = centerPoint.get(2) + z;
                vertices.add(temp_vector);
            }
        }
    }

    public void createEllipsoid() {
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 60) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 60) {
                float x = radiusX * (float) (Math.cos(v) * Math.cos(u));
                float y = radiusY * (float) (Math.cos(v) * Math.sin(u));
                float z = radiusZ * (float) (Math.sin(v));
                temp.add(new Vector3f(x, z, y));
            }
        }
        vertices.clear();
        vertices.addAll(temp);
        setupVAOVBO();
    }

    public void createHyperBoloid1Side() {
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 60) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 60) {
                float x = radiusX * (float) ((1 / Math.cos(v)) * Math.cos(u));
                float y = radiusY * (float) ((1 / Math.cos(v)) * Math.sin(u));
                float z = radiusZ * (float) (Math.tan(v));
                temp.add(new Vector3f(x, z, y));
            }
        }
        vertices.clear();
        vertices.addAll(temp);
        setupVAOVBO();
    }

    public void createHyperBoloid2Side() {
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 60) {
            for (double u = -Math.PI / 2; u <= Math.PI / 2; u += Math.PI / 60) {
                float x = radiusX * (float) (Math.tan(v) * Math.cos(u));
                float y = radiusY * (float) (Math.tan(v) * Math.sin(u));
                float z = radiusZ * (float) (1 / Math.cos(v));
                temp.add(new Vector3f(x, z, y));
            }
            for (double u = Math.PI / 2; u <= 3 * Math.PI / 2; u += Math.PI / 60) {
                float x = radiusX * (float) (Math.tan(v) * Math.cos(u));
                float y = radiusY * (float) (Math.tan(v) * Math.sin(u));
                float z = radiusZ * (float) (1 / Math.cos(v));
                temp.add(new Vector3f(x, z, y));
            }
        }
        vertices.clear();
        vertices.addAll(temp);
        setupVAOVBO();
    }

    public void createEllipticCone() {
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 100) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 60) {
                float x = radiusX * (float) (v * Math.cos(u));
                float y = radiusY * (float) (v * Math.sin(u));
                float z = radiusZ * (float) v;
                temp.add(new Vector3f(x, z, y));
            }
        }
        vertices.clear();
        vertices.addAll(temp);
        setupVAOVBO();
    }

    public void createEllipticParaboloid() {
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = Math.PI; v >= 0; v -= Math.PI / 60) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 60) {
                float x = radiusX * (float) (v * Math.cos(u));
                float y = radiusY * (float) (v * Math.sin(u));
                float z = (float) (v * v);
                temp.add(new Vector3f(x, z, y));
            }
        }
        vertices.clear();
        vertices.addAll(temp);
        setupVAOVBO();
    }

    public void createHyperboloidParaboloid() {
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = Math.PI; v >= 0; v -= Math.PI / 60) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 60) {
                float x = radiusX * (float) (v * Math.tan(u));
                float y = radiusY * (float) (v * (1 / Math.cos(u)));
                float z = (float) (v * v);
                temp.add(new Vector3f(x, z, y));
            }
        }
        vertices.clear();
        vertices.addAll(temp);
        setupVAOVBO();
    }
}
