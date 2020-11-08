package com.sematec.basic.image_handle

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.sematec.basic.R
import com.sematec.basic.utils.*
import id.zelory.compressor.Compressor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_upload_avatar.*
import java.io.File


class UploadAvatarActivity : BaseActivity(isFullScreen = true) {

    val CAMERA_R_CODE = 1000
    val GALLERY_R_CODE = 2000

    val compositeDisposable  = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_avatar)


        openGallery.setOnClickListener {
            getPermissions(ImageResourceType.GALLERY)
        }

        openCamera.setOnClickListener {
            getPermissions(ImageResourceType.CAMERA)
        }

    }

    private fun getPermissions(type: ImageResourceType) {
        Dexter.withContext(this)
            .withPermissions(
                android.Manifest.permission.CAMERA,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            ).withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport) { /* ... */
                    if (type == ImageResourceType.CAMERA) {
                        getImageFromCamera()
                    } else if (type == ImageResourceType.GALLERY) {
                        getImageFromGallery()
                    }

                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: List<PermissionRequest?>?,
                    token: PermissionToken?
                ) { /* ... */
                }
            }).check()
    }


    fun getImageFromCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, CAMERA_R_CODE)
    }

    fun getImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent , GALLERY_R_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == CAMERA_R_CODE) {
                val imageData = data?.extras?.get("data") as Bitmap
                avatar.load(this, imageData)
            }
            if (requestCode == GALLERY_R_CODE) {
                val uri = data?.data

                uri.toString().log("camera__ uri")

                if (uri != null) {
                    val fileAddress = FilePickUtils.getPath(this, uri)
                    val file = File(fileAddress)
                    file.length().toString().log("file_length")
                    compress(file)
                   /// compressAndUpload(file)
                }
            }
        } else {
            "selecting photo failed".toast()
        }

    }


    private fun compress(file: File) {

        compositeDisposable.add(
            //observable variables (RX)
            Compressor(this)
                .setMaxWidth(640)
                .setMaxHeight(480)
                .setQuality(80)
                .compressToFileAsFlowable(file)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

                .subscribe({file->
                    "Image has been compressed".toast()
                    avatar.load(this , file)
                    file.length().toString().log("file_length after compressing")
                }, {
                    it.message?.toast()
                })
        )
    }

}