import com.onlylemi.processing.android.capture.*;

PAndroidSensor as;

void setup() {
	size(720, 480);

	background(0);

	as = new PAndroidSensor(0);
	as.start();
}

void draw() {
	// get accelerometer sensor value
	//float[] values = as.getSensorValues(PSensorType.TYPE_ACCELEROMETER);
	float[] values = as.getAccelerometerSensorValues();
	float x = values[0];
	float y = values[1];
	float z = values[2];

	println(values);

	int r = (int) (11.0f * (11.0f + x));
	int g = (int) (11.0f * (11.0f + y));
	int b = (int) (11.0f * (11.0f + z));

	// background
	noStroke();
	fill(r, g, b, 25);
	rect(0, 0, width, height);

	// 3 circles
	float x1 = ((int) (width / 20 * (9.5f + (1.0f) * y)));
	float y1 = ((int) (height / 12 * (x + 6.0f)));
	fill(255, 0, 0);
	ellipse(x1, y1, 100, 100);

	float x2 = ((int) (width / 20 * (9.5f + (-1.0f) * x)));
	float y2 = ((int) (height / 12 * (y + 6.0f)));
	fill(0, 255, 0);
	ellipse(x2, y2, 100, 100);

	float x3 = ((int) (width / 20 * (9.5f + (1.0f) * x)));
	float y3 = ((int) (height / 12 * (y + 6.0f)));
	fill(0, 0, 255);
	ellipse(x3, y3, 100, 100);
}