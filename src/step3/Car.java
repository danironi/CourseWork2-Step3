package step3;

public class Car {
    private String regNo;
    private String model;
    private String colour;

    public Car(String regNo, String model, String colour) {
        this.regNo = regNo;
        this.model = model;
        this.colour = colour;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public boolean getCarByRegNo(String regNo){
        return this.getRegNo().equals(regNo);
    }


    @Override
    public String toString(){
        return "Registration Number: "+ regNo + "\nModel: "+ model + "\nColour: " + colour + "\n";
    }
}

