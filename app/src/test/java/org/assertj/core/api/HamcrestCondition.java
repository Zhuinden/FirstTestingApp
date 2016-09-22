package org.assertj.core.api;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;

/**
 * Allows to use a Hamcrest matcher as a condition.
 *
 * Example:
 * <pre><code class='java'> Condition&lt;String&gt; aStringContainingA = new HamcrestCondition&lt;&gt;(containsString(&quot;a&quot;));
 *
 * // assertions will pass
 * assertThat(&quot;abc&quot;).is(aStringContainingA);
 * assertThat(&quot;bc&quot;).isNot(aStringContainingA);
 *
 * // assertion will fail
 * assertThat(&quot;bc&quot;).is(aStringContainingA);</code></pre>
 */
public class HamcrestCondition<T>
        extends Condition<T> {

    private Matcher<T> matcher;

    /**
     * Constructs a {@link Condition} using the matcher given as a parameter.
     *
     * @param matcher the Hamcrest matcher to use as a condition
     */
    public HamcrestCondition(Matcher<T> matcher) {
        this.matcher = matcher;
        as(describeMatcher());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean matches(T value) {
        return matcher.matches(value);
    }

    private String describeMatcher() {
        Description d = new StringDescription();
        matcher.describeTo(d);
        return d.toString();
    }
}