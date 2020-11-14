package railway.catalogue.infrastructure;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import railway.catalogue.domain.BusinessKilometerRepository;
import railway.catalogue.domain.common.BusinessKilometer;
import railway.catalogue.domain.common.Destination;
import railway.catalogue.infrastructure.utility.InfrastructureUtility;

import java.util.Objects;

@Repository
@AllArgsConstructor
public class BusinessKilometerRepositoryImpl implements BusinessKilometerRepository {
  @Autowired private final JdbcTemplate jdbcTemplate;

  @Override
  public BusinessKilometer findBy(Destination destination) {
    final int distance =
        Objects.requireNonNull(
            jdbcTemplate.queryForObject(
                "select distance from business_kilometer where destination = ?",
                new Object[] {InfrastructureUtility.toDestinationString(destination)},
                Integer.class));
    return BusinessKilometer.from(distance);
  }
}
