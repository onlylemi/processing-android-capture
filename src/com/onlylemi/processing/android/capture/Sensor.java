package com.onlylemi.processing.android.capture;

/**
 * a interface about getting sensor data
 * <p>
 * https://github.com/onlylemi/processing-android-capture
 *
 * @author onlylemi
 */
public interface Sensor {

    /**
     * @return All values are in SI units (m/s^2)
     * <ul>
     * <li>values[0]: Acceleration minus Gx on the x-axis</li>
     * <li>values[1]: Acceleration minus Gy on the y-axis</li>
     * <li>values[2]: Acceleration minus Gz on the z-axis</li>
     * </ul>
     */
    float[] getAccelerometerSensorValues();

    /**
     * @return Ambient light level in SI lux units
     */
    float getLightSensorValues();

    /**
     * @return All values are angles in degrees.
     * <ul>
     * <li>values[0]: Azimuth, angle between the magnetic north direction and the y-axis, around the z-axis (0 to
     * 359). 0=North, 90=East, 180=South, 270=West</li>
     * <li>values[1]: Pitch, rotation around x-axis (-180 to 180), with positive values when the z-axis moves toward
     * the y-axis.</li>
     * <li>values[2]: Roll, rotation around the y-axis (-90 to 90) increasing as the device moves clockwise.</li>
     * </ul>
     */
    float[] getOrientationSensorValues();

    /**
     * @return Proximity sensor distance measured in centimeters
     */
    float getProximitySensorValues();

    /**
     * @return ambient (room) temperature in degree Celsius
     */
    float getTemperatureSensorValues();

    /**
     * @return Atmospheric pressure in hPa (millibar)
     */
    float getPressureSensorValues();

    /**
     * @return All values are in radians/second and measure the rate of rotation around the device's local X, Y and Z
     * axis. The coordinate system is the same as is used for the acceleration sensor. Rotation is positive in the
     * counter-clockwise direction. That is, an observer looking from some positive location on the x, y or z axis at
     * a device positioned on the origin would report positive rotation if the device appeared to be rotating counter
     * clockwise. Note that this is the standard mathematical definition of positive rotation and does not agree with
     * the definition of roll given earlier.
     * <ul>
     * <li>values[0]: Angular speed around the x-axis</li>
     * <li>values[1]: Angular speed around the y-axis</li>
     * <li>values[2]: Angular speed around the z-axis</li>
     * </ul>
     */
    float[] getGyroscopeSensorValues();

    /**
     * @return All values are in micro-Tesla (uT) and measure the ambient magnetic field in the X, Y and Z axis.
     */
    float[] getMagneticFieldSensorValues();

    /**
     * get sensor values
     *
     * @param sensor type
     * @return sensor name
     */
    float[] getSensorValues(String sensor);

}
