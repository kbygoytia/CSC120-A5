import java.util.ArrayList;

public class Car {

    private ArrayList<Passenger> passengers;
    private int max_capacity = 4;

    public Car(int max_capacity){
        this.max_capacity = max_capacity;
        this.passengers = new ArrayList<Passenger>(this.max_capacity);
    }
    public ArrayList<Passenger> getpassengers(){
        return this.passengers;
    }
    public int getCapacity(){
        return this.max_capacity;
    }

    public int seatsRemaining(){
        int pass_in_car =  passengers.size();
        int seats_remaining = (this.max_capacity - pass_in_car);
        return seats_remaining;
    } 
    public void addPassenger(Passenger p){
        if(seatsRemaining() !=0){
            this.passengers.add(p);
        }
        else{
            throw new RuntimeException("Cannot add " + p.getname() + ". Car is full.");
        }
    }

    public void removePassenger(Passenger p){
        if(this.passengers.contains(p)){
            this.passengers.remove(p);
        }
        else {
            throw new RuntimeException(p.getname() + " is not in the car.");
        }
    }

    public void printManifest(){
        if(this.passengers.isEmpty()==false){
            for (Passenger p : this.passengers){
                System.out.println(p.getname());
            }
        }
        else{
            System.out.println("This car is empty.");
        }
    }
}