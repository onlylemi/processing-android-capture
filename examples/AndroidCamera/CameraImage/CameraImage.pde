import com.onlylemi.processing.android.capture.*;

AndroidCamera ac;
PImage img;

void setup() {
  size(720, 480);
  ac = new AndroidCamera(width, height, 30);
  ac.start();
}

void draw() {
  img = ac.getCameraImage();
  image(img, 0, 0);
}