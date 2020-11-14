package railway.catalogue.domain;

import railway.catalogue.domain.common.BusinessKilometer;
import railway.catalogue.domain.common.Destination;

public interface BusinessKilometerRepository {
  BusinessKilometer findBy(Destination destination);
}
