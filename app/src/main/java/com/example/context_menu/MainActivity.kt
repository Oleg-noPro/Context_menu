package com.example.context_menu

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var textET: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textET = findViewById(R.id.textET)
        registerForContextMenu(textET)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_change_color -> {
                when(textET.text.toString().toInt()) {
                    1 -> textET.setBackgroundColor(Color.rgb(255, 165, 0))
                    2 -> textET.setBackgroundColor(Color.YELLOW)
                    3 -> textET.setBackgroundColor(Color.GREEN)
                    4 -> textET.setBackgroundColor(Color.BLUE)
                    5 -> textET.setBackgroundColor(Color.RED)
                }
            }
            R.id.menu_close_programm -> {
                finish()
            }
            else -> return super.onContextItemSelected(item)
        }
        return true
    }
}