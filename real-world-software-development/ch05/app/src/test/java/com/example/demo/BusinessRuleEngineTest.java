package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

class BusinessRuleEngineTest {

    @Test
    void shouldPerformAnActionWithFacts() {
        Rule mockRule = mock(Rule.class);
        Facts mockFacts = mock(Facts.class);
        BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFacts);

        businessRuleEngine.addRule(mockRule);
        businessRuleEngine.run();

        verify(mockRule).perform(mockFacts);
    }

    @Test
    void shouldAddActionWithFacts() {
        var env = new Facts();
        env.addFact("Mark", "CEO");
        env.addFact("name", "Bob");

        BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(env);

        businessRuleEngine.addRule(facts -> {
            final String markName = facts.getFacts("Mark");
            if ("CEO".equals(markName)) {
                var name = facts.getFacts("name");
                System.out.println("Relevant customer: " + name);
            }
        });

        businessRuleEngine.run();

        assertThat(businessRuleEngine.count()).isEqualTo(1);
    }

    @Test
    void shouldCalculateTotalActionWith() {
        var env = new Facts();
        env.addFact("stage", "LEAD");
        env.addFact("amount", "15");

        BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(env);

        businessRuleEngine.addRule(facts -> {
            Stage dealStage = Stage.valueOf(facts.getFacts("stage"));
            double amount = Double.parseDouble(facts.getFacts("amount"));

            var forecastedAmount = amount * switch (dealStage) {
                case LEAD -> 0.2;
                case EVALUATING -> 0.5;
                case INTERESTED -> 0.8;
                case CLOSED -> 1;
            };

            facts.addFact("forecastedAmount", String.valueOf(forecastedAmount));
        });

        businessRuleEngine.run();

        assertThat(env.getFacts("forecastedAmount")).isEqualTo("3.0");
    }
}
