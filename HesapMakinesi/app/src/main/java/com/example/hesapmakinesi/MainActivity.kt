package com.example.hesapmakinesi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hesapmakinesi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var sayi1 = ""
    var operator = ""
    var isSecondNumber = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Butonlara click özelliği verildi
        binding.button1.setOnClickListener { addNumber("1") }
        binding.button2.setOnClickListener { addNumber("2") }
        binding.button3.setOnClickListener { addNumber("3") }
        binding.button4.setOnClickListener { addNumber("4") }
        binding.button5.setOnClickListener { addNumber("5") }
        binding.button6.setOnClickListener { addNumber("6") }
        binding.button7.setOnClickListener { addNumber("7") }
        binding.button8.setOnClickListener { addNumber("8") }
        binding.button9.setOnClickListener { addNumber("9") }
        binding.button0.setOnClickListener { addNumber("0") }
        binding.buttonNokta.setOnClickListener { addNumber(".") }
        binding.buttonArt.setOnClickListener { selectOperator("+") }
        binding.buttonEksi.setOnClickListener { selectOperator("-") }
        binding.buttonCarpma.setOnClickListener { selectOperator("*") }
        binding.buttonBolme.setOnClickListener { selectOperator("/") }
        binding.buttonYuzde.setOnClickListener { selectOperator("%") }
        binding.buttonNokta.setOnClickListener { addNumber(".") }

        binding.buttonEsittir.setOnClickListener {
            calculateResult()
        }

        binding.buttonAC.setOnClickListener {
            clear()
        }

        binding.imageSil.setOnClickListener {
            val currentText = binding.editTextText2.text.toString()
            if ( currentText.isNotEmpty()) {
                val newText = currentText.dropLast(1)  // droplast() : girilen stringin son karakterini silmek için
                binding.editTextText2.setText(newText)
            }
        }
    }

    //  yeni bir sayıya geçerken önce ekranı temizlemek için
    private fun addNumber(num: String) {
        if (isSecondNumber) {
            binding.editTextText2.setText("")
            isSecondNumber = false
        }

        val current = binding.editTextText2.text.toString()
        binding.editTextText2.setText(current + num)
    }

    private fun selectOperator(op: String) {
        sayi1 = binding.editTextText2.text.toString()
        operator = op
        isSecondNumber = true
    }

    private fun calculateResult() {
        val sayi2 = binding.editTextText2.text.toString()

        if (sayi1.isNotEmpty() && sayi2.isNotEmpty()) {
            val num1 = sayi1.toDouble()
            val num2 = sayi2.toDouble()
            var sonuc = 0.0

            when (operator) {
                "+" -> sonuc = num1 + num2
                "-" -> sonuc = num1 - num2
                "*" -> sonuc = num1 * num2
                "/" -> sonuc = if (num2 != 0.0) num1 / num2 else 0.0
                "%" -> sonuc =  ( num1 * num2 ) / 100
            }

            binding.editTextText2.setText(sonuc.toString())
        }
    }
    
    private fun clear() {
        binding.editTextText2.setText("")
        sayi1 = ""
        operator = ""
        isSecondNumber = false
    }
}