import com.onlylemi.processing.android.capture.*;

PhoneCapture pc;

void setup() {
  size(720, 480);
  
  pc = new PhoneCapture(width, height, 20);
  pc.start();
}

void draw(){
  background(0);
  
  translate(width / 2, height / 2);
  
  int c = pc.getColor();
  fill(c);
  ellipse(0, 0, 300, 300);
}

void exit(){
  pc.exit();
}