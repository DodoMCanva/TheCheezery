package garcia.fernando.thecheezery

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var btnCold : Button = findViewById(R.id.button_cold_drink) as Button
        var btnHot : Button = findViewById(R.id.button_hot_drink) as Button
        var btnSweets : Button = findViewById(R.id.button_sweet) as Button
        var btnSalties : Button = findViewById(R.id.button_salties) as Button
        var btnCombos : Button = findViewById(R.id.button_combo) as Button
        var btnCustom : Button = findViewById(R.id.button_custom) as Button


        btnCold.setOnClickListener(){
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("categoria", "cold")
            startActivity(intent)
        }
        btnHot.setOnClickListener(){
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("categoria", "hot")
            startActivity(intent)
        }
        btnSweets.setOnClickListener(){
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("categoria", "sweet")
            startActivity(intent)
        }
        btnSalties.setOnClickListener(){
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("categoria", "salt")
            startActivity(intent)
        }
        btnCombos.setOnClickListener(){
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("categoria", "combo")
            startActivity(intent)
        }
        btnCustom.setOnClickListener(){
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("categoria", "c")
            startActivity(intent)
        }

    }
}