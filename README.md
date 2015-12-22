# Processing-Android Camera Capture Lib
This library tries to transfer data between`processing` and `android`. I make a android app to capture the real-time video from ''Android camera''  through the socket to the server (processing server) with `WiFi`. The users use this lib to get phone camera capture in processing, then can do image processing. 

It's only beta named **''Beta1.0''**. Welcome to try it and if there is a problem, please contact me or new a issues.

####  **android app project : [https://github.com/onlylemi/AndroidCapture](https://github.com/onlylemi/AndroidCapture)**

**A primitive example to get phone camera image :**
```processing
import com.onlylemi.processing.android.capture.*;

AndroidCapture ac;
PImage img;

void setup() {
  size(720, 480);
  ac = new AndroidCapture(width, height, 30);
  pc.start();
}

void draw() {
  img = pc.getPImage();
  image(img, 0, 0);
}

void exit() {
  ac.exit();
}
```
---

**A primitive example to get the middle color of phone camera :**
```processing
import com.onlylemi.processing.android.capture.*;

AndroidCapture ac;

void setup() {
  size(720, 480);
  
  ac = new AndroidCapture(width, height, 20);
  pc.start();
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
