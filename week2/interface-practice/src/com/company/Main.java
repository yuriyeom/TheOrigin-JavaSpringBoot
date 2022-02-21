package com.company;

public class Main {

    public static void main(String[] args) {
        Driver unlicensed = new Driver("unlicensed", 0 );
        Driver me = new Driver("me", 1);

        CarInterface car = new GoCart();
        car.setDriver(me);

        car = new SmallCar();
        car.setDriver(me);
//        car.setDriver(unlicensed);

//        CarDriver driver = new CarDriver("name", 1);
//        SimpleCar car = new SimpleCar();
//        car.setDriver(driver);
//
//        Road route88 = new Road();
//        route88.addCar(car);
    }
}
