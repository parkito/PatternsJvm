package main.java.ru.siksmfp.java.patterns.command;

public class RobotOneJob implements Job {
    private RobotOne robot;

    public RobotOneJob(RobotOne robot) {
        this.robot = robot;
    }

    @Override
    public void doJob() {
        robot.killPeople();
    }
}
