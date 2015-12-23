import com.onlylemi.processing.android.capture.*;

AndroidCapture ac;

void setup() {
  size(720, 480);
  
  ac = new AndroidCapture(width, height, 20);
  ac.start();
}

void draw(){
  background(0);
  
  translate(width / 2, height / 2);
  
  int c = ac.getColor();
  fill(c);
  ellipse(0, 0, 300, 300);
}