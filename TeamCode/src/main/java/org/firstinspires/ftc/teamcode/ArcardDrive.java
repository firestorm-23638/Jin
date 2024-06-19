package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class ArcardDrive extends LinearOpMode {


    @Override
    public void runOpMode() throws InterruptedException {

        DcMotor frontLeft = this.hardwareMap.get(DcMotor.class, "frontLeft");
        DcMotor frontRight = this.hardwareMap.get(DcMotor.class, "frontRight");
        DcMotor backLeft = this.hardwareMap.get(DcMotor.class, "backLeft");
        DcMotor backRight = this.hardwareMap.get(DcMotor.class, "backRight");

        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);

        while(opModeIsActive()) {

            double y = -this.gamepad1.left_stick_y;
            double x = -this.gamepad1.right_stick_x;

        }


    }
}
