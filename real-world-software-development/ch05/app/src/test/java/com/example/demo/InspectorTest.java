package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.List;
import org.junit.jupiter.api.Test;

class InspectorTest {

    @Test
    void inspectOneConditionEvaluateTestTrue() {
        Facts facts = new Facts();
        facts.addFact("jobTitle", "CEO");
        ConditionalAction jobTitleCondition = new JobTitleCondition();
        Inspector inspector = new Inspector(jobTitleCondition);

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

    @Test
    void segregationInterfaceWith() {
        Facts mockFacts = new Facts();
        mockFacts.addFact("jobTitle", "CEO");

        Condition condition = (Facts facts) -> "CEO".equals(
                facts.getFacts("jobTitle"));

        Action action = (Facts facts) -> {
            var name = facts.getFacts("name");
            System.out.println(name);
        };

        Rule rule = new DefaultRule(condition, action);

        rule.perform(mockFacts);

        assertThat(mockFacts.getFacts("jobTitle")).isEqualTo("CEO");
    }

    @Test
    void name() {
        Facts mockFacts = new Facts();
        mockFacts.addFact("jobTitle", "CEO");

        Condition condition = (Facts facts) -> "CEO".equals(
                facts.getFacts("jobTitle"));

        Action action = (Facts facts) -> {
            var name = facts.getFacts("name");
            System.out.println(name);
        };

        Rule rule = RuleBuilder.when(condition).then(action);

        rule.perform(mockFacts);

        assertThat(mockFacts.getFacts("jobTitle")).isEqualTo("CEO");
    }
}
