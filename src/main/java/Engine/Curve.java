package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

public class Curve extends Object {
    List<Vector3f> points = new ArrayList<>();
    List<Integer> numbers = new ArrayList<>();
    List<Vector3f> curve = new ArrayList<>();

    public Curve(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList, vertices, color);
    }

    public void createCurve() {
        curve = new ArrayList<>();
        numbers = new ArrayList<>();
        pascal();

        if (points.size() > 1) {
            for (double t = 0; t <= 1; t += 0.01) {
                float x = 0;
                float y = 0;

                for (int i = 0; i < points.size(); i++) {
                    x += (numbers.get(i) * points.get(i).x * Math.pow(1 - t, (points.size() - 1) - i) * Math.pow(t, i));
                    y += (numbers.get(i) * points.get(i).y * Math.pow(1 - t, (points.size() - 1) - i) * Math.pow(t, i));
                }
                curve.add(new Vector3f(x, y, 0));
            }
        }
        this.vertices = curve;
    }

    public void pascal() {
        for (int r = 0; r <= points.size() - 1; r++) {
            // nCr formula
            int num = factorial(points.size() - 1) / (factorial((points.size() - 1) - r) * factorial(r));
            numbers.add(num);
        }
    }

    public int factorial(int num) {
        if (num >= 1)
            return num * factorial(num - 1);
        else
            return 1;
    }

    public int combination(int a, int b) {
        return factorial(a) / (factorial(a - b) * factorial(b));
    }

    public void addVertices(Vector3f newVertices) {
        points.add(newVertices);
        createCurve();
        setupVAOVBO();
    }
}

