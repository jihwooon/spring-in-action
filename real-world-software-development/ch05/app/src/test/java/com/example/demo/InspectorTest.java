package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class InspectorTest {

    @Test
    void inspectOneConditionEvaluateTestTrue() {
        Facts facts = new Facts();
        facts.addFact("jobTitle", "CEO");
        ConditionalAction condition = new JobTitleCondition();
        Inspector inspector = new Inspector(condition);

        List<Report> inspect = inspector.inspect(facts);

        assertThat(inspect.size()).isEqualTo(1);

    }

    private class JobTitleCondition implements ConditionalAction {

        @Override
        public void perform(Facts facts) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean evaluate(Facts facts) {
            return "CEO".equals(facts.getFacts("jobTitle"));
        }
    }
}
