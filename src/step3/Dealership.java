package step3;

import static javax.swing.SwingUtilities.getRoot;

public class Dealership {
    private int dealershipId;
    private Make root;

    public Make getRoot() {
        return root;
    }

    public void setRoot(Make root) {
        this.root = root;
    }

    public void addMake(Make make) throws Exception {

        if(root==null){
            root=make;
        }
        else{
            root.insert(make);
        }
    }


    public boolean findByMakeName(String makeName) {
        return getByMakeName(makeName) != null;
    }

    public Make getByMakeName(String makeName){
        if(root != null){
            return root.findByMakeName(makeName);
        }
        else{
            return null;
        }
    }

    public boolean getCarByRegNo(String regNo){

        return root.getCarByRegNo(regNo);

    }

    public void displayAll(){

        if (root != null){
            root.getInOrder();
        }
        else{
            System.out.println("There are no cars within the dealership.");
        }

    }

}

