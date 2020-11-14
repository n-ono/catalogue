package railway.catalogue.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import railway.catalogue.domain.BasicSuperExpressSurchargeRepository;
import railway.catalogue.domain.common.Amount;
import railway.catalogue.domain.common.Destination;
import railway.catalogue.domain.common.SeatType;
import railway.catalogue.domain.common.TrainType;

@Service
@AllArgsConstructor
public class BasicSuperExpressSurchargeReferenceService {
  @Autowired private final BasicSuperExpressSurchargeRepository repository;

  public Amount refer(TrainType trainType, SeatType seatType, Destination destination) {
    return repository.findBy(trainType, seatType, destination);
  }
}
