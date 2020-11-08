package com.sematec.basic.menu

import android.Manifest
import android.R.attr
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.sematec.basic.R
import com.sematec.basic.utils.FilePickUtils
import com.sematec.basic.utils.log
import com.sematec.basic.utils.toast
import id.zelory.compressor.Compressor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_menu.*
import java.io.File


class MenuActivity : AppCompatActivity() {
    private var compositeDisposable = CompositeDisposable()
    val GALLERY_CODE = 1000
    val CAMERA_CODE = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        //checkGalleryPermission()
        dialog()
    }

    private fun checkGalleryPermission() {
        Dexter.withContext(this)
            .withPermissions(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ).withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(p0: MultiplePermissionsReport?) {
                    // openGallery()
                   openCamera()
                }

                override fun onPermissionRationaleShouldBeShown(
                    p0: MutableList<com.karumi.dexter.listener.PermissionRequest>?,
                    p1: PermissionToken?
                ) {
                    TODO("Not yet implemented")
                }

            }).check()
    }


    private fun openCamera() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(takePictureIntent, CAMERA_CODE)
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK);
        intent.type = "image/*";
        this.startActivityForResult(intent, GALLERY_CODE);
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GALLERY_CODE) {
            val uri = data?.data
            if (uri != null && this != null) {
                val file = File(FilePickUtils.getPath(this, uri))
                compressAndUpload(file)
            }
        }
        if (requestCode == CAMERA_CODE) {
            val imageData = data?.extras?.get("data") as Bitmap
            Glide
                .with(this)
                .load(imageData)
                .centerCrop()
                .placeholder(R.drawable.material)
                .into(image)
        }

    }

    private fun compressAndUpload(file: File) {

        val cd  = CompositeDisposable()

        compositeDisposable.add(

            Compressor(this)
                .setMaxWidth(640)
                .setMaxHeight(480)
                .setQuality(80)
                .compressToFileAsFlowable(file)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

                .subscribe({
                    "Image has been compressed".toast()

                }, {
                    it.message?.toast()
                })
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(0, 100, 0, "Item1FromKotlin")
        menu?.add(0, 200, 0, "Item2FromKotlin")
        menuInflater.inflate(R.menu.main_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                "home".toast()
            }
            R.id.setting -> {
                "setting".toast()
            }
            R.id.profile -> {
                "profile".toast()
            }
            R.id.logOut -> {
                "logOut".toast()
            }
            100 -> {
                "Item1FromKotlin".toast()
            }
            200 -> {
                "Item2FromKotlin".toast()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    fun dialog(){
            val builder = AlertDialog.Builder(this)
            builder.setMessage("Hi")
                .setPositiveButton("k",{ dialog, id ->
                        // FIRE OK
                    })
                .setNegativeButton("No",{ dialog, id ->
                        // User cancelled the dialog
                    })
            builder.create().show()


    }

}