package eone.grim.volleymaster.ui.main.playerstats.collecting.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import eone.grim.volleymaster.R
import io.woong.wheelpicker.ValuePickerAdapter

class BasicNumberPickerAdapter : ValuePickerAdapter<Int, View>() {
    override fun createItemView(parent: ViewGroup): View {
        val inflater = LayoutInflater.from(parent.context)
        return inflater.inflate(R.layout.picker_item_p_s, parent, false)
    }

    override fun bindItemView(itemView: View, position: Int) {
        val value = getValue(position)
        itemView.findViewById<AppCompatTextView>(R.id.valueText).text = value.toString()
    }
}