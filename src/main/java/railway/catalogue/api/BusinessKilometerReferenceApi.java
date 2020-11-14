package railway.catalogue.api;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import railway.catalogue.api.response.BusinessKilometerReferenceResponse;
import railway.catalogue.api.utility.CatalogueApiUtility;
import railway.catalogue.domain.BusinessKilometerRepository;
import railway.catalogue.domain.common.BusinessKilometer;
import railway.catalogue.service.BusinessKilometerReferenceService;

@RestController
@AllArgsConstructor
public class BusinessKilometerReferenceApi {
  @Autowired private final BusinessKilometerReferenceService service;
  @Autowired private final BusinessKilometerRepository repository;

  @RequestMapping(value = "/business-kilometer", method = RequestMethod.GET)
  public BusinessKilometerReferenceResponse refer(
      @RequestParam(name = "destination") String destination) {
    BusinessKilometer businessKilometer =
        service.refer(CatalogueApiUtility.toDestination(destination));
    return new BusinessKilometerReferenceResponse(businessKilometer.getValue());
  }
}
