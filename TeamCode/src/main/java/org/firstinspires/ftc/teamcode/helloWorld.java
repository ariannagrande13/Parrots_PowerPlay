package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 *
 */
@TeleOp()
public class helloWorld extends OpMode {
    @Override
    public void init() {
        telemetry.addData("hello","World");
    }

    @Override
    public void loop() {



    }
}
//this code shows how much sid sucks