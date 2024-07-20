import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.movieapp.Item
import com.example.movieapp.R

class CustomAdapter(private val context: Context, private val items: List<Item>) : BaseAdapter() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Any = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: inflater.inflate(R.layout.list_item, parent, false)

        val itemImage: ImageView = view.findViewById(R.id.item_image)
        val itemText1: TextView = view.findViewById(R.id.item_moviename)
        val itemText2: TextView = view.findViewById(R.id.item_category)
        val itemText3: TextView = view.findViewById(R.id.item_releasedate)

        val item = items[position]

        itemImage.setImageResource(item.imageResId)
        itemText1.text = item.moviename
        itemText2.text = item.category
        itemText3.text = item.releasedate

        return view
    }
}
