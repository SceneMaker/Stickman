/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.common.enums.Gender;
import de.dfki.common.part.Part3D;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;

import java.net.URL;

/**
 * @author Beka
 */
public class RightFoot3D extends Foot
{
    public RightFoot3D(Part3D rightForeLeg)
    {
        super(rightForeLeg);
        RightForeLeg3D foreLeg = (RightForeLeg3D) rightForeLeg;
//        mSize = new Dimension(Preferences.FOOT_WIDTH, Preferences.FOOT_HEIGHT);
        if (foreLeg.getUpperLeg().getDownBody().getUpperBody().getNeck().getHead().getStickman().mType == Gender.TYPE.MALE)
            mColor = Color.rgb(80, 80, 80, 1);
        else
            mColor = Color.rgb(154, 83, 198, 1);
        mYRotation = 130;

        URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/foot.dae");
        ColModelImporter im = new ColModelImporter();
        im.read(url);
        footMeshView = (MeshView) im.getImport()[0];

        material = new PhongMaterial();
        material.setDiffuseColor(mColor.darker());
        footMeshView.setMaterial(material);

        this.getChildren().add(footMeshView);
        foreLeg.foreLegBox.getChildren().add(this);

        init();
    }

    @Override
    public void init()
    {
        super.init();
        this.setTranslateY(-5);
        this.setTranslateX(7);
    }

    @Override
    public void update()
    {
        material.setDiffuseColor(mColor);
        footMeshView.setMaterial(material);
    }

    @Override
    public MeshView getMeshView()
    {
        return footMeshView;
    }
}
