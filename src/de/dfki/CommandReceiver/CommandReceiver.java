/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.CommandReceiver;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.controllerhelper.ColorHelper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;

/**
 *
 * @author EmpaT
 *//////////////////////////////////////////////
public class CommandReceiver extends Thread {

    private DatagramSocket serverSocket;
    DatagramPacket receivePacket;
    
    private Stickman3D mStickman3D;

    byte[] receiveData = new byte[1024];
    public static boolean go = true;
    String action = "";

    public CommandReceiver(Stickman3D stickman3D) {
        this.mStickman3D = stickman3D;
        try {
            serverSocket = new DatagramSocket(64000);
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
        } catch (IOException ex) {
            Logger.getLogger(CommandReceiver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while (go) {
            try {
                System.out.println("shemovida");
                serverSocket.receive(receivePacket);
                
                action = new String(receiveData, 0, receivePacket.getLength());
                if(!action.isEmpty()){
                    String[] prefix = action.split("-");
                    switchPrefixAndRun(prefix[0], prefix[1]);
                }
            } catch (IOException ex) {
                Logger.getLogger(CommandReceiver.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void switchPrefixAndRun(String prefix, String tail)
    {
        ColorPicker colorPicker;
        switch(prefix)
        {
            case "ColorHead":
                colorPicker = createColorPicker(tail.split(","));
                ColorHelper.headColorChanger(mStickman3D, colorPicker);
                break;
            case "ColorHair":
                colorPicker = createColorPicker(tail.split(","));
                ColorHelper.hairColorChanger(mStickman3D, colorPicker);
                break; 
            case "ColorBody":
                colorPicker = createColorPicker(tail.split(","));
                ColorHelper.bodyColorChanger(mStickman3D, colorPicker);
                break;
            case "ColorLimbs":
                colorPicker = createColorPicker(tail.split(","));
                ColorHelper.limbsColorChanger(mStickman3D, colorPicker);
                break;
            case "ColorShoes":
                colorPicker = createColorPicker(tail.split(","));
                ColorHelper.shoesColorChanger(mStickman3D, colorPicker);
                break;
            case "ColorLips":
                colorPicker = createColorPicker(tail.split(","));
                ColorHelper.lipsColorChanger(mStickman3D, colorPicker);
                break;
            case "ColorEye":
                colorPicker = createColorPicker(tail.split(","));
                ColorHelper.eyeColorChanger(mStickman3D, colorPicker);
                break;
            case "ColorBrow":
                colorPicker = createColorPicker(tail.split(","));
                ColorHelper.browColorChanger(mStickman3D, colorPicker);
                break;
            case "ColorNose":
                colorPicker = createColorPicker(tail.split(","));
                ColorHelper.noseColorChanger(mStickman3D, colorPicker);
                break;
            case "Reset":
                ColorHelper.resetAll(mStickman3D);
                break;
            case "OpacityShoes":
                OpacityHelper.shoesOpacityChanger(mStickman3D, Float.parseFloat(tail));
                break;
            case "OpacityLips":
                OpacityHelper.lipsOpacityChanger(mStickman3D, Float.parseFloat(tail));
                break;
            case "OpacityEye":
                OpacityHelper.eyeOpacityChanger(mStickman3D, Float.parseFloat(tail));
                break;
            case "OpacityBrow":
                OpacityHelper.browOpacityChanger(mStickman3D, Float.parseFloat(tail));
                break;
            case "OpacityNose":
                OpacityHelper.noseOpacityChanger(mStickman3D, Float.parseFloat(tail));
                break;
            case "OpacityHead":
                OpacityHelper.headOpacityChanger(mStickman3D, Float.parseFloat(tail));
                break;
            case "OpacityLimbs":
                OpacityHelper.limbsOpacityChanger(mStickman3D, Float.parseFloat(tail));
                break;
            case "OpacityBody":
                OpacityHelper.bodyOpacityChanger(mStickman3D, Float.parseFloat(tail));
                break;
            case "OpacityHair":
                OpacityHelper.hairOpacityChanger(mStickman3D, Float.parseFloat(tail));
                break;
            case "Emotion":
                if(tail.equalsIgnoreCase("AngrySmall"))
                    mStickman3D.doAnimation("AngrySmallMouth", 500, true);
                else
                    mStickman3D.doAnimation(tail, 500, true);
                break;
            case "Gesture":
                 mStickman3D.doAnimation(tail, 500, true);
                break;
        }
    }
    
    private ColorPicker createColorPicker(String[] rgbValues)
    {
        if(rgbValues.length == 3)
        {
            int R = Integer.parseInt(rgbValues[0]);
            int G = Integer.parseInt(rgbValues[1]);
            int B = Integer.parseInt(rgbValues[2]);
            Color color = Color.rgb(R, G, B, 1.0);
            ColorPicker colorPicker = new ColorPicker(color);
            return colorPicker;
        } 
        return null;
    }
}
