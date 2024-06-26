package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;

@TeleOp
public class ArcardDrive extends LinearOpMode {


    @Override
    public void runOpMode() throws InterruptedException {

        DcMotor frontLeft = this.hardwareMap.get(DcMotor.class, "frontLeft");
        DcMotor frontRight = this.hardwareMap.get(DcMotor.class, "frontRight");
        DcMotor backLeft = this.hardwareMap.get(DcMotor.class, "backLeft");
        DcMotor backRight = this.hardwareMap.get(DcMotor.class, "backRight");
        DcMotor leftElevator = this.hardwareMap.get(DcMotor.class,"leftElevator");
        DcMotor rightElevator = this.hardwareMap.get(DcMotor.class, "rightElevator");
        Servo leftClaw = this.hardwareMap.get(Servo.class,"leftClaw");
        Servo rightClaw = this.hardwareMap.get(Servo.class,"rightClaw");
        Servo shooter = this.hardwareMap.get(Servo.class,"shooter");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        leftElevator.setDirection(DcMotorSimple.Direction.REVERSE);
        rightClaw.setDirection(Servo.Direction.REVERSE);

        waitForStart();


        while (opModeIsActive()) {

            double y = -this.gamepad1.left_stick_y;
            double x = -this.gamepad1.left_stick_x;
            double z = -this.gamepad1.right_stick_x;
            boolean a = this.gamepad1.left_bumper;
            boolean b = this.gamepad1.right_bumper;
            float triggerR = this.gamepad1.right_trigger;
            float triggerL = this.gamepad1.left_trigger;
            boolean droneButton = this.gamepad1.x;
            frontLeft.setPower(y - x - z);
            backLeft.setPower(y + x - z);
            backRight.setPower(y - x + z);
            frontRight.setPower(y + x + z);

            if (a) {
                leftElevator.setPower(1);
                rightElevator.setPower(1);
            }

            if (b) {
                leftElevator.setPower(-1);
                rightElevator.setPower(-1);
            }
            if (b == false && a == false) {
                leftElevator.setPower(0);
                rightElevator.setPower(0);
            }
            if (Double.compare(triggerL, 1) == 0) {
                leftClaw.setPosition(90);
                rightClaw.setPosition(90);
            }
            if (triggerR == 0) {
                leftClaw.setPosition(0);
                rightClaw.setPosition(0);

            }
            if (droneButton) {
                shooter.setPosition(-90);
            }
            else {
                shooter.setPosition(0);
            }
        }
    }
}