package com.alexandria.alexandria

import javafx.application.Platform
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.TextArea
import javafx.scene.layout.BorderPane
import javafx.scene.layout.GridPane
import javafx.stage.FileChooser
import java.io.File

class AlexandriaController {

    @FXML
    lateinit var borderPaneContainer: BorderPane

    @FXML
    lateinit var buttonRawView: Button

    @FXML
    lateinit var buttonAddFile: Button

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
        val fxmlLoader = FXMLLoader(Alexandria::class.java.getResource("views/center/raw-file.fxml"))
        val rawDataNode: TextArea = fxmlLoader.load()

        val center: GridPane = borderPaneContainer.center as GridPane
        center.children.setAll(rawDataNode)

        Platform.runLater {
            fxmlLoader.getController<RawFileViewController>().onRawClick(actionEvent)
        }
    }

}