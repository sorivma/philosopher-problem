package com.example.philosophermultithred;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Philosopher extends Thread{
    private final Spoon leftSpoon;
    private final Spoon rightSpoon;
    private final Circle philosopherCircle;
    private final UILogger uiLogger;
    private int philosopherId;

    public Philosopher(Spoon leftSpoon, Spoon rightSpoon, Circle philosopherCircle, UILogger uiLogger, int philosopherId) {
        this.leftSpoon = leftSpoon;
        this.rightSpoon = rightSpoon;
        this.philosopherCircle = philosopherCircle;
        this.uiLogger = uiLogger;
        this.philosopherId = philosopherId;
        System.out.println("philosopher created");
    }

    @Override
    public void run() {
        System.out.println("started running");
        try {
            while (true) {
                action(new Action(
                        Action.ActionType.THINKING,
                        System.nanoTime()));

                synchronized (leftSpoon) {
                    action(new Action(
                            Action.ActionType.TAKE_LEFT,
                            System.nanoTime()));
                    synchronized (rightSpoon) {
                        action(new Action(
                                Action.ActionType.TAKE_RIGHT,
                                System.nanoTime()
                        ));

                        action(new Action(
                                Action.ActionType.EATING,
                                System.nanoTime()
                        ));

                        action(new Action(
                                Action.ActionType.LAY_RIGHT,
                                System.nanoTime()
                        ));
                    }

                    action(new Action(
                            Action.ActionType.LAY_LEFT,
                            System.nanoTime()
                    ));

                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void action(Action action) throws InterruptedException {
        Thread.sleep(10);
        switch(action.getAction()) {
            case EATING -> philosopherCircle.setFill(Paint.valueOf("58E000"));
            case THINKING -> philosopherCircle.setFill(Paint.valueOf("1B1BB2"));
        }

//        synchronized (uiLogger) {
//            uiLogger.log(action, philosopherId);
//        }
        Thread.sleep((int) (100));
    }
}
