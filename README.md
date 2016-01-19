# Processing-Android Camera&Sensor Capture Lib
This library tries to transfer data between [Processing](https://processing.org) and [Android](https://android.com). I make a android app to capture the real-time video from `"Android Camera"` and the real-time data from `"Android Sensor"` through the socket to the server (processing server) with `WiFi`. The users use this lib to get phone camera frame and sensors data in processing, then can do some interesting things. 
 
## NOTICE
The current version is **"2.0.1"**. Because of some library rule from processing.org, I only update some class name and delete 'P'. And other thing is same. Welcome to try it and if there is a problem, please contact me or new a issues. 

**Latest release**: [https://github.com/onlylemi/processing-android-capture/releases](https://github.com/onlylemi/processing-android-capture/releases)

I develope the whole project in [IntelliJ IDEA](https://www.jetbrains.com/idea/). The address of original project source: [https://github.com/onlylemi/P5AndroidCapture](https://github.com/onlylemi/AndroidCapture)


## Folder
* **android-apk** 
  android phone client app in it.  
  wandoujia:[http://www.wandoujia.com/apps/com.onlylemi.android.capture](http://www.wandoujia.com/apps/com.onlylemi.android.capture)
*  **examples**
  There are some primitive examples in it. The users download them and load `.jar` file in the project. The `.jar` file is set the named `'code'` folder.
*  **library**
  The `processing-android-capture.jar` file in it.
*  **src** 
  The source code of this lib in it.

## Android App
 **the source code of app :** [https://github.com/onlylemi/AndroidCapture](https://github.com/onlylemi/AndroidCapture)  
 **my test phone:** [meilan note2](http://www.meizu.com/products/meilannote2/spec.html) and `android5.1`

## Examples
### PAndroid Camera: 
* The users use the `getCameraImage()` function to get android client phone camera frame and it will return a `PImage` object in processing. 
*  The users use the `getColor()` function to get color from android phone camera and it return a `int` object. 


**1. A primitive example to get phone camera image :**

![android camera](https://raw.githubusercontent.com/onlylemi/processing-android-capture/master/camera_image.gif)
```processing
import com.onlylemi.processing.android.capture.*;

PAndroidCamera ac;
PImage img;

void setup() {
  size(720, 480);
  ac = new PAndroidCamera(width, height, 30);
  ac.start();
}

void draw() {
  // get android camera frame
  img = ac.getCameraImage();
  image(img, 0, 0);
}
```

--

**2. A primitive example to get the middle color of phone camera :**

![android camera color](https://raw.githubusercontent.com/onlylemi/processing-android-capture/master/camera_color.gif)
```processing
import com.onlylemi.processing.android.capture.*;

PAndroidCamera ac;

void setup() {
  size(720, 480);

  ac = new PAndroidCamera(width, height, 20);
  ac.start();
}

void draw() {
  background(0);
  translate(width / 2, height / 2);

  // get color from android camera
  int c = ac.getColor();
  fill(c);
  ellipse(0, 0, 300, 300);
}
```

### PAndroid Sensor: 
There is a class named `PAndroidSensor` in this lib. And there are **8** sensors from android phone. The users get sensor type in class named `PSensorType`. 

 * PSensorType.TYPE_ACCELEROMETER 
 * PSensorType.TYPE_LIGHT 
 * PSensorType.TYPE_ORIENTATION 
 * PSensorType.TYPE_PROXIMITY 
 * PSensorType.TYPE_TEMPERATURE 
 * PSensorType.TYPE_PRESSURE 
 * PSensorType.TYPE_GYROSCOPE 
 * PSensorType.TYPE_MAGNETIC_FIELD 


**1.  a example to get android sensor values:**

![android sensor data](https://raw.githubusercontent.com/onlylemi/processing-android-capture/master/sensor_data.gif)
```processing
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
  float[] values1 = as.getAccelerometerSensorValues();
  //float[] values1 = as.getSensorValues(PSensorType.TYPE_ACCELEROMETER);
  text("X : " + values1[0], 250, 50);
  text("Y : " + values1[1], 400, 50);
  text("Z : " + values1[2], 550, 50);

  text(PSensorType.TYPE_ORIENTATION + " : ", 60, 100);
  float[] values2 = as.getOrientationSensorValues();
  //float[] values2 = as.getSensorValues(PSensorType.TYPE_ORIENTATION);
  text("X : " + values2[0], 250, 100);
  text("Y : " + values2[1], 400, 100);
  text("Z : " + values2[2], 550, 100);

  text(PSensorType.TYPE_MAGNETIC_FIELD + " : ", 60, 150);
  float[] values3 = as.getMagneticFieldSensorValues();
  //float[] values3 = as.getSensorValues(PSensorType.TYPE_MAGNETIC_FIELD);
  text("X : " + values3[0], 250, 150);
  text("Y : " + values3[1], 400, 150);
  text("Z : " + values3[2], 550, 150);

  text(PSensorType.TYPE_GYROSCOPE + " : ", 60, 200);
  float[] values4 = as.getGyroscopeSensorValues();
  //float[] values4 = as.getSensorValues(PSensorType.TYPE_GYROSCOPE);
  text("X : " + values4[0], 250, 200);
  text("Y : " + values4[1], 400, 200);
  text("Z : " + values4[2], 550, 200);

  text(PSensorType.TYPE_LIGHT + " : ", 60, 250);
  float values5 = as.getLightSensorValues();
  //float values5 = as.getSensorValues(PSensorType.TYPE_LIGHT)[0];
  text("level : " + values5, 250, 250);

  text(PSensorType.TYPE_PROXIMITY + " : ", 60, 300);
  float values6 = as.getProximitySensorValues();
  //float values6 = as.getSensorValues(PSensorType.TYPE_PROXIMITY)[0];
  text("distance : " + values6, 250, 300);

  text(PSensorType.TYPE_PRESSURE + " : ", 60, 350);
  float values7 = as.getPressureSensorValues();
  //float[] values7 = as.getSensorValues(PSensorType.TYPE_PRESSURE);
  text("pressure : " + values7, 250, 350);

  text(PSensorType.TYPE_TEMPERATURE + " : ", 60, 400);
  float values8 = as.getTemperatureSensorValues();
  //float values8 = as.getSensorValues(PSensorType.TYPE_TEMPERATURE);
  text("temperature : " + values8, 250, 400);
}
```

--

**2.  a example to use android sensor values:**

![android sensor color](https://raw.githubusercontent.com/onlylemi/processing-android-capture/master/sensor_color.gif)

```processing
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
```

## CONTACT
**Eamil:** xiaomi_0623(AT)163.com  
**Wechat:** (AT)xiaomi-0623  
**Weibo:** [http://www.weibo.com/xiaomi0623](http://www.weibo.com/xiaomi0623)