package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_TRIANGLE_FAN;

public class Circle extends Object {

    float radiusX;
    float radiusY;

    public Circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint,
                  Float radiusX, Float radiusY) {
        super(shaderModuleDataList, vertices, color, centerPoint);
        this.centerPoint = centerPoint;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
//        createCircle();
        setupVAOVBO();
    }

    public double degToRad(float degree) {
        return (degree * Math.PI / (float) 180);
    }

    public void createCircle() {
        vertices.clear();
        for (int i = 0; i < 360; i += 0.1) {
            double rad = degToRad(i);
            Float x = (float) (centerPoint.get(0) + Math.cos(rad) * radiusX);
            Float y = (float) (centerPoint.get(1) + Math.sin(rad) * radiusY);
            Float z = 0.0f;
            vertices.add(new Vector3f(x, y, z));
        }
    }

    public void createRectangle() {
        vertices.clear();
        int degree = 45;
        for (float i = 0; i < 4; i++) {
            double rad = degToRad(degree);
            Float x = (float) (centerPoint.get(0) + Math.cos(rad) * radiusX);
            Float y = (float) (centerPoint.get(1) + Math.sin(rad) * radiusY);
            Float z = 0.0f;
            vertices.add(new Vector3f(x, y, z));
            degree += 90;
        }
    }

    public void createTriangle() {
        vertices.clear();
        int degree = 90;
        for (float i = 0; i < 3; i++) {
            double rad = degToRad(degree);
            Float x = (float) (centerPoint.get(0) + Math.cos(rad) * radiusX);
            Float y = (float) (centerPoint.get(1) + Math.sin(rad) * radiusY);
            Float z = 0.0f;
            vertices.add(new Vector3f(x, y, z));
            if (degree == 90) {
                degree += 135;
            } else {
                degree += 90;
            }
        }
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
//        glDrawArrays(GL_TRIANGLE_FAN, 0, vertices.size());
//    }
}
