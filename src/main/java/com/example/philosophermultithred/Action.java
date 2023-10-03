package com.example.philosophermultithred;

public class Action {
    private ActionType action;
    private long nanoTime;

    public Action(ActionType action, long nanoTime) {
        this.action = action;
        this.nanoTime = nanoTime;
    }

    public ActionType getAction() {
        return action;
    }

    public void setAction(ActionType action) {
        this.action = action;
    }

    public long getNanoTime() {
        return nanoTime;
    }

    public void setNanoTime(long nanoTime) {
        this.nanoTime = nanoTime;
    }

    public enum ActionType {
        THINKING,
        EATING,
        TAKE_LEFT,
        TAKE_RIGHT,
        LAY_LEFT,
        LAY_RIGHT
    }
}
