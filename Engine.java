public class Engine {
    private FuelType f;
    private double current_fuel;
    private double max_fuel;

    public Engine(FuelType f, double max_fuel){
        this.f = f;
        this.max_fuel = max_fuel;
        this.current_fuel = max_fuel;
    }

    public FuelType getf(){
        return this.f;
    }

    public double getcurrent_fuel(){
        return this.current_fuel;
        }

    public double getmax_fuel(double current_fuel){
        return max_fuel;
    }
        

    public void refuel(){
        if (current_fuel < max_fuel){
            this.current_fuel = max_fuel;
            System.out.print("\nAfter refueling the current fuel is: " + this.current_fuel);
        }
    }
    


    public void go(){
        if (this.current_fuel == 0.0){
            throw new RuntimeException("Out of fuel");
            // Engine.refuel();
        }
        else{
            this.current_fuel -= 25.0;
         } 
    }

    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0);
        try {
            while (true) {
                myEngine.go();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // Out of fuel
        }
        myEngine.refuel();
    }
}
