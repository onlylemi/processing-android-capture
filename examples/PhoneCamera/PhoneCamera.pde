import com.onlylemi.processing.android.capture.*;

PhoneCapture pc;
PImage img;

void setup() {
  size(1280, 720);
  pc = new PhoneCapture(width, height, 30);
  pc.start();
}

void draw() {
  img = pc.getPImage();
  image(img, 0, 0);
}

void exit() {
  pc.exit();
}