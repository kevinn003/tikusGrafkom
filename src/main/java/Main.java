import Engine.*;
import Engine.Object;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.glfw.GLFW.*;


public class Main {

    private Window window = new Window(800, 800, "TIKUS");

    private ArrayList<Object> objects = new ArrayList<>();
    private ArrayList<Object> objectsRectangle = new ArrayList<>();
    private List<Vector3f> circle = new ArrayList<>();
    private ArrayList<Rectangle> stars = new ArrayList<>();
    MouseInput mouseInput;

    private ArrayList<Object> objectsPointsControl = new ArrayList<>();
    private Object controlLine;
    private ArrayList<Object> curves = new ArrayList<>();
    private ArrayList<Vector3f> center = new ArrayList<>();
    private ArrayList<Sphere> planets = new ArrayList<>();
    Sphere kotak;
    Sphere bundar;

    private ArrayList<Sphere> kepala = new ArrayList<>();
    private ArrayList<Sphere> badan = new ArrayList<>();
    private ArrayList<Sphere> kaki = new ArrayList<>();
    private ArrayList<Sphere> tangan = new ArrayList<>();
    private ArrayList<Sphere> topi = new ArrayList<>();
    private ArrayList<Object> kumis = new ArrayList<>();
    private ArrayList<Sphere> telinga = new ArrayList<>();
    int countDegree = 0;
    Camera camera = new Camera();
    Projection projection = new Projection(window.getWidth(), window.getHeight());

    public void init() {
        window.init();
        GL.createCapabilities();
        camera.setPosition(0f, 0f, 3f);

        //head
        kepala.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(.58f, .58f, .58f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.3f,
                0.3f,
                0.3f, 36,
                18, 2));
        kepala.get(0).translateObject(0f, 0f, 0.1f);

