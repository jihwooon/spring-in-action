package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

class BusinessRuleEngineTest {

    @Test
    void shouldHaveNoRulesInitially() {
        BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();

        assertThat(businessRuleEngine.count()).isZero();
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

    @Test
    void shouldExecuteOneAction() {
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();
        final Action mockAction = mock(Action.class);

        businessRuleEngine.addAction(mockAction);
        businessRuleEngine.run();

        verify(mockAction).execute();

        assertThat(businessRuleEngine.count()).isEqualTo(1);
    }
}
