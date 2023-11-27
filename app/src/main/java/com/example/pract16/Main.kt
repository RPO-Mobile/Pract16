package com.example.pract16


import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.toSpanned
import com.example.pract16.databinding.CustomToastBinding
import com.example.pract16.databinding.MainActBinding


class Main : AppCompatActivity() {
    private lateinit var binding: MainActBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainActBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val text = "Нажата кнопка 1"
            Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).show()
        }

        binding.btn2.setOnClickListener{
            val text = "Нажата кнопка 2, текст выводится по центру"
            val toast = Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER, 0 , 0)
            toast.show()
        }

        binding.btn3.setOnClickListener{
            val toast = Toast.makeText(applicationContext, "Пример с картинкой", Toast.LENGTH_LONG)
            toast.setGravity(Gravity.CENTER, 0, 0)
            val toastContainer = toast.view as LinearLayout?
            val img = ImageView(applicationContext)
            img.setImageResource(R.drawable.img)
            toastContainer!!.addView(img, 0)
            toast.show()

            /*val toast = Toast.makeText(applicationContext, "Котик хочет кушать", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER, 0, 0)
            val toastLayout = layoutInflater.inflate(R.layout.custom_toast, findViewById(R.id.custom_toast_container))
            val textView = toastLayout.findViewById<TextView>(R.id.toast_text)
            textView.text = "Котик хочет кушать"
            val catImage = toastLayout.findViewById<ImageView>(R.id.toast_image)
            catImage.setImageResource(R.drawable.img)
            toast.view = toastLayout
            toast.show()*/
        }

        binding.btn4.setOnClickListener{
            val toastLayout = layoutInflater.inflate(R.layout.custom_toast, null)
            val toast = Toast(this)
            toast.view = toastLayout
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()

        }

        binding.btn5.setOnClickListener{
            val customToastBinding = CustomToastBinding.inflate(layoutInflater)
            customToastBinding.toastImage.setImageResource(R.drawable.img_2)
            customToastBinding.toastText1.text = "Этот текст установлен программно1"
            customToastBinding.toastText2.text = "Этот текст установлен программно2"
            customToastBinding.toastText1.setBackgroundColor(getColor(R.color.lightGray))
            customToastBinding.toastText2.setBackgroundColor(getColor(R.color.lightGray))

            val toast = Toast(this)
            toast.view = customToastBinding.customToastContainer
            toast.setGravity(Gravity.CENTER, 0 ,0)
            toast.show()
        }

        binding.btn6.setOnClickListener{
            val customToastBinding = CustomToastBinding.inflate(layoutInflater)
            customToastBinding.toastText1.text = binding.et1.text.toString()
            customToastBinding.toastText2.text = binding.et2.text.toString()

            val toast = Toast(this)
            toast.view = customToastBinding.customToastContainer
            toast.show()
        }
    }
}