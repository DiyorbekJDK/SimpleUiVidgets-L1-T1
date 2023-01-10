package com.example.simpleuividgets

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity() {
    private var index = -1
    private val languages = arrayOf("Java", "Kotlin", "C", "JavaScript", "C++", "Python", "Dart")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radiogroup()
        search()
        ratingBar()
        sSBtn()
        textSwitcher()

    }
    private fun textSwitcher(){
        val textSwitcher: TextSwitcher = findViewById(R.id.textSwitcher)
        val btnBack: MaterialButton = findViewById(R.id.btnback)
        val btnNext: MaterialButton = findViewById(R.id.btnNext)

        textSwitcher.setFactory {
            val textView = TextView(this)
            textView.textSize = 30f
            textView.gravity = Gravity.CENTER
            textView
        }
        btnBack.setOnClickListener {
            if (index > 0){
                index--
                textSwitcher.setText(languages[index])
            }
        }
        btnNext.setOnClickListener {
            if (index < languages.size -1){
                index++
                if (index == languages.size -1){
                    index = 0
                }
                textSwitcher.setText(languages[index])
            }
        }

    }

    private fun sSBtn() {
        val spinner: Spinner = findViewById(R.id.spinner)
        val switchMaterial: SwitchMaterial = findViewById(R.id.switchbtn)
        val btn: AppCompatButton = findViewById(R.id.btnstart)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, languages)
        spinner.adapter = adapter
        switchMaterial.setOnCheckedChangeListener { _, b ->
            switchMaterial.isChecked = b
        }
        btn.setOnClickListener {
            ProgressDialog(this).apply {
                setTitle("This is progress dialog")
                setMessage("Loading...")
            }.show()
        }
    }

    private fun ratingBar() {
        val ratingBar: RatingBar = findViewById(R.id.ratingBar)
        val btn: Button = findViewById(R.id.ratingBtn)

        btn.setOnClickListener {
            Snackbar.make(it, "${ratingBar.rating}", Snackbar.LENGTH_LONG).show()
        }
    }

    private fun search() {
        val autoCompleteTextView: AutoCompleteTextView = findViewById(R.id.autoCompleteTextView)
        val multiAutoCompleteTextView =
            findViewById<MultiAutoCompleteTextView>(R.id.multiCompleteTextView)
        val languages = arrayOf("Java", "Kotlin", "C", "JavaScript", "C++", "Python", "Dart")
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, languages)
        autoCompleteTextView.setAdapter(arrayAdapter)
        multiAutoCompleteTextView.setAdapter(arrayAdapter)
        multiAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
    }

    private fun radiogroup() {
        val radioGrop: RadioGroup = findViewById(R.id.radioGroup)
        radioGrop.setOnCheckedChangeListener { radioGroup, id ->
            when (id) {
                R.id.red -> {
                    radioGroup.setBackgroundColor(
                        ContextCompat.getColor(this, R.color.red)
                    )
                }
                R.id.blue -> {
                    radioGroup.setBackgroundColor(
                        ContextCompat.getColor(this, R.color.blue)
                    )
                }
                R.id.green -> {
                    radioGroup.setBackgroundColor(
                        ContextCompat.getColor(this, R.color.green)
                    )
                }
            }
        }

    }

}

