import com.onlylemi.processing.android.capture.*;

PAndroidCamera ac;
PImage img;

void setup() {
  size(720, 480);
  ac = new PAndroidCamera(width, height, 30);
  ac.start();
}

void draw() {
  img = ac.getPImage();
  image(img, 0, 0);
}