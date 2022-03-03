package com.alexandria.alexandria

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

class Alexandria : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(Alexandria::class.java.getResource("app-root-view.fxml"))

        val load = fxmlLoader.load<Parent>()
        val scene = Scene(load, 800.0, 600.0)
        stage.title = "Alexandria"
        stage.scene = scene

        stage.show()
    }
}

fun main() {
    Application.launch(Alexandria::class.java)
}