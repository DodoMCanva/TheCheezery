package garcia.fernando.thecheezery

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProductosActivity : AppCompatActivity() {
    var productos = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)
        val categoria = intent.getStringExtra("categoria")
        agregarProductos(categoria)


        var listView : ListView = findViewById(R.id.listv) as ListView

        var adaptador: AdaptadorProductos = AdaptadorProductos(this, productos)
        listView.adapter = adaptador
    }

    fun agregarProductos(categoria: String?) {
        when (categoria) {
            "cold" -> {
                productos.add(Product("Caramel Frap", R.drawable.caramelfrap, "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.", 5.0))
                productos.add(Product("Chocolate Frap", R.drawable.chocolatefrap, "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.", 6.0))
                productos.add(Product("Cold Brew", R.drawable.coldbrew, "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.", 3.0))
                productos.add(Product("Matcha Latte", R.drawable.matcha, "Leafy taste of matcha green tea powder with creamy milk and a little sugar...", 4.0))
                productos.add(Product("Oreo Milkshake", R.drawable.oreomilkshake, "Chocolate ice cream, and oreo cookies. Topped with whipped cream...", 7.0))
                productos.add(Product("Peanut Milkshake", R.drawable.peanutmilkshake, "Vanilla ice cream, mixed with peanut butter and chocolate.", 7.0))
            }
            "hot" -> {
                productos.add(Product("Latte", R.drawable.latte, "Coffee drink made with espresso and steamed milk", 6.0))
                productos.add(Product("Hot chocolate", R.drawable.hotchocolate, "Heated drink with shaved chocolate, topped with marshmallows.", 5.0))
                productos.add(Product("Espresso", R.drawable.espresso, "Full-flavored, concentrated form of coffee.", 4.0))
                productos.add(Product("Chai Latte", R.drawable.chailatte, "Spiced tea concentrate with milk", 6.0))
                productos.add(Product("Capuccino", R.drawable.capuccino, "Espresso-based coffee drink with steamed foam.", 7.0))
                productos.add(Product("American coffee", R.drawable.americano, "Espresso with hot water", 2.0))
            }

            "sweet" -> {
                productos.add(Product("Blueberry cake", R.drawable.blueberrycake, "Vanilla cake topped with cheese topping and blueberries.", 6.0))
                productos.add(Product("Chocolate cupcake", R.drawable.chocolatecupcake, "Chocolate cupcakes topped with butter cream and cherries", 3.0))
                productos.add(Product("Lemon tartalette", R.drawable.lemontartalette, "Pastry shell with a lemon filling", 4.0))
                productos.add(Product("Red Velvet cake", R.drawable.redvelvetcake, "Soft, moist cake topped with cream cheese frosting.", 6.0))
                productos.add(Product("Cherry cheesecake", R.drawable.strawberrycheesecake, "Creamy cheesecake with cherry topping.", 7.0))
                productos.add(Product("Tiramisu", R.drawable.tiramisu, "Coffee-flavored Italian dessert", 6.0))
            }

            "salt" -> {
                productos.add(Product("Chicken crepes", R.drawable.chickencrepes, "Crepes stuffed with chicken, spinach and mushrooms.", 6.0))
                productos.add(Product("Club Sandwich", R.drawable.clubsandwich, "Delicious sandwich with fries.", 5.0))
                productos.add(Product("Panini", R.drawable.hampanini, "Grilled sandwich with Italian bread.", 4.0))
                productos.add(Product("Philly cheese steak", R.drawable.phillycheesesteak, "Steak with onions, peppers, and provolone.", 6.0))
                productos.add(Product("Nachos", R.drawable.nachos, "Tortilla chips with beef, cheddar, beans, and guac.", 7.0))
            }
        }
    }
    private class AdaptadorProductos : BaseAdapter{
        var productos = ArrayList<Product>()
        var contexto : Context? = null
        constructor(contexto: Context, productos: ArrayList<Product>){
            this.contexto = contexto
            this.productos = productos
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(position: Int): Any {
            return productos[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var prod = productos[position]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.producto_view, null)
            var imagen =  vista.findViewById(R.id.producto_img) as ImageView
            var nombre =  vista.findViewById(R.id.producto_nombre) as TextView
            var desc = vista.findViewById(R.id.producto_desc) as TextView
            var precio = vista.findViewById(R.id.producto_precio) as TextView

            imagen.setImageResource(prod.image)
            nombre.setText(prod.name)
            desc.setText(prod.description)
            precio.setText("$${prod.price}")

            return vista
        }
    }
}