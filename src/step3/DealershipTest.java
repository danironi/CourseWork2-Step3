package step3;

import java.util.HashSet;
import java.util.Set;

public class DealershipTest {
    static Dealership dealership = new Dealership();

    public static void main(String[] args){

        do{

            try{

                String menu = "Enter one of the following options: \n"+
                        "1 - Add a make \n"+
                        "2 - Add a new car \n" +
                        "3 - Remove a specific car \n" +
                        "4 - Display car details for a specific make \n" +
                        "5 - Display all make and car details for the dealership \n" +
                        "6 - Display the number of cars available for a specific make and model of car \n" +
                        "7 - Quit \n" +
                        ">>";

                int option = Input.getInteger(menu);

                switch(option){

                    case 1:

                        String makeName = Input.getString("Enter Make name: ");
                        Make make = new Make(makeName);
                        try{
                            dealership.addMake(make);
                            System.out.println(makeName + " has been added.");
                        }
                        catch(Exception e){
                            System.out.println("Make already exist");
                        };
                        break;

                    case 2:
                        makeName = Input.getString("Enter Make name: ");

                        if(dealership.findByMakeName(makeName)){
                            Make make1 = dealership.getByMakeName(makeName);

                            String regNo = Input.getRegNo("Enter registration number: ");
                            if(!dealership.getCarByRegNo(regNo)){

                                String model = Input.getString("Enter model: ");
                                String colour = Input.getString("Enter colour: ");

                                Car car = new Car(regNo, model, colour);

                                make1.addCar(car);

                                System.out.println("Car has been added.");
                            }
                            else{
                                System.out.println("This registration number is already exist, enter a new one please. ");

                            }

                        }
                        else{
                            System.out.println("There is no such make within the dealership.");
                        }
                        break;

                    case 3:
                        makeName = Input.getString("Enter Make name: ");

                            if(dealership.findByMakeName(makeName)){
                                Make make1 = dealership.getByMakeName(makeName);
                                String regNo = Input.getRegNo("Enter car's registration number: ");

                                if(make1.getCarRegNo(regNo)!=null) {
                                    make1.removeCar(regNo);
                                    System.out.println("The car has been removed");
                                }
                                else {
                                    System.out.println("There is no such car with this registration number.");
                                }
                            }
                            else{
                                System.out.println("There is no such make within the dealership.");
                            }

                        break;

                    case 4:
                        makeName = Input.getString("Enter Make name: ");

                        if(dealership.findByMakeName(makeName)){
                            Make make1 = dealership.getByMakeName(makeName);
                            if(make1.getCar()!=null){
                                make1.displayCar();
                            }
                            else{
                                System.out.println("There is no "+makeName+" car within the dealership. ");
                            }
                        }
                        else{

                            System.out.println("There is no such make within the dealership.");

                        }
                        break;

                    case 5:
                        dealership.displayAll();
                        break;

                    case 6:
                        makeName = Input.getString("Enter Make name: ");

                        if(dealership.findByMakeName(makeName)){
                            Make make1 = dealership.getByMakeName(makeName);
                            String model = Input.getString("Enter car's model name: ");

                            if(make1.getCar()!=null){
                                System.out.println(" ");
                                System.out.println("Number of "+makeName.toUpperCase()+" "+model.toUpperCase()+" within the dealership: "+make1.getCarNumbers(model)+"\n");
                            }
                            else {
                                System.out.println("There is no such car with this model name.");
                            }
                        }
                        else{
                            System.out.println("There is no such make within the dealership.");
                        }

                        break;

                    case 7:
                        Set<String> answers = new HashSet<String>();
                        answers.add("y");
                        answers.add("Y");

                        String answer= Input.getString("Quit? (y/n)");
                        if (answers.contains(answer)){
                            System.exit(0);
                        }

                    default:
                        System.out.println("If you wish to continue, then enter the right menu option. ");
                }
            }
            catch(Exception e){
                System.out.println("If you wish to continue, then enter the right menu option. ");
            }
        }
        while(Repeat.repeat());
    }
}

