package com.example.geektrust;

import java.io.IOException;

public class MetroStationApp {
    public static void main(String[] args) throws IOException {

        MetroStationService metroStationService = new MetroStationService();
        metroStationService.start("input/metrocard.txt");
    }
}
