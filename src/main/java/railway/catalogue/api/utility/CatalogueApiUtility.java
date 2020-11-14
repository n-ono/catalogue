package railway.catalogue.api.utility;

import io.vavr.API;
import railway.catalogue.domain.common.Destination;
import railway.catalogue.domain.common.SeatType;
import railway.catalogue.domain.common.TrainType;

import static io.vavr.API.$;

public class CatalogueApiUtility {
  public static Destination toDestination(String destinationString) {
    return API.Match(destinationString)
        .of(
            API.Case($("shinosaka"), Destination.SHINOSAKA),
            API.Case($("himeji"), Destination.HIMEJI));
  }

  public static TrainType toTrainType(String trainTypeString) {
    return API.Match(trainTypeString)
        .of(API.Case($("nozomi"), TrainType.NOZOMI), API.Case($("hikari"), TrainType.HIKARI));
  }

  public static SeatType toSeatType(String seatTypeString) {
    return API.Match(seatTypeString)
        .of(API.Case($("free"), SeatType.FREE), API.Case($("reserved"), SeatType.RESERVED));
  }
}
