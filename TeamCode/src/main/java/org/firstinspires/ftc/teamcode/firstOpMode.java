package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="loganFirstOpMode")

public class firstOpMode extends LinearOpMode {

    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private Servo servoOne = null;

    @Override
    public void runOpMode() {leftDrive = hardwareMap.get(DcMotor.class, "leftMotor");
        rightDrive = hardwareMap.get(DcMotor.class, "rightMotor");
        servoOne = hardwareMap.get(Servo.class, "servoOne");

        waitForStart();
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        while (opModeIsActive() && !isStopRequested()) {
            double leftMotor = -gamepad1.left_stick_y;
            double rightMotor = -gamepad1.right_stick_y;
            double drive = -gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;
            leftMotor = Range.clip(drive + turn, -1.0, 1.0);
            rightMotor = Range.clip(drive - turn, -1.0, 1.0);
            double servoNegTwo = 0.3;
            double servoPosTwo = 0.6;

            leftDrive.setPower(leftMotor);
            rightDrive.setPower(rightMotor);
            if (gamepad1.a == true) {
                servoOne.setPosition(servoNegTwo + 0.001);
            } else if (gamepad1.b == true) {
                servoOne.setPosition(servoPosTwo - 0.001);
            }

        }

    }

}

