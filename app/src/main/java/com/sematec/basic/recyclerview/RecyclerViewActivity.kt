package com.sematec.basic.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sematec.basic.R
import com.sematec.basic.entities.HitsEntity
import com.sematec.basic.utils.toast
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity(), RecyclerContract.View,
    ActionsAdapter.ClickOnAction, ImagesAdapter.ImageClickListener {

    lateinit var presenter: RecyclerContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        presenter = RecyclerPresenter(this)
        presenter.onViewCreated()
    }

    override fun onImagesResult(images: List<HitsEntity>) {
        runOnUiThread {
            val imagesAdapter = ImagesAdapter(this, images)
            imagesAdapter.onImageClickListener = this
            imagesList.adapter = imagesAdapter
        }
    }

    override fun onError(msg: String?) {
        runOnUiThread {
            msg?.toast()
        }
    }

    override fun onActionsResult(actions: List<String>) {
        runOnUiThread {
            val actionsAdapter = ActionsAdapter(this, actions)
            actionsAdapter.actionClickHandler = this
            actionElementsList.adapter = actionsAdapter
        }
    }

    override fun onActionClickListener(item: String) {
        "${item} in activity received".toast()
    }

    override fun onImageClicked(image: HitsEntity) {
        "onImageClicked".toast()
    }

    override fun onAvatarClicked(image: HitsEntity) {
        "onAvatarClicked".toast()
     }

    override fun onLikeClicked(image: HitsEntity) {
        "onLikeClicked".toast()
     }
}