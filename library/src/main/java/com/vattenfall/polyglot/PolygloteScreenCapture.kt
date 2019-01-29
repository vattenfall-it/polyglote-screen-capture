package com.vattenfall.polyglot

import android.graphics.Bitmap
import android.os.Build
import android.support.test.InstrumentationRegistry
import android.support.test.runner.screenshot.Screenshot
import android.support.test.uiautomator.UiDevice
import java.io.IOException
import java.util.*

/**
 * Created by Adam Styrc on 2018-08-09.
 */
class PolygloteScreenCapture {

    companion object {
        private val PROCESSORS = setOf(PolygloteScreenCaptureProcessor())

        fun takeScreenshot(name: String) {
            val locale = getCurrentLocale()

            val capture = Screenshot.capture()
            capture.format = Bitmap.CompressFormat.PNG
            capture.name = "${name}_${locale.toLanguageTag()}"

            try {
                capture.process(PROCESSORS)
            } catch (ex: IOException) {
                throw IllegalStateException(ex)
            }
        }

        fun takeScreenshot(name: String, waitForIdle: Boolean = false) {
            if (waitForIdle) {
                UiDevice.getInstance(InstrumentationRegistry.getInstrumentation()).waitForIdle()
            }

            takeScreenshot(name)
        }

        private fun getCurrentLocale(): Locale {
            val configuration = InstrumentationRegistry.getTargetContext()
                .resources
                .configuration

            if (Build.VERSION.SDK_INT >= 24) {
                return configuration
                    .locales
                    .get(0)
            } else {
                return configuration.locale
            }

        }
    }
}
