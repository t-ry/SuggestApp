package app.takahashi.kamesan.originalapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter: RecyclerView.Adapter<ListAdapter.gameViewHolder>() {

    var gameList = emptyList<GameInfo>()

    class gameViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.text_view)
        val container: View = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): gameViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item, parent, false)
        return gameViewHolder(view)
    }

    var itemClickListener: OnItemClickListener? = null

    interface OnItemClickListener{
        fun onItemClick(gameId: Int)
    }

    override fun getItemCount() = gameList.size

    override fun onBindViewHolder(holder: gameViewHolder, position: Int) {
        val currentItem = gameList[position]
        holder.textView.text = currentItem.gameTitle
        holder.container.setOnClickListener{
            itemClickListener?.onItemClick(currentItem.gameId)
        }
    }

    fun setData(game: List<GameInfo>) {
        this.gameList = game
        notifyDataSetChanged()
    }

}
