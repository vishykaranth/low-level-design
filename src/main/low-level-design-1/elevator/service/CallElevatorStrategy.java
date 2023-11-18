package elevator.service;


import elevator.model.Elevator;

public interface CallElevatorStrategy {
    public Elevator getElevator(Elevator[] elevators, Integer currentFloor, Integer direction);
}
