package com.example.internalfilesstorage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fileName = "arquivo.txt"
        val fileContent = "Conteúdo do Arquivo"

        val file = File(filesDir, fileName)
        file.createNewFile()

        val extFile = File(getExternalFilesDir(null), fileName)
        extFile.createNewFile()

        file.outputStream().use {
            it.write(fileContent.toByteArray())
        }

        extFile.outputStream().use {
            it.write(fileContent.toByteArray())
        }


        file.inputStream().use {
            Toast.makeText(this, it.readBytes().decodeToString(), Toast.LENGTH_SHORT).show()
        }

//        val conteudo = readContent(extFile)

//        Toast.makeText(this, conteudo, Toast.LENGTH_SHORT).show()

    }

//    private fun readContent(file: File): String {
//        file.inputStream().use {
//            return it.readBytes().decodeToString()
//        }
//    }
}