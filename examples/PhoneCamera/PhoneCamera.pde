import com.onlylemi.processing.android.capture.*;

AndroidCapture ac;
PImage img;

void setup() {
  size(1280, 720);
  ac = new AndroidCapture(width, height, 30);
  ac.start();
}

void draw() {
  img = ac.getPImage();
  image(img, 0, 0);
}

void exit() {
  ac.exit();
}