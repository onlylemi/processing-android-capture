import com.onlylemi.processing.android.capture.*;

AndroidCapture ac;
PImage img;

void setup() {
  size(720, 480);
  ac = new AndroidCapture(width, height, 30);
  ac.start();
}

void draw() {
  img = ac.getPImage();
  image(img, 0, 0);
}