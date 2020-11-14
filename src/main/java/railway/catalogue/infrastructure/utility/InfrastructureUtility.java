package railway.catalogue.infrastructure.utility;

import railway.catalogue.domain.common.Destination;
import railway.catalogue.domain.common.SeatType;
import railway.catalogue.domain.common.TrainType;

import static io.vavr.API.*;

public class InfrastructureUtility {
  public static String toDestinationString(Destination destination) {
    return Match(destination)
        .of(Case($(Destination.SHINOSAKA), "shinosaka"), Case($(Destination.HIMEJI), "himeji"));
  }

  public static String toTrainTypeString(TrainType trainType) {
    return Match(trainType)
        .of(Case($(TrainType.NOZOMI), "nozomi"), Case($(TrainType.HIKARI), "hikari"));
  }

  public static String toSeatTypeString(SeatType seatType) {
    return Match(seatType)
        .of(Case($(SeatType.FREE), "free"), Case($(SeatType.RESERVED), "reserved"));
  }
}
