package railway.catalogue.api;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import railway.catalogue.api.response.BasicSuperExpressSurchargeReferenceResponse;
import railway.catalogue.api.utility.CatalogueApiUtility;
import railway.catalogue.domain.BasicSuperExpressSurchargeRepository;
import railway.catalogue.domain.common.Amount;
import railway.catalogue.service.BasicSuperExpressSurchargeReferenceService;

@RestController
@AllArgsConstructor
public class BasicSuperExpressSurchargeReferenceApi {
  @Autowired private final BasicSuperExpressSurchargeReferenceService service;
  @Autowired private final BasicSuperExpressSurchargeRepository repository;

  @RequestMapping(value = "/basic-super-express-surcharge", method = RequestMethod.GET)
  public BasicSuperExpressSurchargeReferenceResponse refer(
      @RequestParam(name = "train-type") String trainType,
      @RequestParam(name = "seat-type") String seatType,
      @RequestParam(name = "destination") String destination) {
    Amount amount =
        service.refer(
            CatalogueApiUtility.toTrainType(trainType),
            CatalogueApiUtility.toSeatType(seatType),
            CatalogueApiUtility.toDestination(destination));
    return new BasicSuperExpressSurchargeReferenceResponse(amount.getValue());
  }
}
