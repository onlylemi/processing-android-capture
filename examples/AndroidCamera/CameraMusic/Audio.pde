import ddf.minim.*;
import ddf.minim.analysis.*;

Minim minim;
AudioPlayer audio;
FFT fft;

void initAudio(){
  minim = new Minim(this);
  audio= minim.loadFile("Say Something.mp3", 1024);
  audio.play();
}