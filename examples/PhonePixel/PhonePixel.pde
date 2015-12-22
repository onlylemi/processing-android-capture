import com.onlylemi.processing.android.capture.*;
import peasy.PeasyCam;

AndroidCapture ac;
PImage img;
PeasyCam cam;

void setup() {
  size(720, 480, P3D);

  cam = new PeasyCam(this, 500);

  ac = new AndroidCapture(width, height, 20);
  ac.start();
}

void draw(){
  background(0);
  translate(-width / 2, -height / 2);
  img = ac.getPImage();
  int steps = 10;
  for (int i = 0; i < width / steps; i++) {
    for (int j = 0; j < height / steps; j++) {
      pushMatrix();
      int c = img.get(i * steps, j * steps);
      float z = brightness(c);
      fill(c);
      noStroke();
      translate(i * steps, j * steps, z);
      box(steps - 2);
      popMatrix();
    }
  }
}

void exit(){
  ac.exit();
}