package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

class BusinessRuleEngineTest {

    @Test
    void shouldPerformAnActionWithFacts() {
        final Action mockAction = mock(Action.class);
        Facts mockFacts = mock(Facts.class);
        BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFacts);

        businessRuleEngine.addAction(mockAction);
        businessRuleEngine.run();

        verify(mockAction).execute(mockFacts);
    }

    @Test
    void shouldAddActionWithFacts() {
        var env = new Facts();
        env.addFact("Mark", "CEO");

        BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(env);

        businessRuleEngine.addAction(facts -> {
            final String markName = facts.getFacts("Mark");
            if ("CEO".equals(markName)) {
                var name = facts.getFacts("name");
                System.out.println("Relevant customer: " + name);
            }
        });

        businessRuleEngine.run();

        assertThat(businessRuleEngine.count()).isEqualTo(1);
    }
}
