package com.alexandria.alexandria

import com.jfoenix.controls.JFXButton
import javafx.application.Platform
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import javafx.scene.layout.*
import javafx.scene.paint.Paint
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
        val source: Node = actionEvent.source as Node
        val scene: VBox = source.scene.lookup("#main") as VBox

        val fxmlLoader = FXMLLoader(Alexandria::class.java.getResource("content-raw-data.fxml"))
        val rawDataNode: GridPane = fxmlLoader.load()


        rawDataNode.border = Border(BorderStroke(Paint.valueOf("Red"),BorderStrokeStyle.DASHED,CornerRadii.EMPTY,BorderStroke.DEFAULT_WIDTHS))
        GridPane.setVgrow(rawDataNode, Priority.ALWAYS)
        GridPane.setHgrow(rawDataNode, Priority.ALWAYS)
        scene.children.setAll(rawDataNode)
        Platform.runLater {
            fxmlLoader.getController<RawFileViewController>().onRawClick(actionEvent)
        }
    }

    @FXML
    lateinit var buttonRawFileView: JFXButton

    @FXML
    lateinit var buttonAdd: JFXButton

    @FXML
    lateinit var buttonLibrary: JFXButton
}