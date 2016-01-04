package com.onlylemi.processing.android.capture;

import processing.core.PImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * processing android camera
 *
 * @author onlylemi
 */
public class PAndroidCamera implements Runnable {

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
     * new a PAndroidCamera obj
     *
     * @param width          the width of image
     * @param height         the height of image
     * @param imageFrameRate the frame rate of getting image
     */
    public PAndroidCamera(int width, int height, long imageFrameRate) {
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
                //System.out.println("connect success. ");
                ins = s.getInputStream();
                image = ImageIO.read(ins);

                //start = end;
                end = System.currentTimeMillis();
                if (end - start < imageFrameRate) {
                    Thread.sleep(imageFrameRate - (end - start));
                    start = end;
                }
                ins.close();
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * get pimage from phone camera camera
     *
     * @return the frame of android camera
     */
    public PImage getPImage() {
        if (image != null) {
            pImage = new PImage(image);
            pImage.resize(width, height);
        }
        return pImage;
    }

    /**
     * get the the middle color of phone screen
     *
     * @return color
     */
    public int getColor() {
        if (image != null) {
            color = image.getRGB(image.getWidth() / 2, image.getHeight() / 2);
        }
        return color;
    }

    /**
     * start phone camera
     */
    public void start() {
        thread.start();
    }

    /**
     * restart phone camera
     */
    public void restart() {
        thread.resume();
    }

    /**
     * stop phone camera
     */
    public void pause() {
        thread.suspend();
    }

}
