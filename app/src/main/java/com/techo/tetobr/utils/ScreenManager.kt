package com.techo.tetobr.utils

import android.content.Context
import android.content.Intent
import com.techo.tetobr.activitys.MainActivity


class ScreenManager(private var context: Context?) {

    fun switchToMainActivity() {
        // Obtém a classe da tela de destino
        val destinationActivity: Class<*> = MainActivity::class.java

        // Cria uma intenção para iniciar a nova atividade
        val intent = Intent(context, destinationActivity)

        // Inicia a nova atividade
        context!!.startActivity(intent)
    }
}
