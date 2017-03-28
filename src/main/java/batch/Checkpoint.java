package main.java.batch;

import java.io.Serializable;

/**
 * Created by Kevin on 28-3-2017.
 */
public final class Checkpoint implements Serializable {
    private int eventCount;

    public Checkpoint() {
        eventCount = 0;
    }

    public final void eventHappened() {
        ++eventCount;
    }

    public final int getCount() {
        return eventCount;
    }
}