        //mata
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.07f,
                0.1f,
                0.11f, 36,
                18, 2));
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.07f,
                0.1f,
                0.11f, 36,
                18, 2));
        kepala.get(0).getChildObject().get(0).translateObject(-0.09f, 0.07f, 0.3f);
        kepala.get(0).getChildObject().get(1).translateObject(0.09f, 0.07f, 0.3f);

        //pupil
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                Arrays.asList(0f, 0f, 0f),
                0.025f,
                0.028f,
                0.025f, 36,
                18, 2));
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                Arrays.asList(0f, 0f, 0f),
                0.025f,
                0.028f,
                0.025f, 36,
                18, 2));
        kepala.get(0).getChildObject().get(2).translateObject(-0.08f, 0.05f, 0.39f);
        kepala.get(0).getChildObject().get(3).translateObject(0.08f, 0.05f, 0.39f);

        //nose
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 0.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.07f,
                0.05f,
                0.05f, 36,
                18, 2));
        kepala.get(0).getChildObject().get(4).translateObject(0f, -0.09f, 0.39f);

        //telinga
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(.58f, 0.58f, 0.58f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.17f,
                0.17f,
                0.17f, 36,
                18, 2));
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(.58f, 0.58f, 0.58f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.17f,
                0.17f,
                0.17f, 36,
                18, 2));
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.8f, 0.47f, 0.54f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.13f,
                0.13f,
                0.13f, 36,
                18, 2));
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.8f, 0.47f, 0.54f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.13f,
                0.13f,
                0.13f, 36,
                18, 2));
        kepala.get(0).getChildObject().get(5).translateObject(-0.18f, 0.33f, 0.05f);
        kepala.get(0).getChildObject().get(6).translateObject(0.18f, 0.33f, 0.05f);
        kepala.get(0).getChildObject().get(7).translateObject(-0.18f, 0.33f, 0.1f);
        kepala.get(0).getChildObject().get(8).translateObject(0.18f, 0.33f, 0.1f);



        //badan
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.58f, 0.58f, 0.58f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.25f,
                0.25f,
                0.35f, 36,
                18, 3));
        kepala.get(0).getChildObject().get(9).translateObject(0f, -0.3f, 0.1f);

        //lengan
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.58f, 0.58f, 0.58f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.06f,
                0.1f,
                0.16f, 36,
                18, 3));

        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.58f, 0.58f, 0.58f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.06f,
                0.1f,
                0.16f, 36,
                18, 3));
        kepala.get(0).getChildObject().get(10).translateObject(-0.25f, -.4f, 0.1f);
        kepala.get(0).getChildObject().get(11).translateObject(0.25f, -.4f, 0.1f);

        //telapak tangan
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.8f, 0.47f, 0.54f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.05f,
                0.05f,
                0.05f, 36,
                18, 2));
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.8f, 0.47f, 0.54f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.05f,
                0.05f,
                0.05f, 36,
                18, 2));
        kepala.get(0).getChildObject().get(12).translateObject(-0.25f, -.55f, 0.15f);
        kepala.get(0).getChildObject().get(13).translateObject(0.25f, -.55f, 0.15f);

        //paha
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.58f, 0.58f, 0.58f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.06f,
                0.1f,
                0.16f, 36,
                18, 3));


        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.58f, 0.58f, .58f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.06f,
                0.1f,
                0.16f, 36,
                18, 3));
        kepala.get(0).getChildObject().get(14).translateObject(-0.14f, -0.69f, 0.1f);
        kepala.get(0).getChildObject().get(15).translateObject(0.14f, -0.69f, 0.1f);

        //telapak kaki
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.8f, 0.47f, 0.54f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.05f,
                0.05f,
                0.05f, 36,
                18, 3));
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.8f, 0.47f, 0.54f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.05f,
                0.05f,
                0.05f, 36,
                18, 3));
        kepala.get(0).getChildObject().get(16).translateObject(-0.14f, -.85f, 0.11f);
        kepala.get(0).getChildObject().get(17).translateObject(0.14f, -.85f, 0.11f);


        //kumis
        kepala.get(0).getChildObject().add(new Curve(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0.0f)
        ,Arrays.asList(0f,0f,0f)));
        kepala.get(0).getChildObject().get(18).addVertices(new Vector3f(-0.4f, -0.075f, 0.1f));
        kepala.get(0).getChildObject().get(18).addVertices(new Vector3f(-0.3f, 0.1f, 0.1f));
        kepala.get(0).getChildObject().get(18).addVertices(new Vector3f(-0.07f, -0.0225f, 0.1f));
        kepala.get(0).getChildObject().get(18).translateObject(0f,0f,0.38f);

        kepala.get(0).getChildObject().add(new Curve(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0.0f)
                ,Arrays.asList(0f,0f,0f)));
        kepala.get(0).getChildObject().get(19).addVertices(new Vector3f(-0.4f, -0.275f, 0.1f));
        kepala.get(0).getChildObject().get(19).addVertices(new Vector3f(-0.3f, 0.05f, 0.1f));
        kepala.get(0).getChildObject().get(19).addVertices(new Vector3f(-0.07f, -0.0425f, 0.1f));
        kepala.get(0).getChildObject().get(19).translateObject(0f,0f,0.38f);

        kepala.get(0).getChildObject().add(new Curve(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0.0f)
                ,Arrays.asList(0f,0f,0f)));
        kepala.get(0).getChildObject().get(20).addVertices(new Vector3f(0.4f, -0.075f, 0.1f));
        kepala.get(0).getChildObject().get(20).addVertices(new Vector3f(0.3f, 0.1f, 0.1f));
        kepala.get(0).getChildObject().get(20).addVertices(new Vector3f(0.07f, -0.0225f, 0.1f));
        kepala.get(0).getChildObject().get(20).translateObject(0f,0f,0.38f);

        kepala.get(0).getChildObject().add(new Curve(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0.0f)
                ,Arrays.asList(0f,0f,0f)));
        kepala.get(0).getChildObject().get(21).addVertices(new Vector3f(0.4f, -0.275f, 0.1f));
        kepala.get(0).getChildObject().get(21).addVertices(new Vector3f(0.3f, 0.05f, 0.1f));
        kepala.get(0).getChildObject().get(21).addVertices(new Vector3f(0.07f, -0.0425f, 0.1f));
        kepala.get(0).getChildObject().get(21).translateObject(0f,0f,0.38f);
    }

    public void input() {
                if (window.getMouseInput().isLeftButtonPressed()) {
                    Vector2f pos = window.getMouseInput().getCurrentPos();

                    pos.x = (pos.x - (window.getWidth()) / 2.0f) / (window.getWidth() / 2.0f);
                    pos.y = (pos.y - (window.getHeight()) / 2.0f) / (-window.getHeight() / 2.0f);

                    if ((!(pos.x > 1 || pos.x < -0.95) && !(pos.y > 0.95 || pos.y < -1))) {
                        System.out.println("x : " + pos.x + " y : " + pos.y);
                    }
                }
        if (window.isKeyPressed(GLFW_KEY_W)) {
            for (Sphere kepala : kepala
            ) {
                List<Float> temp = new ArrayList<>(kepala.getCenterPoint());
                kepala.translateObject(-temp.get(0), -temp.get(1), -temp.get(2));
                kepala.rotateObject((float) Math.toRadians(0.5f), 0f, 1f, 0f);
                kepala.translateObject(temp.get(0), temp.get(1), temp.get(2));
            }
//            for (Sphere telinga : telinga
//            ) {
//                telinga.rotateObject((float) Math.toRadians(0.5f), 0f, 1f, 0f);
//            }
//            for (Sphere badan : badan
//            ) {
//                badan.rotateObject((float) Math.toRadians(0.5f), 0f, 1f, 0f);
//            }
//            for (Sphere kaki : kaki) {
//                kaki.rotateObject((float) Math.toRadians(0.5f), 0f, 1f, 0f);
//            }
//            for (Sphere tangan : tangan
//            ) {
//                tangan.rotateObject((float) Math.toRadians(0.5f), 0f, 1f, 0f);
//            }
//            for (Object kumis : kumis
//            ) {
//                kumis.rotateObject((float) Math.toRadians(0.5f), 0f, 1f, 0f);
//            }
        }
        if (window.isKeyPressed(GLFW_KEY_S)) {
            camera.moveForward(0.1f);
        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            for (Sphere telinga : telinga
            ) {
                telinga.translateObject(-0.1f, 0f, 0f);
            }
            for (Sphere kepala : kepala
            ) {
                kepala.translateObject(-0.1f, 0f, 0f);
            }
            for (Sphere badan : badan
            ) {
                badan.translateObject(-0.1f, 0f, 0f);
            }
            for (Sphere kaki : kaki) {
                kaki.translateObject(-0.1f, 0f, 0f);
            }
            for (Sphere tangan : tangan
            ) {
                tangan.translateObject(-0.1f, 0f, 0f);
            }
            for (Object kumis : kumis
            ) {
                kumis.translateObject(-0.1f, 0f, 0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_D)) {
            for (Sphere telinga : telinga
            ) {
                telinga.translateObject(0.1f, 0f, 0f);
            }
            for (Sphere kepala : kepala
            ) {
                kepala.translateObject(0.1f, 0f, 0f);
            }
            for (Sphere badan : badan
            ) {
                badan.translateObject(0.1f, 0f, 0f);
            }
            for (Sphere kaki : kaki) {
                kaki.translateObject(0.1f, 0f, 0f);
            }

            for (Sphere tangan : tangan
            ) {
                tangan.translateObject(0.1f, 0f, 0f);
            }
            for (Object kumis : kumis
            ) {
                kumis.translateObject(0.1f, 0f, 0f);
            }
        }
    }

    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f, 0.0f, 0.8f, 0.0f);
            GL.createCapabilities();

            input();

//            code
            for (Sphere kaki : kaki
            ) {
                kaki.draw(camera, projection);
            }
            for (Sphere telinga : telinga
                 ) {
                telinga.draw(camera, projection);
            }
            for (Sphere badan : badan
            ) {
                badan.draw(camera, projection);
            }
            for (Sphere tangan : tangan
            ) {
                tangan.draw(camera, projection);
            }

            for (Sphere kepala : kepala
            ) {
                kepala.draw(camera, projection);
            }
            for (Object kumis : kumis) {
                kumis.drawLine(camera, projection);
            }
            for (Sphere topi : topi
            ) {
                topi.draw(camera, projection);
            }
            //Restore state
            glDisableVertexAttribArray(0);

            //Poll for window events.
            //The key callback above will only be
            //invoked during this call.
            glfwPollEvents();
        }
    }

    public void run() {
        init();
        loop();
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
