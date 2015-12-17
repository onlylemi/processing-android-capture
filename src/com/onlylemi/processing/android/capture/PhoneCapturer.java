package com.onlylemi.processing.android.capture;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;

import processing.core.PImage;

/**
 * 手机摄像头捕获图像
 * 
 * @author only乐秘
 *
 */
public class PhoneCapturer implements Runnable {

	private ServerSocket ss = null;
	private BufferedImage image;
	private InputStream ins;
	private PImage pImage;
	private int color;

	private int width, height;
	private long imageFrameRate;

	private Thread thread;

	private long start, end;

	private boolean flag;

	/**
	 * 手机摄像头捕获图像构造函数
	 * 
	 * @param width
	 *            获取图像的宽
	 * @param height
	 *            获取图像的高
	 * @param imageFrameRate
	 *            刷新速率
	 */
	public PhoneCapturer(int width, int height, long imageFrameRate) {
		this.width = width;
		this.height = height;
		this.imageFrameRate = imageFrameRate;

		flag = true;
		start = System.currentTimeMillis();
		try {
			ss = new ServerSocket(6000);
		} catch (IOException e) {
			e.printStackTrace();
		}

		pImage = new PImage(width, height, PImage.RGB);

		thread = new Thread(this);
	}

	@Override
	public void run() {
		while (flag) {
			Socket s;
			try {
				s = ss.accept();
				if (s == null) {
					System.out.println("connect fail!!! ");
					flag = false;
				}
				// System.out.println("connect success. ");
				end = System.currentTimeMillis();
				ins = s.getInputStream();
				image = ImageIO.read(ins);

				start = end;
				if (end - start < imageFrameRate) {
					Thread.sleep(imageFrameRate - (end - start));
					start = end;
				}
				ins.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 得到手机摄像头的图像
	 * 
	 * @return
	 */
	public PImage getPImage() {
		if (image != null) {
			pImage = new PImage(image);
			pImage.resize(width, height);
		}
		return pImage;
	}

	/**
	 * 得到手机所识别的颜色
	 * 
	 * @return
	 */
	public int getColor() {
		color = image.getRGB(image.getWidth() / 2, image.getHeight() / 2);
		return color;
	}

	public void start() {
		thread.start();
	}

}
