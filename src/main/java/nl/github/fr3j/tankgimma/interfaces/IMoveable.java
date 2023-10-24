package nl.github.fr3j.tankgimma.interfaces;

public interface IMoveable {
    void setMotion(double speed, double direction);

    void setRotate(double angle);

    void setSpeed(double speed);

    void setAngle(double angle);

    double getAngle();
}
