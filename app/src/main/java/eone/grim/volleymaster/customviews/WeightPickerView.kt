package eone.grim.volleymaster.customviews

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.RequiresApi
import eone.grim.volleymaster.R

class WeightPickerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    val lineColor =  0xE2B56E
    private var currentValue = 60
    private val linePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = 0xFFFFC737.toInt()
        strokeWidth = context.dpToPx(5) // Extension function to convert dp to pixels
    }
    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = 0xFFFFC737.toInt()
        textSize = context.dpToPx(20) // Set the text size
        textAlign = Paint.Align.CENTER
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Draw the scale lines
        val lineHeight = 50f
        for (i in 0..100) {
            val lineLength = if (i == currentValue) lineHeight * 3 else if (i % 5 == 0)  lineHeight * 1.7f else lineHeight // Change the line length depending on the value
            canvas.drawLine(i*40f,height.toFloat(),i*40f,height - lineLength,linePaint)
        }
        canvas.scale(0.5f,0.5f)

        // Draw the central line
//        canvas.drawLine(/* ... */)

        // Draw the text
//        canvas.drawText("$currentValue kg", /* x */, /* y */, textPaint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        // Handle touch events to update currentValue
        return true
    }

    // Use this method to convert dp to pixel
    private fun Context.dpToPx(dp: Int): Float {
        return dp * resources.displayMetrics.density
    }
}
