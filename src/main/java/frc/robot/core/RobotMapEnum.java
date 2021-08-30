package frc.robot.core;

public enum RobotMapEnum {
    GAMEPAD(2),
    A_BUTTON(1),
    B_BUTTON(2),
    X_BUTTON(3),
    Y_BUTTON(4),
    L_BUMPER(5),
    R_BUMPER(6),
    LFB(7),
    RFB(8),
    L_JOYSTICK_X(0),
    L_JOYSTICK_Y(1),
    R_JOYSTICK_X(4),
    R_JOYSTICK_Y(5);

    private int map;

    public int getMap() {
        return this.map;
    }

    private RobotMapEnum(int map) {
        this.map = map;
    }
}
