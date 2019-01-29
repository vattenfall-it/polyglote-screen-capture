package com.vattenfall.polyglot

import android.content.Context
import java.util.*

class LocaleManager {

    companion object {
        var locale: Locale? = null

        fun wrap(context: Context) : Context {
            if (locale != null) {
                val configuration = context.resources.configuration
                configuration.setLocale(locale)
                return context.createConfigurationContext(configuration)
            } else {
                return context
            }
        }

    }
}