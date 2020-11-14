package railway.catalogue.domain;

import railway.catalogue.domain.common.Amount;
import railway.catalogue.domain.common.Destination;

public interface BasicFareRepository {
  Amount findBy(Destination destination);
}
