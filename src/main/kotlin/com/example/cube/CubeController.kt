package com.example.cube

import javafx.scene.Group
import javafx.scene.PerspectiveCamera
import javafx.scene.PointLight
import javafx.scene.Scene
import javafx.scene.control.Slider
import javafx.scene.paint.Color
import javafx.scene.shape.Box
import javafx.scene.transform.Rotate
import javafx.stage.Stage


class CubeController {
    lateinit var sldZ1: Slider
    lateinit var sldY1: Slider
    lateinit var sldX1: Slider

    fun initialize(){
        // create a 3D box
        val box = Box(200.0, 200.0, 200.0)
        box.translateX = 400.0
        box.translateY = 400.0
        box.translateZ = 400.0

        box.rotationAxis = Rotate.X_AXIS
        box.rotate = 45.0
        box.rotationAxis = Rotate.Y_AXIS
        box.rotate = 45.0

        // create a point light
        val light = PointLight(Color.CYAN)

        // create a group
        val group = Group()
        group.children.addAll(box, light)

        // create a camera
        val fixedEyeAtCameraZero = false
        val camera = PerspectiveCamera(fixedEyeAtCameraZero)

        // create a scene
        val scene = Scene(group, 800.0, 800.0)
        scene.camera = camera

        // create a stage
        val stage = Stage()
        stage.title = "3D Box"
        stage.scene = scene
        stage.show()

        // bind the 1st set of sliders to the box size
        box.scaleXProperty().bind(sldX1.valueProperty())
        box.scaleYProperty().bind(sldY1.valueProperty())
        box.scaleZProperty().bind(sldZ1.valueProperty())
    }
}