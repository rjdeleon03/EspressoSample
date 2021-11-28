package com.pabsdl.espressotest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

import android.content.Context;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest2 {

    private ActivityScenario<MainActivity> mainActivityScenario;

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.pabsdl.espressotest", appContext.getPackageName());
    }

    @Before
    public void setup() {
        mainActivityScenario = ActivityScenario.launch(MainActivity.class);
        mainActivityScenario.moveToState(Lifecycle.State.RESUMED);
    }

    @Test
    public void testText() {
        onView(withId(R.id.main_text_view))
                .check(matches(withText("Hello, Ricardo!")));
        onView(withId(R.id.main_edit_text))
                .perform(ViewActions.typeText("World"));
        onView(ViewMatchers.isRoot()).perform(
                ViewActions.closeSoftKeyboard());
        onView(withId(R.id.main_button))
                .perform(ViewActions.click());
        onView(withId(R.id.main_text_view))
                .check(matches(withText("Hello, World!")));
    }
}