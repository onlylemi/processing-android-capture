# Processing-Android Camera Capture Lib
This library tries to transfer data between [Processing](https://processing.org) and [Android](https://android.com). I make a android app to capture the real-time video from ''Android camera''  through the socket to the server (processing server) with `WiFi`. The users use this lib to get phone camera capture in processing, then can do image processing. 

It's only beta named **''Beta1.0''**. Welcome to try it and if there is a problem, please contact me or new a issues. 

I will add most `Android sense` in **"Beta2.0"** and make it work in [openframeworks](http://www.openframeworks.cc/). 

## Folder
* **android-apk** 
  android phone client app in it.
*  **examples**
  There are some primitive examples in it. The users download them and load `.jar` file in the project. The `.jar` file is set the named `'code'` folder.
*  **library**
  The `processing-android-capture.jar` file in it.
*  **reference**
  The `javadoc` of this lib in it.
*  **src** 
  The source code of this lib in it.

## Android App
 **the source code of app : [https://github.com/onlylemi/AndroidCapture](https://github.com/onlylemi/AndroidCapture)**

## Examples
**1. A primitive example to get phone camera image :**

![enter image description here](https://raw.githubusercontent.com/onlylemi/processing-android-capture/master/camera_image.gif)
```processing
import com.onlylemi.processing.android.capture.*;

AndroidCapture ac;
PImage img;

void setup() {
  size(720, 480);
  ac = new AndroidCapture(width, height, 30);
  ac.start();
}

void draw() {
  // 获取图像帧
  img = ac.getPImage();
  image(img, 0, 0);
}
```


--


**2. A primitive example to get the middle color of phone camera :**

![enter image description here](https://raw.githubusercontent.com/onlylemi/processing-android-capture/master/camera_color.gif)
```processing
import com.onlylemi.processing.android.capture.*;

AndroidCapture ac;

void setup() {
  size(720, 480);
  
  ac = new AndroidCapture(width, height, 20);
  ac.start();
}

void draw(){
  background(0);
  
  translate(width / 2, height / 2);
  // 获取颜色
  int c = ac.getColor();
  fill(c);
  ellipse(0, 0, 300, 300);
}
```
