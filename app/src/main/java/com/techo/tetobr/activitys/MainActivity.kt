package com.techo.tetobr.activitys

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.techo.tetobr.databinding.ActivityMainBinding // Importe a classe de binding gerada

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.let {

            it.btnCadastrar.setOnClickListener {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
            }
//            val handler = Handler(Looper.getMainLooper())
//            handler.postDelayed({
//                val intent = Intent(this, NewBoletosActivity::class.java)
//                startActivity(intent)
//            }, 100)
        }
    }
}
