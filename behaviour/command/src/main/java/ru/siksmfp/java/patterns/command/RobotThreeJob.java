package main.java.ru.siksmfp.java.patterns.command;

public class RobotThreeJob implements Job {
    private RobotThree robotThree;

    public RobotThreeJob(RobotThree robotThree) {
        this.robotThree = robotThree;
    }

    @Override
    public void doJob() {
        robotThree.rescuePeople();
    }
}
