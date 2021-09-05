package com.company;

import java.util.*;

public class Car {
    private int codeCar;
    private int number;
    private int distance;
    private int parameter;
    Car(String data) {
        String[] massive = data.split("-|_|C");
        codeCar = Integer.decode(massive[1]);
        number = Integer.decode(massive[2]);
        distance = Integer.decode(massive[3]);
        if (massive.length == 5)
            parameter = Integer.decode(massive[4]);
    }

    public int getDistance() {
        return distance;
    }

    public int getParameter() {
        return parameter;
    }

    @Override
    public String toString() {
        if (codeCar == 100)
            return "C" + codeCar +
                    "_" + number +
                    "-" + distance;
        else return "C" + codeCar +
                "_" + number +
                "-" + distance +
                "-" + parameter;
    }

    public static class CarDistanceComparator implements Comparator<Car> {
        @Override
        public int compare(Car o1, Car o2) {
            return o1.getDistance() - o2.getDistance();
        }
    }

    public static class CarParameterComparator implements Comparator<Car> {
        @Override
        public int compare(Car o1, Car o2) {
            return o1.getParameter() - o2.getParameter();
        }
    }

    public static void main(String[] args) {
        List<Car> cars = new LinkedList<Car>();
        List<Light> lightCars = new LinkedList<Light>();
        List<Hard> hardCars = new LinkedList<Hard>();
        List<Passenger> passengerCars = new LinkedList<Passenger>();
        List<Crane> cranes = new LinkedList<Crane>();

        String[] data = new String[]{"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50", "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20", "C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15"};
        for (String str : data
        ) {
            String[] massive = str.split("_");
            switch (massive[0]) {
                case "C100": {
                    Light car = new Light(str);
                    lightCars.add(car);
                    break;
                }
                case "C200": {
                    Hard car = new Hard(str);
                    hardCars.add(car);
                    break;
                }
                case "C300": {
                    Passenger car = new Passenger(str);
                    passengerCars.add(car);
                    break;
                }
                case "C400": {
                    Crane car = new Crane(str);
                    cranes.add(car);
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + massive[0]);
            }
        }
        double lightGSM = 0;
        double hardGSM = 0;
        double passengerGSM = 0;
        double craneGSM = 0;
        for (Light light : lightCars) {
            lightGSM += light.GSM();
        }
        for (Hard hard : hardCars) {
            hardGSM += hard.GSM();
        }
        for (Passenger passanger : passengerCars) {
            passengerGSM += passanger.GSM();
        }
        for (Crane crane : cranes) {
            craneGSM += crane.GSM();
        }
        System.out.println("Общая стоимость расходов на ГСМ : " + (lightGSM + hardGSM + passengerGSM + craneGSM));
        System.out.println("Стоимость расходов на ГСМ для легковых машин : " + lightGSM);
        System.out.println("Стоимость расходов на ГСМ для грузовых машин : " + hardGSM);
        System.out.println("Стоимость расходов на ГСМ для пассажирского транспорта : " + passengerGSM);
        System.out.println("Стоимость расходов на ГСМ для тяжелой техники : " + craneGSM);
        double max = Math.max(Math.max(lightGSM, hardGSM), Math.max(passengerGSM, craneGSM));
        if (max == lightGSM)
            System.out.println("Наибольшая стоимость расходов на легковые машины");
        else if (max == hardGSM)
            System.out.println("Наибольшая стоимость расходов на грузовые машины");
        else if (max == passengerGSM)
            System.out.println("Наибольшая стоимость расходов на пассажирский транспорт");
        else if (max == craneGSM)
            System.out.println("Наибольшая стоимость расходов на тяжелую технику");
        double min = Math.min(Math.min(lightGSM, hardGSM), Math.min(passengerGSM, craneGSM));
        if (min == lightGSM)
            System.out.println("Наименьшая стоимость расходов на легковые машины");
        else if (min == hardGSM)
            System.out.println("Наименьшая стоимость расходов на грузовые машины");
        else if (min == passengerGSM)
            System.out.println("Наименьшая стоимость расходов на пассажирский транспорт");
        else if (min == craneGSM)
            System.out.println("Наименьшая стоимость расходов на тяжелую технику");

        Comparator<Car> comparator = new CarDistanceComparator().thenComparing(new CarParameterComparator());
        Collections.sort(lightCars, comparator);
        Collections.sort(hardCars, comparator);
        Collections.sort(passengerCars, comparator);
        Collections.sort(cranes, comparator);
        System.out.println(lightCars);
        System.out.println(hardCars);
        System.out.println(passengerCars);
        System.out.println(cranes);
    }
}
