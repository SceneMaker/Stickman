package de.dfki.stickman3D.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.common.agent.Agent3D;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;

import java.net.URL;

/**
 * Created by EmpaT on 29.07.2017.
 */
public abstract class Hair3D extends PartStickman3D
{
    public SHAPE mShape = SHAPE.DEFAULT;
    protected MeshView hairMeshView;
    protected PhongMaterial material;


    @Override
    public void setShape(String s)
    {
        mShape = SHAPE.valueOf(s);
    }

    @Override
    public void resetShape()
    {
        mShape = SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {
        executeFadeInFadeOut(hairMeshView, mShape, step);
    }

    @Override
    public void update()
    {
        material.setDiffuseColor(mColor);
        hairMeshView.setMaterial(material);
    }

    @Override
    public MeshView getMeshView()
    {
        return hairMeshView;
    }

    protected void initializeHair(URL hairURL)
    {
        ColModelImporter importer = new ColModelImporter();
        importer.read(hairURL);
        hairMeshView = (MeshView) importer.getImport()[0];
        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        hairMeshView.setMaterial(material);
    }
}
