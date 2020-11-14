package railway.catalogue.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import railway.catalogue.domain.BasicFareRepository;
import railway.catalogue.domain.common.Amount;
import railway.catalogue.domain.common.Destination;

@Service
@AllArgsConstructor
public class BasicFareReferenceService {
  @Autowired private final BasicFareRepository repository;

  public Amount refer(Destination destination) {
    return repository.findBy(destination);
  }
}
