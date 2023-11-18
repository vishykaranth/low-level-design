package elevator.service;


import elevator.model.SwitchDirection;

public interface IFloorSwitchService {
    void pressSwitch(SwitchDirection switchDirection);
}
