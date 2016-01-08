# processing-android-capture

## Lib介绍
这是一个有关 [processing](https://processing.org) 和 [android](https://android.com) 交互的`library`。通过`Android app`客户端获取手机的摄像头图像及各类传感器的数据通过局域网`WiFi`通信`socket`编程技术发送到`processing`服务端，服务端接受数据然后进行图像处理、数据应用。

## WHY
12月13日下午1点-3点，来自财新数据可视化实验室的执行总监**任远老师**在OF COURSE给大家进行[Live Coding+Music Visualization](http://e.vhall.com/686423389)现场表演！期间，任远老师在做视频和音乐的互动时，即兴的将观众融入到了作品中，用手机将现场的观众录制下来，然后将录制的视频进行播放，通过摄像头和音乐进行了实时的互动，观众成为了**live coding**的一部分，同时观众也参与了作品的创作。live coding并不是我一个人在写code，而是大家和我一起完成code。 在这个环节中手机正好可以当做这个媒介，如果我可以拿着手机把手机拍摄到的画面可以实时传到processing中处理，而不是先在现场录制一段视屏然后再播放处理这样效果是不是更好呢?

同时，大家都知道在processing里可以写程序直接采用**android-mode**执行，只要你的电脑中有**android-sdk**，就可以在android手机上运行，但是大家觉得运行效果如何呢？我只想说还能不能再卡点呀，本来一幅优美的画面，硬生生的给你放成慢动作，还是超慢动作啊。另外，[processing foundation](https://github.com/processing) 对 [processing-android](https://github.com/processing/processing-android) 的维护的又很少，所以性能也就不是很令人满意。但是，android手机是个很好的东西，凭借它有丰富的传感器、摄像头、画板以及它的灵活性，既然让它本身执行processing很卡，那为何不让它解放出来，只从它上获取数据，把数据交给processing pc端做处理呢?

正因为如此，这个库就诞生了。我称它为**processing-android-capture**。**capture**包括**android** `camera`、`sensor`。

废话不多说了，先看看Android App界面，然后上代码讲解。

## Android APP
![androidcapture1](https://raw.githubusercontent.com/onlylemi/AndroidCapture/master/androidcapture1.jpg)
Δ  android客户端 首页

![androidcapture1](https://raw.githubusercontent.com/onlylemi/AndroidCapture/master/androidcapture2.jpg)
Δ  android客户端 登录服务器界面（地址为processing 服务端的本地ip地址，pc端cmd进入命令行模式，输入ipconfig即可查看）

![androidcapture1](https://raw.githubusercontent.com/onlylemi/AndroidCapture/master/androidcapture3.jpg)
Δ  android客户端 颜色识别界面

![androidcapture1](https://raw.githubusercontent.com/onlylemi/AndroidCapture/master/androidcapture4.jpg)
Δ  android客户端 传感器选择界面

## 使用方法
1. 首先你需要在github上去下载processing-android-capture.jar及android客户端app  
**android app豌豆荚地址：** (http://www.wandoujia.com/apps/com.onlylemi.android.capture)
2. 在手机上安装app，processing项目中导入jar包到code文件夹下
3. pde文件中调用。一下分为`camera`、`sensor`两种情况进行阐释


### PAndroidCamera类
* 获取图像 **getCameraImage()**
* 获取颜色 **getColor()**

---

* 导包
```processing
// 导包
import com.onlylemi.processing.android.capture.*;
```
* 声明（**PAndroidCamera类**）
```processing
// 声明
PAndroidCamera ac;
PImage img;
```
* 在**setup**函数中初始化，并且开启捕捉
```processing
void setup() {
    size(720, 480);
    // 初始化对象
    // 参数含义： width 图像的宽
    //           height 图像的高
    //           30 frame速率
    ac = new PAndroidCamera(width, height, 30);
    ac.start();
};
```
* 在**draw**函数中调用**getCameraImage（）**函数获取图像
```processing
void draw() {
    // 获取图像
    img = ac.getCameraImage();
    image(img, 0, 0);
}
```
```processing
void draw(){
    translate(width / 2, height / 2);
    // 获取颜色
    int c = ac.getColor();
    fill(c);
    ellipse(0, 0, 300, 300);
}
```

至此 **PAndroidCamera** 类的功能就介绍完毕，具体效果在后面的实例中查看。

### PAndroidSensor类
* 提供Android手机的8大传感器  
* 加速度传感器（PSensorType.TYPE_ACCELEROMETER）  
调用函数**getAccelerometerSensorValues()**  
* 方向传感器（PSensorType.TYPE_ACCELEROMETER）  
调用函数**getOrientationSensorValues()**  
* 地磁传感器（PSensorType.TYPE_MAGNETIC_FIELD）   
调用函数**getMagneticFieldSensorValues()**
* 陀螺仪传感器（PSensorType.TYPE_GYROSCOPE）  
调用函数**getGyroscopeSensorValues()**
* 光线传感器（PSensorType.TYPE_LIGHT）  
调用函数**getLightSensorValues()**  
* 距离传感器（PSensorType.TYPE_PROXIMITY）  
调用函数**getProximitySensorValues()**
* 压力传感器（PSensorType.TYPE_PRESSURE）  
调用函数**getPressureSensorValues()**
* 温度传感器（PSensorType.TYPE_TEMPERATURE）  
调用函数**getTemperatureSensorValues()**

---

* 导包
```processing
// 导包
import com.onlylemi.processing.android.capture.*;
```
* 声明（**PAndroidSensor类**）
```processing
// 声明
PAndroidSensor as;
```
* 在**setup**函数中初始化，并且开启数据捕捉
```processing
void setup() {
	size(720, 480);
	background(0);
    // 初始化对象
    // 参数含义： 0 获取数据速率
	as = new PAndroidSensor(0);
	as.start();
}
```
* 在**draw**函数中调用相应函数进行数据获取（每种传感器数据获得都有两种方式）
```processing
void draw() {
	background(0);
	fill(255);
	textSize(15);
    // 每种传感器都有两种方法获取数据
	float[] values1 = as.getAccelerometerSensorValues();
	float[] values1 = as.getSensorValues(PSensorType.TYPE_ACCELEROMETER);

	float[] values2 = as.getOrientationSensorValues();
	float[] values2 = as.getSensorValues(PSensorType.TYPE_ORIENTATION);

	float[] values3 = as.getMagneticFieldSensorValues();
	float[] values3 = as.getSensorValues(PSensorType.TYPE_MAGNETIC_FIELD);

	float[] values4 = as.getGyroscopeSensorValues();
	float[] values4 = as.getSensorValues(PSensorType.TYPE_GYROSCOPE);

	float values5 = as.getLightSensorValues();
	float values5 = as.getSensorValues(PSensorType.TYPE_LIGHT)[0];

	float values6 = as.getProximitySensorValues();
	float values6 = as.getSensorValues(PSensorType.TYPE_PROXIMITY)[0];

	float values7 = as.getPressureSensorValues();
	float[] values7 = as.getSensorValues(PSensorType.TYPE_PRESSURE);

	float values8 = as.getTemperatureSensorValues();
	float values8 = as.getSensorValues(PSensorType.TYPE_TEMPERATURE);
}
```
至此 **PAndroidSensor** 类的功能就介绍完毕，具体效果在后面的实例中查看。

## 具体示例
代码1：[https://github.com/onlylemi/processing-android-capture/tree/master/examples/AndroidCamera/PhoneCamera](https://github.com/onlylemi/processing-android-capture/tree/master/examples/AndroidCamera/CameraImage)

效果1：  
![](https://raw.githubusercontent.com/onlylemi/processing-android-capture/master/camera_image.gif)

---

代码2：[https://github.com/onlylemi/processing-android-capture/tree/master/examples/AndroidCamera/CameraColor](https://github.com/onlylemi/processing-android-capture/tree/master/examples/AndroidCamera/CameraColor)

效果2：  
![](https://raw.githubusercontent.com/onlylemi/processing-android-capture/master/camera_color.gif)

---

代码3：[https://github.com/onlylemi/processing-android-capture/tree/master/examples/AndroidCamera/AccSensor](https://github.com/onlylemi/processing-android-capture/tree/master/examples/AndroidSensor/AccSensor)

效果3：  
![](https://raw.githubusercontent.com/onlylemi/processing-android-capture/master/sensor_color.gif)

--- 

代码4：[https://github.com/onlylemi/processing-android-capture/tree/master/examples/AndroidCamera/CameraMusic](https://github.com/onlylemi/processing-android-capture/tree/master/examples/AndroidCamera/CameraMusic)

效果4：  
![](https://raw.githubusercontent.com/onlylemi/processing-android-capture/master/camera_music.gif)

---

代码4：[https://github.com/onlylemi/processing-android-capture/tree/master/examples/AndroidCamera/CameraPixel](https://github.com/onlylemi/processing-android-capture/tree/master/examples/AndroidCamera/CameraPixel)  
效果4：  
![](https://raw.githubusercontent.com/onlylemi/processing-android-capture/master/camera_pixel.gif)

## END
本篇文章中所有提到的代码都是该**lib**提供的[examples](https://github.com/onlylemi/processing-android-capture/tree/master/examples)，都可以在**github**上下载到，因为processing是由java语言实现的，所以整个项目我是采用 [IntelliJ IDEA](https://www.jetbrains.com/idea/) IDE所实现（建议大家使用，写代码so爽），然后再转到**processing**下的。项目的android客户端使用 [Android studio](http://developer.android.com/sdk/index.html) 实现。所有代码都已开源到**github**上，欢迎大家指导批评。

Lib地址：[https://github.com/onlylemi/processing-android-capture](https://github.com/onlylemi/processing-android-capture)  
IDEA原项目地址：[https://github.com/onlylemi/P5AndroidCapture](https://github.com/onlylemi/P5AndroidCapture)  
Android APP地址：[https://github.com/onlylemi/AndroidCapture](https://github.com/onlylemi/AndroidCapture)

## CONTACT
**Eamil：** xiaomi_0623(AT)163.com  
**Wechat：** (AT)xiaomi-0623  
**Weibo：** [http://www.weibo.com/xiaomi0623](http://www.weibo.com/xiaomi0623)  
**Github：** [https://github.com/onlylemi](https://github.com/onlylemi)