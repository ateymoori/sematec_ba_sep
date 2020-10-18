package com.sematec.basic.recyclerview

import com.sematec.basic.entities.HitsEntity

interface RecyclerContract {

    interface View {
        fun onImagesResult(images: List<HitsEntity>)
        fun onError(msg: String?)
        fun onActionsResult(actions: List<String>)
    }

    interface Presenter {
        fun onViewCreated()
        fun onImagesResult(images: List<HitsEntity>)
        fun onActionsResult(actions: List<String>)
        fun onError(msg: String?)
    }

    interface Model {
        fun getImages()
        fun getActions()

    }


}