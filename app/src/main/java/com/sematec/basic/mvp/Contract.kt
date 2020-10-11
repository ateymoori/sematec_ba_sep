package com.sematec.basic.mvp

import com.sematec.basic.entities.HitsEntity

interface Contract {

    interface View {
        fun onResults(result: MutableList<HitsEntity>)
        fun onError(msg: String?)
        fun onLoading(show:Boolean)
    }

    interface Presenter {
        fun search(word: String)

    }


}