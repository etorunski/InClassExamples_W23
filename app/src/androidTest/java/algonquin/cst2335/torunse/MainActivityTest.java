package algonquin.cst2335.torunse;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        //find something on screen:
        ViewInteraction appCompatEditText = onView( withId(R.id.editText) );

        //do something with what you found: type in "abcde", hide the keyboard
        appCompatEditText.perform(replaceText("abcde"), closeSoftKeyboard());

        ViewInteraction materialButton = onView( withId(R.id.button) );
        materialButton.perform(click()); //click the button

        //do an assertion:
        appCompatEditText.check( matches(  withText( "Enter your password")) );
    }

    @Test
    public void mainActivityTest3() {
        //find something on screen:
        ViewInteraction appCompatEditText = onView( withId(R.id.editText) );

        //do something with what you found: type in "abcde", hide the keyboard
        appCompatEditText.perform(  replaceText("abcd"), closeSoftKeyboard());

        ViewInteraction materialButton = onView( withId(R.id.button) );
        materialButton.perform(click()); //click the button

        //do an assertion:
        appCompatEditText.check( matches(  withText( "abcd")) );
    }


    @Test
    public void mainActivityTest2() {
        //find something on screen:
        ViewInteraction appCompatEditText = onView( withId(R.id.editText) );

        //do something with what you found: type in "abcde", hide the keyboard
        appCompatEditText.perform(replaceText("ABCDE"), closeSoftKeyboard());

        ViewInteraction materialButton = onView( withId(R.id.button) );
        materialButton.perform(click()); //click the button

        //do an assertion:
        appCompatEditText.check( matches(  withText( "Your password is complex enough")) );
    }


    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}