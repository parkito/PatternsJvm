package main.java.ru.siksmfp.java.patterns.command;

import java.util.Random;

public class Run implements Runnable {
    private Random random = new Random();
    private Job job;

    @Override
    public void run() {
        int rand = random.nextInt();
        if (rand % 3 == 0) {
            job = new RobotThreeJob(new RobotThree());
        } else if (rand % 2 == 0) {
            job = new RobotTwoJob(new RobotTwo());
        } else {
            job = new RobotOneJob(new RobotOne());
        }
        job.doJob();
    }
}
