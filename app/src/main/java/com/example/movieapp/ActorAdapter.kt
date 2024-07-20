import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.Actor
import com.example.movieapp.databinding.ItemActorBinding

class ActorAdapter(private val dataList: List<Actor>) : RecyclerView.Adapter<ActorAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemActorBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(actor: Actor) {
            // Use Glide to load image
            Glide.with(binding.root.context)
                .load(actor.imageResId)
                .into(binding.actorImage)

            binding.actorName.text = actor.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemActorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
