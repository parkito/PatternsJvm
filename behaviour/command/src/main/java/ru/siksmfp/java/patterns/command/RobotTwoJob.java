package main.java.ru.siksmfp.java.patterns.command;

public class RobotTwoJob implements Job {
    private RobotTwo robot;

    public RobotTwoJob(RobotTwo robot) {
        this.robot = robot;
    }

    @Override
    public void doJob() {
        robot.doWork();
    }
}
