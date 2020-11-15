package com.sematec.basic.profile_view

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.constraintlayout.widget.ConstraintLayout
import com.sematec.basic.R
import kotlinx.android.synthetic.main.profile_view.view.*

class ProfileView   constructor(
    context: Context,
    attrs: AttributeSet? = null
) :ConstraintLayout(context, attrs ) {

    private var typedArray: TypedArray? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.profile_view, this, true)
        if (!isInEditMode) {
            attrs?.let {
                 typedArray = context.obtainStyledAttributes(it, R.styleable.ProfileView, 0, 0)
                 val userTitle = typedArray?.getString(R.styleable.ProfileView_userTitle) ?: "default"
                 val isMarried = typedArray?.getBoolean(R.styleable.ProfileView_married , false)

                nameFamily.text  = userTitle

                typedArray?.recycle()
            }
        }

    }

}