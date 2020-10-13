package com.example.weatherapp.app;

public class WindConvert {
    public static String convertWindDirection(String direction) {
        String detail = "";
        switch (direction) {
            case "N":
                detail = "North";
                break;

            case "NE":
                detail = "North East";
                break;

            case "E":
                detail = "East";
                break;

            case "SE":
                detail = "South East";
                break;

            case "S":
                detail = "South";
                break;

            case "SW":
                detail = "South West";
                break;

            case "W":
                detail = "West";
                break;

            case "NW":
                detail = "North West";
                break;


        }
        return detail;
    }

    public static int rotateImage(String direction) {
        int rotate = 0;
        switch (direction) {
            case "N":
                rotate = 315;
                break;

            case "NE":
                rotate = 0;
                break;

            case "E":
                rotate = 45;
                break;

            case "SE":
                rotate = 90;
                break;

            case "S":
                rotate = 135;
                break;

            case "SW":
                rotate = 180;
                break;

            case "W":
                rotate = 225;
                break;

            case "NW":
                rotate = 270;
                break;


        }
        return rotate;
    }


}
