import java.util.ArrayList;
public class Train {

    private final Engine engine;
    private ArrayList<Car> cars;
    private int max_capacity;

    public Train(FuelType f, double max_fuel, int nCars, int max_capacity){
        this.cars = new ArrayList<Car>(nCars);
        for (int i = 0; i < nCars; i++){
            this.cars.add(new Car(max_capacity));
        }
        this.engine = new Engine(f, max_fuel);


    }
    public Engine getEngine(){
        return this.engine;
    }
    public Car getCar(int i){
        return this.cars.get(i-1);
    }
    public int getMaxCapacity(){
        int max_capacity = 0;
        for(Car c: cars) {
            max_capacity += c.getCapacity();
        }
        return max_capacity;
    }

    public int seatsRemaining(){
        int total_seats_rem = 0;
        for(Car c: cars){
            total_seats_rem += c.seatsRemaining();
        }
        return total_seats_rem;
    }
    public void printManifest(){
        for(Car c: cars){
            c.printManifest();
        }
    }
    public static void main(String[] args){
        Train my_train = new Train(FuelType.ELECTRIC, 100.0, 3, 4);
        Engine my_engine = my_train.getEngine();
        System.out.println("\nCurrent fuel is: " + my_engine.getcurrent_fuel());

        Passenger pass_1 = new Passenger("Kim");
        Passenger pass_2 = new Passenger("Ella");
        Passenger pass_3 = new Passenger("Julie");
        Passenger pass_4 = new Passenger("Taylor");
        

        pass_1.boardCar(my_train.getCar(1));
        pass_2.boardCar(my_train.getCar(1));
        pass_3.boardCar(my_train.getCar(2));
        pass_4.boardCar(my_train.getCar(1));

        Car car1 = my_train.getCar(1);
        Car car2 = my_train.getCar(2);
        Car car3 = my_train.getCar(3);

        System.out.println("\nSeats remaining in Car 1: " + car1.seatsRemaining());
        System.out.println("\nSeats remaining in Car 2: " + car2.seatsRemaining());
        System.out.println("\nSeats remaining in Car 3: " + car3.seatsRemaining());


        System.out.println("\nPassangers in Car 1:");
        car1.printManifest();

        System.out.println("\nPassangers in Car 2:");
        car2.printManifest();

        System.out.println("\nPassangers in Car 3:");
        car3.printManifest();

        System.out.println("\nTotal seats remaining are: " + my_train.seatsRemaining());

        my_engine.go();
        System.out.println("\nCurrent fuel is: " + my_engine.getcurrent_fuel());

        System.out.println("\n" + pass_1.getname() + " has left the train.");
        car1.removePassenger(pass_1);
        System.out.println("\nTotal seats remaining are: " + my_train.seatsRemaining());
        
        System.out.println("\nPassangers in Car 1");
        car1.printManifest();

        my_engine.go();
        System.out.println("\nCurrent fuel is: " + my_engine.getcurrent_fuel());

        my_engine.refuel();


    }
}


