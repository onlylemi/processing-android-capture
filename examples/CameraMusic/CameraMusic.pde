import com.onlylemi.processing.android.capture.*;

PhoneCapture pc;
PImage img;
PImage mask;

void setup(){
  size(1280, 720, P3D);
  frameRate(30);
  background(0);
  imageMode(CENTER);
  initAudio();
  
  pc = new PhoneCapture(width, height, 30);
  pc.start();
  
  mask = loadImage("mask.png");
}

void draw(){
  noStroke();
  fill(0, audio.mix.level() * 255);
  rect(0, 0, width, height);
  
  tint(255,25);
  img = pc.getPImage();
  img.mask(mask);
  float level = audio.mix.level() * 5;
  img.resize((int) (width * level), (int) (height * level));
  image(img, width / 2, height / 2);
}

void exit(){
  pc.exit();
}