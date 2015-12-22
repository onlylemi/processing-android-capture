# Processing-Android Camera Capture Lib
This library tries to transfer data between`processing` and `android`. I make a android app to capture the real-time video from ''Android camera''  through the socket to the server (processing server) with `WiFi`. The users use this lib to get phone camera capture in processing, then can do image processing. 

It's only beta named **''Beta1.0''**. Welcome to try it and if there is a problem, please contact me or new a issues.

## Folder
* **android-apk** 
  android phone client app in it.
*  **examples**
  There are some primitive examples in it. The users download them and load `.jar` file in the project. The `.jar` file is set the named `'code'` folder.
*  **library**
  The `processing-android-capture.jar` file in it.
*  **src** 
  The source code of this lib int it.

## Android App
 **the source code of app : [https://github.com/onlylemi/AndroidCapture](https://github.com/onlylemi/AndroidCapture)**

## Examples
**1. A primitive example to get phone camera image :**
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
  img = pc.getPImage();
  image(img, 0, 0);
}

void exit() {
  ac.exit();
}
```


--


**2. A primitive example to get the middle color of phone camera :**
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
  
  int c = ac.getColor();
  fill(c);
  ellipse(0, 0, 300, 300);
}

void exit(){
  ac.exit();
}
```



