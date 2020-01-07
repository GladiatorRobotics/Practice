package RIO.java.src.org.team5109.frc.networktables;
import edu.wpi.first.networktables.*;
public class imudata{
    NetworkTableInstance inst = NetworkTableInstance.getDefault();
    NetworkTable visiontable;
    double midpoint;
	double midpointFeet;
    double centerpoint = 0;
    double point_x1;
    double point_x2;
    double point_y1;
    double point_y2;
    double point_x3;
    double point_y3;
    double point_x4;
    double point_y4;
    double point_midx;
    double point_midy;
    double slope;

    public void VisionGetTable(){
    visiontable = inst.getTable("Vision Table");
    //System.out.println(visiontable.getKeys());
    }
    
    public void PointData(){
    point_x1 = visiontable.getEntry("Point1X").getDouble(0);
    point_y1 = visiontable.getEntry("Point1Y").getDouble(0);
    point_x2 = visiontable.getEntry("Point2X").getDouble(0);
    point_y2 = visiontable.getEntry("Point2Y").getDouble(0);
    point_x3 = visiontable.getEntry("Point3X").getDouble(0);
    point_y3 = visiontable.getEntry("Point3Y").getDouble(0);
    point_x4 = visiontable.getEntry("Point4X").getDouble(0);
    point_midx = visiontable.getEntry("MidpointX").getDouble(0);
    point_midy = visiontable.getEntry("MidpointY").getDouble(0);
    
    midpoint = visiontable.getEntry("Midpoint").getDouble(0);
    

    slope = (point_y2-point_y1)/(point_x2-point_x1);
    //midpoint = (point_x1+point_x2)/2;
    midpointFeet = Math.abs(300 - midpoint) / 700;

    //System.out.println(midpoint);
    /*
    System.out.println("Point 1 X: " + point_x1);
    System.out.println("Point 1 Y: " + point_y1);
    System.out.println("Point 2 X: " + point_x2);
    System.out.println("Point 2 Y: " + point_y2);
    System.out.println("Point 3 X: " + point_x3);
    System.out.println("Point 3 Y: " + point_y3);
    System.out.println("Point 4 X: " + point_x4);
    System.out.println("Point 4 Y: " + point_y4);
    System.out.println("Midpoint" + midpoint);
    System.out.println("Midpointfeet" + midpointFeet);
    */


}
public double getpoint_midx() {
    return point_midx;
}
public double getpoint_midy() {
    return point_midy;
}
public double getslope() {
    return slope;
}
public double getmidfeet(){
    return midpointFeet;
}
public double getmidpoint() {
    return midpoint;
}
   /* if(operator.getRawButton(8) == true) {
        System.out.println("buttonispressed");
        
        centering();
    }
    else {
        midpoint = (point_x2 + point_x1) / 2;
        midpointFeet = Math.abs(300 - midpoint) * 0.00236111;
        Counter = 0;
        leftMotor1.set(ControlMode.PercentOutput, 0);
        leftMotor2.set(ControlMode.PercentOutput, 0);
        rightMotor1.set(ControlMode.PercentOutput, 0);
        rightMotor2.set(ControlMode.PercentOutput, 0);
    } */

}