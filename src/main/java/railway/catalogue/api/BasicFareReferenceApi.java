package railway.catalogue.api;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import railway.catalogue.api.response.BasicFareReferenceResponse;
import railway.catalogue.api.utility.CatalogueApiUtility;
import railway.catalogue.domain.BasicFareRepository;
import railway.catalogue.domain.common.Amount;
import railway.catalogue.service.BasicFareReferenceService;

@RestController
@AllArgsConstructor
public class BasicFareReferenceApi {
  @Autowired private final BasicFareReferenceService service;
  @Autowired private final BasicFareRepository repository;

  @RequestMapping(value = "/basic-fare", method = RequestMethod.GET)
  public BasicFareReferenceResponse refer(@RequestParam(name = "destination") String destination) {
    Amount amount = service.refer(CatalogueApiUtility.toDestination(destination));
    return new BasicFareReferenceResponse(amount.getValue());
  }
}
