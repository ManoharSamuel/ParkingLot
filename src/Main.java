import controllers.TicketController;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import services.TicketService;
import strategies.parkingspotassignmentstrategy.ParkingSpotAssignmentStrategy;
import strategies.parkingspotassignmentstrategy.RandomParkingSpotAssignmentStrategy;

public class Main {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy = new RandomParkingSpotAssignmentStrategy();

        TicketService ticketService = new TicketService(gateRepository, parkingLotRepository, ticketRepository,
                                                        parkingSpotAssignmentStrategy, vehicleRepository);

        TicketController ticketController = new TicketController(ticketService);

        System.out.println("Application Started successfully");
    }
}