package com.jack.demo.matrix

import android.graphics.Matrix
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }

    private val matrix = Matrix()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val originMatrix = Matrix()
        originMatrix.setTranslate(50f, 25f)
        val array = FloatArray(9)
        originMatrix.getValues(array)
        logMatrix("matrix", array)

        originMatrix.invert(matrix)
        matrix.getValues(array)
        logMatrix("invert matrix", array)
        imageView.scaleType = ImageView.ScaleType.MATRIX        // do not forget
        imageView.imageMatrix = originMatrix
//        imageView.setImageDrawable(ColorDrawable(resources.getColor(android.R.color.black)))
        imageView.setImageDrawable(resources.getDrawable(R.drawable.icon))
    }

    private fun logMatrix(charSequence: CharSequence, array: FloatArray) {
        val builder = StringBuilder()
        array.forEachIndexed { index, fl ->
            builder.append("$fl\t")
            if ((index + 1) % 3 == 0) {
                builder.appendln()
            }
        }
        Log.d(TAG, "[$charSequence:\n$builder]")
    }
}
