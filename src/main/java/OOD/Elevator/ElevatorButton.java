package OOD.Elevator;

public class ElevatorButton {
    private int level;
    private Elevator elevator;

    public ElevatorButton(int button, Elevator e) {
        this.level = level;
        this.elevator = e;
    }

    public void pressButton() {
        InternalRequest request = new InternalRequest(level);
        elevator.handleInternalRequest(request);
    }
}
