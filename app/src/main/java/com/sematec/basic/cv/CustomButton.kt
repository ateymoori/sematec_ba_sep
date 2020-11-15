package com.sematec.basic.cv

import android.content.Context
import android.content.res.TypedArray

import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.sematec.basic.R


class CustomButton constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleRes) {

    private var typedArray: TypedArray? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.my_btn, this, true)
//        if (!isInEditMode) {
//            attrs?.let {
//                typedArray = context.obtainStyledAttributes(it, R.styleable.CustomButton, 0, 0)
//                setText(typedArray?.getString(R.styleable.CustomButton_button_text) ?: "button")
//                typedArray?.recycle()
//            }
//        }

    }

}