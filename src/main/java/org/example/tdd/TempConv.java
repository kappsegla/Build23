package org.example.tdd;

public class TempConv {

    public static float convert(String s) {
        boolean isFahrenheit = s.endsWith("F");
        String text;
        if (s.contains("Temp:")) {
            text = s.substring(s.indexOf("Temp:") + 6, s.length() - 2);
        } else {
            text = s.substring(s.indexOf(',') + 1);
        }
        float degrees = Float.parseFloat(text);
        if (isFahrenheit) {

            degrees = fahrenheitToCelsius(degrees);
        }
        return degrees;
    }

    private static float fahrenheitToCelsius(float f) {
        return (f - 32) * 5 / 9;
    }
}
