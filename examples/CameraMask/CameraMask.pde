import com.onlylemi.processing.android.capture.*;

PAndroidCamera ac;
PImage img;
PImage mask;

void setup(){
  size(1280, 720, P3D);
  frameRate(30);
  background(0);
  imageMode(CENTER);
  
  ac = new PAndroidCamera(width, height, 30);
  ac.start();
  
  mask = loadImage("mask.png");
}

void draw(){
  noStroke();
  fill(0, 25);
  rect(0, 0, width, height);
  
  tint(255,25);
  img = ac.getPImage();
  img.mask(mask);
  image(img, width / 2, height / 2);
}
