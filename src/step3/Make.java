package step3;

import java.util.ArrayList;

public class Make implements Comparable<Make>{

    private String makeName;
    private ArrayList<Car> cars = new ArrayList<Car>();
    private Make left;
    private Make right;


    public Make(String makeName, ArrayList<Car> cars) {
        this.makeName = makeName;
        this.cars = cars;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public Make(String makeName) {
        this.makeName = makeName;
    }

    public String getMakeName() {
        return makeName;
    }

    public void setMakeName(String makeName) {
        this.makeName = makeName;
    }

    public Make getLeft() {
        return left;
    }

    public void setLeft(Make left) {
        this.left = left;
    }

    public Make getRight() {
        return right;
    }

    public void setRight(Make right) {
        this.right = right;
    }

    @Override
    public String toString(){

        String make = "Make: " + makeName + "\n";

        return make;

    }

    public void insert(Make make) throws Exception {
        if(make.compareTo(this)==0) throw new Exception();
        if(make.compareTo(this)<0) {
            if (this.left == null) {
                this.left = make;
            } else {
                this.left.insert(make);
            }
        }
        else if(this.right == null){
            this.right = make;
        }
        else{
            this.right.insert(make);
        }
    }

    public Make find(Make make) throws SortedADT.NotFoundException {
        Make foundObject;
        if (make != null) {
            if (this.compareTo(make) == 0) {

                foundObject = this;
            } else{

                if (this.compareTo(make) > 0) {
                    foundObject = this.left.find(make);
                } else {
                    foundObject = this.right.find(make);
                }
            }
        } else{
            throw new SortedADT.NotFoundException();
        }
        return foundObject;
    }

    public Make findByMakeName(String makeName) {
        Make found =null;
        if (this.makeName.equals(makeName)) {
            return this;
        }
        else{

            if (this.left != null && this.makeName.compareTo(makeName) > 0) {
                found = this.left.findByMakeName(makeName);
            }
            if (found != null) {
                return found;
            }
            if (this.right != null && this.makeName.compareTo(makeName) < 0) {
                found = this.right.findByMakeName(makeName);
            }

        }

        return found;
    }

    public void addCar(Car car){

        cars.add(car);
    }

    public void displayCar(){

        for(Car car: cars){
            System.out.println(car);
        }
    }

    public Car getCar(){
        for(Car car: cars){
            return car;
        }
        return null;
    }

    public boolean getCarByRegNo(String regNo){
        for(Car car:cars){
            if(car.getCarByRegNo(regNo)){
                return true;
            }
        }
        return false;
    }

    public int getCarNumbers(String model){
        int num=0;
        for(Car car: cars){

            if(car.getModel().equalsIgnoreCase(model)){
                num++;

            }
        }
        return num;
    }


    public boolean removeCar(String regNo) throws SortedADT.NotFoundException {
        if(getCarRegNo(regNo)!=null){
            this.cars.remove(getCarRegNo(regNo));
            return true;
        }
        else{
            return false;
        }
    }

    public Car getCarRegNo(String regNo){
        int i = 0;
        while (cars.size() > i) {
            if (cars.get(i).getRegNo().equalsIgnoreCase(regNo)) {
                return cars.get(i);
            }
            i++;
        }
        return null;
    }

    public void getInOrder(){
        if(this.left !=null ) {
            this.left.getInOrder();

        }
        System.out.println(this.toString());
        this.displayCar();

        if(this.right!=null) {
            this.right.getInOrder();

        }
    }

    @Override
    public int compareTo(Make make) {
        return this.makeName.compareTo(make.getMakeName());
    }
}

