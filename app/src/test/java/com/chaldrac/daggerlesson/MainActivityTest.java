package com.chaldrac.daggerlesson;

import android.widget.TextView;
import com.chaldrac.daggerlesson.ui.MainActivity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    private MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);

    @Test
    public void shouldInjectMockStringFactory() {
        TextView greeting = mainActivity.findViewById(R.id.greeting);
        assertEquals("Hello Komi!", greeting.getText());
    }

    @Test
    public void shouldInjectMagicNumber() {
        TextView number = mainActivity.findViewById(R.id.number);
        assertEquals("The magic number is 4", number.getText());
    }

}
