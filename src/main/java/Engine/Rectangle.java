package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL30.*;

public class Rectangle extends Object {
    List<Integer> index;
    int ibo;
    public Rectangle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Integer> index){
        super(shaderModuleDataList,vertices,color);
        this.index = index;
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,Utils.listoInt(index),GL_STATIC_DRAW);
    }
//    public void draw(){
//        drawSetup();
//
//        //Bind IBO & draw
//        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
//        glDrawElements(GL_TRIANGLES,index.size(),GL_UNSIGNED_INT,0);
//    }
//    public void drawStars() {
//        drawSetup();
//
//        // optional
//        glLineWidth(1); // ketebalan garis
//        glPointSize(0); // besar kecil vertex
//        // wajib
//        // GL_LINE, GL_LINE_STRIP, GL_lINE_LOOP, GL_TRIANGLES, GL_TRIANGLE_FAN, GL_POINT -> YG SERING DIPAKAI
//        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
//        glDrawElements(GL_LINE_LOOP, index.size(), GL_UNSIGNED_INT, 0);
//    }

}
