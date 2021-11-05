package com.example.gastodeviagens

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        botao.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        val id = view?.id
        if (id == R.id.botao) calculate()
    }

    private fun calculate() = if (validationOK()) {

        try {
            val distance = distance.text.toString().toFloat()
            val price = price.text.toString().toFloat()
            val autonomy = autonomy.text.toString().toFloat()

            val result = (price * distance) / autonomy
            textovalortotal.text = "R$ ${"%.2f".format(result)}" //formatação do valor total

        } catch (erro: NumberFormatException) {
            Toast.makeText(this, getString(R.string.informe_valores_validos), Toast.LENGTH_LONG)
                .show()//alerta de notificação
        }

    } else {

        Toast.makeText(this, getString(R.string.preencha_os_campos), Toast.LENGTH_LONG)
            .show()//alerta de notificação
    }

    private fun validationOK(): Boolean {
        return (distance.text.toString() != "" &&
                price.text.toString() != "" &&
                autonomy.text.toString() != "" &&
                autonomy.text.toString() != "0")  //retorna verificação caso seja true


    }

}





