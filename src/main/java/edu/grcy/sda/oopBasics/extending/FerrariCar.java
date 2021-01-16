package edu.grcy.sda.oopBasics.extending;

public class FerrariCar extends SportCar {
    private String modelName;

    public FerrariCar(int accelerationTo100, String modelName) {
        super(accelerationTo100);
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }

    @Override
    public String getColor() {
        return "Ferrari is always red";
    }

    public String getColor(String addon) {
        return "Ferrari is of color " + addon;
    }

    public String getOriginalColor() {
        return super.getColor();
    }


}
