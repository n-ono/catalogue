package railway.catalogue.infrastructure;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import railway.catalogue.domain.BasicFareRepository;
import railway.catalogue.domain.common.Amount;
import railway.catalogue.domain.common.Destination;
import railway.catalogue.infrastructure.utility.InfrastructureUtility;

import java.util.Objects;

@Repository
@AllArgsConstructor
public class BasicFareRepositoryImpl implements BasicFareRepository {
  @Autowired private final JdbcTemplate jdbcTemplate;

  @Override
  public Amount findBy(Destination destination) {
    final int value =
        Objects.requireNonNull(
            jdbcTemplate.queryForObject(
                "select amount from basic_fare where destination = ?",
                new Object[] {InfrastructureUtility.toDestinationString(destination)},
                Integer.class));
    return Amount.from(value);
  }
}
