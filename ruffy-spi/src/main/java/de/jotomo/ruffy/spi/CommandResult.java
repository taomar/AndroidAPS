package de.jotomo.ruffy.spi;

import android.support.annotation.Nullable;

import java.util.LinkedList;
import java.util.List;

import de.jotomo.ruffy.spi.history.Bolus;
import de.jotomo.ruffy.spi.history.PumpHistory;

public class CommandResult {
    /** Whether the command was executed successfully. */
    public boolean success;
    /** State of the pump *after* command execution. */
    public PumpState state;
    /** Bolus actually delivered if request was a bolus command. */
    public double delivered;
    /** History if requested by the command. */
    @Nullable
    public PumpHistory history;
    /** Basal rate profile if requested. */
    public BasalProfile basalProfile;

    /** Warnings raised on the pump that are forwarded to AAPS to be turned into AAPS
     * notifications. */
    public List<Integer> forwardedWarnings = new LinkedList<>();

    public int reservoirLevel = -1;

    @Nullable
    @Deprecated
    public Bolus lastBolus;

    public CommandResult success(boolean success) {
        this.success = success;
        return this;
    }

    public CommandResult state(PumpState state) {
        this.state = state;
        return this;
    }

    public CommandResult history(PumpHistory history) {
        this.history = history;
        return this;
    }

    public CommandResult basalProfile(BasalProfile basalProfile) {
        this.basalProfile = basalProfile;
        return this;
    }

    @Override
    public String toString() {
        return "CommandResult{" +
                "success=" + success +
                ", state=" + state +
                ", history=" + history +
                ", basalProfile=" + basalProfile +
                ", forwardedWarnings='" + forwardedWarnings + '\'' +
                ", lastBolus=" + lastBolus +
                '}';
    }
}
