package eone.grim.volleymaster.utils

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import eone.grim.volleymaster.R
import eone.grim.volleymaster.data.model.TrainingItem
import eone.grim.volleymaster.viewmodels.TrainingViewModel

class TrainingAdapter(private val trainingList: List<TrainingItem>,
                      private val listener: TrainingItemListener
) :    RecyclerView.Adapter<TrainingAdapter.TrainingViewHolder>() {


    interface TrainingItemListener {
        fun onItemSelected(trainingItem: TrainingItem)
    }
    inner class TrainingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val trainingImage: ImageView = itemView.findViewById(R.id.trainingIV)
        val trainingName: TextView = itemView.findViewById(R.id.trainingName)
        val trainingDesc: TextView = itemView.findViewById(R.id.trainingDesc)
        val trainingGoButton: Button = itemView.findViewById(R.id.trainingGo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_training, parent, false)
        return TrainingViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrainingViewHolder, position: Int) {
        val trainingItem = trainingList[position]
        Glide.with(holder.trainingImage.context)
            .load(trainingItem.imageResource)
            .into(holder.trainingImage)
        holder.trainingImage.setImageURI(Uri.parse(trainingItem.imageResource))
        holder.trainingName.text = trainingItem.trainingName
        holder.trainingDesc.text = trainingItem.trainingDesc
        holder.trainingGoButton.setOnClickListener {
            listener.onItemSelected(trainingItem)

        }
    }

    override fun getItemCount(): Int {
        return trainingList.size
    }
}
