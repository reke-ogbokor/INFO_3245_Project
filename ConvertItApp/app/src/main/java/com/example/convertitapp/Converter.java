package com.example.convertitapp;


import android.util.Log;

import com.digidemic.unitof.UnitOf;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Converter {
    private UnitOf.Volume unitOfVolume;
    private UnitOf.Area unitOfArea;
    private String unit;
    private Double input;
    private static DecimalFormat df2 = new DecimalFormat("#.######");


    public Converter() {

    }

    public void setUnit(String text) {
        this.unit = text;

    }

    public String getUnit() {
        return unit;
    }

    public Double getInput() {
        return input;
    }

    public void setInput(Double input) {
        this.input = input;
    }

    public ArrayList<String> convertVolume() {

        ArrayList<String> result = new ArrayList<>();

        switch (unit) {
            case "m3":
                unitOfVolume = new UnitOf.Volume().fromCubicMeters(input);
                break;
            case "km3":
                unitOfVolume = new UnitOf.Volume().fromCubicKilometers(input);
                break;
            case "cm3":
                unitOfVolume = new UnitOf.Volume().fromCubicCentimeters(input);
                break;
            case "mm3":
                unitOfVolume = new UnitOf.Volume().fromCubicMillimeters(input);
                break;
            case "l":
                unitOfVolume = new UnitOf.Volume().fromLiters(input);
                break;
            case "ml":
                unitOfVolume = new UnitOf.Volume().fromMilliliters(input);
                break;
            case "gal":
                unitOfVolume = new UnitOf.Volume().fromGallonsUS(input);
                break;
            case "qt":
                unitOfVolume = new UnitOf.Volume().fromQuartsUS(input);
                break;
            case "pt":
                unitOfVolume = new UnitOf.Volume().fromPintsUS(input);
                break;
            case "fl oz":
                unitOfVolume = new UnitOf.Volume().fromFluidOuncesUS(input);
                break;
            case "tbsp":
                unitOfVolume = new UnitOf.Volume().fromTablespoonsUS(input);
                break;
            case "tsp":
                unitOfVolume = new UnitOf.Volume().fromTeaspoonsUS(input);
                break;
        }

        result.add(df2.format(unitOfVolume.toCubicMeters()));
        result.add(df2.format(unitOfVolume.toCubicKilometers()));
        result.add(df2.format(unitOfVolume.toCubicCentimeters()));
        result.add(df2.format(unitOfVolume.toCubicMillimeters()));
        result.add(df2.format(unitOfVolume.toLiters()));
        result.add(df2.format(unitOfVolume.toMilliliters()));
        result.add(df2.format(unitOfVolume.toGallonsUS()));
        result.add(df2.format(unitOfVolume.toQuartsUS()));
        result.add(df2.format(unitOfVolume.toPintsUS()));
        result.add(df2.format(unitOfVolume.toFluidOuncesUS()));
        result.add(df2.format(unitOfVolume.toTablespoonsUS()));
        result.add(df2.format(unitOfVolume.toTeaspoonsUS()));


        return result;
    }
}
