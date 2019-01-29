package com.vattenfall.polyglot_screen_capture;

import android.Manifest;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import com.adamstyrc.polyglot_screen_scapture.R;
import com.vattenfall.polyglot.LocaleRule;
import com.vattenfall.polyglot.PolygloteScreenCapture;
import org.junit.Rule;
import org.junit.Test;

import java.util.Locale;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class, false, false);
    @Rule
    public LocaleRule localeRule = new LocaleRule(new Locale.Builder().setLanguage("pl").build(), Locale.ENGLISH);
    @Rule
    public GrantPermissionRule permissionRule =
            GrantPermissionRule.grant(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE);

    @Test
    public void testMainActivity() throws Throwable {
        mActivityRule.launchActivity(new Intent());

        onView(withId(R.id.tvHello)).check(matches(withText(R.string.hello_world)));
        Thread.sleep(2000);
        PolygloteScreenCapture.Companion.takeScreenshot("main_activity");

        mActivityRule.finishActivity();
    }
}
