package eone.grim.volleymaster.ui.home.playerstats.collecting

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import eone.grim.volleymaster.R
import eone.grim.volleymaster.customviews.PickerLayoutManager
import eone.grim.volleymaster.databinding.FragmentPSWeightBinding

class PSWeightFragment : Fragment() {

    private val binding: FragmentPSWeightBinding by lazy {
        FragmentPSWeightBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = binding.root

        val viewPager2 = activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.next.setOnClickListener {
            viewPager2?.currentItem = 3
        }
        binding.back.setOnClickListener {
            viewPager2?.currentItem = 1
        }

        val rv = binding.weightPicker
        val sa = ScaleAdapter()
        val plm = PickerLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        plm.setOnScrollListener(object : PickerLayoutManager.OnScrollListener {
            override fun onScrolling(view: View, position: Int) {
                // Update UI here as the scrolling occurs
                "${sa.data[position]}".also { binding.weight.text = it }
            }

            override fun onScrollSelection(view: View) {
                // Update UI here when the scroll stops
                val position = rv.getChildLayoutPosition(view)
                "${sa.data[position]}".also { binding.weight.text = it }
            }
        })
        rv.layoutManager = plm
        rv.adapter = sa


        return view
    }

    class ScaleAdapter : RecyclerView.Adapter<ScaleAdapter.ScaleViewHolder>() {

        var data: List<Int> = (20..150).toList() //Minimum weight 20 Maximum weight 50
            get() = field
            @SuppressLint("NotifyDataSetChanged")
            set(value) {
                field = value
                notifyDataSetChanged()
            }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScaleViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.scale_item, parent, false)
            return ScaleViewHolder(view)
        }

        override fun onBindViewHolder(holder: ScaleViewHolder, position: Int) {

        }

        override fun getItemCount(): Int = data.size

        class ScaleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        }
}


}
