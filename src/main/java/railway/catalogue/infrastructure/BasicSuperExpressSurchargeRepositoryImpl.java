package railway.catalogue.infrastructure;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import railway.catalogue.domain.BasicSuperExpressSurchargeRepository;
import railway.catalogue.domain.common.Amount;
import railway.catalogue.domain.common.Destination;
import railway.catalogue.domain.common.SeatType;
import railway.catalogue.domain.common.TrainType;
import railway.catalogue.infrastructure.utility.InfrastructureUtility;

import java.util.Objects;

@Repository
@AllArgsConstructor
public class BasicSuperExpressSurchargeRepositoryImpl implements BasicSuperExpressSurchargeRepository {
  @Autowired private final JdbcTemplate jdbcTemplate;

  @Override
  public Amount findBy(TrainType trainType, SeatType seatType, Destination destination) {
    final int value =
        Objects.requireNonNull(
            jdbcTemplate.queryForObject(
                "select amount from basic_super_express_surcharge where train_type = ? and seat_type = ? and destination = ?",
                new Object[] {
                  InfrastructureUtility.toTrainTypeString(trainType),
                  InfrastructureUtility.toSeatTypeString(seatType),
                  InfrastructureUtility.toDestinationString(destination)
                },
                Integer.class));
    return Amount.from(value);
  }
}
