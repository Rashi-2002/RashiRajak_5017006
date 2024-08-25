package com.Week45.bookstore.BookstoreAPI.metrics;



import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Counter;

@Component
public class CustomMetrics {

    private final Counter customCounter;

    public CustomMetrics(MeterRegistry meterRegistry) {
        this.customCounter = meterRegistry.counter("custom_metric", "type", "example");
    }

    public void incrementCustomMetric() {
        customCounter.increment();
    }
}
