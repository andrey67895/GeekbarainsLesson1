package Lesson_Six;

public class Animal {


    public void toRun(String name, Integer runningLength, Integer maxRunningLength) {
        if (runningLength > maxRunningLength) {
            System.out.println(name + " пробежал " + maxRunningLength + " м. и прилег отдохнуть. " + name + " еще хочет пройти " + (runningLength - maxRunningLength));
        } else if (runningLength < 0 && runningLength < Math.abs(maxRunningLength)) {
            System.out.println(name + " развернулся и пробежал " + Math.abs(runningLength) + " м.");
        } else if (runningLength < 0 && runningLength > Math.abs(maxRunningLength)) {
            System.out.println(name + " развернулся и пробежал " + Math.abs(runningLength) + " м. и прилег отдохнуть.");
        } else {
            System.out.println(name + " пробежал " + runningLength + " м.");
        }

    }

    public void toSwim(String name, Integer swimmingLength, Integer maxSwimLength) {
        if (swimmingLength > maxSwimLength) {
            System.out.println(name + " проплыл 10 метров, устал и вернулся на берег");
        } else if (swimmingLength < 0 && swimmingLength < Math.abs(maxSwimLength)) {
            System.out.println(name + " убежал от берега на " + Math.abs(swimmingLength) + " м.");
        } else if (swimmingLength < 0 && swimmingLength > Math.abs(maxSwimLength)) {
            System.out.println(name + " убежал от берега на " + Math.abs(swimmingLength) + " м.");
        } else {
            System.out.println(name + " проплыл " + swimmingLength + " м.");
        }
    }
}