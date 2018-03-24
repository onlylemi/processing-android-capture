# AndroidCapture For Processing

![Logo](https://raw.githubusercontent.com/onlylemi/res/master/processing-android-capture-logo.gif)

> * 已被 [processing.org](https://processing.org/reference/libraries/) 官方收录
> * 已被 [creativecoding.cn](http://creativecoding.cn/?p=587) 收录
> * 已被 [OF COURSE](http://mp.weixin.qq.com/s?__biz=MzA4NTc5MDU5OQ==&mid=410954063&idx=1&sn=cd94026161ffc4862a4397571041d605&3rd=MzA3MDU4NTYzMw==&scene=6#rd) 收录


## Lib介绍

这是一个有关 [processing](https://processing.org) 和 [android](https://android.com) 交互的`library`。通过`Android app`客户端获取手机的摄像头图像及各类传感器的数据通过局域网`WiFi`通信`socket`编程技术发送到`processing`服务端，服务端接受数据然后进行图像处理、数据应用。

## WHY

本是一只**程序猿**，由于开发 **android** 项目需求，无意中发现了 **processing** 这门语言，效果真是太赞了，本来打算用它来做 **ui/animation** 的，可是它的 android 的库不是很好，社区维护的又少之又少，也就放弃了使用。

可是它的效果不得不佩服呀，简单的几句代码就可以勾勒出一幅优美的画面，做**可视化（我最喜欢做的）**又是如此方便，所以就拿 processing 玩起来了。前段时间做的一个**室内地磁导航 app**，在给大家讲地磁导航原理的时候讲了又讲，可是大家就是不明白，最后用做了一个简单地磁导航原理模拟动画，大家瞬间明白。在不断的尝试后，越来越喜欢这门语言，现在一有空就会拿出来玩玩。**手握程序，不仅可以写应用，还可以娱乐、画画，真是给程序猿枯燥的生活添加了一笔别样的色彩（“一只不务正业的程序猿”就这样来了）**。哈哈，程序猿也不是你想的那样无趣的，这样的多好啊！

![室内导航原理模型](https://raw.githubusercontent.com/onlylemi/res/master/android-indoor-visual.gif)

另外，大家都知道在 **processing** 里可以写程序直接采用 **android-mode** 执行，只要你的电脑中有 **android-sdk**，就可以在 android 手机上运行，但是大家觉得运行效果如何呢？我只想说还能不能再卡点呀，本来一幅优美的画面，硬生生的给你放成慢动作，还是超慢动作啊。另外，**[processing foundation](https://github.com/processing)** 对 **[processing-android](https://github.com/processing/processing-android)** 的维护的又很少，所以性能也就不是很令人满意。但是，作为一名android开发者，我认为android手机是个很好的东西啊，凭借它有丰富的**传感器**、**摄像头（本文的库就是干）**、**画板**以及它的可移动、灵活的特点，既然让它本身执行processing很卡，那为何不让它解放出来，只从它上获取数据，把数据交给processing pc端做处理呢？

> 12月13日下午1点-3点，来自财新数据可视化实验室的执行总监**[任远老师](http://yuanren.cc/)**在 **[OF COURSE](http://www.ofcourse.io/)** 给大家进行 [Live Coding+Music Visualization](http://e.vhall.com/686423389) 现场表演！期间，任远老师在做视频和音乐的互动时，即兴的将观众融入到了作品中，用手机将现场的观众录制下来，然后将录制的视频进行播放，通过摄像头和音乐进行了实时的互动，观众成为了 **live coding** 的一部分，同时观众也参与了作品的创作。live coding 并不是我一个人在写 code，而是大家和我一起完成code。 在这个环节中手机正好可以当做这个媒介，如果我可以拿着手机把手机拍摄到的画面可以实时传到processing中处理，而不是先在现场录制一段视屏然后再播放处理这样效果是不是更好呢?  
**Live coding代码**：[https://github.com/onlylemi/MusicVisual](https://github.com/onlylemi/MusicVisual)

正因为如此，我就决定开发一个 processing 和 android 交互的库，供大家来使用，同时，**作为一个只用p rocessing 从来就没给[foundation](https://github.com/processing) 捐赠过的人，写这样一个lib来为社区做点贡献，这样心里应该会好过点吧。。。**

就这样这个库诞生了。我称它为 **AndroidCapture For Processing**。**capture** 包括**android** `camera`、`sensor`。

废话不多说了，先看看 Android App 界面，然后给大家撸代码讲解。  

## Android APP

![androidcapture1](https://raw.githubusercontent.com/onlylemi/res/master/androidcapture1.jpg)  
Δ  android 客户端 首页

![androidcapture2](https://raw.githubusercontent.com/onlylemi/res/master/androidcapture2.jpg)  
Δ  android 客户端 登录服务器界面（地址为 processing 服务端的本地ip地址，pc 端 cmd 进入命令行模式，输入 ipconfig 即可查看本地局域网 ip 地址）

![androidcapture3](https://raw.githubusercontent.com/onlylemi/res/master/androidcapture3.jpg)  
Δ  android 客户端 颜色识别界面

![androidcapture4](https://raw.githubusercontent.com/onlylemi/res/master/androidcapture4.jpg)  
Δ  android 客户端 传感器选择界面

## 使用方法

1. 首先你需要在 github 上去下载 AndroidCaptureForProcessing.jar 及 android 客户端 app  
**android app 豌豆荚地址:** [http://wandoujia.com/apps/com.onlylemi.android.capture](http://wandoujia.com/apps/com.onlylemi.android.capture)
2. 在手机上安装 app，processing 项目中导入 jar 包到 code 文件夹下
3. pde 文件中调用。一下分为`camera`、`sensor`两种情况进行阐释


### PAndroidCamera类

* 获取图像 **getCameraImage()**
* 获取颜色 **getColor()**

#### 使用步骤

1、导包

```java
// 导包
import com.onlylemi.processing.android.capture.*;
```

2、声明（**AndroidCamera类**）


```java
// 声明
AndroidCamera ac;
PImage img;
```

3、在 **setup** 函数中初始化，并且开启捕捉

```java
void setup() {
    size(720, 480);
    // 初始化对象
    // 参数含义： width 图像的宽
    //           height 图像的高
    //           30 frame速率
    ac = new AndroidCamera(width, height, 30);
    ac.start();
};
```

4、在 **draw** 函数中调用**getCameraImage()**函数获取图像

```java
void draw() {
    // 获取图像
    img = ac.getCameraImage();
    image(img, 0, 0);
}
```
```java
void draw(){
    translate(width / 2, height / 2);
    // 获取颜色
    int c = ac.getColor();
    fill(c);
    ellipse(0, 0, 300, 300);
}
```

至此 **AndroidCamera** 类的功能就介绍完毕，具体效果在后面的实例中查看。

### PAndroidSensor类

* 提供Android手机的8大传感器  
* 加速度传感器（SensorType.TYPE_ACCELEROMETER）  
调用函数**getAccelerometerSensorValues()**  
* 方向传感器（SensorType.TYPE_ACCELEROMETER）  
调用函数**getOrientationSensorValues()**  
* 地磁传感器（SensorType.TYPE_MAGNETIC_FIELD）   
调用函数**getMagneticFieldSensorValues()**
* 陀螺仪传感器（SensorType.TYPE_GYROSCOPE）  
调用函数**getGyroscopeSensorValues()**
* 光线传感器（SensorType.TYPE_LIGHT）  
调用函数**getLightSensorValues()**  
* 距离传感器（SensorType.TYPE_PROXIMITY）  
调用函数**getProximitySensorValues()**
* 压力传感器（SensorType.TYPE_PRESSURE）  
调用函数**getPressureSensorValues()**
* 温度传感器（SensorType.TYPE_TEMPERATURE）  
调用函数**getTemperatureSensorValues()**

#### 使用步骤

1、导包

```java
// 导包
import com.onlylemi.processing.android.capture.*;
```

2、声明（**PAndroidSensor类**）

```java
// 声明
AndroidSensor as;
```

3、在 **setup** 函数中初始化，并且开启数据捕捉

```java
void setup() {
    size(720, 480);
    background(0);
    // 初始化对象
    // 参数含义： 0 获取数据速率
    as = new AndroidSensor(0);
    as.start();
}
```

4、在 **draw** 函数中调用相应函数进行数据获取（每种传感器数据获得都有两种方式）

```java
void draw() {
    background(0);
    fill(255);
    textSize(15);
    // 每种传感器都有两种方法获取数据
    float[] values1 = as.getAccelerometerSensorValues();
    float[] values1 = as.getSensorValues(SensorType.TYPE_ACCELEROMETER);
    
    float[] values2 = as.getOrientationSensorValues();
    float[] values2 = as.getSensorValues(SensorType.TYPE_ORIENTATION);


    float[] values3 = as.getMagneticFieldSensorValues();
    float[] values3 = as.getSensorValues(SensorType.TYPE_MAGNETIC_FIELD);

    float[] values4 = as.getGyroscopeSensorValues();
    float[] values4 = as.getSensorValues(SensorType.TYPE_GYROSCOPE);

    float values5 = as.getLightSensorValues();
    float values5 = as.getSensorValues(SensorType.TYPE_LIGHT)[0];

    float values6 = as.getProximitySensorValues();
    float values6 = as.getSensorValues(SensorType.TYPE_PROXIMITY)[0];

    float values7 = as.getPressureSensorValues();
    float[] values7 = as.getSensorValues(SensorType.TYPE_PRESSURE);

    float values8 = as.getTemperatureSensorValues();
    float values8 = as.getSensorValues(SensorType.TYPE_TEMPERATURE);
}
```
 
至此 **AndroidSensor** 类的功能就介绍完毕，具体效果在后面的实例中查看。

## 具体示例

代码1：[CameraImage](https://github.com/onlylemi/processing-android-capture/tree/master/examples/AndroidCamera/CameraImage)  
效果1：  
![CameraImage](https://raw.githubusercontent.com/onlylemi/res/master/processing-android-capture-camera_image.gif)

---

代码2：[CameraColor](https://github.com/onlylemi/res/master/examples/AndroidCamera/CameraColor)  
效果2：  
![CameraColor](https://raw.githubusercontent.com/onlylemi/res/master/processing-android-capture-camera_color.gif)

---

代码3：[AccSensor](https://github.com/onlylemi/processing-android-capture/tree/master/examples/AndroidSensor/AccSensor)  
效果3：  
![AccSensor](https://raw.githubusercontent.com/onlylemi/res/master/processing-android-capture-sensor_color.gif)

--- 

代码4：[CameraMusic](https://github.com/onlylemi/processing-android-capture/tree/master/examples/AndroidCamera/CameraMusic)  
效果4：  
![CameraMusic](https://raw.githubusercontent.com/onlylemi/res/master/processing-android-capture-camera_music.gif)

---

代码5：[CameraPixel](https://github.com/onlylemi/processing-android-capture/tree/master/examples/AndroidCamera/CameraPixel)  
效果5：  
![CameraPixel](https://raw.githubusercontent.com/onlylemi/res/master/processing-android-capture-camera_pixel.gif)

## END

本篇文章中所有提到的代码都是该 **lib** 提供的[examples](https://github.com/onlylemi/processing-android-capture/tree/master/examples)，都可以在 **github** 上下载到，因为processing是由java语言实现的，所以整个项目我是采用 [IntelliJ IDEA](https://www.jetbrains.com/idea/) IDE所实现（强烈建议大家使用，写代码 so 爽），然后再转到 **processing** 下的。项目的android客户端使用 [Android studio](http://developer.android.com/sdk/index.html) 实现。所有代码都已开源到 **github** 上，欢迎大家指导批评。

Lib地址：[https://github.com/onlylemi/processing-android-capture](https://github.com/onlylemi/processing-android-capture)  
IDEA原项目地址：[https://github.com/onlylemi/P5AndroidCapture](https://github.com/onlylemi/P5AndroidCapture)  
Android APP地址：[https://github.com/onlylemi/AndroidCapture](https://github.com/onlylemi/AndroidCapture)

## CONTACT

**Weibo：** [@only乐秘](http://www.weibo.com/xiaomi0623)  
**GitHub：** [@onlylemi](https://github.com/onlylemi)
