package com.zhuinden.testingapp;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static org.assertj.android.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@Config(constants = BuildConfig.class, sdk = 23)
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    MainActivity activity;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class); // buildActivity(activityClass).setup().get().create().start().postCreate(null).resume().visible();
    }

    @Test
    public void addition_isCorrect()
            throws Exception {
        assertThat(2+2).isEqualTo(4);
        //assertEquals(4, 2 + 2);
    }

    @Test
    public void showsHelloWorld() {
        TextView helloWorld = (TextView)activity.findViewById(R.id.main_hello_world);
        //assertThat(helloWorld.getText().toString()).isEqualTo("Hello World!");
        //assertThat(helloWorld.getText().toString()).is(new HamcrestCondition<>(Matchers.equalTo("Hello World!")));
        //assertThat("Did not display hello world", helloWorld.getText().toString(), Matchers.equalTo("Hello World!"));
        assertThat(helloWorld).containsText(R.string.hello_world);
    }

    @Test
    public void startsSecondActivity() {
        Button button = (Button)activity.findViewById(R.id.main_start_next);
        button.performClick();
        Intent expectedIntent = new Intent(activity, SecondActivity.class);

        ShadowActivity shadowActivity = Shadows.shadowOf(activity);
        Intent intent = shadowActivity.getNextStartedActivity();

        assertThat(intent).isNotNull();
        assertThat(intent.filterEquals(expectedIntent)).isTrue();
    }
}