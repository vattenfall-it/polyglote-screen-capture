package com.vattenfall.polyglot

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import java.util.*



/**
 * Created by Adam Styrc on 2018-08-09.
 */

class LocaleRule(vararg val locales: Locale = arrayOf(Locale.ENGLISH)) : TestRule {

    private var mDeviceLocale: Locale? = null

    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                try {
                    mDeviceLocale = Locale.getDefault()
                    for (locale in locales) {
                        setLocale(locale)
                        base.evaluate()
                    }
                } finally {
                    if (mDeviceLocale != null) {
                        setLocale(mDeviceLocale!!)
                    }
                }
            }
        }
    }

    private fun setLocale(locale: Locale) {
        LocaleManager.locale = locale
    }
}