package com.sematec.basic.recyclerview

import com.sematec.basic.entities.HitsEntity

class RecyclerPresenter(val view: RecyclerContract.View) : RecyclerContract.Presenter {

    lateinit var model: RecyclerContract.Model

    init {
        model = RecyclerModel(this)
    }

    override fun onViewCreated() {
        Thread{
            model.getImages()
            model.getActions()
        }.start()
    }

    override fun onImagesResult(images: List<HitsEntity>) {
        view.onImagesResult(images)
    }

    override fun onActionsResult(actions: List<String>) {
         view.onActionsResult(actions)
    }

    override fun onError(msg: String?) {
        view.onError(msg)
    }
}