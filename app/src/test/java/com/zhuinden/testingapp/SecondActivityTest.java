package com.zhuinden.testingapp;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.assertj.android.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Owner on 2016.09.22.
 */
@Config(constants = BuildConfig.class, sdk = 23)
@RunWith(RobolectricTestRunner.class)
public class SecondActivityTest {

    SecondActivity activity;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(SecondActivity.class); // buildActivity(activityClass).setup().get().create().start().postCreate(null).resume().visible();
    }

    @Test
    public void showsSecondView() {
        SecondView secondView = (SecondView)activity.findViewById(R.id.second_root);
        assertThat(secondView).isVisible();
    }
}
