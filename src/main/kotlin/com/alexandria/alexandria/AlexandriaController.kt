package com.alexandria.alexandria

import javafx.application.Platform
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.layout.*
import javafx.stage.FileChooser
import java.io.File

class AlexandriaController {
    fun onAddClick(actionEvent: ActionEvent) {
        val source: Node = actionEvent.source as Node

        val fc = FileChooser()
        val file: File? = fc.showOpenDialog(source.scene.window)
        if (file?.isFile != null) {
            println("File Name:      ${file.name}")
            println("File Extension: ${file.extension}")
        }
    }

    fun onRawClick(actionEvent: ActionEvent) {
        val fxmlLoader = FXMLLoader(Alexandria::class.java.getResource("content-raw-data.fxml"))
        val rawDataNode: GridPane = fxmlLoader.load()


        Platform.runLater {
            fxmlLoader.getController<RawFileViewController>().onRawClick(actionEvent)
        }
    }

    @FXML
    lateinit var buttonRawView: Button

    @FXML
    lateinit var buttonAddFile: Button
}