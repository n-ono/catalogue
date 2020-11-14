package railway.catalogue.domain;

import railway.catalogue.domain.common.Amount;
import railway.catalogue.domain.common.Destination;
import railway.catalogue.domain.common.SeatType;
import railway.catalogue.domain.common.TrainType;

public interface BasicSuperExpressSurchargeRepository {
  Amount findBy(TrainType trainType, SeatType seatType, Destination destination);
}
