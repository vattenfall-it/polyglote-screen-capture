package com.vattenfall.polyglot

import android.os.Environment.DIRECTORY_PICTURES
import android.os.Environment.getExternalStoragePublicDirectory
import android.support.test.runner.screenshot.BasicScreenCaptureProcessor
import java.io.File

/**
 * Created by Adam Styrc on 2018-08-10.
 */
class PolygloteScreenCaptureProcessor : BasicScreenCaptureProcessor() {

    init {
        this.mDefaultScreenshotPath = File(
                File(
                        getExternalStoragePublicDirectory(DIRECTORY_PICTURES),
                        "polyglote-screen-capture"
                ).absolutePath
        )
    }

    override fun getFilename(prefix: String): String = prefix
}