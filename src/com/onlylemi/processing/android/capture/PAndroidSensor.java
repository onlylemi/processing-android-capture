package com.onlylemi.processing.android.capture;

import processing.data.JSONArray;
import processing.data.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * processing android sensor
 *
 * @author onlylemi
 */
public class PAndroidSensor implements Runnable, PSensor {

    private byte[] byteBuffer = new byte[1024];
    private ServerSocket ss = null;
    private InputStream ins;
    private String data = "";

    private long start, end;
    private boolean flag;

    private long rate;

    private Thread thread;

    /**
     * new a PAndroidSensor obj
     *
     * @param rate the rate of getting data
     */
    public PAndroidSensor(long rate) {
        this.rate = rate;

        flag = true;
        start = System.currentTimeMillis();
        try {
            ss = new ServerSocket(6001);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                ins = s.getInputStream();

                StringBuffer sb = new StringBuffer();
                int amount;
                while ((amount = ins.read(byteBuffer)) != -1) {
                    sb.append(new String(byteBuffer, 0, amount));
                }
                data = sb.toString();

                //System.out.println(data);

                //start = end;
                end = System.currentTimeMillis();
                if (end - start < rate) {
                    Thread.sleep(rate - (end - start));
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
     * start getting sensors data
     */
    public void start() {
        thread.start();
    }

    /**
     * restart getting sensors data
     */
    public void restart() {
        thread.resume();
    }

    /**
     * pause getting sensors data
     */
    public void pause() {
        thread.suspend();
    }

    /**
     * the sensors data of android client
     *
     * @return
     */
    public String getData() {
        return data;
    }

    /**
     * parser json data
     *
     * @param data
     * @return
     */
    private float[] parserSensorJson(String data, String sensor) {
        float[] values = new float[3];

        if (!"".equals(data)) {
            JSONObject jo = JSONObject.parse(data);
            JSONArray ja = jo.getJSONArray(PSensorType.ANDROID_SENSOR);

            for (int i = 0; i < ja.size(); i++) {
                if (!ja.getJSONObject(i).isNull(sensor)) {
                    JSONObject jo1 = ja.getJSONObject(i).getJSONObject(sensor);

                    values[0] = jo1.getFloat("value0");
                    values[1] = jo1.getFloat("value1");
                    values[2] = jo1.getFloat("value2");
                }

            }
        }

        return values;
    }

    @Override
    public float[] getAccelerometerSensorValues() {
        return parserSensorJson(data, PSensorType.TYPE_ACCELEROMETER);
    }

    @Override
    public float getLightSensorValues() {
        return parserSensorJson(data, PSensorType.TYPE_LIGHT)[0];
    }

    @Override
    public float[] getOrientationSensorValues() {
        return parserSensorJson(data, PSensorType.TYPE_ORIENTATION);
    }

    @Override
    public float getProximitySensorValues() {
        return parserSensorJson(data, PSensorType.TYPE_PROXIMITY)[0];
    }

    @Override
    public float getTemperatureSensorValues() {
        return parserSensorJson(data, PSensorType.TYPE_TEMPERATURE)[0];
    }

    @Override
    public float getPressureSensorValues() {
        return parserSensorJson(data, PSensorType.TYPE_PRESSURE)[0];
    }

    @Override
    public float[] getGyroscopeSensorValues() {
        return parserSensorJson(data, PSensorType.TYPE_PRESSURE);
    }

    @Override
    public float[] getMagneticFieldSensorValues() {
        return parserSensorJson(data, PSensorType.TYPE_MAGNETIC_FIELD);
    }

    @Override
    public float[] getSensorValues(String sensor) {
        return parserSensorJson(data, sensor);
    }
}
