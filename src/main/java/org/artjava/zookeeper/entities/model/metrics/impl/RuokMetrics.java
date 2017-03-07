package org.artjava.zookeeper.entities.model.metrics.impl;

/**
 * @author artJava
 * @date 2017-01-05 19:49
 * @since JDK1.7
 */
public class RuokMetrics {

    private boolean isOk;

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    @Override public String toString() {
        return "RuokMetrics{" + "isOk=" + isOk + '}';
    }
}
