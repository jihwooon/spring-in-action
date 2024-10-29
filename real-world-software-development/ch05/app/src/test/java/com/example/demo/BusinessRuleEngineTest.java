package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BusinessRuleEngineTest {

    @Test
    void shouldHaveNoRulesInitially() {
        BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();

        assertThat(businessRuleEngine.count()).isEqualTo(0);
    }

    @Test
    void shouldAddTwoActions() {
        BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();

        businessRuleEngine.addAction(() -> {
        });
        businessRuleEngine.addAction(() -> {
        });

        assertThat(businessRuleEngine.count()).isEqualTo(2);

    }
}
