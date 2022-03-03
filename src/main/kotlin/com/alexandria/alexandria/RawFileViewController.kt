package com.alexandria.alexandria

import javafx.application.Platform
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.TextArea
import javafx.scene.layout.GridPane
import javafx.stage.FileChooser
import java.io.File
import java.nio.file.Files

class RawFileViewController {
    @FXML
    lateinit var gridpaneContent: GridPane
    @FXML
    lateinit var textareaRawData: TextArea

    fun onRawClick(actionEvent: ActionEvent) {

        val fc = FileChooser()
        val file: File? = fc.showOpenDialog(textareaRawData.scene.window)
        if (file?.isFile != null) {
            textareaRawData.text = "File Name:\t\t${file.name}\n"
            textareaRawData.appendText("File Extension:\t${file.extension}\n\n")

            val allLines = Files.readAllLines(file.toPath(), Charsets.ISO_8859_1)

            allLines.forEach {
                Platform.runLater { textareaRawData.appendText("$it\n") }
            }

            val fileContent: ByteArray = Files.readAllBytes(file.toPath())
            val it = fileContent.slice(IntRange(0, 10))
            it.forEach {
                println("Binary Value:  ${Integer.toBinaryString(it.toInt())}")
                println("Byte Value:    $it")
                println("Int Value:     ${it.toInt()}")
                println("Octal Value:   ${Integer.toOctalString(it.toInt())}")
                println("Hex Value:     ${Integer.toHexString(it.toInt())}")
            }
        }
    }
}