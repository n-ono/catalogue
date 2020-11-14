package railway.catalogue.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import railway.catalogue.domain.BusinessKilometerRepository;
import railway.catalogue.domain.common.BusinessKilometer;
import railway.catalogue.domain.common.Destination;

@Service
@AllArgsConstructor
public class BusinessKilometerReferenceService {
  @Autowired private final BusinessKilometerRepository repository;

  public BusinessKilometer refer(Destination destination) {
    return repository.findBy(destination);
  }
}
