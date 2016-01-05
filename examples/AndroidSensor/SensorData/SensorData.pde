import com.onlylemi.processing.android.capture.*;

PAndroidSensor as;

void setup() {
	size(720, 480);

	background(0);

	as = new PAndroidSensor(0);
	as.start();
}

void draw() {
	background(0);
	fill(255);

	textSize(15);

	text(PSensorType.TYPE_ACCELEROMETER + " : ", 60, 50);
	text("X : " + as.getAccelerometerSensorValues()[0], 250, 50);
	text("Y : " + as.getAccelerometerSensorValues()[1], 400, 50);
	text("Z : " + as.getAccelerometerSensorValues()[2], 550, 50);

	text(PSensorType.TYPE_ORIENTATION + " : ", 60, 100);
	text("X : " + as.getOrientationSensorValues()[0], 250, 100);
	text("Y : " + as.getOrientationSensorValues()[1], 400, 100);
	text("Z : " + as.getOrientationSensorValues()[2], 550, 100);

	text(PSensorType.TYPE_MAGNETIC_FIELD + " : ", 60, 150);
	text("X : " + as.getMagneticFieldSensorValues()[0], 250, 150);
	text("Y : " + as.getMagneticFieldSensorValues()[1], 400, 150);
	text("Z : " + as.getMagneticFieldSensorValues()[2], 550, 150);

	text(PSensorType.TYPE_GYROSCOPE + " : ", 60, 200);
	text("X : " + as.getGyroscopeSensorValues()[0], 250, 200);
	text("Y : " + as.getGyroscopeSensorValues()[1], 400, 200);
	text("Z : " + as.getGyroscopeSensorValues()[2], 550, 200);

	text(PSensorType.TYPE_LIGHT + " : ", 60, 250);
	text("level : " + as.getLightSensorValues(), 250, 250);

	text(PSensorType.TYPE_PROXIMITY + " : ", 60, 300);
	text("distance : " + as.getProximitySensorValues(), 250, 300);

	text(PSensorType.TYPE_PRESSURE + " : ", 60, 350);
	text("pressure : " + as.getPressureSensorValues(), 250, 350);

	text(PSensorType.TYPE_TEMPERATURE + " : ", 60, 400);
	text("temperature : " + as.getTemperatureSensorValues(), 250, 400);
}