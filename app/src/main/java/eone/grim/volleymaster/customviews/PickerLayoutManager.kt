package eone.grim.volleymaster.customviews

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.abs

class PickerLayoutManager(
    context: Context?,
    orientation: Int,
    reverseLayout: Boolean
) : LinearLayoutManager(context, orientation, reverseLayout) {

    private var midView: View? = null

    private var onScrollListener: OnScrollListener? = null

    // This method is called after the scroll has stopped
    private fun onScrollStopped() {
        midView?.let {
            onScrollListener?.onScrollSelection(it)
        }
    }
    override fun onLayoutChildren(recycler: RecyclerView.Recycler, state: RecyclerView.State) {
        super.onLayoutChildren(recycler, state)
        scaleDownView()
    }

    override fun scrollHorizontallyBy(dx: Int, recycler: RecyclerView.Recycler, state: RecyclerView.State): Int {
        if (orientation == HORIZONTAL) {
            val scrolled = super.scrollHorizontallyBy(dx, recycler, state)
            scaleDownView()
            return scrolled
        } else return 0
    }
    private fun scaleDownView() {
        val mid = width / 2.0f
        var closestDistance = Float.MAX_VALUE
        for (i in 0 until childCount) {
            val child = getChildAt(i) ?: continue
            val childMid = (getDecoratedLeft(child) + getDecoratedRight(child)) / 2.0f
            val distance = abs(mid - childMid)
            if (distance < closestDistance) {
                closestDistance = distance
                midView = child
            }

            val scale = when {
                i==10->1f
                i<10&&(i+1)%5==0 -> 0.55f
                i>10&&(i-1)%5==0 -> 0.55f
                else -> 0.3f
            }
            child.scaleY = scale
        }
        midView?.let { view ->
            onScrollListener?.onScrolling(view, getPosition(view))
        }
    }

    override fun onScrollStateChanged(state: Int) {
        super.onScrollStateChanged(state)
        if (state == RecyclerView.SCROLL_STATE_IDLE) {
            onScrollStopped()
        }
    }

    fun setOnScrollListener(listener: OnScrollListener) {
        onScrollListener = listener
    }

    interface OnScrollListener {
        fun onScrolling(view: View, position: Int)
        fun onScrollSelection(view: View)
    }
}
