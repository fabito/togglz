package org.togglz.core.activation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

import org.togglz.core.spi.ActivationStrategy;

/**
 * Implementation of {@link ActivationStrategyProvider} that loads the strategies using the JDK {@link ServiceLoader}.
 * 
 * @author Jesse Kershaw
 */
public class DefaultActivationStrategyProvider implements ActivationStrategyProvider {

    private final List<ActivationStrategy> strategies = new ArrayList<ActivationStrategy>();

    public DefaultActivationStrategyProvider() {
        for (ActivationStrategy activationStrategy : ServiceLoader.load(ActivationStrategy.class)) {
            strategies.add(activationStrategy);
        }
    }

    public void addActivationStrategy(ActivationStrategy strategy) {
        this.strategies.add(strategy);
    }

    @Override
    public List<ActivationStrategy> getActivationStrategies() {
        return Collections.unmodifiableList(this.strategies);
    }

}
