package org.firstinspires.ftc.teamcode.drivecode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class grabDriveCode extends LinearOpMode {
    @Override
    public void runOpMode() {
        DcMotor motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft");
        DcMotor motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");
        DcMotor motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight");
        DcMotor motorBackRight = hardwareMap.dcMotor.get("motorBackRight");

        DcMotor motorLift = hardwareMap.dcMotor.get("motorLift");
        Servo servoGrabber = hardwareMap.servo.get("servoGrabber");

        motorFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBackRight.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {

            double frontLiftPower = gamepad2.left_stick_y;

            double leftPower = gamepad1.left_trigger;
            double rightPower = gamepad1.right_trigger;

           /* double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;
            motorFrontLeft.setPower(frontLeftPower);
            motorBackLeft.setPower(backLeftPower);
            motorFrontRight.setPower(frontRightPower);
            motorBackRight.setPower(backRightPower); */

           if (gamepad1.left_stick_y > 0) {
               motorFrontLeft.setPower(leftPower);
               motorBackLeft.setPower(leftPower);
               motorFrontRight.setPower(rightPower);
               motorBackRight.setPower(rightPower);
           }

            if (gamepad1.left_stick_y < 0) {
                motorFrontLeft.setPower(-leftPower);
                motorBackLeft.setPower(-leftPower);
                motorFrontRight.setPower(-rightPower);
                motorBackRight.setPower(-rightPower);
            }
            if (gamepad1.right_trigger > 0) {
                motorFrontLeft.setPower(leftPower);
                motorBackLeft.setPower(-leftPower);
                motorFrontRight.setPower(-rightPower);
                motorBackRight.setPower(rightPower);
            }

            if (gamepad1.left_trigger > 0) {
                motorFrontLeft.setPower(-leftPower);
                motorBackLeft.setPower(leftPower);
                motorFrontRight.setPower(rightPower);
                motorBackRight.setPower(-rightPower);
            }

            if (gamepad1.right_stick_x < 0) {
                motorFrontLeft.setPower(-leftPower);
                motorBackLeft.setPower(-leftPower);
                motorFrontRight.setPower(rightPower);
                motorBackRight.setPower(rightPower);
            }

            if (gamepad1.right_stick_x > 0) {
                motorFrontLeft.setPower(leftPower);
                motorBackLeft.setPower(leftPower);
                motorFrontRight.setPower(-rightPower);
                motorBackRight.setPower(-rightPower);
            }

            motorLift.setPower(frontLiftPower);

            if (gamepad2.a) {
                servoGrabber.setPosition(0);
            }
            if (gamepad2.y) {
                servoGrabber.setPosition(1);
            }

        }
    }
}
